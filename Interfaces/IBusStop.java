package Interfaces;

import Information.BusStopResult;

import java.util.ArrayList;

public interface IBusStop {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getTimeStamp();
    ArrayList<BusStopResult> getResults();
}
