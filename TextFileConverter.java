import java.io.*;

public class TextFileConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt"; // Change to your input file path
        String outputFile = "output.txt"; // Change to your output file path

        convertToUpperCase(inputFile, outputFile);
    }

    public static void convertToUpperCase(String inputFileName, String outputFileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                String uppercaseLine = line.toUpperCase();
                writer.write(uppercaseLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Conversion completed. Output written to " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
