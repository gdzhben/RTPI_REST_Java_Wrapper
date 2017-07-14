package Interfaces;

import java.util.ArrayList;

public interface ITimeTableFullResult {
    String getStartDayOfWeek();
    String getEndDayOfWeek();
    String getDestination();
    String getDestinationLocalized();
    String getLastUpdated();
    ArrayList<String> getDepartures();
}
