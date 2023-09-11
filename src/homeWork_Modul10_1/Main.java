package homeWork_Modul10_1;

import java.io.*;
import java.util.regex.*;

public class Main {
    private static final String ABSOLUTE_PATH = "C:\\Users\\eshap\\IdeaProjects\\HomeWork_Modul10_1\\src\\homeWork_Modul10_1\\file.txt";
    public static void main(String[] args) {
        File file = new File(ABSOLUTE_PATH);
        checkIfFileAvailable(file);
        checkNumberTel(file);
    }
    private static void checkIfFileAvailable (File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    private static void checkNumberTel (File file) {
        final String PHONE_TEMPLATE = "[(]\\d{3}[)]\\s\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(PHONE_TEMPLATE);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                } else {
                    System.out.print("");
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}