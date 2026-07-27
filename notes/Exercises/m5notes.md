E1:

After adds:  [Java Fundamentals, Clean Code, Effective Java, Java Fundamentals]
After set:   [Java Fundamentals, Clean Architecture, Effective Java, Java Fundamentals]
After remove:[Clean Architecture, Effective Java, Java Fundamentals]

System.out.println(books.get(99)); prints:
Found Effective Java: true
Size: 3
Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 99 out of bounds for length 3


E2:
These are deterministic:

second "Java" add returns false;
size is 3;
sorted view is alphabetical.
Raw HashSet iteration order is not a contract and may vary by JDK or run.

Sets determine duplicates using equals and hashCode. Strings already implement them. Lab 5 must define identity 
carefully when custom objects are stored in sets.

E5:
TreeMap keys always iterate in sorted order — that part is guaranteed. HashMap key order is not a contract; it may 
differ between runs or JDK versions, so never depend on it for display order.


E7:
The map is updated only after the title was successfully removed from the available list. Updating the map first could record a loan for an unavailable title and leave inconsistent state.
This warm-up intentionally simplifies the domain. Lab 5 will improve it with:

Book and Member objects instead of raw strings;
immutable IDs;
separate uniqueness sets;
borrow/return history;
search, sorting, and reports.