package csvReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvReader {
    private ModIdentifier modelIdentifier = new ModIdentifier();

    private List<String> rows = new ArrayList<>();

    public Map<String, List<String>> getModel(String csvFile) throws IOException, NumberFormatException{
        rows = getRows(csvFile);
        return modelIdentifier.identityModel(rows);
    }

    private List<String> getRows(String csvFile) throws IOException {
        Files.lines(Paths.get(csvFile), StandardCharsets.UTF_8).forEach(row -> rows.add(row));
        return rows.isEmpty() ? null : rows;
    }
}