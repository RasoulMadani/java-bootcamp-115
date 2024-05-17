package q03;

import q03.baseClasses.*;

public class FootballSystem {
    public static void main(String[] args) {
        ContractPlayer contractPlayer = new ContractPlayer(200);

        Player player = new Player("allah", "allah", "iran", contractPlayer);

        Game game = new Game();

        PlaySalary playSalary = new PlaySalary(game, 2000);


        player.getContractPlayer().addPlaySalaries(playSalary);


        System.out.println(player.salaryCalculation());


        ContractCoach contractCoach = new ContractCoach(2000, 200);

        Coach coach = new Coach("ali", "alii", "iran", contractCoach);

        System.out.println(coach.salaryCalculation());


        Referee referee = new Referee("ali", "alii", "tehran", "one");

        Team team = new Team("allah", "iran");

        team.addPlayer(player);

        team.addCoach(coach);

        team.print_all_salaries();

    }
}