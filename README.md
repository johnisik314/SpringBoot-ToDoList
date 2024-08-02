
# Spring Boot To-Do List Application

This Spring Boot application provides a simple web-based To-Do List. Users can add, edit, and delete tasks directly from their browser. The application persists to-do items in a text file on the server, ensuring that the list is saved across sessions.

## Features

- **Add To-Do Items**: Add items to your to-do list and see them appear instantly.
- **Edit To-Do Items**: Click the edit button next to any item to change its text.
- **Delete To-Do Items**: Remove items from the list using the delete button.
- **Persistence**: All items are stored in a text file, preserving the list even when the server restarts.

## Prerequisites

Before you can run this application, you'll need the following installed on your machine:

- Java JDK 11 or newer
- Maven (to build and run the application)

## Setup Instructions

1. **Clone the Repository**:
   \```bash
   git clone https://github.com/johnisik314/SpringBoot-ToDoList.git
   \cd SpringBoot-ToDoList
   \```

2. **Build the Application**:
   Use Maven to build the application:
   \```bash
   mvn clean install
   \```

3. **Run the Application**:
   Start the application using Spring Boot's Maven plugin:
   \```bash
   mvn spring-boot:run
   \```
   The application will be available at `http://localhost:8080/`.

4. **Accessing the Application**:
   Open a web browser and navigate to `http://localhost:8080/` to start using the To-Do List.

## Application Structure

- **DemoApplication.java**: The main class that runs the Spring Boot application and contains all endpoints and business logic.
- **index.html**: The frontend HTML file located in `src/main/resources/templates`, which displays the To-Do list and includes forms for adding, editing, and deleting items.
- **text.txt**: The text file used for persistence, located at `C:/Users/johni/Desktop/demo/demo/src/main/resources/text.txt`.

## Editing the File Path

The current setup uses a static file path for the to-do list text file. If you wish to change the file path, edit the `FILE_PATH` variable in `DemoApplication.java`:
\```java
private static final String FILE_PATH = ".../demo/demo/src/main/resources/text.txt";
\```
Adjust this path as needed to fit your file system structure.
