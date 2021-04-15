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
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=0
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=1
    }

    public static void main(String[] args) {

        getArgs(args);

        switch (key) {
            case "-c":
                create(args);
                break;
            case "-u":
                update(args);
                break;

        }
        //start here - ����� ���
    }

    public static void create(String args[]) {


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
        try {
            Date db = simpleDateFormat.parse(date);
            if (sex.equals("�"))
                allPeople.set(0,Person.createMale(name, db));
            if (sex.equals("�"))
                allPeople.set(0,Person.createFemale(name, db));
            System.out.println(allPeople.size() - 1);
        } catch (ParseException e) {

        }

    }

    public static void getArgs(String args[]) {
        key = args[0];
        name = args[1];
        sex = args[2];
        date = args[3];
    }
}
