package Main;

import Data.DataObtainer;
import Information.BusStop;

import java.io.IOException;
import java.net.URISyntaxException;

class Test {
    public static void main(String[] args) throws IOException, URISyntaxException {
        BusStop bs = new BusStop("184");
        System.out.println(bs.getResults().get(0).getStopId());

        //System.out.println(DataObtainer.getDataRequest("https://data.dublinked.ie/cgi-bin/rtpi/busstopinformation?stopid=1433&format-json"));
    }
}
