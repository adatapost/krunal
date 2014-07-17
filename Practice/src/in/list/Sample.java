/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Sample {
    public static void main(String []args){
        CartSet products = new CartSet();
        products.add(new Product("Pen",10.00,10.00));
        products.add(new Product("Pencil",4.00,10.00));
         products.add(new Product("Pen",10.00,10.00));
          products.add(new Product("Pen",10.00,10.00));
        products.add("Book", 100.10, 2.4);
        
        for(Product p : products){
            System.out.println(p);
        }
     }
     public static void main3(String []args){
        Cart products = new Cart();
        products.add(new Product("Pen",10.00,10.00));
        products.add(new Product("Pencil",4.00,10.00));
         products.add(new Product("Pen",10.00,10.00));
          products.add(new Product("Pen",10.00,10.00));
        products.add("Book", 100.10, 2.4);
        
        for(Product p : products){
            System.out.println(p);
        }
     }
    public static void main2(String []args){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Pen",10.00,10.00));
        products.add(new Product("Pencil",4.00,10.00));
         products.add(new Product("Pen",10.00,10.00));
          products.add(new Product("Pen",10.00,10.00));
        
        for(Product p : products){
            System.out.println(p);
        }
     }
   public static void main1(String []args){
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Mehsana");
        cities.add("Surat");
        cities.add(1, "Jamnagar");
        for(String s: cities){
            System.out.println(s);
        }
        
        cities.remove("Mehsana"); //Remove using equals & hashCode
        cities.set(0, cities.get(0) + " West");
        for(String s: cities){
            System.out.println(s);
        }
   }
}
