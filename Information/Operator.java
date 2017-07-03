package Information;

import Data.Keys;
import Interfaces.IOperator;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;

public class Operator implements IOperator {
    private String name;
    private ArrayList<String> routes = new ArrayList<String>();

    public Operator(JsonObject operatorData) {
        this.name = operatorData.getJsonString(Keys.NAME).toString();

        for (JsonValue route: operatorData.getJsonArray(Keys.OPERATORS)) {
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
