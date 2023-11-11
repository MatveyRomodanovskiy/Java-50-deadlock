package telran.truck.task;

import java.util.ArrayList;

import telran.truck.model.Elevator;

public class Truck implements Runnable {
	int nRaces;
	int capacity;
	ArrayList<Elevator> elevators;	

	public Truck(int nRaces, int capacity, ArrayList<Elevator> elevators) {
		this.nRaces = nRaces;
		this.capacity = capacity;
		this.elevators = elevators;
	}

	@Override
	public void run() {
		for(int i = 0; i < (nRaces/2); i++) {
			synchronized (elevators.get(1)) {
				if (elevators.get(1).getCurrentVolume() > 200000) {
					synchronized (elevators.get(0)){
					elevators.get(0).add(capacity);
					}
				} 
				else {
					synchronized (elevators.get(1)){
					elevators.get(1).add(capacity/2);
					}
					synchronized (elevators.get(0)){
					elevators.get(0).add(capacity/2);
					}
				}
			}
		}
		for(int i = nRaces/2; i < nRaces; i++) {
			synchronized (elevators.get(0)) {
				if (elevators.get(0).getCurrentVolume() > 200000) {
					synchronized (elevators.get(1)){
					elevators.get(1).add(capacity);
					}
				}
				else
				{
					synchronized (elevators.get(1)){
					elevators.get(1).add(capacity/2);
					}
					synchronized (elevators.get(0)){
					elevators.get(0).add(capacity/2);
					}
				}
				}
			}
		
	}

}
