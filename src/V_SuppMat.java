import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class V_SuppMat extends JPanel implements ActionListener{

	private JPanel pannel;
	private JComboBox<String> liste;
	private JLabel lblMateriel;
	private JButton btn;

	public V_SuppMat(ArrayList<Materiel> lesMateriels) {
		this.setPreferredSize(new Dimension(700,500));
		this.setLayout(new BorderLayout());
        
		//PANEL
		this.pannel = new JPanel();
        this.pannel.setBackground(new Color(48, 51, 107));
        
        //JComboBox
        this.liste = new JComboBox<String>();
		ArrayList<Materiel> desMateriels = lesMateriels;
        for(Materiel unMateriel : desMateriels) {
        	this.liste.addItem(unMateriel.getIdObjet() + " - " + unMateriel.getNomObjet());
        }
		this.liste.setPreferredSize(new Dimension(150,30));
        
        //JLabel
		this.lblMateriel = new JLabel("Choisir un matériel à supprimer :");
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
	    		String objet = V_SuppMat.this.liste.getSelectedItem().toString();
				int idObjet = Modele.recupInt(objet);
	    		String newLine = System.getProperty("line.separator");	
	            JTextArea result = new JTextArea ("Une erreur est survenue !");
	            if(Modele.supprimerMat(idObjet)) {
	                result = new JTextArea ("La suppression a bien été effectué"); 
	                pannel.removeAll();
	                pannel.add(result);
	                pannel.revalidate();
	                pannel.repaint(); 
	            }
	            else {
	            	result = new JTextArea ("Une erreur est survenue .");
	            	pannel.removeAll();
	            	pannel.add(result);
	            	pannel.revalidate();
	            	pannel.repaint(); 
	            }
	    	}
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
