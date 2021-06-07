package solution;

import java.awt.*;
import java.io.*;
<<<<<<< HEAD
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws Exception
    {
        Developer developer=new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer.makeJob());
    }
}
=======
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        USB usb=new CardReader(new MemoryCard());
        usb.connectWithUsbCable();
        usb=new Cable(new Telephone());
        usb.connectWithUsbCable();
    }
}
>>>>>>> 8be50d1ece75abd1979a95b65495ff50f55da243
