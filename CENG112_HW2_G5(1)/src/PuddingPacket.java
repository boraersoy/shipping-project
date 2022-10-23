import java.time.LocalDate;

public class PuddingPacket {
	public final int netWeight = 120; //grams
	public final String flavor = "banana";
	public String expirationDate = null;
	public final String name = "pudding";
	
	public PuddingPacket(int Months)	{
		LocalDate date = LocalDate.of(2024, 12, 01);
		expirationDate = date.plusMonths(Months).toString();
		
	}
	public String getPuddingInfo() {
		return (netWeight + " " + flavor + " " + expirationDate ); 
	}
	
	public String getPuddingName() {
		return name;
	}
	public String getExpirationDate() {
		return expirationDate;
	}

}
