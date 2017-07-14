package Interfaces;

import Information.BusStopOperator;

import java.util.ArrayList;

public interface IBusStopResult {
    String getStopId();
    String getDisplayStopId();
    String getShortName();
    String getShortNameLocalized();
    String getFullName();
    String getFullNameLocalized();
    String getLatitude();
    String getLongitude();
    String getLastUpdated();
    ArrayList<BusStopOperator> getOperators();
}
