import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class V_Connexion extends JFrame implements ActionListener{

	//Attributs privés
    private JPanel panelConnexion;
    private JPanel panelButton;
    private JLabel lblLogin;
    private JLabel lblPassword;
    private JTextField jtfLogin;
    private JPasswordField jtfPassword;
    private JButton btnConnexion;
    private ImageIcon img;
    private JLabel image;
    private JMenuBar menu;
    private JMenuItem ajoutCrs;
    private JMenuItem suppCrs;
    private JMenuItem affCrs;
    private JMenuItem rechCrs;
    private JMenuItem ajoutEcu;
    private JMenuItem suppEcu;
    private JMenuItem affEcu;
    private JMenuItem rechEcu;
    private JMenuItem ajoutCir;
    private JMenuItem suppCir;
    private JMenuItem affCir;
    private JMenuItem rechCir;
    private JMenuItem affCrsXML;
    private JMenuItem affEcuCSV;
    
    public V_Connexion() {
    	this.setTitle("GSB II");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setResizable(true);
        
        panelConnexion = new JPanel();
        panelButton = new JPanel();
        this.panelConnexion.setBackground(Color.blue);
        this.panelButton.setBackground(Color.blue);
        
        lblLogin = new JLabel("Login : ");
        jtfLogin = new JTextField("");
        
        lblPassword = new JLabel("Mot de passe : ");
        jtfPassword = new JPasswordField ("");
       
        jtfLogin.setPreferredSize(new Dimension(150, 30));
        jtfPassword.setPreferredSize(new Dimension(150, 30));

        panelConnexion.add(lblLogin);
        panelConnexion.add(jtfLogin);
        panelConnexion.add(lblPassword);
        panelConnexion.add(jtfPassword);
        
        btnConnexion = new JButton ("Valider");
        btnConnexion.addActionListener(this);
        panelButton.add(btnConnexion);
        this.getContentPane().add(panelConnexion, BorderLayout.NORTH);
        this.getContentPane().add(panelButton, BorderLayout.SOUTH);
        
        img = new ImageIcon("P:/Workspace/RASIO/f1_fond.jpg");
        image = new JLabel();
        image.setIcon(img);
        this.getContentPane().add(image);
        
        this.setAlwaysOnTop(false);
        this.setVisible(true);
    }
    
    class ActionListe implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		/*if (e.getSource().equals(ajoutCrs)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AjoutCourse().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(affCrs)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AffCourse(Modele.afficherCourse()).getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(affCrsXML)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new ToXML(Modele.afficherCourse()).getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(rechCrs)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new RechCourse().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(suppCrs)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new SuppCourse().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		}
    		
    		if (e.getSource().equals(ajoutEcu)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AjoutEcurie().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(affEcu)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AffEcurie(Modele.afficherEcurie()).getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(affEcuCSV)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new ToCSV(Modele.afficherEcurie()).getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(rechEcu)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new RechEcurie().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(suppEcu)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new SuppEcurie().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		}
    		
    		if (e.getSource().equals(ajoutCir)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AjoutCircuit().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(affCir)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AffCircuit(Modele.afficherCircuit()).getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(rechCir)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new RechCircuit().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} 
    		else if (e.getSource().equals(suppCir)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new SuppCircuit().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		}*/
    		
    	}
    }
    
    public void actionPerformed (ActionEvent evenement) {
        if(evenement.getSource() == btnConnexion) {
            String login = jtfLogin.getText();
            String password = jtfPassword.getText();
            String newLine = System.getProperty("line.separator");	
            JTextArea result = new JTextArea ("Erreur de connexion !");
            if(Modele.connexion(login,password)) {
                result = new JTextArea ("Bienvenue sur GSB II !"); 
                affichageMenu();
                panelConnexion.removeAll();
                panelConnexion.add(result);
                panelConnexion.revalidate();
                panelConnexion.repaint(); 
            }
            else {
                panelConnexion.add(result);
                panelConnexion.revalidate();
                panelConnexion.repaint(); 
            }
        }
    }
    
    public void affichageMenu() {
    	
                JMenuBar menu = new JMenuBar();

                JMenu menuCrs = new JMenu("Course");
                JMenu menuEcu = new JMenu("Ecurie");
                JMenu menuCir = new JMenu("Circuit");

                this.ajoutCrs = new JMenuItem("Ajouter Course");
                this.affCrs = new JMenuItem("Afficher Course");
                this.affCrsXML = new JMenuItem("Imprimer Course XML");
                this.rechCrs = new JMenuItem("Rechercher Course");
                this.suppCrs = new JMenuItem("Supprimer Course");

                this.ajoutEcu = new JMenuItem("Ajouter Ecurie");
                this.affEcu = new JMenuItem("Afficher Ecurie");
                this.affEcuCSV = new JMenuItem("Imprimer Ecurie CSV");
                this.rechEcu = new JMenuItem("Rechercher Ecurie");
                this.suppEcu = new JMenuItem("Supprimer Ecurie");

                this.ajoutCir = new JMenuItem("Ajouter Circuit");
                this.affCir = new JMenuItem("Afficher Circuit");
                this.rechCir = new JMenuItem("Rechercher Circuit");
                this.suppCir = new JMenuItem("Supprimer Circuit");

                menuCrs.add(ajoutCrs);
                menuCrs.add(affCrs);
                menuCrs.add(affCrsXML);
                menuCrs.add(rechCrs);
                menuCrs.add(suppCrs);

                menuEcu.add(ajoutEcu);
                menuEcu.add(affEcu);
                menuEcu.add(affEcuCSV);
                menuEcu.add(rechEcu);
                menuEcu.add(suppEcu);

                menuCir.add(ajoutCir);
                menuCir.add(affCir);
                menuCir.add(rechCir);
                menuCir.add(suppCir);

                this.ajoutCrs.addActionListener(new ActionListe ());
                this.affCrs.addActionListener(new ActionListe ());
                this.affCrsXML.addActionListener(new ActionListe ());
                this.rechCrs.addActionListener(new ActionListe ());
                this.suppCrs.addActionListener(new ActionListe ());

                this.ajoutEcu.addActionListener(new ActionListe ());
                this.affEcu.addActionListener(new ActionListe ());
                this.affEcuCSV.addActionListener(new ActionListe ());
                this.rechEcu.addActionListener(new ActionListe ());
                this.suppEcu.addActionListener(new ActionListe ());

                this.ajoutCir.addActionListener(new ActionListe ());
                this.affCir.addActionListener(new ActionListe ());
                this.rechCir.addActionListener(new ActionListe ());
                this.suppCir.addActionListener(new ActionListe ());
                
                menu.add(menuCrs);
                menu.add(menuEcu);
                menu.add(menuCir);
                this.setJMenuBar(menu);
    }
}

