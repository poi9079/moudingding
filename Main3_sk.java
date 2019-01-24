import java.util.*;

public class Main3 {

	// create a private static data member of GRSData object
	// (You need to call the methods of GRSData when you find the average mark, median or
	//  best student(s) of a module


  	public static void main(String[] argv) {

		if (argv.length != 2) {
				System.out.println("Usage: java Main3 {average | median | beststudent} <module code>");
				System.exit(1);
		}

		// if the user wants to find the average mark of a module,
		// call the calculateModuleAverageMark method and show the result in DOS prompt

		// else if the user wants to find the median mark of a module,
		// call the calculateModuleMedian method and show the result in DOS prompt

		// else if the user wants to find the best students (may have more than 1 best student) of a module,
		// call the displayBestStudent method

    	// else show the message on how to run the program in DOS prompt and exit the program

  	}

  	public static double calculateModuleAverageMark(String mCode) {

		// return the average mark of a module (module code as input parameter "mCode")

  	}

  	public static double calculateModuleMedian(String mCode) {

		// return the median mark of a module (module code as input parameter "mCode")

  	}

  	public static void displayBestStudent(String mCode) {

    	// find the highest mark of a module (module code as input parameter "mCode")
		// then find the studentID(s) of student(s) with the highest mark
		// show the above information in DOS prompt

	}


}

class GRSData {

	private String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
	private String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
	private int[][] marks = { {30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
	                    {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
	                    {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
	                    {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669

   	public int[] getModuleMark(String mCode) {

		// return an array of marks for a module with given module code
		// (module code as input parameter "mCode").
  	}

  	public String getStudentID(int i) {

		// return student ID of the student with index i in array stduentID

  	}
}