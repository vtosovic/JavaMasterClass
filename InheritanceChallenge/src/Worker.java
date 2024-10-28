public class Worker {

    private String name;
    private String birthDate;
    protected String endDate;

    public Worker(){

    }

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge(){
        int currentYear = 2025;
        //parseInt returns string to integer
        //substring gets string starting from 6 (first is zero)
        //date is mm.dd.yyyy, so year starts at 6
        int birthYear = Integer.parseInt(birthDate.substring(6));

        return (currentYear - birthYear);
    }

    //This method will be overridden
    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate){
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
