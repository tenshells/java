package Prototype;

import p.p;

public class Address implements Prototype<Address> {
    int streetNo;
    String taluk;
    String district;
    String state;
    String country;

    public Address copy(){
        Address a = new Address();
        a.streetNo=this.streetNo;
        a.taluk=this.taluk;
        a.state=this.state;
        a.district=this.district;
        a.country=this.country;
        return a;

    }

    public void printAddress(){
        p.printl("Address:  "+streetNo+", "+taluk+", "+district+", "+state+", "+country);
    }


}
