import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class V_SuppMat extends JPanel{

	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JComboBox<String> liste;
	private JLabel lblMateriel;
	private JButton btn;

	public V_SuppMat(ArrayList<Materiel> lesMateriels) {
		this.setPreferredSize(new Dimension(700,500));
		this.setLayout(new BorderLayout());
		
		//Layout
        FlowLayout flowLay = new FlowLayout();
        flowLay.setVgap(40);
        flowLay.setHgap(30);
        
		//PANEL
		this.pannelHaut = new JPanel();
		this.pannelHaut.setLayout(flowLay);
        this.pannelHaut.setBackground(new Color(48, 51, 107));
        
        this.pannelBas = new JPanel();
        this.pannelBas.setLayout(flowLay);
        this.pannelBas.setBackground(new Color(48, 51, 107));
        
        //JComboBox
        this.liste = new JComboBox<String>();
		ArrayList<Materiel> desMateriels = lesMateriels;
        for(Materiel unMateriel : desMateriels) {
        	liste.addItem(unMateriel.getIdObjet() + " - " + unMateriel.getNomObjet());
        }
		liste.setPreferredSize(new Dimension(150,30));
        
        //JLabel
		this.lblMateriel = new JLabel("Choisir un matériel à supprimer :");
		this.lblMateriel.setForeground(Color.white);
		
		this.pannelHaut.add(this.lblMateriel);
        this.pannelHaut.add(this.liste);
        
        this.btn = new JButton("Valider");
        this.btn.setForeground(Color.white);
        this.btn.setBackground(new Color(104,109,224));
        
        this.add(pannelHaut, BorderLayout.NORTH);
        this.add(pannelBas, BorderLayout.CENTER);
        this.setVisible(true);
	}
	
	public void actionPerformed ( ActionEvent evenement) {
    	//Si la source de l'�v�nement est le JButton appel� 
    	if(evenement.getSource() == btn) {
    		String nomCircuit = jtfNom.getText();	
    		String newLine = System.getProperty("line.separator");	
            JTextArea result = new JTextArea ("Une erreur est survenue !");
            if(Modele.supprimerMat(nomCircuit)) {
                result = new JTextArea ("La suppression a bien été effectué"); 
                monPanelGlobal.removeAll();
                monPanelGlobal.add(result);
                monPanelGlobal.revalidate();
                monPanelGlobal.repaint(); 
            }
            else {
            	result = new JTextArea ("Une erreur est survenue .");
            	monPanelGlobal.removeAll();
            	monPanelGlobal.add(result);
            	monPanelGlobal.revalidate();
            	monPanelGlobal.repaint(); 
            }
    	}
    }

}
