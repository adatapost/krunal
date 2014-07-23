/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.adc.model;

import in.adc.IDao;
import java.util.List;
import in.adc.Db;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class DeptDao implements IDao<Dept> {

    @Override
    public boolean add(Dept obj) {
        try(Db x = new Db("insert into dept values (?,?,?)")){
            x.getSt().setInt(1, obj.getDeptNo());
            x.getSt().setString(2, obj.getDeptName());
            x.getSt().setString(3,obj.getDeptLocation());
            x.execute();
            return true;
        }catch(Exception ex){
            System.out.println("DeptDao#add : " + ex);
        }
        return false;
    }

    @Override
    public boolean delete(Dept obj) {
         try(Db x = new Db("delete from dept  where deptno=?")){
            x.getSt().setInt(1, obj.getDeptNo());
            x.execute();
            return true;
        }catch(Exception ex){
            System.out.println("DeptDao#delete : " + ex);
        }
        return false;
    }

    @Override
    public boolean update(Dept obj) {
       try(Db x = new Db("update dept set deptname=?,deptlocation=? where deptno=?")){
            
            x.getSt().setString(1, obj.getDeptName());
            x.getSt().setString(2,obj.getDeptLocation());
            x.getSt().setInt(3, obj.getDeptNo());
            x.execute();
            return true;
        }catch(Exception ex){
            System.out.println("DeptDao#update : " + ex);
        }
        return false;
    }

    @Override
    public Dept get(Dept obj) {
         try(Db x = new Db("select * from dept where deptno=?")){
            x.getSt().setInt(1, obj.getDeptNo());
            Object []ar = x.row();
            if(ar!=null){
            Dept dept=new Dept();
            dept.setDeptNo(Integer.parseInt(ar[0].toString()));
            dept.setDeptName(ar[1].toString());
            dept.setDeptLocation(ar[2].toString());
            return dept;
            }
        }catch(Exception ex){
            System.out.println("DeptDao#get : " + ex);
        }
        return null;
    }

    @Override
    public List<Dept> gets() {
        List<Dept> list=new ArrayList<>();
        try(Db x = new Db("select * from dept")){
           for(Object []ar : x.rows()){
            Dept dept=new Dept();
            dept.setDeptNo(Integer.parseInt(ar[0].toString()));
            dept.setDeptName(ar[1].toString());
            dept.setDeptLocation(ar[2].toString());
            list.add(dept);
            }
        }catch(Exception ex){
            System.out.println("DeptDao#gets : " + ex);
        }
        return list;
    }

}
