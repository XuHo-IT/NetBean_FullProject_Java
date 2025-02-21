/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Softbank_South extends SoftBank {

    public Softbank_South(String BankName, int Date, String Address, int SeniorEmployees, int JuniorEmployees) {
        super(BankName, Date, Address, SeniorEmployees, JuniorEmployees);
    }

    public double CalculateEstimatedCost()
    {
        double regionFactor = 1.5; 
        double seniorSalary = SeniorEmployees * 5000 * regionFactor;
        double juniorSalary = JuniorEmployees * 2000 * regionFactor;
        return seniorSalary + juniorSalary;
    }

    public double CalculateActualCost(int contractorEmployees)
    {
        double estimatedCost = CalculateEstimatedCost();
        double contractorSalary = contractorEmployees * 1000; 
        return estimatedCost + contractorSalary;
    }
    
}
