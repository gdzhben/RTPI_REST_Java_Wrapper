package Interfaces;

import Information.BusStopResult;
import Information.RealTimeBusResult;

import java.util.ArrayList;

public interface IRealTimeBus {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getStopId();
    String getTimeStamp();
    ArrayList<RealTimeBusResult> getResults();
}
