```text
customer-management-platform/
├── pom.xml
├── docs/
│   └── CODING-STANDARDS.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/northstar/crm/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/northstar/crm/
│       └── resources/
└── target/
```


### Step 1 — Classify these files

Copy into `maven-layout-notes.md` and fill the destination:

| File | Destination            |
| ---- |------------------------|
| `Customer.java` | src/main/java          |
| `CustomerServiceTest.java` | src/main/java          |
| `application.properties` | src/main/resources/    |
| `sample-customers.json` used only by tests | src/test/resources/  | 
| `CODING-STANDARDS.md` | docs/                  |
| `Customer.class` | target/classes/        |

### Step 2 — Check your answers

| File                       | Destination                       |
|----------------------------|-----------------------------------|
| `Customer.java`            | `src/main/java/...`               |
| `CustomerServiceTest.java` | `src/test/java/...`               |
| `application.properties`   | `src/main/resources/`             |
| test JSON                  | `src/test/resources/`             |
| standards                  | `docs/`                           |
| `Customer.class`           | generated under `target/classes/` |

### Step 3 — Explain `target/`

Write: `target/` is generated from source by Maven. It can be deleted and rebuilt, so it should be ignored rather than committed.

### Step 4 — Spot the mistakes

Explain why each is wrong:

- production Java in `src/test/java`;
  - Should be in src/main/java/
- passwords committed in `application.properties`;
  - passwords should be comitted to either data storage file or a secret file.
- hand-editing `target/classes`;
  - target/ should just be ignored
- test fixtures in production resources without a runtime need.
  - fixtures cannot be tested without a runtime in this situation

## Expected result

Every file is assigned to the correct Maven location, and you can distinguish source from generated output.

## Pass criteria

| # | Confirm | Notes |
| - | ------- | ----- |
| 1 | Six files classified correctly | Pass / Fail |
| 2 | You explain why `target/` is ignored | Pass / Fail |
| 3 | You state that resources must not contain committed secrets | Pass / Fail |