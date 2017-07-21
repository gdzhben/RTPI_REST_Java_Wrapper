package Information;

import Data.DataObtainer;
import Data.Keys;
import Interfaces.IRoute;
import org.apache.http.client.utils.URIBuilder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Route implements IRoute {
    private String errorCode;
    private String errorMessage;
    private String numberOfResults;
    private String route;
    private String timeStamp;
    private ArrayList<RouteResult> results = new ArrayList<>();

    public Route(String route, String operator) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme(UrlConstants.HTTPS);
        builder.setHost(UrlConstants.RTPI_HOST);
        builder.setPath(UrlConstants.RTPI_PATH + UrlConstants.BUS_INFORMATION);
        builder.addParameter(UrlConstants.STOP_ID, route);
        builder.addParameter(UrlConstants.OPERATOR, operator);

        JsonObject busStopData = DataObtainer.getParsedDataObject(DataObtainer.getDataRequest(builder.build().toString()));

        this.errorCode = busStopData.getJsonString(Keys.ERROR_CODE).toString();
        this.errorMessage = busStopData.getJsonString(Keys.ERROR_MESSAGE).toString();
        this.numberOfResults = busStopData.getJsonNumber(Keys.NUMBER_OF_RESULTS).toString();
        this.route = busStopData.getJsonNumber(Keys.ROUTE).toString();
        this.timeStamp = busStopData.getJsonString(Keys.TIMESTAMP).toString();

        for (JsonValue resultData: busStopData.getJsonArray(Keys.RESULTS)) {
            JsonReader jsonReader = Json.createReader(new StringReader(resultData.toString()));
            results.add(new RouteResult(jsonReader.readObject()));
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
    public String getRoute() {
        return this.route;
    }

    @Override
    public String getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public ArrayList<RouteResult> getResults() {
        return this.results;
    }
}
