public class Reservation {
	//Attributs privés
	private int idReservation;
	private Objet unObjet;
	private int idUtilisateur;
	private int duree;
	private java.sql.Time dateHeureDebut;
	private java.sql.Time dateHeureFin;
	
	public Reservation() {
		
	}
	
	public Reservation(int unIdReservation, Objet leObjet, int unIdUtilisateur, int uneDuree, java.sql.Time uneDateHeureDebut, java.sql.Time dateHeureFin) {
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

	public java.sql.Time getDateHeureDebut() {
		return dateHeureDebut;
	}

	public void setDateHeureDebut(java.sql.Time dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public java.sql.Time getDateHeureFin() {
		return dateHeureFin;
	}

	public void setDateHeureFin(java.sql.Time dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}
	
	
}
