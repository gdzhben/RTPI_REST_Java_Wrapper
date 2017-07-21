package Information;

import Data.DataObtainer;
import Data.Keys;
import Information.TimeTableWeekResult;
import Interfaces.ITimeTableWeek;
import org.apache.http.client.utils.URIBuilder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class TimeTableWeek implements ITimeTableWeek {
    private String errorCode;
    private String errorMessage;
    private String numberOfResults;
    private String stopId;
    private String route;
    private String timeStamp;
    private ArrayList<TimeTableWeekResult> results = new ArrayList<>();

    public TimeTableWeek(String stopNumber) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme(UrlConstants.HTTPS);
        builder.setHost(UrlConstants.RTPI_HOST);
        builder.setPath(UrlConstants.RTPI_PATH + UrlConstants.TIME_TABLE);
        builder.addParameter(UrlConstants.TYPE, UrlConstants.WEEK);
        builder.addParameter(UrlConstants.STOP_ID, stopNumber);

        JsonObject timeTableData = DataObtainer.getParsedDataObject(DataObtainer.getDataRequest(builder.build().toString()));

        this.errorCode = timeTableData.getJsonString(Keys.ERROR_CODE).toString();
        this.errorMessage = timeTableData.getJsonString(Keys.ERROR_MESSAGE).toString();
        this.numberOfResults = timeTableData.getJsonNumber(Keys.NUMBER_OF_RESULTS).toString();
        this.stopId = timeTableData.getJsonString(Keys.STOP_ID).toString();
        // TODO Fix null route issue
        this.route = timeTableData.getJsonObject(Keys.ROUTE).getValueType().toString();
        this.timeStamp = timeTableData.getJsonString(Keys.TIMESTAMP).toString();

        for (JsonValue resultData: timeTableData.getJsonArray(Keys.RESULTS)) {
            JsonReader jsonReader = Json.createReader(new StringReader(resultData.toString()));
            results.add(new TimeTableWeekResult(jsonReader.readObject()));
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
    public String getRoute() {
        return this.route;
    }

    @Override
    public String getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public ArrayList<TimeTableWeekResult> getResults() {
        return this.results;
    }
}
