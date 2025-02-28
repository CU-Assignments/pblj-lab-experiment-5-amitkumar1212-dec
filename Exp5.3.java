

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name, designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}

public class exp_5_3 {
    private static final String FILE_NAME = "employees.ser";

    public static void addEmployee() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: "); int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter Name: "); String name = sc.nextLine();
            System.out.print("Enter Designation: "); String designation = sc.nextLine();
            System.out.print("Enter Salary: "); double salary = sc.nextDouble();
            oos.writeObject(new Employee(id, name, designation, salary));
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("IO Error.");
        }
    }

    public static void displayAllEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                System.out.println(ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("End of employee records.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employees.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee\n2. Display All Employees\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAllEmployees();
                case 3 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
