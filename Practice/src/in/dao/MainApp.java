/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.dao;

import java.util.List;

 

/**
 *
 * @author admin
 */
public class MainApp {
     public static void main(String []args){
       try(Db x=new Db("select * from dept")){
           List<Object[]> list = x.rows();
           for(Object []ar: list){
               System.out.println(ar[0] + " " + ar[1] + " " + ar[2]);
           }
       } catch (Exception ex) {
           System.out.println(ex);
       }
   }
    public static void main4(String []args){
       try(Db x=new Db("select max(deptno) from dept")){
          System.out.println(x.row()[0]);
       } catch (Exception ex) {
           System.out.println(ex);
       }
   }
    public static void main3(String []args){
       try(Db x = new Db("select * from dept where deptno=?")){
           x.getSt().setInt(1, 90);
           Object []a=x.row();
           if(a!=null){
               System.out.println(a[0] + " " + a[1] + " " + a[2]);
           }else{
               System.out.println("Not found");
           }
           
       } catch (Exception ex) {
           System.out.println(ex);
       }
   }
     public static void main2(String []args){
       try(Db x = new Db("insert into dept values (?,?,?)")){
           x.getSt().setInt(1, 90);
           x.getSt().setString(2, "A");
           x.getSt().setString(3,"A");
           x.execute();
       } catch (Exception ex) {
           System.out.println(ex);
       }
   }
   public static void main1(String []args){
       try {
           Db x = new Db("insert into dept values (?,?,?)");
           x.getSt().setInt(1, 90);
           x.getSt().setString(2, "A");
           x.getSt().setString(3,"A");
           x.execute();
           x.dispose();
           
       } catch (Exception ex) {
           System.out.println(ex);
       }
   }
}
