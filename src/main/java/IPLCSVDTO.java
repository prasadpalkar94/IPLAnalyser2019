public class IPLCSVDTO {
    public String player;
    public double averages;
    public int fours;
    public int sixes;
    public int runs;
    public double strikeRates;


    public IPLCSVDTO(IPL2019CSV ipl2019CSV) {
        player= ipl2019CSV.player;
        averages=ipl2019CSV.averages;
        strikeRates=ipl2019CSV.strikeRates;
        fours=ipl2019CSV.fours;
        sixes=ipl2019CSV.sixes;
        runs=ipl2019CSV.runs;
    }

}
