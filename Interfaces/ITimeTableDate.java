package Interfaces;

import Information.RealTimeBusResult;
import Information.TimeTableResult;

import java.util.ArrayList;

public interface ITimeTableDate {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getStopId();
    String getTimeStamp();
    ArrayList<TimeTableResult> getResults();
}
