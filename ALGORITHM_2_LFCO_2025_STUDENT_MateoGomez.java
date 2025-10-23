import java.util.*;


public class ALGORITHM_2_LFCO_2025_STUDENT_MateoGomez {

    public static class PDAResult {
        public final boolean accepted;
        public final List<String> trace;
        public PDAResult(boolean accepted, List<String> trace) {
            this.accepted = accepted;
            this.trace = trace;
        }
    }

    public static PDAResult analyze(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        List<String> trace = new ArrayList<>();
  
        stack.push('$');
        trace.add("init: push $ (stack bottom marker)");

        boolean seenB = false;

        trace.add("start processing input: '" + input + "'");

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a') {
                if (seenB) {
                    trace.add("read 'a' after 'b' detected -> reject (no 'a' allowed after 'b')");
                    return new PDAResult(false, trace);
                }
                stack.push('A');
                trace.add("read 'a' : push 'A' (stack now: " + stackToString(stack) + ")");
            } else if (c == 'b') {
                if (stack.peek() != null && stack.peek() == 'A') {
                    stack.pop();
                    trace.add("read 'b' : pop 'A' (stack now: " + stackToString(stack) + ")");
                } else {
                    trace.add("read 'b' : no 'A' to pop -> reject (stack: " + stackToString(stack) + ")");
                    return new PDAResult(false, trace);
                }
                seenB = true;
            } else {
                trace.add("invalid symbol '" + c + "' -> reject (alphabet is {a,b})");
                return new PDAResult(false, trace);
            }
        }

      
        if (stack.size() == 1 && stack.peek() == '$') {
            trace.add("end of input: stack = " + stackToString(stack) + " -> accept");
            return new PDAResult(true, trace);
        } else {
            trace.add("end of input: stack = " + stackToString(stack) + " -> reject (unmatched 'A's remain)");
            return new PDAResult(false, trace);
        }
    }

    private static String stackToString(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) sb.append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Algorithm 2: PDA ===");

        List<String> examples = ALGORITHM_1_LFCO_2025_STUDENT_MateoGomez.generateAccepted(3);
        examples.addAll(ALGORITHM_1_LFCO_2025_STUDENT_MateoGomez.generateRejected());

        for (String s : examples) {
            System.out.println("\nInput: '" + s + "'");
            PDAResult r = analyze(s);
            for (String step : r.trace) System.out.println("  " + step);
            System.out.println("Result: " + (r.accepted ? "ACCEPTED" : "REJECTED"));
        }
    }
}

