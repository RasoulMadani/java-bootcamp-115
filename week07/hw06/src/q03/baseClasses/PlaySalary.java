package q03.baseClasses;

public class PlaySalary {
    int gameId;
    int salary;

    public PlaySalary(int gameId, int salary) {
        this.gameId = gameId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PlaySalary{" +
                "gameId=" + gameId +
                ", salary=" + salary +
                '}';
    }
}
