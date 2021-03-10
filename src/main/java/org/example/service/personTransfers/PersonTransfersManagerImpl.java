package org.example.service.personTransfers;

import javafx.beans.binding.MapExpression;
import org.example.modul.Payment;
import org.example.modul.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PersonTransfersManagerImpl implements PersonTransfersManager {

    @Override
    public void addSendMoneyToPerson(List<Payment> payments, Map<Integer, Person> personsSendMoney) {
        for (Payment payment : payments) {
            int sendMoney = payment.getAmount();
            int personSendMoneyAmount = personsSendMoney.get(payment.getSenderId()).getSendMoney();
            personsSendMoney.get(payment.getSenderId()).setSendMoney(sendMoney + personSendMoneyAmount);
        }
    }

    @Override
    public void addReceivedMoneyToPerson(List<Payment> payments, Map<Integer, Person> personsReceivedMoney) {
        for (Payment payment : payments) {
            int receivedMoney = payment.getAmount();
            int personReceivedMoney = personsReceivedMoney.get(payment.getReceiverId()).getReceivedMoney();
            personsReceivedMoney.get(payment.getReceiverId()).setReceivedMoney(receivedMoney + personReceivedMoney);
        }
    }

    private List<Person> getPersonsList(Map<Integer, Person> personsWithTransfers) {
        List<Person> personList = new ArrayList<>();
        for (Map.Entry<Integer, Person> entry : personsWithTransfers.entrySet()) {
            personList.add(entry.getValue());
        }
        return personList;
    }

    @Override
    public List<Person> fromBiggestSender(Map<Integer, Person> personsSenders) {
        List<Person> personListBiggestSenders = getPersonsList(personsSenders);

        for (int i = 0; i < personListBiggestSenders.size() - 1; i++) {
            for (int j = 0; j < personListBiggestSenders.size() - 1; j++) {
                if (personListBiggestSenders.get(j).getSendMoney() < personListBiggestSenders.get(j + 1).getSendMoney()) {
                    Collections.swap(personListBiggestSenders, j, j + 1);
                }
            }
        }
        return personListBiggestSenders;
    }

    @Override
    public List<Person> fromBiggestReceivers(Map<Integer, Person> personsReceivers) {
        List<Person> personListBiggestReceivers = getPersonsList(personsReceivers);

        for (int i = 0; i < personListBiggestReceivers.size() - 1; i++) {
            for (int j = 0; j < personListBiggestReceivers.size() - 1; j++) {
                if (personListBiggestReceivers.get(j).getReceivedMoney() < personListBiggestReceivers.get(j + 1).getReceivedMoney()) {
                    Collections.swap(personListBiggestReceivers, j, j + 1);
                }
            }
        }
        return personListBiggestReceivers;
    }
}
