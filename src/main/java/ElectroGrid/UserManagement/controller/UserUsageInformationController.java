package ElectroGrid.UserManagement.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ElectroGrid.UserManagement.constant.Constant;
import ElectroGrid.UserManagement.constant.UserUsageInformationConstant;
import ElectroGrid.UserManagement.modal.UserUsageInformation;
import ElectroGrid.UserManagement.util.DatabaseConnection;

public class UserUsageInformationController {
	
	//get all
			public static ArrayList<UserUsageInformation> getUserUsageInformation() throws ClassNotFoundException, SQLException {
				ArrayList<UserUsageInformation> plist = new ArrayList<>();
				String getQury = UserUsageInformationConstant.GETALLUSERUSAGEINFORMATION;
				Connection con = DatabaseConnection.getConnection();

				PreparedStatement preparedStatement = con.prepareStatement(getQury);
				ResultSet rs = preparedStatement.executeQuery();

				while(rs.next()) {
					UserUsageInformation usageInformation = new UserUsageInformation();
					usageInformation.setUserName(rs.getString(Constant.INDEX_ONE));
					usageInformation.setAddress(rs.getString(Constant.INDEX_TWO));
					usageInformation.setNoOfUnit(rs.getInt(Constant.INDEX_TREE));
					usageInformation.setMonth(rs.getString(Constant.INDEX_FOUR));
					
					


					plist.add(usageInformation);
				}
				return plist;

			}
			
			
			//create
			public static UserUsageInformation createUserUsageInformation(UserUsageInformation usageInformation) throws SQLException, ClassNotFoundException {
				String CreateQury =UserUsageInformationConstant.CREATEUSERUSAGEINFORMATION;
				Connection con = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
				preparedStatement.setInt(Constant.INDEX_ONE,usageInformation.getUsageID());
				preparedStatement.setString(Constant.INDEX_TWO, usageInformation.getUserName());
				preparedStatement.setString(Constant.INDEX_TREE, usageInformation.getAddress());
				preparedStatement.setInt(Constant.INDEX_FOUR, usageInformation.getNoOfUnit());
				preparedStatement.setString(Constant.INDEX_FIVE, usageInformation.getMonth());

				
						  
				boolean isCreate = preparedStatement.execute();
			    if(!isCreate) {
			    	return usageInformation;
				}
				else {
					return null;
				}
			}
			
			//get by ID
			
			public static UserUsageInformation getUserUsageInformationByID(int infId) throws SQLException, ClassNotFoundException {
				
				String getdata_query = UserUsageInformationConstant.GETUSERUSAGEINFORMATIONBYID;
				Connection con = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
						
				UserUsageInformation usageInformation = null;
						
				preparedStatement.setInt(Constant.INDEX_ONE, infId);
						
				ResultSet rs = preparedStatement.executeQuery();
						
				while(rs.next()) {
					int usageID = rs.getInt(Constant.INDEX_ONE);
					String userName = rs.getString(Constant.INDEX_TWO);
					String address = rs.getString(Constant.INDEX_TREE);
					int noOfUnit = rs.getInt(Constant.INDEX_FOUR);
					String month = rs.getString(Constant.INDEX_FIVE);
					

					usageInformation = new UserUsageInformation(usageID, userName, address, noOfUnit, month);
				}
				return usageInformation;
						
			}
			
			//Update
			public static UserUsageInformation updateUserUsageInformation(UserUsageInformation usageInformation,int infId) throws SQLException, ClassNotFoundException {
				
//				String update_query = UserUsageInformationConstant.UPDATEUSERUSAGEINFORMATION;
				String update_query = "UPDATE userpowerusageinformation SET usageID = ? , userName = ? , address = ? , noOfUnit = ? , month = ? WHERE usageID ='"+infId+"'";
				Connection con = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
				preparedStatement.setInt(Constant.INDEX_ONE, usageInformation.getUsageID());
				preparedStatement.setString(Constant.INDEX_TWO, usageInformation.getUserName());
				preparedStatement.setString(Constant.INDEX_TREE, usageInformation.getAddress());
				preparedStatement.setInt(Constant.INDEX_FOUR, usageInformation.getNoOfUnit());
				preparedStatement.setString(Constant.INDEX_FIVE, usageInformation.getMonth());
				

				
////				preparedStatement.setInt(Constant.INDEX_TEN, infId); //ask
//						
				if(preparedStatement.executeUpdate() > 0) {
					return getUserUsageInformationByID(infId); //ask
				}
				else {
					return null;
				}
						
			}
			
			//Delete
			public static boolean deleteUserUsageInformation(int infId) throws SQLException, ClassNotFoundException {
				
				String delete_query = UserUsageInformationConstant.DELETEUSERUSAGEINFORMATION;
				Connection con = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(delete_query);
						
				preparedStatement.setInt(Constant.INDEX_ONE, infId);
				boolean isDeleted = preparedStatement.execute();
						
				return isDeleted;
						
			}



}
