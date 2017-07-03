package Interfaces;

import Information.Result;

import java.util.ArrayList;

public interface IBusStop {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getTimeStamp();
    ArrayList<Result> getResults();
}
