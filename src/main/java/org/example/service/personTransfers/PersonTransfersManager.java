package org.example.service.personTransfers;

import org.example.modul.Payment;
import org.example.modul.Person;

import java.util.List;
import java.util.Map;

public interface PersonTransfersManager {
    void addSendMoneyToPerson(List<Payment> payments, Map<Integer, Person> personsSendMoney);

    void addReceivedMoneyToPerson(List<Payment> payments, Map<Integer, Person> personsReceivedMoney);

    List<Person> fromBiggestSender(Map<Integer, Person> personsSenders);

    List<Person> fromBiggestReceivers(Map<Integer, Person> personsReceivers);
}
