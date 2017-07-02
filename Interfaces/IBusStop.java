import javax.json.JsonObject;

public interface IBusStop {
    public String getErrorCode();
    public String getErrorMessage();
    public String getNumberOfResults();
    public String getTimeStamp();
    public ArrayList<JsonObject> getResults();
}
