public class IPLCSVDTO {
    public String player;
    public double averages;
    public int fours;
    public int sixes;
    public int runs;
    public double strikeRates;
    public int fourWickets;
    public int fiveWickets;
    public double economyRates;
    public int wickets;




    public IPLCSVDTO(IPL2019CSV ipl2019CSV) {
        player= ipl2019CSV.player;
        averages=ipl2019CSV.averages;
        strikeRates=ipl2019CSV.strikeRates;
        fours=ipl2019CSV.fours;
        sixes=ipl2019CSV.sixes;
        runs=ipl2019CSV.runs;
    }

    public IPLCSVDTO(IPL2019BOWLERSCSV ipl2019Bowlers){
        player=ipl2019Bowlers.player;
        strikeRates=ipl2019Bowlers.strikeRates;
        economyRates=ipl2019Bowlers.economyRates;
        fourWickets=ipl2019Bowlers.fourWickets;
        fiveWickets=ipl2019Bowlers.fiveWickets;
        averages=ipl2019Bowlers.averages;
        wickets=ipl2019Bowlers.wickets;
    }

}
