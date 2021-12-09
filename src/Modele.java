import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modele {

	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static int nb; 
	private static PreparedStatement pst;
	
	/**Proc�dure qui permet la connexion � la bdd
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
	
	/**Proc�dure qui d�connecte de la bdd
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
	
	/**V�rifie si l'utilisateur en param�tres existe dans la bdd et renvoie vrai si il existe
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
	
	/**Retourne une cha�ne correspondant au r�le de l'utilisateur pass� en param�tres
	 * @param String unLogin
	 * @param String unMdp
	 * @return String unRole
	 */
	public static String verifRole(String unLogin, String unMdp) {
		String unRole = "";
		try {
			Modele.connexionBDD();
			String sql = "SELECT role FROM Utilisateur WHERE login = ? AND mdp = sha1(?);";
			pst = connexion.prepareStatement(sql);
			pst.setString(1, unLogin);
			pst.setString(2, unMdp);
			rs = pst.executeQuery();
			while(rs.next()) {
				unRole = rs.getString(1);
			}
		}catch(SQLException e) {
			System.out.println("Erreur dans la fonction verifRole");
			e.printStackTrace();
		}
		return unRole;
	}
	
	/**Recuper tous les mat�riels de la bdd et les retourne dans une collection de Materiel
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
	 * M�thode d'insertion de mat�riel dans la bdd
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
	 * M�thode d'insertion de v�hicule dans la bdd
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
}
