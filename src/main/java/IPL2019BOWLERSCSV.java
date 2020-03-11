import com.opencsv.bean.CsvBindByName;

public class IPL2019BOWLERSCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;


    @CsvBindByName(column = "Avg", required = true)
    public double averages;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRates;

    @CsvBindByName(column = "4w", required = true)
    public int fourWickets;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWickets;

    @CsvBindByName(column = "Econ", required = true)
    public double economyRates;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @Override
    public String toString() {
        return "IPL2019BOWLERSCSV{" +
                "player='" + player + '\'' +
                ", averages=" + averages +
                ", strikeRates=" + strikeRates +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                ", economyRates=" + economyRates +
                ", wickets=" + wickets +
                '}';
    }
}
