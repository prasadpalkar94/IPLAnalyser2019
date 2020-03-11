import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class IPL2019Analyser {



    public enum Player{
        BATSMAN,BOWLER
    }
    List<IPLCSVDTO> iplList = null;
    Map<String, IPLCSVDTO> iplMap = null;
    Map<SortFieldBat, Comparator<IPLCSVDTO>> sortMap = null;

    public int loadMostRunData(Player player, String... csvFilePath) throws IPLAnalyserException, IOException {
        iplMap = new IPLAdapterFactory().getIPLAdapter(player,csvFilePath);
        iplList = new ArrayList<>(iplMap.values());
        return iplMap.size();
    }



    public IPL2019Analyser(){
        this.sortMap = new HashMap<>();
        this.sortMap.put(SortFieldBat.AVERAGE, Comparator.comparing(ipl -> ipl.averages));
        this.sortMap.put(SortFieldBat.STRIKE_RATES, Comparator.comparing(ipl -> ipl.strikeRates));
        this.sortMap.put(SortFieldBat.SIXES_AND_FOURS, Comparator.comparing(ipl -> ipl.sixes+ipl.fours));

    }


    public String getSortedData(SortFieldBat field) throws IPLAnalyserException {
        if (iplList == null || iplList.size() == 0) {
            throw new IPLAnalyserException("Census_Data_Issue",
                    IPLAnalyserException.ExceptionType.IPL_DATA_PROBLEM);
        }
        iplList = iplMap.values().stream().collect(Collectors.toList());
        this.sort(iplList, this.sortMap.get(field).reversed());
        String sorted = new Gson().toJson(iplList);
        return sorted;
    }


    private void sort(List<IPLCSVDTO> iplList, Comparator<IPLCSVDTO> iplComparator) {
        for (int i = 0; i < iplList.size() - 1; i++) {
            for (int j = 0; j < iplList.size() - i - 1; j++) {
                IPLCSVDTO ipl1 = iplList.get(j);
                IPLCSVDTO ipl2 = iplList.get(j + 1);
                if (iplComparator.compare(ipl1, ipl2) > 0) {
                    iplList.set(j, ipl2);
                    iplList.set(j + 1, ipl1);
                }
            }
        }
    }

}
