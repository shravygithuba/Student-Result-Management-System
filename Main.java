import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.loadFromFile();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n📘 Student Result Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Save to File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter marks in Subject 1: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter marks in Subject 2: ");
                    int m2 = sc.nextInt();
                    System.out.print("Enter marks in Subject 3: ");
                    int m3 = sc.nextInt();

                    Student s = new Student(name, roll, m1, m2, m3);
                    manager.addStudent(s);
                    System.out.println("✅ Student added successfully.");
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    manager.searchStudent(searchRoll);
                    break;
                case 4:
                    manager.saveToFile();
                    break;
                case 5:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
