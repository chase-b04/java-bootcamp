### Step 1 — Assign the tasks

| Task                                  | Layer      |
|---------------------------------------|------------|
| Accept future create-customer input   | controller |
| Reject blank customer name            | service    |
| Find customer by ID                   | repository |
| Represent customer ID/name/status     | entity     |
| Represent create request fields       | dto        |
| Define customer-not-found failure     | exception  |
| Wire application objects later        | config     |

### Step 2 — Check the reference

```text
accept input → controller
business validation → service
find by ID → repository
domain state → entity
request shape → dto
failure type → exception
wiring/configuration → config
```

### Step 3 — Repair a “god controller”

Bad flow:

```text
Controller validates every business rule
→ edits an in-memory list directly
→ constructs database queries
→ formats errors
```

Rewrite it:

```text
Controller maps request
→ Service validates/orchestrates
→ Repository saves/finds
→ Service returns result
→ Controller maps response
```

### Step 4 — Explain why boundaries help

Write 3–5 sentences covering:

- Boundaries help because they allow for isolated testing due to class boundaries. They also allow for replacing storage
without changing controller by defining themselves in the service layer. They transfer data without exposing entities, keeping transport concerns out of the business
logic. Finally, they make ownership discoverable by it's definitions.

- isolated testing;
- replacing storage without changing controller;
- keeping transport concerns out of business logic;
- making ownership discoverable.