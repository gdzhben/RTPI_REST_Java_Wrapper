package Interfaces;
import javax.json.JsonObject;
import java.io.IOException;

public interface IDataObtainer {
    static String getDataRequest(String urlString) throws IOException {
        return null;
    }

    static JsonObject getParsedDataObject(String jsonString) {
        return null;
    }
}
