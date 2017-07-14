package Interfaces;

import Information.RouteStop;

import java.util.ArrayList;

public interface IRouteResult {
    String getOperator();
    String getOrigin();
    String getOriginTranslated();
    String getDestination();
    String getDestinationTranslated();
    String getLastUpdated();
    ArrayList<RouteStop> getStops();
}
