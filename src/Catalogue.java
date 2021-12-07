import java.util.ArrayList;
public class Catalogue {
	//Attributs privés
	private int idCatalogue;
	private String nomCatalogue;
	private ArrayList<Objet> lesObjets;
	
	public Catalogue() {
		this.lesObjets = new ArrayList<Objet>();
	}
	
	public Catalogue(int unId, String unNom) {
		this.idCatalogue = unId;
		this.nomCatalogue = unNom;
		this.lesObjets = new ArrayList<Objet>();
	}
	
	//Accesseurs
	public int getIdCatalogue() {
		return idCatalogue;
	}

	public void setIdCatalogue(int idCatalogue) {
		this.idCatalogue = idCatalogue;
	}

	public String getNomCatalogue() {
		return nomCatalogue;
	}

	public void setNomCatalogue(String nomCatalogue) {
		this.nomCatalogue = nomCatalogue;
	}

	public ArrayList<Objet> getLesObjets() {
		return lesObjets;
	}

	public void setLesObjets(ArrayList<Objet> lesObjets) {
		this.lesObjets = lesObjets;
	}
	
	public void ajouterObjet(Objet unObjet) {
		this.lesObjets.add(unObjet);
	}
	
	
}