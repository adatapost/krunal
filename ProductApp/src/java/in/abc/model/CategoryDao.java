/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.model;

import in.abc.Db;
import in.abc.U;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryDao {

    public static boolean add(Category cat) {
        try (Db x = new Db("insert into category values (?,?)")) {
            x.getSt().setInt(1, cat.getCategoryId());
            x.getSt().setString(2, cat.getCategoryName());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("CategoryDao.add :" + ex);
        }
        return false;
    }

    public static boolean update(Category cat) {
        try (Db x = new Db("update category set category_name=? where category_id=?")) {
            x.getSt().setString(1, cat.getCategoryName());
            x.getSt().setInt(2, cat.getCategoryId());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("CategoryDao.update :" + ex);
        }
        return false;
    }

    public static boolean delete(Category cat) {
        try (Db x = new Db("delete from category where category_id=?")) {
            x.getSt().setInt(1, cat.getCategoryId());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("CategoryDao.delete :" + ex);
        }
        return false;
    }

    public static Category get(Category cat) {
        try (Db x = new Db("select * from category where category_id=?")) {
            x.getSt().setInt(1, cat.getCategoryId());
            Object[] ar = x.row();
            if (ar != null) {
                Category c = new Category();
                c.setCategoryId(U.toInt(ar[0]));
                c.setCategoryName(ar[1].toString());
                return c;
            }
        } catch (Exception ex) {
            System.err.println("CategoryDao.get :" + ex);
        }
        return null;
    }

    public static List<Category> gets() {
        List<Category> list = new ArrayList<>();
        try (Db x = new Db("select * from category")) {
            for (Object[] ar : x.rows()) {
                Category c = new Category();
                c.setCategoryId(U.toInt(ar[0]));
                c.setCategoryName(ar[1].toString());
                list.add(c);
            }
        } catch (Exception ex) {
            System.err.println("CategoryDao.gets :" + ex);
        }
        return list;
    }
}
