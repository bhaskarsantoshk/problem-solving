package company.google.stacks_and_queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1106ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        return eval(expression);
    }

    private boolean eval(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<List<Boolean>> operandGroup = new Stack<>();
        for ( char c: expression.toCharArray()){
            if ( c == 't' || c == 'f'){
                if ( !operandGroup.isEmpty()){
                    operandGroup.peek().add(c=='t');
                } else if ( c == '!' || c == '&' || c == '|'){
                    operators.add(c);
                    operandGroup.add(new ArrayList<>());
                } else if ( c == ')'){
                    List<Boolean> currentOpearnds = operandGroup.pop();
                    char operator = operators.pop();
                    boolean result = false;
                    if ( operator == '!'){
                        result = !currentOpearnds.get(0);
                    } else if ( operator == '&'){
                        result = currentOpearnds.stream().allMatch(Boolean::booleanValue);
                    } else if ( operator == '|'){
                        result = currentOpearnds.stream().anyMatch(Boolean::booleanValue);
                    }
                    if (!operandGroup.isEmpty()) {
                        operandGroup.peek().add(result);
                    } else {
                        return result;  // Final result
                    }
                }
            }
        }
        return false;  // Should not reach here
    }
}
