package Main;

import Clasification.Kmeans;
import DataSets.DataSet;
import DataSets.DataPoint;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        dataSet.loadDataSet();
        
        List<DataPoint> dataPoints = dataSet.getDataPoints();
        
        int k = 3; // Número de clusters
        Kmeans kmeans = new Kmeans();
        kmeans.kmeans(k);
        kmeans.inicializacionCentroides(dataPoints);
        
        double[] prevPercentages = new double[k];
        int maxIterations = 100;
        
        for (int i = 0; i < maxIterations; i++) {
            kmeans.asignarCluster(dataPoints);
            kmeans.actualizarCentroides();
        
            double[] currentPercentages = kmeans.calcularPorcentajes(dataPoints.size());
 
            boolean isStable = true;
            for (int j = 0; j < k; j++) {
                if (Math.abs(currentPercentages[j] - prevPercentages[j]) > 0.001) { 
                    isStable = false;
                    break;
                }
            }
            
            if (isStable) {
                System.out.println("\n---Los clusters se han estabilizado después de " + (i + 1) + " iteraciones.---\n");
                break;
            }
            
            prevPercentages = currentPercentages;
        }

        // Mostrar el porcentaje final y los datos de cada cluster
        List<List<DataPoint>> clusters = kmeans.getClusters();
        int totalDataPoints = clusters.stream().mapToInt(List::size).sum(); // Cuenta total de puntos
        
        for (int i = 0; i < clusters.size(); i++) {
            List<DataPoint> cluster = clusters.get(i);
            double percentage = (double) cluster.size() / totalDataPoints * 100;
        
            System.out.printf("Cluster %d: %.2f%%\n", (i + 1), percentage);
            System.out.println("Datos pertenecientes a Cluster " + (i + 1) + ":");
        
            for (DataPoint point : cluster) {
                System.out.println(" - " + point.getCountry());
            }
        
            System.out.println();
        }
    }
}
