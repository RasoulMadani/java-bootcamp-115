package q01.baseClasses;

import q01.commonClassess.CheckIsDigit;

public class PhysicalNewspaperSubscription extends NewsPaperSubscription {
    public PhysicalNewspaperSubscription(String name) {
        this.name = name;
    }

    @Override
    public String setAddress(String address) {
        if(!CheckIsDigit.checkForDigit(address)){
            this.rate = 0;
            System.out.println("address must contain one digit !!");
        }else {
            this.address =address;
            this.rate = 15;
        };
        return null;
    }

    @Override
    public String toString() {
        return "PhysicalNewspaperSubscription{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rate=" + rate +
                '}';
    }
}
