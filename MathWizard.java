import java.util.Scanner;

public class MathWizard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the formula and the expected answer from the user
        System.out.print("Enter the mathematical formula: ");
        String formula = input.nextLine();

        System.out.print("Enter the expected answer: ");
        double expectedAnswer = input.nextDouble();

        // Solve the formula
        double result = solveFormula(formula);

        // Compare the result with the expected answer
        if (Math.abs(result - expectedAnswer) < 0.000001) {
            System.out.println("Congratulations, the formula is correct!");
        } else {
            System.out.println("Sorry, the formula is incorrect.");
        }
    }

    public static double solveFormula(String formula) {
        // Remove all spaces from the formula
        formula = formula.replaceAll("\\s", "");

        // Evaluate the formula based on BODMAS rules
        double result = 0;
        int currentNumber = 0;
        char currentOperator = '+';
        boolean multiplicationOrDivision = false;

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (i == formula.length() - 1 || !Character.isDigit(c)) {
                switch (currentOperator) {
                    case '+':
                        result += currentNumber;
                        break;
                    case '-':
                        result -= currentNumber;
                        break;
                    case '*':
                        if (multiplicationOrDivision) {
                            result /= currentNumber;
                        } else {
                            result *= currentNumber;
                        }
                        break;
                    case '/':
                        if (multiplicationOrDivision) {
                            result /= currentNumber;
                        } else {
                            result *= currentNumber;
                        }
                        break;
                }

                if (c == '*' || c == '/') {
                    multiplicationOrDivision = true;
                } else {
                    multiplicationOrDivision = false;
                }

                currentOperator = c;
                currentNumber = 0;
            }
        }

        return result;
    }
}
