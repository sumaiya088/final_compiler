import java.util.*;

public class Main {

    public static void main(String[] args) {
   CodeGenerator.startProgram();
        String[] program = {

                "ক=৫+৩",
                "খ=১০-৪",
                "গ=৫*৬",
                "ঘ=২০/৫",

                // ---------------- OPERATOR PRECEDENCE ----------------
                "ঙ=৫+৬*৩",
                "চ=(৫+৬)*৩",

                // ---------------- NESTED BRACKETS ----------------
                "ছ=((৫+২)*(৩+৪))",
                "জ=((২+৩)*(৪+(৫*২)))",

                // ---------------- VARIABLES ----------------
                "ক=৫",
                "খ=১০",
                "গ=ক+খ",
                "ঘ=ক+খ*২",
                "ঙ=((ক+২)*(খ-৩))",

                // ---------------- REASSIGNMENT ----------------
                "ক=১৫",
                "খ=ক+৫",

                // ---------------- COMPLEX MIX ----------------
                "চ=((ক+খ)*(৩+(২*৪)))",

                // ---------------- ERROR CASES ----------------
                "ছ=৫+", // ends with operator
                "জ=৫++২", // double operator
                "ঝ=(৫+২", // missing bracket
                "ঞ=৫+২)", // extra bracket
                "ট=৫(২+৩)", // missing operator
                "ঠ=অ+৫", // undefined variable
                "ড=১০/(৫-৫)", // division by zero
                "ঢ=(())", // empty brackets
                "ণ=৫+@", // invalid token
                "ত=(৫+*)২" // invalid expression
        };

        for (String line : program) {
            try {

    List<String> tokens = Lexer.tokenize(line);

    System.out.println("Tokens: " + tokens);

    if (tokens.get(0).equals("if") || tokens.get(0).equals("while")) {
                    ControlFlowDispatcher.handle(tokens);
                } else {
                    Parser.parseAndEvaluate(tokens);
                }

}

catch (Exception e) {

    //System.out.println("Recovered From Error...");
}
        }

        Parser.printSymbolTable();
          CodeGenerator.endProgram();

                // ---------- SAVE GENERATED FILE ----------

                CodeGenerator.saveToFile();

    }
}