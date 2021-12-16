import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class V_AjoutVehicule extends JPanel implements ActionListener{

	//Attributs priv�s
	private GroupLayout layout;
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JLabel lblId;
	private JTextField jtfId;
	private JLabel lblNom;
	private JTextField jtfNom;
	private JLabel lblModele;
	private JTextField jtfModele;
	private JLabel lblImmat;
	private JTextField jtfImmat;
	private JLabel lblType;
	private JTextField jtfType;
	private JButton btnValider;
	private JLabel lblNotif;
	private JLabel lblMarque;
	private JTextField jtfMarque;
	private JLabel lblPlace;
	private JTextField jtfPlace;
		
	public V_AjoutVehicule(ArrayList<Vehicule> lesVehicules) {
		this.setPreferredSize(new Dimension(700,500));
		this.setBackground(new Color(48, 51, 107));
		this.setLayout(new BorderLayout());
        
		//Panel
		this.pannelHaut = new JPanel();
        this.pannelBas = new JPanel();
        this.pannelHaut.setBackground(new Color(48, 51, 107));
        this.pannelBas.setBackground(new Color(48, 51, 107));
        this.pannelHaut.setLayout(new BorderLayout());
        this.layout = new GroupLayout(this.pannelBas);
        this.layout.setAutoCreateGaps(true);
        this.layout.setAutoCreateContainerGaps(true);
        this.pannelBas.setLayout(this.layout);
        
        //JLabel
        this.lblNotif = new JLabel("");
        
  		this.lblId = new JLabel("Id du véhicule :");
  		this.lblId.setForeground(Color.white);
  		this.jtfId = new JTextField ("");
		this.jtfId.setMaximumSize(new Dimension(150,30));
  		
		this.lblNom = new JLabel("Nom du véhicule :");
		this.lblNom.setForeground(Color.white);
		this.jtfNom = new JTextField ("");
		this.jtfNom.setMaximumSize(new Dimension(100,30));
		
		this.lblType = new JLabel("Id du type du véhicule :");
		this.lblType.setForeground(Color.white);
		this.jtfType = new JTextField ("");
		this.jtfType.setMaximumSize(new Dimension(100,30));
		
		this.lblImmat = new JLabel("Immatriculation du véhicule :");
		this.lblImmat.setForeground(Color.white);
		this.jtfImmat = new JTextField ("");
		this.jtfImmat.setMaximumSize(new Dimension(100,30));
		
		this.lblModele = new JLabel("Modele du véhicule :");
		this.lblModele.setForeground(Color.white);
		this.jtfModele = new JTextField ("");
		this.jtfModele.setMaximumSize(new Dimension(100,30));
		
		this.lblMarque = new JLabel("Marque du véhicule :");
		this.lblMarque.setForeground(Color.white);
		this.jtfMarque = new JTextField ("");
		this.jtfMarque.setMaximumSize(new Dimension(100,30));
		
		this.lblPlace = new JLabel("Nombre de place du véhicule :");
		this.lblPlace.setForeground(Color.white);
		this.jtfPlace = new JTextField ("");
		this.jtfPlace.setMaximumSize(new Dimension(100,30));
		
		this.btnValider = new JButton("Valider");
        this.btnValider.setForeground(Color.white);
        this.btnValider.setBackground(new Color(104,109,224));
        this.btnValider.addActionListener(new ActionValider());

        //GroupLayout
        layout.setHorizontalGroup(layout.createSequentialGroup() 
    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) 
    					.addComponent(lblId)
    					.addComponent(jtfId)
    					.addComponent(lblNom)
    					.addComponent(jtfNom)
    					)
    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(lblType)
    					.addComponent(jtfType)
    					.addComponent(lblImmat)
    					.addComponent(jtfImmat)
    					)
    			);
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(lblId)
        				.addComponent(lblType))
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addGroup (layout.createSequentialGroup()
        						.addComponent(jtfId)
        						.addComponent(lblNom)
        						.addComponent(jtfNom)
        						)
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        							.addComponent(jtfType)
        							.addComponent(lblImmat)
        							.addComponent(jtfImmat))
        							)
        				)
        		);
        	
        
        this.add(pannelHaut, BorderLayout.NORTH);
        this.add(pannelBas, BorderLayout.CENTER);
        this.add(btnValider, BorderLayout.SOUTH);
        this.setVisible(true);
	}
	
	class ActionValider implements ActionListener{
		public void actionPerformed(ActionEvent evenement) {
			if(evenement.getSource() == btnValider) {
				int id = Integer.parseInt(jtfId.getText());
	    		String nom = jtfNom.getText();	
	    		int type = Integer.parseInt(jtfType.getText());
	    		String immat = jtfImmat.getText();
	    		String modele = jtfModele.getText();
	    		String marque = jtfMarque.getText();
	    		int nbPlace = Integer.parseInt(jtfPlace.getText());
	    		String newLine = System.getProperty("line.separator");
	            //On v�rifie que l'ajout est bon et si c'est le cas on actualise les panels
	            if(Modele.ajouterVehicule(id,nom,type,immat,modele,marque,nbPlace)) {
	            	V_AjoutVehicule.this.lblNotif.setText("Ajout enregistrée.");
	            	V_AjoutVehicule.this.lblNotif.setForeground(Color.green);
	            }
	            else {
	            	V_AjoutVehicule.this.lblNotif.setText("Ajout échouhé, veuillez ré-essayer.");
	            	V_AjoutVehicule.this.lblNotif.setForeground(Color.red);
	            }
	            V_AjoutVehicule.this.pannelBas.repaint();
	            V_AjoutVehicule.this.pannelBas.revalidate();
	            

	    	}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
