public class Vehicule extends Objet{

	//Attributs privés
	private Type_Vehicule typeVehicule;
	private String immat;
	private String modele;
	private String marque;
	private int nbPlaces;
	
	/**
	 * Constructeur de la page
	 * @param unIdObjet
	 * @param unNomObjet
	 * @param unNbReservation
	 * @param unIdTypeV
	 * @param unImmat
	 * @param unModele
	 * @param uneMarque
	 * @param unNbPlace
	 */
	public Vehicule(int unIdObjet, String unNomObjet, int unNbReservation, Type_Vehicule unTypeV , String unImmat, String unModele, String uneMarque, int unNbPlace) {
		super(unIdObjet, unNomObjet, unNbReservation);
		this.typeVehicule = unTypeV;
		this.immat = unImmat;
		this.modele = unModele;
		this.marque = uneMarque;
		this.nbPlaces = unNbPlace;
	}

	//Accesseurs
	public Type_Vehicule getIdTypeV() {
		return this.typeVehicule;
	}

	public void setIdTypeV(Type_Vehicule unIdTypeV) {
		this.typeVehicule = unIdTypeV;
	}

	public String getImmat() {
		return this.immat;
	}

	public void setImmat(String unImmat) {
		this.immat = unImmat;
	}

	public String getModele() {
		return this.modele;
	}

	public void setModele(String unModele) {
		this.modele = unModele;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String uneMarque) {
		this.marque = uneMarque;
	}

	public int getNbPlaces() {
		return this.nbPlaces;
	}

	public void setNbPlaces(int unNbPlaces) {
		this.nbPlaces = unNbPlaces;
	}
	
	/**
	 * Méthode retournant toutes les informations d'un objet véhicule
	 */
	public String toString() {
		int id = super.getIdObjet();
		String nom = super.getNomObjet();
		int nb = super.getNbReservations();
		return id + " - " + nom + " - " + nb + " - " + this.typeVehicule.getLibelle() + " - " + this.immat + " - " + this.modele + " - " + this.marque + " - " + this.nbPlaces;
	}
}
