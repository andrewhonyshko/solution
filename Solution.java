package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
    static
    {

        try {
            firstFileName = reader.readLine();
            secondFileName=reader.readLine();
        }
        catch (IOException e)
        {

        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        try {
            String x="D:\\text.txt";
            //FileReader fileReader = new FileReader(this.fullFileName);
            FileReader fileReader = new FileReader(x);
            reader=new BufferedReader(fileReader);
           if(reader.ready()) {
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line= reader.readLine();

          //          this.content += " " + line;
                }
            }
            reader.close();
            fileReader.close();
        }
        catch ( IOException e)
        {
            e.printStackTrace();
        }
      systemOutPrintln(firstFileName);
        //systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface extends Runnable{

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface
    {
        private String fullFileName;
        private String content="";

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName=fullFileName;

        }

        @Override
        public String getFileContent() {
            return content;
        }

        @Override
        public void run() {
            try {
               // String x="D:\\text.txt";
                FileReader fileReader = new FileReader(this.fullFileName);
                //FileReader fileReader = new FileReader(x);
                BufferedReader reader=new BufferedReader(fileReader);
                if(reader.ready()) {
                    String line;
                    while ((line=reader.readLine()) != null) {
                        System.out.println(line);
                        this.content+=line+" ";
                    }
                }

                this.content.trim();
                reader.close();
                fileReader.close();
            }
            catch ( IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    //add your code here - class
}
