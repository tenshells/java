package Decorator;

public class ChocolateCone implements IceCream{
    IceCream ic;

    ChocolateCone(){

    }
    ChocolateCone(IceCream c){
        this.ic=c;
    }

    @Override
    public int getCost() {
        if(ic==null)
            return 9;
        else
            return ic.getCost()+8;
    }

    @Override
    public String getDesc() {
        if(ic==null){
            return "Chocolate Cone";
        }
        else
            return ic.getDesc() + " w/ Chocolate Cone";
    }
    
}
