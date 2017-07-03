package Information;

import Interfaces.IOperator;

import javax.json.JsonObject;
import java.util.ArrayList;

/**
 * Created by francis on 03/07/17.
 */
public class Operator implements IOperator {
    public Operator(JsonObject jsonObject) {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public ArrayList<String> getRoutes() {
        return null;
    }
}
