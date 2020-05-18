import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Test {
    public static void main(String[] args) {
        final String fileName = "countries_data.csv";
        File file = new File(fileName);

        try (
                Scanner fileScanner = new Scanner(file);
                Scanner userInputScanner = new Scanner(System.in)
        ) {
            Map<String, Country> countries = new HashMap<>();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                List<String> elements = List.of(line.split(";"));

                for (int i = 0; i < elements.size(); i++) {
                    countries.put(elements.get(0), new Country(elements.get(0), elements.get(1), elements.get(2)));
                }
            }

            System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje (np. PL - Polska):");
            String code = userInputScanner.nextLine();
            if (countries.containsKey(code)) {
                Country foundCountry = countries.get(code);
                System.out.println(foundCountry);
            } else {
                System.out.println("Wpisany kod jest nieprawidłowy lub nie ma informacji o takim państwie w pliku: "
                        + fileName);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + fileName);
        }
    }
}