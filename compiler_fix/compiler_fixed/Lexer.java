import java.util.*;
import java.util.regex.*;

public class Lexer {

    public static String convertBanglaToEnglishNumber(String input) {

        String bangla = "০১২৩৪৫৬৭৮৯";
        String english = "0123456789";

        for (int i = 0; i < bangla.length(); i++) {
            input = input.replace(bangla.charAt(i), english.charAt(i));
        }

        return input;
    }

    public static String convertBanglaToEnglishWords(String input) {

        String[] bangla = {
                "অ", "আ", "ই", "ঈ", "উ", "ঊ", "ঋ", "এ", "ঐ", "ও", "ঔ",
                "ক", "খ", "গ", "ঘ", "ঙ",
                "চ", "ছ", "জ", "ঝ", "ঞ",
                "ট", "ঠ", "ড", "ঢ", "ণ",
                "ত", "থ", "দ", "ধ", "ন",
                "প", "ফ", "ব", "ভ", "ম",
                "য", "র", "ল", "শ", "ষ", "স", "হ",
                "ড়", "ঢ়", "য়", "ৎ",
                "ং", "ঃ", "ঁ"
        };

        String[] english = {
                "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10",
                "b0", "b1", "b2", "b3", "b4",
                "b5", "b6", "b7", "b8", "b9",
                "b10", "b11", "b12", "b13", "b14",
                "b15", "b16", "b17", "b18", "b19",
                "b20", "b21", "b22", "b23", "b24",
                "b25", "b26", "b27", "b28", "b29",
                "b30", "b31", "b32", "b33", "b34", "b35", "b36",
                "c0", "c1", "c2", "c3",
                "d0", "d1", "d2"
        };

        for (int i = 0; i < bangla.length; i++) {
            input = input.replace(bangla[i], english[i]);
        }

        return input;
    }

    public static List<String> tokenize(String line) {

        List<String> tokens = new ArrayList<>();

        line = convertBanglaToEnglishNumber(line);
        line = convertBanglaToEnglishWords(line);

        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+|\\+|\\-|\\*|\\/|=|\\(|\\))");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        String joinedTokens = "";

                for (String t : tokens) {

                        joinedTokens += t;
                }

                String cleanedLine = line.replaceAll(
                                "\\s+",
                                "");

                if (!joinedTokens.equals(
                                cleanedLine)) {

                        System.out.println(
                                        "Invalid Token Found!");
                }



        return tokens;
    }
}