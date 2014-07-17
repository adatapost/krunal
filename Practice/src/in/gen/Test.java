/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.gen;

/**
 *
 * @author admin
 */
public class Test {
     public static void main(String []args) {
         Pair<String,Double> item=new Pair<>("Pen", 10.10);
         System.out.println(item.getKey() + " " + item.getValue());
         
         
     }
    public static void main2(String []args) {
        Stack<String> s = new Stack<>(new String[3]);
        Stack<Double> t = new Stack<>(new Double[3]);
        s.push("Abc");
        t.push(10.10);
        System.out.println(s.pop() + " " + t.pop());
        
    }
   public static void main1(String []args) {
       IntStack s = new IntStack(new int[3]);
       s.push(10);
       s.push(20);
       s.push(30);
       s.push(40);
       
       System.out.println(s.pop());
       System.out.println(s.pop());
       System.out.println(s.pop());
       System.out.println(s.pop());
       
       
   }
}
