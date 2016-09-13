package openstack;

/*
 * Alkan Salan
 */
public class AWSThread extends Thread
{
	private String awsTyp;	
	private String produc;
	private String zone;
	private float meinePreise;
	private String instanceID ;
	private HauptFenster fensterUpdate;
	

	

	public AWSThread(String awsTyp, String produc, String zone, float meinePreise,  String instanceID, HauptFenster fenster){
		
		 this.awsTyp = awsTyp;
		 this.produc = produc;
		 this.zone = zone;
		 this.meinePreise = meinePreise;
		 this.instanceID = instanceID;
		 this.fensterUpdate = fenster;
		
	}
	
	
	
  @Override public void run()
  {
	  Openstack openStacks = new Openstack();
	  String region= zone.substring(0, zone.length()-1);
	  
	  // Preisabfrage vom AWS 
	  AWSPrice awsPrice = new AWSPrice(region, awsTyp, produc, zone, 1); 
	  
	// Preisabfrage vom AWS aber die letzten 1000 Einträge um den Mittelwert zu berechnen.
	  AWSPrice awsMittelwert = new AWSPrice(region, awsTyp, produc, zone, 1000);
	  openStacks.listServers();
	 
	  
	  
	  float awsPrices = awsPrice.getPrice();
	 
	  float myprice = meinePreise;
	  
	  // Mittelwert Berechnung der letzten 1000 Einträgen
	  long mittelwert = awsMittelwert.getmittelwet();
	  
	  
	  if(awsPrices != 0){
	  
		  /**
		   * Die While-Schleife durchläuft solange bis der AWS-Preis höher ist als Mein-Preis
		   */
		  while(myprice>=awsPrices){

			  awsPrices = awsPrice.getPrice(); 
			  try {
				  
				  /**
				   * Um nicht jede Sekunde abzufragen, wurde der Mittelwert  der letzten 1000 Zeiteinträgen berechnet, 
				   * somit sparen wir unnötige Berechnungen. 
				   */
					Thread.sleep(mittelwert);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		  System.out.println(instanceID +" wird heruntergefahren" +  "   mein preis: " + myprice + "  awspreis "+ awsPrices);
		  /**
		   * Die Instanz herunterfahren 
		   */
		  openStacks.stopInstance(instanceID);
	  }
	  else{
		  System.out.println("Fehler bitte versuchen Sie später nochmal");  
	  }
	  
	 /*
	  * 10 Sekunden warten bis sich die Instanz heruntergefahren wird, 
	  * da es vorkommen kann dass es länger dauert und die Anzeige falsch Aktualisiert (noch aktiv ist) wird.
	  */
	  try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
	  /**
	   * Nach dem Beenden der Instanz wird die Anzeige Aktualisiert,  
	   * dies wurde mit Hilfe von Observer Patter implementiert
	   */
	  AnzeigenErgebnis anzeigen = new AnzeigenErgebnis();
	  anzeigen.addObserver(fensterUpdate);
	  anzeigen.aktualisieren();


	 
  }
  
 
  
  
}
