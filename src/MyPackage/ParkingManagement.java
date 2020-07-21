package MyPackage;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ParkingManagement 
{
	 static List<Vehicle> allVehicles = new ArrayList<Vehicle>();
		public static void main(String[] args)throws IOException
		{
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
			   
	                   ResidentVehicle residentvehicle[] = new ResidentVehicle[3];
	                    residentvehicle[0] = new ResidentVehicle("TN49A2222","Senthil",1212121212,201,true);
	                    residentvehicle[1] = new ResidentVehicle("TN49B4444","Ragavan",1414141414,202,false);
	                    residentvehicle[2] = new ResidentVehicle("TN49C6666","Srimathi",1616161616,203,true); 

	                    VisitorVehicle visitorvehicle[] = new VisitorVehicle[3];
	                    visitorvehicle[0] = new VisitorVehicle("TN49A2222","Senthil",1212121212,201,9);
	                    visitorvehicle[1] = new VisitorVehicle("TN49B4444","Ragavan",1414141414,202,8);
	                    visitorvehicle[2] = new VisitorVehicle("TN49C6666","Srimathi",1616161616,203,15); 
	                    
	                    for(int i = 0 ; i < 3 ; i++)
	                    {
	                       if(residentvehicle[i].isParkingStatus())
	                    	 System.out.println(addVehicle(residentvehicle[i]));
	                    }
	                         
	                    for(int i = 0 ; i < 3 ; i++)
	                         System.out.println(addVehicle(visitorvehicle[i]));
	                    
	                    /*int f = 0;
		                  do
		                  {
		                	  try
		                	  {
		                	   f = 0;
		                	   System.out.println("Press '1' --> ResidentVehicle");
		                	   System.out.println("Press '2' --> VisitorVehicle");
		                	   System.out.println("Press '3' --> To Exit ");
		                	   int choice = Integer.parseInt(bufferedreader.readLine());
		                	   
		                	    switch(choice)
		                	    {
		                	    case 1:
		                	    {
		                	    	ResidentVehicle residentvehicle1 = new ResidentVehicle();
	 
		                	    	System.out.println("Enter reg Number , Owner Name , mobile Number , Flat Number , Parking Status : ");
		                	    	String regNumber = bufferedreader.readLine();
		                	    	residentvehicle1.setRegNumber(regNumber);
		                	    	String ownerName = bufferedreader.readLine();
		                	    	residentvehicle1.setOwnerName(ownerName);
		                	    	long mobileNumber = Long.parseLong(bufferedreader.readLine());
		                	    	residentvehicle1.setMobileNumber(mobileNumber);
		                	    	int flatNumber = Integer.parseInt(bufferedreader.readLine());
		                	    	residentvehicle1.setFlatNumber(flatNumber);
		                	    	boolean parkingStatus = Boolean.parseBoolean(bufferedreader.readLine());
		                	    	residentvehicle1.setParkingStatus(parkingStatus);
		                	    	if(residentvehicle1.isParkingStatus())
		                	           System.out.println(addVehicle(residentvehicle1));
		                	    	break;
		                	    }
		                	    case 2:
		                	    {
		                	    	VisitorVehicle visitorvehicle1 = new VisitorVehicle();
		                	    	System.out.println("Enter reg Number , Owner Name , mobile Number , Visiting flat Number , in Time : ");
		                	    	String regNumber = bufferedreader.readLine();
		                	    	visitorvehicle1.setRegNumber(regNumber);
		                	    	String ownerName = bufferedreader.readLine();
		                	    	visitorvehicle1.setOwnerName(ownerName);
		                	    	long mobileNumber = Long.parseLong(bufferedreader.readLine());
		                	    	visitorvehicle1.setMobileNumber(mobileNumber);
		                	    	int visitingFlatNumber = Integer.parseInt(bufferedreader.readLine());
		                	    	visitorvehicle1.setVisitingFlatNumber(visitingFlatNumber);
		                	    	int inTime = Integer.parseInt(bufferedreader.readLine());
		                	    	visitorvehicle1.setInTime(inTime);
		                	    	
		                	    	System.out.println(addVehicle(visitorvehicle1));
		                	    	break;
		                	    }
		                	    case 3:
		                	    {
		                	    	System.out.println("Exit");
		                	    	f  = 1;
		                	    	break;
		                	    }
		                	    default:
		                	    	System.out.println("Invalid Choice");
		                	    }
		                	  }
		                	  catch(NumberFormatException nf)
		                	  {
		                		  System.out.println("Enter values with Exact datatype");
		                	  }
		                  }while(f != 1);

		                  */
	                 int n = 0;
	                  do
	                  {
	                	try
	                	{
	                    System.out.println("If you want to update Vehicle's out time ? ");
          	    	    System.out.println("Press '1' --> for yes");
          	    	    System.out.println("Press '2' --> for Exit");
          	    	    n = Integer.parseInt(bufferedreader.readLine());
          	         	if(n == 1)
          	         	{
          	    	       System.out.println("Enter Vehicle's reg Number and OutTime :");
          	               String regNumber = bufferedreader.readLine();
          	               int outTime = Integer.parseInt(bufferedreader.readLine());
          	               if(outTime >=0  && outTime <=24)
          	               System.out.println(setVisitorVehicleOutTime(regNumber,outTime));
          	               else
          	            	 System.out.println("Enter Correct Timing");
	                    }
	                	}
	                	catch(NumberFormatException nf)
	                	{
	                		System.out.println("Warning : Enter a number");
	                	}
	                  }while(n != 2);
	                   System.out.println("Number of Resident Vehicle Parked ? "+getParkedResidentVehicleCount());
	                   displayAllVehicles();
	                  
		}
		public static String addVehicle(Vehicle v)
		{
		     int n = allVehicles.size();
	          if( n < 10)
             {
	                                  allVehicles.add(v);
			                          return "Vehicle parked at Parking Slot no : "+ ++n ;
		       }
	           else
	           {
	                                    try
	                                    {
	                                             throw new ParkingSlotNotAvailableException("No Parking Slots Available");
	                                     }
	                                      catch(ParkingSlotNotAvailableException pe)
	                                      {}
	 
	                              }
	                           
	                          return " ";
	               }
		public static String setVisitorVehicleOutTime(String regNumber , int outTime)
		{
	                       int f = 0;
	                       for(Vehicle v : allVehicles)
	                       {
	                              if(v instanceof VisitorVehicle && v.getRegNumber().equals(regNumber))
	                              {
	                                  VisitorVehicle VV = (VisitorVehicle)v;
	                                   f = 1;
	                                        VV.setOutTime(outTime);
	                                        return "Vehicle with reg Number : "+ VV.getRegNumber() + " updated Successfully";
	                               }
	                       }
	                       if(f == 0)
	                       {
	                           try{ throw new VehicleNotFoundException ("Searched Vehicle Not Found : "+regNumber);}
	                          catch(VehicleNotFoundException vf){}
	                       }
	                       return "";        
		 }
		public static int getParkedResidentVehicleCount()
		{
			int count = 0;
			for(Vehicle v : allVehicles)
	         {
	                 if(v instanceof ResidentVehicle)
	                  {
	                        ResidentVehicle rv = (ResidentVehicle)v;
	                        if(rv.isParkingStatus() == true)
	                                count++;
	                   }
	          }

			return count;
		}
		public static void displayAllVehicles()
		{
	                     for(Vehicle v : allVehicles)
	                       System.out.println(v.getRegNumber() + "\t" + v.getOwnerName() + "\t\t" + v.getMobileNumber() );
		}
		
	 
}
