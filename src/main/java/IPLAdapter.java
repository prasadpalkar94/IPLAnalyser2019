import com.csvbuilder.CSVBuilderFactory;
import com.csvbuilder.ICSVInterface;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter {
    public abstract Map<String, IPLCSVDTO> loadMostRunData(String... csvFilePath) throws IOException;


    public <E> Map<String, IPLCSVDTO> loadCensusData(Class <E> iplCSVClass,String csvFilePath ) {
        Map<String, IPLCSVDTO> iplMap= new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVInterface csvBuilder= CSVBuilderFactory.createCSVBuilder();
            Iterator<E> censusCSVIterator=csvBuilder.getStateCSVIterator(reader,iplCSVClass);
            Iterable<E> csvIterable = () -> censusCSVIterator;
            if(iplCSVClass.getName().equals("IPL2019CSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPL2019CSV.class::cast)
                        .forEach(batsman -> iplMap.put(batsman.player, new IPLCSVDTO(batsman)));
            }
            return iplMap;

        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (IllegalStateException e){
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}
