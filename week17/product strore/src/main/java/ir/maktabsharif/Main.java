package ir.maktabsharif;

import ir.maktabsharif.util.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();
        applicationContext.getMenu().show();

    }
}
