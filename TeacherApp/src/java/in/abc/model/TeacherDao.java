

package in.abc.model;

import in.abc.Db;
import in.abc.U;
import java.util.ArrayList;

import java.util.List;

public class TeacherDao {
     
   

    public static boolean add(Teacher teach) {
        try (Db x = new Db("insert into teacher values (?,?,?)")) {
            x.getSt().setInt(1, teach.getTeacherId());
            x.getSt().setString(2, teach.getTeacherName());
            x.getSt().setInt(3, teach.getTeacherSalary());
            
            x.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("TeacherDao.add :" + ex);
        }
        return false;
    }
    public static boolean update(Teacher teach)
    {
        try(Db x=new Db("update teacher set teacherName=?,teacherSalary=? where TeacherId=?"))
        {
            x.getSt().setString(1,teach.getTeacherName());
            x.getSt().setInt(2, teach.getTeacherSalary());
            x.getSt().setInt(3, teach.getTeacherId());
            x.execute();
            return true;
        }
        catch(Exception e)
        {
            System.out.println("teacherDao.update" + e);
        }
        return false;
    }
     public static boolean delete(Teacher teach)
    {
        try(Db x=new Db("delete from teacher where TeacherId=?"))
        {
           x.getSt().setInt(1, teach.getTeacherId());
            x.execute();
            return true;
        }
        catch(Exception e)
        {
            System.out.println("teacherDao.delete" + e);
        }
        return false;
    }
     public static Teacher get(Teacher teach)
     {
         try(Db x=new Db("select * from teacher where teacherId=?"))
         {
             x.getSt().setInt(1, teach.getTeacherId());
             Object []ar=x.row();
             if(ar!=null)
             {
                 Teacher t=new Teacher();
                 t.setTeacherId(U.toint(ar[0]));
                 t.setTeacherName(ar[1].toString());
                 t.setTeacherSalary(U.toint(ar[2]));
                 return t;
             }
         }
         catch(Exception e)
         {
             System.out.println("teacherDao.get" + e);
         }
         return null;
     }
    

    public static List<Teacher> gets() {
        List<Teacher> list = new ArrayList<>();
        try (Db x = new Db("select * from teacher")) {
            for (Object[] ar : x.rows()) {
               Teacher t=new Teacher();
          t.setTeacherId(U.toint(ar[0]));
          t.setTeacherName(ar[1].toString());
          t.setTeacherSalary(U.toint(ar[2]));
                list.add(t);
            }
        } catch (Exception ex) {
            System.err.println("TeacherDao.gets :" + ex);
        }
        return list;
    }


}
