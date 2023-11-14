package Decorator;

public class ChocoChips implements IceCream{
    IceCream ic;

    ChocoChips(IceCream ic){
        this.ic=ic;
    }

    @Override
    public int getCost() {
        return ic.getCost()+5;
    }

    @Override
    public String getDesc() {
        return ic.getDesc()+" w/ Choco Chips";
    }
}
