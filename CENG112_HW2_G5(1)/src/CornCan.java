import java.time.LocalDate;

public class CornCan {
	public final int netWeight = 220;
	public final int drainedWeight = 132;
	public final String productionCountry = "turkey";
	public String expirationDate = null;
	public final String name = "corn";
	
	public CornCan(int Months)	{
		LocalDate date = LocalDate.of(2024, 12, 01);
		expirationDate = date.plusMonths(Months).toString();
		
	}
	public String cornGetInfo() {
		return (netWeight + " " + drainedWeight + " " + productionCountry
				+ " " + expirationDate);
	}

	public String CorngetName() {
		return (name);
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	
}
