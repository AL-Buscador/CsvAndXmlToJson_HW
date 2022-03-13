import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVRead {
    static List<Emloyee> parseCSV(String[] columnMapping, String file) {
        List<Emloyee> newList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            ColumnPositionMappingStrategy<Emloyee> strategy =
                    new ColumnPositionMappingStrategy<>();
            strategy.setType(Emloyee.class);
            strategy.setColumnMapping(columnMapping[0], columnMapping[1], columnMapping[2], columnMapping[3],
                    columnMapping[4]);

            CsvToBean<Emloyee> csv = new CsvToBeanBuilder<Emloyee>(reader)
                    .withMappingStrategy(strategy)
                    .build();

            newList = csv.parse();
        }catch (IOException ex) {
            ex.printStackTrace();;
        }
        return newList;
    }
}
