package solution;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        DataBase dataBase=new AdapterDataBase();
        dataBase.insert();
        dataBase.update();
        dataBase.delete();

    }
}