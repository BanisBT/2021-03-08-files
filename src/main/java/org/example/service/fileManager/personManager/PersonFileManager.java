package org.example.service.fileManager.personManager;

import org.example.modul.Person;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PersonFileManager {
    Person stringFromTxt(String textFromFile);

    Map<Integer, Person> mapPersonsFromFile(String path) throws IOException;

    void writerFilePersonSendMoney(String path, List<Person> personListSend, boolean append);
    void writerFilePersonReceiver(String path, List<Person> personListReceiv, boolean append);
}
