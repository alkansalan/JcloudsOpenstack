package openstack;

/*
 * Alkan Salan
 */

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("rawtypes")

public class HauptFenster implements Observer{

	private JFrame frame;
	private JTextField textmeinpreis_1;
	private JTextField textmeinpreis_2;
	private JTextField textmeinpreis_3;
	private JScrollPane scrollPane1;	
	private ArrayList<Float> zahl;
	private AWSThread awsThread; 
	private Openstack openStack; 
	private AwsTyp awsTyps;
	private String awsTypArray[];
	private JComboBox comboBoxawsTypArray_1;
	private JComboBox comboBoxawsTypArray_2;
	private JComboBox comboBoxawsTypArray_3;
	private JComboBox comboBoxZone;
	private DefaultListModel listModel;
	private JList list_1;
	private static HauptFenster window;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new HauptFenster();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HauptFenster() {
			initialize();	
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked" })
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		awsTyps = new AwsTyp();
		openStack = new Openstack();
		listModel=new DefaultListModel();
		

		/**
		 * Auflisten der Instanzen 
		 */
		
		JList list = new JList(openStack.listServers());	
		JScrollPane scrollPane = new JScrollPane(list);	
		scrollPane.setBounds(113, 76, 200, 100);		
		frame.getContentPane().add(scrollPane);
		
		/**
		 * TextFelder 
		 */
		JTextPane txtpnServer = new JTextPane();
		txtpnServer.setText("Server");
		txtpnServer.setBounds(113, 45, 40, 20);
		frame.getContentPane().add(txtpnServer);
		
		JTextPane txtpnStatus = new JTextPane();
		txtpnStatus.setText("Status");
		txtpnStatus.setBounds(163, 45, 40, 20);
		frame.getContentPane().add(txtpnStatus);
		
		JTextPane txtpnServerType = new JTextPane();
		txtpnServerType.setText("Server-Type");
		txtpnServerType.setBounds(213, 45, 70, 20);
		frame.getContentPane().add(txtpnServerType);
	
		
	
		awsTypArray = awsTyps.getEuCentralTyps();
		
		/**
		 * Paramater suche für AWS-Preis-abfrage 
		 */
		
		String productDescription[] = {"Linux/UNIX", "Windows"};
				
		String endpoint[] = {
		"US East (N. Virginia)", "US West (Oregon)", "US West (N. California)", 
		"EU (Ireland)", "EU (Frankfurt)", 
		"Asia Pacific (Singapore)", "Asia Pacific (Tokyo)",
		"Asia Pacific (Sydney)", "Asia Pacific (Seoul)", "Asia Pacific (Mumbai)",
		"South America (Sao Paulo)"};
		
		String usEastZone[] = {"us-east-1a", "us-east-1b", "us-east-1c", "us-east-1e"};
		String usWest1Zone[] = {"us-west-1a", "us-west-1c"};
		String usWest2Zone[] = {"us-west-2a", "us-west-2b", "us-west-2c"};
		String euWestZone[]={"eu-west-1a", "eu-west-1b", "eu-west-1c"};
		String euCentralZone[]={"eu-central-1a", "eu-central-1b"};
		String apNortheast1Zone[]={"ap-northeast-1a", "ap-northeast-1c"};
		String apNortheast2Zone[]={"ap-northeast-2a", "ap-northeast-2c"};
		String apSoutheast1Zone[]={"ap-southeast-1a", "ap-southeast-1b"};
		String apSoutheast2Zone[]={"ap-southeast-2a", "ap-southeast-2b", "ap-southeast-2c"};
		String apSoutZone[]={"ap-sout-1a", "ap-sout-1b"};
		String saEastZone[]={"sa-east-1a", "sa-east-1c"};
		
		
		/**
		 * Auswählen der Parameter  
		 */
		
		comboBoxawsTypArray_1 = new JComboBox(awsTypArray);
		comboBoxawsTypArray_1.setBounds(323, 77, 100, 20);
		frame.getContentPane().add(comboBoxawsTypArray_1);			
		
		comboBoxawsTypArray_2 = new JComboBox(awsTypArray);
		comboBoxawsTypArray_2.setBounds(323, 95, 100, 20);
		frame.getContentPane().add(comboBoxawsTypArray_2);
		
		
		comboBoxawsTypArray_3 = new JComboBox(awsTypArray);
		comboBoxawsTypArray_3.setBounds(323, 114, 100, 20);
		frame.getContentPane().add(comboBoxawsTypArray_3);

		JComboBox comboBoxproductDescription = new JComboBox(productDescription);
		comboBoxproductDescription.setBounds(323, 145, 100, 20);
		frame.getContentPane().add(comboBoxproductDescription);
		
		comboBoxZone = new JComboBox(euCentralZone);
		comboBoxZone.setBounds(454, 145, 110, 20);
		frame.getContentPane().add(comboBoxZone);
		
		
		/**
		 * Je nach Land/Kontinent ändern sich die AWS-Typen und die Regions-Parametern    
		 */
		
		
		JComboBox comboBoxEndpoint = new JComboBox(endpoint);
		comboBoxEndpoint.setSelectedIndex(4); // Frankfurt
		comboBoxEndpoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comboBoxawsTypArray_1.removeAllItems();
				comboBoxawsTypArray_2.removeAllItems();
				comboBoxawsTypArray_3.removeAllItems();
				comboBoxZone.removeAllItems();
				
				if(comboBoxEndpoint.getSelectedIndex() == 0 ){
					awsTypArray = awsTyps.getUsEastTyps();	
					parameterAenderung(usEastZone, awsTypArray);	
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 1){
					awsTypArray = awsTyps.getUsWest1Typs();	
					parameterAenderung(usWest1Zone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 2){
					awsTypArray = awsTyps.getUsWest2Typs();	
					parameterAenderung(usWest2Zone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 3){
					awsTypArray = awsTyps.getEuWestTyps();
					parameterAenderung(euWestZone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 4){
					awsTypArray = awsTyps.getEuCentralTyps();
					parameterAenderung(euCentralZone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 5){
					awsTypArray = awsTyps.getApNortheast1Typs();
					parameterAenderung(apNortheast1Zone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 6){
					awsTypArray = awsTyps.getApNortheast2Typs();
					parameterAenderung(apNortheast2Zone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 7){
					awsTypArray = awsTyps.getApSoutheast1Typs();
					parameterAenderung(apSoutheast1Zone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 8){
					awsTypArray = awsTyps.getApSoutheast2Typs();
					parameterAenderung(apSoutheast2Zone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 9){
					awsTypArray = awsTyps.getApSouthTyps();
					parameterAenderung(apSoutZone, awsTypArray);
				}
				else if (comboBoxEndpoint.getSelectedIndex() == 10){
					awsTypArray = awsTyps.getSeEastTyps();
					parameterAenderung(saEastZone, awsTypArray);
				}							
			}
		});
		comboBoxEndpoint.setBounds(323, 45, 175, 20);
		frame.getContentPane().add(comboBoxEndpoint);
		
		
		/**
		 * Meine Preise für die Instanzen   
		 */
		
		textmeinpreis_1 = new JTextField();
		textmeinpreis_1.setBounds(454, 77, 86, 20);
		frame.getContentPane().add(textmeinpreis_1);
		textmeinpreis_1.setColumns(10);
		
		textmeinpreis_2 = new JTextField();
		textmeinpreis_2.setBounds(454, 95, 86, 20);
		frame.getContentPane().add(textmeinpreis_2);
		textmeinpreis_2.setColumns(10);
		
		textmeinpreis_3 = new JTextField();
		textmeinpreis_3.setBounds(454, 114, 86, 20);
		frame.getContentPane().add(textmeinpreis_3);
		textmeinpreis_3.setColumns(10);
		
		
		/**
		 * Start-Button durchläuft die selbst definierten AWS-Parametern und vergleicht im Thread Mein-Preis und AWS-preis. 
		 * Wenn Mein-Preis unterhalb des AWS-preises ist dann wird die Instanz heruntergefahren. 
		 * 
		 * Um nicht den Hauptthread zu blockieren werden die Preis abfragen im neuen erzeugten Thread berechnet. 
		 * Jede Instanz bekommt einem neuen Thread zugewiesen.
		 */
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> awsTypcomBox = new ArrayList<String>();
				awsTypcomBox.add(comboBoxawsTypArray_1.getSelectedItem().toString());
				awsTypcomBox.add(comboBoxawsTypArray_2.getSelectedItem().toString());
				awsTypcomBox.add(comboBoxawsTypArray_3.getSelectedItem().toString());
				
				
				boolean check;
				try {
					zahl = new ArrayList<Float>();	
					float zahl1 = Float.parseFloat(textmeinpreis_1.getText());
					zahl.add(zahl1);
					float zahl2 = Float.parseFloat(textmeinpreis_2.getText());
					zahl.add(zahl2);
					float zahl3 = Float.parseFloat(textmeinpreis_3.getText());
					zahl.add(zahl3);
					check = true;
				}
				catch (NumberFormatException nfe) {
		            System.out.println("Keine Zahl, bitte Zahl eingeben"); 
		            check = false;
		        }
				
				ArrayList<String> instanceID = new ArrayList<String>();
				instanceID = openStack.getInstanceIDliste();
				
				/**
				 * Es werden nur die ersten drei Instanzen ausgeführt.
				 * Deshalb werden auch drei Thread erzeugt und auch ausführt 
				 */
				
				if(check){
					for(int x=0; x<3; x++){
						
						/** Parameter 
						 * AWSThread( Instanz-Typ, Instanz-BS, AWS-Zone, Mein-Preis, Intanz-ID, Objekt vom Typ HauptFenster);
						 */
						
						awsThread = new AWSThread(awsTypcomBox.get(x),  comboBoxproductDescription.getSelectedItem().toString(), comboBoxZone.getSelectedItem().toString(), zahl.get(x), instanceID.get(x), window);
						awsThread.start();
					}
				}
				
				
			}
		});		
		btnStart.setBounds(262, 187, 89, 23);
		frame.getContentPane().add(btnStart);			
		
		list_1 = new JList(openStack.listServers());	
		scrollPane1 = new JScrollPane(list_1);
		scrollPane1.setBounds(113, 231, 200, 100);	
		frame.getContentPane().add(scrollPane1);


	}
	
	
	@SuppressWarnings("unchecked")
	public void parameterAenderung(String[] zone, String[] awsTyp){
		
		for(int i=0; i<awsTyp.length; i++){
			comboBoxawsTypArray_1.addItem(awsTyp[i]);
			comboBoxawsTypArray_2.addItem(awsTyp[i]);
			comboBoxawsTypArray_3.addItem(awsTyp[i]);
		}
		for(int x=0; x<zone.length; x++){
			comboBoxZone.addItem(zone[x]);
		}		
	}
	
	/**
	 * Aktualisiert der Anzeige
	 */
	@SuppressWarnings("unchecked")
	public synchronized void updates(){
		listModel=new DefaultListModel();	
		String aktu[] = openStack.listServers();
		for (int i=0; i<aktu.length; i++) {
		  listModel.addElement(aktu[i]);
		}
		list_1.setModel(listModel);
		
		
	}

	/**
	 * Observable Patter Muster implementiert, 
	 * wenn der Thread beendet wird startet die Methode update();
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updates();
	}
	
	
	
}
