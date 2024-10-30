package Clasification;

import DataSets.DataPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kmeans {

    private int k;
    private List<DataPoint> centroides;
    private List<List<DataPoint>> clusters;

    public void kmeans(int k){
        this.k = k;
        this.centroides = new ArrayList<>();
        this.clusters = new ArrayList<>();
    }

    public void inicializacionCentroides(List<DataPoint> dataPoints){
        Random random = new Random();

        for (int i = 0; i < k; i++) {
            int randomIndex = random.nextInt(dataPoints.size());
            centroides.add(dataPoints.get(randomIndex));
        }
    }

    //Asignar cluster a cada punto mas cercano
    public void asignarCluster(List<DataPoint> dataPoints){

        clusters.clear();
        for (int i = 0; i < k ; i++) {
            clusters.add(new ArrayList<>());
        }
       
        for (DataPoint point:dataPoints){
            int clusterCloser = obtenerClusterMasCercano(point);
            clusters.get(clusterCloser).add(point);
        }

    }

    //Actualizar centroides
    public void actualizarCentroides(){
        for (int i = 0; i < k; i++) {
            List<DataPoint> cluster = clusters.get(i);
            if (!cluster.isEmpty()) {
                centroides.set(i, calcularCentroide(cluster));
            }
        }
    }

    //Calcular indice del centroide mas cercano
    private int obtenerClusterMasCercano(DataPoint point){

        double distMinima = Double.MAX_VALUE;
        int indiceCercano = 0;

        for (int i = 0; i < centroides.size(); i++) {
            double distancia = calcularDistancia(point, centroides.get(i));
            if (distancia < distMinima){
                distMinima = distancia;
                indiceCercano = i;
            }
            
        }

        return indiceCercano;
    }

    //Calcular el centroide promedio de un cluster
    private DataPoint calcularCentroide(List<DataPoint> cluster) {
        int numPuntos = cluster.size();
        double[] promedios = new double[cluster.get(0).getAttributes().length];

        for (DataPoint point : cluster) {
            for (int i = 0; i < point.getAttributes().length; i++) {
                promedios[i] += point.getAttributes()[i];
            }
        }

        for (int i = 0; i < promedios.length; i++) {
            promedios[i] /= numPuntos;
        }

        return new DataPoint(promedios);
    }

    //Calcular distancia entre dos puntos
    private double calcularDistancia(DataPoint p1, DataPoint p2) {
        double suma = 0.0;
        for (int i = 0; i < p1.getAttributes().length; i++) {
            suma += Math.pow(p1.getAttributes()[i] - p2.getAttributes()[i], 2);
        }
        return Math.sqrt(suma);
    }

    public List<List<DataPoint>> getClusters() {
        return clusters;
    }

    //Obtener el porcentaje de cada cluster
    public double[] calcularPorcentajes(int totalDataPoints) {
        double[] percentages = new double[clusters.size()];
        
        for (int i = 0; i < clusters.size(); i++) {
            percentages[i] = (double) clusters.get(i).size() / totalDataPoints;
        }
        
        return percentages;
    }

}
