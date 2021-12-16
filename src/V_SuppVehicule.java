import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class V_SuppVehicule extends JPanel implements ActionListener{
	
	private JPanel pannel;
	private JComboBox<String> liste;
	private JLabel lblNotif;
	private JLabel lblMateriel;
	private JButton btn;

	public V_SuppVehicule(ArrayList<Vehicule> lesVehicules) {
		this.setPreferredSize(new Dimension(700,500));
		this.setLayout(new BorderLayout());
        
		//PANEL
		this.pannel = new JPanel();
        this.pannel.setBackground(new Color(48, 51, 107));
        
        this.lblNotif = new JLabel(" ");
        
        //JComboBox
        this.liste = new JComboBox<String>();
		ArrayList<Vehicule> desVehicules = lesVehicules;
        for(Vehicule unVehicule : desVehicules) {
        	this.liste.addItem(unVehicule.getIdObjet() + " - " + unVehicule.getNomObjet() +  " - " + unVehicule.getMarque());
        }
		this.liste.setPreferredSize(new Dimension(150,30));
        
        //JLabel
		this.lblMateriel = new JLabel("Choisir un véhicule à supprimer :");
		this.lblMateriel.setForeground(Color.white);
		
		this.pannel.add(this.lblMateriel);
        this.pannel.add(this.liste);
        
        this.btn = new JButton("Valider");
        this.btn.setForeground(Color.white);
        this.btn.setBackground(new Color(104,109,224));
        this.btn.addActionListener(new ActionValider());
        
        this.add(pannel, BorderLayout.CENTER);
        this.add(btn, BorderLayout.SOUTH);
        this.setVisible(true);
	}
	
	class ActionValider implements ActionListener{
		public void actionPerformed ( ActionEvent evenement) {
	    	//Si la source de l'�v�nement est le JButton appel� 
	    	if(evenement.getSource() == btn) {
	    		String objet = V_SuppVehicule.this.liste.getSelectedItem().toString();
				int idObjet = Modele.recupInt(objet);
	    		String newLine = System.getProperty("line.separator");
	            if(Modele.supprimerVehicule(idObjet)) {
	            	V_SuppVehicule.this.lblNotif.setText("Suppression réussie.");
	            	V_SuppVehicule.this.lblNotif.setForeground(Color.green);
	            }
	            else {
	            	V_SuppVehicule.this.lblNotif.setText("Suppression échouhée, veuillez ré-essayer.");
	            	V_SuppVehicule.this.lblNotif.setForeground(Color.red);
	            }
	            V_SuppVehicule.this.pannel.repaint();
	            V_SuppVehicule.this.pannel.revalidate();
	    	}
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
