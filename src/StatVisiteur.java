public class StatVisiteur {
	//Attributs privés
	private int idVisiteur;
	private String nom;
	private String prenom;
	private int nbReserv;
	private String typeMat;
	
	//Constructeurs
	public StatVisiteur() {
		
	}
	
	public StatVisiteur(int unIdVisiteur, String unNom, String unPrenom, int nbReserv, String typeMat) {
		this.idVisiteur = unIdVisiteur;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.nbReserv = nbReserv;
		this.typeMat = typeMat;
	}
	
	//Accesseurs
	public int getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNbReserv() {
		return nbReserv;
	}

	public void setNbReserv(int nbReserv) {
		this.nbReserv = nbReserv;
	}

	public String getTypeMat() {
		return typeMat;
	}

	public void setTypeMat(String typeMat) {
		this.typeMat = typeMat;
	}
	
	
}
