1. When choose List over Set?
You should use a List when you need your information ordered and duplicates allowed.

2. Why HashSet before inserting a book ID?
To block duplicate entry.

3. Why a Map for “currently borrowed” vs only a boolean?
Key/Value identification and managing multiple borrowed books at a time.

4. HashMap vs TreeMap in this lab?
TreeMap is used to keep a ordered map of categories, making it easier for finding the max key.

5. Comparable vs Comparator for books?
Comparable defines a naturally sorted order in the Book Class, while comparator defines sorting rules out of the Book class.

6. Which iteration style would you use most in production—and why?
For loops are probably the most common for simple iterations, with .map() and .filter() being good choices when handling complex data structures.

7. CRM: which collection for customer list / unique emails / id→customer lookup?
Use a twos HashMap for ID lookups of customers and emails.