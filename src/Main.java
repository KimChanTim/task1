import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")), 8192))) {
            Parser parser = new Parser(scanner);
            parser.parse();
            parser.printSequences();
        }
        catch (IOException e) {
            System.err.println();
        }
    }
}