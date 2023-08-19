package password.generator;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * This class will handle the json loading and saving the setting state using gson
 */
public class DataSaver {
    private static final String FILENAME = "assets/json/settings.json";

    public static void saveData(Settings settings) throws IOException {
        FileWriter fileWriter = new FileWriter(FILENAME);
        new Gson().toJson(settings, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }

    public static void loadData(Settings settings) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(FILENAME));
        Map<?, ?> map = gson.fromJson(reader, Map.class);

        if (map != null) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String key = (String) entry.getKey();
                switch (key) {
                    case "useAllAlpha" -> settings.setUseAllAlpha((Boolean) entry.getValue());
                    case "useNumeric" -> settings.setUseNumeric((Boolean) entry.getValue());
                    case "useSpecial" -> settings.setUseSpecial((Boolean) entry.getValue());
                    case "length" -> settings.setLength(((Double) entry.getValue()).intValue());
                    case "password" -> settings.setPassword((String) entry.getValue());
                    default -> {
                        // do nothing, key not found
                    }
                }
            }
        }

        reader.close();
    }
}