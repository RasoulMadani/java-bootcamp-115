package q03.baseClasses;

public class Coach extends User{
    private ContractCoach[] contractsCoach = new ContractCoach[10];
    private int indexContractsCoach = 0;
    public Coach(String firstName, String lastName, String nationality, ContractCoach contract) {
        super(firstName, lastName, nationality);
        this.contractsCoach[indexContractsCoach++] = contract;
    }
    public int salaryCalculation() {
        return (
                (30 - contractsCoach[indexContractsCoach-1].getVacationDay())
                        * contractsCoach[indexContractsCoach-1].getPerDay()
                + contractsCoach[indexContractsCoach-1].getBaseSalary()
            );
    }

    public ContractCoach getContractCoach() {
        return contractsCoach[indexContractsCoach-1];
    }

    public Coach setContractCoach(ContractCoach contractCoach) {
        this.contractsCoach[indexContractsCoach++] = contractCoach;
        return this;
    }
}
