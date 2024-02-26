package uvg.edu.gt;
import java.util.Stack;

public class Expresion {
    private String infix;
    private String postfix;

    public Expresion(String infix) {
        this.infix = infix;
        this.postfix = convertirInfixAPostfix(infix);
    }

    private String convertirInfixAPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new IllegalArgumentException("Expresión infix inválida");
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedencia(c) <= precedencia(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private int precedencia(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public int evaluar() {
        Stack<Integer> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        if (val1 == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        stack.push(val2 / val1);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public String getPostfix() {
        return postfix;
    }
}
