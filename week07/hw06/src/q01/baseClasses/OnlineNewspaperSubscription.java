package q01.baseClasses;

import q01.commonClassess.CheckIsDigit;

public class OnlineNewspaperSubscription extends NewsPaperSubscription {
    public OnlineNewspaperSubscription(String name) {
        this.name= name;
    }

    @Override
    public String setAddress(String address) {
        if(!CheckIsDigit.checkForAtSign(address)){
            this.rate = 0;
            System.out.println("address must contain one \"@\" !!");
        }else {
            this.address = address;
            this.rate = 9;
        };
        return null;
    }

    @Override
    public String toString() {
        return "OnlineNewspaperSubscription{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rate=" + rate +
                '}';
    }
}
