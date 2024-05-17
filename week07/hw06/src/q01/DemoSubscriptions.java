package q01;

import q01.baseClasses.OnlineNewspaperSubscription;
import q01.baseClasses.PhysicalNewspaperSubscription;

public class DemoSubscriptions {
    public static void main(String[] args) {
        PhysicalNewspaperSubscription physicalNewspaperSubscription = new PhysicalNewspaperSubscription("rasoul");
        OnlineNewspaperSubscription onlineNewspaperSubscription = new OnlineNewspaperSubscription("hamid");
        physicalNewspaperSubscription.setAddress("tehran ");
        onlineNewspaperSubscription.setAddress("iran pelake 4 ");
        System.out.println(onlineNewspaperSubscription);
        System.out.println(physicalNewspaperSubscription);
    }


}
