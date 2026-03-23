# TEYA - Tiny Ledger

## Description
A lightweight Spring Boot application that allows the user to record financial
transactions (deposits and withdrawals) and monitor the balance and transaction history.

## Getting Started
### Prerequisites
- Ensure you have Java 21 installed.
- Ensure Maven is installed.

### Running the Application
From the root directory of the project, execute the following commands in the specified order:

```Bash
mvn clean install
```
and then
```Bash
mvn spring-boot:run
```

The server will typically start on http://localhost:8080.

## API usage and examples
Below are examples on how to interact with the features using curl.

1. Record a Movement (Deposit/Withdrawal)
   To add a new transaction, send a POST request with the amount and type.

#### Deposit example:

macOS / Linux (cURL):

```Bash
curl -X POST http://localhost:8080/api/transaction \
-H "Content-Type: application/json" \
-d '{"amount": 500.00, "type": "DEPOSIT"}'
```

windows (PowerShell):

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/transaction" `
  -Method Post `
  -ContentType "application/json" `
  -Body '{"amount": 500.00, "type": "DEPOSIT"}'
```

##### Withdrawal example:

macOS / Linux (cURL):

```Bash
curl -X POST http://localhost:8080/api/transaction \
-H "Content-Type: application/json" \
-d '{"amount": 200.00, "type": "WITHDRAWAL"}'
```

windows (PowerShell):

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/transaction" `
  -Method Post `
  -ContentType "application/json" `
  -Body '{"amount": 200.00, "type": "WITHDRAWAL"}'
```

2. View current balance

macOS / Linux (cURL):

```Bash
curl -X GET http://localhost:8080/api/account/balance
```

windows (PowerShell):

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/account/balance" `
  -Method Get
```

3. View transaction history

macOS / Linux (cURL):

```Bash
curl -X GET http://localhost:8080/api/transaction/history
```

windows (PowerShell):

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/transaction/history" `
  -Method Get
```

4. Create Session

macOS / Linux (cURL):

```Bash
curl -X POST http://localhost:8080/api/session
```

windows (PowerShell):

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/session" `
  -Method Post
```

5. Rollback Session

macOS / Linux (cURL):

```Bash
curl -X POST http://localhost:8080/api/session/rollback
```

windows (PowerShell):

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/session/rollback" `
  -Method Post
```

6. Commit Session

macOS / Linux (cURL):

```Bash
curl -X POST http://localhost:8080/api/session/commit
```

windows (PowerShell):

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/session/commit" `
  -Method Post
```

## Assumptions
Throughout the code comments started by `"ASSUMPTION:"` can be found. Their purpose is to give context on why certain
decisions were made, most of them to simplify the project.

- Assumption 1 - On the /api/transaction/history endpoint I ignored the pagination for simplicity
- Assumption 2 - I created an `Account` domain to handle balance fetching
- Assumption 3 - Only one repository entity was created (ignored the repository for `Account`, created only for `Transaction`) 
- Assumption 4 - TransactionType is used both for internal and external domain 

## Testing
The application has no automated tests, as it was not a requirement for the exercise.