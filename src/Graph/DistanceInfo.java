package Graph;

public class DistanceInfo {
	
	int lastVertix;
	int distance;
	
	DistanceInfo(){
		lastVertix = -1;
		distance = -1;
	}

	public int getLastVertix() {
		return lastVertix;
	}

	public void setLastVertix(int lastVertix) {
		this.lastVertix = lastVertix;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	

}
