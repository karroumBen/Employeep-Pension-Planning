package edu.miu.cs485.epps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs485.epps.model.Employee;
import edu.miu.cs485.epps.model.PensionPlan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class EmployeepPensionPlanningApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(EmployeepPensionPlanningApplication.class, args);
        List<Employee> employees = prepareData();
        Collections.sort(employees, Comparator.comparing(Employee::getFirstName)
                        .reversed()
                .thenComparing(Comparator.comparingDouble(Employee::getYearlySalary)));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(employees);
        System.out.println(jsonString);
        printEligibleForPensionPlan(employees);

    }
    public static List<Employee> prepareData() {
        List<Employee> employees = new ArrayList<>();
        PensionPlan pp1 = new PensionPlan("EX1089", LocalDate.of(2023,1,17),100.00);
        PensionPlan pp2 = new PensionPlan("SM2307", LocalDate.of(2019,11,4),1555.50);

        employees.add(new Employee(1000L,"Daniel", "Agar", LocalDate.of(2018,1,17), 105945.50, pp1));
        employees.add(new Employee(1001L,"Benard", "Shaw",LocalDate.of(2019,4,3), 197750.00, null));
        employees.add(new Employee(1002L,"Carly", "Agar", LocalDate.of(2014,5,16), 842000.75, pp2));
        employees.add(new Employee(1003L,"Wesley", "Schneider", LocalDate.of(2019,5,2), 74500.00, null));

        return employees;
    }
    public static void printEligibleForPensionPlan(List<Employee> employees) throws JsonProcessingException {
        List<Employee> eligibleEmployees = employees.stream().filter(
                employee -> LocalDate.now().getYear() - employee.getEmploymentDate().getYear() >= 5 && employee.getPensionPlan() != null).toList();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(eligibleEmployees);
        System.out.println(jsonString);

    }

}
