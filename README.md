

Software Pre-requisites: 
java 11
Maven
git

Build: mvn clean install.

Run: java -jar ./target/loan-services-spring-boot.jar

Database is created under user_home/db/loandb, ex C:/users/example_user/db/loandb.mv.db

Usage notes:

Curl command (windows bash shell) or linux

1.	Get loan balance
curl http://localhost:8080/banking/loan/balance/123

2) Add a new loan to database

curl -i -X POST -d '{"customerId":"123","loanAmount":"5000.00","customerName":"John Doe"}' -H "Content-Type:application/json" http://localhost:8080/banking/loan/create

Alternative usage options:

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
