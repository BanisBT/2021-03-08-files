package org.example.service.fileManager.personManager;

import org.example.modul.Person;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonFileManagerImpl implements PersonFileManager {
    @Override
    public Person stringFromTxt(String textFromFile) {
        Person personFromFile = null;
        String[] stringFromFile = textFromFile.split(",");
        Person tempPerson = new Person();
        tempPerson.setId(Integer.parseInt(stringFromFile[0]));
        tempPerson.setName(stringFromFile[1]);
        tempPerson.setSurname(stringFromFile[2]);
        personFromFile = tempPerson;
        return personFromFile;
    }

    @Override
    public Map<Integer, Person> mapPersonsFromFile(String path) throws IOException {
        Map<Integer, Person> personsFromFile = new HashMap<>();
        Person tempPerson = null;
        BufferedReader br = null;
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                tempPerson = stringFromTxt(line);
                personsFromFile.put(tempPerson.getId(), tempPerson);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
        return personsFromFile;
    }

    @Override
    public void writerFilePersonSendMoney(String path, List<Person> personListSend, boolean append) {
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(path, append);
            BufferedWriter bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (Person person : personListSend) {
                pw.println(person.toStringTxtSend());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close();
        }
    }

    @Override
    public void writerFilePersonReceiver(String path, List<Person> personListReceived, boolean append) {
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(path,append);
            BufferedWriter bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (Person person : personListReceived){
                pw.println(person.toStringTxtReceived());
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (pw != null)
                pw.close();
        }
    }

}
