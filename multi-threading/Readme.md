# Java Multithreading, Concurrency & Performance Optimization

## Why we need threads

1. Responsiveness
2. Performance

## How to achive responsiveness

1. Concurrency - Multitasking:

* Responsiveness can be achieved by using mutiple threads, with a separate thread for each task
* Generally very hard to achive otherwise.
* Achieved by multitasking between threads
* Concurrency = Multitasking
* We don't need multiple cores to achieve concurrency



## How to achieve performance 

* We can create illusion of multiple tasks executing in parallel using just a single core
* with multiple cores we can truly run multiple tasks completely in parallel. 

2. Performance - Impact

* Completing a complex task much faster
* Finish more work in the same period of time
* For high scale service - 
    > Fewer machines  
    > Less money spent on hardware  
    > More saving/profits

## Why we need Threads

1. Responsiveness - Concurrency
2. Performance - Parallelism

# Operating System Notes

    > OS 
    - gets loaded from Disk into memory when we turn on our computer  
    - provides abstraction and helps application developers to interact with the hardware 
    - When the user runs an application, OS takes the program from disk and creates an instance of that application in the memory   - this instance is called a process (sometimes Context).  
    - Each process is completely isloated from any other process that runs on the system.  
    - Process contains meta data like process id, files the application opens for reading and writing, code which is the programming instructions that are executed in the cpu, the heap (data) the application needs and at least one thread called the main thread.  
    - Thread contains two main things: stack and instruction pointer
    - In Multi threaded programming, each thread has it's own stack and instruction pointer - all the rest of the components are shared by all threads.  
    - Stack - a region in memory where local variables are stored, and passed into functions.   
    - Instruction Pointer - address of the next instruction to execute  
     

