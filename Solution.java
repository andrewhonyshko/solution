package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static String key;
    public static String name;
    public static String sex;
    public static String date;
    public static int id;
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=0
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=1
    }

    public static void main(String[] args) {

        key=args[0];

        switch (key) {
            case "-c":
                create(args);
                break;
            case "-u":
                update(args);
                break;
            case "-d":
                delete(args);

            case "-i":
                print(args);
                break;

        }
        //start here - ����� ���
    }

    public static void create(String args[]) {
        name = args[1];
        sex = args[2];
        date = args[3];
        try {
            Date db = simpleDateFormat.parse(date);
            if (sex.equals("�"))
                allPeople.add(Person.createMale(name, db));
            if (sex.equals("�"))
                allPeople.add(Person.createFemale(name, db));
            System.out.println(allPeople.size() - 1);
        } catch (ParseException e) {

        }

    }

    public static void update(String args[]) {
        id=Integer.parseInt(args[1]);
        name = args[2];
        sex = args[3];
        date = args[4];
        try {
            Date db = simpleDateFormat.parse(date);
            if (sex.equals("�"))
                allPeople.set(id,Person.createMale(name, db));
            if (sex.equals("�"))
                allPeople.set(id,Person.createFemale(name, db));
            System.out.println(allPeople.size() - 1);
        } catch (ParseException e) {

        }

    }

    public static void delete(String args[])
    {
        id=Integer.parseInt(args[1]);
        allPeople.remove(id);

    }
    public static void print(String args[])
    {
        id=Integer.parseInt(args[1]);
        simpleDateFormat.applyPattern("dd-MM-yyyy");
        Person person=allPeople.get(id);
        System.out.println(person.getName());
        System.out.println(person.getSex());
        System.out.println(person.getBirt);



    }
}
