Copy the Stream Operations Table into notes/stream-operations-table.md and mark each operation you implemented.

Copy into `notes/stream-operations-table.md` and check what you implemented:

| Operation / API                  |                Used?                 | Where (method / menu)  | Notes  |
|----------------------------------|:------------------------------------:|------------------------|--------|
| Lambda `forEach`                 |         demonstrateLambdas()         | menu 10                |        |
| `Predicate`                      |  demonstrateFunctionalInterfaces()   | menu 11                |        |
| `Function`                       |  demonstrateFunctionalInterfaces()   | menu 11                |        |
| `Consumer`                       |  demonstrateFunctionalInterfaces()   | menu 11                |        |
| `Supplier`                       |  demonstrateFunctionalInterfaces()   | menu 11                |        |
| `filter`                         |   displayFilteredItTopPerformers()   | menu 4                 |        |
| `map`                            |         demonstrateMapping()         | menu 15                |        |
| `sorted`                         |         demonstrateSorting()         | menu 16                |        |
| `distinct`                       |     displayDistinctDepartments()     | menu 17                |        |
| `limit` / `skip`                 |      demonstrateStreamSources()      | menu 12                |        |
| `count`                          |           displayCounts()            | menu 19                |        |
| `reduce`                         |         displayReductions()          | displaySalaryReport()  | Menu 3 |
| `collect(toList/toSet)`          |       getTopSalaries(int count       | displayDashboard()     | Menu 8 |
| `groupingBy`                     |       demonstrateCollectors()        | menu 20                |        |
| `partitioningBy`                 |    displayPartitionedEmployees()     | displaySalaryReport()  | Menu 3 |
| `summarizingDouble`              |      displaySummaryStatistics()      | displaySalaryReport()  | Menu 3 |
| `Optional` (`max` / `ifPresent`) | displayHighestPaidEmployeeOptional() | displayHighestSalary() | Menu 5 |
| Method references                |                 N/A                  | N/A                    |        |
| Dashboard composed report        |          displayDashboard()          | menu 8                 |        |


List functional interfaces and example lambdas used.
The demonstrateFunctionalInterfaces() method utilized both lambdas and functional interfaces. For example:
- Predicate<Employee> highEarner = employee -> employee.getSalary() > 100_000;
- Function<Employee, String> employeeSummary = employee -> employee.getName() + " (" + employee.getDepartment() + ")";
- Consumer<Employee> printRating = employee -> System.out.println(employee.getName() + " - Rating " + employee.getRating());
- Supplier<Employee> topSample = () -> employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);


Draft answers to Reflection Questions (finalize after Manual Verification).
1. What are the advantages of Streams over loops?
Streams offer a powerful way to process collections in a declaritive and functional manner. 

2. When should Streams be preferred?
They should be preferred because they are more efficient. 

3. What is the difference between filter() and map()?
filter() keeps matching elements, map() transforms each element

4. Why is reduce() useful?
Reduce processes all elements by reduction.

5. What does Collectors.groupingBy() do?
They group/aggregate collections.

6. What is the benefit of using Optional?
Optional provides a keywork for values that may be null.

7. Why are Lambda Expressions more readable?
Lambda provides concise, anonymous functions.

8. When should method references be used?
Method references should be used when a lambda expression forwards its argument without adding anymore code.

9. Which stream operation is terminal? Give three examples from your lab.
Terminal operations trigger execution. Three Examples: forEach, count(), collect().

10. How do Streams improve enterprise Java applications?  (Forward look) How would a future CRM use filter / map / groupingBy on customers the same way this lab uses them on employees—without claiming the CRM is implemented today?
Streaks improve java enterprise by helping to the building of efficient and scalable enterprise applications. They are ideal for collections, large datasets, and real time data flows. They improve readability of code, enable features like filtering and grouping, and enable parallel processing.