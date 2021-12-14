import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
public class Modele {

	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static int nb; 
	private static PreparedStatement pst;
	
	/**
	 * Procédure qui permet la connexion à la bdd
	 * 
	 */
	public static void connexionBDD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.218/gsb2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");

			st = connexion.createStatement();
		} 
		catch (ClassNotFoundException erreur ) {
			erreur.printStackTrace();
		} 
		catch (SQLException erreur) {
			erreur.printStackTrace();
		}
	}
	
	/**
	 * Procédure qui déconnecte de la bdd
	 * 
	 */
	public static void deconnexion() {
		try {
			connexion.close();
		} 
		catch (SQLException erreur) {
			erreur.printStackTrace();
		}
	}
	
	/**
	 * Vérifie si l'utilisateur en paramètres existe dans la bdd et renvoie vrai si il existe
	 * @param String unLogin
	 * @param String unMdp
	 * @return boolean rep
	 */
	public static boolean connexion(String unLogin, String unMdp) {
		Modele.connexionBDD();
		boolean rep;
		rep = false;
		nb = 0;
		try {
			pst = connexion.prepareStatement( "SELECT COUNT(*) AS nbLogin FROM Utilisateur WHERE login = ? AND mdp = sha1(?) ;");
			pst.setString(1, unLogin);
			pst.setString(2, unMdp);
			rs = pst.executeQuery();
			while(rs.next()) {
				nb = rs.getInt("nbLogin");
			}
			rs.close();
			if (nb == 1) {
				rep = true;
			}
		} 
		catch (SQLException erreur) {
			erreur.printStackTrace();
		}
		return rep;
	}
	
	/**
	 * Retourne une chaîne correspondant au rôle de l'utilisateur passé en paramètres
	 * @param String unLogin
	 * @param String unMdp
	 * @return String unRole
	 */
	public static Hashtable<String, String> verifRole(String unLogin, String unMdp) {
		String unRole = "";
		int unId;
		Hashtable<String, String> ht = new Hashtable<String, String>();
		try {
			Modele.connexionBDD();
			String sql = "SELECT id, role FROM Utilisateur WHERE login = ? AND mdp = sha1(?);";
			pst = connexion.prepareStatement(sql);
			pst.setString(1, unLogin);
			pst.setString(2, unMdp);
			rs = pst.executeQuery();
			while(rs.next()) {
				unId = rs.getInt(1);
				unRole = rs.getString(2);
				ht.put("id", Integer.toString(unId));
				ht.put("role", unRole);
			}
		}catch(SQLException e) {
			System.out.println("Erreur dans la fonction verifRole");
			e.printStackTrace();
		}
		return ht;
	}
	
	/**
	 * Recuper tous les matériels de la bdd et les retourne dans une collection de Materiel
	 * @return lesMateriel
	 */
	public static ArrayList<Materiel> getLesMateriels(){
		ArrayList<Materiel> lesMat = new ArrayList<Materiel>();
		try {
			Modele.connexionBDD();
			st = connexion.createStatement();
			String sql = "SELECT Objet.idObjet, Objet.nom, Objet.nbReservation, Materiel.largeur, Materiel.longueur, Materiel.typeMat FROM Objet, Materiel WHERE Objet.idObjet = Materiel.idMat;";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				int nbReserv = rs.getInt(3);
				double largeur = rs.getDouble(4);
				double longueur = rs.getDouble(5);
				String type = rs.getString(6);
				Materiel unMateriel = new Materiel(id,nom,nbReserv,largeur,longueur,type);
				lesMat.add(unMateriel);
			}
		}catch(SQLException e) {
			System.out.println("Erreur dans la fonction getLesObjets");
			e.printStackTrace();
		}
		return lesMat;
	}
	
	/**
	 * Recuper tous les véhicules de la bdd et les retourne dans une collection de Vehicule
	 * @return lesMateriel
	 */
	public static ArrayList<Vehicule> getLesVehicules(){
		ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
		try {
			Modele.connexionBDD();
			st = connexion.createStatement();
			String sql = "SELECT * FROM Objet, Vehicule, TypeVehicule WHERE Objet.idObjet = Vehicule.idVehicule GROUP BY idObjet;";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				int nbReserv = rs.getInt(3);
				int idTypeV = rs.getInt(5);
				String immat = rs.getString(6);
				String modele = rs.getString(7);
				String marque = rs.getString(8);
				int nbPlaces = rs.getInt(9);
				String libelle = rs.getString(11);
				Type_Vehicule unType = new Type_Vehicule(idTypeV,libelle);
				Vehicule unVehicule = new Vehicule(id,nom,nbReserv,unType,immat,modele,marque,nbPlaces);
				lesVehicules.add(unVehicule);
			}
		}catch(SQLException e) {
			System.out.println("Erreur dans la fonction getLesObjets");
			e.printStackTrace();
		}
		return lesVehicules;
	}
	
	/**
	 * Méthode d'insertion de matériel dans la bdd
	 * @param unIdObjet
	 * @param unNomObjet
	 * @param uneLargeur
	 * @param uneLongueur
	 * @param unType
	 * @return
	 */
	public static boolean ajouterMat(int unIdObjet, String unNomObjet, double uneLargeur, double uneLongueur, String unType) {
		boolean rep = false;
		try {
			Modele.connexionBDD();
			String requete1 = "INSERT INTO Objet(idObjet,nom,nbReservation) VALUES(?,?,0);";
			pst = connexion.prepareStatement(requete1);
			pst.setInt(1, unIdObjet);
			pst.setString(2, unNomObjet);
			int ins = pst.executeUpdate();
			String requete2 = "INSERT INTO Materiel VALUES(?,?,?,?);";
			pst = connexion.prepareStatement(requete2);
			pst.setInt(1, unIdObjet);
			pst.setDouble(2, uneLargeur);
			pst.setDouble(3, uneLongueur);
			pst.setString(4, unType);
			int ins2 = pst.executeUpdate();
			if (ins == 1 & ins2 == 1) {
				rep = true;
			}
		}catch(SQLException e) {
			System.out.println("Erreur dans la requ�te ajouterMat");
			e.printStackTrace();
		}
		return rep;
	}
	
	/**
	 * Méthode d'insertion de véhicule dans la bdd
	 * @param unIdObjet
	 * @param unNomObjet
	 * @param unNbReservation
	 * @param unIdTypeV
	 * @param unImmat
	 * @param unModele
	 * @param uneMarque
	 * @param unNbPlace
	 * @return
	 */
	public static boolean ajouterVehicule(int unIdObjet, String unNomObjet, int unNbReservation, int unIdTypeV , String unImmat, String unModele, String uneMarque, int unNbPlace) {
	boolean rep = false;
		try {
			Modele.connexionBDD();
			String requete1 = "INSERT INTO Objet(idObjet,nom) VALUES(?,?);";
			pst = connexion.prepareStatement(requete1);
			pst.setInt(1, unIdObjet);
			pst.setString(2, unNomObjet);
			int ins = pst.executeUpdate();
			String requete2 = "INSERT INTO Vehicule VALUES(?,?,?,?,?,?)";
			pst = connexion.prepareStatement(requete2);
			pst.setInt(1, unIdObjet);
			pst.setInt(2, unIdTypeV);
			pst.setString(3, unImmat);
			pst.setString(4, unModele);
			pst.setString(5, uneMarque);
			pst.setInt(6, unNbPlace);
			int ins2 = pst.executeUpdate();
			if(ins == 1 & ins == 1) {
				rep = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rep;
	}
	
	/**
	 * Méthode r�cup�rant l'id d'un objet de type Materiel
	 * @param id
	 * @return
	 */
	public static Materiel getMaterielById(int id) {
		Materiel unMateriel = null;
		try {
			Modele.connexionBDD();
			String sql = "SELECT Objet.idObjet, Objet.nom, Objet.nbReservation, Materiel.largeur, Materiel.longueur, Materiel.typeMat FROM Objet, Materiel WHERE Objet.idObjet = ? AND Objet.idObjet = Materiel.idMat;";
			pst = connexion.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				int unId = rs.getInt(1);
				String nom = rs.getString(2);
				int nbReserv = rs.getInt(3);
				double largeur = rs.getDouble(4);
				double longueur = rs.getDouble(5);
				String type = rs.getString(6);
				unMateriel = new Materiel(unId,nom,nbReserv,largeur,longueur,type);
			}
		}catch(SQLException e) {
			System.out.println("Erreur dans la fonction getLesObjets");
			e.printStackTrace();
		}
		return unMateriel;
	}
	/**
	 * Recuperer un vehicule a partir de son id
	 * @param id
	 * @return
	 */
	public static Vehicule getVehiculeById(int id) {
		Vehicule unVehicule = null;
		try {
			Modele.connexionBDD();
			String sql = "SELECT * FROM Objet, Vehicule, TypeVehicule WHERE Objet.idObjet = Vehicule.idVehicule AND Objet.idObjet = ?;";
			pst = connexion.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				int unId = rs.getInt(1);
				String nom = rs.getString(2);
				int nbReserv = rs.getInt(3);
				int idTypeV = rs.getInt(5);
				String immat = rs.getString(6);
				String modele = rs.getString(7);
				String marque = rs.getString(8);
				int nbPlaces = rs.getInt(9);
				String libelle = rs.getString(11);
				Type_Vehicule unType = new Type_Vehicule(idTypeV,libelle);
				unVehicule = new Vehicule(unId,nom,nbReserv,unType,immat,modele,marque,nbPlaces);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur dans la fonction getVehiculeById");
		}
		return unVehicule;
	}
	
	/**
	 * Méthode récupérant uniquement l'id d'un objet
	 * @param uneChaine
	 * @return
	 */
	public static int recupInt(String uneChaine) {
		String val = uneChaine.replaceAll("\\D+","");
		int leInt = Integer.parseInt(val);
		return leInt;
	}

	/**Ajouter un materiel
	 * @param idObjet
	 * @param idUser
	 * @param dateDebut
	 * @param dateFin
	 * @return
	 */
	public static boolean ajouterReservation(int idObjet, int idUser, String dateDebut, String dateFin) {
		boolean rep = false;
		try {
			Modele.connexionBDD();
			String sql = "INSERT INTO Reservation(idObjet, idUtilisateur, dateHeureDebut, dateHeureFin) VALUES (?,?,?,?);";
			pst = connexion.prepareStatement(sql);
			pst.setInt(1, idObjet);
			pst.setInt(2, idUser);
			pst.setString(3, dateDebut);
			pst.setString(4, dateFin);
			int ins = pst.executeUpdate();
			if(ins == 1) {
				rep = true;
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println("Erreur dans la fonction ajouterReservation");
			e.printStackTrace();
		}
		return rep;
	}
	
	/**
	 * Methode de suppression d'objet de la bdd
	 * @param unId
	 * @return
	 */
	public static boolean supprimerMat (int unId) {
		Modele.connexionBDD();
		String requete;
		String req;
		int ins;
		int ins2;
		boolean rep = false;
		try {
			requete = "DELETE FROM Objet WHERE idObjet = ?";
			ins = st.executeUpdate(requete);
			req = "DELETE FROM Materiel WHERE idMat = ?";
			ins2 = st.executeUpdate(req);
			if (ins == 1 && ins2 == 1) {
				rep = true;
			}
		} 
		catch (SQLException erreur) {
			erreur.printStackTrace();
		}
		return rep;
	}
	
}
