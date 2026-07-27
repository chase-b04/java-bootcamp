import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DepartmentCountDemo {
    public static void main(String[] args) {
        // TODO: stream + collect groupingBy(Employee::department, Collectors.counting())
        Map<String, Long> counts = EmployeeData.sample().stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        //new Employee(6, "Fatima", "Finance", 70_000)
        // TreeMap gives the report a stable alphabetical order.
        Map<String, Long> sortedCounts = new TreeMap<>(counts);

        sortedCounts.forEach((department, count) ->
                System.out.println(department + ": " + count));
    }
}