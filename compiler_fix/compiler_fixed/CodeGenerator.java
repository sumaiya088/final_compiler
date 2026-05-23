import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CodeGenerator {

        static List<String> generatedCode = new ArrayList<>();

        // ---------- ADDED FIX: TRACK VARIABLES ----------
        static Set<String> declaredVariables = new HashSet<>();

        // ---------- START PROGRAM ----------

        public static void startProgram() {

                generatedCode.add(
                                "public class GeneratedCode {");

                generatedCode.add(
                                "public static void main(String[] args) {");
        }
        
         // ---------- END PROGRAM ----------

        public static void endProgram() {

                generatedCode.add("}");

                generatedCode.add("}");
        }
        
        public static void addLine(
                        String line) {

                generatedCode.add(
                                "    " + line);
        }


        // ---------- SAVE FILE ----------

        public static void saveToFile() {

                try {

                        FileWriter writer = new FileWriter(
                                        "GeneratedCode.java");

                        for (String line : generatedCode) {

                                writer.write(
                                                line + "\n");
                        }

                        writer.close();

                        System.out.println(
                                        "\nGeneratedCode.java created successfully!");
                }

                catch (IOException e) {

                        System.out.println(
                                        "File Writing Error!");
                }
        }
}
    
