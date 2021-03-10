package org.example;

import org.example.modul.Driver;
import org.example.modul.Payment;
import org.example.modul.Person;
import org.example.service.fileManager.charFileManager.FileWriterReader;
import org.example.service.fileManager.charFileManager.FileWriterReaderImpl;
import org.example.service.fileManager.driverFileManager.PrintWriterManager;
import org.example.service.fileManager.driverFileManager.PrintWriterManagerImpl;
import org.example.service.fileManager.paymentManager.PaymentFileManager;
import org.example.service.fileManager.paymentManager.PaymentFileMangerImpl;
import org.example.service.fileManager.personManager.PersonFileManager;
import org.example.service.fileManager.personManager.PersonFileManagerImpl;
import org.example.service.personTransfers.PersonTransfersManager;
import org.example.service.personTransfers.PersonTransfersManagerImpl;
import org.example.service.stringManager.StringReverse;
import org.example.service.stringManager.StringReverseImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    private static String path = "/Users/Gabi/IdeaProjects/2021-03-08-files/src/main/java/org/example/files/Name.txt";
    private static String pathReverse = "/Users/Gabi/IdeaProjects/2021-03-08-files/src/main/java/org/example/files/NameReverse.txt";
    private static String pathDriver = "/Users/Gabi/IdeaProjects/2021-03-08-files/src/main/java/org/example/files/Driver.csv";
    private static String pathPerson = "/Users/Gabi/IdeaProjects/2021-03-08-files/src/main/java/org/example/files/People.txt";
    private static String pathPayment = "/Users/Gabi/IdeaProjects/2021-03-08-files/src/main/java/org/example/files/Payment.txt";
    private static String pathSend = "/Users/Gabi/IdeaProjects/2021-03-08-files/src/main/java/org/example/files/PeopleBySendMoney.txt";
    private static String pathReceived = "/Users/Gabi/IdeaProjects/2021-03-08-files/src/main/java/org/example/files/PeopleByReveivedMoney.txt";

    public static void main(String[] args) throws IOException {
        FileWriterReader reader = new FileWriterReaderImpl();
        StringReverse reverse = new StringReverseImpl();
        PrintWriterManager printW = new PrintWriterManagerImpl();
        PersonFileManager personMng = new PersonFileManagerImpl();
        PaymentFileManager payMng = new PaymentFileMangerImpl();
        PersonTransfersManager transferMng = new PersonTransfersManagerImpl();

        char[] text = "Tomas Barauskas".toCharArray();
        reader.fileWriter(path, text);
        String textFromFile = reader.fileReader(path);
        String textReverse = reverse.stringReverse(textFromFile);
        reader.fileWriter(pathReverse, textReverse.toCharArray());

        List<Driver> drivers = new ArrayList<>();
        drivers.add( new Driver("Tomas", "Volvo","ABC123", 123000));
        drivers.add( new Driver("Andrius", "BMW","ABD444", 444000));
        drivers.add( new Driver("Paulius", "Ferrari","DDD123", 12000));
        drivers.add( new Driver("Kestas", "Audi","ABC999", 999000));

        printW.printWriter(drivers,pathDriver, false);
        List<Driver> driversFromFile = printW.bufferedReader(pathDriver);
//        for (Driver driver : driversFromFile){
//            System.out.println(driver);
//
        Map<Integer, Person> persons;
        persons = personMng.mapPersonsFromFile(pathPerson);
//        System.out.println(persons.get(3066));

        List<Payment> payments = payMng.paymentsFromFile(pathPayment);
        transferMng.addSendMoneyToPerson(payments, persons);
        transferMng.addReceivedMoneyToPerson(payments, persons);

        List<Person> personList = transferMng.fromBiggestSender(persons);
//        for (Person person : personList){
//            System.out.println(person);
//        }

        personMng.writerFilePersonSendMoney(pathSend,personList,false);
        personList = transferMng.fromBiggestReceivers(persons);
        personMng.writerFilePersonReceiver(pathReceived,personList,false);
        }
    }

