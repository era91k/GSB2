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
public class V_voirReservation extends JPanel implements ActionListener{
	//Attributs privés
	private JPanel monPanel;
	private JLabel lblTitre;
	private JLabel lblNotif;
	private JButton btnSupprimer;
	private JTable tableau;
	private JScrollPane scrollPane;
	private int idVisiteur;
	
	public V_voirReservation(ArrayList<Reservation> lesReservations, int idUser) {
		this.setBackground(new Color(48, 51, 107));
		this.monPanel = new JPanel();
		this.monPanel.setPreferredSize(new Dimension(700,500));
		this.monPanel.setBackground(new Color(48, 51, 107));
		
		//IdVisiteur
		this.idVisiteur = idUser;
		
		//Labels
		this.lblTitre = new JLabel("Mes réservations");
		this.lblTitre.setForeground(Color.white);
		this.lblTitre.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.lblTitre.setBorder(new EmptyBorder(20,0,30,130));
		
		this.lblNotif = new JLabel("");
		
		//Boutons
		this.btnSupprimer = new JButton("Supprimer");
		this.btnSupprimer.setForeground(Color.white);
		this.btnSupprimer.setBackground(new Color(104,109,224));
		this.btnSupprimer.setPreferredSize(new Dimension(100,30));
		this.btnSupprimer.addActionListener(this);
		
		//Tableau
		String[] entetes = {"Reservation", "Objet reservé", "Duree", "Date début", "Date Fin"};
		int taille = lesReservations.size();
		Object[][]donnees = new Object[taille][5];
		int i = 0;
		for(i = 0 ; i < taille ; i++) {
			donnees[i][0] = lesReservations.get(i).getIdReservation();
			donnees[i][1] = lesReservations.get(i).getUnObjet().getNomObjet();
			donnees[i][2] = lesReservations.get(i).getDuree() + " jours" ;
			donnees[i][3] = lesReservations.get(i).getDateHeureDebut();
			donnees[i][4] = lesReservations.get(i).getDateHeureFin();
		}
		this.tableau = new JTable(donnees, entetes);
		this.tableau.setPreferredScrollableViewportSize(new Dimension(650,280));
		this.tableau.setFillsViewportHeight(true);
		this.tableau.setRowHeight(30);
		this.scrollPane = new JScrollPane(this.tableau);
		
		//Ajout des panels
		this.monPanel.add(this.lblTitre);
		this.monPanel.add(this.btnSupprimer);
		this.monPanel.add(this.scrollPane);
		this.add(this.monPanel);
		this.setVisible(true);
	}
	
	private JPanel getMonPanel() {
		return this.monPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnSupprimer) {//Si on appuie sur le bouton supprimer
			int ligne = this.tableau.getSelectedRow();
			if(ligne != -1) {
				String idReservation = this.tableau.getModel().getValueAt(ligne, 0).toString();//Recuperation de l'idReservation
				int idR = Modele.recupInt(idReservation);
				if(Modele.supprimerReservation(idR)) {//Suppression de la reservation
					int idUser = this.idVisiteur;
					ArrayList<Reservation> lesReservations = Modele.getReservation(idUser);
					V_voirReservation maVue = new V_voirReservation(lesReservations, idUser);
					maVue.setBorder(BorderFactory.createEmptyBorder(-5, 0, 0, 0));//On empeche que le panel descende
					this.removeAll();
					this.add(maVue);
					this.repaint();
					this.revalidate();
					
				}else {//Si aucune ligne n'a été choisie
					JOptionPane.showMessageDialog(this, "Suppression echouée");
				}
			}else {//Si la suppression échoue
				JOptionPane.showMessageDialog(this, "Aucune ligne n'a été selectionnée");
			}
		}
	}

}
