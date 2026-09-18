## Project Statement:


Relying on manual processes, paper records, or basic spreadsheets to manage bank accounts is typically slow, vulnerable to human error, and tough to properly audit. Routine actions like setting up a new account, making deposits, withdrawing cash, or viewing a balance, require a more reliable approach. 
This project directly addresses these challenges through a lightweight, command-line Bank Management System built to execute essential banking tasks accurately and consistently.

## Scope of the Project:


Currently Implemented:

Setting up new accounts (requires a unique account number, the account holder's name, and a starting deposit).

Processing deposits for active accounts.

Processing withdrawals, which includes a strict balance check to prevent overdrafts.

Retrieving the current balance for specific accounts.

Generating a complete overview of all accounts currently stored in the system.

Essential error handling and input validation (designed to catch duplicate account IDs, unregistered accounts, insufficient balances, and incorrect menu entries).

## Future Enhancements:



Data persistence (such as database integration or file-based storage), as the current iteration only holds data in memory while the program is running.

Security features including user logins, authentication, and multi-user access control.

Transitioning from a strictly command-line interface to a web application or graphical user interface (GUI).

Adding more complex financial products, such as interest calculation, loan management, and multi-currency support.

## Target Audience:


Peers and evaluators reviewing the project as a practical demonstration of core Java programming, command-line application structure, and modular software design.

Beginner programmers and hobbyists seeking a clean, self-contained reference on how to simulate basic banking workflows in code.

Instructors evaluating the implementation of input/output operations, application control flow, and functional decomposition within a menu-based program.

## High-Level Features:


Account Administration: Tools to seamlessly register new profiles and locate existing ones.

Transaction Handling: Secure methods for depositing and withdrawing funds from active accounts.

System Inquiries: Options to look up a specific user's balance or print out the entire account registry.

Menu-Driven Navigation: A continuous execution loop that allows the user to perform multiple actions until they explicitly choose to exit.

Robust Validation: Built-in safeguards that prevent logic errors from bad inputs, such as typos in menu choices, attempting to overdraw funds, or creating duplicate accounts.
