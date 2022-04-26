package ElectroGrid.UserManagement.constant;

public class UserUsageInformationConstant {
	public static String GETALLUSERUSAGEINFORMATION = "select userName,address,noOfUnit,month from userpowerusageinformation";
	public static String CREATEUSERUSAGEINFORMATION = "insert into userpowerusageinformation values (?,?,?,?,?)";
	public static String GETUSERUSAGEINFORMATIONBYID = "SELECT * FROM userpowerusageinformation WHERE usageID = ?";
	public static String UPDATEUSERUSAGEINFORMATION = "UPDATE userpowerusageinformation SET usageID = ? , userName = ? , address = ? , noOfUnit = ? , month = ? WHERE usageID = ?";
	public static String DELETEUSERUSAGEINFORMATION = "DELETE FROM userpowerusageinformation WHERE usageID = ?";

}
