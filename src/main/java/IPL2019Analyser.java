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
    Map<SortField, Comparator<IPLCSVDTO>> sortMap = null;

    public int loadData(Player player, String... csvFilePath) throws IPLAnalyserException, IOException {
        iplMap = new IPLAdapterFactory().getIPLAdapter(player,csvFilePath);
        iplList = new ArrayList<>(iplMap.values());
        return iplMap.size();
    }



    public IPL2019Analyser(){
        this.sortMap = new HashMap<>();
        this.sortMap.put(SortField.AVERAGE, Comparator.comparing(ipl -> ipl.averages));
        this.sortMap.put(SortField.STRIKE_RATES, Comparator.comparing(ipl -> ipl.strikeRates));
        this.sortMap.put(SortField.SIXES_AND_FOURS, Comparator.comparing(ipl -> ipl.sixes+ipl.fours));

        Comparator<IPLCSVDTO> iplComparator = Comparator.comparing(ipl -> ipl.sixes+ipl.fours);
        this.sortMap.put(SortField.STRIKE_RATES_WITH_SIXES_AND_FOURS, iplComparator.thenComparing(ipl ->ipl.strikeRates));

        this.sortMap.put(SortField.BEST_AVERAGE_AND_STRIKE_RATES, Comparator.comparing(ipl -> ipl.averages+ipl.strikeRates));
        this.sortMap.put(SortField.BEST_RUN_AND_AVERAGES, Comparator.comparing(ipl -> ipl.runs+ipl.averages));

        this.sortMap.put(SortField.ECONOMY_RATES, Comparator.comparing(ipl -> ipl.economyRates));

        Comparator<IPLCSVDTO> iplComparator1 = Comparator.comparing(ipl -> ipl.fiveWickets+ipl.fourWickets);
        this.sortMap.put(SortField.BEST_STRIKE_RATES_WITH_5WICKETS_AND_4WICKETS, iplComparator1.thenComparing(ipl ->ipl.strikeRates));

        this.sortMap.put(SortField.BEST_AVERAGE_WITH_STRIKE_RATES, Comparator.comparing(ipl -> ipl.averages+ipl.strikeRates));

        Comparator<IPLCSVDTO> iplComparator2 = Comparator.comparing(ipl -> ipl.wickets);
        this.sortMap.put(SortField.MAX_WICKETS_AND_BEST_AVERAGE, iplComparator2.thenComparing(ipl ->ipl.averages));



    }


    public String getSortedData(SortField field) throws IPLAnalyserException {
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
