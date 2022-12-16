package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckVerification {
	ConnectionStud cs = new ConnectionStud();
	public void getVerification(int id, String name) {
		
		try {
			Connection con = cs.getConnectionDetails();
			PreparedStatement pps = con.prepareStatement("Select * from studentquiz");
			ResultSet rs = pps.executeQuery();
			while (rs.next()) {
//				if ((rs.getString(2)!=name)||(rs.getInt(1)!=id)) { // Use exception handling
//					System.err.println(" Invalid Id or Name.Please enter valid details");
//					return;
//				}
				 if ((rs.getInt(4)!=-1)&& (rs.getInt(1)==id)) { // Use exception handling
					System.err.println(" Sorry !!You are already given exam.");
					return;
				}
			}
			Quiz q = new Quiz();
			
			q.getQuizTest(id);
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getStudentData(int id,String password)
	{
		ConnectionStud cs = new ConnectionStud();
		try {
			Connection con = cs.getConnectionDetails();
			PreparedStatement pps = con.prepareStatement("Select * from studentquiz where stud_id=?");
			pps.setInt(1, id);
			ResultSet rs = pps.executeQuery();
			while(rs.next())
			{
				if((rs.getInt(1)==id)&& (rs.getString(3).equals(password)))
				{
					System.out.print("Name ="+rs.getString(2));
					System.out.print("\tScore = "+rs.getInt(4));
					System.out.print("\tGrade ="+rs.getString(5));
					System.out.println();
					return;
				}
			}
			System.err.println("Invalid id or password.");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/*public static void main(String[] args) {
		CheckVerification ac = new CheckVerification();
		ac.getVerification(4, "ken");
		ac.getStudentData(3,"ken123" );
	}*/
	public void getWholeData()
	{
		Connection con = cs.getConnectionDetails();
		try {
			
			PreparedStatement pps = con.prepareStatement("Select stud_name,stud_score,stud_grade from studentquiz order by stud_score desc");
			ResultSet rs = pps.executeQuery();
			while(rs.next())
			{

				System.out.print("Name ="+rs.getString(1));
				System.out.print("\tScore = "+rs.getInt(2));
				System.out.print("\tGrade ="+rs.getString(3));
				System.out.println();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
