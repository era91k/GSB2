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

public class V_SuppType extends JPanel implements ActionListener {

	private JPanel pannel;
	private JComboBox<String> liste;
	private JLabel lblNotif;
	private JLabel lblType;
	private JButton btn;
	
	public V_SuppType(ArrayList<Type_Vehicule> lesTypes) {
		this.setPreferredSize(new Dimension(700,500));
		this.setLayout(new BorderLayout());
        
		//PANEL
		this.pannel = new JPanel();
        this.pannel.setBackground(new Color(48, 51, 107));
        
        this.lblNotif = new JLabel(" ");
        
        //JComboBox
        this.liste = new JComboBox<String>();
		ArrayList<Type_Vehicule> desTypes = lesTypes;
        for(Type_Vehicule unType : desTypes) {
        	this.liste.addItem(unType.getCode() + " - " + unType.getLibelle());
        }
		this.liste.setPreferredSize(new Dimension(150,30));
        
        //JLabel
		this.lblType = new JLabel("Choisir un type de véhicule à supprimer :");
		this.lblType.setForeground(Color.white);
		
		this.pannel.add(this.lblType);
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
	    		String objet = V_SuppType.this.liste.getSelectedItem().toString();
				int idObjet = Modele.recupInt(objet);
	            if(Modele.supprimerVehicule(idObjet)) {
	            	V_SuppType.this.lblNotif.setText("Suppression réussie.");
	            	V_SuppType.this.lblNotif.setForeground(Color.green);
	            }
	            else {
	            	V_SuppType.this.lblNotif.setText("Suppression échouhée, veuillez ré-essayer.");
	            	V_SuppType.this.lblNotif.setForeground(Color.red);
	            }
	            V_SuppType.this.pannel.repaint();
	            V_SuppType.this.pannel.revalidate();
	    	}
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
