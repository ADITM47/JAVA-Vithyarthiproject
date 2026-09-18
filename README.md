## Bank Management System


A terminal-based Bank Management System built entirely in Java. It allows users to register accounts, handle deposits and withdrawals, view balances, and display a list of all active accounts using a simple command-line interface—meaning no database setup or graphical interface is needed.

## Overview


This application mimics the fundamental operations of a banking platform. Data is temporarily stored in memory while the application runs (it does not persist to a hard drive after closing), ensuring the project remains completely dependency-free and easy to launch straight from the terminal. The architecture combines three main components—Account Management, Transaction Processing, and Reporting—all housed within a single executable file, Bank.java, and navigated via a continuous menu loop.

## Features


Register a new bank account requiring a unique ID, the user's name, and an opening deposit.

Add funds to an active account.

Process cash withdrawals, complete with logic to block transactions if funds are insufficient.

View the current balance of a specific account.

Print a comprehensive list of all registered accounts along with their standing balances.

Basic error handling to prevent duplicate account IDs, flag unregistered accounts, and block overdrafts.

An interactive menu loop that continues execution until the user explicitly opts to quit.

## Technologies / Tools Used


Language: Core Java (pure Java implementation, zero external frameworks).

Compilation/Execution: Standard JDK command-line utilities (javac, java).

Interface: Terminal / Command Prompt via a text-driven menu.

Data Structure: Utilizes Java's ArrayList for in-memory storage, eliminating the need for database or file system integration.
## Project Structure

```
BankManagementSystem/
├── CODE (which comtains Bank.java)     # Entry point, menu loop, and workflow routing ('Account Management','Transaction Processing','',)
├── README.md
├── statement.md

```

## Prerequisites

- A Java Development Kit (JDK), version 8 or later, installed on your machine.
  - Check with: `java -version` and `javac -version`
  - If not installed, download it from
    [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or
    install the free [OpenJDK](https://openjdk.org/).
- A terminal / command prompt.
- No other dependencies, packages, or configuration files are required.

## Setup & Installation

1. **Get the project files.**
   Clone the repository:
   ```bash
   git clone <your-repository-url>
   cd BankManagementSystem
   ```

2. **Verify Java is installed.**
   ```bash
   java -version
   javac -version
   ```
   Both commands should print a version number. If either fails, install a
   JDK first (see Prerequisites above).

## Running the Project

1. **Compile all Java files** (run from inside the project folder, the same
   folder that contains `Bank.java`):
   ```bash
   javac  Bank.java
   ```
   This creates `.class` file for `Bank`, in the same folder.

2. **Run the program:**
   ```bash
   java Bank.java
   ```

3. **Use the menu.** You will see:
   ```
   Welcome to the Bank Management System!

   1. Create Account
   2. Deposit Money
   3. Withdraw Money
   4. Check Balance
   5. Show All Accounts
   6. Exit
   Enter your choice:
   ```
   Type a number (1–6) and press Enter, then follow the prompts for that
   option (account number, name, amount, etc.).

4. **Exit** by choosing option `6` at any time.

## Instructions for Testing

No testing framework is required — the program is verified manually by
running it and exercising each module through the menu:

1. Compile and run the program as described above.
2. **Test account creation (Module 1):**
   - Choose `1`, create an account (e.g. number `101`, name `Alice`, deposit `500`).
   - Choose `1` again with the **same** account number `101` — it should say
     "Account already exists."
3. **Test transactions (Module 2):**
   - Choose `2`, deposit `200` into account `101` — balance should become `700`.
   - Choose `3`, withdraw `1000` from account `101` — it should say
     "Insufficient balance."
   - Choose `3`, withdraw `200` from account `101` — balance should become `500`.
4. **Test reporting (Module 3):**
   - Choose `4`, check the balance of account `101` — it should print the
     current balance.
   - Choose `5` to list all accounts and confirm the details are correct.
5. **Test invalid input handling:**
   - Try option `4` or `1` with an account number that was never created —
     it should say "Account not found."
   - Enter an out-of-range menu choice (e.g. `7`) — it should say
     "Invalid choice. Please try again."
6. Choose `6` to exit and confirm the program terminates cleanly.

Since all data is stored in memory, restarting the program (`java Bank`)
always begins with zero accounts but this is expected behavior, not a bug.
