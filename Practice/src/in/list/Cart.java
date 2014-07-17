/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.list;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Cart extends ArrayList<Product> {
   public void add(String name,Double rate, Double qty){
       this.add(new Product(name, rate, qty));
   }
}
