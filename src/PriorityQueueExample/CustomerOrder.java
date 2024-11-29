package PriorityQueueExample;

public class CustomerOrder implements Comparable<CustomerOrder>{
	private int orderId;
    private double orderAmount;
    private String customerName;
    private boolean isEmergency; // New field for emergency cases
    private long timestamp;      // Keeps track of the order of arrival

    public CustomerOrder(int orderId, double orderAmount, String customerName, boolean isEmergency, long timestamp) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.customerName = customerName;
        this.isEmergency = isEmergency;
        this.timestamp = timestamp;
    }

//    @Override
//    public int compareTo(CustomerOrder o) {
//        return o.orderId > this.orderId ? 1 : -1;
//    }
    
//    //method to make the queue in ascending order meaning the first one will go out first
//    @Override
//    public int compareTo(CustomerOrder o) {
//        return Integer.compare(this.orderId, o.orderId);
//    }
    
    
    //changed to giving patients that are emergency for having priority
    @Override
    public int compareTo(CustomerOrder o) {
        // Emergency patients have the highest priority
        if (this.isEmergency && !o.isEmergency) {
            return -1;
        } else if (!this.isEmergency && o.isEmergency) {
            return 1;
        }
        // If both are emergencies or neither are, compare by orderId (or another metric)
        return Integer.compare(this.orderId, o.orderId);
    }

    @Override
    public String toString() {
        return "orderId:" + this.orderId + ", orderAmount:" + this.orderAmount + ", customerName:" + customerName + ", timestamp=" + timestamp +
                '}';
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}

