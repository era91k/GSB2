import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class V_TypeVehicule extends JPanel implements ActionListener{

	//Attributs priv�s
	private JPanel monPanel;
	private JLabel lblTitre;
	private JTable tableau;
	private JScrollPane scrollPane;
			
	public V_TypeVehicule(ArrayList<Type_Vehicule> lesTypes) {
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
		String[] entetes = {"Id", "Libelle"}; 
		int taille = lesTypes.size();
		Object[][]donnees = new Object[taille][2];
		int i = 0;
		for(i = 0 ; i < taille ; i++) {
			donnees[i][0] = lesTypes.get(i).getCode();
			donnees[i][1] = lesTypes.get(i).getLibelle();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
