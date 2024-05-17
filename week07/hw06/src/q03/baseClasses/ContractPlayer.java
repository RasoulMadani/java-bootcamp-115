package q03.baseClasses;

import java.util.Arrays;

public class ContractPlayer {

    private int baseSalary;
    private PlaySalary[] playSalaries = new PlaySalary[10];
    private int indexPlaySalary = 0;


    public ContractPlayer(int baseSalary) {
        this.baseSalary = baseSalary;

    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public ContractPlayer setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public PlaySalary[] getPlaySalaries() {
        return playSalaries;
    }

    public void addPlaySalaries(PlaySalary playSalary) {
        playSalaries[indexPlaySalary] = playSalary;
        indexPlaySalary++;
    }

    @Override
    public String toString() {
        return "Contract{" +  "\n" +
                "baseSalary=" + baseSalary + "\n" +
                ", playSalaries=" + Arrays.toString(playSalaries) + "\n" +
                ", indexPlaySalary=" + indexPlaySalary + "\n" +
                '}';
    }
}

