package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quiz {
	int correctAns = 0;
	int wrongAns = 0;

	// b,a,d,c,b,c,a,b,c,c
	public  void getQuizTest(int id) {
		Question q1 = new Question("'Who is founder of java?", "a.Van Rossum", "b.James Gosling", "c.Dennis Ritchie",
				"d.Bjarne Stroustrup");
		Question q2 = new Question("When java was invented?", "a.1995", "b.1996", "c.1918", "d.1999");
		Question q3 = new Question("How many pillars of Oops concept?", "a.3", "b.2", "c.5", "d.4");
		Question q4 = new Question("How many methods in object class?", "a.13", "b.12", "c.11", "d.15");
		Question q5 = new Question("String is the class that represents sequence of……", "a.Object", "b.Character",
				"c.Class", "d.Array");
		Question q6 = new Question("Number of primitive data types in java are?", "a.6", "b.7", "c.8", "d.9");
		Question q7 = new Question("What is size of float and double in java?", "a.32 & 64", "b.32 & 32", "c.64 & 64",
				"d.64 & 32");
		Question q8 = new Question("Array in java are…", "a.Object reference", "b.Objects", "c.Primitive data type",
				"d.None");
		Question q9 = new Question("CompareTo() returns", "a.True", "b.False", "c.An int value", "d.None");
		Question q10 = new Question("Total constructor string class have?", "a.3", "b.7", "c.13", "d.20");

		HashMap<Question, Character> hm = new HashMap<>();
		hm.put(q1, 'b');
		hm.put(q2, 'a');
		hm.put(q3, 'd');
		hm.put(q4, 'c');
		hm.put(q5, 'b');
		hm.put(q6, 'c');
		hm.put(q7, 'a');
		hm.put(q8, 'b');
		hm.put(q9, 'c');
		hm.put(q10, 'c');

		int q=1;
		

		for (Map.Entry<Question, Character> map : hm.entrySet()) {
			System.out.println(q+") "+map.getKey().getQuestion());
			System.out.println(map.getKey().getOpt_1());
			System.out.println(map.getKey().getOpt_2());
			System.out.println(map.getKey().getOpt_3());
			System.out.println(map.getKey().getOpt_4());
			q++;

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Answer: ");
			Character ans = sc.next().charAt(0);

			int cans = Character.compare(ans, map.getValue());
			if (cans == 0) {

				correctAns++;

			} 
		}
		System.out.println();
		System.out.println("\t\t\t\t***************Result****************\n");
		System.out.println("Total Questions: " + hm.size());
		System.out.println("Correct Answered Questions : " + correctAns);

		int Score = correctAns;

		if (Score > 8) {
			System.out.println("Garde : A");
			setStudentDetails( id,Score, "A");
		} else if (Score >= 5 && Score <= 8) {
			System.out.println("Grade : B");
			setStudentDetails( id,Score, "B");
		} else if (Score == 5) {
			System.out.println("Grade : C");
			setStudentDetails( id,Score, "C");
		} else {
			System.out.println(" Student Result--Fail");
			setStudentDetails( id,Score, "Fail");

		}

	}

	public void setStudentDetails(int id, int score, String grade) {
		ConnectionStud cs = new ConnectionStud();
		try {
			Connection con = cs.getConnectionDetails();
			PreparedStatement ps = con
					.prepareStatement("update studentquiz set stud_score=?,stud_grade=? where stud_id=?");
			
			ps.setInt(1, score);
			ps.setString(2, grade);
			ps.setInt(3,id);
			
			//PreparedStatement ps1=con.prepareStatement("");
			int rs = ps.executeUpdate();
			

	
		
	}
	
		catch(Exception e) {
			
		}
		
	}
	/*public static void main(String[] args) {
		Quiz q=new Quiz();
		q.getQuizTest(1);*/
		
}
