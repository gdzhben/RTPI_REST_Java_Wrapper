package Information;

import Data.DataObtainer;
import Data.Keys;
import Exceptions.MaxResultsNeededException;
import Interfaces.ITimeTableDay;
import org.apache.http.client.utils.URIBuilder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class TimeTableDay implements ITimeTableDay {
    private String errorCode;
    private String errorMessage;
    private String numberOfResults;
    private String stopId;
    private String timeStamp;
    ArrayList<TimeTableDayResult> results = new ArrayList<>();

    public TimeTableDay(String stopId, String routeId, String dateTime, String maxResults, String operator, String format) throws URISyntaxException, IOException, MaxResultsNeededException {
        try {
            Integer.parseInt(maxResults);
        } catch (NumberFormatException e) {
            throw new MaxResultsNeededException();
        }

        // Date format is dd/mm/yyyy
        // TODO fix encoding of slashes by URIBuilder for datetime
        URIBuilder builder = new URIBuilder();
        builder.setScheme(UrlConstants.HTTPS);
        builder.setHost(UrlConstants.RTPI_HOST);
        builder.setPath(UrlConstants.RTPI_PATH + UrlConstants.TIME_TABLE);
        builder.addParameter(UrlConstants.TYPE, UrlConstants.DAY);
        builder.addParameter(UrlConstants.STOP_ID, stopId);
        builder.addParameter(UrlConstants.ROUTE_ID, routeId);
        builder.addParameter(UrlConstants.DATE_TIME, dateTime);
        builder.addParameter(UrlConstants.MAX_RESULTS, maxResults);
        builder.addParameter(UrlConstants.OPERATOR, operator);
        builder.addParameter(UrlConstants.FORMAT, format);

        System.out.println(builder.build().toString());

        JsonObject timeTableData = DataObtainer.getParsedDataObject(DataObtainer.getDataRequest(builder.build().toString()));

        this.errorCode = timeTableData.getJsonString(Keys.ERROR_CODE).toString();
        this.errorMessage = timeTableData.getJsonString(Keys.ERROR_MESSAGE).toString();
        this.numberOfResults = timeTableData.getJsonNumber(Keys.NUMBER_OF_RESULTS).toString();
        this.stopId = timeTableData.getJsonNumber(Keys.NUMBER_OF_RESULTS).toString();
        this.timeStamp = timeTableData.getJsonString(Keys.TIMESTAMP).toString();

        for (JsonValue resultData: timeTableData.getJsonArray(Keys.RESULTS)) {
            JsonReader jsonReader = Json.createReader(new StringReader(resultData.toString()));
            results.add(new TimeTableDayResult(jsonReader.readObject()));
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
    public ArrayList<TimeTableDayResult> getResults() {
        return this.results;
    }
}
