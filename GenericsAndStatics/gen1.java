package GenericsAndStatics;

public class gen1 {
    class bruh<T, V> {

        T tom;
        V vas;

        bruh(T t, V v) {
            this.tom = t;
            this.vas = v;
        }

        void print() {
            System.out.println("I am basically a " + tom + " and a " + vas);
        }
    }

    public static void main(String[] args) {
        gen1 gen = new gen1();
        gen1.bruh<String, Double> hey = gen.new bruh<>("Shelton", 10.1);

        hey.print();
    }
}
