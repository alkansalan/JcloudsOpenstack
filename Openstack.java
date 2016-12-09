package openstack;

/*
 * Alkan Salan
 */
import java.io.IOException;
import java.util.ArrayList;
import org.jclouds.ContextBuilder;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.Flavor;
import org.jclouds.openstack.nova.v2_0.domain.Server;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;
import com.google.common.io.Closeables;


public class Openstack {

	private ArrayList<String> instanceIDliste = new ArrayList<String>();
	private NovaApi novaApi;
	private ServerApi serverApi;

	/**
	 * Verbindungsparamter
	 */
	public Openstack() {
			
		String provider = "";
	    String identity = ""; 
	    String credential = "";
	    String endpoint = "";
    
		novaApi = ContextBuilder.newBuilder(provider)
	                .endpoint(endpoint)
	                .credentials(identity, credential)
	                .buildApi(NovaApi.class);		
	}
	
	
		
	/**
	 * Liste Alle Server und gebe sie später auf dem Bildschirm aus.
	 */
	 public String[] listServers(boolean checkactive) {
		 	
		 String region = "RegionOne";
	     serverApi = novaApi.getServerApi(region);
	      
	     FlavorApi flavorApi=  novaApi.getFlavorApi(region);
	     String serverID;
	     String flavorID;
	     String serverName;
	     String serverstatus;
	     String serverTyp;
	     String puffer;
	     String instanceID;
	     String[] ergebnisArray = new String[100];
	     int zaehler =0;
	     instanceIDliste.clear();
	     
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
	            			  
	            			 
	            			  if (( serverstatus.equals("ACTIVE")) ||  checkactive){
	            				
	            				  if(serverstatus.equals("ACTIVE")){
	            					  instanceIDliste.add(instanceID);
	            				  }
		            			  ergebnisArray[zaehler] = puffer;
		  	            		
		            			  zaehler++;
	            			  }
	            			 
	            			 
	            		  }
	  	             	
	  	              }
	          
	            }
	           
				return ergebnisArray;
        
	}
		

	public ArrayList<String> getInstanceIDliste() {
			return instanceIDliste;
	}
	
	public String getInstanzName(String instID){
		 String name = instID;
		 for (Server server : serverApi.listInDetail().concat()) {
        	 
        	 String instanceID = server.getId();
        	 name = server.getName();
        	 
        	 if(instanceID.equals(instID)){
        		 return name;
        	 }
        	 }
		 
			
		return name;
	}
	
	
	public String getStatusInstanz(String instID){
		String serverStatus = instID;
		for (Server server : serverApi.listInDetail().concat()) {
        	 
        	 String instanceID = server.getId();
        	
        	 if(instanceID.equals(instID)){
        		 serverStatus = server.getStatus().toString();
        	 }
        	 }
		 return serverStatus;
	}
	


	
	
	/**
	 * Always close your service when you're done with it.
	 */
	public void close() throws IOException {
		Closeables.close(novaApi, true);
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
/*	public void listAllImages() {
		for (Image image : computeService.listImages()) {
			System.out.println(image.toString());
		}
	}*/
	


	
}


