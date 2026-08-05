class Person{
    private int id;
    private String name;
    private double age;
    Person(int id, String name , double age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    double getAge(){
        return age;
    }
}
class Patient extends Person{
    private String disease;
    private double billAmount;
    Patient(int id, String name, double age, String disease, double billAmount){
        super(id,name,age);
        this.disease = disease;
        this.billAmount = billAmount;
    }
    String getDisease(){
        return disease;
    }
    double getBillAmount(){
        return billAmount;
    }
    int getId(){
        return super.getId();
    }
    String getName(){
        return super.getName();
    }
    double getAge(){
        return super.getAge();
    }
}


class Solution3{
    static Patient findPatientWithHighestBill(Patient[] patients){
        Patient thatPatient = patients[0];
        for(int i=0; i<patients.length; i++){
            if(patients[i].getBillAmount() > thatPatient.getBillAmount()){
                thatPatient = patients[i];
            }
        }
        return thatPatient;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Patient[] patients = new Patient[n];
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.next();
            double age = sc.nextDouble();
            sc.nextLine();
            String disease = sc.next();
            double billAmount = sc.nextDouble();
            patients[i] = new Patient(id,name,age,disease,billAmount);
        }
        Patient result = findPatientWithHighestBill(patients);
        if(result != null){
            System.out.println(result.getId() + " " + result.getName() + " " + result.getAge() + " " + result.getDisease() + " " + result.getBillAmount());
        }else {
            System.out.println("No patients found");
        }
    }
}