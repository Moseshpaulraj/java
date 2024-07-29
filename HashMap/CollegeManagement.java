import java.util.*;

public class CollegeManagement {
    public static void main(String[] args) {

        HashMap<Integer, Student> studentMap = new HashMap<>();

        studentMap.put(101, new Student("Sakthi", "Grade A", "sakthivel@example.com"));
        studentMap.put(102, new Student("Moses", "Grade C", "Mosesh1234@example.com"));
        studentMap.put(103, new Student("Abraham", "Grade B", "abraham@example.com"));

     	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Your Id : ");
        int studentId = sc.nextInt();

        if (studentMap.containsKey(studentId)) 
	{
           Student student = studentMap.get(studentId);

            System.out.println("Student Details:");
            System.out.println("ID: " + studentId);
            System.out.println("Name: " + student.name);
            System.out.println("Grade: " + student.grade);
            System.out.println("Email: " + student.email);
        } else {
            System.out.println("Student ID " + studentId + " not found.");
        }
    }
}

class Student {
    public String name;
    public String grade;
    public String email;

    public Student( String name, String grade, String email) {
        this.name = name;
        this.grade = grade;
        this.email = email;
    }
}
