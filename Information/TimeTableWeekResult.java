package Information;

import Data.Keys;
import Interfaces.ITimeTableWeekResult;

import javax.json.*;
import java.util.ArrayList;

public class TimeTableWeekResult implements ITimeTableWeekResult {
    private String startDayOfWeek;
    private String endDayOfWeek;
    private String destination;
    private String destinationLocalized;
    private String lastUpdated;
    private ArrayList<String> departures = new ArrayList<>();

    public TimeTableWeekResult(JsonObject jsonObject) {
        this.startDayOfWeek = jsonObject.getJsonString(Keys.START_DAY_OF_WEEK).toString();
        this.endDayOfWeek = jsonObject.getJsonString(Keys.END_DAY_OF_WEEK).toString();
        this.destination = jsonObject.getJsonString(Keys.DESTINATION).toString();
        this.destinationLocalized = jsonObject.getJsonString(Keys.DESTINATION_LOCALIZED).toString();
        this.lastUpdated = jsonObject.getJsonString(Keys.LAST_UPDATED).toString();

        for (JsonValue departure: jsonObject.getJsonArray(Keys.DEPARTURES)) {
            departures.add(departure.toString());
        }
    }

    @Override
    public String getStartDayOfWeek() {
        return this.startDayOfWeek;
    }

    @Override
    public String getEndDayOfWeek() {
        return this.endDayOfWeek;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public String getDestinationLocalized() {
        return this.destinationLocalized;
    }

    @Override
    public String getLastUpdated() {
        return this.lastUpdated;
    }

    @Override
    public ArrayList<String> getDepartures() {
        return this.departures;
    }
}
