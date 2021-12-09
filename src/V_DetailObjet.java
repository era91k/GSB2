import java.awt.*;
import javax.swing.*;
public class V_DetailObjet extends JFrame{
	private JPanel monPanel;
	private JTextArea unLabel;
	private String leContenu;
	JScrollPane scrollPane;
	
	public V_DetailObjet(String unFormat, String unTitre) {
		//Titre
        this.setTitle(unTitre); 
        //Localisation de la fenêtre (null = milieu)
        this.setLocationRelativeTo(null);
        //Arrêt du programme quand la croix "fermer" est cliquée
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //Taille de la fenêtre
        this.setSize(700, 500);
        this.setResizable(true); //<---Redimension de la fenetre impossible
		
		this.monPanel = new JPanel();
		this.leContenu = unFormat;
		this.unLabel = new JTextArea(leContenu);
		this.unLabel.setEditable(false);
		this.monPanel.add(unLabel);
		this.scrollPane = new JScrollPane(this.monPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
        this.setAlwaysOnTop(true);
        this.getContentPane().add(scrollPane);
        this.setVisible(true);
	}
}