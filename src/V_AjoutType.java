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

public class V_AjoutType extends JPanel implements ActionListener{

	//Attributs priv�s
	private GroupLayout layout;
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JLabel lblId;
	private JTextField jtfId;
	private JLabel lblNom;
	private JTextField jtfNom;
	private JLabel lblNotif;
	private JButton btnValider;
			
	public V_AjoutType(ArrayList<Type_Vehicule> lesTypes) {
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
        
  		this.lblId = new JLabel("Id du type du véhicule :");
  		this.lblId.setForeground(Color.white);
  		this.jtfId = new JTextField ("");
		this.jtfId.setMaximumSize(new Dimension(150,30));
  		
		this.lblNom = new JLabel("Libelle du véhicule :");
		this.lblNom.setForeground(Color.white);
		this.jtfNom = new JTextField ("");
		this.jtfNom.setMaximumSize(new Dimension(100,30));
		
		this.btnValider = new JButton("Valider");
        this.btnValider.setForeground(Color.white);
        this.btnValider.setBackground(new Color(104,109,224));
        this.btnValider.addActionListener(new ActionValider());
        
        //GroupLayout
        layout.setHorizontalGroup(layout.createSequentialGroup() 
    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) 
    					.addComponent(lblId)
    					.addComponent(jtfId)
    					
    					)
    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    					.addComponent(lblNom)
    					.addComponent(jtfNom)
    					)
    			);
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(lblId)
        				.addComponent(lblNom))
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addGroup (layout.createSequentialGroup()
        						.addComponent(jtfId)
        						)
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        							.addComponent(jtfNom))
        							)
        				)
        		);
        
        this.add(pannelHaut, BorderLayout.NORTH);
        this.add(pannelBas, BorderLayout.CENTER);
        this.add(btnValider, BorderLayout.SOUTH);
        this.setVisible(true);
	}

	class ActionValider implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnValider) {
				int id = Integer.parseInt(jtfId.getText());
	    		String nom = jtfNom.getText();
	    		String newLine = System.getProperty("line.separator");
	            //On v�rifie que l'ajout est bon et si c'est le cas on actualise les panels
	            if(Modele.ajouterTypeVehicule(id,nom)) {
	            	V_AjoutType.this.lblNotif.setText("Ajout enregistrée.");
	            	V_AjoutType.this.lblNotif.setForeground(Color.green);
	            }
	            else {
	            	V_AjoutType.this.lblNotif.setText("Ajout échouhé, veuillez ré-essayer.");
	            	V_AjoutType.this.lblNotif.setForeground(Color.red);
	            }
	            V_AjoutType.this.pannelBas.repaint();
	            V_AjoutType.this.pannelBas.revalidate();
	    	}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
