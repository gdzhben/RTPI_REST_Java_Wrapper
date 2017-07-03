package Information;

import Data.Keys;
import Interfaces.IResult;

import javax.json.JsonObject;
import java.util.ArrayList;

public class Result implements IResult {
    private JsonObject data;

    Result(JsonObject resultData) {
        data = resultData;
    }

    @Override
    public String getStopId() {
        return data.getJsonString(Keys.STOP_ID).toString();
    }

    @Override
    public String getDisplayStopId() {
        return null;
    }

    @Override
    public String getShortName() {
        return null;
    }

    @Override
    public String getShortNameLocalized() {
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public String getFullNameLocalized() {
        return null;
    }

    @Override
    public String getLatitude() {
        return null;
    }

    @Override
    public String getLongitude() {
        return null;
    }

    @Override
    public String getLastUpdated() {
        return null;
    }

    @Override
    public ArrayList<Operator> getOperators() {
        return null;
    }
}
