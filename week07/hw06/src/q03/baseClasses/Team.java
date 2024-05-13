package q03.baseClasses;

import java.util.Arrays;

public class Team {
    private String name;
    private String lig;
    private Coach coach;
    private Player[] players = new Player[10];
    int indexPlayer;

    public Team(String name, String lig, Coach coach) {
        this.name = name;
        this.lig = lig;
        this.coach = coach;
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

    public Coach getCoach() {
        return coach;
    }

    public Team setCoach(Coach coach) {
        this.coach = coach;
        return this;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Team addPlayer(Player player) {
        players[indexPlayer++] = player;
        return this;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", lig='" + lig + '\'' +
                ", coach=" + coach +
                ", players=" + Arrays.toString(players) +
                ", indexPlayer=" + indexPlayer +
                '}';
    }
}
