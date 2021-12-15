import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class V_MenuVisiteur extends JFrame implements ActionListener {
	//Attributs priv�s
	private JPanel monPanel;
	private JMenuBar menu;
	private JMenu menuReservation;
	private JMenu menuDeconnexion;
	private JMenuItem reserverObjet;
	private JMenuItem reserverVoiture;
	private JMenuItem voirReservations;
	private JMenuItem seDeconnect;
	private JMenuItem quitter;
	private int idVisiteur;
	
	public V_MenuVisiteur(int unIdVisiteur) {
		this.idVisiteur = unIdVisiteur;
		//Titre
        this.setTitle("Bienvenu(e) dans GSB2"); 
        //Localisation de la fen�tre (null = milieu)
        this.setLocationRelativeTo(null);
        //Arr�t du programme quand la croix "fermer" est cliqu�e
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
        
        //Partie Gestion des reservaations
        this.menuReservation = new JMenu("Reservation");
        this.reserverObjet = new JMenuItem("Reserver un objet");
        this.voirReservations = new JMenuItem("Voir mes reservations");
        this.reserverVoiture = new JMenuItem("Reserver une voiture");
        this.reserverObjet.addActionListener(new ActionReserverObjet());
        this.voirReservations.addActionListener(new ActionVoirReservations());
        this.reserverVoiture.addActionListener(new ActionReserverVoiture());
        this.menuReservation.add(reserverObjet);
        this.menuReservation.add(this.reserverVoiture);
        this.menuReservation.add(voirReservations);
        this.menu.add(menuReservation);
        
        //Partie deconnexion
        this.menuDeconnexion = new JMenu("Deconnexion");
        this.seDeconnect = new JMenuItem("Se deconnecter");
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
	
	class ActionReserverObjet implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Materiel> lesMat = Modele.getLesMateriels();
			int idVisiteur = V_MenuVisiteur.this.idVisiteur;
			V_MenuVisiteur.this.getContentPane().removeAll();
			V_MenuVisiteur.this.getContentPane().add(new V_ReserverMateriel(lesMat, idVisiteur));
			V_MenuVisiteur.this.revalidate();
			V_MenuVisiteur.this.setVisible(true);
			
		}
	}
	
	class ActionReserverVoiture implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Vehicule> lesMat = Modele.getLesVehicules();
			int idVisiteur = V_MenuVisiteur.this.idVisiteur;
			V_MenuVisiteur.this.getContentPane().removeAll();
			V_MenuVisiteur.this.getContentPane().add(new V_ReserverVoiture(lesMat, idVisiteur));
			V_MenuVisiteur.this.revalidate();
			V_MenuVisiteur.this.setVisible(true);
			
		}
	}

	
	class ActionVoirReservations implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int idVisiteur = V_MenuVisiteur.this.idVisiteur;
			ArrayList<Reservation> lesReservations = Modele.getReservation(idVisiteur);
			V_MenuVisiteur.this.getContentPane().removeAll();
			V_MenuVisiteur.this.getContentPane().add(new V_voirReservation(lesReservations, idVisiteur));
			V_MenuVisiteur.this.revalidate();
			V_MenuVisiteur.this.setVisible(true);
		}
	}
	
	class ActionDeconnexion implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			V_MenuVisiteur.this.dispose();
			V_Connexion maVue = new V_Connexion();
		}
	}
	
	class ActionQuitter implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			V_MenuVisiteur.this.dispose();
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}