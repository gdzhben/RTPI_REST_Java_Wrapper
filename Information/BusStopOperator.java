package Information;

import Data.Keys;
import Interfaces.IBusStopOperator;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;

public class BusStopOperator implements IBusStopOperator {
    private String name;
    private ArrayList<String> routes = new ArrayList<String>();

    public BusStopOperator(JsonObject operatorData) {
        this.name = operatorData.getJsonString(Keys.NAME).toString();

        for (JsonValue route: operatorData.getJsonArray(Keys.ROUTES)) {
            routes.add(route.toString());
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<String> getRoutes() {
        return this.routes;
    }
}
