package Information;

import Data.DataObtainer;
import Data.Keys;
import Exceptions.MaxResultsNeededException;
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
    private ArrayList<RealTimeBusResult> results = new ArrayList<>();

    public RealTimeBus(String stopId, String routeId, String maxResults, String operator, String format) throws URISyntaxException, IOException, MaxResultsNeededException {
        try {
            Integer.parseInt(maxResults);
        } catch (NumberFormatException e) {
            throw new MaxResultsNeededException();
        }

        URIBuilder builder = new URIBuilder();
        builder.setScheme(UrlConstants.HTTPS);
        builder.setHost(UrlConstants.RTPI_HOST);
        builder.setPath(UrlConstants.RTPI_PATH + UrlConstants.REAL_TIME_BUS_INFORMATION);
        builder.addParameter(UrlConstants.STOP_ID, stopId);
        builder.addParameter(UrlConstants.ROUTE_ID, routeId);
        builder.addParameter(UrlConstants.MAX_RESULTS, maxResults);
        builder.addParameter(UrlConstants.OPERATOR, operator);
        builder.addParameter(UrlConstants.FORMAT, format);

        System.out.println(builder.build().toString());

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
