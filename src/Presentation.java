import java.util.ArrayList;
import java.util.List;

public class Presentation {
    public static void runPresentation() {


        // Create railway stations


        RailwayStation stationA = new RailwayStation("A");
        RailwayStation stationB = new RailwayStation("B");
        RailwayStation stationC = new RailwayStation("C");
        RailwayStation stationD = new RailwayStation("D");
        RailwayStation stationF = new RailwayStation("F");
        RailwayStation stationG = new RailwayStation("G");

        System.out.println("Created Railway Stations: " + stationA + ", " + stationB+ ", " + stationC+ ", " + stationD+ ", " + stationF+ ", " + stationG);


        // Create connections

        Connection connectionAB = new Connection(stationA, stationB, 100);
        System.out.println("Created Connection: " + connectionAB);

        Connection connectionBC = new Connection(stationB, stationC, 150);
        System.out.println("Created Connection: " + connectionBC);

        Connection connectionCD = new Connection(stationC, stationD, 50);
        System.out.println("Created Connection: " + connectionCD);

        Connection connectionDF = new Connection(stationD, stationF, 200);
        System.out.println("Created Connection: " + connectionDF);

        Connection connectionFG = new Connection(stationF, stationG, 100);
        System.out.println("Created Connection: " + connectionFG);



        List<Connection> railWayMap = new ArrayList<>();

        railWayMap.add(connectionAB);
        railWayMap.add(connectionBC);
        railWayMap.add(connectionCD);
        railWayMap.add(connectionDF);
        railWayMap.add(connectionFG);




        Route route = new Route(stationA, stationB,railWayMap);
        System.out.println("Created Route: " + route.getIntermediateStations());

        // Create a locomotive
        Locomotive locomotive1 = new Locomotive("Locomotive1", stationA, stationB, stationC, 10, 500, 1000, 5);
        System.out.println("Created Locomotive: " + locomotive1);

        // Create railroad cars
        PassengerRailroadCar passengerCar1 = new PassengerRailroadCar("P1", "SecurityInfo1", 10, 30, 50, true);
        System.out.println("Created PassengerRailroadCar: " + passengerCar1);

        // Attach railroad cars to the locomotive
        locomotive1.attachRailroadCar(passengerCar1);
        System.out.println("Attached PassengerRailroadCar to Locomotive");

        // Create a trainset
        List<RailroadCar> cars = new ArrayList<>();
        cars.add(passengerCar1);
        Trainset trainset1 = new Trainset(locomotive1);
        System.out.println("Created Trainset: " + trainset1);

        // Create a route


        // New loop to simulate train movement and speed changes
        int distanceCovered = 0;
        int totalDistance = 100; // This should be the total distance of the route, e.g., connectionAB.getDistance()

        while (distanceCovered < totalDistance) {
            locomotive1.setCurrentSpeed(locomotive1.getCurrentSpeed() + 10);
            distanceCovered += 10;
            System.out.println("Current speed of trainset Locomotive1: " + locomotive1.getCurrentSpeed() + " km/h");
            System.out.println("Distance covered: " + distanceCovered + " km");

            if (distanceCovered >= totalDistance) {
                System.out.println("The trainset has arrived at the destination.");
                break;
            }
        }

        while (locomotive1.getCurrentSpeed() > 0) {
            locomotive1.setCurrentSpeed(locomotive1.getCurrentSpeed() - 10);
            System.out.println("Current speed of trainset Locomotive1: " + locomotive1.getCurrentSpeed() + " km/h");
        }

    }

    }

