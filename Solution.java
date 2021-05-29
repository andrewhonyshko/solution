package solution;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static class Product
    {
        int id;
        String productName;
        String price;
        String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s",id,productName,price,quantity);
        }
    }


    public static void main(String[] args) throws IOException {
        if(args.length==0)
            return;

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Product> productsList=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));
        while(bufferedReader.ready())
        {
            Product product=getProduct(bufferedReader.readLine());
            productsList.add(product);
        }
        bufferedReader.close();
        switch (args[0])
        {
            case "-u":
            {
                int index=0;
                int id=Integer.parseInt(args[1]);
                for(int i=0;i<productsList.size();i++)
                {
                    if(productsList.get(i).id==id)
                        index=i;
                }
                productsList.set(index,updateProduct(args));
                BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
                for(Product pr:productsList)
                {
                    writer.write(pr.toString());
                    writer.newLine();
                }
                writer.close();
                break;
            }
            case "-d":
            {
                int index=0;
                int id=Integer.parseInt(args[1]);
                for(int i=0;i<productsList.size();i++)
                {
                    if(productsList.get(i).id==id)
                        index=i;
                }
                productsList.remove(index);
                BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
                for(Product pr:productsList)
                {
                    writer.write(pr.toString());
                    writer.newLine();
                }
                writer.close();
                break;
            }
        }
    }
    public static Product getProduct(String str)
    {
        String id =str.substring(0,8).trim();
        String name=str.substring(8,38).trim();
        String price=str.substring(38,46).trim();
        String quantity=str.substring(46).trim();
        return new Product(Integer.parseInt(id),name,price,quantity);
    }
    public static Product updateProduct(String args[])
    {
        int id=Integer.parseInt(args[1]);
        String productName="";
        String price=args[args.length-2];
        String quantity=args[args.length-1];
        for(int j=2;j< args.length-2;j++)
        {
            productName+=args[j]+" ";
        }
        if(productName.length()>30)
            productName=productName.substring(0,30);
        if(price.length()>8)
            price=price.substring(0,8);
        if(quantity.length()>4)
            quantity=quantity.substring(0,4);

        return new Product(id,productName,price,quantity);

    }
}