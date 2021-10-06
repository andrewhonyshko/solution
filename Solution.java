package solution;



/* 
И еще один адаптер
*/


import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[][] crossword = new int[][]{
                {'f', 'e', 'r', 'r', 'o', 'k'},
                {'u', 's', 'e', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'r'},
                {'e', 'e', 'p', 'r', 'e', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        int[][] crossword1 = new int[][]{
                {'a', 'e', 'c', 'd', 'e', 'f'},
                {'b', 'c', 'e', 'c', 'f', 'g'},
                {'c', 'd', 'k', 'f', 'g', 'h'},
                {'d', 'r', 'f', 'g', 'h', 'k'},
                {'e', 'f', 'g', 'h', 'a', 'b'}
        };
        Time time=new Time();
        time.setStart(new Date().getTime());
        detectAllWords(crossword1, "ee","erp","mgep", "ane", "sf","home","ome","me").forEach(System.out::println);
        time.setStop(new Date().getTime());

        FileOutputStream fileOutputStream=new FileOutputStream("d://file.txt",true);
        ObjectOutputStream outputStream=new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(time);

        Time time1=new Time();
        time1.setStart(new Date().getTime());
        detectAll(crossword1, "ee","erp","mgep", "ane", "sf","home","ome","me").forEach(System.out::println);
        time1.setStop(new Date().getTime());
        outputStream.writeObject(time1);
        System.out.println(time);

        FileInputStream fileInputStream=new FileInputStream("d://file.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        //Time timeSerializable=(Time)objectInputStream.readObject();
        objectInputStream.close();
        //System.out.println(detectAllWords(crossword, "derl","masu","epr","pgae"));

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] copy, String... words) {
        List<Word> list = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (String s : words) {
            Word word;
            int lengthWord = s.length();
            char[] ch = s.toCharArray();

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[i].length; j++) {
                    char[] tempArr = new char[ch.length];
                    int tempY;
                    int tempX;
                    if (ch.length == 1) {
                        if (ch[0] == copy[i][j]) {
                            word = new Word(s);
                            word.setStartPoint(j, i);
                            word.setEndPoint(j, i);
                            list.add(word);
                        }
                    } else if (ch[0] == copy[i][j])//find first char
                    {
                        ///////////////////////////////////////////////
                        // ЧТЕНИЕ КРОСВОРДА СЛЕВА НАПРАВО

                        //проверяем, не находиться первая буква на правой границе и хватит ли ему места
                        if (j <= copy[i].length - lengthWord) {
                            tempY = j;
                            tempX = i;
                            //счытываем символы в массиве  сopy[i][j] по горизонтали
                            // слева на право
                            for (int k = 0; k < tempArr.length; k++) {
                                tempArr[k] = (char) copy[tempX][tempY];
                                tempY++;
                            }
                            //проверяем, равны ли оба масива
                            if (Arrays.equals(ch, tempArr)) {
                                x = i;
                                y = j + (s.length() - 1);
                                word = new Word(s);
                                word.setStartPoint(j, i);
                                word.setEndPoint(y, x);
                                list.add(word);
                            }
                            //ЧИТАЕМ ДИАГОНАЛИ СЛЕВА НА ПРАВО
                            //проверяем, не находиться первая буква на нижней границе и хватит ли ему места
                            if (i <= copy.length - lengthWord) {
                                tempY = j;
                                tempX = i;
                                //счытываем символы в массиве  сopy[i][j] по диагонали
                                // слева вниз
                                for (int k = 0; k < tempArr.length; k++) {
                                    tempArr[k] = (char) copy[tempX][tempY];
                                    tempY++;
                                    tempX++;
                                }
                                //проверяем, равны ли оба масива
                                if (Arrays.equals(ch, tempArr)) {
                                    x = i + (s.length() - 1);
                                    y = j + (s.length() - 1);
                                    word = new Word(s);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(y, x);
                                    list.add(word);
                                }
                            }

                            //проверяем, не находиться первая буква на верхней границе и хватит ли ему места
                            if(i >= lengthWord - 1) {
                                tempY = j;
                                tempX = i;
                                //счытываем символы в массиве  сopy[i][j] по диагонали
                                // слева вверх
                                for (int k = 0; k < tempArr.length; k++) {
                                    tempArr[k] = (char) copy[tempX][tempY];
                                    tempY++;
                                    tempX--;
                                }

                                //проверяем диагональ слева вверх
                                if(Arrays.equals(ch,tempArr)){
                                    x = i - (s.length() - 1);
                                    y = j + (s.length() - 1);
                                    word = new Word(s);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(y, x);
                                    list.add(word);
                                }
                            }
                        }

                        ///////////////////////////////////////////////
                        // ЧТЕНИЕ КРОСВОРДА СПРАВА НА ЛЕВО
                        //проверяем, не находиться первая буква на левой границе и хватит ли ему места
                        if (j >= lengthWord - 1) {
                            tempY = j;
                            tempX = i;
                            //проверяем, горизонталь в обратном порядке
                            for (int k = 0; k < tempArr.length; k++) {
                                tempArr[k] = (char) copy[tempX][tempY];
                                tempY--;
                            }
                            if (Arrays.equals(ch, tempArr)) {
                                x = i;
                                y = j - (s.length() - 1);
                                word = new Word(s);
                                word.setStartPoint(j, i);
                                word.setEndPoint(y, x);
                                list.add(word);
                            }

                            //ЧИТАЕМ ДИАГОНАЛИ СЛЕВА НА ПРАВО
                            //проверяем, не находиться первая буква на нижней границе и хватит ли ему места
                            if (i <= copy.length - lengthWord) {
                                tempY=j;
                                tempX=i;
                                //читаем диагональ в справа вниз
                                for (int k = 0; k < tempArr.length; k++) {
                                    tempArr[k] = (char) copy[tempX][tempY];
                                    tempY--;
                                    tempX++;
                                }
                                if(Arrays.equals(ch,tempArr)){
                                    x = i + (lengthWord - 1);
                                    y = j - (lengthWord - 1);
                                    word = new Word(s);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(y, x);
                                    list.add(word);
                                }
                            }
                            //проверяем, не находиться первая буква на верхней границе и хватит ли ему места
                            if(i >= lengthWord - 1) {
                                tempY=j;
                                tempX=i;
                                for (int k = 0; k < tempArr.length; k++) {
                                    tempArr[k] = (char) copy[tempX][tempY];
                                    tempY--;
                                    tempX--;
                                }
                                //читаем диагональ справа вверх
                                if(Arrays.equals(ch,tempArr))
                                {
                                    x = i - (s.length() - 1);
                                    y = j - (s.length() - 1);
                                    word = new Word(s);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(y, x);
                                    list.add(word);
                                }
                            }
                        }

                        //ЧИТАЕМ ВЕРТИКАЛИ
                        //проверяем, не находиться первая буква на нижней границе
                        // и хватит ли ему места
                        if(i <= copy.length - lengthWord) {
                            tempY=j;
                            tempX=i;
                            //читаем вертикаль в нормальном порядке
                            for (int k = 0; k < tempArr.length; k++) {
                                tempArr[k] = (char) copy[tempX][tempY];
                                tempX++;
                            }
                            //если массивы равны
                            if(Arrays.equals(ch,tempArr))
                            {
                                x = i + (s.length() - 1);
                                y = j;
                                word = new Word(s);
                                word.setStartPoint(j, i);
                                word.setEndPoint(y, x);
                                list.add(word);
                            }
                        }
                        //проверяем, не находиться первая буква на верхней границе
                        //и хватит ли ему места
                        if(i >= lengthWord - 1) {
                            tempY=j;
                            tempX=i;
                            for (int k = 0; k < tempArr.length; k++) {
                                tempArr[k] = (char) copy[tempX][tempY];
                                tempX--;
                            }
                            //читаем вертикаль в обратном порядке
                            if(Arrays.equals(ch,tempArr))
                            {
                                x = i - (s.length() - 1);
                                y = j;
                                word = new Word(s);
                                word.setStartPoint(j, i);
                                word.setEndPoint(y, x);
                                list.add(word);
                            }
                        }

                    }
                }
            }
        }
        return list;
    }

    public static List<Word> detectAll(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        StringBuilder sb;
        Word word;
        int ver = crossword.length;//розмір строк
        int hor = crossword[0].length;//розмір стовпців

        outer:
        for (String s : words) {
            int lengthWay = s.length() - 1;
            //горизонтали
            for (int i = 0; i < ver; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < hor; j++) {
                    sb.append((char) crossword[i][j]);
                }
                //по горизонталі вперед
                String horLine=sb.toString();
                if (horLine.contains(s)) {
                    word = new Word(s);
                    word.setStartPoint(sb.indexOf(s), i);
                    word.setEndPoint(sb.indexOf(s) + lengthWay, i);
                    list.add(word);
                }
                //по горизонталі назад
                horLine=sb.reverse().toString();
                if (horLine.contains(s)) {
                    int tempY = (sb.length() - 1) - sb.indexOf(s);
                    word = new Word(s);
                    word.setStartPoint(tempY, i);
                    word.setEndPoint(tempY - lengthWay, i);
                    list.add(word);
                }

            }
            //вертикали
            for (int i = 0; i < hor; i++) {
                sb = new StringBuilder();
                //заповнюємо вертикаль
                for (int j = 0; j < ver; j++) {
                    sb.append((char) crossword[j][i]);
                }
                //зверху вниз
                String verLine= sb.toString();
                if (verLine.contains(s)) {
                    word = new Word(s);
                    word.setStartPoint(i, sb.indexOf(s));
                    word.setEndPoint(i, sb.indexOf(s) + lengthWay);
                    list.add(word);
                }
                //знизу вверх
                verLine=sb.reverse().toString();
                if (verLine.contains(s)) {
                    int tempX = (sb.length() - 1) - sb.indexOf(s);
                    word = new Word(s);
                    word.setStartPoint(i, tempX);
                    word.setEndPoint(i, tempX - lengthWay);
                    list.add(word);
                }
            }
            //диагонали
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    int x = i;
                    int y = j;

                    sb = new StringBuilder();
                    //зліва вниз
                    while (x < ver && y < hor) {
                        sb.append((char) crossword[x][y]);
                        x++;
                        y++;
                    }

                    String diagonal=sb.toString();
                    if (diagonal.contains(s)) {
                        word = new Word(s);
                        x=i+sb.indexOf(s);
                        y=j+sb.indexOf(s);
                        word.setStartPoint(y,x);
                        word.setEndPoint(y + lengthWay, x + lengthWay);
                        list.add(word);
                    }
                    //по диагонали справа вгору
                    diagonal=sb.reverse().toString();
                    if(diagonal.contains(s))
                    {
                        x=i+(sb.length()-1)-sb.indexOf(s);
                        y=j+(sb.length()-1)- sb.indexOf(s);
                        word = new Word(s);
                        word.setStartPoint(y, x);
                        word.setEndPoint(y-lengthWay, x-lengthWay);
                        list.add(word);
                    }
                }
            }
            //справа вниз
            for(int i=ver-1;i>=0;i--)
            {
                for(int j=0;j<hor;j++)
                {
                    int x=i;
                    int y=j;
                    sb=new StringBuilder();
                    while(x>=0&&y<hor)
                    {
                        sb.append((char) crossword[x][y]);
                        x--;
                        y++;
                    }
                    String diagonal=sb.toString();
                    if(diagonal.contains(s))
                    {
                        int tempY=j+sb.indexOf(s);
                        int tempX=i-sb.indexOf(s);
                        word=new Word(s);
                        word.setStartPoint(tempY,tempX);
                        word.setEndPoint((tempY+lengthWay),tempX-lengthWay);
                        list.add(word);
                    }
                    diagonal=sb.reverse().toString();
                    if(diagonal.contains(s))
                    {
                        int tempY;
                        int tempX;
                        tempY=j+(sb.length()-1)- sb.indexOf(s);
                        tempX=i-(sb.length()-1)+sb.indexOf(s);
                        word=new Word(s);
                        word.setStartPoint(tempY,tempX);
                        word.setEndPoint(tempY-lengthWay,tempX+lengthWay);
                        list.add(word);
                    }
                }
            }
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {

            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
