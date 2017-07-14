package Information;

import Data.DataObtainer;
import Data.Keys;
import Interfaces.IBusStop;

import javax.json.*;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class BusStop implements IBusStop {
    private String errorCode;
    private String errorMessage;
    private String numberOfResults;
    private String timeStamp;
    private ArrayList<BusStopResult> results = new ArrayList<BusStopResult>();

    public BusStop(String stopNumber) throws URISyntaxException, IOException {
        StringBuilder url = new StringBuilder(UrlConstants.RTPI_SERVER);
        url.append(UrlConstants.BUS_STOP_INFORMATION);
        url.append("?");
        url.append(UrlConstants.STOP_ID);
        url.append("=");
        url.append(stopNumber);

        JsonObject busStopData = DataObtainer.getParsedDataObject(DataObtainer.getDataRequest(url.toString()));

        this.errorCode = busStopData.getJsonString(Keys.ERROR_CODE).toString();
        this.errorMessage = busStopData.getJsonString(Keys.ERROR_MESSAGE).toString();
        this.numberOfResults = busStopData.getJsonNumber(Keys.NUMBER_OF_RESULTS).toString();
        this.timeStamp = busStopData.getJsonString(Keys.TIMESTAMP).toString();

        for (JsonValue resultData: busStopData.getJsonArray(Keys.RESULTS)) {
            JsonReader jsonReader = Json.createReader(new StringReader(resultData.toString()));
            results.add(new BusStopResult(jsonReader.readObject()));
            jsonReader.close();
        }
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

    public ArrayList<BusStopResult> getResults() {
        return this.results;
    }
}