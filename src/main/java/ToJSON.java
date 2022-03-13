import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ToJSON {
    static void writeString(String json, String writeFile) {
        try (FileWriter file = new FileWriter(writeFile)) {
            file.write(json);
            file.flush();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static String ListToJson(List<Emloyee> list) {
        Type listType = new TypeToken<List<Emloyee>>() {}.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String json = gson.toJson(list, listType);
        return json;
    }
}
