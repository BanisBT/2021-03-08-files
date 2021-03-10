package org.example.service.fileManager.paymentManager;

import org.example.modul.Payment;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PaymentFileManager {
    List<Payment> paymentsFromFile(String path) throws IOException;
    Payment paymentFromString(String textFromFile);
}
