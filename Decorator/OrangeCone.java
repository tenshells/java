package Decorator;

public class OrangeCone implements IceCream{
    IceCream ic;

    OrangeCone(){

    }

    OrangeCone(IceCream ic){
        this.ic=ic;
    }

    @Override
    public int getCost() {
        if(ic==null)
            return 10;
        else
            return 8+ic.getCost();
    }

    @Override
    public String getDesc() {
        if(ic==null)
            return "Orange Cone";
        else{
            return ic.getDesc()+" w/ Orange Cone";
        }
    }
}
