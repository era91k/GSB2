import java.awt.*;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class V_ReserverMateriel extends JPanel {
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JLabel lblMateriel;
	private JLabel lblDateDebut;
	private JLabel lblDateFin;
	private JComboBox<String> lesMateriels;
	private JTextField jtfDateDebut;
	private JTextField jtfDateFin;
	private JButton btnValider;
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker2;
	
	public V_ReserverMateriel() {
		this.setPreferredSize(new Dimension(700,500));
		this.setLayout(new BorderLayout());
		
		//Layout
        FlowLayout flowLay = new FlowLayout();
        flowLay.setVgap(20);
        flowLay.setHgap(30);
        
		//PANEL
		this.pannelHaut = new JPanel();
		this.pannelHaut.setLayout(flowLay);
        this.pannelHaut.setBackground(new Color(48, 51, 107));
        
        this.pannelBas = new JPanel();
        this.pannelBas.setLayout(flowLay);
        this.pannelBas.setBackground(new Color(48, 51, 107));
        
        //JLabel
        this.lblDateDebut = new JLabel("Date début :");
        this.lblDateDebut.setForeground(Color.white);
        this.lblDateFin = new JLabel("Date fin :");
        this.lblDateFin.setForeground(Color.white);
        
        //DatePickerDebut
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl panel = new JDatePanelImpl(model,p);
        this.datePicker = new JDatePickerImpl(panel,null);
        
        //DatePickerFin
        SqlDateModel model2 = new SqlDateModel();
        Properties p2 = new Properties();
        p2.put("text.day", "Day");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl panel2 = new JDatePanelImpl(model2,p2);
        this.datePicker2 = new JDatePickerImpl(panel2,null);
        
        this.pannelBas.add(this.lblDateDebut);
        this.pannelBas.add(this.datePicker);
        this.pannelBas.add(this.lblDateFin);
        this.pannelBas.add(this.datePicker2);
        
        this.add(pannelBas, BorderLayout.CENTER);
        this.setVisible(true);
	}
}
