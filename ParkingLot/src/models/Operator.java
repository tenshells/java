package ParkingLot.src.models;

public class Operator {
    private int id;
    private int empId;
    private String name;

    public int getEmpId() {
        return empId;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
