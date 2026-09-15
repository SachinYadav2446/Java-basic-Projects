import java.util.Scanner;
public class GradeManagement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   Grade Management System           ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        String[] names = new String[numStudents];
        double[] grades = new double[numStudents];
        // Input student data
        inputStudentData(names, grades);
        // Display menu
        boolean continueProgram = true;
        while(continueProgram) {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    displayAllStudents(names, grades);
                    break;
                case 2:
                    displayStatistics(grades);
                    break;
                case 3:
                    displayGradeDistribution(grades);
                    break;
                case 4:
                    findTopStudent(names, grades);
                    break;
                case 5:
                    continueProgram = false;
                    System.out.println("\nThank you for using Grade Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.\n");
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n--- Choose an option ---");
        System.out.println("1. Display all students and grades");
        System.out.println("2. Display statistics");
        System.out.println("3. Display grade distribution");
        System.out.println("4. Find top student");
        System.out.println("5. Exit");
    }
    static void inputStudentData(String[] names, double[] grades) {
        System.out.println("\n--- Enter Student Information ---");
        for (int i = 0; i < names.length; i++) {
            scanner.nextLine(); // Clear buffer
            System.out.print("Enter name of student " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
            System.out.print("Enter grade for " + names[i] + ": ");
            grades[i] = scanner.nextDouble();
            // Validate grade
            while (grades[i] < 0 || grades[i] > 100) {
                System.out.print("Invalid grade! Enter grade between 0-100: ");
                grades[i] = scanner.nextDouble();
            }
        }
        System.out.println();
    }
    static void displayAllStudents(String[] names, double[] grades) {
        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + String.format("%.2f", grades[i]));
        }
    }
    static void displayStatistics(double[] grades) {
        double average = calculateAverage(grades);
        double highest = findHighest(grades);
        double lowest = findLowest(grades);
        System.out.println("\n--- Grade Statistics ---");
        System.out.println("Average Grade: " + String.format("%.2f", average));
        System.out.println("Highest Grade: " + String.format("%.2f", highest));
        System.out.println("Lowest Grade: " + String.format("%.2f", lowest));
    }
    static void displayGradeDistribution(double[] grades) {
        int[] distribution = new int[5]; // A(90+), B(80-89), C(70-79), D(60-69), F(<60)
        for (double grade : grades) {
            if (grade >= 90) distribution[0]++;
            else if (grade >= 80) distribution[1]++;
            else if (grade >= 70) distribution[2]++;
            else if (grade >= 60) distribution[3]++;
            else distribution[4]++;
        }
        System.out.println("\n--- Grade Distribution ---");
        System.out.println("A (90-100): " + distribution[0] + " students");
        System.out.println("B (80-89):  " + distribution[1] + " students");
        System.out.println("C (70-79):  " + distribution[2] + " students");
        System.out.println("D (60-69):  " + distribution[3] + " students");
        System.out.println("F (<60):    " + distribution[4] + " students");
    }
    static void findTopStudent(String[] names, double[] grades) {
        int topIndex = 0;
        double topGrade = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > topGrade) {
                topGrade = grades[i];
                topIndex = i;
            }
        }
        System.out.println("\n--- Top Student ---");
        System.out.println("Name: " + names[topIndex]);
        System.out.println("Grade: " + String.format("%.2f", topGrade));
    }
    static double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
    static double findHighest(double[] grades) {
        double highest = grades[0];
        for (double grade : grades) {
            if (grade > highest) highest = grade;
        }
        return highest;
    }
    static double findLowest(double[] grades) {
        double lowest = grades[0];
        for (double grade : grades) {
            if (grade < lowest) lowest = grade;
        }
        return lowest;
    }
}




