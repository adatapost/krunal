/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.adc;

import java.util.List;

/**
 *
 * @author admin
 */
public interface IDao<T> {
    boolean add(T obj);
    boolean delete(T obj);
    boolean update(T obj);
    T get(T obj);
    List<T> gets();
}
