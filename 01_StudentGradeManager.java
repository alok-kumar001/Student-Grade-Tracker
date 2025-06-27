import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private ArrayList<Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return total / (double) grades.size();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Grades: " + grades + ", Average: " + calculateAverage();
    }
}

public class StudentGradeManager {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentGradeManager() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        students.add(new Student(name, id));
        System.out.println("Student added successfully.");
    }

    public void addGrade() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter Grade to Add: ");
            int grade = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            student.addGrade(grade);
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentGradeManager manager = new StudentGradeManager();
        manager.start();
    }
}
