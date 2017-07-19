package Interfaces;

/**
 * Created by francis on 14/07/17.
 */
public interface IRealTimeBusResult {
    String getArrivalDateTime();
    String getDueTime();
    String getDepartureDateTime();
    String getDepartureDueTime();
    String getScheduledArrivalDateTime();
    String getScheduledDepartureDateTime();
    String getDestination();
    String getDestinationLocalized();
    String getOrigin();
    String getOriginLocalized();
    String getDirection();
    String getOperator();
    String getAdditionalInformation();
    String getLowFloorStatus();
    String getRoute();
    String getSourceTimeStamp();
}
