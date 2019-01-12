package telran.m2m.model;

import telran.m2m.dto.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Room Simulation model class for the monitoring and control system for buildings
 * made for generation of imitation model to test the functionality of microservices project
 * @author Andrey Lavrinenko
 */
public class RoomSimulation {

    /**
     * Minimum room volume in cubic meters
     */
    private static final float MIN_ROOM_VOLUME_M3 = 10 * 3;

    /**
     * Maximum room volume in cubic meters
     */
    private static final float MAX_ROOM_VOLUME_M3 = 100 * 3;

    /**
     * Minimum number of windows in room
     */
    private static final int MIN_WINDOWS = 1;

    /**
     * Maximum number of windows in room
     */
    private static final int MAX_WINDOWS = 4;

    /**
     * Probability of opened window in percents
     */
    private static final double PROBABILITY_WINDOW_OPENED = 15;

    /**
     * Minimum window's height in meters
     */
    private static final double MIN_WINDOW_HEIGHT = 0.5;

    /**
     * Maximum windows's height in meters
     */
    private static final double MAX_WINDOW_HEIGHT = 2.1;

    /**
     * Minimum window's width in meters
     */
    private static final double MIN_WINDOW_WIDTH = 0.6;

    /**
     * Maximum windows's width in meters
     */
    private static final double MAX_WINDOW_WIDTH = 2.3;

    /**
     * Minimum number of heaters in the room
     */
    private static final int MIN_HEATERS = 1;

    /**
     * Maximum number of heaters in the room
     */
    private static final int MAX_HEATERS = 3;

    /**
     * Minimum heater's energy consumption, Kwt per hour
     */
    private static final double MIN_HEATER_ELECTRICITY_PER_HOUR = 0.5;

    /**
     * Maximum heater's energy consumption, Kwt per hour
     */
    private static final double MAX_HEATER_ELECTRICITY_PER_HOUR = 2.5;

    /**
     * Minimum heater's efficiency in percents
     */
    private static final double MIN_HEATER_EFF = 75;

    /**
     * Maximum heater's efficiency in percents
     */
    private static final double MAX_HEATER_EFF = 98;

    /**
     * Probability of heater working
     */
    private static final double PROBABILITY_HEATER_WORKS = 20;

    /**
     * Minimum number of coolers
     */
    private static final int MIN_COOLERS = 1;

    /**
     * Maximum number of coolers
     */
    private static final int MAX_COOLERS = 3;

    /**
     * Minimum cooler's electricity consumption in killowatt per hour
     */
    private static final double MIN_COOLER_ELECTRICITY_PER_HOUR = 0.5;

    /**
     * Maximum cooler's electricity consumption in killowatt per hour
     */
    private static final double MAX_COOLER_ELECTRICITY_PER_HOUR = 2.5;

    /**
     * Minimum cooler's efficiency in percents
     */
    private static final double MIN_COOLER_EFF = 60;

    /**
     * Maximum cooler's efficiency in percents
     */
    private static final double MAX_COOLER_EFF = 90;

    /**
     * Probability of cooler turned on
     */
    private static final double PROBABILITY_COOLER_WORKS = 20;

    /**
     * Minimum number of lights in room
     */
    private static final int MIN_LIGHTS = 1;

    /**
     * Maximum number of lights in room
     */
    private static final int MAX_LIGHTS = 10;

    /**
     * Minimum consumption of light in killowatt per hour
     */
    private static final double MIN_LIGHT_ELECTRICITY_PER_HOUR = 0.05;

    /**
     * Maximum consumption of light in killowatt per hour
     */
    private static final double MAX_LIGHT_ELECTRICITY_PER_HOUR = 0.2;

    /**
     * Minimum light lumen per killowatt
     */
    private static final double MIN_LIGHT_LUMEN_PER_KWT = 10;

    /**
     * Maximum light lumen per killowatt
     */
    private static final double MAX_LIGHT_LUMEN_PER_KWT = 200;

    /**
     * Minimum light efficiency
     */
    private static final double MIN_LIGHT_EFFICIENCY = 35;

    /**
     * Maximum light efficiency
     */
    private static final double MAX_LIGHT_EFFICIENCY = 95;

    /**
     * Probability of operating light in percents
     */
    private static final double PROBABILITY_LIGHT_OPERATES = 40;

    /**
     * Minimum number of persons in the room
     */
    private static final int MIN_ROOM_PERSONS = 0;

    /**
     * Maximum number of persons in the room
     */
    private static final int MAX_ROOM_PERSONS = 10;

    /**
     * Minimum number of persons in the room
     */
    private static final int MIN_ROOM_ANIMALS = 0;

    /**
     * Maximum number of persons in the room
     */
    private static final int MAX_ROOM_ANIMALS = 10;

    /**
     * Minimum air conditioner flow per room in cubic meters per hour
     */
    private static final double MIN_AIR_CONDITIONER_FLOW = 30;

    /**
     * Minimum air conditioner flow per room in cubic meters per hour
     */
    private static final double MAX_AIR_CONDITIONER_FLOW = 200;

    /**
     * Minimum air conditioner electricity consumption
     */
    private static final double MIN_AIR_CONDITIONER_ELECTRICITY = 0.2;

    /**
     * Maximum air conditioner electricity consumption
     */
    private static final double MaX_AIR_CONDITIONER_ELECTRICITY = 1;

    /**
     * Probability of air conditioner working
     */
    private static final double PROBABILITY_AIR_CONDITIONER_WORKS = 90;

    /**
     * Minimum room internal temperature in Celsius
     */
    private static final double MIN_ROOM_INTERNAL_TEMP = 15;

    /**
     * Maximum room internal temperature in Celsius
     */
    private static final double MAX_ROOM_INTERNAL_TEMP = 35;

    /**
     * Minimum room outside temperature in Celsius
     */
    private static final double MIN_ROOM_OUTSIDE_TEMP = -65;

    /**
     * Maximum room outside temperature in Celsius
     */
    private static final double MAX_ROOM_OUTSIDE_TEMP = 65;

    /**
     * Generates energy consumption in start moment, as there were no consumption before start
     * energy consumption assumed to be zero
     */
    private static final double ENERGY_CONSUMPTION_START_MOMENT = 0;

    /**
     * Minimum amount of oxygen in new room after generation
     */
    private static final double MIN_ROOM_OXYGEN = 20.5;

    /**
     * Maximum amount of oxygen in new room after generation
     */
    private static final double MAX_ROOM_OXYGEN = 21.9;

    /**
     * Minimum start amount of CO2 in room in volume percent
     */
    private static final double MIN_ROOM_CO2 = 100 * 0.0001;

    /**
     * Maximum start amount of CO2 in room in volume percent
     */
    private static final double MAX_ROOM_CO2 = 600 * 0.0001;

    /**
     * Probability of smoke presence in the room in percents
     */
    private static final double PROBABILITY_SMOKE = 1;

    /**
     * Default room alarm status
     */
    private static final boolean ROOM_ALARM_STATUS = false;

    /**
     * Probability to change opened/closed status of window in standard time period
     */
    private static final double PROBABILITY_CHANGE_OPENED_CLOSED_STATUS = 1;

    /**
     * Standard time period in seconds for update of the room
     */
    private static final double STANDARD_TIME_PERIOD_SEC = 5;

    /**
     * Probability to change heater's operating status in standard time period
     */
    private static final double PROBABILITY_HEATER_CHANGE_WORK_STATUS = 3;

    /**
     * Probability to change lights's operating status in standard time period
     */
    private static final double PROBABILITY_LIGHT_CHANGE_WORK_STATUS = 3;

    /**
     * Probability to change cooler's operating status in standard time period
     */
    private static final double PROBABILITY_COOLER_CHANGE_WORK_STATUS = 3;

    /**
     * Probability of changing number of persons in room after standard time period
     */
    private static final double PROBABILITY_PERSONS_NUMBER_CHANGE = 3;

    /**
     * Probability of changing number of animals in room after standard time period
     */
    private static final double PROBABILITY_ANIMALS_NUMBER_CHANGE = 4;

    /**
     * Probability of air conditioner work change
     */
    private static final double PROBABILITY_AIR_CONDITIONER_WORK_CHANGE = 2;

    /**
     * Air heat absorbing capacity, kilojoules/(M3-K)
     */
    private static final double AIR_HEAT_ABSORBING_CAPACITY = 1.3;

    /**
     * Amount of seconds in hour
     */
    private static final double SECONDS_PER_HOUR = 3600;

    /**
     * Coefficient for converting from kilowatts tp kilo joules
     */
    private static final double KOEFF_KWT_SEC_TO_KJOULE = 1;

    /**
     * Average opened window ventilation speed, meters per second
     */
    private static final double WINDOW_AIR_SPEED = 0.5;

    /**
     * Absolute temperature gauge maximum
     */
    private static final double ABSOLUTE_TEMP_GAUGE_MAX = 400;

    /**
     * Absolute temperature gauge minimum
     */
    private static final double ABSOLUTE_TEMP_GAUGE_MIN = -70;

    /**
     * Quantity of heat generated by person per hour
     */
    private static final double HEAT_BY_PERSON_PER_HOUR = 0.07;

    /**
     * Quantity of heat generated by animal per hour
     */
    private static final double HEAT_BY_ANIMAL_PER_HOUR = 0.02;

    /**
     * Minimum room outside temperature deviation after standard time per sec
     */
    private static final double MIN_ROOM_OUTSIDE_TEMP_DEVIATION = -0.1;

    /**
     * Maximum room outside temperature deviation after standard time per sec
     */
    private static final double MAX_ROOM_OUTSIDE_TEMP_DEVIATION = 0.1;

    /**
     * Person's oxygen consumption in cubic meters per hour
     */
    private static final double PERSON_OXYGEN_CONSUMPTION = 0.5 / 24.0;

    /**
     * Animal's oxygen consumption in cubic meters per hour
     */
    private static final double ANIMAL_OXYGEN_CONSUMPTION = 0.25 / 24.0;

    /**
     * Person's CO2 production in cubic meters per hour
     */
    private static final double PERSON_CO2_PRODUCTION = 0.025 / 1000.0;

    /**
     * Animal's CO2 production in cubic meters per hour
     */
    private static final double ANIMAL_CO2_PRODUCTION = 0.013 / 1000.0;

    /**
     * Probability of smoke after certain amount of time in percents
     */
    private static final double PROBABILITY_OF_SMOKE = 0.01;

    /**
     * Probability of alarm after certain amount of time in percents
     */
    private static final double PROBABILITY_OF_ALARM = 0.01;

    /**
     * Current room object for the simulation of the room
     */
    private Room room;

    /**
     * Current room windows objects for the simulation of air inflow
     */
    private ArrayList<Window> windows = new ArrayList<>();

    /**
     * Current room heaters objects for the simulation of room heating
     */
    private ArrayList<Heater> heaters = new ArrayList<>();

    /**
     * Current room coolers for the simulation of room cooling
     */
    private ArrayList<Cooler> coolers = new ArrayList<>();

    /**
     * Current room lights for the simulation of the room lightning
     */
    private ArrayList<Light> lights = new ArrayList<>();

    /**
     * Current air conditioner in the room
     */
    private AirConditioner airConditioner = new AirConditioner();

    /**
     * All rooms list
     */
    private static ArrayList<Room> rooms = new ArrayList<>();

    /**
     * Creating the random room simulation, first start
     * @return
     */
    public Room startRoomSimulation() {
        this.room = new Room(getNewRoomId(), getNewRoomName(), getNewVolumeRoomM3(),
                getNewRoomWindows(), getNewRoomHeaters(), getNewRoomCoolers(), getNewRoomLights(),
                getNewRoomPersons(), getNewRoomAnimals(), getNewRoomAirConditioner(),
                getNewRoomInternalTemperatureC(), getNewRoomOutsideTemperatureC(), getNewLightLumenPerHour(),
                getNewRoomElectricityKwtPerHour(), getNewRoomOxygenPercentOfVolume(),
                getNewRoomCO2PercentOfVolume(), getNewRoomIsSmoke(), getNewRoomIsAlarm());
        return room;
    }

    /**
     * Start status of alarm system in the room
     * @return alarm system activation status
     */
    private boolean getNewRoomIsAlarm() {
        return ROOM_ALARM_STATUS;
    }

    /**
     * Probability of smoke in the room
     * @return status of smoke presence in the room
     */
    private boolean getNewRoomIsSmoke() {
        return getRandomBooleanWithProbability(PROBABILITY_SMOKE);
    }

    /**
     * Generates CO2 in the room in the start moment of new room
     * @return CO2 in the room in PPM
     */
    private double getNewRoomCO2PercentOfVolume() {
        return getRandomDoubleInRange(MIN_ROOM_CO2, MAX_ROOM_CO2);
    }

    /**
     * Generates oxygen in the room in the start moment of new room
     * @return oxygen in the room in percents
     */
    private double getNewRoomOxygenPercentOfVolume() {
        return getRandomDoubleInRange(MIN_ROOM_OXYGEN, MAX_ROOM_OXYGEN);
    }

    /**
     * Generates energy consumption in start moment
     * @return kilowatt per hour
     */
    private double getNewRoomElectricityKwtPerHour() {
        return ENERGY_CONSUMPTION_START_MOMENT;
    }

    /**
     * Generates outside temperature in Celsius
     * @return room's outside temperature
     */
    private double getNewRoomOutsideTemperatureC() {
        return getRandomDoubleInRange(MIN_ROOM_OUTSIDE_TEMP, MAX_ROOM_OUTSIDE_TEMP);
    }

    /**
     * Generates new room internal temperature
     * @return room's internal temperature in Celsius
     */
    private double getNewRoomInternalTemperatureC() {
        return getRandomDoubleInRange(MIN_ROOM_INTERNAL_TEMP, MAX_ROOM_INTERNAL_TEMP);
    }

    /**
     * Generates new air conditioner in the room
     * @return air conditioner
     */
    private AirConditioner getNewRoomAirConditioner() {
        return new AirConditioner(getNewAirConditionerAirFlowM3PerHour(),
                getNewAirConditionerElectricityKwtPerHour(), getNewAirConditionerOperatingStatus());
    }

    /**
     * Provides new air conditioner operation status
     * @return status if air conditioner turned on
     */
    private boolean getNewAirConditionerOperatingStatus() {
        return getRandomBooleanWithProbability(PROBABILITY_AIR_CONDITIONER_WORKS);
    }

    /**
     * Generates new air conditioner consumption in kilowatt per hour
     * @return energy consumption
     */
    private double getNewAirConditionerElectricityKwtPerHour() {
        return getRandomDoubleInRange(MIN_AIR_CONDITIONER_ELECTRICITY,
                MaX_AIR_CONDITIONER_ELECTRICITY);
    }

    /**
     * Generates flow of new air conditioner in the room
     * @return air flow in cubic meters per hour
     */
    private double getNewAirConditionerAirFlowM3PerHour() {
        return getRandomDoubleInRange(MIN_AIR_CONDITIONER_FLOW, MAX_AIR_CONDITIONER_FLOW);
    }

    /**
     * Generates current number of animals in the room
     * @return animals' count
     */
    private int getNewRoomAnimals() {
        return getRandomIntInRange(MIN_ROOM_ANIMALS, MAX_ROOM_ANIMALS);
    }

    /**
     * Generates number of persons in the room
     * @return persons' number
     */
    private int getNewRoomPersons() {
        return getRandomIntInRange(MIN_ROOM_PERSONS, MAX_ROOM_PERSONS);
    }

    /**
     * Generates new room lights
     * @return lights list
     */
    private ArrayList<Light> getNewRoomLights() {
        int numberOfLights = getRandomIntInRange(MIN_LIGHTS, MAX_LIGHTS);
        for (int i = 0; i < numberOfLights; i++) {
            Light light = getNewLight();
            lights.add(light);
        }
        return lights;
    }

    /**
     * Generates new light
     * @return light
     */
    private Light getNewLight() {
        return new Light(getNewLightId(), getNewLightElectricityPerHour(),
                getNewLumenPerKwt(), getLightEff(),
                getNewLightOperatingStatus());
    }

    /**
     * Generates probability of operating light
     * @return status if light is on
     */
    private boolean getNewLightOperatingStatus() {
        return getRandomBooleanWithProbability(PROBABILITY_LIGHT_OPERATES);
    }

    /**
     * Generates light efficiency
     * @return efficiency of light in percents
     */
    private double getLightEff() {
        return getRandomDoubleInRange(MIN_LIGHT_EFFICIENCY, MAX_LIGHT_EFFICIENCY);
    }

    /**
     * Generates lumen per kwt values for new light
     * @return lumen per killowatt
     */
    private double getNewLumenPerKwt() {
        return getRandomDoubleInRange(MIN_LIGHT_LUMEN_PER_KWT, MAX_LIGHT_LUMEN_PER_KWT);
    }

    /**
     * Generates new light's lumen per killowatt
     * @return lumen per killowatt
     */
    private double getNewLightLumenPerHour() {
        return getRandomDoubleInRange(MIN_LIGHT_LUMEN_PER_KWT, MAX_LIGHT_LUMEN_PER_KWT);
    }

    /**
     * Generates the light's electricity consumption per hour
     * @return light's electricity consumption
     */
    private double getNewLightElectricityPerHour() {
        return getRandomDoubleInRange(MIN_LIGHT_ELECTRICITY_PER_HOUR, MAX_LIGHT_ELECTRICITY_PER_HOUR);
    }

    /**
     * Generates new light id
     * @return id of light
     */
    private int getNewLightId() {
        return lights.size();
    }

    /**
     * Generates current room's cooler list
     * @return list of coolers
     */
    private ArrayList<Cooler> getNewRoomCoolers() {
        int numberOfCoolers = getRandomIntInRange(MIN_COOLERS, MAX_COOLERS);
        for (int i = 0; i < numberOfCoolers; i++) {
            Cooler cooler = getNewCooler();
            coolers.add(cooler);
        }
        return coolers;
    }

    /**
     * Generates new cooler
     * @return cooler
     */
    private Cooler getNewCooler() {
        return new Cooler(getNewCoolerId(), getNewCoolerElectricityPerHour(),
                getNewCoolerEff(), getNewCoolerOperationStatus());
    }

    /**
     * Generates the probability of working cooler
     * @return probability of cooler turned on
     */
    private boolean getNewCoolerOperationStatus() {
        return getRandomBooleanWithProbability(PROBABILITY_COOLER_WORKS);
    }

    /**
     * Generates new cooler's efficiency in percents
     * @return efficiency of cooler
     */
    private double getNewCoolerEff() {
        return getRandomDoubleInRange(MIN_COOLER_EFF, MAX_COOLER_EFF);
    }

    /**
     * Generates new cooler's energy consumption in killowatt per hour
     * @return
     */
    private double getNewCoolerElectricityPerHour() {
        return getRandomDoubleInRange(MIN_COOLER_ELECTRICITY_PER_HOUR, MAX_COOLER_ELECTRICITY_PER_HOUR);
    }

    /**
     * Generates cooler's id
     * @return id of cooler
     */
    private int getNewCoolerId() {
        return coolers.size();
    }

    /**
     * Getting heater's list
     * @return list of heaters
     */
    private ArrayList<Heater> getNewRoomHeaters() {
        int numberOfHeaters = getRandomIntInRange(MIN_HEATERS, MAX_HEATERS);
        for (int i = 0; i < numberOfHeaters; i++) {
            Heater heater = getNewHeater();
            heaters.add(heater);
        }
        return heaters;
    }

    /**
     * Generates new heater
     * @return heater
     */
    private Heater getNewHeater() {
        return new Heater(getNewHeaterId(), getNewHeaterElectricityPerHour(),
                getNewHeaterEff(), getNewHeaterOperationStatus());
    }

    /**
     * Determines if the new heater works
     * @return status if heater turned on
     */
    private boolean getNewHeaterOperationStatus() {
        return getRandomBooleanWithProbability(PROBABILITY_HEATER_WORKS);
    }

    /**
     * Generates new heater's efficiency
     * @return heater's eff in percents
     */
    private double getNewHeaterEff() {
        return getRandomDoubleInRange(MIN_HEATER_EFF, MAX_HEATER_EFF);
    }


    /**
     * Determines new heater energy consumption in Kwt per hour
     * @return heater's energy consumption
     */
    private double getNewHeaterElectricityPerHour() {
        return getRandomDoubleInRange(MIN_HEATER_ELECTRICITY_PER_HOUR, MAX_HEATER_ELECTRICITY_PER_HOUR);
    }

    /**
     * Generates new heater id
     * @return heater's id
     */
    private int getNewHeaterId() {
        return heaters.size();
    }

    /**
     * Generates new windows in new room
     * @return window's list
     */
    private ArrayList<Window> getNewRoomWindows() {
        int numberOfWindows = getRandomIntInRange(MIN_WINDOWS, MAX_WINDOWS);
        for (int i = 0; i < numberOfWindows; i++) {
            Window window = getNewWindow();
            windows.add(window);
        }
        return windows;
    }

    /**
     * Generates random window
     * @return window
     */
    private Window getNewWindow() {
        return new Window(getNewWindowId(), getNewWindowOpenedStatus(),
                getNewWindowHeightM(), getNewWindowWidthM());
    }

    /**
     * Generates new window width in meters
     * @return window's width in meters
     */
    private double getNewWindowWidthM() {
        return getRandomDoubleInRange(MIN_WINDOW_WIDTH, MAX_WINDOW_WIDTH);
    }

    /**
     * Generates new window height in meters
     * @return window's height in meters
     */
    private double getNewWindowHeightM() {
        return getRandomDoubleInRange(MIN_WINDOW_HEIGHT, MAX_WINDOW_HEIGHT);
    }

    /**
     * Determination of current window opened status
     * @return boolean if window is opened
     */
    private boolean getNewWindowOpenedStatus() {
        return getRandomBooleanWithProbability(PROBABILITY_WINDOW_OPENED);
    }

    /**
     * Generates new window id
     * @return window's id
     */
    private int getNewWindowId() {
        return windows.size();
    }

    /**
     * Generates random new room volume in cubic meters
     * @return volume of room in M3, 2 decimal points accuracy
     */
    private double getNewVolumeRoomM3() {
        return getRandomDoubleInRange(MIN_ROOM_VOLUME_M3, MAX_ROOM_VOLUME_M3);
    }

    /**
     * Getting new room name after creation
     * @return newly created room name
     */
    private String getNewRoomName() {
        return "Room" + rooms.size();
    }

    /**
     * Getting new room number id after creation
     * @return newly created room number
     */
    private int getNewRoomId() {
        return rooms.size();
    }

    /**
     * Updating current room parameters after N seconds
     * @return updated room
     */
    public Room updateRoomSimulation() {
        room.setElectricityKwtPerHour(calculateElectricityKwtPerHour());
        room.setInternalTemperatureC(calculateUpdatedRoomTemperature(room.getInternalTemperatureC()));
        room.setOutsideTemperatureC(calculateUpdatedOutsideTemperature(room.getOutsideTemperatureC()));
        room.setOxygenPercentOfVolume(getUpdatedOxygenPercentOfVolume(room.getOxygenPercentOfVolume()));
        room.setCO2PercentOfVolume(getUpdatedCO2PercentOfVolume(room.getCO2PercentOfVolume()));
        room.setWindows(updateWindows(windows));
        room.setHeaters(updateHeaters(heaters));
        room.setCoolers(updateCoolers(coolers));
        room.setLights(updateLights(lights));
        room.setPersonsCount(getUpdatedPersons(room.getPersonsCount()));
        room.setAnimalsCount(getUpdatedAnimals(room.getAnimalsCount()));
        room.setAirConditioner(getUpdatedAirConditioner(room.getAirConditioner()));
        room.setLightLumen(calculateUpdatedLightLumen());
        room.setSmoke(getUpdatedSmoke(room.isSmoke()));
        room.setAlarm(getUpdatedAlarm(room.isAlarm()));
        return room;
    }

    /**
     * Updates alarm status in certain amount of time
     * @param alarm initial smoke status
     * @return updated alarm status
     */
    private boolean getUpdatedAlarm(boolean alarm) {
        return alarm ? alarm : getRandomBooleanWithProbability(PROBABILITY_OF_ALARM);
    }

    /**
     * Updates smoke status in certain amount of time
     * @param smoke initial smoke status
     * @return updated smoke status
     */
    private boolean getUpdatedSmoke(boolean smoke) {
        return smoke ? smoke : getRandomBooleanWithProbability(PROBABILITY_OF_SMOKE);
    }

    /**
     * Calculates updated carbon dioxide percent after certain amount of time
     * @param co2PercentOfVolume initial CO2 percent of volume
     * @return updated C02 percent of volume
     */
    private double getUpdatedCO2PercentOfVolume(double co2PercentOfVolume) {
        double Vco2start = room.getVolumeRoomM3() * co2PercentOfVolume;
        double Vco2produced = room.getPersonsCount()  * PERSON_CO2_PRODUCTION
                + room.getAnimalsCount() * ANIMAL_CO2_PRODUCTION;
        double Vco2removed = (getVolumeOfAirChangedByAirConditioner()
                + getVolumeOfAirChangedFromWindowsOpened()) * co2PercentOfVolume;
        double Vco2change = Vco2removed > Vco2produced ? 0 :
                Vco2produced - Vco2removed;
        double Vco2final = Vco2start + Vco2change;
        double updatedco2PercentOfVolume = Vco2final / room.getVolumeRoomM3();
        return updatedco2PercentOfVolume;
    }

    /**
     * Calculate updated oxygen percent of volume in certain amount of time
     * @param oxygenPercentOfVolume initial percent of oxygen
     * @return updated percent of oxygen
     */
    private double getUpdatedOxygenPercentOfVolume(double oxygenPercentOfVolume) {
        double Voxygenstart = room.getVolumeRoomM3() * oxygenPercentOfVolume;
        double Voxygenused = room.getPersonsCount()  * PERSON_OXYGEN_CONSUMPTION
                + room.getAnimalsCount() * ANIMAL_OXYGEN_CONSUMPTION;
        double Voxygenrecovered = (getVolumeOfAirChangedByAirConditioner()
                + getVolumeOfAirChangedFromWindowsOpened()) * oxygenPercentOfVolume;
        double Voxygenchange = Voxygenrecovered > Voxygenused ? 0 :
                    Voxygenused - Voxygenrecovered;
        double Voxygenfinal = Voxygenstart - Voxygenchange;
        double updatedOxygenPercentOfVolume = Voxygenfinal / room.getVolumeRoomM3();
        return updatedOxygenPercentOfVolume;
    }

    /**
     * Calculates updated outside temperature
     * @param outsideTemperatureC outside temperature in Celsius
     * @return updated outside temperature in Celsius
     */
    private double calculateUpdatedOutsideTemperature(double outsideTemperatureC) {
        return Math.round((outsideTemperatureC + getRandomDoubleInRange(MIN_ROOM_OUTSIDE_TEMP_DEVIATION,
                MAX_ROOM_OUTSIDE_TEMP_DEVIATION)) * 100.0) / 100.0;
    }

    /**
     * Calculates electricity per hour by all currents electrical devices in the room
     * @return kWt hour
     */
    private double calculateElectricityKwtPerHour() {
        double kWtHour = 0;
        for (int i = 0; i < heaters.size(); i++) {
            kWtHour += heaters.get(i).getElectricityPerHour();
        }
        for (int i = 0; i < coolers.size(); i++) {
            kWtHour += coolers.get(i).getElectricityPerHour();
        }
        for (int i = 0; i < lights.size(); i++) {
            kWtHour += lights.get(i).getElectricityPerHour();
        }
        kWtHour += airConditioner.getElectricityKwtPerHour();
        return Math.round(kWtHour * 100.0) / 100.0;
    }

    /**
     * Calculates lumen for all lights at room at the moment
     * @return all lights' lumen
     */
    private double calculateUpdatedLightLumen() {
        double Lumen = 0;
        for (int i = 0; i < lights.size(); i++) {
            Lumen += lights.get(i).getlumenPerKwt() *
                    lights.get(i).getElectricityPerHour() *
                    lights.get(i).getlightEff();
        }
        return Math.round(Lumen * 100.0) / 100.0;
    }

    /**
     * Calculates updated internal room temperature after certain period of time
     * Q = Cv * V * (T1 - T0); T2 = T1 + Q / (Cv * V)
     * where Q - quantity of heat, kilojoules of joules
     * where Cv - heat absorbing capacity, kilojoules/(M3-K)
     * @param internalTemperatureC current internal temperature
     * @return updated room temperature
     */
    private double calculateUpdatedRoomTemperature(double internalTemperatureC) {
        double Q = calculateQuantityOfHeat();
        double V = room.getVolumeRoomM3();
        double T1 = internalTemperatureC;
        double Cv = AIR_HEAT_ABSORBING_CAPACITY;
        double T2 = Math.round((T1 + Q / (Cv * V)) * 100.0) / 100.0;
        if (T2 > ABSOLUTE_TEMP_GAUGE_MAX) {
            T2 = ABSOLUTE_TEMP_GAUGE_MAX;
        } else if (T2 < ABSOLUTE_TEMP_GAUGE_MIN) {
            T2 = ABSOLUTE_TEMP_GAUGE_MIN;
        }
        return T2;
    }

    /**
     * Calculates quantity of heat in the room in certain period of time
     * @return quantity of heat
     */
    private double calculateQuantityOfHeat() {
        double Qheaters = calculateQuantityOfHeatForHeaters();
        double Qcoolers = calculateQuantityOfHeatForCoolers();
        double Qairconditioner = calculateQuantityOfHeatForAirConditioner();
        double Qopenedwindows = calculateQuantityOfHeatForOpenedWindows();
        double Qpersons = calculateQuantityOfHeatByPersons();
        double Qanimals = calculateQuantityOfHeatByAnimals();
        return Qheaters + Qcoolers + Qairconditioner + Qopenedwindows + Qpersons + Qanimals;
    }

    /**
     * Calculate quantity of heat by persons
     * @return quantity of heat generated by peoples
     */
    private double calculateQuantityOfHeatByPersons() {
        return room.getPersonsCount() * HEAT_BY_PERSON_PER_HOUR
                * STANDARD_TIME_PERIOD_SEC / SECONDS_PER_HOUR;
    }

    /**
     * Calculate quantity of heat by persons
     * @return quantity of heat generated by peoples
     */
    private double calculateQuantityOfHeatByAnimals() {
        return room.getAnimalsCount() * HEAT_BY_ANIMAL_PER_HOUR
                * STANDARD_TIME_PERIOD_SEC / SECONDS_PER_HOUR;
    }

    /**
     * Calculates quantity of heat by opened windows air change after certain period of time
     * Q = Cv * V * (T0 - T1);
     * where Q - quantity of heat, kilojoules of joules
     * where Cv - heat absorbing capacity, kilojoules/(M3-K)
     * @return
     */
    private double calculateQuantityOfHeatForOpenedWindows() {
        double V = getVolumeOfAirChangedFromWindowsOpened();
        double T1 = room.getInternalTemperatureC();
        double T0 = room.getOutsideTemperatureC();
        double Cv = AIR_HEAT_ABSORBING_CAPACITY;
        double Q = Cv * V * (T0 - T1);
        return Q;
    }

    /**
     * Calculates volume of air changed in the room from windows opened
     * @return volume of changed air
     */
    private double getVolumeOfAirChangedFromWindowsOpened() {
        double S = 0;
        for (int i = 0; i < room.getWindows().size(); i++) {
            if (room.getWindows().get(i).isOpened()) {
                S += room.getWindows().get(i).getHeightM()
                        * room.getWindows().get(i).getWidthM();
            }
        }
        return S * WINDOW_AIR_SPEED * STANDARD_TIME_PERIOD_SEC
                / SECONDS_PER_HOUR;
    }

    /**
     * Calculates quantity of heat by air conditioner air change after certain period of time
     * Q = Cv * V * (T0 - T1);
     * where Q - quantity of heat, kilojoules of joules
     * where Cv - heat absorbing capacity, kilojoules/(M3-K)
     * @return quantity of heat by air conditioner air change
     */
    private double calculateQuantityOfHeatForAirConditioner() {
        double V = getVolumeOfAirChangedByAirConditioner();
        double T1 = room.getInternalTemperatureC();
        double T0 = room.getOutsideTemperatureC();
        double Cv = AIR_HEAT_ABSORBING_CAPACITY;
        double Q = Cv * V * (T0 - T1);
        return Q;
    }

    /**
     * Calculates volume of air changed in the room by air conditioner in standard timestamp
     * @return volume of air changed by air conditioner
     */
    private double getVolumeOfAirChangedByAirConditioner() {
        return room.getAirConditioner().getAirFlowM3PerHour()
                    / SECONDS_PER_HOUR * STANDARD_TIME_PERIOD_SEC;
    }

    /**
     * Calculates quantity of negative heat (cooling) in the room in certain period of time
     * @return quantity of negative heat (cooling)
     */
    private double calculateQuantityOfHeatForCoolers() {
        double Qcoolers = 0;
        for (int i = 0; i < coolers.size(); i++) {
            Qcoolers -= coolers.get(i).getElectricityPerHour()
                    * coolers.get(i).getCoolingEff()
                    * STANDARD_TIME_PERIOD_SEC / SECONDS_PER_HOUR
                    * KOEFF_KWT_SEC_TO_KJOULE;
        }
        return Qcoolers;
    }

    /**
     * Calculates quantity of heat in the room generated by heaters in certain period of time
     * @return quantity of heat by heaters
     */
    private double calculateQuantityOfHeatForHeaters() {
        double Qheaters = 0;
        for (int i = 0; i < heaters.size(); i++) {
            Qheaters += heaters.get(i).getElectricityPerHour()
                    * heaters.get(i).getHeatingEff()
                    * STANDARD_TIME_PERIOD_SEC / SECONDS_PER_HOUR
                    * KOEFF_KWT_SEC_TO_KJOULE;
        }
        return Qheaters;
    }

    /**
     * Updates air conditioner work status after certain period of time
     * @param airConditioner current air conditioner
     * @return updated air conditioner
     */
    private AirConditioner getUpdatedAirConditioner(AirConditioner airConditioner) {
        if (getRandomBooleanWithProbability(PROBABILITY_AIR_CONDITIONER_WORK_CHANGE)) {
            airConditioner.setOperating(!airConditioner.isOperating());
        }
        return airConditioner;
    }

    /**
     * Updated number of animals after certain period of time
     * @param animals number of animals in the room
     * @return updated number of animals in the room
     */
    private int getUpdatedAnimals(int animals) {
        if (getRandomBooleanWithProbability(PROBABILITY_ANIMALS_NUMBER_CHANGE)) {
            animals = getNewRoomAnimals();
        }
        return animals;
    }

    /**
     * Updated number of persons after certain period of time
     * @param persons number of persons in the room
     * @return updated number of persons in the room
     */
    private int getUpdatedPersons(int persons) {
        if (getRandomBooleanWithProbability(PROBABILITY_PERSONS_NUMBER_CHANGE)) {
            persons = getNewRoomPersons();
        }
        return persons;
    }

    /**
     * Updates lights' status after period of time
     * @param lights list of lights
     * @return updated list of lights
     */
    private ArrayList<Light> updateLights(ArrayList<Light> lights) {
        for (int i = 0; i < lights.size(); i++) {
            lights.set(i, getUpdatedLight(lights.get(i)));
        }
        return lights;
    }

    /**
     * Updates light work status after certain period of time
     * @param light
     * @return updated light
     */
    private Light getUpdatedLight(Light light) {
        if (getRandomBooleanWithProbability(PROBABILITY_LIGHT_CHANGE_WORK_STATUS)) {
            light.setOperating(!light.isOperating());
        }
        return light;
    }

    /**
     * Updates coolers' status after period of time
     * @param coolers list of coolers
     * @return updated list of coolers
     */
    private ArrayList<Cooler> updateCoolers(ArrayList<Cooler> coolers) {
        for (int i = 0; i < coolers.size(); i++) {
            coolers.set(i, getUpdatedCoolers(coolers.get(i)));
        }
        return coolers;
    }

    /**
     * Updates cooler's status
     * @param cooler
     * @return updated cooler
     */
    private Cooler getUpdatedCoolers(Cooler cooler) {
        if (getRandomBooleanWithProbability(PROBABILITY_COOLER_CHANGE_WORK_STATUS)) {
            cooler.setOperating(!cooler.isOperating());
        }
        return cooler;
    }

    /**
     * Updates heaters' status after period of time
     * @param heaters list of heaters
     * @return updated list of heaters
     */
    private ArrayList<Heater> updateHeaters(ArrayList<Heater> heaters) {
        for (int i = 0; i < heaters.size(); i++) {
            heaters.set(i, getUpdatedHeater(heaters.get(i)));
        }
        return heaters;
    }

    /**
     * Updates heaters's status
     * @param heater current heater
     * @return updated heater
     */
    private Heater getUpdatedHeater(Heater heater) {
        if (getRandomBooleanWithProbability(PROBABILITY_HEATER_CHANGE_WORK_STATUS)) {
            heater.setOperating(!heater.isOperating());
        }
        return heater;
    }

    /**
     * Updates windows' status after period of time
     * @param windows room window list
     * @return updated window list
     */
    private ArrayList<Window> updateWindows(ArrayList<Window> windows) {
        for (int i = 0; i < windows.size(); i++) {
            windows.set(i, getUpdatedWindow(windows.get(i)));
        }
        return windows;
    }

    /**
     * Updates window's status
     * @param window current window
     * @return updated window
     */
    private Window getUpdatedWindow(Window window) {
        if (getRandomBooleanWithProbability(PROBABILITY_CHANGE_OPENED_CLOSED_STATUS)) {
            window.setOpened(!window.isOpened());
        }
        return window;
    }

    /**
     * Creates random int in range
     * @param min from
     * @param max to
     * @return int
     */
    private int  getRandomIntInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Creates random double in range
     * @param min from
     * @param max to
     * @return with two digits accuracy
     */
    private double getRandomDoubleInRange(double min, double max) {
        Random random = new Random();
        return Math.round((min + (max - min) * random.nextDouble()) * 100.0) / 100.0;
    }

    /**
     * Creates random boolean with probability
     * @param probability of occurrence
     * @return if an event occurs
     */
    private boolean getRandomBooleanWithProbability(double probability) {
        Random random = new Random();
        return random.nextFloat() < (probability / 100.0);
    }

    @Override
    public String toString() {
        return "RoomSimulation{" +
                "room=" + room +
                ", windows=" + windows +
                ", heaters=" + heaters +
                ", coolers=" + coolers +
                ", lights=" + lights +
                ", airConditioner=" + airConditioner +
                '}';
    }
}
