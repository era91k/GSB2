import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class V_MenuResponsable extends JFrame implements ActionListener {
	//Attributs privés
	private JPanel monPanel;
	private JMenuBar menu;
	private JMenu menuMat;
	private JMenu menuVehicule;
	private JMenu menuType;
	private JMenu menuDeconnexion;
	private JMenuItem voirVehicule;
	private JMenuItem ajoutVehicule;
	private JMenuItem suppVehicule;
	private JMenuItem voirMat;
	private JMenuItem ajoutMat;
	private JMenuItem suppMat;
	private JMenuItem voirType;
	private JMenuItem ajoutType;
	private JMenuItem suppType;
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
        
        //Partie Gestion des Materiéls
        this.menuMat = new JMenu("Matériel");
        this.voirMat = new JMenuItem("Voir les matériels");
        this.ajoutMat = new JMenuItem("Ajouter un matériel");
        this.suppMat = new JMenuItem("Supprimer un matériel");
        this.voirMat.addActionListener(new ActionVoirMat());
        this.ajoutMat.addActionListener(new ActionAjoutMat());
        this.suppMat.addActionListener(new ActionSuppMat());
        this.menuMat.add(voirMat);
        this.menuMat.add(ajoutMat);
        this.menuMat.add(suppMat);
        this.menu.add(menuMat);
        
        //Partie Gestion des Véhicules
        this.menuVehicule = new JMenu("Véhicule");
        this.voirVehicule = new JMenuItem("Voir les véhicules");
        this.ajoutVehicule = new JMenuItem("Ajouter un matériel");
        this.suppVehicule = new JMenuItem("Supprimer un matériel");
        this.voirVehicule.addActionListener(new ActionVoirVehicule());
        this.ajoutVehicule.addActionListener(new ActionAjoutVehicule());
        this.suppVehicule.addActionListener(new ActionSuppVehicule());
        this.menuVehicule.add(voirVehicule);
        this.menuVehicule.add(ajoutVehicule);
        this.menuVehicule.add(suppVehicule);
        this.menu.add(menuVehicule);
        
      //Partie Gestion des Véhicules
        this.menuType = new JMenu("Type de véhicule");
        this.voirType = new JMenuItem("Voir les types");
        this.ajoutType = new JMenuItem("Ajouter un type");
        this.suppType = new JMenuItem("Supprimer un type");
        this.voirType.addActionListener(new ActionVoirType());
        this.ajoutType.addActionListener(new ActionAjoutType());
        this.suppType.addActionListener(new ActionSuppType());
        this.menuType.add(voirType);
        this.menuType.add(ajoutType);
        this.menuType.add(suppType);
        this.menu.add(menuType);
        
        //Partie deconnexion
        this.menuDeconnexion = new JMenu("Déconnexion");
        this.seDeconnect = new JMenuItem("Se déconnecter");
        this.quitter = new JMenuItem("Quitter");
        this.seDeconnect.addActionListener(new ActionDeconnexion());
        this.quitter.addActionListener(new ActionQuitter());
        this.menuDeconnexion.add(seDeconnect);
        this.menuDeconnexion.add(quitter);
        this.menu.add(this.menuDeconnexion);
        

        
        //Couleur des composants
        this.menuMat.setForeground(new Color(206, 214, 224));
        this.menuDeconnexion.setForeground(new Color(206, 214, 224));
        
        this.add(monPanel);
        this.getContentPane().add(monPanel);
        this.setJMenuBar(menu);
        this.setVisible(true);
        this.revalidate();
	}
	
	class ActionVoirMat implements ActionListener{
		public void acttionPerformed(ActionEvent e) {
			ArrayList<Materiel> lesMat = Modele.getLesMateriels();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_AjoutMat(lesMat));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
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
	
	class ActionSuppMat implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Materiel> lesMat = Modele.getLesMateriels();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_SuppMat(lesMat));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
			
		}
	}
	
	class ActionVoirVehicule implements ActionListener{
		public void acttionPerformed(ActionEvent e) {
			ArrayList<Vehicule> lesVehicules = Modele.getLesVehicules();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_Vehicule(lesVehicules));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class ActionAjoutVehicule implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Vehicule> lesVehicules = Modele.getLesVehicules();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_AjoutVehicule(lesVehicules));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
			
		}
	}
	
	class ActionSuppVehicule implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Vehicule> lesVehicules = Modele.getLesVehicules();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_SuppVehicule(lesVehicules));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
			
		}
	}
	
	class ActionVoirType implements ActionListener{
		public void acttionPerformed(ActionEvent e) {
			ArrayList<Type_Vehicule> lesTypes = Modele.getLesTypesVehicules();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_TypeVehicule(lesTypes));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class ActionAjoutType implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Type_Vehicule> lesTypes = Modele.getLesTypesVehicules();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_AjoutType(lesTypes));
			V_MenuResponsable.this.revalidate();
			V_MenuResponsable.this.setVisible(true);
			
		}
	}
	
	class ActionSuppType implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Type_Vehicule> lesTypes = Modele.getLesTypesVehicules();
			V_MenuResponsable.this.getContentPane().removeAll();
			V_MenuResponsable.this.getContentPane().add(new V_SuppType(lesTypes));
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