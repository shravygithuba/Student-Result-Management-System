import java.io.*;
import java.util.*;

public class StudentManager {
    private static final String FILE_NAME = "student_data.txt";
    private List<Student> students = new ArrayList<>();

    public void loadFromFile() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("File not found. Starting fresh...");
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                s.printDetails();
            }
        }
    }

    public void searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNo) {
                s.printDetails();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
