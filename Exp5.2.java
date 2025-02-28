Java program that serializes and deserializes a Student object. It saves the Student object to a file and then reads it back, displaying the student details.
The program handles exceptions like FileNotFoundException, IOException, and ClassNotFoundException.

import java.io.*;

// Student class implementing Serializable interface
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization compatibility
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class StudentSerialization {

    public static void main(String[] args) {
        // Test Case 1: Serialize and Deserialize a valid student object
        Student student = new Student(1, "John Doe", 3.75);
        serializeStudent(student);
        Student deserializedStudent = deserializeStudent();
        if (deserializedStudent != null) {
            System.out.println("Deserialized Student Details:");
            System.out.println(deserializedStudent);
        }

        // Test Case 2: Try to deserialize from a non-existent file
        System.out.println("\nAttempting to deserialize from a non-existent file:");
        deserializeStudentFromFile("non_existent_file.ser");

        // Test Case 3: Handle invalid class during deserialization
        // Uncomment the following line to simulate ClassNotFoundException
        // simulateClassNotFoundException();
    }

    private static void serializeStudent(Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Student object has been serialized and saved to file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    private static Student deserializeStudent() {
        return deserializeStudentFromFile("student.ser");
    }

    private static Student deserializeStudentFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student student = (Student) ois.readObject();
            System.out.println("Student object has been deserialized.");
            return student;
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
        return null;
    }

    // Uncomment this method to simulate ClassNotFoundException
    /*
    private static void simulateClassNotFoundException() {
        // This method is just a placeholder to show how to handle ClassNotFoundException.
        // You can modify the Student class and try to deserialize it to see the exception.
    }
    */
}
