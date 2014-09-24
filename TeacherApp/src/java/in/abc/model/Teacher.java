/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.abc.model;

import java.util.Objects;

/**
 *
 * @author Dhavan
 */
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer teacherSalary;

    public Teacher() {
        teacherId=0;
        teacherName="";
        teacherSalary=0;
    }

    public Teacher(Integer teacherId) {
        this.teacherId = teacherId;
    }
    

    public Teacher(Integer teacherId, String teacherName, Integer teacherSalary) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSalary = teacherSalary;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(Integer teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.teacherId);
        hash = 53 * hash + Objects.hashCode(this.teacherSalary);
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
        final Teacher other = (Teacher) obj;
        if (!Objects.equals(this.teacherId, other.teacherId)) {
            return false;
        }
        if (!Objects.equals(this.teacherName, other.teacherName)) {
            return false;
        }
        if (!Objects.equals(this.teacherSalary, other.teacherSalary)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSalary=" + teacherSalary + '}';
    }
    
    
    
}
