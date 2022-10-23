import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayStack<TunaCan> TunaCanPile = new ArrayStack<TunaCan>();
		ArrayStack<CornCan> CornCanPile = new ArrayStack<CornCan>();
		ArrayStack<PuddingPacket> PudingPacketPile = new ArrayStack<PuddingPacket>();
		ArrayStack<InstantNoodlePacket> InstantNoodlePacketPile = new ArrayStack<InstantNoodlePacket>();

		for (int i = 0; i<=30; i++) {
			
			TunaCan TunaCanitem = new TunaCan(-i);
			TunaCanPile.push(TunaCanitem);
			CornCan CornCanitem = new CornCan(-i);
			CornCanPile.push(CornCanitem);
			PuddingPacket PudingPacketitem = new PuddingPacket(-i);
			PudingPacketPile.push(PudingPacketitem);
			InstantNoodlePacket InstantNoodleitem = new InstantNoodlePacket(-i);
			InstantNoodlePacketPile.push(InstantNoodleitem);
			//show stack items
		}
		System.out.println("before processing the orders\nTUNACANPILE");
		
		for (int i = 0; i <= 29; i++) {
			System.out.println("drained weight:" + TunaCanPile.returnTunaCanItems()[i].drainedWeigth + " netweight:"
					+ TunaCanPile.returnTunaCanItems()[i].netWeight + " Ingredients:" +
					TunaCanPile.returnTunaCanItems()[i].Ingredients + " expiration date:" +
					TunaCanPile.returnTunaCanItems()[i].expirationDate);
		}
		System.out.println("CORNCANPILE");
		for (int i = 0; i <= 29; i++) {
			System.out.println("drained weight:" + CornCanPile.returnCornCanItems()[i].drainedWeight + " net Weight:"
					+ CornCanPile.returnCornCanItems()[i].netWeight + " production country:" +
					CornCanPile.returnCornCanItems()[i].productionCountry + " expiration date:" +
					CornCanPile.returnCornCanItems()[i].expirationDate);
		}
		System.out.println("PUDDINGPACKETPILE");
		for (int i = 0; i <= 29; i++) {
			System.out.println("flavor:" + PudingPacketPile.returnPuddingPacketItems()[i].flavor + " net weight: "
					+ PudingPacketPile.returnPuddingPacketItems()[i].netWeight + " expiration date: " +
					PudingPacketPile.returnPuddingPacketItems()[i].expirationDate);
		}
		System.out.println("INSTANTNOODLEPILE");
		for (int i = 0; i <= 29; i++) {
			System.out.println("simmer duration:" + InstantNoodlePacketPile.returnInstantNoodleItems()[i].simmerDuration + " net Weight: "
					+ InstantNoodlePacketPile.returnInstantNoodleItems()[i].netWeight + " expiration date: " +
					InstantNoodlePacketPile.returnInstantNoodleItems()[i].expirationDate);
		}
		//parse csv lines
		String file = "src//orders.csv";
		BufferedReader reader = null;
		String line = "";
		
		Queue orderQueue = new Queue();
		reader = new BufferedReader(new FileReader(file));
		while((line = reader.readLine()) != null) {
			String[] row = line.split(",");
			Order OrderObject = new Order();
			OrderObject.OrderID = Integer.parseInt(row[0]);
			OrderObject.OrderDate = row[1];	
			OrderObject.foodCategory[0] = row[2];
			OrderObject.foodCategory[1] = row[3];
			OrderObject.foodCategory[2] = row[4];
			//split csv lines create order objects
			orderQueue.enqueue(OrderObject);
			

				
				
			}
			reader.close();
			System.out.println("QUEUE BEFORE PROCESSING ORDERS");
			orderQueue.printObjects();
			ArrayList cargoPacketList = new ArrayList();
			for (int i = 0; i<=29; i++) {
				
				int index = 0;
				Object[] object = new Object[3];
				Order orderobject = orderQueue.dequeue();

				
				
				if (orderobject.foodCategory[0].contains("tuna") ||
				orderobject.foodCategory[1].contains("tuna") ||
				orderobject.foodCategory[2].contains("tuna") ) {
					
					object[index] = TunaCanPile.pop();
					index++;
				}
				if (orderobject.foodCategory[0].contains("corn") ||
					orderobject.foodCategory[1].contains("corn") ||
					orderobject.foodCategory[2].contains("corn") ) {
					object[index] = CornCanPile.pop();
					index++;
						}
				if (orderobject.foodCategory[0].contains("pudding") ||
					orderobject.foodCategory[1].contains("pudding") ||
					orderobject.foodCategory[2].contains("pudding") ) {
					object[index] = PudingPacketPile.pop();
					index++;
								}
				if (orderobject.foodCategory[0].contains("noodle") ||
					orderobject.foodCategory[1].contains("noodle") ||
					orderobject.foodCategory[2].contains("noodle") ) {
					object[index] = InstantNoodlePacketPile.pop();
					index++;
					}
				index = 0;
				
				CargoPackage cargopackage = new CargoPackage(orderobject.OrderID, orderobject.OrderDate, object);
				cargoPacketList.insert(cargopackage.orderID, cargopackage);
				
			}
			System.out.println("DISPLAYING LIST OF CARGO ITEMS");
			cargoPacketList.displayCargoItems();
			System.out.println("PILES AFTER PROCESSING THE ORDERS\nTUNACANPILE");
			for (int i = 0; i <= TunaCanPile.numberOfItems()-1; i++) {
				System.out.println("drained weight:" + TunaCanPile.returnTunaCanItems()[i].drainedWeigth + " net Weight:"
						+ TunaCanPile.returnTunaCanItems()[i].netWeight + " Ingredients:" +
						TunaCanPile.returnTunaCanItems()[i].Ingredients + " expiration Date:" +
						TunaCanPile.returnTunaCanItems()[i].expirationDate);
			}
			System.out.println("CORNCANPILE");
			System.out.println("Pile is empty");
			for (int i = 0; i <= CornCanPile.numberOfItems() - 1; i++) {
				System.out.println("drained weight:" + CornCanPile.returnCornCanItems()[i].drainedWeight + " net Weight:"
						+ CornCanPile.returnCornCanItems()[i].netWeight + " production country:" +
						CornCanPile.returnCornCanItems()[i].productionCountry + " expiration Date:" +
						CornCanPile.returnCornCanItems()[i].expirationDate);
			}
			
			System.out.println("PUDDINGPACKETPILE");
			for (int i = 0; i <= PudingPacketPile.numberOfItems() - 1; i++) {
				System.out.println("flavor:" + PudingPacketPile.returnPuddingPacketItems()[i].flavor + " net Weight:"
						+ PudingPacketPile.returnPuddingPacketItems()[i].netWeight + " expiration Date:" +
						PudingPacketPile.returnPuddingPacketItems()[i].expirationDate);
			}
			System.out.println("INSTANTNOODLEPILE");
			for (int i = 0; i <= InstantNoodlePacketPile.numberOfItems() - 1; i++) {
				System.out.println("simmer duration:" + InstantNoodlePacketPile.returnInstantNoodleItems()[i].simmerDuration + " net Weight:"
						+ InstantNoodlePacketPile.returnInstantNoodleItems()[i].netWeight + " expiration Date:" +
						InstantNoodlePacketPile.returnInstantNoodleItems()[i].expirationDate);
			}
			System.out.println("displaying expiration dates of the packaged products with ID 25");
			cargoPacketList.displayCargoItem(25);
			cargoPacketList.remove(20);
			System.out.println("displaying list's contents after removing item with ID 20");
			cargoPacketList.displayCargoItems();
		
	}

}
