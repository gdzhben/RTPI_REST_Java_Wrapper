package Main;

import Data.DataObtainer;
import Exceptions.MaxResultsNeededException;
import Information.BusStop;
import Information.RealTimeBus;
import Information.TimeTableDay;
import Information.TimeTableWeek;

import java.io.IOException;
import java.net.URISyntaxException;

class Test {
    public static void main(String[] args) throws IOException, URISyntaxException, MaxResultsNeededException {
        BusStop bs = new BusStop("184");
        System.out.println(bs.getNumberOfResults());
        RealTimeBus rtb = new RealTimeBus("184", "", "10", "", "");
        System.out.println(rtb.getNumberOfResults());
        TimeTableDay ttd = new TimeTableDay("184");
        System.out.println(ttd.getTimeStamp());
//        TimeTableWeek ttw = new TimeTableWeek("184");
//        System.out.println(ttw.getNumberOfResults());
    }
}
