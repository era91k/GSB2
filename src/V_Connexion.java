import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class V_Connexion extends JFrame implements ActionListener {
	//Attributs priv�s
	private JPanel monPanel;
	private JLabel lblRaceio;
	private JLabel lblLogin;
	private JTextField jtfLogin;
	private JLabel lblMdp;
	private JPasswordField jpfMdp;
	private JButton btnValider;
	
	public V_Connexion() {
		
		//Titre
        this.setTitle("Connexion � Raceio"); 
        //Localisation de la fen�tre (null = milieu)
        this.setLocationRelativeTo(null);
        //Arr�t du programme quand la croix "fermer" est cliqu�e
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Taille de la fen�tre
        this.setSize(400, 380);
        this.setResizable(false); //<---Redimension de la fenetre impossible
        
        //Initialisation et param�trage du panel
        this.monPanel = new JPanel();
        this.monPanel.setLayout(null);
        this.monPanel.setBackground(new Color(48, 51, 107));
        
        //Initialisation des composants
        this.lblRaceio = new JLabel("CONNEXION A GSB2");
        this.lblLogin = new JLabel("Login");
        this.jtfLogin = new JTextField("");
        this.lblMdp = new JLabel("Mot de passe");
        this.jpfMdp = new JPasswordField("");
        this.btnValider = new JButton("Valider");
        this.btnValider.addActionListener(this);
        
        //Couleur des composants
        lblRaceio.setForeground(Color.white);
        lblLogin.setForeground(Color.white);
        lblMdp.setForeground(Color.white);
        jtfLogin.setForeground(Color.white);
        jpfMdp.setForeground(Color.white);
        btnValider.setForeground(Color.white);
        jtfLogin.setBackground(new Color(83, 92, 104));
        jpfMdp.setBackground(new Color(83, 92, 104));
        btnValider.setBackground(new Color(104, 109, 224));
        btnValider.setBorder(null);
        
        //Taille et position des composants
        this.lblRaceio.setBounds(125,20,200,30);
        this.lblLogin.setBounds(70,80,100,30);
        this.lblMdp.setBounds(70,165,100,30);
        this.jtfLogin.setBounds(170,80,150,30);
        this.jpfMdp.setBounds(170,165,150,30);
        this.btnValider.setBounds(150,250,100,30);
        
        //Ajouter les composants au panel
        monPanel.add(this.lblRaceio);
        monPanel.add(this.lblLogin);
        monPanel.add(this.jtfLogin);
        monPanel.add(this.lblMdp);
        monPanel.add(this.jpfMdp);
        monPanel.add(this.btnValider);
        
        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel);
        this.setVisible(true);
	}
	
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == btnValider) {// <-- Lorsque l'utilisateur valide la connexion
			String unLogin = jtfLogin.getText();
			char[] unMdp = jpfMdp.getPassword();
			String leMdp = new String(unMdp);
			if(Modele.connexion(unLogin, leMdp)) {
				//L'utilisateur existe
				String role = Modele.verifRole(unLogin, leMdp);
				switch(role) {//On v�rifie son r�le
					case "visiteur" :
						V_MenuVisiteur fenVisit = new V_MenuVisiteur();
						dispose();
						break;
					case "responsable" :
						JOptionPane.showMessageDialog(this, "Connexion r�ussie - Responsable");
						break;
					case "directeur" :
						JOptionPane.showMessageDialog(this, "Connexion r�ussie - Directeur");
						break;
				}
			}else {
				//Utilisateur n'existe pas
				JOptionPane.showMessageDialog(this, "Login ou mot de passe incorrect");
			}
		}
	}
}

