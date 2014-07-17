/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.coll;

/**
 *
 * @author admin
 */
public class Test {
   public static void main(String []args){
       MyColletion items = new MyColletion();
       for(Integer no : items) {
           System.out.println(no);
       }
   }
}
