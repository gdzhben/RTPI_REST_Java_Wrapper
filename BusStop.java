import java.utils.ArrayList;
import javax.json.JsonObject;

public class BusStop implements IBusStop {
    private String errorCode;
    private String errorMessage;
    private String numberOfResults;
    private String timeStamp;
    private ArrayList<JsonObject> results;

    BusStop(String stopNumber) {

    }

    public String getErrorCode() {
        return this.ErrorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getNumberOfResults() {
        return this.numberofresults;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public ArrayList<JsonObject> getResults() {
        return this.results;
    }
}
