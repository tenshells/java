package Decorator;

public class Caramel implements IceCream{
    IceCream ic;

    Caramel(IceCream ic){
        this.ic=ic;
    }

    @Override
    public int getCost() {
        return ic.getCost()+3;
    }

    @Override
    public String getDesc() {
        return ic.getDesc()+" w/ Caramel";
    }
    
}
