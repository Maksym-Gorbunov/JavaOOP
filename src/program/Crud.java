package program;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Crud {
	private ArrayList<Person> persons;
	private ArrayList<Vehicle> vehicles;
	HashMap<String, String> register = new HashMap<>();        //register numbers -> personal numbers
	public String path = "C:\\Java\\Labb2MaksymGorbunov\\data\\";

	public void saveRegister() {
		File file = new File(path + "register.bin");
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(file)))) {
			out.writeObject(register);
		} catch (FileNotFoundException e) {
			System.out.println("--> failed1 on save register");
		} catch (IOException e) {
			System.out.println("--> failed2 on save register");
		}
	}

	public HashMap<String, String> loadRegister() {
		File file = new File(path + "register.bin");
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(file)))) {
			register = (HashMap<String, String>) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("--> persons list is empty");
			register = new HashMap<String, String>();
		} catch (IOException e) {
			System.out.println("--> failed2 on read persons");
		} catch (ClassNotFoundException e) {
			System.out.println("--> failed3 on read persons");
		}
		return register;
	}

	//Save vehicles data to 'vehicles.bin'
	public void saveVehicles() {
		File file = new File(path + "vehicles.bin");
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(file)))) {
			out.writeObject(vehicles);
		} catch (FileNotFoundException e) {
			System.out.println("--> vehicles list is empty");
		} catch (IOException e) {
			System.out.println("--> failed2 on save vehicles");
		}
	}

	//Save persons data to 'persons.bin'
	public void savePersons() {
		File file = new File(path + "persons.bin");
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(file)))) {
			out.writeObject(persons);
		} catch (FileNotFoundException e) {
			System.out.println("--> failed1 on save persons");
		} catch (IOException e) {
			System.out.println("--> failed2 on save persons");
		}
	}

	//Load vehicles data from 'vehicles.bin'
	public ArrayList<Vehicle> loadVehicles() {
		File file = new File(path + "vehicles.bin");
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(file)))) {
			vehicles = (ArrayList<Vehicle>) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("--> vehicles list is empty");
			vehicles = new ArrayList<>();
		} catch (IOException e) {
			System.out.println("--> failed2 on read vehicles");
		} catch (ClassNotFoundException e) {
			System.out.println("--> failed3 on read vehicles");
		}
		return vehicles;
	}

	//Load persons data from 'persons.bin'
	public ArrayList<Person> loadPersons() {
		File file = new File(path + "persons.bin");
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(file)))) {
			persons = (ArrayList<Person>) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("--> persons list is empty");
			persons = new ArrayList<>();
		} catch (IOException e) {
			System.out.println("--> failed2 on read persons");
		} catch (ClassNotFoundException e) {
			System.out.println("--> failed3 on read persons");
		}
		return persons;
	}

	public void deletePerson(Person person) {
		if (persons.contains(person)) {
			persons.remove(person);
			savePersons();
			System.out.println("Person '" + person.getPersonalNumber() + "' was deleted");
		}
	}

	public void deleteVehicle(Vehicle vehicle) {
		if (vehicles.contains(vehicle)) {
			vehicles.remove(vehicle);
			saveVehicles();
		}
	}

	public void deleteVehicleFromRegister(Vehicle vehicle) {
		if (register.get(vehicle.getRegNumber()) != null) {
			register.remove(vehicle.getRegNumber());
			saveRegister();
		}
	}

	//get multiply name of clases in string, and return all fields
	public Field[] getAllFields(String...args) {
		Class<?> Cref = null;
		Field[] allFields = new Field[]{};
		for (int i = 0; i < args.length; i++) {
			try {
				Cref = Class.forName("program." + args[i]);
				Field[] classFields = Cref.getDeclaredFields();

				allFields = Stream.concat(Arrays.stream(allFields), Arrays.stream(classFields))
						.toArray(Field[]::new);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return allFields;
	}

	//Getters & Setters
	public ArrayList<Person> getPersons() {
		return persons;
	}
	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public Map<String, String> getRegister() {
		return register;
	}
	public void setRegister(HashMap<String, String> register) {
		this.register = register;
	}
}
	
	





