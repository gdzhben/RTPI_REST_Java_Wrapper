package Interfaces;

import Information.OperatorResult;

import java.util.ArrayList;

public interface IOperator {
    String getErrorCode();
    String getErrorMessage();
    String getNumberOfResults();
    String getTimeStamp();
    ArrayList<OperatorResult> getResults();
}
