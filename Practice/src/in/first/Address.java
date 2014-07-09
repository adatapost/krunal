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
public class Address {
    private String city;
    private Integer pin;

    public Address() {
        city="";
        pin=0;
    }

    public Address(String city, Integer pin) {
        this.city = city;
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", pin=" + pin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.city);
        hash = 53 * hash + Objects.hashCode(this.pin);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.pin, other.pin)) {
            return false;
        }
        return true;
    }
        
}
