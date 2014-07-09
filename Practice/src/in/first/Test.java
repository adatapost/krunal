/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.first;

/**
 *
 * @author admin
 */
public class Test {

    public static void main(String[] args) {
        Student s = new Student(10, "Manish", new Address("Meh", 22222), new Address("Pat", 2222));
        System.out.println(s);
        System.out.println(s.getLocalAddress().getCity() + " " + s.getLocalAddress().getPin());
    }

    public static void main4(String[] args) {
        Student s = new Student(10, "Manish");
        s.setLocalAddress(new Address("Mehsana", 100001));
        s.setPostalAddress(new Address("Surat", 383832));
        System.out.println(s);
        System.out.println(s.getLocalAddress().getCity() + " " + s.getLocalAddress().getPin());
    }

    public static void main3(String[] args) {
        Student s = new Student(10, "Manish");
        s.getLocalAddress().setCity("Mehsana");
        s.getLocalAddress().setPin(384001);
        s.getPostalAddress().setCity("Patan");;
        s.getPostalAddress().setPin(432211);
        System.out.println(s);
        System.out.println(s.getLocalAddress().getCity() + " " + s.getLocalAddress().getPin());

    }

    public static void main2(String[] args) {
        Student s = new Student();
        s.setRoll(10);
        s.setName("Raj");
        s.getLocalAddress().setCity("Mehsana");
        s.getLocalAddress().setPin(384001);
        s.getPostalAddress().setCity("Patan");;
        s.getPostalAddress().setPin(432211);

        System.out.println(s);
        System.out.println(s.getLocalAddress().getCity() + " " + s.getLocalAddress().getPin());

    }

    public static void main1(String[] args) {
        Address s = new Address("A", 10);
        s.setCity("Mehsana");
        System.out.println(s);
    }
}
