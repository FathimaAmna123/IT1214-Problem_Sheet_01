class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    
    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles;
    private int vehicleCount;

    public ParkingLot() {
        vehicles = new Vehicle[5]; // Max capacity is 5
        vehicleCount = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount++] = vehicle;
        } else {
            System.out.println("Parking lot is full. Cannot park new vehicle.");
        }
    }

    
    public void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getLicensePlate().equalsIgnoreCase(licensePlate)) {
                found = true;
                
                for (int j = i; j < vehicleCount - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[--vehicleCount] = null;
                System.out.println("Vehicle with license plate " + licensePlate + " has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with license plate " + licensePlate + " not found.");
        }
    }

    public void displayVehicles() {
        if (vehicleCount == 0) {
            System.out.println("Parking lot is empty.");
        } else {
            System.out.println("Parked Vehicles:");
            for (int i = 0; i < vehicleCount; i++) {
                Vehicle v = vehicles[i];
                System.out.println("License Plate: " + v.getLicensePlate() +
                                   ", Owner: " + v.getOwnerName() +
                                   ", Hours Parked: " + v.getHoursParked());
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        parkingLot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));
		
        parkingLot.removeVehicle("XYZ789");

        parkingLot.displayVehicles();
    }
}
