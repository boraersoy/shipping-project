
public class Queue {
	private final int DEFAULT_CAPACITY = 31;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private Order[] QueueArray = new Order[this.DEFAULT_CAPACITY];
	

	public void enqueue(Order entry) {
		//ensureCapacity();
		backIndex++;
		QueueArray[backIndex] = entry;
	}
	public Order dequeue() {
		Order front = QueueArray[frontIndex+1];
		QueueArray[frontIndex+1] = null;
		frontIndex++;
		return front;
		
		
	}
	public Order getFront() {
		return QueueArray[frontIndex+1];
	}
	public Order getItem(int index) {
		return QueueArray[index];
	}
	public void printObjects() {
	for (int i = 1; i <= 30; i++) {
		System.out.println("Order ID:" + QueueArray[i].OrderID + " Order Date:" + 
				QueueArray[i].OrderDate + " Order items: " +
				QueueArray[i].foodCategory[0] + " " +
				QueueArray[i].foodCategory[1] + " " +
				QueueArray[i].foodCategory[2]);
	}
		}

}
