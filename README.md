# IWD Redefine Possible - Software Testing & Quality Assurance

## Overview
This repository contains the test suite for the SauceDemo website (https://www.saucedemo.com/), focusing on manual and automated testing to ensure the quality of core functionalities, including login, product listing, product details, cart operations, checkout process, and logout. The project is part of the IWD Redefine Possible initiative for Software Testing & Quality Assurance.

## Repository Structure
- **Test Cases**: `SauceDemo Test Cases.xlsx`
  - Contains manual test cases (TC_001 to TC_006) covering login, product listing, product details, add to cart, checkout, and logout functionalities.
  - Each test case includes TC ID, summary, description, preconditions, test steps, test data, expected results, actual results, status, and type (manual/automated).
  
- **Test Plan**: `SauceDemo_Test Plan.docx`
  - Outlines the testing strategy, scope, objectives, tasks, test environment, deliverables, schedule, risks, and mitigation strategies.
  - Prepared by Rawan Ellsayed, dated May 1, 2025, with a focus on functional, UI, and negative testing.

- **Automation Code**:
  - **`LoginPage.java`**: Page Object Model (POM) class for login functionality, handling username, password input, and login button click.
  - **`ProductsPage.java`**: POM class for product page interactions, including adding a product (Sauce Labs Backpack) to the cart and navigating to the cart.
  - **`CheckoutPage.java`**: POM class for checkout process, covering checkout initiation, filling user information, and completing the order.
  - **`LoginTest.java`**: TestNG test suite for automated testing of login, adding a product to the cart, navigating to the cart, and completing the checkout process using Selenium WebDriver with Chrome.

## Prerequisites
- **Java**: JDK 8 or higher
- **Selenium WebDriver**: For browser automation
- **TestNG**: For test execution and reporting
- **WebDriverManager**: For managing browser drivers (e.g., ChromeDriver)
- **Browsers**: Chrome, Firefox, Safari, Edge (as specified in the test plan)
- **Network**: Stable 4G or WiFi connection

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Merrn60/IWD-Redefine-possible--Software-Testing-Quality-assurance.git
