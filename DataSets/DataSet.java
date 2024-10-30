package DataSets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataSet {
    
    String csvFile = "DataSets/Country-data.csv";
    private List<DataPoint> dataPoints = new ArrayList<>();

    public void loadDataSet() {
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length == 10) {
                    DataPoint dataPoint = new DataPoint(
                        values[0],
                        Double.parseDouble(values[1]),
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]),
                        Double.parseDouble(values[6]),
                        Double.parseDouble(values[7]),
                        Double.parseDouble(values[8]),
                        Double.parseDouble(values[9])
                    );
                    dataPoints.add(dataPoint);
                    }   
                }

            } catch (IOException e) {
            e.printStackTrace();
            } catch (NumberFormatException e){
            System.out.println("Error de formato en el archivo CSV: " + e);
        }   
    }

    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }

}

