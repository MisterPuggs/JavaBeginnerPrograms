import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //doin this so i can commit changes
        Scanner scanner = new Scanner(System.in);


    }

    public static String getInput(String prompt, Scanner scanner){
        //creates a basic input function
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
}