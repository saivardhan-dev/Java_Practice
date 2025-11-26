# Exception Handling

## Introduction:
- **Exception:** An unwanted, unextected event that distrubs normal flow of program. (Exception Handling : Defniing alternative way to continue the rest of the execution of the program)
- **Purpose of Exception Handling:**  The purpose of exception handling is to manage runtime errors and unexpected events to prevent a program from crashing, making it more robust, user-friendly, and reliable. It allows a program to gracefully respond to problems, such as invalid user input or network connection failures, by handling the error in a controlled manner and potentially providing a meaningful message to the user instead of an abrupt termination.
- Example: 
```text
try{
├── read data form remote location
}catch(FileNotFound e) { 
├── Use local file and continue rest of the program normally
}
```
## Run-Time Stack: 
- Eeverytime a process or a code or a thread needs to run in Java, a runtime stack is created so as to store the operations performed while executing the thread.
- Every entry in the run-time stack is known as stack frame or activation record. Once a function has been called by the process, its associated data is deleted from the runtime stack.
- Once all the functions have been called, the runtime stack will be empty. This means it needs to be removed from the memory(Last in first out).
- At this point in time, the runtime stack is destroyed and then the thread is also terminated.
- Every program conains atleast one thread which is main() thread.

## Default Exception handling in java: 
- In Java, when an exception occurs within a thread and is not caught by any try-catch block within that thread's execution path, the Java Virtual Machine (JVM) invokes a default exception handler.

## Exception hierarchy
- Java's exception hierarchy provides a structured way to manage and categorize errors and exceptional conditions that can occur during program execution. This hierarchy originates from the Throwable class, which is the superclass of all errors and exceptions in Java.
- Exception are caused by our program and exceptions are recoverable by using try catch block whereas errors are not caused by our program, mostly they are caused by lack of system resources.
- <img width="1440" height="691" alt="image" src="https://github.com/user-attachments/assets/cb1dd574-3632-4418-858a-47fb1468d39b" />

## Cheched and Unchecked Exception:
**Checked Exception:** 
