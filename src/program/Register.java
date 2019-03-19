package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Register {
	private static Map<Person, ArrayList<Vehicle>> data = new HashMap<>();
	private static ArrayList<String> regNumbers = new ArrayList<>();	
	
	//Add person with or without vehicles
	public static void add(Person person, Vehicle vehicle) {
		if(person != null) {
			//if person doesn't exist
			if(!data.containsKey(person)) { 
				ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
				if(vehicle != null && !regNumbers.contains(vehicle.getRegNumber())) {
					vehiclesList.add(vehicle);
					regNumbers.add(vehicle.getRegNumber());
				}
				data.put(person, vehiclesList);
			//if person already exist
			} else if(vehicle != null && !regNumbers.contains(vehicle.getRegNumber())) {
					regNumbers.add(vehicle.getRegNumber());
					data.get(person).add(vehicle);
			}
		}
	}
	
	//Remove vehicle
	public static void removeVehicle(Person person, Vehicle vehicle) {
		if(person != null) {
			//if person matched and vehicle owned by same person
			if(data.containsKey(person) && data.get(person).contains(vehicle)) {
				data.get(person).remove(vehicle);
				regNumbers.remove(vehicle.getRegNumber());
			}
		}
	}
	
	//Remove person (if no vehicles)
	public static void removePerson(Person person) {
		if(data.containsKey(person)) {
			if(data.get(person).isEmpty()) 
				data.remove(person);
		}
	}
	
	//Change vehicle owner
	public static void changeOwner(Person person, Vehicle vehicle, Person newPerson) {
		if(person != null && newPerson != null) {
			//if person matched and vehicle owned by same person
			if(data.containsKey(person) && data.get(person).contains(vehicle)) {
				removeVehicle(person, vehicle);
				add(newPerson, vehicle);
			}
		}
	}
	
	//Print DATA
	public static void printData() {
		System.out.println(getData());
	}
	//Print reg.numbers
	public static void printRegNumbers() {
		System.out.println(getRegNumbers());
	}
	
	//Return DATA
	public static Map<Person, ArrayList<Vehicle>> getData() {
		return data;
	}
	//Return regNumbers
	public static ArrayList<String> getRegNumbers() {
		return regNumbers;
	}
}
