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
	
	/**Procédure qui permet la connexion à la bdd
	 * 
	 */
	public static void connexionBDD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsb2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
			st = connexion.createStatement();
		} 
		catch (ClassNotFoundException erreur ) {
			erreur.printStackTrace();
		} 
		catch (SQLException erreur) {
			erreur.printStackTrace();
		}
	}
	
	/**Procédure qui déconnecte de la bdd
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
	
	/**Vérifie si l'utilisateur en paramètres existe dans la bdd et renvoie vrai si il existe
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
	
	/**Retourne une chaîne correspondant au rôle de l'utilisateur passé en paramètres
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
	
	/**Recuper tous les matériels de la bdd et les retourne dans une collection de Materiel
	 * @return lesMateriel
	 */
	public static ArrayList<Materiel> getLesMateriels(){
		ArrayList<Materiel> lesMat = new ArrayList<Materiel>();
		try {
			Modele.connexionBDD();
			st = connexion.createStatement();
			String sql = "SELECT objet.idObjet, objet.nom, objet.nbReservation, materiel.largeur, materiel.longueur, materiel.typeMat FROM objet, materiel WHERE objet.idObjet = materiel.idMat;";
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
}
