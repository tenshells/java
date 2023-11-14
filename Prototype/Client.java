package Prototype;

public class Client{
    public static void main(String[] args) {
        Student aditya = new Student();
        aditya.name="Aditya";
        aditya.id=7119;
        aditya.address.country = "India";
        aditya.address.district = "Thrissur";
        aditya.address.state = "Kerala";
        aditya.address.streetNo = 45;
        aditya.address.taluk = "Mundur";

        aditya.printStudent();

        Student abhishek = aditya.copy();

        abhishek.name="Abhishek";
        abhishek.id++;

        abhishek.printStudent();

        System.out.println("wassup");

    }
}