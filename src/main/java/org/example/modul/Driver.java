package org.example.modul;

public class Driver {
    private String name;
    private String vehicleModel;
    private String vehicleRegistration;
    private int vehicleMileage;

    public Driver() {
    }

    public Driver(String name, String vehicleModel, String vehicleRegistration, int vehicleMileage) {
        this.name = name;
        this.vehicleModel = vehicleModel;
        this.vehicleRegistration = vehicleRegistration;
        this.vehicleMileage = vehicleMileage;
    }

    public String stringToCsv() {
        return String.format("%s,%s,%s,%d", name, vehicleModel, vehicleRegistration, vehicleMileage);
    }

    @Override
    public String toString() {
        return "Vairuotojo info: " + '\n' + "Vardas | automobilis | automobilio numeris | rida " + '\n' +
                name + " | " + vehicleModel + " |  " + vehicleRegistration + " | " + vehicleMileage + '\n';
    }

    public String getName() {
        return name;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public int getVehicleMileage() {
        return vehicleMileage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public void setVehicleMileage(int vehicleMileage) {
        this.vehicleMileage = vehicleMileage;
    }
}
