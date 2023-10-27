package multithreading;

class HelloWorld{
    public static void main(String[] args) {
        HelloPrinter hp = new HelloPrinter("The time is up, the time is now, the time is 6 o clock ");
        hp.run();

        Thread t = new Thread(hp);
        t.start();
    }
}

class HelloPrinter implements Runnable{
    String s;

    HelloPrinter(){
        s="Hello World";
    }
    HelloPrinter(String s){
        this.s=s;
    }

    @Override
    public void run(){
        System.out.println(s+" from "+Thread.currentThread().getName());
    }
}

