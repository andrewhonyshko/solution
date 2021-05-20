package solution;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        String key=args[0];


        switch (key)
        {
            case "-e":
                coder(args[1], args[2]);
                break;
            case "-d":
                decoder(args[1], args[2]);
                break;
        }



    }

    public static void coder(String fileName, String fileOutput) {
        try {
            InputStream stream = new FileInputStream(fileName);
            BufferedInputStream buffer = new BufferedInputStream(stream,200);
            List<Character> characters=new ArrayList<>();
            int i=0;
            while((i=buffer.read())!=-1)
            {
                characters.add((char) ((char) i*10));
                list.add(i*10);
            }
            BufferedOutputStream bufferedOutput=new BufferedOutputStream(
                    new FileOutputStream(fileOutput));

            for(Integer b:list)
                bufferedOutput.write(b);
            buffer.close();
            bufferedOutput.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       // buffer.
    }
    public static void decoder(String fileName, String fileOutput)
    {
        try {
            InputStream stream = new FileInputStream(fileName);
            BufferedInputStream buffer = new BufferedInputStream(stream,200);
            List<Integer> list=new ArrayList<>();
            List<Character> characters=new ArrayList<>();

            int i=0;
            while((i=buffer.read())!=-1)
            {
                characters.add((char) (i/10));
                list.add(i/10);
            }
            BufferedOutputStream bufferedOutput=new BufferedOutputStream(
                    new FileOutputStream(fileOutput));

            for(Integer b:list)
                bufferedOutput.write(b);
            buffer.close();
            bufferedOutput.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
