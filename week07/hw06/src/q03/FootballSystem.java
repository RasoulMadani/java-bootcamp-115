package q03;

import q03.baseClasses.*;

public class FootballSystem {
    public static void main(String[] args) {
        Contract contractPlayer = new Contract(200);
        Player player = new Player("allah","allah","iran",contractPlayer);

        Game game = new Game();
        System.out.println(game);
        PlaySalary playSalary = new PlaySalary(game.getId(),2000);
        player.getContract().addPlaySalaries(playSalary);
        System.out.println(player);
        Contract contractCoach = new Contract(2000,200);
        Coach coach = new Coach("ali","alii","iran",contractCoach);
        Referee referee = new Referee("ali","alii","tehran",contractCoach,"one");
        Team team = new Team("allah","iran",coach);
        team.addPlayer(player);
        System.out.println(team);

    }
}