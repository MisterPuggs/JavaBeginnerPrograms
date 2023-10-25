import java.util.Scanner;

interface mathFunction {
    //provides base interface for lambda functions
    int operate(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        //doin this so i can commit changes
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the calculator program!");
        boolean running = true;
        while (running){

        }

    }

    public static String getInput(String prompt, Scanner scanner){
        //creates a basic input function
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
}