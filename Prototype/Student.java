package Prototype;

import p.p;

public class Student implements Prototype<Student>{
    
    public String name;
    public int id;
    private float psp;
    public Address address;

    public Student(){
        this.psp=50;
        this.address = new Address();
    }

    public Student copy(){
        Student s = new Student();
        s.name=this.name;
        s.id = this.id;
        s.psp = this.psp;
        s.address = this.address.copy();

        return s;
    }

    public void printStudent(){
        p.printl("name : "+name);
        p.printl("id : "+id);
        p.printl("psp : "+psp);
        
        address.printAddress();
        
    }

}
