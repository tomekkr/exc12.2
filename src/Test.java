import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Test {
    public static void main(String[] args) {
        final String fileName = "countries_data.csv";
        File file = new File(fileName);
        try (Scanner fileScanner = new Scanner(file);
             Scanner userInputScanner = new Scanner(System.in)
        ) {

            Map<String, Country> countries = FileService.createMapFromFile(fileScanner);
            System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje (np. PL - Polska):");
            String code = FileService.readCodeFromUser(userInputScanner);
            System.out.println(FileService.getInfoAboutCountry(fileName, countries, code));

        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        } catch (NoDataFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}