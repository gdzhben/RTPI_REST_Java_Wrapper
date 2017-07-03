package Interfaces;

import Information.Operator;

import java.util.ArrayList;

public interface IResult {
    String getStopId();
    String getDisplayStopId();
    String getShortName();
    String getShortNameLocalized();
    String getFullName();
    String getFullNameLocalized();
    String getLatitude();
    String getLongitude();
    String getLastUpdated();
    ArrayList<Operator> getOperators();
}
