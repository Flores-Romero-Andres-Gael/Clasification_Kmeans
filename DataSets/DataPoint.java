package DataSets;

public class DataPoint {
    private String country;
    private double gdp;
    private double childMortality;
    private double exports;
    private double health;
    private double imports;
    private double income;
    private double inflation;
    private double lifeExpectancy;
    private double totalPopulation;

    public DataPoint(String country, double gdp, double childMortality, double exports, 
                     double health, double imports, double income, 
                     double inflation, double lifeExpectancy, double totalPopulation) {
        this.country = country;
        this.gdp = gdp;
        this.childMortality = childMortality;
        this.exports = exports;
        this.health = health;
        this.imports = imports;
        this.income = income;
        this.inflation = inflation;
        this.lifeExpectancy = lifeExpectancy;
        this.totalPopulation = totalPopulation;
    }

    public DataPoint(double[] attributes) {
        if (attributes.length != 9) {
            throw new IllegalArgumentException("Se requieren 9 atributos.");
        }
        this.gdp = attributes[0];
        this.childMortality = attributes[1];
        this.exports = attributes[2];
        this.health = attributes[3];
        this.imports = attributes[4];
        this.income = attributes[5];
        this.inflation = attributes[6];
        this.lifeExpectancy = attributes[7];
        this.totalPopulation = attributes[8];
    }

    public double[] getAttributes() {
        return new double[]{gdp, childMortality, exports, health, imports, income, inflation, lifeExpectancy, totalPopulation};
    }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getGdp() { return gdp; }
    public void setGdp(double gdp) { this.gdp = gdp; }

    public double getChildMortality() { return childMortality; }
    public void setChildMortality(double childMortality) { this.childMortality = childMortality; }

    public double getExports() { return exports; }
    public void setExports(double exports) { this.exports = exports; }

    public double getHealth() { return health; }
    public void setHealth(double health) { this.health = health; }

    public double getImports() { return imports; }
    public void setImports(double imports) { this.imports = imports; }

    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }

    public double getInflation() { return inflation; }
    public void setInflation(double inflation) { this.inflation = inflation; }

    public double getLifeExpectancy() { return lifeExpectancy; }
    public void setLifeExpectancy(double lifeExpectancy) { this.lifeExpectancy = lifeExpectancy; }

    public double getTotalPopulation() { return totalPopulation; }
    public void setTotalPopulation(double totalPopulation) { this.totalPopulation = totalPopulation; }
}
