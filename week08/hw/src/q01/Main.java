package q01;

import q01.baseClasses.Barrack;
import q01.baseClasses.Soldier;
import q01.commonClasses.EnumRank;

public class Main {
    public static void main(String[] args) {
        Barrack barrack = new Barrack();
        System.out.println(barrack.percentageOfCorporate());


        Soldier soldier1 = new Soldier(EnumRank.Sergeant);
        Soldier soldier2 = new Soldier(EnumRank.Corporal);
        Soldier soldier3 = new Soldier(EnumRank.Corporal);
        Soldier soldier4 = new Soldier(EnumRank.Corporal);
        barrack.addSoldiers(soldier1);
        barrack.addSoldiers(soldier2);
        barrack.addSoldiers(soldier3);
        barrack.addSoldiers(soldier4);
        int inex1 = 1;
        while (true) {

            barrack.runShootingTest();

            System.out.println("Shooting test :" + inex1 + " result: " + barrack.percentageOfCorporate() + " % of soldiers are Corporals");
            if (barrack.percentageOfCorporate() < 60) {
                break;
            }
            inex1++;
        }


    }
}
