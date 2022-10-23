import java.time.LocalDate;
import java.time.Month;

public class TunaCan {
	public final int netWeight = 75;
	public final int drainedWeigth = 50;
	public final String Ingredients = "tuna,sunflower oil,salt";
	public  String expirationDate = null;
	public final String name = "tuna";
	
	public TunaCan(int Months)	{
		LocalDate date = LocalDate.of(2024, 12, 01);
		expirationDate = date.plusMonths(Months).toString();
		
	}
	public String getTunaInfo() {
		return (netWeight + " " + drainedWeigth + " " + Ingredients + " " + expirationDate);
			
	}
	public String getTunaName() {
		return name;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	
}
