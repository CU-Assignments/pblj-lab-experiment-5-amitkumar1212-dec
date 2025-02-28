// writing a Java program to calculate the sum of a list of integers using autoboxing and unboxing, along with methods to parse strings into their respective wrapper classes (e.g., Integer.parseInt()).
import java.util.ArrayList;
import java.util.List;

public class SumOfIntegers {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        // Test Case 1
        addIntegers(integers, 10, 20, 30, "40", "50");
        System.out.println("The sum of the list is: " + calculateSum(integers));

        // Test Case 2
        integers.clear();
        addIntegers(integers, "100", "200", "300");
        System.out.println("The sum of the list is: " + calculateSum(integers));

        // Test Case 3
        integers.clear();
        addIntegers(integers, "50", "invalid", "70");
        System.out.println("The sum of the list is: " + calculateSum(integers));
    }

    private static void addIntegers(List<Integer> list, int... values) {
        for (int value : values) {
            list.add(value); // Autoboxing
        }
    }

    private static void addIntegers(List<Integer> list, String... values) {
        for (String value : values) {
            Integer parsedValue = parseStringToInteger(value);
            if (parsedValue != null) {
                list.add(parsedValue); // Autoboxing
            }
        }
    }

    private static Integer parseStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + str);
            return null; // Return null if parsing fails
        }
    }

    private static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (Integer number : list) {
            sum += number; // Unboxing
        }
        return sum;
    }
}
