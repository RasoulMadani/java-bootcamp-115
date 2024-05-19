package q01.baseClasses;

import q01.commonClasses.EnumRank;

import java.util.Arrays;

public class Barrack {
    Soldier[] soldiers = new Soldier[15];
    int indexSoldiers = 0;
    int countOfCorporals;
    int countOfCorporalsNew;
    public void addSoldiers(Soldier soldier) {
        soldiers[indexSoldiers++] = soldier;
    }

    public void runShootingTest() {
        countOfCorporals=0;
        for (Soldier soldier : soldiers) {
            if (soldier != null) {
                soldier.shooting();
                if (soldier.getEnumRank() == EnumRank.Corporal){
                    countOfCorporals++;
                }
                System.out.println(soldier);
            }

        }
        countOfCorporalsNew = countOfCorporals;
    }
    public double percentageOfCorporate(){
        return ((double) countOfCorporalsNew / (indexSoldiers)) * 100;

    }
    @Override
    public String toString() {
        return "Barrack{" +
                "soldiers=" + Arrays.toString(soldiers) +
                ", indexSoldiers=" + indexSoldiers +
                '}';
    }
}
