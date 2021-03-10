package org.example.modul;

public class Person {
    private int id;
    private String name;
    private String surname;
    private int receivedMoney;
    private int sendMoney;

    public Person() {
    }

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Zmogus: " + '\n' + "Id | Vardas | Pavarde" + '\n' +
                id + " | " + name + " | " + surname + '\n' +
                "Asmuo yra issiuntes " + sendMoney + " pinigu" + '\n' +
                "Asmuo yra gaves " + receivedMoney + " pinigu" + '\n';
    }
    public String toStringTxtSend(){
        return String.format("%s,%s,%d",name,surname,sendMoney);
    }
    public String toStringTxtReceived(){
        return String.format("%s,%s,%d",name,surname,receivedMoney);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(int receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public int getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(int sendMoney) {
        this.sendMoney = sendMoney;
    }
}
