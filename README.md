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

2) Algorithm 2: PDA simulator with trace

   java ALGORITHM_2_LFCO_2025_ABC


Expected behavior: For several example inputs the program prints a step-by-step trace of stack operations and whether the string is ACCEPTED or REJECTED.

3) Algorithm 3: derivation and parse tree

   java ALGORITHM_3_LFCO_2025_ABC

Expected behavior: For accepted inputs, prints the leftmost derivation forms (sentential forms) and then a textual parse tree with indentation.

---

## Notes & implementation details

The PDA implemented is deterministic (push on a, pop on b, reject invalid symbols or incorrect order).

The leftmost derivation routine constructs sentential forms by repeatedly applying the rule S -> a S b and finally replacing S by ε.

The parse tree printer uses indentation to show tree structure; it is intended for human inspection, not for automated parsing.

---

## The video of the operation of the codes
**Video:** 
