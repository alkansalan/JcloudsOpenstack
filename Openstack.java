package openstack;

/*
 * Alkan Salan
 */
import java.io.IOException;
import java.util.ArrayList;
import org.jclouds.ContextBuilder;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.compute.domain.Image;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.Flavor;
import org.jclouds.openstack.nova.v2_0.domain.Server;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;
import com.google.common.io.Closeables;


public class Openstack {

	private final ComputeService computeService;
	private ArrayList<String> instanceIDliste = new ArrayList<String>();
	private NovaApi novaApi;
	private int anzahlActiveServer;
	private ServerApi serverApi;



	/**
	 * Verbindungsparamter
	 */
	public Openstack() {
			
	    String provider = "";
	    String identity = ""; 
	    String credential = "";
	    String endpoint = "";
	      
		  		
		ComputeServiceContext context = ContextBuilder.newBuilder(provider)
				.endpoint(endpoint)
				.credentials(identity, credential)
				.buildView(ComputeServiceContext.class);

		computeService = context.getComputeService();
		
	    
		novaApi = ContextBuilder.newBuilder(provider)
	                .endpoint(endpoint)
	                .credentials(identity, credential)
	                .buildApi(NovaApi.class);
		
	}
	
	
		
	/**
	 * Liste Alle Server und gebe sie später auf dem Bildschirm aus.
	 */
	 public String[] listServers() {
		 	
	     String region = "";
	     serverApi = novaApi.getServerApi(region);
	       
	     FlavorApi flavorApi=  novaApi.getFlavorApi(region);
	     String serverID;
	     String flavorID;
	     String serverName;
	     String serverstatus;
	     String serverTyp;
	     String puffer;
	     String instanceID;
	     int zaehlerServerstatus = 0;
	     String[] ergebnisArray = new String[100];
	     int zaehler =0;
	     		
	            for (Server server : serverApi.listInDetail().concat()) {
	            	 serverID = server.getFlavor().getId();
	            	 instanceID = server.getId();
	            
	            	  for (Flavor flavor : flavorApi.listInDetail().concat()) {
	            		  flavorID = flavor.getId();
	            		  	
	            		  if(serverID.equals(flavorID)){
	            			  serverName = server.getName();
	            			  serverstatus = server.getStatus().toString();
	            			  serverTyp = flavor.getName();
	            			  puffer = serverName + " \t\t " + serverstatus + " \t\t " + serverTyp;
	            			  ergebnisArray[zaehler] = puffer;
	            		
	            			  zaehler++;
	            			 
	            			  if (serverstatus.equals("ACTIVE")){
	            				  zaehlerServerstatus = zaehlerServerstatus+1;
	            				
		            			  instanceIDliste.add(instanceID);
	            			  }
	            		
	            		  }
	  	             	
	  	              }
	          
	            }
	            setanzahlActiveServer(zaehlerServerstatus);
	           
				return ergebnisArray;
        
	}
		

	public ArrayList<String> getInstanceIDliste() {
			return instanceIDliste;
	}
	
	
	
	public void setanzahlActiveServer(int zahl){	
		anzahlActiveServer = zahl;
	}
	
	
	public int getanzahlActiveServer(){
		System.out.println("anzahl: " + anzahlActiveServer);
		return anzahlActiveServer;
	} 
	
	
	/**
	 * Always close your service when you're done with it.
	 */
	public void close() throws IOException {
		Closeables.close(computeService.getContext(), true);
	}

	
	/**
	 * Stop the Instance
	 */
	public void stopInstance(String instancID){	
		 serverApi.stop(instancID);	
	}
	
	
	/**
	 * Start the Instance
	 */
	public void startInstance(String instancID){	 
		 serverApi.start(instancID);	
	}
	
	
	/**
	 * Print all images
	 */
	public void listAllImages() {
		for (Image image : computeService.listImages()) {
			System.out.println(image.toString());
		}
	}
	



	

	

	
}


