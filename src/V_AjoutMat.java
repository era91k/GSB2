import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class V_AjoutMat extends JPanel implements ActionListener{

	//Attributs privés
	private GroupLayout layout;
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JLabel lblId;
	private JTextField jtfId;
	private JLabel lblNom;
	private JTextField jtfNom;
	private JLabel lblLargeur;
	private JTextField jtfLargeur;
	private JLabel lblLongueur;
	private JTextField jtfLongueur;
	private JLabel lblType;
	private JTextField jtfType;
	private JButton btnValider;
	
	public V_AjoutMat(ArrayList<Materiel> lesMat) {
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
  		this.lblId = new JLabel("Id du matériel :");
  		this.lblId.setForeground(Color.white);
  		this.jtfId = new JTextField ("");
		this.jtfId.setMaximumSize(new Dimension(150,30));
  		
		this.lblNom = new JLabel("Nom du matériel :");
		this.lblNom.setForeground(Color.white);
		this.jtfNom = new JTextField ("");
		this.jtfNom.setMaximumSize(new Dimension(100,30));
		
		this.lblLargeur = new JLabel("Largeur du matériel :");
		this.lblLargeur.setForeground(Color.white);
		this.jtfLargeur = new JTextField ("");
		this.jtfLargeur.setMaximumSize(new Dimension(100,30));
		
		this.lblLongueur = new JLabel("Longueur du matériel :");
		this.lblLongueur.setForeground(Color.white);
		this.jtfLongueur = new JTextField ("");
		this.jtfLongueur.setMaximumSize(new Dimension(100,30));
		
		this.lblType = new JLabel("Type du matériel :");
		this.lblType.setForeground(Color.white);
		this.jtfType = new JTextField ("");
		this.jtfType.setMaximumSize(new Dimension(100,30));
		
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
    					.addComponent(lblLargeur)
    					.addComponent(jtfLargeur)
    					.addComponent(lblLongueur)
    					.addComponent(jtfLongueur)
    					)
    			);
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(lblId)
        				.addComponent(lblLargeur))
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addGroup (layout.createSequentialGroup()
        						.addComponent(jtfId)
        						.addComponent(lblNom)
        						.addComponent(jtfNom)
        						)
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        							.addComponent(jtfLargeur)
        							.addComponent(lblLongueur)
        							.addComponent(jtfLongueur))
        							)
        				)
        		);
        	
        
        this.add(pannelHaut, BorderLayout.NORTH);
        this.add(pannelBas, BorderLayout.CENTER);
        this.add(btnValider, BorderLayout.SOUTH);
        this.setVisible(true);
		
	}
	
	class ActionValider implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
