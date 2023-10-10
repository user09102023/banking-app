Please NOTE: This is not a real-life project and these are not real-life requirements

Pre-requisites: 
java 11, java executable on Path variable.
Maven and access to repos with required dependencies.

Build: run maven-build.bat from the project root directory.

Run: run example-start.bat - runs as stand-alone executable jar.

Usage notes:
Sending create loan post request should be done via Postman or alternative with Content-Type set to application/json.

http://localhost:8080/banking/loan/create
Sample json create loan request:
{
"customerId": "123",
"loanAmount": "5000.00",
"customerName": "John Doe"
}

Getting total loan amounts can be done via the browser:
http://localhost:8080/banking/loan/balance/123

