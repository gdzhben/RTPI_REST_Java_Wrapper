package Interfaces;

import Information.TimeTableWeekResult;

import java.util.ArrayList;

public interface ITimeTableWeek {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getStopId();
    String getRoute();
    String getTimeStamp();
    ArrayList<TimeTableWeekResult> getResults();
}
