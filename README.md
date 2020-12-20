# Spring Boot BankAccount Rest API

BankAccountAPI allows users to perform CRUD transactions on a simple bank application.

### Dependencies
Java 11.0.9, Maven

### Setup
1.Clone the application
```sh
$ git clone git@github.com:ozgurutku/SpringBoot-BankAccountAPI.git
```
2.Build and run the app using maven
```sh
$ mvn spring-boot:run
```
The app will start running at http://localhost:8080.

### Usage
```sh
GET /getAllAccount

GET /searchById/{id}

GET /searchByName/{name}

POST /create

PUT /update/{id}

DELETE /delete/{id}
```