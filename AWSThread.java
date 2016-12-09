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
	  String instanzeName;
	  
	  // Preisabfrage vom AWS 
	  AWSPrice awsPrice = new AWSPrice(region, awsTyp, produc, zone, 1); 
	  
	// Preisabfrage vom AWS aber die letzten 1000 Einträge um den Mittelwert zu berechnen.
	  AWSPrice awsMittelwert = new AWSPrice(region, awsTyp, produc, zone, 1000);
	  openStacks.listServers(false);
	 
	  
	  
	  float awsPrices = awsPrice.getPrice();
	 
	  float myprice = meinePreise;
	  
	 
	  
	  
	  if(awsPrices != 0){
	  
		  // Mittelwert Berechnung der letzten 1000 Einträgen
		  long mittelwert = awsMittelwert.getmittelwet();
		  
		  /**
		   * Die While-Schleife durchläuft solange bis der AWS-Preis höher ist als Mein-Preis
		   */
		  while(myprice>=awsPrices){

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
			  awsPrices = awsPrice.getPrice(); 
		  }
		  instanzeName = openStacks.getInstanzName(instanceID);
		  System.out.println(instanzeName +" wird heruntergefahren" +  "   mein preis: " + myprice + "  awspreis "+ awsPrices);
		  /**
		   * Die Instanz herunterfahren 
		   */
		  openStacks.stopInstance(instanceID);
	  }
	  else{
		  instanzeName = openStacks.getInstanzName(instanceID);
		  System.out.println(instanzeName +":  Fehler bitte versuchen Sie später nochmal");  
	  }
	  
	 /*
	  *Warten bis es wirklich heruntergefahren wurde
	  */  
	 String status = openStacks.getStatusInstanz(instanceID);
	 while(status!="SHUTOFF"){
		status = openStacks.getStatusInstanz(instanceID);
		
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
