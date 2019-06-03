package nicservice;

public class NIC {
	private int id;
	private String NIC;
	private boolean isGovernmentEmployee;
	
	public NIC() {}
	
	public NIC(int id, String NIC, boolean isGovernmentEmployee) {
		this.id = id;
		this.NIC = NIC;
		this.isGovernmentEmployee = isGovernmentEmployee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public boolean getGovernmentEmployee() {
		return isGovernmentEmployee;
	}

	public void setGovernmentEmployee(boolean isGovernmentEmployee) {
		this.isGovernmentEmployee = isGovernmentEmployee;
	}

}
