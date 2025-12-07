# BrowserTest Automation Project

This project demonstrates a **Selenium-based automated testing framework** for a web application deployed in a QA environment. It integrates with Java, JUnit, and ChromeDriver using WebDriverManager, with robust handling for environments that take time to load.

---

## Project Overview

The main goal of this project is to automate testing of a web application, ensuring that the **QA environment is fully ready** before executing any assertions. The automation framework is designed to handle delays in web app deployment using **timeout polling**, making it reliable and robust.

---

## Features

- Automated browser testing with Selenium WebDriver in headless mode.  
- Environment readiness checks with polling to handle slow deployments.  
- JUnit integration for structured assertions.  
- WebDriverManager integration to manage ChromeDriver automatically.  
- CI/CD ready for integration into Azure DevOps pipelines for automated testing.  

---


## Key Points & Lessons Learned

1. **Timeout polling is critical:**  
   When a new WAR file is built and deployed to the QA environment, the application may take some time to reflect the updates. Without polling and retries in the test scripts, tests can fail. Adding wait intervals ensures the scripts run reliably once the environment is fully updated.

2. **Headless browser execution:**  
   Tests run efficiently in CI/CD pipelines without needing a visible browser.  

3. **CI/CD integration:**  
   This test framework can be integrated into Azure DevOps pipelines, enabling automated QA checks after each build and reducing manual testing.  

4. **Environment readiness checks:**  
   Scripts include a mechanism to wait for the QA environment to fully load before performing assertions, ensuring robustness.  

---

## How to Run

1. locally we can test using - mvn clean test
2. once configured in Azure DevOps, the automation scripts run automatically after deployment to the QA environment.
