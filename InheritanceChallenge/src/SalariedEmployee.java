public class SalariedEmployee extends  Employee{

    double annualSalary;
    boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    //payed 26 times a year
    // maximum pension is 90% of salary
    @Override
    public double collectPay() {
        double paycheck = annualSalary / 26;
        double adjustedPay = (isRetired)? 0.9*paycheck:paycheck;
        return (int) adjustedPay;

    }

    //from Worker class
    public void retire(){
        terminate("12/12/2025");
        isRetired = true;
    }
}
