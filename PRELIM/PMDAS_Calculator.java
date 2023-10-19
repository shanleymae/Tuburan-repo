import java.util.Scanner;
import java.util.Stack;

public class PMDAS_Calculator {

    private Stack<Character> operatorStack;
    private Stack<Double> valueStack;
    private boolean error;

    public PMDAS_Calculator() {
        operatorStack = new Stack<>();
        valueStack = new Stack<>();
        error = false;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int getPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }

    private double stringToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric value: " + str);
            error = true;
            return 0.0; // Return a default value or handle the error as needed.
        }
    }

    private void processOperator(char t) {
        if (valueStack.size() < 2) {
            System.out.println("Expression error.");
            error = true;
            return;
        }
        double b = valueStack.pop();
        double a = valueStack.pop();
        double r = 0;
        switch (t) {
            case '+':
                r = a + b;
                break;
            case '-':
                r = a - b;
                break;
            case '*':
                r = a * b;
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Division by zero error.");
                    error = true;
                } else {
                    r = a / b;
                }
                break;
            default:
                System.out.println("Operator error.");
                error = true;
                break;
        }
        valueStack.push(r);
    }

    private double evaluate(String expression) {
        // Trim and format the input
        expression = expression.trim().replaceAll("\\s+", "");

        // Add explicit '*' symbols for implicit multiplication
        expression = expression.replaceAll("(\\d)(\\()", "$1*$2");

        // Handle negative numbers
        expression = expression.replace("(-", "(0-");

        // The characters that make up the input
        char[] characters = expression.toCharArray();

        // Main loop - process all input characters
        for (int n = 0; n < characters.length; n++) {
            char ch = characters[n];
            if (ch >= '0' && ch <= '9' || ch == '.') {
                // Read the entire number
                StringBuilder number = new StringBuilder();
                while (n < characters.length && (characters[n] >= '0' && characters[n] <= '9' || characters[n] == '.')) {
                    number.append(characters[n]);
                    n++;
                }
                n--; // Move the index back by one
                double value = stringToDouble(number.toString());
                valueStack.push(value);
            } else if (isOperator(ch)) {
                while (!operatorStack.empty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())) {
                    char toProcess = operatorStack.pop();
                    processOperator(toProcess);
                }
                operatorStack.push(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.empty() && operatorStack.peek() != '(') {
                    char toProcess = operatorStack.pop();
                    processOperator(toProcess);
                }
                if (!operatorStack.empty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                } else {
                    System.out.println("Error: unbalanced parenthesis.");
                    error = true;
                }
            }
        }
        // Empty out the operator stack at the end of the input
        while (!operatorStack.empty()) {
            char toProcess = operatorStack.pop();
            if (toProcess == '(') {
                System.out.println("Error: unbalanced parenthesis.");
                error = true;
            } else {
                processOperator(toProcess);
            }
        }
        // Print the result if no error has been seen.
        if (!error) {
            if (valueStack.size() == 1 && operatorStack.isEmpty()) {
                double result = valueStack.pop();
                return result;
            } else {
                System.out.println("Expression error.");
                error = true;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // The original input
        System.out.print("Enter an expression to compute: ");
        String userInput = input.nextLine();

        PMDAS_Calculator calc = new PMDAS_Calculator();
        double result = calc.evaluate(userInput);
        if (!calc.hasError()) {
            System.out.println("The result is " + result);
        }
    }

    public boolean hasError() {
        return error;
    }
}