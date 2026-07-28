## Implementation Checkpoints

### Checkpoint A — Project + exceptions + model

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `java-bootcamp/examples/Lab7-ATMSystem/src/com/academy/atm/` exists | **Pass** / Fail |
| 2 | Four custom exceptions + `Account` + `transactions.txt` + `logs/` present | **Pass** / Fail |
| 3 | Seed accounts: `1001`/`1234`/$11000 and `1002`/`5678`/$5000 | **Pass** / Fail |
| 4 | Edited via IntelliJ (or optional VS Code) on your laptop | **Pass** / Fail |

### Checkpoint B — Service + Main compile

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `ATMService`, `LoggerUtil`, `Transaction`, `Main` present | **Pass** / Fail |
| 2 | `javac -d out src/com/academy/atm/*.java` succeeds | **Pass** / Fail |
| 3 | `java -cp out com.academy.atm.Main` from **project root** shows menu 1–7 | **Pass** / Fail |
| 4 | Exit prints `Thank You` and terminates | **Pass** / Fail |

### Checkpoint C — Exception behavior

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Withdraw more than balance (e.g. `20000` on `1001`) → Insufficient Balance; menu continues | **Pass** / Fail |
| 2 | Invalid amount / bad PIN / missing account produce ERROR messages (not crashes) | **Pass** / Fail |
| 3 | Invalid numeric input shows the Part 3 messages and continues | _**Pass**_ / Fail |
| 4 | `finally` prints return-to-menu text after operations | **Pass** / Fail |
| 5 | try-with-resources handles missing/unreadable `transactions.txt` with the IOException message | **Pass** / Fail |

### Checkpoint D — Logging + evidence

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `logs/application.log` contains ERROR (and ideally INFO) entries under the project root | **Pass** / Fail |
| 2 | Exception hierarchy notes filled; reflection drafted | **Pass** / Fail |
| 3 | Screenshots of success **and** failure paths saved (no secrets) | **Pass** / Fail |
