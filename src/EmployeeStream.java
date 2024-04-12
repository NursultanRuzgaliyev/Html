import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class EmployeeStream {
    static void printUniqueLastNames(List<Employee> employees){
        employees.stream()
                .map(Employee::getLastName)
                .sorted()
                .collect(Collectors.toList())
                .forEach(string -> System.out.println(string));
    }
    static double calculateAverageSalaryOfEmployeesYoungerThan30( List<Employee> employees){
        return employees.stream()
                .filter(employee -> employee.getAge()<30)
                .map(Employee::getSalary)
                .mapToDouble(salary->salary)
                .average()
                .orElse(0.0);


    }
    static void printAverageSalaryByAge(List<Employee> employees){
        String salary;
        Integer age;
        employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getAge,
                                Collectors.averagingDouble(Employee::getSalary)
                        ))
                .forEach(age,salary)-> System.out.println("Average salary for age " + age + " :" + salary));

    }
}
