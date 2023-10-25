import java.util.Scanner;

public class Main {
    public static int getIntInput(String prompt, Scanner scanner, int failreturn){
        String promptnl = prompt.contains("\n") ? prompt : prompt+"\n";
        //ensures that the prompt gives a new line, if not already in the prompt
        System.out.printf(promptnl);
        String getvalue = scanner.nextLine();
        try {
            return Integer.valueOf(getvalue);
        }
        catch(NumberFormatException e) {
            //System.out.printf("non Integer entered, returning default of"+failreturn+"\n");
            // failreturn indicates that the user input was not a valid int.
            return failreturn;
        }
    }

    public static void main(String[] args) {
        //writing this just so theres a change i can commit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello and welcome!\n");

        final int min = -5, max = 10;
        for (int i = min; i <= max; i++) {
            System.out.println("i = " + i);
        }
        int value = min-1;
        while (min > value || value > max) {
            value = getIntInput("which value of i is your favourite?", scanner, min-1);
            if (min > value || value > max) {
                System.out.printf("Please enter a value between "+min+" and "+max+" (inclusive).\n");
            }
        }
        System.out.printf("Your selection was "+value+"!\n");
    }
}

