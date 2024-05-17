package q03.baseClasses;

import java.util.Arrays;

public class Team {
    private String name;
    private String lig;
    private Coach[] coaches = new Coach[10];
    private int indexCoaches;
    private Player[] players = new Player[10];
    private int indexPlayer;

    public Team(String name, String lig) {
        this.name = name;
        this.lig = lig;
    }

    public void print_all_salaries() {
        int salary = 0;
        System.out.println(this.coaches[0]);
        for (int i = 0; i < indexCoaches; i++) {
            if (this.coaches[i] != null) {
                salary += coaches[i].salaryCalculation();
            }
        }
        for (int i = 0; i < indexPlayer; i++) {
            if (this.players[i] != null) {
                salary += players[i].salaryCalculation();
            }
        }
        System.out.println(salary);
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public String getLig() {
        return lig;
    }

    public Team setLig(String lig) {
        this.lig = lig;
        return this;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Team addPlayer(Player player) {
        players[indexPlayer++] = player;
        return this;
    }

    public Team addCoach(Coach coach) {
        coaches[indexCoaches++] = coach;
        return this;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", lig='" + lig + '\'' +
                ", coachs=" + Arrays.toString(coaches) +
                ", indexCoaches=" + indexCoaches +
                ", players=" + Arrays.toString(players) +
                ", indexPlayer=" + indexPlayer +
                '}';
    }
}
