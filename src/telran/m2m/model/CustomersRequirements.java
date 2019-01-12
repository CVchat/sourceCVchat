package telran.m2m.model;

public class CustomersRequirements {
    /**
     * Minimum room temperature in degrees Celsius based on customer's requirements,
     * usually meant in conditions without people and animals,
     * e.g. should be higher than 10 degrees Celsius for rooms with water heating
     */
    private double minRoomTemperatureC;

    /**
     * Maximum room temperature in degrees Celsius based on customer's requirements,
     * usually meant in conditions without people and animals,
     * e.g. should be lower than 40 degrees Celsius for rooms when people and animals
     * can come in the nearest feature
     */
    private double maxRoomTemperatureC;

    public double getMinRoomTemperatureC() {
        return minRoomTemperatureC;
    }

    public void setMinRoomTemperatureC(double minRoomTemperatureC) {
        this.minRoomTemperatureC = minRoomTemperatureC;
    }

    public double getMaxRoomTemperatureC() {
        return maxRoomTemperatureC;
    }

    public void setMaxRoomTemperatureC(double maxRoomTemperatureC) {
        this.maxRoomTemperatureC = maxRoomTemperatureC;
    }

    @Override
    public String toString() {
        return "CustomersRequirements{" +
                "minRoomTemperatureC=" + minRoomTemperatureC +
                ", maxRoomTemperatureC=" + maxRoomTemperatureC +
                '}';
    }
}
