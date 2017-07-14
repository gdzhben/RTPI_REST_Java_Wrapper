package Information;

import Data.Keys;
import Interfaces.IBusStopResult;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.StringReader;
import java.util.ArrayList;

public class BusStopResult implements IBusStopResult {
    private String stopId;
    private String displayStopId;
    private String shortName;
    private String shortNameLocalized;
    private String fullName;
    private String fullNameLocalized;
    private String latitude;
    private String longitude;
    private String lastUpdated;
    private ArrayList<BusStopOperator> operators = new ArrayList<BusStopOperator>();

    BusStopResult(JsonObject resultData) {
        this.stopId = resultData.getJsonString(Keys.STOP_ID).toString();
        this.displayStopId = resultData.getJsonString(Keys.DISPLAY_STOP_ID).toString();
        this.shortName = resultData.getJsonString(Keys.SHORT_NAME).toString();
        this.shortNameLocalized = resultData.getJsonString(Keys.SHORT_NAME_LOCALIZED).toString();
        this.fullName = resultData.getJsonString(Keys.FULL_NAME).toString();
        this.fullNameLocalized = resultData.getJsonString(Keys.FULL_NAME_LOCALIZED).toString();
        this.latitude = resultData.getJsonString(Keys.LATITUDE).toString();
        this.longitude = resultData.getJsonString(Keys.LONGITUDE).toString();
        this.lastUpdated = resultData.getJsonString(Keys.LAST_UPDATED).toString();

        for (JsonValue operatorData: resultData.getJsonArray(Keys.OPERATORS)) {
            JsonReader jsonReader = Json.createReader(new StringReader(operatorData.toString()));
            operators.add(new BusStopOperator(jsonReader.readObject()));
            jsonReader.close();
        }
    }

    @Override
    public String getStopId() {
        return this.stopId;
    }

    @Override
    public String getDisplayStopId() {
        return this.displayStopId;
    }

    @Override
    public String getShortName() {
        return this.shortName;
    }

    @Override
    public String getShortNameLocalized() {
        return this.shortNameLocalized;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String getFullNameLocalized() {
        return this.fullNameLocalized;
    }

    @Override
    public String getLatitude() {
        return this.latitude;
    }

    @Override
    public String getLongitude() {
        return this.longitude;
    }

    @Override
    public String getLastUpdated() {
        return this.lastUpdated;
    }

    @Override
    public ArrayList<BusStopOperator> getOperators() {
        return this.operators;
    }
}
