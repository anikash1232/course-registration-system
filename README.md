# Course Registration System

A simulation of UNC's ConnectCarolina registration flow in Java — registration windows
assigned by credit hours, two-factor authentication, and event check-in — built around
custom checked exceptions.

## What it does

Students are assigned a registration day based on how many credit hours they've earned,
the way real course registration staggers access by seniority. Before registering they
authenticate through a simulated Duo two-factor flow. Separately, students check in to
campus CLE events, and the system tracks which events each student has already scanned so
nobody double-registers attendance.

Each failure mode is its own exception type rather than a boolean return or a null:

- `DuoAuthenticationFailedException` — bad student ID, or authentication rejected
- `CLEEventNotFoundException` — check-in attempted against an unknown event
- `CLEAlreadyScannedException` — duplicate check-in for an event already recorded

## Architecture

```
Student                  name, ID, credit hours, scanned CLE events
Apprentice               core registration logic
Enchanter                adds validation and error handling
Sorcerer                 full implementation - registration windows, Duo auth, CLE scanning
AuthenticatorSimulation  driver

DuoAuthenticationFailedException
CLEEventNotFoundException        custom checked exceptions
CLEAlreadyScannedException
```

`Sorcerer.calculateValidDay(credits)` maps credit hours to a registration window and throws
`IllegalArgumentException` on nonsense input. `initStudents` catches those per-student so
one bad record doesn't abort the batch, and `duoAuthenticate` throws rather than returning a
flag — so a caller can't accidentally ignore a failed authentication by not checking a
return value.

## Running it

Requires Java 17+ and Maven.

```bash
mvn clean compile exec:java
```
