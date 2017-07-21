package Interfaces;

import Information.TimeTableDayResult;

import java.util.ArrayList;

public interface ITimeTableDay {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getStopId();
    String getTimeStamp();
    ArrayList<TimeTableDayResult> getResults();
}
