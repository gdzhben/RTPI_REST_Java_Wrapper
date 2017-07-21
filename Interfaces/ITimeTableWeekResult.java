package Interfaces;

import java.util.ArrayList;

public interface ITimeTableWeekResult {
    String getStartDayOfWeek();
    String getEndDayOfWeek();
    String getDestination();
    String getDestinationLocalized();
    String getLastUpdated();
    ArrayList<String> getDepartures();
}
