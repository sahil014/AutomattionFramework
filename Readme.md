# Java-Based Test Automation Framework
This is a **Java 17** based, modular **Test Automation Framework** built using **TestNG** and **Maven**.  
It supports **Data-Driven Testing**, **Parallel Execution**, **Cloud Execution on LambdaTest**, and **Headless Mode** for faster local runs.


## Author

- [@sahil014](https://github.com/sahil014)
- EmailAddress: sahilnarang014@gmail.com


## 🚀 About Me
Hii, my name is Sahil Narang and i have 8+ experience in automation testing using technologies like Selenium Webdriver, Rest Assured and Cypress.


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/sahil014)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/sahil-narang-22a352129)



## Prerequisites

Before running the tests, ensure you have following softwares installed on your system.
- **Java 17** -Make sure java is installed and the JAVA_HOME variable is set.
- **Maven** - Make sure maven is installed and added to the system path.
- Download Maven Link : https://maven.apache.org/download.cgi



## Key Features

- **Modular and Scalable**: Built using POM (Page Object Model).
- **Data-Driven Testing**: Supports reading data from CSV, Excel, or JSON files.
- **Parallel Execution**: Handled via TestNG configuration.
- **Cross-Browser Testing**: Supports Chrome, Firefox, Edge, etc.
- **LambdaTest Integration**: Run tests in the cloud on multiple OS/browser combinations.
- **Headless Mode**: Run tests faster without opening a browser UI.
- **Logging & Reporting**: Detailed logs using Log4j and visually rich reports via Extent Reports.


## 🧩 Tech Stack

| Component | Description |
|------------|-------------|
| **Language** | Java 17 |
| **Test Runner** | TestNG |
| **Build Tool** | Maven |
| **Data Handling** | OpenCSV, Gson, Apache POI |
| **Test Data Generation** | Faker Library |
| **Cloud Execution** | LambdaTest |
| **Reports** | Extent Reports |
| **Logging** | Log4j |
| **Execution Modes** | Local / Cloud / Headless |


## Installation

**Clone the Repository** :

- git clone https://github.com/sahil014/AutomattionFramework.git

- cd AutomattionFramework

## **Running tests on LambdaTest**

**Clone the Repository** :

- mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X

## **Running tests on local machine using chrome browser in headless mode**

**Clone the Repository** :

- mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X

## **Reporting & Logs**
🧾 Extent Report

After execution, the HTML report will be available at:
./report.html

- The report includes:

- Test execution summary

- Screenshots on failure

- Steps with timestamps

- Execution environment details

🧱 Log4j Logs

Log files are generated in: ./logs directory

## **Integrated the project with Github Actions**
This AutomattionFramework is intergrated with Github Actions and tests will be executed 7PM IST on 1st of every month.
The reports will be archived to gh-pages branch.
You can view the html report :- https://sahil014.github.io/AutomattionFramework/report.html 

    
    
