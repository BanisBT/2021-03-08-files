package org.example.service.fileManager.paymentManager;

import org.example.modul.Payment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentFileMangerImpl implements PaymentFileManager {
    @Override
    public List<Payment> paymentsFromFile(String path) throws IOException {
        List<Payment> payments = new ArrayList<>();
        Payment tempPayment = null;
        BufferedReader br = null;
        try{
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            br = new BufferedReader( new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null){
                payments.add(paymentFromString(line));
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br != null)
                br.close();
        }
        return payments;
    }

    @Override
    public Payment paymentFromString(String textFromFile) {
        Payment paymentFromString = null;
        String[] stringFromFile = textFromFile.split(", ");
        Payment tempPayment = new Payment();
        tempPayment.setPaymentId(Integer.parseInt(stringFromFile[0]));
        tempPayment.setAmount(Integer.parseInt(stringFromFile[1]));
        tempPayment.setReceiverId(Integer.parseInt(stringFromFile[2]));
        tempPayment.setSenderId(Integer.parseInt(stringFromFile[3]));
        paymentFromString = tempPayment;
        return paymentFromString;
    }
}
