public interface Result {
    public String getStopId();
    public String getDisplayStopId();
    public String getShortName();
    public String getShortNameLocalized();
    public String getFullName();
    public String getFullNameLocalized();
    public String getLatitude();
    public String getLongitude();
    public String getLastUpdated();
    public ArrayList<Operator> getOperators();
}
