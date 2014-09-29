/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.model;

/**
 *
 * @author admin
 */
public class Emp {
  private int empNo;
  private String empName;
  private String photo;

    public Emp() {
    }

    public Emp(int empNo, String empName, String photo) {
        this.empNo = empNo;
        this.empName = empName;
        this.photo = photo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
  
}
