public abstract class Objet {
	//Attributs privés
	private int idObjet;
	private String nomObjet;
	private int nbReservations;
	private Catalogue sonCatalogue;
	
	//Constructeur
	public Objet() {
		
	}
	
	public Objet(int unIdObjet, String unNomObjet, int unNbReservation, Catalogue unCatalogue) {
		this.idObjet = unIdObjet;
		this.nomObjet = unNomObjet;
		this.nbReservations = unNbReservation;
		this.sonCatalogue = unCatalogue;
		this.sonCatalogue.ajouterObjet(this);
	}
	
	public Objet(int unIdObjet, String unNomObjet, int unNbReservation) {
		this.idObjet = unIdObjet;
		this.nomObjet = unNomObjet;
		this.nbReservations = unNbReservation;
		this.sonCatalogue.ajouterObjet(this);
	}
	
	public Objet(Objet unObjet, Catalogue unCatalogue) {
		this.idObjet = unObjet.getIdObjet();
		this.nomObjet = unObjet.getNomObjet();
		this.nbReservations = unObjet.getNbReservations();
		this.sonCatalogue = unCatalogue;
		this.sonCatalogue.ajouterObjet(this);
	}
	
	//Accesseurs
	public int getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}

	public String getNomObjet() {
		return nomObjet;
	}

	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
	}

	public int getNbReservations() {
		return nbReservations;
	}

	public void setNbReservations(int nbReservations) {
		this.nbReservations = nbReservations;
	}
	
	public Catalogue getSonCatalogue() {
		return sonCatalogue;
	}

	public void setSonCatalogue(Catalogue sonCatalogue) {
		this.sonCatalogue = sonCatalogue;
	}

	@Override
	public abstract String toString();

}