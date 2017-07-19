package Main;

import Data.DataObtainer;
import Information.BusStop;
import Information.RealTimeBus;

import java.io.IOException;
import java.net.URISyntaxException;

class Test {
    public static void main(String[] args) throws IOException, URISyntaxException {
        BusStop bs = new BusStop("184");
        System.out.println(bs.getResults().get(0).getOperators().get(0).getRoutes().get(0));
        RealTimeBus rtb = new RealTimeBus("184");
        System.out.println(rtb.getTimeStamp());
    }
}
