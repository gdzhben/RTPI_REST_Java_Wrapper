package Information;

import Data.Keys;
import Interfaces.IRouteResult;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.StringReader;
import java.util.ArrayList;

public class RouteResult implements IRouteResult{
    private String operator;
    private String origin;
    private String originTranslated;
    private String destination;
    private String destinationTranslated;
    private String lastUpdated;
    private ArrayList<RouteStop> stops = new ArrayList<>();

    public RouteResult(JsonObject jsonObject) {
        this.operator = jsonObject.getJsonString(Keys.OPERATOR).toString();
        this.origin = jsonObject.getJsonString(Keys.ORIGIN).toString();
        this.originTranslated = jsonObject.getJsonString(Keys.ORIGIN_TRANSLATED).toString();
        this.destination = jsonObject.getJsonString(Keys.DESTINATION).toString();
        this.destinationTranslated = jsonObject.getJsonString(Keys.DESTINATION_TRANSLATED).toString();
        this.lastUpdated = jsonObject.getJsonString(Keys.LAST_UPDATED).toString();

        for (JsonValue stopData: jsonObject.getJsonArray(Keys.STOPS)) {
            JsonReader jsonReader = Json.createReader(new StringReader(stopData.toString()));
            stops.add(new RouteStop(jsonReader.readObject()));
            jsonReader.close();
        }
    }

    @Override
    public String getOperator() {
        return this.operator;
    }

    @Override
    public String getOrigin() {
        return this.origin;
    }

    @Override
    public String getOriginTranslated() {
        return this.originTranslated;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public String getDestinationTranslated() {
        return this.destinationTranslated;
    }

    @Override
    public String getLastUpdated() {
        return this.lastUpdated;
    }

    @Override
    public ArrayList<RouteStop> getStops() {
        return this.stops;
    }
}
