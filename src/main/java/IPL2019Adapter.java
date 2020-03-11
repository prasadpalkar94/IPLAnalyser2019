import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IPL2019Adapter extends IPLAdapter {


    @Override
    public Map<String, IPLCSVDTO> loadMostRunData(String... csvFilePath) throws IOException {
        Map<String, IPLCSVDTO> iplMap = new HashMap<>();
        iplMap= super.loadIPLData(IPL2019CSV.class,csvFilePath[0]);
        return iplMap;
    }

    public Map<String, IPLCSVDTO> loadMostWicketsData(String... csvFilePath) throws IOException {
        Map<String, IPLCSVDTO> iplMap = new HashMap<>();
        iplMap= super.loadIPLData(IPL2019BOWLERSCSV.class,csvFilePath[0]);
        return iplMap;
    }
}
