/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.coll;

import java.util.Iterator;

/**
 *
 * @author admin
 */
public class MyColletion  implements Iterable<Integer> {

    private Integer []nos = {10,20,30,40};
    private int index = 0;
    
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
               if(index>=nos.length) return false;
               return true;
            }
            @Override
            public Integer next() {
                return nos[index++];
            }
        };
    }
}
