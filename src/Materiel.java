public class Materiel extends Objet{
	//Attributs privés
	private double largeur;
	private double longueur;
	private String type;
	
	/**
	 * Constructeur de la classe
	 * @param unIdObjet
	 * @param unNomObjet
	 * @param unNbReservation
	 * @param uneLargeur
	 * @param uneLongueur
	 * @param unType
	 */
	public Materiel(int unIdObjet, String unNomObjet, int unNbReservation, double uneLargeur, double uneLongueur, String unType) {
		super(unIdObjet,unNomObjet,unNbReservation);
		this.largeur = uneLargeur;
		this.longueur = uneLongueur;
	}

	//Accesseurs
	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double uneLargeur) {
		this.largeur = uneLargeur;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double uneLongueur) {
		this.longueur = uneLongueur;
	}

	public String getType() {
		return type;
	}

	public void setType(String unType) {
		this.type = unType;
	}
	
	/**
	 * Méthode retorunant toutes les informations d'un objet matériel
	 */
	public String toString() {
		int id = super.getIdObjet();
		String nom = super.getNomObjet();
		int nb = super.getNbReservations();
		return id + " - " + nom + " - " + nb + " - " + this.largeur + " - " + this.longueur + " - " + this.type;
	}
	
	
}