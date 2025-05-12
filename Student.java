public class Student {
    private String name;
    private int rollNumber;
    private int marks1, marks2, marks3;

    public Student(String name, int rollNumber, int marks1, int marks2, int marks3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public int getTotalMarks() {
        return marks1 + marks2 + marks3;
    }

    public double getAverage() {
        return getTotalMarks() / 3.0;
    }

    public boolean isPassed() {
        return marks1 >= 35 && marks2 >= 35 && marks3 >= 35;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return rollNumber + "," + name + "," + marks1 + "," + marks2 + "," + marks3;
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        return new Student(
            parts[1],
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[2]),
            Integer.parseInt(parts[3]),
            Integer.parseInt(parts[4])
        );
    }

    public void printDetails() {
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNumber);
        System.out.println("Marks      : " + marks1 + ", " + marks2 + ", " + marks3);
        System.out.println("Total      : " + getTotalMarks());
        System.out.println("Average    : " + getAverage());
        System.out.println("Status     : " + (isPassed() ? "Passed" : "Failed"));
        System.out.println("-------------------------------");
    }
}
