import java.util.Scanner;

interface mathFunction {
    //provides base interface for lambda functions
    float using(float a, float b);
}

public class Main {
    public static void main(String[] args) {
        //scanner and introductory statement
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the calculator program!");

        //construct calculator functions - im using lambdas cus i wanna try em >:[
        mathFunction add = (float a, float b) -> a+b;
        mathFunction mul = (float a, float b) -> a*b;
        mathFunction mod = (float a, float b) -> a%b;

        //variables for storing string versions of floats converted when required
        //for calculations and variable to store the desired function
        String calcResult, funcValue="", func = " ";
        float crInt, fvInt;
        String funcList[] = {"+", "-", "x", "/", "%", "^"};

        //main calculator program bit
        calcResult = getFloatLoop("Enter initial value (max 9digits)", scanner);

        boolean running = true, validFunction;
        while (running){
            outputScreen(func, funcValue, calcResult);
            //get function, and ensure it is valid
            validFunction = false;
            while (!validFunction) {
                func = getInput("do operation (+ - x / % ^):", scanner);
                for (String item : funcList){
                    if (item.equals(func)) {validFunction = true; break;}
                }
            }
            outputScreen(func, funcValue, calcResult);
            funcValue = getFloatLoop("Enter value: (max 9 digits)", scanner);
            outputScreen(func, funcValue, calcResult);
            System.out.println("performing calculation. . .");
            crInt = Float.parseFloat(calcResult);
            fvInt = Float.parseFloat(funcValue);
            switch (func) {
                case "+": calcResult = String.valueOf(add.using(crInt, fvInt)); break;
                case "-": calcResult = String.valueOf(add.using(crInt, -fvInt)); break;
                case "x": calcResult = String.valueOf(mul.using(crInt, fvInt)); break;
                case "/": calcResult = String.valueOf(mul.using(crInt, 1/fvInt)); break;
                case "%": calcResult = String.valueOf(mod.using(crInt, fvInt)); break;
            }
            func = " "; funcValue = "";
            calcResult = calcResult.substring(0, Math.min(calcResult.length(), 9));
            if (calcResult.charAt(calcResult.length() - 1) == '.') {
                calcResult = calcResult.replace(".", "");
            }
        }
    }

    public static String getFloatLoop(String prompt, Scanner scanner){
        //check if valid float and that truncated value doesnt end on decimal
        //repeats until valid entry
        String input = getInput(prompt, scanner);
        while (true) {
            try {
                Float.parseFloat(input);
                input = input.substring(0, Math.min(input.length(), 9));
                if (input.charAt(input.length() - 1) == '.') {
                    input = input.replace(".", "");
                }
                return input;
            } catch (Exception e) {
                prompt = "Unexpected value recieved, please re-enter value:";
                input = getInput(prompt, scanner);
            }
        }
    }

    public static String getInput(String prompt, Scanner scanner){
        //creates a basic input function
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }

    public static void outputScreen(String func, String funcvalue, String calcvalue){
        //add in whitespace for right-side justification of numbers
        //3spaces for ' = ' (replace = with alternative function like +)
        //9spaces for numeric value such that [ = 123456789]
        while (calcvalue.length() < 9){
            calcvalue = " " + calcvalue;
        }
        while (funcvalue.length() < 9){
            funcvalue = " " + funcvalue;
        }

        //actual display of calculator "screen"
        System.out.println("[````````````]\n[ "+func+" "+funcvalue+"]\n[ = "
                +calcvalue+"]\n[............]\n[]  -+/x^%  []");
    }
}