/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc;

/**
 *
 * @author Dhavan
 */
public class U {
    public static int toint(Object ob)
    {
        try
        {
            return Integer.parseInt(ob.toString());
        }
        catch(Exception e)
        {
            return 0;
        }
  }
}
    
