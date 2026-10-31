
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String usn;
    int[] marks;

    Student(String name, String usn, int[] marks) {
        this.name = name;
        this.usn = usn;
        this.marks = marks;
    }

    int getTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    double getAverage() {
        return (double) getTotal() / marks.length;
    }

    int getHighest() {
        int highest = marks[0];
        for (int mark : marks) {
            if (mark > highest)
                highest = mark;
        }
        return highest;
    }

    int getLowest() {
        int lowest = marks[0];
        for (int mark : marks) {
            if (mark < lowest)
                lowest = mark;
        }
        return lowest;
    }

    void display() {
        System.out.println("\nName: " + name);
        System.out.println("USN: " + usn);
        System.out.println("Total: " + getTotal());
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
    }
}

public class StudentGradeTracker {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter USN: ");
        String usn = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of subjects.");
            return;
        }

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks must be between 0 and 100.");
                i--;
            }
        }

        sc.nextLine();

        students.add(new Student(name, usn, marks));
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}

