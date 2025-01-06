# Password Manager Application

A secure and user-friendly console-based Password Manager application. This tool allows you to manage your passwords, generate strong passwords, and access them securely using a PIN-based authentication system.

## Features

- **Secure Authentication**:
  - Setup and manage a secure PIN for accessing the password manager.
  - Passwords are encrypted for enhanced security.

- **Password Management**:
  - Add, edit, and delete password entries with associated usernames and locations.
  - View a list of stored passwords.

- **Password Generation**:
  - Generate strong passwords with customizable options for length and character sets (uppercase, digits, special characters).
  - Save generated passwords for future use.

- **Persistent Storage**:
  - Passwords are stored in a local file for future retrieval.

## The Group

- Nima Vakiliazar (B2405.090178)

- Ahmed Bakrsedqi (B2405.090238)

- Muhammad Abdulmajeed (B2405.090005)

- Dicle Yıldız (B2305.090240)

- Imaad Khan (B2405.090259)

## Programming Language

Language used is Java. 

## How to Use

### 1. Start the Application
Run the application to display the main menu.

### 2. Main Menu
The main menu offers the following options:
- **1. Manager**: Access the password management module.
- **2. Generator**: Create a new password.
- **0. Exit**: Quit the application.

### 3. Manager Module
- **First-time Setup**:
  - If using the application for the first time, set up a secure PIN.
- **Authentication**:
  - Enter the PIN to access the manager module.
- **Features**:
  - **Add Entry**: Save a username, password, and location.
  - **Edit Entry**: Modify an existing entry.
  - **Delete Entry**: Remove an entry.
  - **View Stored Passwords**: Display all saved entries.

### 4. Password Generator
- Specify the desired password length.
- Choose character preferences:
  - Include uppercase letters.
  - Include digits.
  - Include special characters.
- Generate a password and optionally save it with a username and location.

### 5. Exit
- Select "0" from the main menu to exit the application.

## Project Structure

The project consists of the following classes:
- **Main**: Entry point of the application.
- **Interfaces**: Handles user interactions and menu displays.
- **Authenticator**: Manages PIN setup and authentication.
- **Generator**: Generates strong passwords based on user preferences.
- **Encryptor**: Encrypts and compares sensitive data such as PINs.
- **Storage**: Handles saving, updating, and retrieving password entries from a file.

## Requirements
- Java Development Kit (JDK) 8 or higher.
- A Java IDE or command-line environment.

## Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/password-manager.git
   
2. Navigate to the project directory:

cd password-manager

3. Compile the project:

javac -d bin src/mainPack/*.java

4. Run the application:

java -cp bin mainPack.Main
