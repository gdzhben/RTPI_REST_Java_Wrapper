package Information;

import Data.Keys;
import Interfaces.IRouteStop;

import javax.json.JsonObject;

public class RouteStop implements IRouteStop{
    private String stopId;
    private String displayStopId;
    private String shortName;
    private String shortNameLocalized;
    private String fullName;
    private String fullNameLocalized;
    private String latitude;
    private String longitude;

    public RouteStop(JsonObject jsonObject) {
        this.stopId = jsonObject.getJsonString(Keys.STOP_ID).toString();
        this.displayStopId = jsonObject.getJsonString(Keys.DISPLAY_STOP_ID).toString();
        this.shortName = jsonObject.getJsonString(Keys.SHORT_NAME).toString();
        this.shortNameLocalized = jsonObject.getJsonString(Keys.SHORT_NAME_LOCALIZED).toString();
        this.fullName = jsonObject.getJsonString(Keys.FULL_NAME).toString();
        this.fullNameLocalized = jsonObject.getJsonString(Keys.FULL_NAME_LOCALIZED).toString();
        this.latitude = jsonObject.getJsonString(Keys.LATITUDE).toString();
        this.longitude = jsonObject.getJsonString(Keys.LONGITUDE).toString();
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
}
