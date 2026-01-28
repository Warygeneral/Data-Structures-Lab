# 📘 JAVA COMPLETE REVISION NOTES
## OOPs, Exception Handling, Threads, JDBC, Collections, Generics & Servlets

**Exam-Focused | Question-Aligned | Code-Ready**

---

# TABLE OF CONTENTS

1. [OOPs & Exception Handling](#oops--exception-handling)
2. [Threads & Multithreading](#threads--multithreading)
3. [JDBC - Java Database Connectivity](#jdbc---java-database-connectivity)
4. [Collections, Wrapper Classes & Generics](#collections-wrapper-classes--generics)
5. [Java Servlets](#java-servlets)

---

---

# OOPs & EXCEPTION HANDLING

## 1️⃣ Characteristics of OOP (Very Important)

OOP is based on **four pillars**:

1. **Encapsulation** - Data hiding
2. **Inheritance** - Acquiring properties
3. **Polymorphism** - One name, many forms
4. **Abstraction** - Hiding implementation

---

## 2️⃣ Polymorphism

👉 *One name, many forms*

### Types of Polymorphism:

1. **Compile-time Polymorphism** (Method Overloading)
2. **Run-time Polymorphism** (Method Overriding)

---

### 🔹 Compile-time Polymorphism → Method Overloading

#### Method Overloading

Same method name but:
* Different number of parameters OR
* Different data types

```java
class MathOp {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}
```

🧠 **Rules:**
* Return type alone cannot overload
* Happens at compile time
* Parameter order/type/count must differ

---

## 3️⃣ Constructors

👉 Constructor is used to **initialize objects**
* Constructor name = Class name
* No return type
* Automatically called when object is created

```java
class Student {
    int id;
    String name;

    Student() {
        id = 0;
        name = "NA";
    }
}
```

---

### 🔹 Constructor Overloading

Multiple constructors with different parameters.

```java
class Student {
    int id;
    String name;

    // Default Constructor
    Student() {
        id = 0;
        name = "NA";
    }

    // Parameterized Constructor
    Student(int i, String n) {
        id = i;
        name = n;
    }
}
```

---

## 4️⃣ `this` Keyword

👉 Refers to **current object**

### Uses of `this`:

1. Differentiate instance & local variables
2. Call another constructor (Constructor chaining)
3. Pass current object as parameter

```java
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;           // Differentiating
        this.name = name;
    }
    
    void display() {
        System.out.println(this.id);
    }
}
```

---

## 5️⃣ `static` Keyword

Belongs to **class**, not object.

### Can be:
* static variable
* static method
* static block

```java
class Test {
    static int x = 10;         // Class variable
    int y = 20;                // Instance variable

    static void show() {       // Class method
        System.out.println(x);
    }
    
    static {                   // Static block
        System.out.println("Executes once when class loads");
    }
}
```

🧠 **Rules:**
* Static method cannot use non-static data directly
* Static block executes **once** when class loads
* Static variables are shared among all objects

---

## 6️⃣ Inheritance

👉 One class acquires properties of another class
👉 Uses `extends` keyword

```java
class A {                      // Parent/Super class
    int x = 10;
}

class B extends A {            // Child/Sub class
    int y = 20;
}
```

---

### 🔹 Types of Inheritance in Java

| Type         | Supported | Example |
| ------------ | --------- | ------- |
| Single       | ✅        | B extends A |
| Multilevel   | ✅        | C extends B extends A |
| Hierarchical | ✅        | B,C both extend A |
| Multiple     | ❌ (via class) | NOT allowed with classes |
| Hybrid       | ❌ (via class) | NOT allowed with classes |

✔️ **Multiple inheritance is supported using interface**

---

## 7️⃣ `super` Keyword

Used to:
1. Access parent class variable
2. Call parent class method
3. Call parent class constructor

```java
class A {
    int x = 10;
    
    void show() {
        System.out.println("Parent");
    }
}

class B extends A {
    int x = 20;

    void show() {
        System.out.println(super.x);        // Access parent variable
        super.show();                        // Call parent method
    }
}
```

---

## 8️⃣ Method Overriding (Run-time Polymorphism)

👉 Same method name + same parameters in inheritance
👉 Decided at runtime based on object type

```java
class A {
    void show() {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    void show() {
        System.out.println("B");
    }
}

class Test {
    public static void main(String[] args) {
        A obj = new B();       // Reference of A, object of B
        obj.show();            // Calls B's show() - Runtime polymorphism
    }
}
```

🧠 **Rules:**
* Method signature must be same
* Cannot reduce visibility (public → private not allowed)
* Return type can be covariant (subclass)
* Achieves runtime/dynamic polymorphism

---

## 9️⃣ Abstract Class

👉 A class that **cannot be instantiated**
👉 Can have abstract + non-abstract methods

```java
abstract class Shape {
    abstract void area();          // Abstract method
    
    void display() {               // Non-abstract method
        System.out.println("Shape");
    }
}

class Circle extends Shape {
    @Override
    void area() {
        System.out.println("Area of circle");
    }
}
```

🧠 **Key Points:**
* Cannot create object: `Shape s = new Shape();` ❌
* Can have constructors
* Can have instance variables
* Child class MUST implement all abstract methods

---

## 🔟 Interface

👉 Used to achieve **100% abstraction**
👉 Supports multiple inheritance

```java
interface Shape {
    void area();
    void perimeter();
}

interface Drawable {
    void draw();
}

class Circle implements Shape, Drawable {
    public void area() {
        System.out.println("Area");
    }
    
    public void perimeter() {
        System.out.println("Perimeter");
    }
    
    public void draw() {
        System.out.println("Drawing");
    }
}
```

🧠 **Abstract Class vs Interface:**

| Feature | Abstract Class | Interface |
| ------- | -------------- | --------- |
| Constructors | ✅ Can have | ❌ Cannot have |
| Instance variables | ✅ Can have | ❌ Only static/final |
| Methods | Mixed abstract + concrete | All abstract (Java 8+: default/static) |
| Inheritance | Single (extends) | Multiple (implements) |
| Abstraction | Partial (0-100%) | Full (100%) |
| Access | public, protected, private | Only public |

---

# ⚠️ EXCEPTION HANDLING (VERY IMPORTANT)

---

## 1️⃣ What is an Exception?

👉 An unwanted event that interrupts program execution.

**Exceptions prevent abrupt program termination.**

---

## 2️⃣ Exception Hierarchy

```
Throwable (Base class for all throwables)
 ├── Exception (Recoverable)
 │    ├── Checked Exceptions
 │    │    ├── IOException
 │    │    └── SQLException
 │    └── Unchecked Exceptions (RuntimeException)
 │         ├── ArithmeticException
 │         ├── NullPointerException
 │         └── ArrayIndexOutOfBoundsException
 └── Error (Unrecoverable - JVM related)
      ├── StackOverflowError
      └── OutOfMemoryError
```

---

## 3️⃣ Types of Exceptions

### 🔹 Checked Exceptions

* Checked at **compile time**
* Must be handled or declared
* Examples:
  - `IOException`
  - `SQLException`
  - `FileNotFoundException`

```java
void readFile() throws IOException {
    // Code that may throw IOException
}
```

---

### 🔹 Unchecked Exceptions

* Occur at **runtime**
* Not mandatory to handle
* Examples:
  - `ArithmeticException` (10/0)
  - `NullPointerException` (null reference)
  - `ArrayIndexOutOfBoundsException` (invalid index)
  - `StringIndexOutOfBoundsException`

---

## 4️⃣ Exception Handling Keywords

| Keyword | Use |
| ------- | --- |
| `try` | Contains code that may throw exception |
| `catch` | Handles the exception |
| `finally` | Executes always (cleanup code) |
| `throw` | Explicitly throw exception |
| `throws` | Declare exception in method signature |

---

## 5️⃣ try–catch Example

```java
try {
    int a = 10 / 0;              // May throw exception
} 
catch(ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
catch(Exception e) {
    System.out.println("General exception");
}
finally {
    System.out.println("This always executes");
}
```

🧠 **Key Points:**
* Multiple catch blocks can exist
* General exception catch must be last
* Finally block executes even if exception occurs or not

---

## 6️⃣ User Defined Exception

**Steps:**
1. Create class extending `Exception`
2. Throw it using `throw` keyword

```java
class LowAmountException extends Exception {
    LowAmountException(String msg) {
        super(msg);
    }
}

class BankAccount {
    int balance = 10000;
    
    void withdraw(int amount) throws LowAmountException {
        if(amount > balance) {
            throw new LowAmountException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful");
    }
}

class Test {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        try {
            acc.withdraw(15000);
        } 
        catch(LowAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## 🎯 Exception Handling - Final Tips

✔️ **throw vs throws:**
* `throw` - explicitly throw exception in code
* `throws` - declare exception in method signature

✔️ **finally always executes except when:**
* System.exit(0)
* JVM crashes

✔️ **try-with-resources (Java 7+):**
```java
try(FileReader fr = new FileReader("file.txt")) {
    // Code - auto closes resource
}
```

---

---

# 🧵 THREADS & MULTITHREADING

---

## 1. What is a Thread?

A **thread** is a lightweight sub-process.
It represents a **separate path of execution** within a program.

* A Java program always has **at least one thread** (main thread)
* Multiple threads allow **parallel execution**

### Real-life Example:

* One thread downloads a file
* Another thread shows progress bar simultaneously

---

## 2. Why Multithreading?

Multithreading is used to:

* Improve program performance
* Use CPU efficiently
* Perform multiple tasks simultaneously (apparent parallelism)
* Reduce overall program execution time
* Better resource utilization

---

## 3. Thread Life Cycle (Thread States)

A thread goes through the following states:

### 1️⃣ **New State**

Thread object is created but `start()` is not called yet.

```java
Thread t = new Thread();
```

---

### 2️⃣ **Runnable State**

Thread is ready to run and waiting for CPU allocation from thread scheduler.

```java
t.start();                 // Thread moves to Runnable state
```

---

### 3️⃣ **Running State**

Thread scheduler assigns CPU and thread executes `run()` method.

---

### 4️⃣ **Waiting/Blocked State**

Thread temporarily stops due to:
* `sleep(milliseconds)` - thread sleeps
* `wait()` - thread waits for notification
* I/O operation - waiting for I/O completion
* `join()` - waiting for another thread to complete

```java
Thread.sleep(1000);        // Sleep for 1 second
t.join();                  // Wait for thread t to complete
```

---

### 5️⃣ **Terminated/Dead State**

Thread completes execution or is explicitly stopped.

---

## 4. Thread Priority

Thread priority decides **importance**, not guaranteed execution order.

### Priority Constants:

| Constant | Value | Use |
| -------- | ----- | --- |
| `MIN_PRIORITY` | 1 | Lowest priority |
| `NORM_PRIORITY` | 5 | Default |
| `MAX_PRIORITY` | 10 | Highest priority |

```java
Thread t = new Thread();
t.setPriority(Thread.MAX_PRIORITY);
System.out.println(t.getPriority());
```

🧠 **Note:** Priority behavior depends on OS and JVM. It's not guaranteed.

---

## 5. Thread Operations (Important Methods)

| Method | Description |
| ------ | ----------- |
| `start()` | Starts new thread (calls run internally) |
| `run()` | Code to be executed by thread |
| `sleep(ms)` | Pauses thread for milliseconds |
| `join()` | Main thread waits for this thread |
| `yield()` | Gives CPU to another thread of same priority |
| `isAlive()` | Checks if thread is running |
| `interrupt()` | Interrupts the thread |
| `stop()` | Stops the thread (deprecated) |

🧠 **Critical:** `start()` creates new thread, `run()` directly does NOT create thread.

---

## 6. Creating Threads in Java

### Method 1: Extending Thread Class

```java
class MyThread extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(500);
            } catch(Exception e) {}
        }
    }
}

class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        
        t1.start();              // Start thread 1
        t2.start();              // Start thread 2
    }
}
```

🧠 **Key Point:**
* `start()` creates a new thread
* Calling `run()` directly does NOT create a thread

---

### Method 2: Implementing Runnable Interface (Recommended ✅)

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread");
    }
}

class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

### Why Runnable is better?

* Java supports **only single inheritance**
* Runnable allows extending another class
* Better design approach (composition over inheritance)
* More flexible

---

## 7. Multithreading Example (Exam-Level) - Q33

```java
class Generator extends Thread {
    public void run() {
        while(true) {
            int n = (int)(Math.random() * 10);
            System.out.println("Generated: " + n);

            if(n % 2 == 0) {
                new Square(n).start();
            } else {
                new Cube(n).start();
            }

            try {
                Thread.sleep(1000);
            } catch(Exception e) {}
        }
    }
}

class Square extends Thread {
    int n;
    
    Square(int n) { 
        this.n = n; 
    }
    
    public void run() {
        System.out.println("Square of " + n + " = " + (n*n));
    }
}

class Cube extends Thread {
    int n;
    
    Cube(int n) { 
        this.n = n; 
    }
    
    public void run() {
        System.out.println("Cube of " + n + " = " + (n*n*n));
    }
}

class MainTest {
    public static void main(String[] args) {
        new Generator().start();
    }
}
```

✅ This matches **Question 33 exactly**

---

## 8. Thread Synchronization

### Problem:

Multiple threads accessing **shared resource** may cause **data inconsistency/race condition**.

```java
class Account {
    int balance = 10000;

    void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;              // Problem: Race condition
            System.out.println("Withdrawn: " + amount);
        }
    }
}
```

---

### Solution: Synchronization

Only **one thread at a time** can access synchronized method.

```java
class Account {
    int balance = 10000;

    synchronized void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;              // Safe now
            System.out.println("Withdrawn: " + amount);
        }
    }
}
```

🧠 **How it works:**
* Thread acquires lock on object
* Executes method
* Releases lock
* Other threads wait

---

## 9. Synchronized Block

More granular control over synchronization.

```java
class Account {
    int balance = 10000;

    void withdraw(int amount) {
        synchronized(this) {
            if(balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn");
            }
        }
    }
}
```

---

---

# 🧩 JDBC - JAVA DATABASE CONNECTIVITY

---

## 1. What is JDBC?

JDBC is an **API** (Application Programming Interface) that allows Java programs to **connect and interact with databases**.

**JDBC enables:**
* Database connection
* Execute SQL queries
* Retrieve results
* Update/Delete data

---

## 2. JDBC Architecture

```
Java Application
      ↓
   JDBC API
      ↓
  JDBC Driver
      ↓
Database (MySQL, Oracle, PostgreSQL)
```

---

## 3. Types of JDBC Drivers

| Type | Name | Example | Use |
| ---- | ---- | ------- | --- |
| Type 1 | JDBC-ODBC Bridge | Sun's JDBC-ODBC Bridge | Deprecated ❌ |
| Type 2 | Native API Driver | Oracle Native Driver | Direct connection |
| Type 3 | Network Protocol Driver | Middleware | Remote databases |
| Type 4 | Thin Driver | MySQL Connector/J | Pure Java ✅ |

✅ **MySQL uses Type 4 driver (Most common)**

---

## 4. Steps to Connect Java with Database

### Step 1: Load JDBC Driver

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

---

### Step 2: Establish Connection

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/dbname",
    "username",
    "password"
);
```

**Connection URL format:**
```
jdbc:mysql://hostname:port/database_name
```

---

### Step 3: Create Statement Object

Three types:
* **Statement** - For simple queries
* **PreparedStatement** - For parameterized queries (Recommended)
* **CallableStatement** - For stored procedures

```java
Statement stmt = con.createStatement();
// OR
PreparedStatement ps = con.prepareStatement(query);
```

---

### Step 4: Execute Query

```java
// SELECT
ResultSet rs = ps.executeQuery();

// INSERT, UPDATE, DELETE
int rows = ps.executeUpdate();
```

---

### Step 5: Process Results

```java
while(rs.next()) {
    int id = rs.getInt(1);           // Column 1
    String name = rs.getString(2);   // Column 2
}
```

---

### Step 6: Close Resources

```java
rs.close();
ps.close();
con.close();
```

---

## 5. PreparedStatement (Recommended ✅)

**Advantages:**
* **Precompiled** - Faster execution
* **Secure** - Prevents SQL Injection
* **Reusable** - Can execute multiple times

```java
String query = "INSERT INTO student VALUES(?, ?, ?)";
PreparedStatement ps = con.prepareStatement(query);

ps.setInt(1, 1);              // Parameter 1
ps.setString(2, "Aditya");    // Parameter 2
ps.setInt(3, 95);             // Parameter 3

ps.executeUpdate();            // Execute
```

🧠 **SQL Injection Prevention:**
```java
// ❌ Vulnerable to SQL Injection
String query = "SELECT * FROM student WHERE id=" + userId;

// ✅ Safe with PreparedStatement
String query = "SELECT * FROM student WHERE id=?";
PreparedStatement ps = con.prepareStatement(query);
ps.setInt(1, userId);
```

---

## 6. CallableStatement

Used to execute **stored procedures** in database.

```java
CallableStatement cs = con.prepareCall("{call procedureName()}");
cs.execute();
```

Example with parameters:
```java
String sql = "{call getStudentGrade(?, ?)}";
CallableStatement cs = con.prepareCall(sql);

cs.setInt(1, 101);                    // IN parameter
cs.registerOutParameter(2, Types.VARCHAR);  // OUT parameter

cs.execute();
String grade = cs.getString(2);       // Get result
```

---

## 7. ResultSet

Used to retrieve data from database.

```java
ResultSet rs = ps.executeQuery();

while(rs.next()) {
    int id = rs.getInt("id");         // By column name
    String name = rs.getString("name");
    int marks = rs.getInt(3);         // By column index
}
```

🧠 **Cursor operations:**
```java
rs.first();                           // Move to first row
rs.last();                            // Move to last row
rs.next();                            // Move to next row
rs.previous();                        // Move to previous row
rs.isFirst();                         // Check if first row
```

---

## 8. INSERT Operation

```java
String query = "INSERT INTO student(id, name, marks) VALUES(?, ?, ?)";
PreparedStatement ps = con.prepareStatement(query);

ps.setInt(1, 1);
ps.setString(2, "Aditya");
ps.setInt(3, 95);

int result = ps.executeUpdate();
if(result > 0) {
    System.out.println("Record inserted");
}
```

---

## 9. UPDATE Operation

```java
String query = "UPDATE student SET marks=? WHERE id=?";
PreparedStatement ps = con.prepareStatement(query);

ps.setInt(1, 98);              // New marks
ps.setInt(2, 1);               // Student id

int result = ps.executeUpdate();
if(result > 0) {
    System.out.println("Record updated");
}
```

---

## 10. DELETE Operation

```java
String query = "DELETE FROM student WHERE id=?";
PreparedStatement ps = con.prepareStatement(query);

ps.setInt(1, 1);               // Student id to delete

int result = ps.executeUpdate();
if(result > 0) {
    System.out.println("Record deleted");
}
```

---

## 11. Transaction Management

### Auto-commit (Default)

Each SQL statement is automatically committed.

```java
Connection con = DriverManager.getConnection(url);
// Auto-commit is ON by default
```

---

### Manual Transaction Control

```java
con.setAutoCommit(false);      // Disable auto-commit

try {
    ps1.executeUpdate();
    ps2.executeUpdate();
    con.commit();              // Save both
    System.out.println("Transaction successful");
} 
catch(Exception e) {
    con.rollback();            // Undo both
    System.out.println("Transaction failed");
}
```

🧠 **Definitions:**
* **Commit** - Permanently saves all changes
* **Rollback** - Cancels all changes since last commit

---

## 12. Complete JDBC Program Example (Q34 Type)

```java
import java.sql.*;
import java.util.Scanner;

class StudentDB {
    static final String URL = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASS = "password";
    
    static Connection con;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insertStudent(int id, String name, int marks) {
        try {
            String query = "INSERT INTO student VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);
            
            ps.executeUpdate();
            System.out.println("Student added");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void displayStudents() {
        try {
            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("ID\tName\tMarks");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + 
                                 rs.getString(2) + "\t" + 
                                 rs.getInt(3));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        insertStudent(1, "Aditya", 95);
        insertStudent(2, "Priya", 92);
        displayStudents();
    }
}
```

---

---

# 📊 COLLECTIONS, WRAPPER CLASSES & GENERICS

---

## 🔹 QUESTION MAPPING

From your syllabus, this chapter covers:
* **Q30** – LinkedList iteration
* **Q31** – LinkedList insertion (without collections)
* **Q32** – Delete duplicate objects from ArrayList
* **Q46** – Addition of elements in List
* **Q47** – Size of Collection & empty check
* **Q49** – Set usage
* **Generics / Wrapper** – Type safety questions

---

# 1️⃣ COLLECTIONS FRAMEWORK

## What is Collection?

A **Collection** is a framework that provides **ready-made classes and interfaces** to store and manipulate a group of objects.

👉 **Used when:**
* Size is dynamic
* Duplicate handling needed
* Searching/sorting required
* Need flexibility

---

## Core Interfaces Hierarchy

```
Collection (Interface)
   ├── List (Ordered, allows duplicates)
   │    ├── ArrayList
   │    ├── LinkedList
   │    └── Vector (Legacy)
   │
   ├── Set (Unique elements)
   │    ├── HashSet
   │    ├── LinkedHashSet
   │    └── TreeSet
   │
   └── Queue (FIFO)
        ├── LinkedList
        └── PriorityQueue

Map (Separate - NOT part of Collection)
   ├── HashMap
   ├── LinkedHashMap
   └── TreeMap
```

⚠️ **Note: Map is NOT part of Collection interface**

---

# 2️⃣ COLLECTION INTERFACE (Q47)

## Important Methods:

```java
add(Object obj)              // Add element
remove(Object obj)           // Remove element
size()                       // Number of elements
isEmpty()                    // Check if empty
contains(Object obj)         // Check if exists
iterator()                   // Iterate through collection
clear()                      // Remove all elements
```

### Example (Q47 Type):

```java
import java.util.*;

class CollectionDemo {
    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<>();
        
        col.add(10);
        col.add(20);
        col.add(30);
        
        System.out.println("Size: " + col.size());        // 3
        System.out.println("Is Empty: " + col.isEmpty()); // false
        System.out.println("Contains 20: " + col.contains(20)); // true
        
        col.remove(20);
        System.out.println("Size after remove: " + col.size()); // 2
    }
}
```

---

# 3️⃣ LIST INTERFACE (Q30, Q32, Q46)

## Characteristics:

* **Ordered** - Elements stored in insertion order
* **Allows duplicates** - Same element can appear multiple times
* **Index-based** - Access by position (0, 1, 2...)

---

## 3.1 ArrayList (Q32, Q46)

### When to use:

* Frequent access by index
* Removing duplicates
* Dynamic size needed
* **Faster for retrieval**

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);      // Index 0
list.add(20);      // Index 1
list.add(30);      // Index 2

System.out.println(list.get(0));  // 10
list.set(0, 15);                  // Change element
list.remove(0);                   // Remove first
```

---

### 🔹 Q32 – Delete duplicate objects from ArrayList

**Problem:** Remove duplicates from ArrayList

```java
import java.util.*;

class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(20);
        list.add(30);
        
        System.out.println("Before: " + list);  // [10, 10, 20, 20, 30]
        
        // Solution 1: Using HashSet
        HashSet<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        
        System.out.println("After: " + list);   // [20, 10, 30]
        
        // Solution 2: Using LinkedHashSet (maintains order)
        LinkedHashSet<Integer> lset = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(lset);
        
        System.out.println("After (with order): " + list);
    }
}
```

🔥 **Most common lab solution for Q32**

---

## 3.2 LinkedList (Q30, Q31)

### Features:

* **Doubly linked list** - Each node has previous and next pointers
* No index-based fast access
* Best for **insertion/deletion**

```java
LinkedList<Integer> list = new LinkedList<>();
list.add(10);      // Add at end
list.addFirst(5);  // Add at beginning
list.addLast(20);  // Add at end
list.remove();     // Remove first
```

---

### 🔹 Q30 – Iterate LinkedList from specific position

**Problem:** Iterate from a specific position using ListIterator

```java
import java.util.*;

class LinkedListIteration {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        
        System.out.println("List: " + list);
        
        // Iterate from index 2
        ListIterator<Integer> it = list.listIterator(2);
        
        System.out.println("Elements from index 2:");
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        // Output:
        // 30
        // 40
        // 50
    }
}
```

🧠 **ListIterator methods:**
```java
hasNext()        // Check if next element exists
next()           // Get next element
hasPrevious()    // Check if previous exists
previous()       // Get previous element
set(Object)      // Replace current element
add(Object)      // Insert element
```

---

### 🔹 Q31 – Insert element in LinkedList (WITHOUT Collections)

**Problem:** Implement LinkedList manually and insert element

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;

    MyLinkedList() {
        head = null;
    }

    // Insert at end
    void insert(int data) {
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Insert at beginning
    void insertAtBeg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at position
    void insertAtPos(int data, int pos) {
        Node newNode = new Node(data);
        
        if(pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node temp = head;
        for(int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        
        if(temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Display
    void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();              // 10 -> 20 -> 30 -> null
        
        list.insertAtBeg(5);
        list.display();              // 5 -> 10 -> 20 -> 30 -> null
        
        list.insertAtPos(15, 2);
        list.display();              // 5 -> 15 -> 10 -> 20 -> 30 -> null
    }
}
```

⚠️ **Examiner checks logic, not speed** - This is best for Q31

---

## 3.3 Vector (Legacy)

```java
Vector<Integer> v = new Vector<>();
v.add(10);
v.addElement(20);
```

🧠 **Thread-safe but slower than ArrayList**

---

## 3.4 Stack

LIFO (Last In First Out)

```java
Stack<Integer> stack = new Stack<>();
stack.push(10);       // Add
stack.pop();          // Remove and return
stack.peek();         // View top
stack.isEmpty();      // Check if empty
```

---

# 4️⃣ QUEUE & DEQUE

## Queue (FIFO - First In First Out)

```java
Queue<Integer> q = new LinkedList<>();
q.add(10);            // Enqueue
q.remove();           // Dequeue
q.peek();             // View front
q.isEmpty();
```

---

## Deque (Double Ended Queue)

Insert/remove from both ends

```java
Deque<Integer> dq = new ArrayDeque<>();
dq.addFirst(10);      // Add at front
dq.addLast(20);       // Add at end
dq.removeFirst();     // Remove from front
dq.removeLast();      // Remove from end
```

---

# 5️⃣ SET INTERFACE (Q49)

## Characteristics:

* **No duplicates** - Unique elements only
* **No index** - Cannot access by position
* **No ordering** (except TreeSet/LinkedHashSet)

---

## 🔹 Q49 – Program using Set

### HashSet (Unordered)

```java
import java.util.*;

class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        
        set.add(10);
        set.add(10);      // Duplicate - ignored
        set.add(20);
        set.add(30);
        
        System.out.println("HashSet: " + set);
        // Output: [20, 10, 30] (Order may vary)
        
        System.out.println("Size: " + set.size());  // 3
        System.out.println("Contains 10: " + set.contains(10));  // true
        
        set.remove(20);
        System.out.println("After remove: " + set);
        
        // Iterate
        for(Integer num : set) {
            System.out.println(num);
        }
    }
}
```

---

### LinkedHashSet (Insertion Order)

```java
Set<Integer> set = new LinkedHashSet<>();
set.add(30);
set.add(10);
set.add(20);

System.out.println(set);  // [30, 10, 20] - Maintains order
```

---

### TreeSet (Sorted Order)

```java
Set<Integer> set = new TreeSet<>();
set.add(30);
set.add(10);
set.add(20);

System.out.println(set);  // [10, 20, 30] - Sorted
```

---

# 6️⃣ MAP INTERFACE

## Characteristics:

* **Key-value pairs**
* **Keys are unique**
* **Not part of Collection interface**

---

## HashMap (Unordered)

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "Java");
map.put(2, "Python");

System.out.println(map.get(1));    // "Java"
System.out.println(map.size());    // 2
System.out.println(map.containsKey(1));  // true

// Iterate
for(Integer key : map.keySet()) {
    System.out.println(key + " = " + map.get(key));
}
```

---

## LinkedHashMap (Insertion Order)

```java
Map<Integer, String> map = new LinkedHashMap<>();
map.put(1, "A");
map.put(2, "B");
map.put(3, "C");

System.out.println(map);  // {1=A, 2=B, 3=C}
```

---

## TreeMap (Sorted by Key)

```java
Map<Integer, String> map = new TreeMap<>();
map.put(3, "C");
map.put(1, "A");
map.put(2, "B");

System.out.println(map);  // {1=A, 2=B, 3=C}
```

---

# 7️⃣ WRAPPER CLASSES

## Purpose:

Convert primitive data types to objects and vice versa.

| Primitive | Wrapper |
| --------- | ------- |
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| char | Character |
| boolean | Boolean |

---

## Boxing (Primitive → Object)

```java
// Explicit Boxing
int a = 10;
Integer obj = Integer.valueOf(a);

// Auto Boxing (Java 5+)
Integer obj = 10;
```

---

## Unboxing (Object → Primitive)

```java
// Explicit Unboxing
Integer obj = 10;
int b = obj.intValue();

// Auto Unboxing (Java 5+)
int b = obj;
```

---

## Common Methods

```java
Integer.parseInt("10");          // String to int
Integer.toString(10);            // int to String
Integer.max(10, 20);             // Maximum
Integer.min(10, 20);             // Minimum
Double.parseDouble("3.14");      // String to double
```

---

## Wrapper Classes in Collections

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);                    // Auto boxing
int num = list.get(0);           // Auto unboxing
```

---

# 8️⃣ GENERICS (VERY IMPORTANT)

## Why Generics?

* **Type safety** - Compile-time checking
* **No casting** - Avoid ClassCastException
* **Code reusability** - Write once, use for multiple types

---

## Generic Class

```java
class Box<T> {
    T value;
    
    void set(T value) {
        this.value = value;
    }
    
    T get() {
        return value;
    }
}

class Test {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(10);
        System.out.println(intBox.get());  // 10
        
        Box<String> strBox = new Box<>();
        strBox.set("Java");
        System.out.println(strBox.get());  // Java
    }
}
```

🧠 **Key Points:**
* `<T>` is type parameter (placeholder)
* Can use: `<T>`, `<E>`, `<K>`, `<V>`, `<N>` etc.
* Type determined at runtime

---

## Generic Method

```java
class Test {
    // Generic method
    static <T> void show(T data) {
        System.out.println("Type: " + data.getClass().getName());
        System.out.println("Value: " + data);
    }
    
    public static void main(String[] args) {
        show(10);           // Integer
        show("Java");       // String
        show(3.14);         // Double
    }
}
```

---

## Generic Collection (Q46 Type)

```java
// Without Generics (Type-unsafe)
ArrayList list = new ArrayList();
list.add(10);
list.add("Java");           // Mixed types
Integer num = (Integer)list.get(0);  // Casting needed

// With Generics (Type-safe)
ArrayList<String> list = new ArrayList<>();
list.add("Java");
// list.add(10);            ❌ Compile error
String str = list.get(0);  // No casting needed
```

---

## Bounded Type Parameters

```java
// T must be Number or its subclass
class Box<T extends Number> {
    void show(T value) {
        System.out.println(value);
    }
}

class Test {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        Box<Double> box2 = new Box<>();
        // Box<String> box3 = new Box<>();  ❌ Error
    }
}
```

---

## Wildcard (?)

```java
// ? means any type
void printList(ArrayList<?> list) {
    for(Object obj : list) {
        System.out.println(obj);
    }
}

// ? extends Number - any subclass of Number
void addNumbers(ArrayList<? extends Number> list) {
    // Can only read, not add
}
```

---

---

# ☕ JAVA SERVLETS

---

## 1. What is a Servlet?

A **servlet** is a Java program that:
* Runs on a **web server** (server-side)
* Handles **HTTP requests** from clients
* Generates **dynamic web responses**
* Extends functionality of servers

👉 **Used to:**
* Build dynamic web applications
* Process form data
* Access databases
* Create sessions
* Maintain state

---

## 2. Servlet Architecture

```
Client (Browser)
    ↓
HTTP Request
    ↓
Web Server (Tomcat)
    ↓
Servlet Container
    ↓
Servlet Class
    ↓
    ├── doGet()
    ├── doPost()
    ├── doPut()
    └── doDelete()
    ↓
HTTP Response
    ↓
Client (Browser)
```

---

## 3. Lifecycle of a Servlet

A servlet goes through **three phases**:

### 1️⃣ **Initialization (init)**

* Called **once** when servlet is loaded
* Server calls `init()` method
* Used for **one-time setup**

```java
public void init(ServletConfig config) throws ServletException {
    System.out.println("Servlet initialized");
}
```

---

### 2️⃣ **Service/Request Processing (service)**

* Called **every time** a request comes
* Server calls `service()` method
* `service()` internally calls `doGet()` or `doPost()`

```java
protected void service(HttpServletRequest request, 
                       HttpServletResponse response) 
        throws ServletException, IOException {
    // Process request
    // Send response
}
```

---

### 3️⃣ **Destruction (destroy)**

* Called **once** when servlet is unloaded
* Server calls `destroy()` method
* Used for **cleanup** (close DB connections, etc.)

```java
public void destroy() {
    System.out.println("Servlet destroyed");
}
```

---

## 4. Servlet APIs and Packages

### Important Packages:

```
javax.servlet
 ├── Servlet (Interface)
 ├── ServletConfig
 ├── ServletContext
 └── ServletRequest
 
javax.servlet.http
 ├── HttpServlet (Class)
 ├── HttpServletRequest
 ├── HttpServletResponse
 └── HttpSession
```

---

## 5. Key Classes and Interfaces

### 📌 Servlet Interface

```java
public interface Servlet {
    void init(ServletConfig config);
    void service(ServletRequest req, ServletResponse res);
    void destroy();
    String getServletInfo();
}
```

---

### 📌 HttpServlet Class

Most commonly extended class (already implements Servlet)

```java
public class HttpServlet extends GenericServlet {
    protected void doGet(HttpServletRequest req, 
                        HttpServletResponse res) { }
    
    protected void doPost(HttpServletRequest req, 
                         HttpServletResponse res) { }
}
```

---

### 📌 ServletRequest Interface

Gets request data from client

```java
String getParameter(String name);      // Get form parameter
String[] getParameterValues(String name);
Enumeration getParameterNames();
String getMethod();                    // GET/POST
String getQueryString();               // Query string
```

---

### 📌 ServletResponse Interface

Sends response to client

```java
PrintWriter getWriter();               // Get text output stream
ServletOutputStream getOutputStream(); // Get binary output
void setContentType(String type);      // Set MIME type
void sendRedirect(String location);    // Redirect
```

---

## 6. Classes for Handling Request and Response

### HttpServletRequest Methods:

```java
String getParameter(String name);           // Get single parameter
String[] getParameterValues(String name);   // Get multiple values
String getMethod();                         // GET/POST/PUT/DELETE
String getQueryString();                    // Query string
String getRemoteAddr();                     // Client IP
String getRemoteHost();                     // Client hostname
String getHeader(String name);              // Get header value
Cookie[] getCookies();                      // Get cookies
HttpSession getSession();                   // Get session
```

---

### HttpServletResponse Methods:

```java
PrintWriter getWriter();                    // Text response
ServletOutputStream getOutputStream();      // Binary response
void setContentType(String type);           // MIME type
void sendRedirect(String url);              // Redirect
void sendError(int sc, String msg);         // Send error
void addCookie(Cookie cookie);              // Add cookie
void setHeader(String name, String value);  // Set header
```

---

## 7. Simple Servlet Example

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
    
    // Initialization
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Servlet initialized");
    }
    
    // Handle GET requests
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response type
        response.setContentType("text/html");
        
        // Get output writer
        PrintWriter out = response.getWriter();
        
        // Write HTML response
        out.println("<html>");
        out.println("<head><title>Hello</title></head>");
        out.println("<body>");
        out.println("<h1>Hello from Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    // Cleanup
    public void destroy() {
        System.out.println("Servlet destroyed");
    }
}
```

**web.xml mapping:**
```xml
<servlet>
    <servlet-name>SimpleServlet</servlet-name>
    <servlet-class>SimpleServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>SimpleServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

---

## 8. Working with Form Data

### HTML Form:

```html
<form method="POST" action="/myapp/processForm">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" value="Login">
</form>
```

### Servlet Processing:

```java
protected void doPost(HttpServletRequest request, 
                     HttpServletResponse response) 
        throws ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    // Get form parameters
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    out.println("<html><body>");
    out.println("Username: " + username + "<br>");
    out.println("Password: " + password);
    out.println("</body></html>");
    
    out.close();
}
```

---

## 9. Initialization in init()

```java
public class InitServlet extends HttpServlet {
    
    private String databaseURL;
    private Connection dbConnection;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        // Initialize database
        databaseURL = "jdbc:mysql://localhost:3306/mydb";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected");
        } catch(Exception e) {
            throw new ServletException("DB init failed");
        }
    }
    
    public void destroy() {
        try {
            if(dbConnection != null) {
                dbConnection.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 10. Initialization through ServletConfig

**ServletConfig** - Configuration for individual servlet

```java
public void init(ServletConfig config) throws ServletException {
    super.init(config);
    
    // Get init parameter from web.xml
    String param = config.getInitParameter("paramName");
    System.out.println("Parameter: " + param);
    
    // Get servlet name
    String name = config.getServletName();
    System.out.println("Servlet name: " + name);
    
    // Get ServletContext
    ServletContext context = config.getServletContext();
}
```

**web.xml:**
```xml
<servlet>
    <servlet-name>MyServlet</servlet-name>
    <servlet-class>MyServlet</servlet-class>
    <init-param>
        <param-name>paramName</param-name>
        <param-value>paramValue</param-value>
    </init-param>
</servlet>
```

---

## 11. Initialization through ServletContext

**ServletContext** - Shared configuration for entire application

```java
public void init(ServletConfig config) throws ServletException {
    super.init(config);
    
    ServletContext context = config.getServletContext();
    
    // Get application init parameter
    String appParam = context.getInitParameter("appParam");
    System.out.println("App Parameter: " + appParam);
    
    // Get real path
    String realPath = context.getRealPath("/");
    System.out.println("Real path: " + realPath);
    
    // Store attribute (accessible in all servlets)
    context.setAttribute("userId", "12345");
}
```

**web.xml:**
```xml
<context-param>
    <param-name>appParam</param-name>
    <param-value>appValue</param-value>
</context-param>
```

---

## 12. sendRedirect() - Servlet Communication

**sendRedirect()** redirects client to another URL

```java
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    String action = request.getParameter("action");
    
    if(action.equals("login")) {
        // Redirect to login page
        response.sendRedirect("login.jsp");
    } 
    else if(action.equals("home")) {
        // Redirect to home
        response.sendRedirect("home.html");
    }
}
```

🧠 **Client-side redirect:**
* Browser makes **new request** to redirected URL
* URL changes in address bar
* **Two round trips**

---

## 13. forward() and include()

### RequestDispatcher.forward()

Passes control to another servlet/JSP

```java
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    // Process request
    String result = processData();
    
    // Forward to result.jsp
    RequestDispatcher dispatcher = 
        request.getRequestDispatcher("result.jsp");
    dispatcher.forward(request, response);
}
```

🧠 **Forwarding:**
* **Server-side** operation
* URL doesn't change in browser
* **One round trip**
* Can pass data via request attributes

---

### RequestDispatcher.include()

Includes output from another servlet/JSP

```java
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    out.println("<h1>Header</h1>");
    
    // Include content from another servlet
    RequestDispatcher dispatcher = 
        request.getRequestDispatcher("header.jsp");
    dispatcher.include(request, response);
    
    out.println("<h1>Footer</h1>");
}
```

🧠 **Including:**
* Includes **output** of another resource
* Both outputs are **combined**
* Original URL remains same

---

## 14. Request Attributes

Passing data between servlets/JSP using attributes

```java
// Servlet1: Set attribute
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    String username = "Aditya";
    request.setAttribute("user", username);
    
    // Forward to Servlet2
    RequestDispatcher dispatcher = 
        request.getRequestDispatcher("servlet2");
    dispatcher.forward(request, response);
}

// Servlet2: Get attribute
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    String user = (String)request.getAttribute("user");
    response.getWriter().println("User: " + user);
}
```

---

## 15. Connecting to the Database

```java
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DBServlet extends HttpServlet {
    
    private Connection con;
    
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "password"
            );
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            
            out.println("<h2>Students</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Marks</th></tr>");
            
            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getInt(3) + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
    
    public void destroy() {
        try {
            con.close();
        } catch(Exception e) {}
    }
}
```

---

## 16. Servlet Session - Ways to Maintain State

### Problem:

HTTP is **stateless** - server doesn't remember client between requests.

**Solution:** Maintain **state** using:

| Method | Mechanism | Storage | Duration |
| ------ | --------- | ------- | -------- |
| **Cookies** | Client sends back | Browser | Persistent |
| **Session** | SessionID in Cookie | Server memory | Session timeout |
| **URL Rewriting** | Append to URL | Hidden in URL | Page to page |
| **Hidden Form Fields** | Form data | HTML form | Single form |

---

## 17. HttpSession - Session Management

### Creating/Getting Session:

```java
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    // Get existing session or create new
    HttpSession session = request.getSession();
    
    // Or get existing session only
    HttpSession session = request.getSession(false);
    
    // Set session attributes
    session.setAttribute("userId", "12345");
    session.setAttribute("userName", "Aditya");
    
    // Get session ID
    String sessionId = session.getId();
    System.out.println("Session ID: " + sessionId);
}
```

---

### Accessing Session Data:

```java
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    // Get attribute
    String userId = (String)session.getAttribute("userId");
    String userName = (String)session.getAttribute("userName");
    
    // Check if attribute exists
    if(session.getAttribute("userId") != null) {
        System.out.println("User ID: " + userId);
    }
    
    // Get all attributes
    Enumeration names = session.getAttributeNames();
    while(names.hasMoreElements()) {
        String name = (String)names.nextElement();
        Object value = session.getAttribute(name);
        System.out.println(name + " = " + value);
    }
}
```

---

### Session Destruction/Logout:

```java
protected void doGet(HttpServletRequest request, 
                    HttpServletResponse response) 
        throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    // Remove specific attribute
    session.removeAttribute("userId");
    
    // Invalidate entire session (logout)
    session.invalidate();
    
    // Redirect to login
    response.sendRedirect("login.html");
}
```

---

### Session Configuration:

**web.xml:**
```xml
<session-config>
    <cookie-config>
        <max-age>1800</max-age>
    </cookie-config>
    <tracking-mode>COOKIE</tracking-mode>
</session-config>
```

Or in Tomcat:
```java
// 30 minutes timeout
session.setMaxInactiveInterval(30 * 60);
```

---

## 18. Session Destruction & Timeout

### Auto Destruction:

```
Session timeout → Server removes session from memory
→ Client sends JSESSIONID in cookie
→ Server creates new session
```

---

### Manual Destruction:

```java
// Option 1: Logout
session.invalidate();

// Option 2: Remove attribute
session.removeAttribute("userId");

// Option 3: Set timeout
session.setMaxInactiveInterval(10 * 60); // 10 minutes
```

---

## 19. Session Tracking Mechanisms

### 1️⃣ Cookie-based (Default)

```
Server sets JSESSIONID cookie
Client sends back in all requests
```

```java
// Automatic - handled by container
HttpSession session = request.getSession();
```

---

### 2️⃣ URL Rewriting

```
SessionID appended to URL
Used when cookies disabled
```

```java
String url = response.encodeRedirectURL("nextPage.jsp");
response.sendRedirect(url);
```

---

### 3️⃣ Hidden Form Fields

```html
<form method="POST" action="nextServlet">
    <input type="hidden" name="sessionId" value="12345">
    <input type="submit">
</form>
```

---

### 4️⃣ HTTPS (Secure Cookies)

```xml
<cookie-config>
    <secure>true</secure>
    <http-only>true</http-only>
</cookie-config>
```

---

## 🎯 Complete Servlet Example with Session

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Validate credentials
        if(username.equals("admin") && password.equals("admin")) {
            
            // Create session
            HttpSession session = request.getSession();
            
            // Store user info
            session.setAttribute("userId", "1");
            session.setAttribute("userName", username);
            session.setMaxInactiveInterval(30 * 60);  // 30 min timeout
            
            // Redirect to home
            response.sendRedirect("home.jsp");
        } 
        else {
            // Login failed
            out.println("<html><body>");
            out.println("<h2>Invalid credentials</h2>");
            out.println("<a href='login.html'>Try again</a>");
            out.println("</body></html>");
        }
        
        out.close();
    }
}

// Home page checking session
public class HomeServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if(session == null || session.getAttribute("userId") == null) {
            // Not logged in
            response.sendRedirect("login.html");
            return;
        }
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String userName = (String)session.getAttribute("userName");
        
        out.println("<html><body>");
        out.println("<h1>Welcome " + userName + "</h1>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</body></html>");
        
        out.close();
    }
}

// Logout servlet
public class LogoutServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if(session != null) {
            session.invalidate();
        }
        
        response.sendRedirect("login.html");
    }
}
```

---

## 📋 Servlet vs JSP

| Feature | Servlet | JSP |
| ------- | ------- | --- |
| **Type** | Java class | HTML + Java |
| **Compilation** | Manual (extends HttpServlet) | Auto-compiled to servlet |
| **Logic** | Complex business logic | Simple logic + presentation |
| **Layout** | Hard to code HTML | Easy HTML mixing |
| **Use Case** | Backend processing | Frontend rendering |

---

## 🎯 FINAL SERVLET EXAM STRATEGY

### HIGH PRIORITY (Must Score):

1. ✅ Servlet lifecycle (init, service, destroy)
2. ✅ doGet() and doPost() methods
3. ✅ ServletRequest and ServletResponse
4. ✅ Simple servlet program
5. ✅ Form data handling
6. ✅ RequestDispatcher (forward/include)
7. ✅ HttpSession - session management
8. ✅ sendRedirect() vs forward()
9. ✅ Session destruction and timeout
10. ✅ Database connectivity in servlet

### MEDIUM PRIORITY:

1. ✓ ServletConfig and ServletContext
2. ✓ Session tracking mechanisms
3. ✓ Cookies in servlets
4. ✓ URL rewriting
5. ✓ Login/Logout example

### LOWER PRIORITY:

1. Request attributes
2. Filter concepts
3. Listener concepts
4. Servlet threading

---

## Quick Revision Checklist:

- [ ] Write simple servlet with doGet()
- [ ] Handle form data with doPost()
- [ ] Create and use HttpSession
- [ ] Forward and include requests
- [ ] Set session timeout
- [ ] Destroy/invalidate session
- [ ] Connect servlet to database
- [ ] sendRedirect() vs forward() difference
- [ ] Session tracking methods
- [ ] Complete login/logout example

---

## Expected Question Types in Exam:

| Type | Questions |
| ---- | --------- |
| Theory (Lifecycle, APIs) | 2-3 questions |
| Code writing (Simple servlet) | 2 questions |
| Form handling | 1-2 questions |
| Session management | 1-2 questions |
| Database integration | 1 question |
| forward() vs sendRedirect() | 1 question |

---

**Good luck with your exams! 🚀**

*Last updated: January 2026*
*Aligned with Galgotias University CSE Curriculum*
*Complete Coverage: OOPs, Exceptions, Threads, JDBC, Collections, Generics & Servlets*