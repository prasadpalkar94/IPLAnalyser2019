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
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.AVERAGE);
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
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.STRIKE_RATES);
            IPL2019CSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019CSV[].class);
            Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkMethodForMaximumSixesAndFours() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.SIXES_AND_FOURS);
            IPL2019CSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019CSV[].class);
            Assert.assertEquals("Andre Russell", iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkMethodForMaxSixesAndFoursWithBestStrikeRates() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.STRIKE_RATES_WITH_SIXES_AND_FOURS);
            IPL2019CSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019CSV[].class);
            Assert.assertEquals("Andre Russell", iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkMethodForBestAveragesAndBestStrikeRates() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.BEST_AVERAGE_AND_STRIKE_RATES);
            IPL2019CSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019CSV[].class);
            Assert.assertEquals("Ishant Sharma", iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkMethodForMaxRUNSAndBestStrikeRates() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BATSMAN, INDIA_CRICKET_RUN_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.BEST_RUN_AND_AVERAGES);
            IPL2019CSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019CSV[].class);
            Assert.assertEquals("David Warner", iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkMethodForTopBowlingAverage() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BOWLER, IPL_CRICKET_WICKETS_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.AVERAGE);
            IPL2019BOWLERSCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019BOWLERSCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham",iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
