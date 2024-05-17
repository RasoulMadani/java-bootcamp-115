package q03.baseClasses;

public class Player extends User {
    private ContractPlayer[] contractsPlayer = new ContractPlayer[10];
    private int indexContractsPlayer = 0;

    public Player(String firstName, String lastName, String nationality, ContractPlayer contract) {
        super(firstName, lastName, nationality);
        contractsPlayer[indexContractsPlayer++] = contract;
    }

    public int salaryCalculation() {
        PlaySalary[] playSalaries = contractsPlayer[indexContractsPlayer-1].getPlaySalaries();
        int sumPlaySalary = 0;
        for (PlaySalary playSalary : playSalaries) {
            if (playSalary!=null)
                sumPlaySalary += playSalary.salary;
        }
        return sumPlaySalary + contractsPlayer[indexContractsPlayer-1].getBaseSalary();
    }

    public ContractPlayer getContractPlayer(){
        return contractsPlayer[indexContractsPlayer-1];
    }

    public void addContractPlayer(ContractPlayer contractPlayer) {
        contractsPlayer[indexContractsPlayer++] = contractPlayer;
    }
}
