import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class V_MenuResponsable extends JFrame implements ActionListener {
	//Attributs privés
	private JPanel monPanel;
	private JMenuBar menu;
	private JMenu menuReservation;
	private JMenu menuDeconnexion;
	private JMenuItem ajoutMat;
	private JMenuItem suppMat;
	private JMenuItem seDeconnect;
	private JMenuItem quitter;
	
	public V_MenuResponsable() {
		//Titre
        this.setTitle("Bienvenu(e) dans GSB2"); 
        //Localisation de la fenêtre (null = milieu)
        this.setLocationRelativeTo(null);
        //Arrêt du programme quand la croix "fermer" est cliquée
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Taille de la fen�tre
        this.setSize(700, 500);
        this.setResizable(false); //<---Redimension de la fenetre impossible
        
        //Initialisation et param�trage des panels
        this.monPanel = new JPanel();
        this.monPanel.setLayout(null);
        this.monPanel.setBackground(new Color(48, 51, 107));
        
        //Menu et parametrage du menu
        this.menu = new JMenuBar();
        this.menu.setBackground(new Color(47, 53, 66));
        this.menu.setPreferredSize(new Dimension(700,35));
        this.menu.setBorder(BorderFactory.createLineBorder(new Color(47, 53, 66)));
        
        //Partie Gestion des Courses
        this.menuReservation = new JMenu("Matériel");
        this.ajoutMat = new JMenuItem("Ajouter un matériel");
        this.suppMat = new JMenuItem("Supprimer un matériel");
        this.ajoutMat.addActionListener(new ActionAjoutMat());
        this.suppMat.addActionListener(new ActionSupptMat());
        this.menuReservation.add(ajoutMat);
        this.menuReservation.add(suppMat);
        this.menu.add(menuReservation);
        
        //Partie Gestion des �curies
        this.menuDeconnexion = new JMenu("Déconnexion");
        this.seDeconnect = new JMenuItem("Se déconnecter");
        this.quitter = new JMenuItem("Quitter");
        this.seDeconnect.addActionListener(new ActionDeconnexion());
        this.quitter.addActionListener(new ActionQuitter());
        this.menuDeconnexion.add(seDeconnect);
        this.menuDeconnexion.add(quitter);
        this.menu.add(this.menuDeconnexion);
        

        
        //Couleur des composants
        this.menuReservation.setForeground(new Color(206, 214, 224));
        this.menuDeconnexion.setForeground(new Color(206, 214, 224));
        
        this.add(monPanel);
        this.getContentPane().add(monPanel);
        this.setJMenuBar(menu);
        this.setVisible(true);
        this.revalidate();
	}
	
	class ActionAjoutMat implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Materiel> lesMat = Modele.getLesMateriels();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_AjoutMat(lesMat));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
			
		}
	}
	
	class ActionSupptMat implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Materiel> lesMat = Modele.getLesMateriels();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_SuppMat(lesMat));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
			
		}
	}
	
	class ActionDeconnexion implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			V_MenuResponsable.this.dispose();
			V_Connexion maVue = new V_Connexion();
		}
	}
	
	class ActionQuitter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			V_MenuResponsable.this.dispose();
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}