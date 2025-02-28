//Java program that serializes and deserializes a Student object. It saves the Student object to a file and then reads it back, displaying the student details.
//The program handles exceptions like FileNotFoundException, IOException, and ClassNotFoundException.



import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class exp_5_2{
    public static void main(String[] args) {
        String file = "student.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(new Student(1, "John Doe", 3.75));
            System.out.println("Serialized.");
        } catch (IOException e) {
            System.out.println("IO Error.");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Deserialized: " + ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error.");
        }
    }
}
