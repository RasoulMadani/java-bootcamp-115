package q03.baseClasses;

public class PlaySalary {
    Game game;
    int salary;

    public PlaySalary(Game game, int salary) {
        this.game = game;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PlaySalary{" +
                "gameId=" + game.getId() +
                ", salary=" + salary +
                '}';
    }
}
