package Exceptions;

public class MaxResultsNeededException extends Exception {
    public MaxResultsNeededException() {
        System.out.println("Integer required for maxresults parameter.");
    }
}
