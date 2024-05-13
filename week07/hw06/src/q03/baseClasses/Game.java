package q03.baseClasses;

import q03.commonClasses.IdGenerator;

import java.util.Arrays;

public class Game {
    private int id;
    private Player[] mainPlayersVisitingTeam = new Player[10];
    private int indexMainPlayersVisitingTeam = 0;
    private Player[] reservePlayersVisitingTeam = new Player[10];
    private int indexReservePlayersVisitingTeam = 0;
    private Player[] mainPlayersHomeTeam = new Player[10];
    private int indexMainPlayersHomeTeam = 0;
    private Player[] reservePlayersHomeTeam = new Player[10];
    private int indexReservePlayersHomeTeam = 0;
    private Referee[] referees;
    private int indexReferee = 0;
    private Goal[] goals;
    private int indexGoal = 0;

    public Game() {
        this.id = IdGenerator.generator();
    }

    public int getId() {
        return id;
    }

    public Game setId(int id) {
        this.id = id;
        return this;
    }

    public Player[] getMainPlayersVisitingTeam() {
        return mainPlayersVisitingTeam;
    }

    public Game setMainPlayersVisitingTeam(Player mainPlayersVisitingTeam) {
        this.mainPlayersVisitingTeam[indexMainPlayersVisitingTeam++] = mainPlayersVisitingTeam;
        return this;
    }

    public int getIndexMainPlayersVisitingTeam() {
        return indexMainPlayersVisitingTeam;
    }


    public Player[] getReservePlayersVisitingTeam() {
        return reservePlayersVisitingTeam;
    }

    public Game setReservePlayersVisitingTeam(Player reservePlayersVisitingTeam) {
        this.reservePlayersVisitingTeam[indexReservePlayersVisitingTeam++] = reservePlayersVisitingTeam;
        return this;
    }

    public int getIndexReservePlayersVisitingTeam() {
        return indexReservePlayersVisitingTeam;
    }

    public Player[] getMainPlayersHomeTeam() {
        return mainPlayersHomeTeam;
    }

    public Game setMainPlayersHomeTeam(Player mainPlayersHomeTeam) {
        this.mainPlayersHomeTeam[indexMainPlayersHomeTeam++] = mainPlayersHomeTeam;
        return this;
    }

    public int getIndexMainPlayersHomeTeam() {
        return indexMainPlayersHomeTeam;
    }


    public Player[] getReservePlayersHomeTeam() {
        return reservePlayersHomeTeam;
    }

    public Game setReservePlayersHomeTeam(Player reservePlayersHomeTeam) {
        this.reservePlayersHomeTeam[indexReservePlayersHomeTeam++] = reservePlayersHomeTeam;
        return this;
    }

    public int getIndexReservePlayersHomeTeam() {
        return indexReservePlayersHomeTeam;
    }


    public Referee[] getReferees() {
        return referees;
    }

    public Game setReferees(Referee referees) {
        this.referees[indexReferee++] = referees;
        return this;
    }

    public int getIndexReferee() {
        return indexReferee;
    }


    public Goal[] getGoals() {
        return goals;
    }

    public Game setGoals(Goal goals) {
        this.goals[indexGoal++] = goals;
        return this;
    }

    public int getIndexGoal() {
        return indexGoal;
    }

    @Override
    public String toString() {
        return "Game{" + "\n" +
                "  id=" + id + "\n" +
                "  mainPlayersVisitingTeam=" + Arrays.toString(mainPlayersVisitingTeam) + "\n" +
                "  indexMainPlayersVisitingTeam=" + indexMainPlayersVisitingTeam + "\n" +
                "  reservePlayersVisitingTeam=" + Arrays.toString(reservePlayersVisitingTeam) + "\n" +
                "  indexReservePlayersVisitingTeam=" + indexReservePlayersVisitingTeam + "\n" +
                "  mainPlayersHomeTeam=" + Arrays.toString(mainPlayersHomeTeam) + "\n" +
                "  indexMainPlayersHomeTeam=" + indexMainPlayersHomeTeam + "\n" +
                "  reservePlayersHomeTeam=" + Arrays.toString(reservePlayersHomeTeam) + "\n" +
                "  indexReservePlayersHomeTeam=" + indexReservePlayersHomeTeam + "\n" +
                "  referees=" + Arrays.toString(referees) + "\n" +
                "  indexReferee=" + indexReferee + "\n" +
                "  goals=" + Arrays.toString(goals) + "\n" +
                "  indexGoal=" + indexGoal + "\n" +
                '}';
    }
}
