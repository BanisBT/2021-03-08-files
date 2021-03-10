package org.example.service.fileManager.driverFileManager;

import org.example.modul.Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface PrintWriterManager {
    void printWriter(List<Driver> drivers, String path, boolean append);

    Driver stringFromCsv(String csvText);

    ArrayList<Driver> bufferedReader(String path) throws IOException;
}
