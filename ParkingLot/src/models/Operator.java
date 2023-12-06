package ParkingLot.src.models;

public class Operator extends BaseModel{
    private String operatorName;
    private int empId;
    
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    public int getEmpId() {
        return empId;
    }
    public String getOperatorName() {
        return operatorName;
    }
}
