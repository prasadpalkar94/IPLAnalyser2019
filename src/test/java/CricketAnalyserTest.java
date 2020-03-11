import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CricketAnalyserTest {
    private static final String INDIA_CRICKET_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_CRICKET_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenmethodToCheckTopBattingAverage() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadMostRunData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortFieldBat.AVERAGE);
            IPL2019CSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019CSV[].class);
            Assert.assertEquals("MS Dhoni", iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenmethodToCheckToStrikesRate() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadMostRunData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortFieldBat.STRIKE_RATES);
            IPL2019CSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019CSV[].class);
            Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
