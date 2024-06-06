package q01.baseClasses;

import q01.commonClasses.EnumRank;
import q01.commonClasses.IdGenerator;
import q01.commonClasses.RandomIntGenerator;

public class Soldier {
    private int id;
    private int countBullet = 4;
    private int[] scores = new int[4];

    private EnumRank enumRank;
    private EnumRank initialRank;
    private int sumScore = 0;
    private int sumScoreNew = 0;
    public Soldier(EnumRank enumRank) {
        this.id = IdGenerator.generator();
        this.enumRank = enumRank;
        this.initialRank = enumRank;
    }

    public   void shooting(){
        for (int i = 0; i < countBullet; i++) {
            scores[i] =  RandomIntGenerator.generator();
            sumScore += scores[i];
        }
        changeRank();
        sumScoreNew = sumScore;
        sumScore = 0;
    }
    public void changeRank(){
        if (sumScore >= 28){
            if (enumRank == EnumRank.Corporal){
                enumRank = EnumRank.Sergeant;
            }else if(enumRank == EnumRank.Sergeant){
                enumRank = EnumRank.Lieutenant;
            }
        }else{
            if (enumRank == EnumRank.Lieutenant){
                enumRank = EnumRank.Sergeant;
            }else if(enumRank == EnumRank.Sergeant){
                enumRank = EnumRank.Corporal;
            }
        }
    }

    public EnumRank getEnumRank() {
        return enumRank;
    }

    @Override
    public String toString() {
        return
                "Soldier ID : " + id + "\n"+
                "Bullet 1 :" + scores[0] + "\n"+
                "Bullet 2 :" + scores[1] + "\n"+
                "Bullet 3 :" + scores[2] + "\n"+
                "Bullet 4 :" + scores[3] + "\n"+
                "Final Score :" + sumScoreNew + "\n"+
                "Initial Rank :" + initialRank + "\n"+
                "Final Rank :" + enumRank + "\n"+
                "*********************";

    }
}
