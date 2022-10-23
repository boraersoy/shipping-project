import java.time.LocalDate;

public class InstantNoodlePacket {
	public final int netWeight = 120;
	public final int simmerDuration = 3; //mins
	public String expirationDate = null;
	public final String name = "noodle";
	
	public InstantNoodlePacket(int Months)	{
		LocalDate date = LocalDate.of(2024, 12, 01);
		expirationDate = date.plusMonths(Months).toString();
		
	}
	public String noodlegetInfo() {
		return (netWeight + " " + simmerDuration + " " +  expirationDate);
	}
	public String getNoodleName() {
		return name;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	
}
