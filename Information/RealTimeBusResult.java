package Information;

import Data.Keys;
import Interfaces.IRealTimeBus;
import Interfaces.IRealTimeBusResult;

import javax.json.JsonObject;

public class RealTimeBusResult implements IRealTimeBusResult {
    private String arrivalDateTime;
    private String dueTime;
    private String departureDateTime;
    private String departureDueTime;
    private String scheduledArrivalDateTime;
    private String scheduledDepartureTime;
    private String destination;
    private String destinationLocalized;
    private String origin;
    private String originLocalized;
    private String direction;
    private String operator;
    private String additionalInformation;
    private String lowFloorStatus;
    private String route;
    private String sourceTimeStamp;

    public RealTimeBusResult(JsonObject resultData) {
        this.arrivalDateTime = resultData.getJsonString(Keys.ARRIVAL_DATE_TIME).toString();
        this.dueTime = resultData.getJsonString(Keys.DUE_TIME).toString();
        this.departureDateTime = resultData.getJsonString(Keys.DEPARTURE_DATE_TIME).toString();
        this.departureDueTime = resultData.getJsonString(Keys.DEPARTURE_DUE_TIME).toString();
        this.scheduledArrivalDateTime = resultData.getJsonString(Keys.SCHEDULED_ARRIVAL_TIME).toString();
        this.scheduledDepartureTime = resultData.getJsonString(Keys.SCHEDULED_DEPARTURE_TIME).toString();
        this.destination = resultData.getJsonString(Keys.DESTINATION).toString();
        this.destinationLocalized = resultData.getJsonString(Keys.DESTINATION_LOCALIZED).toString();
        this.origin = resultData.getJsonString(Keys.ORIGIN).toString();
        this.originLocalized = resultData.getJsonString(Keys.ORIGIN_LOCALIZED).toString();
        this.direction = resultData.getJsonString(Keys.DIRECTION).toString();
        this.operator = resultData.getJsonString(Keys.OPERATOR).toString();
        this.additionalInformation = resultData.getJsonString(Keys.ADDITIONAL_INFORMATION).toString();
        this.lowFloorStatus = resultData.getJsonString(Keys.LOW_FLOOR_STATUS).toString();
        this.route = resultData.getJsonString(Keys.ROUTE).toString();
        this.sourceTimeStamp = resultData.getJsonString(Keys.SOURCE_TIME_STAMP).toString();

    }

    @Override
    public String getArrivalDateTime() {
        return this.arrivalDateTime;
    }

    @Override
    public String getDueTime() {
        return this.dueTime;
    }

    @Override
    public String getDepartureDateTime() {
        return this.departureDateTime;
    }

    @Override
    public String getDepartureDueTime() {
        return this.departureDueTime;
    }

    @Override
    public String getScheduledArrivalDateTime() {
        return this.arrivalDateTime;
    }

    @Override
    public String getScheduledDepartureTime() {
        return this.scheduledDepartureTime;
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
    public String getOrigin() {
        return this.origin;
    }

    @Override
    public String getOriginLocalized() {
        return this.originLocalized;
    }

    @Override
    public String getDirection() {
        return this.direction;
    }

    @Override
    public String getOperator() {
        return this.operator;
    }

    @Override
    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    @Override
    public String getLowFloorStatus() {
        return this.lowFloorStatus;
    }

    @Override
    public String getRoute() {
        return this.route;
    }

    @Override
    public String getSourceTimeStamp() {
        return this.sourceTimeStamp;
    }
}
