public abstract class Objet {
	//Attributs privés
	private int idObjet;
	private String nomObjet;
	private int nbReservations;
	
	/**
	 * Constructeur
	 * @param unIdObjet
	 * @param unNomObjet
	 * @param unNbReservation
	 */
	public Objet(int unIdObjet, String unNomObjet, int unNbReservation) {
		this.idObjet = unIdObjet;
		this.nomObjet = unNomObjet;
		this.nbReservations = unNbReservation;
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

	@Override
	public abstract String toString();

}