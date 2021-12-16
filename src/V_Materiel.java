import java.awt.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;

public class V_Materiel extends JPanel{
	//Attributs priv�s
	private JPanel monPanel;
	private JLabel lblTitre;
	private JTable tableau;
	private JScrollPane scrollPane;
	
	public V_Materiel(ArrayList<Materiel> lesMats) {
		this.setBackground(new Color(48, 51, 107));
		this.monPanel = new JPanel();
		this.monPanel.setPreferredSize(new Dimension(700,500));
		this.monPanel.setBackground(new Color(48, 51, 107));
		
		//Labels
		this.lblTitre = new JLabel("Matériels disponibles");
		this.lblTitre.setForeground(Color.white);
		this.lblTitre.setFont(new Font("Verdana", Font.PLAIN, 18));
		this.lblTitre.setBorder(new EmptyBorder(10,0,15,0));
		
		//Tableau
		String[] entetes = {"Id", "Nom", "Largeur", "Longueur", "Type de matériel"};
		int taille = lesMats.size();
		Object[][]donnees = new Object[taille][5];
		int i = 0;
		for(i = 0 ; i < taille ; i++) {
			donnees[i][0] = lesMats.get(i).getIdObjet();
			donnees[i][1] = lesMats.get(i).getNomObjet();
			donnees[i][2] = lesMats.get(i).getLargeur();
			donnees[i][3] = lesMats.get(i).getLongueur();
			donnees[i][4] = lesMats.get(i).getType();
		}
		this.tableau = new JTable(donnees, entetes);
		this.tableau.setPreferredScrollableViewportSize(new Dimension(650,280));
		this.tableau.setFillsViewportHeight(true);
		this.tableau.setRowHeight(30);
		this.scrollPane = new JScrollPane(this.tableau);
		
		//Ajout des panels
		this.monPanel.add(this.lblTitre);
		this.monPanel.add(this.scrollPane);
		this.add(this.monPanel);
		this.setVisible(true);
	}
	
	private JPanel getMonPanel() {
		return this.monPanel;
	}

}
