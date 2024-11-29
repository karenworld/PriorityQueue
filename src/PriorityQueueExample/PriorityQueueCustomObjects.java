package PriorityQueueExample;

import java.time.Instant;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueCustomObjects {
	public static void main(String[] args) {
        testPriorityQueueCustomObjects();
    }

    /**
     * Function to show how a priority queue works with Custom Objects
     */
    private static void testPriorityQueueCustomObjects() {
    	long time1 = Instant.parse("2024-12-03T10:00:00Z").toEpochMilli();
        long time2 = Instant.parse("2024-12-03T10:05:00Z").toEpochMilli();
        long time3 = Instant.parse("2024-12-03T10:10:00Z").toEpochMilli();
        long time4 = Instant.parse("2024-12-03T10:15:00Z").toEpochMilli();
        CustomerOrder c1 = new CustomerOrder(1, 100.0, "customer1", false, time1);
        CustomerOrder c2 = new CustomerOrder(3, 50.0, "customer3", true, time2);
        CustomerOrder c3 = new CustomerOrder(2, 300.0, "customer2", false, time3);

        Queue<CustomerOrder> customerOrders = new PriorityQueue<>();
        customerOrders.add(c1);
        customerOrders.add(c2);
        customerOrders.add(c3);
        while (!customerOrders.isEmpty()) {
            System.out.println(customerOrders.poll());
        }
    }
}

//output
//
//orderId:3, orderAmount:50.0, customerName:customer3
//orderId:2, orderAmount:300.0, customerName:customer2
//orderId:1, orderAmount:100.0, customerName:customer1

//output according to ascending order
//orderId:1, orderAmount:100.0, customerName:customer1
//orderId:2, orderAmount:300.0, customerName:customer2
//orderId:3, orderAmount:50.0, customerName:customer3
