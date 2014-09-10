/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class Emp {
   private Integer empNo;
   private String empName;
   private java.sql.Date joinDate;

    public Emp() {
    }

    public Emp(Integer empNo, String empName, Date joinDate) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
    }

    public Emp(Integer empNo) {
        this.empNo = empNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Emp{" + "empNo=" + empNo + ", empName=" + empName + ", joinDate=" + joinDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.empNo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emp other = (Emp) obj;
        if (!Objects.equals(this.empNo, other.empNo)) {
            return false;
        }
        return true;
    }
   
}
