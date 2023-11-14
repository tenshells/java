package Decorator;

public class Marshmallow implements IceCream{
    IceCream ic;

    Marshmallow(IceCream ic){
        this.ic=ic;
    }

    @Override
    public int getCost() {
        return ic.getCost()+2;
    }

    @Override
    public String getDesc() {
        return ic.getDesc()+" w/ Marshmallow";
    }
    
}
