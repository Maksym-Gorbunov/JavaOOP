package program;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    private Crud crud;
    private String regNumber, model, year, weight, color, fuel, numberOfPassangers, loadWeight, loadVolume,
            enginePower, fuelConsumption, tankSize, gears, powerConsumption, batterySize, vehicleType,
            personalNumber, name, adress, age;

    public Controller(Crud crud){
        this.crud = crud;
    }

    public void createPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("personal number: ");
        personalNumber = sc.nextLine();
        if (Validator.isFieldValid("personalNumber", personalNumber)) {
            //person already exist
            if (getPersonByPersonalNumber(personalNumber) != null) {
                System.out.println("--> person '" + personalNumber + "' already exist");
            //create new person
            } else {
                System.out.print("name: ");
                name = sc.nextLine();
                System.out.print("age: ");
                age = sc.nextLine();
                System.out.print("adrsss: ");
                adress = sc.nextLine();
                if ((Validator.isFieldValid("name", name)) &&
                        (Validator.isFieldValid("age", age))) {
                    int age2 = Integer.parseInt(age);
                    Person person = new Person(personalNumber, name, age2, adress);
                    crud.getPersons().add(person);
                    System.out.println("--> new person '" + personalNumber + "' was created");
                    crud.savePersons();
                }
            }
        }
    }

    public void editPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("personal number: ");
        personalNumber = sc.nextLine();
        if (Validator.isFieldValid("personalNumber", personalNumber)) {
            //person doesnt exist
            if (getPersonByPersonalNumber(personalNumber) == null) {
                System.out.println("--> person '" + personalNumber + "' not found");
            //edit person
            } else {
                Person person = getPersonByPersonalNumber(personalNumber);
                if(person != null) {
                    System.out.print("name: ");
                    name = sc.nextLine();
                    System.out.print("age: ");
                    age = sc.nextLine();
                    System.out.print("adrsss: ");
                    adress = sc.nextLine();
                    if ((Validator.isFieldValid("name", name)) &&
                            (Validator.isFieldValid("age", age))) {
                        int ageInt = Integer.parseInt(age);
                        person.setName(name);
                        person.setAge(ageInt);
                        person.setAdress(adress);
                        System.out.println("--> person '" + personalNumber + "' data was updated");
                        crud.savePersons();
                    }
                }
            }
        }
    }

    //input - car fields(special)
    public boolean inputCarFields() {
        Scanner sc = new Scanner(System.in);
        System.out.print("number of passangers: ");
        numberOfPassangers = sc.nextLine();
        if(Validator.isFieldValid("numberOfPassangers", numberOfPassangers))
            return true;
        return false;
    }

    //input - fuel fields
    public Engine createEngine() {
        Scanner sc = new Scanner(System.in);
        System.out.print("engine type (petrol, diesel, electric): ");
        String engineType = sc.nextLine();
        System.out.print("engine power (kW): ");
        enginePower = sc.nextLine();
        if(Validator.isFieldValid("enginePower", enginePower)
            && Validator.isFieldValid("engineType", engineType)) {
            float enginePowerFloat = Float.parseFloat(enginePower);
            switch (engineType) {
                case "petrol":
                    System.out.print("fuel consumption (L/km): ");
                    fuelConsumption = sc.nextLine();
                    System.out.print("tank size (L): ");
                    tankSize = sc.nextLine();
                    System.out.print("number of gears: ");
                    gears = sc.nextLine();
                    if (Validator.isFieldValid("fuelConsumption", fuelConsumption)
                            && Validator.isFieldValid("tankSize", tankSize)
                            && Validator.isFieldValid("gears", gears)) {
                        float fuelConsumptionFloat = Float.parseFloat(fuelConsumption);
                        int tankSizeInt = Integer.parseInt(tankSize);
                        int gearsInt = Integer.parseInt(gears);
                        if (engineType.equals("petrol")) {
                            Engine engine = new Petrol(fuelConsumptionFloat, tankSizeInt, gearsInt, enginePowerFloat);
                            return engine;
                        }
                    }
                    return null;
                case "diesel":
                    System.out.print("fuel consumption (L/km): ");
                    fuelConsumption = sc.nextLine();
                    System.out.print("tank size (L): ");
                    tankSize = sc.nextLine();
                    System.out.print("number of gears: ");
                    gears = sc.nextLine();
                    if (Validator.isFieldValid("fuelConsumption", fuelConsumption)
                            && Validator.isFieldValid("tankSize", tankSize)
                            && Validator.isFieldValid("gears", gears)) {
                        float fuelConsumptionFloat = Float.parseFloat(fuelConsumption);
                        int tankSizeInt = Integer.parseInt(tankSize);
                        int gearsInt = Integer.parseInt(gears);
                        if (engineType.equals("diesel")) {
                            Engine engine = new Diesel(fuelConsumptionFloat, tankSizeInt, gearsInt, enginePowerFloat);
                            return engine;
                        }
                    }
                    return null;
                case "electric":
                    System.out.print("power consumption (kWh/km):");
                    powerConsumption = sc.nextLine();
                    System.out.print("battery size (kWh): ");
                    batterySize = sc.nextLine();
                    if (Validator.isFieldValid("powerConsumption", powerConsumption)
                            && Validator.isFieldValid("batterySize", batterySize)) {
                        float powerConsumptionFloat = Float.parseFloat(powerConsumption);
                        float batterySizeFloat = Float.parseFloat(batterySize);
                        Engine engine = new Electric(powerConsumptionFloat, batterySizeFloat, enginePowerFloat);
                        return engine;
                    }
                default:
                    System.out.println("--> invalid input: engine type (petrol, diesel, electric)");
                    break;
            }
        }
        return null;
    }

    //input - truck fields(special)
    public  boolean inputTruckFields() {
        Scanner sc = new Scanner(System.in);
        System.out.print("load weight: ");
        loadWeight = sc.nextLine();
        System.out.print("load volume: ");
        loadVolume = sc.nextLine();
        if(Validator.isFieldValid("loadWeight", loadWeight)
                && Validator.isFieldValid("loadVolume", loadVolume)) {
            return true;
        }
        return false;
    }

    //input - vehicle fields(all general but not regNumber)
    public boolean inputVehicleFields(){
        Scanner sc = new Scanner(System.in);
        System.out.print("model: ");
        model = sc.nextLine();
        System.out.print("year: ");
        year = sc.nextLine();
        System.out.print("weight (kg): ");
        weight = sc.nextLine();
        System.out.print("color: ");
        color = sc.nextLine();
        if(Validator.isFieldValid("model", model)
            && Validator.isFieldValid("year", year)
            && Validator.isFieldValid("weight", weight)
            && Validator.isFieldValid("color", color)) {
            return true;
        }
            System.out.println("________________________________________________________________");
        return false;
    }

    //get vehicle by register number
    public Vehicle getVehicleByRegNumber(String regNumber) {
        for(Vehicle vehicle : crud.getVehicles()) {
            if (vehicle.getRegNumber().equals(regNumber))
                return vehicle;
        }
        return null;
    }

    public void createVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("register number (AAA-555): ");
        regNumber = sc.nextLine();
        //vehicle already exist
        if(getVehicleByRegNumber(regNumber) != null) {
            System.out.println("--> vehicle '" + regNumber+ "' already exist");
        //create new vehicle
        } else {
            if(inputVehicleFields()){
                Engine fuel = createEngine();
                System.out.print("vehicle type (car, truck): " );
                vehicleType = sc.nextLine();
                if((vehicleType.equals("car") || vehicleType.equals("truck")) && fuel != null){
                    int yearInt = Integer.parseInt(year);
                    int weightInt = Integer.parseInt(weight);
                    switch (vehicleType) {
                        case "car":
                            if (inputCarFields()) {
                                int numberOfPassangersInt = Integer.parseInt(numberOfPassangers);
                                Vehicle vehicle = new Car(regNumber, model, yearInt, weightInt, color, numberOfPassangersInt, fuel);
                                //add car owner
                                System.out.print("car owner (personal number): ");
                                personalNumber = sc.nextLine();
                                //if owner not exist
                                if(getPersonByPersonalNumber(personalNumber) == null) {
                                    System.out.println("Create new person");
                                    createPerson();
                                    crud.getRegister().put(regNumber, personalNumber);
                                    crud.saveRegister();
                                //add car to owner
                                } else {
                                    crud.getRegister().put(regNumber, personalNumber);
                                    crud.saveRegister();
                                }
                                crud.getVehicles().add(vehicle);
                                crud.saveVehicles();
                                System.out.println("--> new car was successfully added");
                            }
                            break;
                        case "truck":
                            if (inputTruckFields()) {
                                int loadWeightInt = Integer.parseInt(loadWeight);
                                int loadVolumeInt = Integer.parseInt(loadVolume);
                                Vehicle vehicle = new Truck(regNumber, model, yearInt, weightInt, color, loadWeightInt, loadVolumeInt, fuel);
                                //add car owner
                                System.out.print("truck owner (personal number): ");
                                personalNumber = sc.nextLine();
                                //if owner not exist, create new person
                                if(getPersonByPersonalNumber(personalNumber) == null) {
                                    System.out.println("Create new person");
                                    createPerson();
                                    crud.getRegister().put(regNumber, personalNumber);
                                    crud.saveRegister();
                                    //add truck to owner
                                } else {
                                    crud.getRegister().put(regNumber, personalNumber);
                                    crud.saveRegister();
                                }
                                crud.getVehicles().add(vehicle);
                                crud.saveVehicles();
                                System.out.println("--> new truck was successfully added");
                            }
                            break;
                        default:
                            System.out.println("--> invalid input: vehicle type (car, truck)");
                            break;
                    }
                }
            }
        }
    }

    public void editVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("register number (AAA-555): ");
        regNumber = sc.nextLine();
        //if vehicle not exist
        if(getVehicleByRegNumber(regNumber) == null) {
            System.out.println("--> vehicle '" + regNumber+ "' not found");
        //edit vehicle
        } else {
            if(inputVehicleFields()){
                Vehicle vehicle = getVehicleByRegNumber(regNumber);
                Engine fuel = createEngine();
                vehicleType = vehicle.getClass().getSimpleName();
                if((vehicleType.equals("car") || vehicleType.equals("truck")) && fuel != null){
                    int yearInt = Integer.parseInt(year);
                    int weightInt = Integer.parseInt(weight);
                    vehicle.setModel(model);
                    vehicle.setYear(yearInt);
                    vehicle.setWeight(weightInt);
                    vehicle.setColor(color);
                    vehicle.setFuel(fuel);
                    switch (vehicleType) {
                        case "car":
                            if (inputCarFields()) {
                                int numberOfPassangersInt = Integer.parseInt(numberOfPassangers);
                                ((Car)vehicle).setNumberOfPassangers(numberOfPassangersInt);
                                crud.saveVehicles();
                                System.out.println("--> car '" + regNumber + "' was successfully edit");
                            }
                            break;
                        case "truck":
                            if (inputTruckFields()) {
                                int loadWeightInt = Integer.parseInt(loadWeight);
                                int loadVolumeInt = Integer.parseInt(loadVolume);
                                ((Truck)vehicle).setLoadVolume(loadVolumeInt);
                                ((Truck)vehicle).setLoadWeight(loadWeightInt);
                                crud.saveVehicles();
                                System.out.println("--> truck '" + regNumber + "' was successfully edit");
                            }
                            break;
                    }
                }
            }
        }
    }

    public Person getPersonByPersonalNumber(String personalNumber) {
        for(Person person : crud.getPersons()) {
            if(person.getPersonalNumber().equals(personalNumber))
                return person;
        }
        return null;
    }

    public void showAllPersons(){
        System.out.println("P E R S O N S:");
          for(Person person : (crud.loadPersons())) {
            System.out.println("  - " + person.getName() + " (" + person.getPersonalNumber() + ")");
        }
    }

    public void showAllVehicles(){
        System.out.println("V E H I C L E S:");
        for(Vehicle vehicle : (crud.loadVehicles())) {
            System.out.println("  - " + vehicle.getModel() + " (" + vehicle.getRegNumber() + ")");
        }
    }

    public void loadPersons() {
        crud.loadPersons();
    }

    public void loadVehicles() {
        crud.loadVehicles();
    }

    public void showRegister(){
        System.out.println("R E G I S T E R:");
        if (crud.getRegister().isEmpty()){
            System.out.println("--> register list is empty");
        } else {
            for (HashMap.Entry<String, String> entry : crud.getRegister().entrySet()) {
                System.out.println("  - (" + entry.getKey() + ") : (" + entry.getValue() + ")");
            }
        }
    }

    public void loadRegister() {
        crud.loadRegister();
    }

    public ArrayList<String> getAllVehiclesByPersonalNumber(String personalNumber) {
        ArrayList<String> vehiclesList = new ArrayList<>();
        for (HashMap.Entry<String, String> entry : crud.getRegister().entrySet()) {
            if (entry.getValue().equals(personalNumber)) {
                vehiclesList.add(entry.getKey());
            }
        }
        if (vehiclesList.isEmpty()) {
            return null;
        } else {
            return vehiclesList;
        }
    }

    public void deletePerson() {
        Scanner sc = new Scanner(System.in);
        String personalNumber;
        System.out.print("personal number: ");
        personalNumber = sc.nextLine();
        if(Validator.isFieldValid("personalNumber", personalNumber)) {
            Person person = getPersonByPersonalNumber(personalNumber);
                if(person != null ) {
                    //delete person only if no vehicles matches in register
                    if(getAllVehiclesByPersonalNumber(person.getPersonalNumber()) == null) {
                        crud.deletePerson(person);
                        System.out.println("--> person '" + person.getPersonalNumber() + "' was deleted successfully");
                    } else {
                        System.out.print("Can't delete '" + person.getPersonalNumber() + "' while exist: ");
                        System.out.println(getAllVehiclesByPersonalNumber(person.getPersonalNumber()));
                    }
                } else {
                    System.out.println("--> person '" + personalNumber + "' not found");
                }
        }
    }

    public void deleteVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("register number: ");
        regNumber = sc.nextLine();
        if(Validator.isFieldValid("registerNumber", regNumber)) {
            Vehicle vehicle = getVehicleByRegNumber(regNumber);
            if(vehicle != null) {
                crud.deleteVehicle(vehicle);
                crud.deleteVehicleFromRegister(vehicle);
                System.out.println("--> vehicle '" + vehicle.getRegNumber() + "' was deleted successfully" );
            } else {
                System.out.println("--> vehicle '" + regNumber + "' not found");
            }
        }
    }

    //find vehicle by register number (and person as owner)
    public void findVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter register number: ");
        regNumber = sc.nextLine();
        if (Validator.isFieldValid("regNumber", regNumber)) {
            if (getVehicleByRegNumber(regNumber) != null) {
                Vehicle vehicle = getVehicleByRegNumber(regNumber);
                System.out.println();
                System.out.println("RESULT:");
                System.out.println(vehicle.info());

            } else {
                System.out.println("--> vehicle '" + regNumber + "' not found");
                System.out.println();
            }

        }
    }

    //find person by personal number
    public void findPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter personal number: ");
        personalNumber = sc.nextLine();
        if(Validator.isFieldValid("personalNumber", personalNumber)) {
            if(getPersonByPersonalNumber(personalNumber) != null) {
                Person person = getPersonByPersonalNumber(personalNumber);
                System.out.println();
                System.out.println("RESULT:");
                System.out.println(person.info());
                System.out.println("vehicles: ");
                if(getAllVehiclesByPersonalNumber(personalNumber) != null) {
                    for(String vehicle : getAllVehiclesByPersonalNumber(personalNumber)) {
                        System.out.println("  - (" + vehicle + ")");
                    }
                } else {
                    System.out.println("    not found");
                }
                System.out.println();
            } else {
                System.out.println("--> person '" + personalNumber + "' not found");
                System.out.println();
            }
        }
    }

    //search everywhere, example: red, Tesla, diesel, car, truck,...any field
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter value to find: ");
        String input = sc.nextLine();
        int matches = 0;

        //search in persons
        Field[] personFields = Person.class.getDeclaredFields();
        for (Person person : crud.getPersons()) {
            for (Field field : personFields) {
                try {
                    field.setAccessible(true);
                    String value = field.get(person).toString();
                    if (input.equals(value)) {
                        matches++;
                        System.out.println("'" + input + "'" + " matches in: " + person.getName() + " ("
                                + person.getPersonalNumber() + ")");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        //search in vehicles
        for (Vehicle vehicle : crud.getVehicles()) {
            //check all general fields for vehicle
            for (Field field : Vehicle.class.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    String value = field.get(vehicle).toString();
                    if (input.equals(value)) {
                        matches++;
                        System.out.println("'" + input + "'" + " matches in: " + vehicle.getModel() + " ("
                                + vehicle.getRegNumber() + ")");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (vehicle instanceof Car) {
                numberOfPassangers = String.valueOf(((Car) vehicle).getNumberOfPassangers());
                if (input.equals(numberOfPassangers) || input.equals("car")) {
                    matches++;
                    System.out.println("'" + input + "'" + " matches in: " + vehicle.getModel() + " ("
                            + vehicle.getRegNumber() + ")");
                }
            } else if (vehicle instanceof Truck) {
                loadWeight = String.valueOf(((Truck) vehicle).getLoadWeight());
                loadVolume = String.valueOf(((Truck) vehicle).getLoadVolume());
                if (input.equals(loadWeight) || input.equals(loadVolume) || input.equals("truck")) {
                    matches++;
                    System.out.println("'" + input + "'" + " matches in: " + vehicle.getModel() + " ("
                            + vehicle.getRegNumber() + ")");
                }
            }
            //check all fuel fields
            enginePower = String.valueOf(vehicle.getFuel().getEnginePower());
            if (input.equals(enginePower)) {
                matches++;
                System.out.println("'" + input + "'" + " matches in: " + vehicle.getModel() + " ("
                        + vehicle.getRegNumber() + ")");
            } else if (vehicle.getFuel() instanceof Petrol) {
                fuelConsumption = String.valueOf(((Petrol) vehicle.getFuel()).getFuelConsumption());
                tankSize = String.valueOf(((Petrol) vehicle.getFuel()).getTankSize());
                gears = String.valueOf(((Petrol) vehicle.getFuel()).getGears());
                if (input.equals(fuelConsumption) || input.equals(tankSize)
                        || input.equals(gears) || input.equals("petrol")) {
                    matches++;
                    System.out.println("'" + input + "'" + " matches in: " + vehicle.getModel() + " ("
                            + vehicle.getRegNumber() + ")");
                }
            } else if (vehicle.getFuel() instanceof Diesel) {
                fuelConsumption = String.valueOf(((Diesel) vehicle.getFuel()).getFuelConsumption());
                tankSize = String.valueOf(((Diesel) vehicle.getFuel()).getTankSize());
                gears = String.valueOf(((Diesel) vehicle.getFuel()).getGears());
                if (input.equals(fuelConsumption) || input.equals(tankSize)
                        || input.equals(gears) || input.equals("diesel")) {
                    matches++;
                    System.out.println("'" + input + "'" + " matches in: " + vehicle.getModel() + " ("
                            + vehicle.getRegNumber() + ")");
                }
            } else if (vehicle.getFuel() instanceof Electric) {
                powerConsumption = String.valueOf(((Electric) vehicle.getFuel()).getPowerConsumption());
                batterySize = String.valueOf(((Electric) vehicle.getFuel()).getBatterySize());
                if (input.equals(powerConsumption) || input.equals(batterySize) || input.equals("electric")) {
                    matches++;
                    System.out.println("'" + input + "'" + " matches in: " + vehicle.getModel() + " ("
                            + vehicle.getRegNumber() + ")");
                }
            }
        }
        if (matches > 0) {
            System.out.println("--> total matches: " + matches);
        } else {
            System.out.println("'" + input + "' not found");
        }
    }
}
