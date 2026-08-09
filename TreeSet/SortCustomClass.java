import java.util.*;
class Employee implements Comparable<Employee>{
    String name;

    Double Salary;

    public Employee(String name, Double Salary){
        this.name = name;
        this.Salary = Salary;
    }
    @Override
    public int compareTo(Employee other){
        return other.Salary.compareTo(this.Salary);
        // For ascending order, use: return this.Salary.compareTo(other.Salary);
    }
}
class SortCustomClass{
    public static void main(String[] args){
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(new Employee("Alice", 50000.0));
        employees.add(new Employee("Bob", 60000.0));
        employees.add(new Employee("Charlie", 55000.0));

        for(Employee emp : employees){
            System.out.println(emp.name + ": " + emp.Salary);
        }
    }
}