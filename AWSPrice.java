package openstack;

/*
 * Alkan Salan
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeSpotPriceHistoryRequest;
import com.amazonaws.services.ec2.model.DescribeSpotPriceHistoryResult;

public class AWSPrice {

	private AmazonEC2 ec2;
	private DescribeSpotPriceHistoryRequest request;
	private ArrayList<Long> zeit = new ArrayList<Long>();
	private ArrayList<Long> differenz = new ArrayList<Long>();
	
	public AWSPrice(String endPoint, String instyp, String producDes, String avZone, int anzahl){
		
		
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("", "");
		ec2 = new AmazonEC2Client(awsCreds);
		ec2.setEndpoint("https://ec2."+endPoint+".amazonaws.com");

		
		request = new DescribeSpotPriceHistoryRequest();
		request.setMaxResults(anzahl);
		    
		    
		// availabilityZone
		String availabilityZone = avZone;
		    
		// InstanceType
		List<String> instanceTypes = new ArrayList<String>();
		instanceTypes.add(instyp);
		    
		// Instance Product
		List<String> productDescriptions = new ArrayList<String>();
		productDescriptions.add(producDes);
		   
		// Hinzufügen Eigenschaften  
		request.setProductDescriptions(productDescriptions);
		request.setInstanceTypes(instanceTypes);
		   
		request.setAvailabilityZone(availabilityZone);
	}
	
	
	/**
	 * Preisabfrage AWS
	 */
	
	public float getPrice(){
		  
		DescribeSpotPriceHistoryResult result = ec2.describeSpotPriceHistory(request);
		float price = 0;   
		   
		for (int i = 0; i < result.getSpotPriceHistory().size(); i++) {
			System.out.println(result.getSpotPriceHistory().get(i));
			price = Float.parseFloat(result.getSpotPriceHistory().get(i).getSpotPrice());
		}
		
	return price;
	}
	
	/**
	 * Die letzten 1000 Zeiteinträge, und den Mittelwert zu Berechnen 
	 */
	
	public long getmittelwet(){		
		
		DescribeSpotPriceHistoryResult result = ec2.describeSpotPriceHistory(request);
		    
		for (int i = 0; i < result.getSpotPriceHistory().size(); i++) {		
			long zeiten = result.getSpotPriceHistory().get(i).getTimestamp().getTime();
		    zeit.add(zeiten);
		}
		
		long mittelwert = 0;
		
		for(int x=0; x<zeit.size()-1; x++){	
		    long differenzen =  zeit.get(x) - zeit.get(x+1);
		    mittelwert = differenzen + mittelwert;
		    differenz.add(differenzen);
		}
			
		mittelwert = mittelwert / zeit.size();	
		System.out.println("mittelwert: "+ TimeUnit.MILLISECONDS.toMinutes(mittelwert) +" Minuten" + "   "+ result.getSpotPriceHistory().get(0).getInstanceType());
		
		return mittelwert;
	}
	
	
	
	
}
