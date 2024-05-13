package q03.baseClasses;

import java.util.Arrays;

public class Contract {

    private int baseSalary;
    private int perDay;
    private PlaySalary[] playSalaries;
    private int indexPlaySalary = 0;

    public Contract(int baseSalary) {
        this.baseSalary = baseSalary;
        playSalaries = new PlaySalary[10];
    }

    public Contract(int baseSalary, int perDay) {
        this.baseSalary = baseSalary;
        this.perDay = perDay;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public Contract setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public int getPerDay() {
        return perDay;
    }

    public Contract setPerDay(int perDay) {
        this.perDay = perDay;
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
                ", perDay=" + perDay + "\n" +
                ", playSalaries=" + Arrays.toString(playSalaries) + "\n" +
                ", indexPlaySalary=" + indexPlaySalary + "\n" +
                '}';
    }
}

