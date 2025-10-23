import java.util.*;

public class ALGORITHM_1_LFCO_2025_STUDENT_MateoGomez {

  
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

    public static List<String> generateRejected() {
        List<String> out = new ArrayList<>();
        out.add("a");
        out.add("b"); 
        out.add("abb");
        out.add("aba"); 
        return out;
    }

    public static void main(String[] args) {
        System.out.println("=== Algorithm 1: Generación de ejemplos ===");
        List<String> accepted = generateAccepted(4); 
        System.out.println("Cadenas aceptadas (ejemplos):");
        for (String s : accepted) System.out.println("'" + s + "'");

        List<String> rejected = generateRejected();
        System.out.println("\nCadenas rechazadas (ejemplos):");
        for (String s : rejected) System.out.println("'" + s + "'");
    }
}


