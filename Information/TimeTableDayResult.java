package Information;

import Data.Keys;
import Interfaces.ITimeTableDayResult;

import javax.json.JsonObject;

public class TimeTableDayResult implements ITimeTableDayResult{
    private String arrivalDateTime;
    private String destination;
    private String destinationLocalized;
    private String operator;
    private String lowFloorStatus;
    private String route;

    public TimeTableDayResult(JsonObject jsonObject) {
        this.arrivalDateTime = jsonObject.getJsonString(Keys.ARRIVAL_DATE_TIME).toString();
        this.destination = jsonObject.getJsonString(Keys.DESTINATION).toString();
        this.destinationLocalized = jsonObject.getJsonString(Keys.DESTINATION_LOCALIZED).toString();
        this.operator = jsonObject.getJsonString(Keys.OPERATOR).toString();
        this.lowFloorStatus = jsonObject.getJsonString(Keys.LOW_FLOOR_STATUS).toString();
        this.route = jsonObject.getJsonString(Keys.ROUTE).toString();
    }

    @Override
    public String getArrivalDateTime() {
        return this.arrivalDateTime;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public String getDestinationLocalized() {
        return this.destinationLocalized;
    }

    @Override
    public String getOperator() {
        return this.operator;
    }

    @Override
    public String getLowFloorStatus() {
        return this.lowFloorStatus;
    }

    @Override
    public String getRoute() {
        return this.route;
    }
}
