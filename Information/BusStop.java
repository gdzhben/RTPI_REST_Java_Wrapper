package Information;

import Interfaces.IBusStop;

import javax.json.JsonObject;
import java.util.ArrayList;

public class BusStop implements IBusStop {
    private String errorCode;
    private String errorMessage;
    private String numberOfResults;
    private String timeStamp;
    private ArrayList<JsonObject> results;

    BusStop(String stopNumber) {

    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getNumberOfResults() {
        return this.numberOfResults;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public ArrayList<JsonObject> getResults() {
        return this.results;
    }
}
