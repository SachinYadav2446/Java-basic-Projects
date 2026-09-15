# Java Basic Projects - Complete Guide

A comprehensive collection of 12 progressively challenging Java projects designed to build your skills from basic fundamentals to Object-Oriented Programming (OOP) concepts.

---

## 📚 Project Structure Overview

### **Level 1: Basics (Projects 1-3)**
Learn fundamental Java concepts and how programs work.

### **Level 2: Control Flow & Functions (Projects 4-6)**
Master methods, control structures, and algorithms.

### **Level 3: Collections & Algorithms (Projects 7-9)**
Work with data structures, collections, and classic algorithms.

### **Level 4: OOP Fundamentals (Projects 10-12)**
Build applications using classes, inheritance, and polymorphism.

---

## 🎯 Project Details

### **Project 1: Hello World & Console IO**
**Location:** `01_HelloWorld/HelloWorld.java`

**Concepts:**
- Basic Java syntax and structure
- Variables and primitive data types (int, double, String, boolean)
- Console output (System.out.println)
- Console input (Scanner class)
- Type casting
- String concatenation

**What you'll learn:**
- How to write and run a basic Java program
- Working with different data types
- Reading user input interactively
- Performing basic calculations

**Run:** 
```bash
cd 01_HelloWorld
javac HelloWorld.java
java HelloWorld
```

---

### **Project 2: Calculator**
**Location:** `02_Calculator/Calculator.java`

**Concepts:**
- Conditional statements (if-else-if, switch)
- Arithmetic operations (+, -, *, /, %)
- Switch statements for menu selection
- Input validation
- Method decomposition (breaking code into functions)

**What you'll learn:**
- Making decisions based on user input
- Implementing multiple operations
- Error handling (e.g., division by zero)
- Organizing code with methods

**Run:**
```bash
cd 02_Calculator
javac Calculator.java
java Calculator
```

**Example:**
```
Enter first number: 10
Enter second number: 5
1. Addition (+)
2. Subtraction (-)
3. Multiplication (*)
...
Result: 10 + 5 = 15
```

---

### **Project 3: Number Guessing Game**
**Location:** `03_GuessingGame/GuessingGame.java`

**Concepts:**
- Loops (while loop)
- Random number generation (Math.random())
- Conditional logic and comparisons
- Loop control (break)
- Game logic and user experience
- Input validation

**What you'll learn:**
- Creating interactive loops
- Generating random numbers
- Providing user feedback
- Implementing win/lose conditions
- Calculating scores

**Run:**
```bash
cd 03_GuessingGame
javac GuessingGame.java
java GuessingGame
```

---

### **Project 4: Temperature Converter**
**Location:** `04_TemperatureConverter/TemperatureConverter.java`

**Concepts:**
- Method creation and reusability
- Parameter passing to methods
- Return values from methods
- Type conversion
- Mathematical formulas
- String formatting (String.format)

**What you'll learn:**
- Writing reusable methods
- Implementing mathematical conversions
- Creating menu-driven applications
- Formatting decimal output

**Key Methods:**
```java
convertCelsiusToFahrenheit(double celsius)
convertFahrenheitToCelsius(double fahrenheit)
convertCelsiusToKelvin(double celsius)
```

**Run:**
```bash
cd 04_TemperatureConverter
javac TemperatureConverter.java
java TemperatureConverter
```

---

### **Project 5: Grade Management System**
**Location:** `05_GradeManagement/GradeManagement.java`

**Concepts:**
- Arrays for storing multiple values
- For loops and enhanced for loops
- Array manipulation and searching
- Calculating statistics (average, min, max)
- Multiple related methods
- Data aggregation

**What you'll learn:**
- Working with arrays of data
- Finding maximum and minimum values
- Calculating averages
- Grade distribution analysis
- Displaying formatted tables

**Features:**
- Store and display student grades
- Calculate class statistics
- Find top student
- Analyze grade distribution (A, B, C, D, F)

**Run:**
```bash
cd 05_GradeManagement
javac GradeManagement.java
java GradeManagement
```

---

### **Project 6: Prime Number Checker**
**Location:** `06_PrimeChecker/PrimeChecker.java`

**Concepts:**
- Nested loops
- Mathematical algorithms
- Optimization techniques (checking up to sqrt)
- ArrayList collections
- Complex conditional logic
- Handling edge cases

**What you'll learn:**
- Implementing mathematical algorithms
- Optimizing loop conditions
- Finding prime numbers efficiently
- Calculating prime factors
- Understanding time complexity

**Key Algorithms:**
- Prime checking: O(√n) complexity
- Prime factorization
- Range searching

**Run:**
```bash
cd 06_PrimeChecker
javac PrimeChecker.java
java PrimeChecker
```

---

### **Project 7: To-Do List Application**
**Location:** `07_TodoList/TodoList.java`

**Concepts:**
- ArrayList for dynamic storage
- CRUD operations (Create, Read, Update, Delete)
- Custom classes (Task class)
- Menu-driven applications
- Data persistence in memory
- Searching and filtering

**What you'll learn:**
- Using ArrayList instead of arrays
- Adding/removing/modifying items dynamically
- Building interactive applications
- Creating custom data classes
- Displaying formatted output

**Features:**
- Add, view, complete, delete tasks
- Prioritize tasks (High, Medium, Low)
- View completion statistics
- Task search

**Run:**
```bash
cd 07_TodoList
javac TodoList.java
java TodoList
```

---

### **Project 8: Simple Bank System**
**Location:** `08_BankSystem/SimpleBankSystem.java`

**Concepts:**
- ArrayList of custom objects
- State management (maintaining balance)
- Complex business logic
- Finding specific items in collections
- Transaction management
- Data validation

**What you'll learn:**
- Managing multiple objects
- Implementing transactions
- Validating business rules
- Searching through collections
- Maintaining data integrity

**BankAccount Class:**
- Account number, holder name, balance
- Deposit and withdraw methods
- Balance tracking

**Features:**
- Create multiple accounts
- Deposit and withdraw money
- Check balance
- View all accounts
- Sample data pre-loaded

**Run:**
```bash
cd 08_BankSystem
javac SimpleBankSystem.java
java SimpleBankSystem
```

---

### **Project 9: Sorting & Searching Algorithms**
**Location:** `09_SortingSearching/SortingSearching.java`

**Concepts:**
- Bubble Sort algorithm (O(n²))
- Selection Sort algorithm (O(n²))
- Merge Sort algorithm (O(n log n))
- Linear Search (O(n))
- Binary Search (O(log n))
- Algorithm analysis and comparison
- Time complexity concepts

**What you'll learn:**
- Implementing classic algorithms
- Comparing algorithm efficiency
- Understanding Big O notation
- Choosing appropriate algorithms
- Performance measurement

**Algorithms Included:**
1. **Sorting:**
   - Bubble Sort: Simple, O(n²)
   - Selection Sort: Simple, O(n²)
   - Merge Sort: Efficient, O(n log n)

2. **Searching:**
   - Linear Search: Works on unsorted, O(n)
   - Binary Search: Fast, requires sorted array, O(log n)

**Run:**
```bash
cd 09_SortingSearching
javac SortingSearching.java
java SortingSearching
```

---

### **Project 10: Bank Account Manager (OOP)**
**Location:** `10_BankAccountOOP/BankAccountManager.java`

**Concepts:**
- Classes and objects (Object creation)
- Encapsulation (private/public access modifiers)
- Constructors
- Getters and setters
- Instance variables and methods
- Method overloading concepts
- Transaction tracking

**What you'll learn:**
- Designing clean class structures
- Hiding internal data (encapsulation)
- Creating and using objects
- Maintaining object state
- Tracking transaction history

**BankAccountOOP Class:**
- Private fields for encapsulation
- Constructor for initialization
- Public methods for operations
- Transaction history tracking

**Features:**
- Create bank accounts with OOP principles
- Deposit, withdraw, transfer money
- Calculate interest
- View transaction history
- Account statistics

**Run:**
```bash
cd 10_BankAccountOOP
javac BankAccountManager.java
java BankAccountManager
```

---

### **Project 11: Library Management System (Inheritance & Polymorphism)**
**Location:** `11_LibrarySystem/LibraryManagementSystem.java`

**Concepts:**
- Inheritance (IS-A relationship)
- Polymorphism (method overriding)
- Abstract classes and abstract methods
- Subclasses extending base classes
- Superclass and subclass relationships
- Method overriding (@Override)
- Composition (HAS-A relationship)

**What you'll learn:**
- Creating class hierarchies
- Designing base and derived classes
- Implementing polymorphic behavior
- Code reusability through inheritance
- Designing extensible systems

**Class Hierarchy:**
```
Book (abstract base class)
├── PrintedBook
├── EBook
└── AudioBook

Member (manages borrowed books)
```

**Key Concepts:**
- Abstract methods that must be implemented by subclasses
- Each book type has specific properties
- Polymorphism: call displayDetails() on any Book type
- Members can borrow and return different book types

**Features:**
- Add different types of books
- Borrow and return books
- Track member's borrowed books
- Search books by title or author
- View detailed book information

**Run:**
```bash
cd 11_LibrarySystem
javac LibraryManagementSystem.java
java LibraryManagementSystem
```

---

### **Project 12: E-Commerce Product Catalog (Advanced OOP)**
**Location:** `12_ECommerceProductCatalog/ECommerceSystem.java`

**Concepts:**
- Multiple classes working together (composition)
- HAS-A relationships
- Advanced encapsulation and data hiding
- Complex business logic across classes
- Collections of complex objects
- System design principles
- Real-world application modeling

**What you'll learn:**
- Designing complex systems
- Composition over inheritance
- Managing multiple interacting classes
- Building scalable applications
- Real-world e-commerce concepts

**Classes in the System:**
1. **Product** - Individual product representation
2. **Catalog** - Collection of products with search
3. **CartItem** - Item in shopping cart
4. **ShoppingCart** - User's cart with CRUD operations
5. **Order** - Customer order
6. **OrderHistory** - Track all orders
7. **ECommerceSystem** - Main system controller

**Key Relationships:**
```
Product (basic unit)
    └─ Catalog (many products)
        └─ ShoppingCart (multiple cart items)
            └─ Order (order from cart)
                └─ OrderHistory (track orders)
```

**Features:**
- Browse product catalog
- Search products
- Add/remove items from cart
- Update quantities
- Checkout and create orders
- View order history
- Complex system interactions

**Run:**
```bash
cd 12_ECommerceProductCatalog
javac ECommerceSystem.java
java ECommerceSystem
```

---

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line/terminal access
- Text editor or IDE

### Installation & Setup

1. **Navigate to project directory:**
   ```bash
   cd "c:\Users\yadav\OneDrive\Desktop\java_basic_projects\Java-basic-Projects"
   ```

2. **Compile a project:**
   ```bash
   cd 01_HelloWorld
   javac HelloWorld.java
   ```

3. **Run the program:**
   ```bash
   java HelloWorld
   ```

### General Flow for Any Project

```bash
# 1. Go to project directory
cd XX_ProjectName

# 2. Compile all Java files
javac *.java

# 3. Run the main class
java MainClassName
```

---

## 📖 Learning Path

### Week 1-2: Fundamentals (Projects 1-3)
- Understand basic syntax
- Practice input/output
- Learn control flow

### Week 3-4: Methods & Functions (Projects 4-6)
- Write reusable methods
- Implement algorithms
- Solve problems with logic

### Week 5-6: Data Structures (Projects 7-9)
- Work with collections
- Implement sorting/searching
- Handle multiple data

### Week 7-8: OOP Basics (Project 10)
- Write your first classes
- Understand encapsulation
- Work with objects

### Week 9-10: Inheritance (Project 11)
- Extend classes
- Implement polymorphism
- Design hierarchies

### Week 11-12: Complex Systems (Project 12)
- Combine multiple concepts
- Build real-world applications
- Design scalable systems

---

## 🎓 Key Concepts Summary

| Concept | Introduced | Project |
|---------|-----------|---------|
| Variables & Data Types | 1 | HelloWorld |
| Control Flow (if/else) | 2 | Calculator |
| Loops (while, for) | 3 | GuessingGame |
| Methods | 4 | TemperatureConverter |
| Arrays | 5 | GradeManagement |
| Algorithms | 6, 9 | PrimeChecker, Sorting |
| ArrayList | 7 | TodoList |
| Custom Classes | 8 | BankSystem |
| Encapsulation | 10 | BankAccountOOP |
| Inheritance | 11 | LibrarySystem |
| Polymorphism | 11 | LibrarySystem |
| Composition | 12 | ECommerce |

---

## 💡 Tips for Success

1. **Understand before copying:** Read and understand each line of code
2. **Modify and experiment:** Change values and see what happens
3. **Add features:** Try to add your own features to projects
4. **Test edge cases:** Think about what could break your code
5. **Document your code:** Add comments explaining logic
6. **Practice frequently:** Coding skill comes from practice
7. **Read errors carefully:** Error messages tell you what's wrong
8. **Compare implementations:** Look at how different projects solve problems

---

## 🔧 Compilation & Execution Troubleshooting

### Issue: "javac command not found"
**Solution:** Install JDK or add Java to system PATH

### Issue: "Class not found"
**Solution:** Make sure you're in the correct directory and class name matches file name

### Issue: "Cannot find symbol"
**Solution:** Check variable names and method names for typos

### Issue: "Multiple public classes"
**Solution:** Each file should have at most one public class

---

## 📝 Code Quality Guidelines

1. **Follow Naming Conventions:**
   - Classes: PascalCase (HelloWorld)
   - Methods/Variables: camelCase (myVariable)
   - Constants: UPPER_CASE (MAX_SIZE)

2. **Add Comments:**
   ```java
   // Single line comment
   
   /**
    * Multi-line comment (JavaDoc)
    * Used for classes and methods
    */
   ```

3. **Write Clean Methods:**
   - One method = one responsibility
   - Clear, descriptive names
   - Reasonable length (fits on screen)

4. **Handle Errors:**
   - Validate user input
   - Check for null values
   - Use try-catch when appropriate

---

## 🎯 Next Steps After Completing All Projects

1. **Build your own projects** using these concepts
2. **Explore frameworks** like Spring Boot
3. **Learn about databases** and SQL
4. **Study design patterns** (Singleton, Factory, etc.)
5. **Practice on coding websites** (LeetCode, HackerRank)
6. **Contribute to open source** Java projects

---

## 📚 Additional Resources

- Java Official Documentation: https://docs.oracle.com/javase/
- Tutorialspoint Java: https://www.tutorialspoint.com/java/
- Oracle Java Tutorials: https://docs.oracle.com/javase/tutorial/
- GeeksforGeeks Java: https://www.geeksforgeeks.org/java/

---

## ✅ Checklist for Each Project

- [ ] Read the project description
- [ ] Understand all concepts introduced
- [ ] Compile successfully without errors
- [ ] Run and test with provided examples
- [ ] Modify and add your own features
- [ ] Test with edge cases
- [ ] Add comments to your code
- [ ] Move to the next project

---

**Happy Coding! 🚀**

This progressive learning path will help you develop a strong foundation in Java and OOP concepts. Each project builds upon previous knowledge, ensuring steady skill development.
