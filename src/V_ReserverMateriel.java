import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import java.sql.Date;

public class V_ReserverMateriel extends JPanel implements ActionListener {
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JLabel lblMateriel;
	private JLabel lblDateDebut;
	private JLabel lblDateFin;
	private JComboBox<String> liste;
	private JButton btnValider;
	private JButton btnDetails;
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker2;
	private int idVisiteur;
	
	public V_ReserverMateriel(ArrayList<Materiel> lesMateriels, int unIdVisiteur) {
		this.idVisiteur = unIdVisiteur;
		this.setPreferredSize(new Dimension(700,500));
		this.setLayout(new BorderLayout());
		
		System.out.println(idVisiteur);
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
		this.lblMateriel = new JLabel("Choisir un matériel :");
		this.lblMateriel.setForeground(Color.white);
        this.lblDateDebut = new JLabel("Date début :");
        this.lblDateDebut.setForeground(Color.white);
        this.lblDateFin = new JLabel("Date fin :");
        this.lblDateFin.setForeground(Color.white);
        
        //JButton
        this.btnDetails = new JButton("Voir les caractéristiques");
		this.btnDetails.setForeground(Color.white);
        this.btnDetails.setBackground(new Color(104, 109, 224));
        this.btnDetails.setPreferredSize(new Dimension(170,30));
        this.btnDetails.setBorder(null);
        this.btnDetails.addActionListener(new ActionVoirDetails());
        
        this.btnValider = new JButton("Valider");
        this.btnValider.setForeground(Color.white);
        this.btnValider.setBackground(new Color(104,109,224));
        this.btnValider.addActionListener(new ActionValider());
        
        
        //DatePickerDebut
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl panel = new JDatePanelImpl(model,p);
        this.datePicker = new JDatePickerImpl(panel, new DateLabelFormatter());
        
        //DatePickerFin
        SqlDateModel model2 = new SqlDateModel();
        Properties p2 = new Properties();
        p2.put("text.day", "Day");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl panel2 = new JDatePanelImpl(model2,p2);
        this.datePicker2 = new JDatePickerImpl(panel2,new DateLabelFormatter());
        
        
        this.pannelHaut.add(this.lblMateriel);
        this.pannelHaut.add(this.liste);
        this.pannelHaut.add(this.btnDetails);
        
        this.pannelBas.add(this.lblDateDebut);
        this.pannelBas.add(this.datePicker);
        this.pannelBas.add(this.lblDateFin);
        this.pannelBas.add(this.datePicker2);
        
        this.add(pannelHaut, BorderLayout.NORTH);
        this.add(pannelBas, BorderLayout.CENTER);
        this.add(btnValider, BorderLayout.SOUTH);
        this.setVisible(true);
	}
	
	class ActionVoirDetails implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String objet = V_ReserverMateriel.this.liste.getSelectedItem().toString();
			int id = Modele.recupInt(objet);
			Materiel unMateriel = Modele.getMaterielById(id);
			String detail = unMateriel.toString();
			String titre = unMateriel.getNomObjet();
			V_DetailObjet maVue = new V_DetailObjet(detail,titre);
			java.sql.Date dateDebut = (java.sql.Date) V_ReserverMateriel.this.datePicker.getModel().getValue();
			java.sql.Date dateFin = (java.sql.Date) V_ReserverMateriel.this.datePicker2.getModel().getValue();
			String dateHeureDebut = dateDebut + " " + "08:00:00";
			String dateHeureFin = dateFin + " " + "18:00:00";
		}
	}
	
	class ActionValider implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String objet = V_ReserverMateriel.this.liste.getSelectedItem().toString();
			int idObjet = Modele.recupInt(objet);
			int idUser = V_ReserverMateriel.this.idVisiteur;
			java.sql.Date dateDebut = (java.sql.Date) V_ReserverMateriel.this.datePicker.getModel().getValue();
			java.sql.Date dateFin = (java.sql.Date) V_ReserverMateriel.this.datePicker2.getModel().getValue();
			String dateHeureDebut = dateDebut + " " + "08:00:00";
			String dateHeureFin = dateFin + " " + "18:00:00";
			JLabel notif = new JLabel();
			if(Modele.ajouterReservation(idObjet, idUser, dateHeureDebut, dateHeureFin)) {
				notif = new JLabel("Réservation enregistrée.");
				notif.setForeground(Color.green);
			}else {
				notif = new JLabel("Réservation échouhée, veuillez ré-essayer.");
				notif.setForeground(Color.red);
			}
			V_ReserverMateriel.this.pannelBas.add(notif);
			V_ReserverMateriel.this.pannelBas.repaint();
			V_ReserverMateriel.this.pannelBas.revalidate();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
