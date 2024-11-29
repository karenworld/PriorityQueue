package PriorityQueueExample;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class SQLiteExample {
	    public static void main(String[] args) {
	        String jdbcUrl = "jdbc:sqlite:customer_orders.db"; // File-based SQLite DB

	        try (Connection conn = DriverManager.getConnection(jdbcUrl)) {
	            // Create table
	            String createTableSQL = "CREATE TABLE IF NOT EXISTS CustomerOrders (" +
	                                    "order_id INTEGER PRIMARY KEY, " +
	                                    "order_amount REAL, " +
	                                    "customer_name TEXT, " +
	                                    "is_emergency BOOLEAN, " +
	                                    "order_timestamp INTEGER)";
	            conn.createStatement().execute(createTableSQL);

	            // Insert data
	            String insertSQL = "INSERT INTO CustomerOrders (order_id, order_amount, customer_name, is_emergency, order_timestamp) " +
	                               "VALUES (?, ?, ?, ?, ?)";
	            try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
	                stmt.setInt(1, 1);
	                stmt.setDouble(2, 100.0);
	                stmt.setString(3, "customer1");
	                stmt.setBoolean(4, false);
	                stmt.setLong(5, 1733220300000L);  // Example timestamp
	                stmt.executeUpdate();
	            }

	            // Query data
	            String selectSQL = "SELECT * FROM CustomerOrders";
	            try (PreparedStatement stmt = conn.prepareStatement(selectSQL);
	                 ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    System.out.println("Order ID: " + rs.getInt("order_id"));
	                    System.out.println("Amount: " + rs.getDouble("order_amount"));
	                    System.out.println("Customer: " + rs.getString("customer_name"));
	                    System.out.println("Emergency: " + rs.getBoolean("is_emergency"));
	                    System.out.println("Timestamp: " + rs.getLong("order_timestamp"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


