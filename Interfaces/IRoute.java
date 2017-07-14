package Interfaces;

import Information.RouteResult;

import java.util.ArrayList;

public interface IRoute {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getRoute();
    String getTimeStamp();
    ArrayList<RouteResult> getResults();
}
