package solution;

import java.awt.*;
import java.io.*;
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