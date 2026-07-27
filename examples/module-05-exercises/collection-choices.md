| # | Scenario                                    | Need       | Interface              | Implementation | Why                    |
| - |---------------------------------------------|------------|------------------------|----------------|------------------------|
| 1 | Ordered catalog; duplicate titles allowed   | order      | `List<Book>`           | `ArrayList<>`  | Dupes okay, not sorted |
| 2 | Unique registered book IDs                  | unique     | `Set<BookId>`          | `HashSet<>`    | Unique, not sorted     |
| 3 | Book ID → current borrower ID               | key->value | `Map<String, String>`  | `HashMap<>`    | ID/Keys                |
| 4 | Alphabetically sorted categories            | sorted     | `Set<String>`          | `TreeSet<>`    | Sorted, Unique         |
| 5 | Category → count, sorted by category        | key->value | `Map<String, Integer>` | `TreeMap<>`    | Sorted, ID/Keys        |
| 6 | Checkout history in event order             | order      | `List<BorrowRecord>`   | `ArrayList<>`  | Ordered, Dupes okay    |