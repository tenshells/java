package Decorator;

public class IceCreamFactory {
    public static IceCream newIceCream(int type){
        if(type==1)
            return new OrangeCone();
        else if(type==2)
            return new ChocolateCone();
        return null;
    }

    public static IceCream newIceCream(int type, IceCream baseCream){
        if(type==1)
            return new OrangeCone(baseCream);
        else if(type==2)
            return new ChocolateCone(baseCream);
        else if(type==3)
            return new ChocoChips(baseCream);
        else if(type==4)
            return new Marshmallow(baseCream);
        else if(type==5)
            return new Caramel(baseCream);
        return null;
    }
}
