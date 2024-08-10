class A{
    static {
        System.out.println("0 parent static");
    }

    {
        System.out.println(" 1  parent instance initializer block is invoked");
    }
    A(){
        System.out.println("2 parent class constructor invoked");
    }
}

class B3 extends A{
    B3(){

        System.out.println(" 4 child class constructor invoked");
    }
    static {
        System.out.println("0.1 child static");
    }

    {
        System.out.println(" 3 instance initializer block is invoked");
    }

    public static void main(String args[]){
        B3 b1= new B3();

    }
}