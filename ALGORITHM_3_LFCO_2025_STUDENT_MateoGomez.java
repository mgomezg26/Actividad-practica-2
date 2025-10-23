import java.util.*;


public class ALGORITHM_3_LFCO_2025_STUDENT_MateoGomez {


    public static List<String> leftmostDerivation(String s) {

        int n = countAsBeforeFirstB(s);
        if (n < 0) return Collections.emptyList();

        List<String> forms = new ArrayList<>();
        String current = "S";
        forms.add(current);

        for (int i = 0; i < n; i++) {
            current = current.replaceFirst("S", "a S b");
            forms.add(current);
        }

        current = current.replaceFirst("S", "ε");
        forms.add(current);


        forms.add(current.replace("ε", ""));
        return forms;
    }


    public static void printParseTree(String s) {
        int n = countAsBeforeFirstB(s);
        if (n < 0) {
            System.out.println("No se puede construir árbol: la cadena no está en la forma a^n b^n");
            return;
        }
        Node root = buildTree(n);
        printNode(root, 0);
    }


    static class Node {
        String label;
        List<Node> children = new ArrayList<>();
        Node(String label) { this.label = label; }
    }


    private static Node buildTree(int n) {
        Node sNode = new Node("S");
        if (n == 0) {
            sNode.children.add(new Node("ε"));
            return sNode;
        } else {
            sNode.children.add(new Node("a"));
            sNode.children.add(buildTree(n - 1));
            sNode.children.add(new Node("b"));
            return sNode;
        }
    }

    private static void printNode(Node node, int indent) {
        for (int i = 0; i < indent; i++) System.out.print("  ");
        System.out.println(node.label);
        for (Node c : node.children) printNode(c, indent + 1);
    }

    private static int countAsBeforeFirstB(String s) {
        if (s == null) return -1;
        int countA = 0;
        boolean seenB = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                if (seenB) return -1;
                countA++;
            } else if (c == 'b') {
                seenB = true;
            } else {
                return -1; 
            }
        }
    
        int countB = s.length() - countA;
        if (countA == countB) return countA;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Algorithm 3: Derivaciones / Árboles ===");
    
        List<String> candidates = ALGORITHM_1_LFCO_2025_STUDENT_MateoGomez.generateAccepted(4);

        candidates.addAll(ALGORITHM_1_LFCO_2025_STUDENT_MateoGomez.generateRejected());

        for (String s : candidates) {
            System.out.println("\nInput: '" + s + "'");
            ALGORITHM_2_LFCO_2025_STUDENT_MateoGomez.PDAResult r = ALGORITHM_2_LFCO_2025_STUDENT_MateoGomez.analyze(s);
            if (!r.accepted) {
                System.out.println("  -> Rechazado por el PDA. No se construye derivación/árbol.");
                continue;
            }
            System.out.println("  -> Aceptado. Derivación leftmost:");
            List<String> deriv = leftmostDerivation(s);
            for (String form : deriv) {
                System.out.println("     " + form);
            }
            System.out.println("  -> Árbol de derivación:");
            printParseTree(s);
        }
    }
}

