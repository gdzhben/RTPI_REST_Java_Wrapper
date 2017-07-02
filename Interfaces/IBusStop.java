package Interfaces;

import javax.json.JsonObject;
import java.util.ArrayList;

public interface IBusStop {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getTimeStamp();
    ArrayList<JsonObject> getResults();
}
