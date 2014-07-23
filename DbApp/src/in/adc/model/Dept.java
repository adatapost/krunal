/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.adc.model;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String deptLocation;

    public Dept() {
    }

    public Dept(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public Dept(Integer deptNo, String deptName, String deptLocation) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptLocation = deptLocation;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLocation() {
        return deptLocation;
    }

    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.deptNo);
        hash = 53 * hash + Objects.hashCode(this.deptName);
        hash = 53 * hash + Objects.hashCode(this.deptLocation);
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
        final Dept other = (Dept) obj;
        if (!Objects.equals(this.deptNo, other.deptNo)) {
            return false;
        }
        if (!Objects.equals(this.deptName, other.deptName)) {
            return false;
        }
        if (!Objects.equals(this.deptLocation, other.deptLocation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dept{" + "deptNo=" + deptNo + ", deptName=" + deptName + ", deptLocation=" + deptLocation + '}';
    }
    
    
}
