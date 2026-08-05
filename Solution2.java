class Employee{
    private int EmployeeId;
    private String name;
    private String Department;
    private double salary;
    private float experience;
    Employee(int EmployeeId,String name,String Department,double salary,float experience){
        this.EmployeeId=EmployeeId;
        this.name=name;
        this.Department=Department;
        this.salary=salary;
        this.experience=experience;
    }
    int getEmployeeId(){
        return EmployeeId;
    }
    String getName(){
        return name;
    }
    String getDepartment(){
        return Department;
    }
    double getSalary(){
        return salary;
    }
    float getExperience(){
        return experience;
    }
}


class Solution2{
    static Employee findHighestPaidEmployee(Employee[] employees,String department){
        Employee highestPaidEmployee = null;
        double maxsalary = 0;
        for(int i=0; i<employees.length; i++){
            if(employees[i].getDepartment().equalsIgnoreCase(department)){
                if(employees[i].getSalary() > maxsalary){
                    maxsalary = employees[i].getSalary();
                    highestPaidEmployee = employees[i];
                }
            }
        }
        return highestPaidEmployee;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] employees=new Employee[n];
        for(int i=0; i<n; i++){
            int EmployeeId=sc.nextInt();
            String name=sc.next();
            String Department=sc.next();
            double salary=sc.nextDouble();
            float experience=sc.nextFloat();
            employees[i]=new Employee(EmployeeId,name,Department,salary,experience);
        }
        Employee result = findHighestPaidEmployee(employees, sc.next());
        if(result != null){
            System.out.println(result.getEmployeeId() + " " + result.getName() + " " + result.getDepartment() + " " + result.getSalary() + " " + result.getExperience());
        } else {
            System.out.println("No employee found in the given department");
        }
    }
}