package Information;

import Data.DataObtainer;
import Data.Keys;
import Interfaces.IBusStop;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class BusStop implements IBusStop {
    private ArrayList<JsonObject> results;
    private JsonObject busStopData;

    public BusStop(String stopNumber) throws URISyntaxException, IOException {
        StringBuilder url = new StringBuilder(UrlConstants.RTPI_SERVER);
        url.append(UrlConstants.BUS_STOP_INFORMATION);
        url.append("?");
        url.append(UrlConstants.STOP_ID);
        url.append("=");
        url.append(stopNumber);

        busStopData = DataObtainer.getParsedDataObject(DataObtainer.getDataRequest(url.toString()));
    }

    public String getErrorCode() {
        return busStopData.getJsonString(Keys.ERROR_CODE).toString();
    }

    public String getErrorMessage() {
        return busStopData.getJsonString(Keys.ERROR_MESSAGE).toString();
    }

    public String getNumberOfResults() {
        return busStopData.getJsonString(Keys.NUMBER_OF_RESULTS).toString();
    }

    public String getTimeStamp() {
        return busStopData.getJsonString(Keys.TIMESTAMP).toString();
    }

    public JsonArray getResults() {
        return busStopData.getJsonArray(Keys.RESULTS);
    }
}
