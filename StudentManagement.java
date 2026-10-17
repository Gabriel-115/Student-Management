import java.util.Scanner;

public class StudentManagement {
    static String[] names = new String[100];
    static String[] regNumbers = new String[100];
    static String[] subjects = new String[100];
    static String[] classes = new String[100];
    static double[] marks = new double[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    // Login method
    static boolean login() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        if (user.equals("teacher") && pass.equals("1234")) {
            System.out.println("Login successful!\n");
            return true;
        } else {
            System.out.println("Wrong username or password.");
            return false;
        }
    }

    // Register students
    static void registerStudents() {
        System.out.print("How many students do you want to register? ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.print("Name: ");
            names[count] = sc.nextLine();
            System.out.print("Registration Number: ");
            regNumbers[count] = sc.nextLine();
            System.out.print("Subject: ");
            subjects[count] = sc.nextLine();
            System.out.print("Class: ");
            classes[count] = sc.nextLine();
            marks[count] = -1; // not yet recorded
            count++;
        }
        System.out.println(n + " student(s) registered successfully.\n");
    }

    // Record marks
    static void recordMarks() {
        if (count == 0) {
            System.out.println("No students registered yet.\n");
            return;
        }
        System.out.println("Enter marks for each student:");
        for (int i = 0; i < count; i++) {
            System.out.print(names[i] + " (" + regNumbers[i] + "): ");
            marks[i] = sc.nextDouble();
        }
        sc.nextLine();
        System.out.println("Marks recorded successfully.\n");
    }

    // Display all students and marks
    static void displayAll() {
        if (count == 0) {
            System.out.println("No students registered yet.\n");
            return;
        }
        System.out.println("\n----- Registered Students -----");
        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + names[i]);
            System.out.println("Reg No: " + regNumbers[i]);
            System.out.println("Subject: " + subjects[i]);
            System.out.println("Class: " + classes[i]);
            if (marks[i] == -1) {
                System.out.println("Marks: Not yet recorded");
            } else {
                System.out.println("Marks: " + marks[i]);
            }
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        if (!login()) {
            return;
        }

        int choice;
        do {
            System.out.println("1. Register Students");
            System.out.println("2. Record Marks");
            System.out.println("3. View All Students and Marks");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerStudents();
                    break;
                case 2:
                    recordMarks();
                    break;
                case 3:
                    displayAll();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}