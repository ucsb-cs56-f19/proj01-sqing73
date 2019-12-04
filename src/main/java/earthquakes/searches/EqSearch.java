package earthquakes.searches;

public class EqSearch{

    private int distance;
    private int minmag;
    private long lat;
    private long lon;
    private String location;
    
    
    public EqSearch(){
	    this.distance = 0;
	    this.minmag = 0;
    }

    public int getDistance(){
	    return this.distance;
    }
    
    public int getMinmag(){
	    return this.minmag;
    }

    public long getLat(){
        return this.lat;
    }

    public long getLon(){
        return this.lon;
    }

    public String getLocation(){
        return this.location;
    }

   
    
    public void setDistance(int d){
	this.distance = d;
    }
    
    public void setMinmag(int m){
	this.minmag = m;
    }

    public void setLat(long la){
        this.lat = la;
    }

    public void setLon(long lo){
        this.lon = lo;
    }

    public void setLocation(String loc){
        this.location = loc;
    }
}