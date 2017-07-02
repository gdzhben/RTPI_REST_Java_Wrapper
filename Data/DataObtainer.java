package Data;

import Interfaces.IDataObtainer;

import java.io.*;
import java.net.*;
import javax.json.JsonObject;

public class DataObtainer implements IDataObtainer {
    public static String getDataRequest(String urlString) throws IOException {
        StringBuilder output = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        reader.close();

        return output.toString();
    }

    public static JsonObject getParsedDataObject(String jsonString) {
        return null;
    }
}
