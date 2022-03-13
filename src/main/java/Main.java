import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "data.xml";
        String writeFile_1 = "data_1.json";
        File xmlFile = new File(path);
        List<Emloyee> list_1 = XMLRead.parseXML(xmlFile);

        String writeFile_2 = "data_2.json";
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Emloyee> list_2 = CSVRead.parseCSV(columnMapping, fileName);


        for(Emloyee emp : list_1) {
            System.out.println(emp.toString());
            System.out.println("\n");
        }

        String json_1 = ToJSON.ListToJson(list_1);
        String json_2 = ToJSON.ListToJson(list_2);

        ToJSON.writeString(json_1, writeFile_1);
        ToJSON.writeString(json_2, writeFile_2);
    }
}