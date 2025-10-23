import java.util.*;

/**
 * Algoritmo 3: construir y mostrar:
 *  - sentential forms en una derivación leftmost de x (S => ... => x)
 *  - y además imprimir un árbol de derivación simple
 *
 * Requiere que la cadena haya sido aceptada por el PDA (se valida antes).
 */
public class ALGORITHM_3_LFCO_2025_STUDENT_MateoGomez {

    // Construye la derivación leftmost (lista de formas sentenciales)
    public static List<String> leftmostDerivation(String s) {
        // Primero validar que es de la forma a^n b^n
        int n = countAsBeforeFirstB(s);
        if (n < 0) return Collections.emptyList(); // no válido

        List<String> forms = new ArrayList<>();
        String current = "S";
        forms.add(current);

        for (int i = 0; i < n; i++) {
            current = current.replaceFirst("S", "a S b");
            forms.add(current);
        }
        // finalmente reemplazamos S por ε (la sentencia final)
        current = current.replaceFirst("S", "ε");
        forms.add(current);

        // opcional: también agregar la forma sin el símbolo ε (la cadena final real)
        forms.add(current.replace("ε", ""));
        return forms;
    }

    // Construye e imprime un árbol derivación recursivo
    public static void printParseTree(String s) {
        int n = countAsBeforeFirstB(s);
        if (n < 0) {
            System.out.println("No se puede construir árbol: la cadena no está en la forma a^n b^n");
            return;
        }
        Node root = buildTree(n);
        printNode(root, 0);
    }

    // Nodo simple para el árbol
    static class Node {
        String label;
        List<Node> children = new ArrayList<>();
        Node(String label) { this.label = label; }
    }

    // Construcción recursiva: S -> a S b | ε
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
                if (seenB) return -1; // 'a' después de 'b' -> no válido
                countA++;
            } else if (c == 'b') {
                seenB = true;
            } else {
                return -1; // símbolo inválido
            }
        }
        // validar que el número de 'b' sea igual al número de 'a'
        int countB = s.length() - countA;
        if (countA == countB) return countA;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Algorithm 3: Derivaciones / Árboles ===");
        // Tomar ejemplos desde ALGORITHM_1 y filtrar por los aceptados usando el PDA
        List<String> candidates = ALGORITHM_1_LFCO_2025_STUDENT_MateoGomez.generateAccepted(4);
        // También probamos alguna rechazada para ver el comportamiento
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
