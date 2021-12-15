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
public class V_ReserverVoiture extends JPanel implements ActionListener {
	//Attributs priv�s
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JLabel lblMateriel;
	private JLabel lblDateDebut;
	private JLabel lblDateFin;
	private JLabel lblNotif;
	private JComboBox<String> liste;
	private JButton btnValider;
	private JButton btnDetails;
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker2;
	private int idVisiteur;
	
	public V_ReserverVoiture(ArrayList<Vehicule> lesVehicules, int unIdVisiteur) {
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
        ArrayList<Vehicule> desVehicules = lesVehicules;
        for(Vehicule unVehicule : desVehicules) {
        	liste.addItem(unVehicule.getIdObjet() + " - " + unVehicule.getNomObjet());
        }
        liste.setPreferredSize(new Dimension(150,30));
        
        //JLabel
		this.lblMateriel = new JLabel("Choisir un v�hicule :");
		this.lblMateriel.setForeground(Color.white);
        this.lblDateDebut = new JLabel("Date d�but :");
        this.lblDateDebut.setForeground(Color.white);
        this.lblDateFin = new JLabel("Date fin :");
        this.lblDateFin.setForeground(Color.white);
        this.lblNotif = new JLabel("");
        
        //JButton
        this.btnDetails = new JButton("Voir les caract�ristiques");
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
        this.pannelBas.add(this.lblNotif);
        
        this.add(pannelHaut, BorderLayout.NORTH);
        this.add(pannelBas, BorderLayout.CENTER);
        this.add(btnValider, BorderLayout.SOUTH);
        this.setVisible(true);
	}
	
	class ActionVoirDetails implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String vehicule = V_ReserverVoiture.this.liste.getSelectedItem().toString();
			int idVehicule = Modele.recupInt(vehicule);
			Vehicule unVehicule = Modele.getVehiculeById(idVehicule);
			String detail = unVehicule.toString();
			String titre = unVehicule.getNomObjet();
			V_DetailObjet maVue = new V_DetailObjet(detail,titre);
		}
	}
	
	class ActionValider implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String vehicule = V_ReserverVoiture.this.liste.getSelectedItem().toString();
			int idVehicule = Modele.recupInt(vehicule);
			int idUser = V_ReserverVoiture.this.idVisiteur;
			java.sql.Date dateDebut = (java.sql.Date) V_ReserverVoiture.this.datePicker.getModel().getValue();
			java.sql.Date dateFin = (java.sql.Date) V_ReserverVoiture.this.datePicker2.getModel().getValue();
			String dateHeureDebut = dateDebut + " " + "08:00:00";
			String dateHeureFin = dateFin + " " + "18:00:00";
			if(Modele.ajouterReservation(idVehicule, idUser, dateHeureDebut, dateHeureFin)) {
				V_ReserverVoiture.this.lblNotif.setText("Reservation enregistr�e.");
				V_ReserverVoiture.this.lblNotif.setForeground(Color.green);
			}else {
				V_ReserverVoiture.this.lblNotif.setText("R�servation �chouh�e, veuillez r�-essayer.");
				V_ReserverVoiture.this.lblNotif.setForeground(Color.red);
			}
			V_ReserverVoiture.this.pannelBas.repaint();
			V_ReserverVoiture.this.pannelBas.revalidate();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
