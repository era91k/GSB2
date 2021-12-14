import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class V_voirReservation extends JPanel {
	//Attributs privés
	private JLabel lblTitre;
	private JButton btnSupprimer;
	private JButton voirDetails;
	private JTable tableau;
	private JScrollPane scrollPane;
	
	public V_voirReservation(ArrayList<Reservation> lesReservations, int idUser) {
		this.setPreferredSize(new Dimension(700,500));
		this.setBackground(new Color(48, 51, 107));
		
		//Labels
		this.lblTitre = new JLabel("Mes réservations");
		this.lblTitre.setForeground(Color.white);
		this.lblTitre.setFont(new Font("Verdana", Font.PLAIN, 30));
		this.lblTitre.setBorder(new EmptyBorder(20,0,30,130));
		
		//Boutons
		this.btnSupprimer = new JButton("Supprimer");
		this.btnSupprimer.setForeground(Color.white);
		this.btnSupprimer.setBackground(new Color(104,109,224));
		this.btnSupprimer.setPreferredSize(new Dimension(100,30));
		
		this.voirDetails = new JButton("Voir détails");
		this.voirDetails.setForeground(Color.white);
		this.voirDetails.setBackground(new Color(104,109,224));
		this.voirDetails.setPreferredSize(new Dimension(100,30));
		
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
		
		this.add(this.lblTitre);
		this.add(this.voirDetails);
		this.add(this.btnSupprimer);
		this.add(this.scrollPane);
		this.setVisible(true);
	}
}
