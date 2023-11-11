package telran.truck.model;

public class Elevator {
	String name;
	int currentVolume;
	
	public Elevator(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the currentVolume
	 */
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	public  void add(int portion) {
		
			currentVolume += portion;
		
	}
}
