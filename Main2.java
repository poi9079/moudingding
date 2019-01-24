import java.util.*;

public class Main2 {
    // Test Data for the program
    private static String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    private static String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static char[][] marks = {{'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
            {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
            {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
            {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'}}; // mark for ICT2669

    public static void main(String[] argv) {
        if (argv.length != 2) {
            System.out.println("Usage: java Main {average | median | beststudent} <module code>");
            System.exit(1);
        }
        switch (argv[0]) {
            case "average":
                System.out.print("The average mark of module " + argv[1] + " = " + calculateModuleAverageMark(argv[1]));
                break;
            case "median":
                System.out.print("The median mark of module " + argv[1] + " = " + calculateModuleMedian(argv[1]));
                break;
            case "beststudent":
                displayBestStudent(argv[1]);
                break;
            default:
                System.out.println("Usage: java Main {average | median | beststudent} <module code>");
                break;

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
        int index = getModuleIndex(mCode);
        double total = 0;
        for (int i = 0; i < marks[index].length; i++)
            total += letterToNumeric(marks[index][i]);
        return total / marks[index].length;
        // return the average mark of a module (module code as input parameter "mCode")

    }

    public static double calculateModuleMedian(String mCode) {
        int index = getModuleIndex(mCode);
        Arrays.sort(marks[index]);
        return (marks[index].length % 2 == 1) ?
                letterToNumeric(marks[index][marks[index].length / 2]) : (letterToNumeric(marks[index][marks[index].length / 2]) + letterToNumeric(marks[index][marks[index].length / 2 - 1])) / 2.0;
        // return the median mark of a module (module code as input parameter "mCode")

    }

    public static void displayBestStudent(String mCode) {
        System.out.println("In module " + mCode + ", the following students perform the best:");
        int index = getModuleIndex(mCode);
        int best = 0;
        for (int i = 0; i < marks[index].length; i++)
            best = (letterToNumeric(marks[index][i]) > letterToNumeric(marks[index][best])) ? i : best;
        for (int i = 0; i < marks[index].length; i++) {
            if (letterToNumeric(marks[index][i]) == letterToNumeric(marks[index][best]))
                System.out.println("Student " + studentID[i]);
        }
        // find the highest mark of a module (module code as input parameter "mCode")
        // then find the studentID(s) of student(s) with the highest mark
        // show the above information in DOS prompt
    }

    public static int getModuleIndex(String mCode) {
        switch (mCode) {
            case "ITD2322":
                return 0;
            case "ICT2422":
                return 1;
            case "ITD2321":
                return 2;
            case "ICT2669":
                return 3;
            default:
                return 0;
        }
    }
    // return the index of a module (module code as input parameter "mCode") in the array of moduleCode
    // You may need to call this method when you want to find the average mark, the median
    // or the best student of a module.


    public static int letterToNumeric(char grade) {
        switch (grade) {
            case 'A':
                return 5;
            case 'B':
                return 4;
            case 'C':
                return 3;
            case 'D':
                return 2;
            case 'E':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }
}