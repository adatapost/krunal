/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.model;

import in.abc.Db;

/**
 *
 * @author admin
 */
public class LoginDao {
    public static boolean createUser(Login login){
        try(Db x=new Db("insert into login values (?,?,?,?,?,?)")) {
            x.getSt().setString(1, login.getUserName());
            x.getSt().setString(2, login.getUserPass());
            x.getSt().setString(3, login.getUserEmail());
            x.getSt().setString(4, login.getUserRole());
            x.getSt().setString(5, login.getQuestion());
            x.getSt().setString(6, login.getAnswer());
            x.execute();
            return true;
            
        }catch(Exception ex){
            System.out.println("LoginDao#createUser : " + ex);
        }
        return false;
    }
     public static Login getLogin(Login login){
        try(Db x=new Db("select * from login where user_name=?")) {
            x.getSt().setString(1, login.getUserName());
            Object []ar = x.row();
            if(ar!=null){
                Login search=new Login();
                search.setUserName(ar[0].toString());
                search.setUserPass(ar[1].toString());
                search.setUserEmail(ar[2].toString());
                search.setUserRole(ar[3].toString());
                search.setQuestion(ar[4].toString());
                search.setAnswer(ar[5].toString());
                return search;
            }
        }catch(Exception ex){
            System.out.println("LoginDao#getLogin : " + ex);
        }
        return null;
    }
}
