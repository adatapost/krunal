/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.first;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Student {
   private Integer roll;
   private String name;
   private Address localAddress;
   private Address postalAddress;

    public Student() {
        roll =0;
        name = "";
        localAddress = new Address();
        postalAddress = new Address();
    }

    public Student(Integer roll, String name) {
        this.roll = roll;
        this.name = name;
        localAddress = new Address();
        postalAddress = new Address();
    }

    public Student(Integer roll, String name, Address localAddress, Address postalAddress) {
        this.roll = roll;
        this.name = name;
        this.localAddress = localAddress;
        this.postalAddress = postalAddress;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(Address localAddress) {
        this.localAddress = localAddress;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public String toString() {
        return "Student{" + "roll=" + roll + ", name=" + name + ", localAddress=" + localAddress + ", postalAddress=" + postalAddress + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.roll);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.localAddress);
        hash = 41 * hash + Objects.hashCode(this.postalAddress);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.roll, other.roll)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
   
   
}
