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
public class V_voirStatVisit extends JPanel implements ActionListener{
	//Attributs privés
	private JPanel monPanel;
	private JLabel lblTitre;
	private JLabel lblNotif;
	private JButton btnPdf;
	private JTable tableau;
	private JScrollPane scrollPane;
	
	public V_voirStatVisit(ArrayList<StatVisiteur> lesStats) {
		this.setBackground(new Color(48, 51, 107));
		this.monPanel = new JPanel();
		this.monPanel.setPreferredSize(new Dimension(700,500));
		this.monPanel.setBackground(new Color(48, 51, 107));
		
		//Labels
		this.lblTitre = new JLabel("Nombre de prêts pour chaque visiteur par type de matériel");
		this.lblTitre.setForeground(Color.white);
		this.lblTitre.setFont(new Font("Verdana", Font.PLAIN, 18));
		this.lblTitre.setBorder(new EmptyBorder(10,0,15,0));
		
		this.lblNotif = new JLabel("");
		
		//Boutons
		this.btnPdf = new JButton("PDF");
		this.btnPdf.setForeground(Color.white);
		this.btnPdf.setBackground(new Color(104,109,224));
		this.btnPdf.setPreferredSize(new Dimension(100,30));
		this.btnPdf.addActionListener(this);
		
		//Tableau
		String[] entetes = {"Id Visiteur", "Nom", "Prenom", "Type de matériel", "Nombre de réservationsl"};
		int taille = lesStats.size();
		Object[][]donnees = new Object[taille][5];
		int i = 0;
		for(i = 0 ; i < taille ; i++) {
			donnees[i][0] = lesStats.get(i).getIdVisiteur();
			donnees[i][1] = lesStats.get(i).getNom();
			donnees[i][2] = lesStats.get(i).getPrenom();
			donnees[i][3] = lesStats.get(i).getTypeMat();
			donnees[i][4] = lesStats.get(i).getNbReserv();
		}
		this.tableau = new JTable(donnees, entetes);
		this.tableau.setPreferredScrollableViewportSize(new Dimension(650,280));
		this.tableau.setFillsViewportHeight(true);
		this.tableau.setRowHeight(30);
		this.scrollPane = new JScrollPane(this.tableau);
		
		//Ajout des panels
		this.monPanel.add(this.lblTitre);
		this.monPanel.add(this.btnPdf);
		this.monPanel.add(this.scrollPane);
		this.add(this.monPanel);
		this.setVisible(true);
	}
	
	private JPanel getMonPanel() {
		return this.monPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnPdf) {
		}
	}

}
