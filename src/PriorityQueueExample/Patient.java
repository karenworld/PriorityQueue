package PriorityQueueExample;

public class Patient {

	private int patientPriority;
	private String patientName;
	private int patientId;
	private boolean isEmergency; // New field for emergency priority

	public Patient(int id, String name, int priority, boolean isEmergency) {
		this.patientName = name;
		this.patientPriority = priority;
		this.patientId = id;
		this.isEmergency = isEmergency;
	}

	public int getPriority() {

		return patientPriority;
	}

	public boolean isEmergency() {
		return isEmergency;
	}

	public int getId() {

		return patientId;
	}

	public String getName() {

		return patientName;
	}
}
