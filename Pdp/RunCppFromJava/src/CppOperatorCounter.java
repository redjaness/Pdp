/*
*
*@ Muhammet Emin AKKURT muhammet.akkurt1@ogr.sakarya.edu.tr
*@ 01.12.24
*<p>
*4.sınıf programlama dillerinin prensibi 
*</p>
*/
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class CppOperatorCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen .cpp dosyasının yolunu girin: ");
        String filePath = scanner.nextLine();

        try {
            Map<String, Integer> operatorCounts = countOperatorsWithRegex(filePath);
            System.out.println("Sonuçlar:");
            System.out.println("Tekli operatör sayısı: " + operatorCounts.get("unary"));
            System.out.println("İkili operatör sayısı: " + operatorCounts.get("binary"));
            System.out.println("Üçlü operatör sayısı: " + operatorCounts.get("ternary"));
        } catch (IOException e) {
            System.err.println("Dosya okunamadı: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countOperatorsWithRegex(String filePath) throws IOException {
        String unaryPattern = "\\+\\+|--|!";
        String binaryPattern = "!=|<=|>=|&&|\\|\\||<<|>>|\\+=|-=|\\*=|/=|%=|&=|\\|=|\\^=|<<=|>>=|\\+|-|\\*|/|%|=|<|>|&|\\||\\^";
        String ternaryPattern = "\\?";

        int unaryCount = 0;
        int binaryCount = 0;
        int ternaryCount = 0;

        Pattern unaryRegex = Pattern.compile(unaryPattern);
        Pattern binaryRegex = Pattern.compile(binaryPattern);
        Pattern ternaryRegex = Pattern.compile(ternaryPattern);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher unaryMatcher = unaryRegex.matcher(line);
                while (unaryMatcher.find()) {
                    unaryCount++;
                }

                Matcher binaryMatcher = binaryRegex.matcher(line);
                while (binaryMatcher.find()) {
                    binaryCount++;
                }

                Matcher ternaryMatcher = ternaryRegex.matcher(line);
                while (ternaryMatcher.find()) {
                    ternaryCount++;
                }
            }
        }

        int overlapCount = countSpecificMatches(filePath, "\\+\\+|--|!|~|!=|\\|");
        binaryCount -= overlapCount;

        Map<String, Integer> result = new HashMap<>();
        result.put("unary", unaryCount);
        result.put("binary", binaryCount);
        result.put("ternary", ternaryCount);

        return result;
    }

    public static int countSpecificMatches(String filePath, String pattern) throws IOException {
        int count = 0;
        Pattern specificPattern = Pattern.compile(pattern);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = specificPattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }
        }
        return count;
    }
}
