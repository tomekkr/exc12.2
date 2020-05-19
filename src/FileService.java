import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class FileService {
    public static Map<String, Country> createMapFromFile(Scanner scanner) {
        Map<String, Country> countries = new HashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> elements = List.of(line.split(";"));
            for (int i = 0; i < elements.size(); i++) {
                countries.put(elements.get(0), new Country(elements.get(0), elements.get(1), elements.get(2)));
            }
        }
        return countries;
    }

    public static String readCodeFromUser(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String getInfoAboutCountry(String fileName, Map<String, Country> countries, String code) {
        if (!countries.containsKey(code)) {
            throw new NoDataFoundException("Nie odnaleziono informacji o takim państwie w pliku: " + fileName);
        }
        return countries.get(code).toString();
    }
}
