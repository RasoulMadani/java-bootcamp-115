package q03.baseClasses;

import java.util.Arrays;

public class ContractCoach {

    private int baseSalary;
    private int perDay;
    private int vacationDay;

    public ContractCoach(int baseSalary, int perDay) {
        this.baseSalary = baseSalary;
        this.perDay = perDay;
    }

    public int getVacationDay() {
        return vacationDay;
    }

    public ContractCoach setVacationDay(int vacationDay) {
        this.vacationDay = vacationDay;
        return this;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public ContractCoach setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    public int getPerDay() {
        return perDay;
    }

    public ContractCoach setPerDay(int perDay) {
        this.perDay = perDay;
        return this;
    }

    @Override
    public String toString() {
        return "ContractCoach{" +
                "baseSalary=" + baseSalary +
                ", perDay=" + perDay +
                ", vacationDay=" + vacationDay +
                '}';
    }
}

