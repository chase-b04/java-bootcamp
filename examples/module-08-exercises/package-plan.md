### Step 1 — Complete the map

| Type                        | Package     | Fully qualified name                                  |
|-----------------------------|-------------|-------------------------------------------------------|
| `CustomerController`        | Controller  | com.northstar.crm.controller.CustomerController       |
| `CustomerService`           | Service     | com.northstar.crm.service.CustomerService             |
| `CustomerRepository`        | Repository  | com.northstar.crm.repository.CustomerRepository       |
| `Customer`                  | entity      | com.northstar.crm.entity.Customer                     |
| `CustomerRequest`           | dto         | com.northstar.crm.dto.CustomerRequest                 |
| `AppConfig`                 | config      | com.northstar.crm.config.AppConfig                    |
| `CustomerNotFoundException` | exception   | com.northstar.crm.exception.CustomerNotFoundException |

### Step 2 — Check the reference

```text
com.northstar.crm.controller.CustomerController
com.northstar.crm.service.CustomerService
com.northstar.crm.repository.CustomerRepository
com.northstar.crm.entity.Customer
com.northstar.crm.dto.CustomerRequest
com.northstar.crm.config.AppConfig
com.northstar.crm.exception.CustomerNotFoundException
```

### Step 3 — Translate package to path

For:

```java
package com.northstar.crm.service;
```

the production source path must be:

```text
src/main/java/com/northstar/crm/service/
```

Write the equivalent path for `CustomerRequest`.
- `src/main/java/com/northstar/crm/dto/CustomerRequest.java`

### Step 4 — Correct bad names

| Bad                                         | Correct                               |
|---------------------------------------------|---------------------------------------|
| `com.Northstar.CRM.Service`                 | `com.northstar.crm.service`           |
| package `utils` for customer business rules | `service` or a focused domain package |
| `customer_service.java`                     | `CustomerService.java`                |
| package declaration does not match folders  | Make both paths identical             |