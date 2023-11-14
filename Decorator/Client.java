package Decorator;

import java.util.Scanner;

import p.p;

public class Client {
    public static void main(String[] args) {
        p.print("Do you want an ice cream ? : (Y/N*");
        try (Scanner s = new Scanner(System.in)) {
            char desire = s.next().charAt(0);

            if(choice(desire)){
                char creativity = 'y';
                boolean cone=true;
                boolean addon=false;
                boolean first=true;
                IceCream ic = null;
                while(choice(creativity)){
                    
                    if(cone){
                        p.printl("Choose your cone : ");
                        p.print("1) OrangeCone 2) ChocolateCone -> ");
                        int coneChoice = s.nextInt();
                        while(!(coneChoice>=1 && coneChoice<=2)){
                            p.printl("Pls enter valid choice!!");
                            coneChoice=s.nextInt();
                        }

                        cone=false;
                        if(first){
                            ic = IceCreamFactory.newIceCream(coneChoice);
                            first=false;
                        }
                        else{
                            ic = IceCreamFactory.newIceCream(coneChoice, ic);
                        }
                    }
                    if(addon){
                        p.printl("Choose your addOne : ");
                        p.print("3) ChocoChips 4) Marshmallow 5) Caramel -> ");
                        int addOnChoice = s.nextInt();
                        while(!(addOnChoice>=3 && addOnChoice<=5)){
                            p.printl("Pls enter valid choice!!");
                            addOnChoice=s.nextInt();
                        }

                        ic=IceCreamFactory.newIceCream(addOnChoice,ic);
                        addon=false;
                    }
                    p.printl("What do you want to do ? ");
                    p.printl("1) Add another cone  2) Add an addon 3* Thanks, im done");
                    int choice = s.nextInt();

                    if(choice==1)
                        cone=true;
                    else if(choice==2) 
                        addon=true;
                    else
                        creativity='n'; 

                }

                p.printl("Description of ice cream : "+ic.getDesc());
                p.printl("Cost of ice cream : "+ic.getCost());
            }   


        }
        

    }

    public static boolean choice(char d){

        if(!(d=='Y' || d=='y'))
            p.printl("Any character other than y taken as No..");

        return d=='Y' || d=='y';
    }
}
