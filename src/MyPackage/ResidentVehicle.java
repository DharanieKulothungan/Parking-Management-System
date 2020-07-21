package MyPackage;

public class ResidentVehicle extends Vehicle
{
	
	private int flatNumber;
    private boolean parkingStatus;

    public ResidentVehicle()
    {
    	flatNumber = 0;
    	parkingStatus = true;
    }
    public int getFlatNumber()
    {
		return flatNumber;
	} 
	public void setFlatNumber(int flatNumber) 
	{
		this.flatNumber = flatNumber;
	}
	public boolean isParkingStatus()
	{
		return parkingStatus;
	}
	public void setParkingStatus(boolean parkingStatus) 
	{
		this.parkingStatus = parkingStatus;
	}
	
	public ResidentVehicle(String regNumber, String ownerName, long mobileNumber, int flatNumber,
			boolean parkingStatus) 
	{
		super(regNumber, ownerName, mobileNumber);
		this.flatNumber = flatNumber;
		this.parkingStatus = parkingStatus;
	} 
}
