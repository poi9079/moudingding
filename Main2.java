import java.util.*;

public class Main2 {
  // Test Data for the program
  	private static String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
	private static String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
	private static char[][] marks = { {'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
	                     {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
	                     {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
	                     {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'}}; // mark for ICT2669

  	public static void main(String[] argv) {
    	if (argv.length != 2) {
      		System.out.println("Usage: java Main2 {average | median | beststudent} module <module code>");
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
    	// numeric average mark is to be returned (since 'A' -> 5, 'B' -> 4, 'C' -> 3 etc..)

  	}

  	public static double calculateModuleMedian(String mCode) {

		// return the median mark of a module (module code as input parameter "mCode")
		// numeric median mark is to be returned (since 'A' -> 5, 'B' -> 4, 'C' -> 3 etc..)

  	}

  	public static void displayBestStudent(String mCode) {

    	// find the highest mark of a module (module code as input parameter "mCode")
		// then find the studentID(s) of student(s) with the highest mark
		// show the above information in DOS prompt

		// numeric highest mark is to be returned (since 'A' -> 5, 'B' -> 4, 'C' -> 3 etc..)

  	}



  	public static int getModuleIndex(String mCode) {

    	// return the index of a module (module code as input parameter "mCode") in the array of moduleCode

		// You may need to call this method when you want to find the average mark, the median
		// or the best student of a module.

  	}

  	public static int letterToNumeric(char grade) {

	    // convert and return a numeric mark from a grade (grade as input pararmeter "grade")

	    // you need to call this method before doing any calculations on marks

  	}
}