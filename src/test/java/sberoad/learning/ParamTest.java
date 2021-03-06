package sberoad.learning;

import java.util.ArrayList;

public class ParamTest {
    public static void main(String[] args) {
// Тест 1: методы не могут видоизменять числовые параметры

        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);


//Тест 2: методы могут изменять состояние объектов,
        //передаваемых в качестве параметров

        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary»" + harry.getSalary());


//Тест 3: методы не могут присоединять новые объекты
//к объектным параметрам
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

    ////
        Manager xxx = new Manager("vasiliy",5000);
        xxx.setbonus(5000);
        System.out.println( xxx.getSalary());
        System.out.println(xxx.getName());
        tripleSalary(xxx);
        System.out.println(xxx.getSalary());
        System.out.println("=============================================================");

Employee [] stuff = new Employee[3];
stuff[0]= a;
stuff[1] = b;
stuff[2]= xxx;

for (Employee e : stuff){
    System.out.println(e.getName() + "    "  + e.getSalary());
}
    }


    private static void tripleValue(double x) //не сработает!
    {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }


    private static void tripleSalary(Employee x) // сработает! 49
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary»" + x.getSalary());
    }

    private static void swap(Employee x, Employee у) {

        Employee temp = x;
        x = у;
        у = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + у.getName());


    }
}

class Employee // упрощенный класс Employee
{
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary()

    {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary *
                byPercent / 100;
        salary += raise;

    }
}
class Manager extends Employee{
    private double bonus ;

    Manager(String n, double s) {
        super(n, s);
        bonus = 0;
    }
    public void  setbonus(double abonus){
        bonus = abonus;
    }

public double getSalary(){
    return super.getSalary() + bonus;
}

}
