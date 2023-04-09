import java.util.Random;
import java.util.UUID;

public class Locomotive {
    private String name;
    private RailwayStation homeStation;
    private RailwayStation sourceStation;
    private RailwayStation destinationStation;
    private UUID locomotiveID;
    private int maxRailroadCars;
    private double maxWeight;
    private int maxElectricalConnections;
    private double currentSpeed;

    public Locomotive(String name, RailwayStation homeStation, RailwayStation sourceStation, RailwayStation destinationStation, int maxRailroadCars, double maxWeight, int maxElectricalConnections, double initialSpeed) {
        this.locomotiveID = UUID.randomUUID();
        this.name = name;
        this.homeStation = homeStation;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.maxRailroadCars = maxRailroadCars;
        this.maxWeight = maxWeight;
        this.maxElectricalConnections = maxElectricalConnections;
        this.currentSpeed = initialSpeed;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RailwayStation getHomeStation() {
        return homeStation;
    }

    public void setHomeStation(RailwayStation homeStation) {
        this.homeStation = homeStation;
    }

    public RailwayStation getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(RailwayStation sourceStation) {
        this.sourceStation = sourceStation;
    }

    public RailwayStation getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(RailwayStation destinationStation) {
        this.destinationStation = destinationStation;
    }

    public UUID getLocomotiveID() {
        return locomotiveID;
    }

    public int getMaxRailroadCars() {
        return maxRailroadCars;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxElectricalConnections() {
        return maxElectricalConnections;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "name='" + name + '\'' +
                ", homeStation=" + homeStation +
                ", sourceStation=" + sourceStation +
                ", destinationStation=" + destinationStation +
                ", locomotiveID=" + locomotiveID +
                ", maxRailroadCars=" + maxRailroadCars +
                ", maxWeight=" + maxWeight +
                ", maxElectricalConnections=" + maxElectricalConnections +
                ", currentSpeed=" + currentSpeed +
                '}';
    }

    public void attachRailroadCar(PassengerRailroadCar passengerCar1) {
    }
    public void updateSpeed(double increment) {
        setCurrentSpeed(getCurrentSpeed() + increment);
    }
    public void move(Route route, double acceleration, double deceleration, double maxSpeed) {
        double distance = route.getDistanceBetweenStations();
        double currentSpeed = this.getCurrentSpeed();
        double distanceCovered = 0;

        while (distanceCovered < distance) {
            // Accelerate the train
            if (currentSpeed < maxSpeed) {
                currentSpeed += acceleration;
                if (currentSpeed > maxSpeed) {
                    currentSpeed = maxSpeed;
                }
            }

            distanceCovered += currentSpeed / 60; // Assuming currentSpeed is in km/h and time step is 1 minute

            // Decelerate the train if it's close to the destination
            double remainingDistance = distance - distanceCovered;
            double requiredDistanceToStop = (currentSpeed * currentSpeed) / (2 * deceleration);

            if (remainingDistance <= requiredDistanceToStop) {
                currentSpeed -= deceleration;
                if (currentSpeed < 0) {
                    currentSpeed = 0;
                }
            }

            System.out.printf("Current speed of trainset %s: %.1f km/h%n", this.getName(), currentSpeed);
            System.out.printf("Distance covered: %.1f km%n", distanceCovered);
        }

        System.out.println("The trainset has arrived at the destination.");
    }



}
