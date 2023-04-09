public class Connection {
    private RailwayStation station1;
    private RailwayStation station2;
    private double distance;

    public Connection(RailwayStation station1, RailwayStation station2, double distance) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
    }

    public RailwayStation getStation1() {
        return station1;
    }

    public void setStation1(RailwayStation station1) {
        this.station1 = station1;
    }

    public RailwayStation getStation2() {
        return station2;
    }

    public void setStation2(RailwayStation station2) {
        this.station2 = station2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double calculateTravelTime(double speed) {
        // Assuming speed is in km/h
        return (getDistance() / speed) * 60; // Convert the time to minutes
    }

    public void saveConnection(){

    }


    @Override
    public String toString() {
        return "Connection{" +
                "station1=" + station1 +
                ", station2=" + station2 +
                ", distance=" + distance +
                '}';
    }
}
