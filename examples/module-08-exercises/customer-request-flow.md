## Steps

### Step 1 — Create the flow

```mermaid
sequenceDiagram
    actor Client
    participant C as CustomerController
    participant S as CustomerService
    participant R as CustomerRepository

    Client->>C: CustomerRequest
    C->>S: createCustomer(request)
    S->>S: validate + assign ID/status
    S->>R: save(Customer)
    R-->>S: saved Customer
    S-->>C: CustomerResponse
    C-->>Client: response
```

### Step 2 — Annotate transformations

| Boundary             | Input                    | Output              |
|----------------------|--------------------------|---------------------|
| Client → controller  | Future transport payload | `CustomerRequest`   |
| Service validation   | Request DTO              | valid domain values |
| Service → repository | `Customer` entity        | saved entity        |
| Service → controller | entity/result            | `CustomerResponse`  |

### Step 3 — Add failure flow

```mermaid
sequenceDiagram
    actor Client
    participant C as Controller
    participant S as Service

    Client->>C: blank name
    C->>S: createCustomer(request)
    S-->>C: validation failure
    C-->>Client: safe error response later
```

Do not invent HTTP status codes yet; Module 8 is structure only.

### Step 4 — Add “now vs later”

```markdown
## Now
- Package names and stub responsibilities
- Plain Java types that compile
- Documented flow

## Later
- Spring controller annotations
- Validation annotations
- Repository implementation/JPA
- HTTP response mapping
- Correlation-ID logging
```

### Step 5 — Final readiness check

Record **Pass** or **Fail** in your notes:

| Readiness check | Result |
| --------------- | ------ |
| I can locate each class package | **~~Pass~~** / Fail |
| I can explain controller → service → repository | **~~Pass~~** / Fail |
| I distinguish DTO from entity | **~~Pass~~** / Fail |
| I have not added Spring/JPA/database code | **~~Pass~~** / Fail |
| I am ready to build the full Maven skeleton in Lab 8 | **~~Pass~~** / Fail |