package Main;

import Data.DataObtainer;

import java.io.IOException;

class Test {
    public static void main(String[] args) throws IOException {
        System.out.println(DataObtainer.getDataRequest("https://data.dublinked.ie/cgi-bin/rtpi/busstopinformation?stopid=1433&format-json"));
    }
}
