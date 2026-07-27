package com.academy.analytics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeService {

    private final List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void displayAllEmployees() {
        System.out.println("Total Employees : " + employees.size());
        System.out.println("Employee List");
        employees.stream().forEach(System.out::println);
        // TODO: stream forEach print each employee
//        throw new UnsupportedOperationException("TODO");
    }

    public void demonstrateLambdas() {
        System.out.println("--- Lambda Expressions ---");
        // TODO: forEach name / salary / department demos
        System.out.println("Names:");
        employees.forEach(employee -> System.out.println(employee.getName()));
        System.out.println("Salaries:");
        employees.forEach(employee -> System.out.printf("$%.0f%n", employee.getSalary()));
        System.out.println("Departments:");
        employees.forEach(employee -> System.out.println(employee.getDepartment()));
//        throw new UnsupportedOperationException("TODO");
    }

    public void demonstrateFunctionalInterfaces() {
        // TODO: Predicate/Function/Consumer/Supplier demos on employees
        Predicate<Employee> highEarner = employee -> employee.getSalary() > 100_000;
        Function<Employee, String> employeeSummary = employee ->
                employee.getName() + " (" + employee.getDepartment() + ")";
        Consumer<Employee> printRating = employee ->
                System.out.println(employee.getName() + " - Rating " + employee.getRating());
        Supplier<Employee> topSample = () -> employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

        System.out.println("--- Functional Interfaces ---");
        employees.stream().filter(highEarner).map(Employee::getName).forEach(System.out::println);
        employees.stream().map(employeeSummary).limit(5).forEach(System.out::println);
        employees.stream().limit(5).forEach(printRating);
        System.out.println("Supplier sample (highest paid): " + topSample.get());
//        throw new UnsupportedOperationException("TODO");
    }

    public void demonstrateStreamSources() {
        // TODO: stream from List, Array, Set — print first 5 names each
        System.out.println("--- Stream Sources ---");
        System.out.println("From List:");
        employees.stream().map(Employee::getName).limit(5).forEach(System.out::println);

        Employee[] employeeArray = employees.toArray(new Employee[0]);
        System.out.println("From Array:");
        java.util.Arrays.stream(employeeArray).map(Employee::getName).limit(5).forEach(System.out::println);

        Set<Employee> employeeSet = new HashSet<>(employees);
        System.out.println("From Set:");
        employeeSet.stream().map(Employee::getName).limit(5).forEach(System.out::println);
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayHighSalaryEmployees() {
        System.out.println("Employees with salary > 80000:");
        // TODO: filter salary > 80_000; forEach
        System.out.println("Employees with salary > 80000:");
        employees.stream()
                .filter(employee -> employee.getSalary() > 80_000)
                .forEach(System.out::println);
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayItEmployees() {
        System.out.println("IT Department:");
        // TODO: filter department IT; forEach
        System.out.println("IT Department:");
        employees.stream()
                .filter(employee -> "IT".equalsIgnoreCase(employee.getDepartment()))
                .forEach(System.out::println);
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayActiveEmployees() {
        System.out.println("Active Employees:");
        // TODO: filter Employee::isActive; forEach
        System.out.println("Active Employees:");
        employees.stream()
                .filter(Employee::isActive)
                .forEach(System.out::println);
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayFilteredItTopPerformers() {
        System.out.println("IT employees with salary > 90000 and rating >= 4:");
        employees.stream()
                .filter(employee -> "IT".equalsIgnoreCase(employee.getDepartment()))
                .filter(employee -> employee.getSalary() > 90_000)
                .filter(employee -> employee.getRating() >= 4)
                .forEach(System.out::println);
        // TODO: chained filters for IT + salary + rating
//        throw new UnsupportedOperationException("TODO");
    }

    public void demonstrateMapping() {
        // TODO: map names / salaries / departments (limit 8)
        System.out.println("Mapped Names:");
        employees.stream().map(Employee::getName).limit(8).forEach(System.out::println);

        System.out.println("Mapped Salaries:");
        employees.stream().map(Employee::getSalary).limit(8).forEach(System.out::println);

        System.out.println("Mapped Departments:");
        employees.stream().map(Employee::getDepartment).limit(8).forEach(System.out::println);
//        throw new UnsupportedOperationException("TODO");
    }

    public void demonstrateSorting() {
        // TODO: sorted by salary asc/desc, name, experience
//        throw new UnsupportedOperationException("TODO");
        System.out.println("Salary Ascending:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Salary Descending:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Name Ascending:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Experience Descending:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getExperience).reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    public void displayDistinctDepartments() {
        System.out.println("Unique Departments:");
        // TODO: map department, distinct, sorted, forEach
        System.out.println("Unique Departments:");
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .forEach(System.out::println);
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayTopAndNextSalaries() {
        // TODO: top 5 and next 5 by salary desc
        Comparator<Employee> bySalaryDesc =
                Comparator.comparingDouble(Employee::getSalary).reversed();

        System.out.println("Top 5 Highest Salaries:");
        employees.stream().sorted(bySalaryDesc).limit(5)
                .forEach(e -> System.out.printf("%s - $%.0f%n", e.getName(), e.getSalary()));

        System.out.println("Next 5 Highest Salaries:");
        employees.stream().sorted(bySalaryDesc).skip(5).limit(5)
                .forEach(e -> System.out.printf("%s - $%.0f%n", e.getName(), e.getSalary()));
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayCounts() {
        // TODO: total, IT count, active count, salary > 100000 count
        long total = employees.size();
        long itCount = employees.stream()
                .filter(e -> "IT".equalsIgnoreCase(e.getDepartment()))
                .count();
        long activeCount = employees.stream().filter(Employee::isActive).count();
        long highSalaryCount = employees.stream()
                .filter(e -> e.getSalary() > 100_000)
                .count();

        System.out.println("Total Employees : " + total);
        System.out.println("IT Employees : " + itCount);
        System.out.println("Active Employees : " + activeCount);
        System.out.println("Employees with Salary > 100000 : " + highSalaryCount);
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayReductions() {
        // TODO: highest/lowest via reduce; total/average via mapToDouble
        Optional<Double> highest = employees.stream().map(Employee::getSalary).reduce(Double::max);
        Optional<Double> lowest = employees.stream().map(Employee::getSalary).reduce(Double::min);
        double total = employees.stream().mapToDouble(Employee::getSalary).sum();
        double average = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);

        System.out.println("Highest Salary : " + highest.orElse(0.0));
        System.out.println("Lowest Salary : " + lowest.orElse(0.0));
        System.out.printf("Total Salary : %.0f%n", total);
        System.out.printf("Average Salary : %.0f%n", average);
//        throw new UnsupportedOperationException("TODO");
    }

    public void demonstrateCollectors() {
        // TODO: toList active, toSet departments, groupingBy department
        List<Employee> active = employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList());
        Set<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Collected active employees : " + active.size());
        System.out.println("Collected departments : " + departments);
        System.out.println("Grouped by department keys : " + byDepartment.keySet());
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayGroupedEmployees() {
        // TODO: groupingBy department; print each group
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        grouped.forEach((department, list) -> {
            System.out.println(department);
            list.forEach(e -> System.out.println("  " + e.getName()));
        });
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayPartitionedEmployees() {
        // TODO: partitioningBy salary > 100_000
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 100_000));
        System.out.println("Salary > 100000 (True):");
        partitioned.get(true).forEach(e -> System.out.println("  " + e.getName()));
        System.out.println("Salary <= 100000 (False):");
        partitioned.get(false).forEach(e -> System.out.println("  " + e.getName()));
//        throw new UnsupportedOperationException("TODO");
    }

    public void displaySummaryStatistics() {
        // TODO: summarizingDouble salary; print max/min/avg/sum/count
        DoubleSummaryStatistics stats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Highest Salary : " + stats.getMax());
        System.out.println("Lowest Salary : " + stats.getMin());
        System.out.println("Average Salary : " + stats.getAverage());
        System.out.println("Total Salary : " + stats.getSum());
        System.out.println("Employee Count : " + stats.getCount());
//        throw new UnsupportedOperationException("TODO");
    }

    public void displayHighestPaidEmployeeOptional() {
        // TODO: max by salary; ifPresentOrElse
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        highestPaid.ifPresentOrElse(
                e -> System.out.println("Highest Paid Employee : " + e.getName()
                        + " ($" + (int) e.getSalary() + ")"),
                () -> System.out.println("No Employee Found")
        );
//        throw new UnsupportedOperationException("TODO");
    }

    public Optional<Employee> findHighestPaidEmployee() {
        // TODO: max by salary
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
//        throw new UnsupportedOperationException("TODO");
    }

    public Optional<Employee> findTopPerformer() {
        // TODO: max by rating then salary
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getRating)
                        .thenComparingDouble(Employee::getSalary));
//        throw new UnsupportedOperationException("TODO");
    }

    public List<Employee> getTopSalaries(int count) {
        // TODO: sorted salary desc; limit count; toList
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(count)
                .toList();
//        throw new UnsupportedOperationException("TODO");
    }

    public List<Employee> getTopPerformers(int minimumRating) {
        // TODO: filter rating >= minimum; sort; toList
        return employees.stream()
                .filter(e -> e.getRating() >= minimumRating)
                .sorted(Comparator.comparingInt(Employee::getRating).reversed()
                        .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()))
                .toList();
//        throw new UnsupportedOperationException("TODO");
    }

    public Map<String, DoubleSummaryStatistics> getDepartmentStatistics() {
        // TODO: groupingBy department + summarizingDouble salary
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summarizingDouble(Employee::getSalary)));
//        throw new UnsupportedOperationException("TODO");
    }

    public Optional<Double> findSecondHighestSalary() {
        // TODO: distinct salaries desc; skip 1; findFirst
        return employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
//        throw new UnsupportedOperationException("TODO");
    }

    public Optional<Employee> findEmployeeWithLongestName() {
        // TODO: max by name length
        return employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getName().length()));
//        throw new UnsupportedOperationException("TODO");
    }

    public Optional<String> findDepartmentWithHighestAverageSalary() {
        // TODO: groupingBy averagingDouble; max entry; map key
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
//        throw new UnsupportedOperationException("TODO");
    }

    public Map<String, Long> generateSalaryHistogram() {
        // TODO: groupingBy salaryBucket + counting
        return employees.stream()
                .collect(Collectors.groupingBy(this::salaryBucket, Collectors.counting()));
//        throw new UnsupportedOperationException("TODO");
    }

    public String collectEmployeeSummary() {
        // TODO: custom Collector of name(department), ...
        return employees.stream()
                .collect(Collector.of(
                        StringBuilder::new,
                        (summary, employee) -> {
                            if (!summary.isEmpty()) {
                                summary.append(", ");
                            }
                            summary.append(employee.getName())
                                    .append("(")
                                    .append(employee.getDepartment())
                                    .append(")");
                        },
                        (left, right) -> {
                            if (!left.isEmpty() && !right.isEmpty()) {
                                left.append(", ");
                            }
                            return left.append(right);
                        },
                        StringBuilder::toString));
    }

    private String salaryBucket(Employee employee) {
        double salary = employee.getSalary();
        if (salary < 60_000) {
            return "40K-60K";
        }
        if (salary < 80_000) {
            return "60K-80K";
        }
        if (salary < 100_000) {
            return "80K-100K";
        }
        return "100K+";
    }
}
