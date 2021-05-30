package solution;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        USB memoryCard=new CardReader(new MemoryCard());
        memoryCard.connectWithUsbCable();
    }
}