import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CricketAnalyserTest {
    private static final String INDIA_CRICKET_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_CRICKET_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    //UC1
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

    //UC2
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

    //UC3
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

    //UC4
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

    //UC5
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

    //UC6
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

    //UC7
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
    
    //UC8


    @Test
    public void checkMethodForTopStrikeRatesBowling() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BOWLER, IPL_CRICKET_WICKETS_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.STRIKE_RATES);
            IPL2019BOWLERSCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019BOWLERSCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham",iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //UC9
    @Test
    public void checkMethodForBestEconomyRatesForBowling() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BOWLER, IPL_CRICKET_WICKETS_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.ECONOMY_RATES);
            IPL2019BOWLERSCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019BOWLERSCSV[].class);
            Assert.assertEquals("Ben Cutting",iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //UC10
    @Test
    public void BestStrikeRatesWithFiveWicketsAndFourWickets() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BOWLER, IPL_CRICKET_WICKETS_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.BEST_STRIKE_RATES_WITH_5WICKETS_AND_4WICKETS);
            IPL2019BOWLERSCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019BOWLERSCSV[].class);
            Assert.assertEquals("Lasith Malinga",iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //UC11
    @Test
    public void BestStrikeRatesWithBestBowlingAverage() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BOWLER, IPL_CRICKET_WICKETS_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.BEST_AVERAGE_WITH_STRIKE_RATES);
            IPL2019BOWLERSCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019BOWLERSCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham",iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //UC12
    @Test
    public void MaxWicketsANDBestBowlingAverage() {
        try {
            IPL2019Analyser ipl2019Analyser = new IPL2019Analyser();
            ipl2019Analyser.loadData(IPL2019Analyser.Player.BOWLER, IPL_CRICKET_WICKETS_CSV_FILE_PATH);
            String checkPlayer = ipl2019Analyser.getSortedData(SortField.MAX_WICKETS_AND_BEST_AVERAGE);
            IPL2019BOWLERSCSV[] iplCSV = new Gson().fromJson(checkPlayer, IPL2019BOWLERSCSV[].class);
            Assert.assertEquals("Imran Tahir",iplCSV[0].player);
        }catch (IPLAnalyserException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
