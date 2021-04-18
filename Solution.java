package solution;

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
    public static SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));
        //allPeople.add(Person.createMale("Сидоров Сидр", new Date()));//сегодня родился    id=2
    }

    public static void main(String[] args) throws Exception {

        key = args[0];

        switch (key) {
            case "-c":
                synchronized (allPeople) {
                    create(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    update(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    delete(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    print(args);
                }
                break;

        }
        //start here - начни тут
    }

    public static void create(String args[]) throws ParseException {
        int j = 1;
        while (j < args.length) {
            name = args[j];
            sex = args[j + 1];
            date = args[j + 2];
            Date db = sdf.parse(date);
            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, db));
            else if (sex.equals("ж"))
                allPeople.add(Person.createFemale(name, db));
            System.out.println(allPeople.size() - 1);
            j = j + 3;
        }
    }

    public static void update(String args[]) throws ParseException {
        int j = 1;
        while (j < args.length) {
            id = Integer.parseInt(args[j]);
            name = args[j + 1];
            sex = args[j + 2];
            date = args[j + 3];
            Date db = sdf.parse(date);
            if (sex.equals("м"))
                allPeople.set(id, Person.createMale(name, db));
            if (sex.equals("ж"))
                allPeople.set(id, Person.createFemale(name, db));

            j=j+4;
        }

    }

    public static void delete(String args[]) {
       int j=1;
       while(j<args.length) {

           id = Integer.parseInt(args[j]);
           Person person = allPeople.get(id);
           person.setBirthDate(null);
           person.setSex(null);
           person.setName(null);

           allPeople.set(id, person);
           j++;
       }

        //  System.out.println(allPeople.get(id));

    }

    public static void print(String args[]) {
        int j=1;
        while(j< args.length) {
            id = Integer.parseInt(args[j]);
            System.out.println(allPeople.get(id));
            j++;
        }

    }
}
