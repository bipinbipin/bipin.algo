package bipin.hackerrank;
import java.util.*;

public class JavaStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            Stack<Character> parStack = new Stack<Character>();
            String input=sc.next();

            //Complete the code
            boolean balanced = true;
            if(!input.isEmpty()) {
                breakloop:
                for (Character ch : input.toCharArray()) {
                    switch(ch) {
                        case '(': case '{': case '[':
                            parStack.push(ch);
                            break;

                        case ')':
                            balanced = checkStack('(', parStack);
                            break;

                        case '}':
                            balanced = checkStack('{', parStack);
                            break;

                        case ']':
                            balanced = checkStack('[', parStack);
                            break;
                    }
                    if (!balanced)
                        break breakloop;
                }
                if (parStack.size() != 0) {
                    balanced = false;
                }
            }
            System.out.println(balanced);
        }
    }

    public static boolean checkStack(Character opposingChar, Stack<Character> parStack) {
        if(!parStack.isEmpty()) {
            if (parStack.peek().equals(opposingChar)) {
                parStack.pop();
                return true;
            }
        }
        return false;
    }


}
