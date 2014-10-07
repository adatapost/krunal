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
public class ProductDao {

    public static boolean add(Product prd) {
        try (Db x = new Db("insert into product values (?,?,?,?,?)")) {
            x.getSt().setInt(1, prd.getProductId());
            x.getSt().setInt(2, prd.getCategoryId());
            x.getSt().setString(3, prd.getProductName());
            x.getSt().setString(4, prd.getUnit());
            x.getSt().setBoolean(5, prd.isAvailable());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("ProductDao.add :" + ex);
        }
        return false;
    }

    public static boolean update(Product prd) {
        try (Db x = new Db("update product set category_id=?,product_name=?,unit=?, is_available=? where product_id=?")) {

            x.getSt().setInt(1, prd.getCategoryId());
            x.getSt().setString(2, prd.getProductName());
            x.getSt().setString(3, prd.getUnit());
            x.getSt().setBoolean(4, prd.isAvailable());
            x.getSt().setInt(5, prd.getProductId());
            x.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("ProductDao.udate :" + ex);
        }
        return false;
    }

    public static boolean delete(Product prd) {
        try (Db x = new Db("delete from product  where product_id=?")) {

            x.getSt().setInt(1, prd.getProductId());

            x.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("ProductDao.delete :" + ex);
        }
        return false;
    }

    public static Product getProduct(Product prd) {
        try (Db x = new Db("select * from product where product_id=?")) {
            x.getSt().setInt(1, prd.getProductId());
            Object[] ar = x.row();
            if (ar != null) {
                Product c = new Product();
                c.setProductId(U.toInt(ar[0]));
                c.setCategoryId(U.toInt(ar[1]));
                c.setProductName(ar[2].toString());
                c.setUnit(ar[3].toString());
                int avail = U.toInt(ar[4]);
                if(avail==1)
                  c.setAvailable(true);
                return c;
            }
        } catch (Exception ex) {
            System.err.println("ProductDao.getProduct :" + ex);
        }
        return null;
    }

    public static List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        try (Db x = new Db("select * from product")) {
            for (Object[] ar : x.rows()) {
                Product c = new Product();
                c.setProductId(U.toInt(ar[0]));
                c.setCategoryId(U.toInt(ar[1]));
                c.setProductName(ar[2].toString());
                c.setUnit(ar[3].toString());
               int avail = U.toInt(ar[4]);
                if(avail==1)
                  c.setAvailable(true);
                list.add(c);
            }
        } catch (Exception ex) {
            System.err.println("ProductDao.getProducts :" + ex);
        }
        return list;
    }

    public static List<Product> getProductsByCategory(int category_id) {
        List<Product> list = new ArrayList<>();
        try (Db x = new Db("select * from product where category_id=?")) {
            x.getSt().setInt(1, category_id);
            for (Object[] ar : x.rows()) {
                Product c = new Product();
                c.setProductId(U.toInt(ar[0]));
                c.setCategoryId(U.toInt(ar[1]));
                c.setProductName(ar[2].toString());
                c.setUnit(ar[3].toString());
                c.setAvailable(U.toBool(ar[4]));
                list.add(c);
            }
        } catch (Exception ex) {
            System.err.println("ProductDao.getProductsByCategory :" + ex);
        }
        return list;
    }
}
