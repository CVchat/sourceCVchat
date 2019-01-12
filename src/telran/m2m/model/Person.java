package telran.m2m.model;

/**
 * Model Object for the Person in the monitoring and control system for buildings
 * made for generation of imitation model to test the functionality of microservices project
 * @author Andrey Lavrinenko
 */
public class Person {

    /**
     * Identification number of Person
     */
    private int idPerson;

    /**
     * Heat production from person to the room's air, in kilowatts per hour
     */
    private double heatKwtPerHour;

    /**
     * Minimal comfortable temperature recommended by doctor
     */
    private double minComfortableTemperatureC;

    /**
     * Maximum comfortable temperature recommended by doctor
     */
    private double maxComfortableTemperatureC;

    /**
     * Maximum Carbon Dioxide CO2 in volume percent recommended by doctor
     */
    private double maxCO2Persent;

    /**
     * Minimum Oxygen O2 in volume percent recommended by doctor
     */
    private double minOxygenPersent;

    /**
     * Oxygen consumption in liters per hour
     */
    private double consumptionOxygenLiterPerHour;

    /**
     * Carbon Dioxide production in liters per hour
     */
    private double productionCO2LiterPerHour;

    public Person(int idPerson, double heatKwtPerHour, double minComfortableTemperatureC, double maxComfortableTemperatureC, double maxCO2Persent, double minOxygenPersent, double consumptionOxygenLiterPerHour, double productionCO2LiterPerHour) {
        this.idPerson = idPerson;
        this.heatKwtPerHour = heatKwtPerHour;
        this.minComfortableTemperatureC = minComfortableTemperatureC;
        this.maxComfortableTemperatureC = maxComfortableTemperatureC;
        this.maxCO2Persent = maxCO2Persent;
        this.minOxygenPersent = minOxygenPersent;
        this.consumptionOxygenLiterPerHour = consumptionOxygenLiterPerHour;
        this.productionCO2LiterPerHour = productionCO2LiterPerHour;
    }

    public Person(double heatKwtPerHour) {
        this.heatKwtPerHour = heatKwtPerHour;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public double getHeatKwtPerHour() {
        return heatKwtPerHour;
    }

    public void setHeatKwtPerHour(double heatKwtPerHour) {
        this.heatKwtPerHour = heatKwtPerHour;
    }

    public double getMinComfortableTemperatureC() {
        return minComfortableTemperatureC;
    }

    public void setMinComfortableTemperatureC(double minComfortableTemperatureC) {
        this.minComfortableTemperatureC = minComfortableTemperatureC;
    }

    public double getMaxComfortableTemperatureC() {
        return maxComfortableTemperatureC;
    }

    public void setMaxComfortableTemperatureC(double maxComfortableTemperatureC) {
        this.maxComfortableTemperatureC = maxComfortableTemperatureC;
    }

    public double getMaxCO2Persent() {
        return maxCO2Persent;
    }

    public void setMaxCO2Persent(double maxCO2Persent) {
        this.maxCO2Persent = maxCO2Persent;
    }

    public double getMinOxygenPersent() {
        return minOxygenPersent;
    }

    public void setMinOxygenPersent(double minOxygenPersent) {
        this.minOxygenPersent = minOxygenPersent;
    }

    public double getConsumptionOxygenLiterPerHour() {
        return consumptionOxygenLiterPerHour;
    }

    public void setConsumptionOxygenLiterPerHour(double consumptionOxygenLiterPerHour) {
        this.consumptionOxygenLiterPerHour = consumptionOxygenLiterPerHour;
    }

    public double getProductionCO2LiterPerHour() {
        return productionCO2LiterPerHour;
    }

    public void setProductionCO2LiterPerHour(double productionCO2LiterPerHour) {
        this.productionCO2LiterPerHour = productionCO2LiterPerHour;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", heatKwtPerHour=" + heatKwtPerHour +
                ", minComfortableTemperatureC=" + minComfortableTemperatureC +
                ", maxComfortableTemperatureC=" + maxComfortableTemperatureC +
                ", maxCO2Persent=" + maxCO2Persent +
                ", minOxygenPersent=" + minOxygenPersent +
                ", consumptionOxygenLiterPerHour=" + consumptionOxygenLiterPerHour +
                ", productionCO2LiterPerHour=" + productionCO2LiterPerHour +
                '}';
    }
}
