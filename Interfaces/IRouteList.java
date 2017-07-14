package Interfaces;

import Information.RouteListResult;

import java.util.ArrayList;

public interface IRouteList {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getTimeStamp();
    ArrayList<RouteListResult> getResults();
}
