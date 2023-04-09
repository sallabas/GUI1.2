import java.util.ArrayList;
import java.util.List;

public class Route {
    private RailwayStation origin;
    private RailwayStation destination;
    private List<RailwayStation> intermediateStations;
    private Double distance;
    List<Connection> railWayMap;
    public Route(RailwayStation origin, RailwayStation destination, List<Connection> railWayMap ) {
        this.origin = origin;
        this.destination = destination;
        this.intermediateStations = intermediateStations;
        this.railWayMap= railWayMap;

    }

    public RailwayStation getOrigin() {
        return origin;
    }

    public RailwayStation getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Route{" +
                "origin=" + origin +
                ", destination=" + destination +
                ", intermediateStations=" + intermediateStations +
                '}';
    }

    public double getDistanceBetweenStations() {
        return distance;
    }
    public void setOrigin(RailwayStation origin) {
        this.origin = origin;
    }
    public void setDestination(RailwayStation destination) {
        this.destination = destination;
    }


    public String getIntermediateStations() {
        List<String> intermediateStations = new ArrayList<>();
        String currentStation = origin.getName();

        while (!currentStation.equals(destination.getName())) {
            intermediateStations.add(currentStation);

            for (Connection connection : railWayMap) {
                if (connection.getStation1().getName().equals(currentStation)) {
                    currentStation = connection.getStation2().getName();
                    break;
                }
            }
        }

        intermediateStations.add(destination.getName());

        return intermediateStations.toString();
    }


}
