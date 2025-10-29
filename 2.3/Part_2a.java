import java.util.*;

public class Part_2a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (type 'done' to finish):");
        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done"))
                break;
            try {
                Integer num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }

        System.out.println("The sum of all integers is: " + sum);
        sc.close();
    }
}
