
public class CargoPackage<T> {
	public int orderID;
	public String orderDate;
	@SuppressWarnings("unchecked")
	public T[] objectArray = (T[]) new Object[3]; //check
	

	public CargoPackage(int orderID, String orderDate, T[] objectArray) {
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.objectArray = objectArray;
	}
	
	
	
}
