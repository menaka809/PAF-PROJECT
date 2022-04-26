package ElectroGrid.UserManagement.modal;

public class UserUsageInformation {
	
	private int usageID;
	private String userName;
	private String address;
	private int noOfUnit;
	private String month;
	
	public UserUsageInformation() {
		super();
	}

	public UserUsageInformation(int usageID, String userName, String address, int noOfUnit, String month) {
		super();
		this.usageID = usageID;
		this.userName = userName;
		this.address = address;
		this.noOfUnit = noOfUnit;
		this.month = month;
	}

	public int getUsageID() {
		return usageID;
	}

	public void setUsageID(int usageID) {
		this.usageID = usageID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNoOfUnit() {
		return noOfUnit;
	}

	public void setNoOfUnit(int noOfUnit) {
		this.noOfUnit = noOfUnit;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	
	

}
