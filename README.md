 # Activitie/assignment-practice-2
### Course / Assignment: Automata & Formal Languages — PDA & Derivations

**Group members:**

Mateo Gomez Giraldo

---

## Implementation of the topic

- A small generator of example strings for the grammar 𝑆 → 𝑎𝑆𝑏 ∣ 𝜀
𝐿=
{
𝑎
𝑛
𝑏
𝑛
∣
𝑛
≥
0
}
(and some rejected examples).

- A deterministic pushdown automaton (PDA) simulator that recognizes 
𝑎^𝑛 𝑏^𝑛

- Construction and display of a leftmost derivation and a derivation tree for accepted strings.

The implementation is in Java and is split across three runnable classes (each with its own main), so you can run each part independently, or compile all and run whichever main you need.

## Versions (environment / tools)

The following versions were used and tested during development. If you have other compatible versions the code should still work, but we recommend the listed ones.

Operating system (example tested):
- Windows 10 / Windows 11 (64-bit)
 


Programming language:

- Java SE (OpenJDK) 11 or 17. Use at least Java 11.

Run tools:

- javac (Java compiler)

Optional recommended and the tool that I use:

- Visual Studio Code + Java Extension Pack

## Project structure

If you rename files to include your initials, keep the class names inside the files consistent or update them accordingly.

## Compilation & Running (instructions)

You got to save the three files in the same folder

1) Run each part in order from 1 to 3
   
   Algorithm 1: generate examples

   java ALGORITHM_1_LFCO_2025_ABC


Expected behavior: prints accepted example strings ("", "ab", "aabb", ...) and some rejected strings.

Algorithm 2: PDA simulator with trace

java ALGORITHM_2_LFCO_2025_ABC


Expected behavior: For several example inputs the program prints a step-by-step trace of stack operations and whether the string is ACCEPTED or REJECTED.

Algorithm 3: derivation and parse tree

java ALGORITHM_3_LFCO_2025_ABC


Expected behavior: For accepted inputs, prints the leftmost derivation forms (sentential forms) and then a textual parse tree with indentation.

Example output (short excerpt)

Running java ALGORITHM_1_LFCO_2025_ABC might print:

=== Algorithm 1: Generación de ejemplos ===
Cadenas aceptadas (ejemplos):
''
'ab'
'aabb'
'aaabbb'
...

Cadenas rechazadas (ejemplos):
'a'
'b'
'abb'
'aba'


Running java ALGORITHM_2_LFCO_2025_ABC might show a trace such as:

Input: 'aabb'
  init: push $ (stack bottom marker)
  start processing input: 'aabb'
  read 'a' : push 'A' (stack now: A$)
  read 'a' : push 'A' (stack now: AA$)
  read 'b' : pop 'A' (stack now: A$)
  read 'b' : pop 'A' (stack now: $)
end of input: stack = $ -> accept
Result: ACCEPTED


Running java ALGORITHM_3_LFCO_2025_ABC prints the leftmost derivation and a tree for 'aabb':

  -> Aceptado. Derivación leftmost:
     S
     a S b
     a a S b b
     a a ε b b
     a a  b b   (final string)
  -> Árbol de derivación:
S
  a
  S
    a
    S
      ε
    b
  b

Notes & implementation details

The grammar implemented is: S -> a S b | ε. The code assumes alphabet {a, b} only and enforces that all a must appear before any b.

The PDA implemented is deterministic (push on a, pop on b, reject invalid symbols or incorrect order).

The leftmost derivation routine constructs sentential forms by repeatedly applying the rule S -> a S b and finally replacing S by ε.

The parse tree printer uses indentation to show tree structure; it is intended for human inspection, not for automated parsing.

How to adapt / integrate

To integrate into a larger project or a single main, you can import the classes or copy their methods into one file and call them in sequence:

Generate candidate strings (Algorithm 1),

Test each using PDA (Algorithm 2),

For accepted strings, print derivations and trees (Algorithm 3).

If you want a GUI or web front-end, consider building a simple CLI or a small Swing/JavaFX app, or expose the logic via a REST API (requires additional libraries).

Troubleshooting

javac not found: Install JDK (OpenJDK or Oracle JDK) and ensure JAVA_HOME and PATH are set.

Version mismatch/runtime errors: Use java -version to confirm your runtime. If you compiled with target 11+, ensure your runtime is Java 11+.

Encoding or console issues: If special characters look wrong, ensure your terminal uses UTF-8 encoding.

Testing suggestions

Test edge cases: the empty string "" (should be accepted), single a or b (rejected), aaabbb (accepted), aab (rejected), aba (rejected).

Add unit tests with JUnit if you want automated testing (not included in this submission).

License & contact

License: You may include your preferred license (e.g., MIT).

Contact / authors: Replace the group members section above with real names and contact emails if the instructor requires it.

If you want, I can:

produce a ready-to-commit README.md file with your exact group member names (tell me the full names and optionally student IDs), or

produce a single Main.java that runs the entire pipeline in sequence, or

add a small run.sh / run.bat script to automate compilation and execution.

Which of those would you like me to generate right now?
