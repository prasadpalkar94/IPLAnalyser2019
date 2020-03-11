import java.io.IOException;
import java.util.Map;

public class IPLAdapterFactory {

    public Map<String,IPLCSVDTO> getIPLAdapter(IPL2019Analyser.Player player, String[] csvFilePath) throws IOException {
        if(player.equals(IPL2019Analyser.Player.BATSMAN))
            return new IPL2019Adapter().loadMostRunData(csvFilePath);
        else if(player.equals(IPL2019Analyser.Player.BOWLER))
            return new IPL2019Adapter().loadMostWicketsData(csvFilePath);
            throw new IPLAnalyserException("INVALID_CHOICE",
                    IPLAnalyserException.ExceptionType.INVALID_CHOICE);
    }
}
