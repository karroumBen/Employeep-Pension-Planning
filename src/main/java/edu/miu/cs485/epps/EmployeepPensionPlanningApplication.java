package edu.miu.cs485.epps;

import edu.miu.cs485.epps.model.Employee;
import edu.miu.cs485.epps.model.PensionPlan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class EmployeepPensionPlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeepPensionPlanningApplication.class, args);
        List<Employee> employees = prepareData();
        Collections.sort(employees, Comparator.comparing(Employee::getFirstName)
                .thenComparing(Comparator.comparingDouble(Employee::getYearlySalary)));
        for (Employee employee: employees) {
            System.out.println(employee);
        }

    }
    public static List<Employee> prepareData() {
        List<Employee> employees = new ArrayList();
        PensionPlan pp1 = new PensionPlan("EX1089", "2023-01-17",100.00);
        PensionPlan pp2 = new PensionPlan("SM2307", "2019-11-04",1555.50);

        employees.add(new Employee(1000L,"Daniel", "Agar", "2018-01-17", 105945.50, pp1));
        employees.add(new Employee(1001L,"Benard", "Shaw", "2019-04-03", 197750.00, null));
        employees.add(new Employee(1002L,"Carly", "Agar", "2014-05-16", 842000.75, pp2));
        employees.add(new Employee(1003L,"Wesley", "Schneider", "2019-05-02", 74500.00, null));

        return employees;
    }

}
