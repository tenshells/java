package GenericsAndStatics;

public class genMeth {
    public static void main(String[] args) {
        System.out.println("The key of a (Shelly, Shimmy) is a "+doSomething("Shelly","Shimmy"));

        System.out.println("----------------------------------------------------------------------------");

        System.out.print("The key of a (Blastoise, 3.14159) is a ");
        System.out.print(doSomething("Blastoise", Math.PI));
    }

    static <K,V> K doSomething(K key, V value){
        System.out.print("Im going to print a key");
        return key;
    }
}
