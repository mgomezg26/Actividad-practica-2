import java.util.*;

public class ALGORITHM_1_LFCO_2025_STUDENT_MateoGomez {

    /**
     * Genera cadenas aceptadas por la gramática S -> a S b | ε
     * Devuelve a^0 b^0 (""), a^1 b^1, ..., a^maxN b^maxN
     */
    public static List<String> generateAccepted(int maxN) {
        List<String> out = new ArrayList<>();
        for (int n = 0; n <= maxN; n++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append('a');
            for (int i = 0; i < n; i++) sb.append('b');
            out.add(sb.toString());
        }
        return out;
    }

    /**
     * Genera ejemplos de cadenas del mismo alfabeto {a,b} que NO pertenecen al lenguaje.
     * (Al menos dos rechazadas; aquí devolvemos varias opciones)
     */
    public static List<String> generateRejected() {
        List<String> out = new ArrayList<>();
        out.add("a");       // un 'a' sin su 'b' correspondiente
        out.add("b");       // un 'b' sin a's previos
        out.add("abb");     // desequilibrio
        out.add("aba");     // formato inválido (hay 'a' después de 'b')
        return out;
    }

    public static void main(String[] args) {
        System.out.println("=== Algorithm 1: Generación de ejemplos ===");
        List<String> accepted = generateAccepted(4); // genera n=0..4
        System.out.println("Cadenas aceptadas (ejemplos):");
        for (String s : accepted) System.out.println("'" + s + "'");

        List<String> rejected = generateRejected();
        System.out.println("\nCadenas rechazadas (ejemplos):");
        for (String s : rejected) System.out.println("'" + s + "'");
    }
}

