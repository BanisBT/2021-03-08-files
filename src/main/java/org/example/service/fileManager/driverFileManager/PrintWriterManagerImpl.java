package org.example.service.fileManager.driverFileManager;

import org.example.modul.Driver;
import org.example.service.fileManager.driverFileManager.PrintWriterManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PrintWriterManagerImpl implements PrintWriterManager {
    @Override
    public void printWriter(List<Driver> drivers, String path, boolean append) {
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(path, append);
            BufferedWriter bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (Driver driver : drivers) {
                pw.println(driver.stringToCsv());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close();
        }
    }

    @Override
    public Driver stringFromCsv(String csvText) {
        Driver driverFromFile = null;
        String[] stringFromFile = csvText.split(",");
        Driver tempDriver = new Driver();
        tempDriver.setName(stringFromFile[0]);
        tempDriver.setVehicleModel(stringFromFile[1]);
        tempDriver.setVehicleRegistration(stringFromFile[2]);
        tempDriver.setVehicleMileage(Integer.parseInt(stringFromFile[3]));
        driverFromFile = tempDriver;

        return driverFromFile;
    }

    @Override
    public ArrayList<Driver> bufferedReader(String path) throws IOException {
        ArrayList<Driver> drivers = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                drivers.add(stringFromCsv(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return drivers;
    }
}
