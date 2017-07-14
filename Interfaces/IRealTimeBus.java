package Interfaces;

import Information.BusStopResult;

import java.util.ArrayList;

public interface IRealTimeBus {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getStopId();
    String getTimeStamp();
    ArrayList<BusStopResult> getResults();
}
