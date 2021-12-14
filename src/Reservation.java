import java.sql.Timestamp;

public class Reservation {
	//Attributs privés
	private int idReservation;
	private Objet unObjet;
	private int idUtilisateur;
	private int duree;
	private Timestamp dateHeureDebut;
	private Timestamp dateHeureFin;
	
	public Reservation() {
		
	}
	
	public Reservation(int unIdReservation, Objet leObjet, int unIdUtilisateur, int uneDuree, Timestamp uneDateHeureDebut, Timestamp dateHeureFin) {
		this.idReservation = unIdReservation;
		this.unObjet = leObjet;
		this.idUtilisateur = unIdUtilisateur;
		this.duree = uneDuree;
		this.dateHeureDebut = uneDateHeureDebut;
		this.dateHeureFin = dateHeureFin;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public Objet getUnObjet() {
		return unObjet;
	}

	public void setUnObjet(Objet unObjet) {
		this.unObjet = unObjet;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Timestamp getDateHeureDebut() {
		return dateHeureDebut;
	}

	public void setDateHeureDebut(Timestamp dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public Timestamp getDateHeureFin() {
		return dateHeureFin;
	}

	public void setDateHeureFin(Timestamp dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}
	
	
}
