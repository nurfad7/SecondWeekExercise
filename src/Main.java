import exercise.Monday;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monday monday = new Monday(scanner);
        monday.result();
        scanner.close();
    }
}