package solution;


import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static class Product {
        private int id;
        private String productName;
        private String price;
        private String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            return;
        ArrayList<Product> listID = new ArrayList<>();
        String fileName="c:\\file.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready())
        {
            Product product=getProduct(reader.readLine());
            listID.add(product);
        }
        reader.close();
        int id=Integer.MIN_VALUE;
        for(Product pr:listID)
        {
            if(id<pr.id)
                id=pr.id;
        }
        String productName="";
        String price=args[args.length-2];
        String quantity=args[args.length-1];
        for(int i=1;i< args.length-2;i++)
        {
            productName+=args[i]+" ";
        }
        if(productName.length()>30)
            productName=productName.substring(0,30);
        if(price.length()>8)
            price=price.substring(0,8);
        if(quantity.length()>4)
            quantity=quantity.substring(0,4);

        //Product product=new Product(++id,productName,price,quantity);
        listID.add(new Product(++id,productName,price,quantity));

        BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
        for(Product pr:listID) {
            writer.write(pr.toString());
            writer.newLine();
        }
        writer.close();


    }
    public static Product getProduct(String string)
    {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);

    }
}
