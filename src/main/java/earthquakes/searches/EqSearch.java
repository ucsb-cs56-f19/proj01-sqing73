package earthquakes.searches;

public class EqSearch{
    private int distance;
    private int minmag;
    private double lat;
    private double lon;
    private String location;

    
    
    public int getDistance(){
	return distance;
    }

    public int getMinmag(){
	return minmag;
    }

    public double getLat(){
	return lat;
    }

    public double getLon(){
	return lon;
    }

    public String getLocation(){
	return location;
    }

    
    public void setDistance(int distant){
	distance = distant;
    }
    
    public void setMinmag(int MM){
	minmag = MM;
    }

    public void setLat(double Latitude){
	lat = Latitude;
    }

    public void setLon(double Longtitude){
	lon = Longtitude;
    }

    public void setLocation(String Location){
	location = Location;
    }

}
