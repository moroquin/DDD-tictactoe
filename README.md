# DDDTicTacToe

A Domain-Driven Design (DDD) implementation of Tic-Tac-Toe game in Java.

## Prerequisites

Before you can compile and run this project, make sure you have the following installed:

- **Java Development Kit (JDK) 8 or higher**
  - Check your Java version: `java -version`
  - Check your Java compiler version: `javac -version`
- **Apache Maven 3.6.0 or higher**
  - Check your Maven version: `mvn -version`

## Project Structure

```
DDDTicTacToe/
├── pom.xml                 # Maven configuration file
├── src/
│   ├── main/
│   │   └── java/
│   │       └── tictactoe/
│   │           └── Main.java    # Main application entry point
│   └── test/
│       └── java/           # Test files
├── target/                 # Compiled classes and build artifacts
└── README.md              # This file
```

## Compilation

### Using Maven (Recommended)

1. **Clean and compile the project:**
   ```bash
   mvn clean compile
   ```

2. **Compile and package into JAR:**
   ```bash
   mvn clean package
   ```

3. **Compile and run tests:**
   ```bash
   mvn clean test
   ```

### Using Java directly (Alternative)

1. **Compile the source files:**
   ```bash
   javac -d target/classes src/main/java/tictactoe/*.java
   ```

## Execution

### Using Maven

1. **Run the main class using Maven:**
   ```bash
   mvn exec:java -Dexec.mainClass="tictactoe.Main"
   ```

2. **Run the packaged JAR file:**
   ```bash
   # First package the project
   mvn clean package
   
   # Then run the JAR
   java -jar target/DDDTicTacToe-1.0-SNAPSHOT.jar
   ```

### Using Java directly

1. **Run from compiled classes:**
   ```bash
   # Make sure you've compiled first
   java -cp target/classes tictactoe.Main
   ```

## Development Workflow

### Common Maven Commands

- **Clean build artifacts:**
  ```bash
  mvn clean
  ```

- **Compile source code:**
  ```bash
  mvn compile
  ```

- **Run tests:**
  ```bash
  mvn test
  ```

- **Package into JAR:**
  ```bash
  mvn package
  ```

- **Install to local repository:**
  ```bash
  mvn install
  ```

### IDE Setup

This project can be imported into any Java IDE that supports Maven:

- **IntelliJ IDEA:** File → Open → Select the project directory
- **Eclipse:** File → Import → Existing Maven Projects
- **VS Code:** Open the project folder (with Java Extension Pack installed)

## Testing

Run the test suite using:

```bash
mvn test
```

The project uses JUnit 3.8.1 for testing. Test files are located in `src/test/java/`.

## Building for Production

To create a production-ready JAR file:

```bash
mvn clean package
```

The compiled JAR will be available in the `target/` directory as `DDDTicTacToe-1.0-SNAPSHOT.jar`.

## Troubleshooting

### Common Issues

1. **"mvn command not found"**
   - Make sure Maven is installed and added to your PATH

2. **"JAVA_HOME not set"**
   - Set the JAVA_HOME environment variable to your JDK installation directory

3. **Compilation errors**
   - Ensure you're using Java 8 or higher
   - Check that all dependencies are properly resolved with `mvn dependency:resolve`

### Getting Help

- Check Maven logs for detailed error messages
- Verify your Java and Maven versions match the prerequisites
- Ensure your JAVA_HOME environment variable is correctly set

## License

This project is licensed under the terms specified in the LICENSE file.
