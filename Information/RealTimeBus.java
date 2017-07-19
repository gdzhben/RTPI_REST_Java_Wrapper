package Information;

import Data.DataObtainer;
import Data.Keys;
import Interfaces.IRealTimeBus;
import org.apache.http.client.utils.URIBuilder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class RealTimeBus implements IRealTimeBus {
    private String errorCode;
    private String errorMessage;
    private String numberOfResults;
    private String stopId;
    private String timeStamp;
    private ArrayList<RealTimeBusResult> results;

    public RealTimeBus(String stopNumber) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme(UrlConstants.HTTPS);
        builder.setHost(UrlConstants.RTPI_HOST);
        builder.setPath(UrlConstants.RTPI_PATH + UrlConstants.REAL_TIME_BUS_INFORMATION);
        builder.addParameter(UrlConstants.STOP_ID, stopNumber);

        JsonObject realTimeBusData = DataObtainer.getParsedDataObject(DataObtainer.getDataRequest(builder.build().toString()));

        this.errorCode = realTimeBusData.getJsonString(Keys.ERROR_CODE).toString();
        this.errorMessage = realTimeBusData.getJsonString(Keys.ERROR_MESSAGE).toString();
        this.numberOfResults = realTimeBusData.getJsonNumber(Keys.NUMBER_OF_RESULTS).toString();
        this.stopId = realTimeBusData.getJsonString(Keys.STOP_ID).toString();
        this.timeStamp = realTimeBusData.getJsonString(Keys.TIMESTAMP).toString();

        for (JsonValue resultData: realTimeBusData.getJsonArray(Keys.RESULTS)) {
            JsonReader jsonReader = Json.createReader(new StringReader(resultData.toString()));
            results.add(new RealTimeBusResult(jsonReader.readObject()));
            jsonReader.close();
        }
    }
    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public String getNumberOfResults() {
        return this.numberOfResults;
    }

    @Override
    public String getStopId() {
        return this.stopId;
    }

    @Override
    public String getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public ArrayList<RealTimeBusResult> getResults() {
        return this.results;
    }
}
