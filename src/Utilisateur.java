public class Utilisateur {
	
	//Attributs privés
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String cp;
	private String ville;
	private String dateEmbauche;
	private String role;
	
	//Constructeurs
	/**
	 * Constructeur par défaut
	 */
	public Utilisateur() {	
		
	}
	
	/**
	 * Constructeur avec tous les attriuts privés de la classe Utilisateur
	 * @param unId
	 * @param unNom
	 * @param unPrenom
	 * @param unLogin
	 * @param unMdp
	 * @param unCp
	 * @param uneVille
	 * @param uneDateEmbauche
	 * @param unRole
	 */
	public Utilisateur(int unId, String unNom, String unPrenom, String unLogin, String unMdp, String unCp, String uneVille, String uneDateEmbauche, String unRole) {
		this.id = unId;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.login = unLogin;
		this.mdp = unMdp;
		this.cp = unCp;
		this.ville = uneVille;
		this.dateEmbauche = uneDateEmbauche;
		this.role = unRole;
	}
	
	//Acceuseurs
	/**
	 * Accesseur attribut id
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Accesseur attribut nom
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Accesseur attribut prenom
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Accesseur attribut login
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Accesseur attribut mdp
	 * @return
	 */
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Accesseur attribut cp
	 * @return
	 */
	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Accesseur attribut ville
	 * @return
	 */
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Accesseur attribut dateEmbauche
	 * @return
	 */
	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * Accesseur attribut role
	 * @return
	 */
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}