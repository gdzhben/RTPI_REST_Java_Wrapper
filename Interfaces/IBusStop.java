package Interfaces;

import javax.json.JsonArray;

public interface IBusStop {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getTimeStamp();
    JsonArray getResults();
}
