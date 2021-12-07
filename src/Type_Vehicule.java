public class Type_Vehicule {
	//Attributs
	private int code;
	private String libelle;
	
	//Constructeurs
	public Type_Vehicule() {
		
	}
	
	public Type_Vehicule(int unCode, String unLibelle) {
		this.code = unCode;
		this.libelle = unLibelle;
	}

	//Accesseurs
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}