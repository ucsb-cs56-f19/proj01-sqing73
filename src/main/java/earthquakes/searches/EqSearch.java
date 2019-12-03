package earthquakes.searches;

public class EqSearch{

    private int distance;
    private int minmag;
    
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

   
    
    public void setDistance(int d){
	this.distance = d;
    }
    
    public void setMinmag(int m){
	this.minmag = m;
    }
}