import javax.json.JsonObject;

public interface IDataObtainer {
    public static String getDataRequest(URL url);
    public static JsonObject getDataObject(String jsonString);
}
