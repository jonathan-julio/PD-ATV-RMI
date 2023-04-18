import java.io.Serializable;

public class Hospital implements Serializable {
    private String name;
    private double latitude;
    private double longitude;
    
    public Hospital(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getName() {
        return name;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public double distanceTo(double latitude, double longitude) {
        double earthRadius = 6371000; // em metros
        double dLat = Math.toRadians(this.latitude - latitude);
        double dLng = Math.toRadians(this.longitude - longitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(this.latitude)) *
                   Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = earthRadius * c;
        return distance;
    }
}
