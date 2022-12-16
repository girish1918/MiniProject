package com.miniproject;

import java.util.Scanner;

public class Driver {
	public void getSwitchCase()
	{
		display();
		CheckVerification cv=new CheckVerification();
		Scanner scan=new Scanner(System.in);
		System.out.print("Select your operation : ");
		int sel=scan.nextInt();
		switch(sel)
		{
		case 1:
			System.out.print("Enter Student id : ");
			int id=scan.nextInt();
			System.out.println("Enter Student Name : ");
			String name=scan.next();
			cv.getVerification(id, name);
			break;
		case 2:
			System.out.print("Enter Student id : ");
			int id1=scan.nextInt();
			System.out.println("Enter Student password");
			String pwd=scan.next();
			cv.getStudentData(id1, pwd);
			break;
		case 3:
			cv.getWholeData();
			break;
		}	
	}
	public void display()
	{
		System.out.println("\t\t\t\t************** Welcome to Quiz Competation ***************");
		System.out.println("Press 1 for Login");
		System.out.println("Pree 2 Get Student Data ");
		System.out.println("Pree 3 for Get  Whole Data");
		
	}
	public static void main(String[] args) {
		int v=1;
		Scanner sc=new Scanner(System.in);
		Driver dr=new Driver();
		
		while(v!=0)
		{
	
			dr.getSwitchCase();
			System.out.print("\n For Contine [Any Key] for Exit [0] :");
			v=sc.nextInt();
			System.out.println( );
			System.out.println("ThankYou for Completed Quiz Competation");
		}

	}
}
