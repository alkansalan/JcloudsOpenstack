package openstack;
/*
 * Alkan Salan
 */


public class AwsTyp {

/**
 * Alle AwsTypen von dem verschiedenen Orten der Welt
 * 
 */
	
	public String[] getUsEastTyps() {
		return usEastTyps;
	}

	public String[] getUsWest1Typs() {
		return usWest1Typs;
	}

	public String[] getUsWest2Typs() {
		return usWest2Typs;
	}

	public String[] getEuWestTyps() {
		return euWestTyps;
	}

	public String[] getApNortheast1Typs() {
		return apNortheast1Typs;
	}

	public String[] getApNortheast2Typs() {
		return apNortheast2Typs;
	}

	public String[] getApSoutheast1Typs() {
		return apSoutheast1Typs;
	}

	public String[] getApSoutheast2Typs() {
		return apSoutheast2Typs;
	}

	public String[] getApSouthTyps() {
		return apSouthTyps;
	}

	public String[] getSeEastTyps() {
		return seEastTyps;
	}

	public String[] getEuCentralTyps() {
		return euCentralTyps;
	}
	
	
	
	private String usEastTyps[] ={
			"t1.micro", 
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"cc2.8xlarge",
			"g2.2xlarge" , "g2.8xlarge" ,
			"cg1.4xlarge", 
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"x1.32xlarge",
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge",
			"cr1.8xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge" ,
			"hi1.4xlarge" };
	
	private String usWest1Typs[] ={
			"t1.micro", 
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"g2.2xlarge" , "g2.8xlarge" ,
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge"  };			

	private String usWest2Typs[] ={
			"t1.micro", 
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"cc2.8xlarge",
			"g2.2xlarge" , "g2.8xlarge" , 
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"x1.32xlarge",
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge",
			"cr1.8xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge" ,
			"hi1.4xlarge" };
	// orginal
	private String euWestTyps[] ={
			"t1.micro", 
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"cc2.8xlarge",
			"g2.2xlarge" , "g2.8xlarge" ,
			"cg1.4xlarge", 
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"x1.32xlarge",
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge",
			"cr1.8xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge" ,
			"hi1.4xlarge" };
	
	private String euCentralTyps[] ={
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"g2.2xlarge" , "g2.8xlarge" , 
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"x1.32xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge" , };
	
	

	private String apNortheast1Typs[] ={
			"t1.micro", 
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"cc2.8xlarge",
			"g2.2xlarge" , "g2.8xlarge" ,
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge",
			"cr1.8xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"hi1.4xlarge" };
	
	private String apNortheast2Typs[] ={
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge" ,};
	private String apSoutheast1Typs[] ={
			"t1.micro", 
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"g2.2xlarge" , "g2.8xlarge" ,
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge" };
	
	private String apSoutheast2Typs[] ={
			"t1.micro", 
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"g2.2xlarge" , "g2.8xlarge" ,
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge",
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge" };
	
	private String apSouthTyps[] ={
			"m4.large" , "m4.xlarge" , "m4.2xlarge" , "m4.4xlarge" , "m4.10xlarge" , 
			"c4.large" , "c4.xlarge" , "c4.2xlarge" , "c4.4xlarge" , "c4.8xlarge" , 
			"r3.large" , "r3.xlarge" , "r3.2xlarge" , "r3.4xlarge" , "r3.8xlarge" , 
			"d2.xlarge" ,"d2.2xlarge" , "d2.4xlarge" , "d2.8xlarge",
			"i2.xlarge" , "i2.2xlarge" , "i2.4xlarge" , "i2.8xlarge" };
	
	private String seEastTyps[] ={
			"t1.micro", 
			"m3.medium" , "m3.large" , "m3.xlarge" , "m3.2xlarge" , 
			"m1.small", "m1.medium", "m1.large", "m1.xlarge",
			"c3.large" ,"c3.xlarge" , "c3.2xlarge" , "c3.4xlarge" , "c3.8xlarge" ,
			"c1.medidum", "c1.xlarge", 
			"r3.4xlarge" , "r3.8xlarge" , 
			"m2.xlarge", "m2.2xlarge", "m2.4xlarge" };
}
