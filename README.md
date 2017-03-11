Users application back-end

Requirements

install Java 1.7 or higher

install tomcat 8.x or higher

install mysql 5.7.17 or higher

Build & development

To start a project use: git clone https://github.com/erizoo/snet-2.0

cd user-app

mvn clean install

java -jar target/dependency/by.webapp-runner.jar target/*.war

project will be available on http://localhost:8080/users

Preview

https://snet2.herokuapp.com/

Specification

https://docs.google.com/document/d/1YB5Ow1lHN82gWVCLLsBPHrFJ67o5Oh-8laBbWgSic2c/