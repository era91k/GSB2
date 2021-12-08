public class Materiel extends Objet{
	//Attributs privés
	private double largeur;
	private double longueur;
	private String type;
	
	//Constructeur
	public Materiel() {
		
	}
	
	public Materiel(int unIdObjet, String unNomObjet, int unNbReservation, double uneLargeur, double uneLongueur, String unType) {
		super(unIdObjet,unNomObjet,unNbReservation);
		this.largeur = uneLargeur;
		this.longueur = uneLongueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		int id = super.getIdObjet();
		String nom = super.getNomObjet();
		int nb = super.getNbReservations();
		return id + " - " + nom + " - " + nb + " - " + this.largeur + " - " + this.longueur + " - " + this.type;
	}
	
	
}