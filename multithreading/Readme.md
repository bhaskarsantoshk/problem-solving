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
    - Each instance from application run independantly from other processes
    - Each process may have one or more threads competing with each other to be executed  
    - The act of stopping one thread, scheduling it's out, scheduling another thread's in, starting thread 2 - is called a context switch  

* Context Switch cost:

    - context switch is not cheap, it's the price for multitasking (concurrency)  
    - Each thread consumes resources in the CPU and memory  
    - When we switch to a different thread - store the data from one thread, restore the data from another thread into memory.   

* Context Switch - key take aways:
    - Too many threads - thrashing, spending more time in management than real production work.  
    - Threads consume less resources than processes. 
    - CS between two threads from the same process is cheaper than context switch between two threads from different processes.  
    
* Thread Scheduling :

    - FCFS 
    - SJF
    - Epochs ( OS divides the time into moderately sized peices called epochs - For each epoch , a different time slice for each thread is allocated by OS - dynamic priority ~~  static priority + bonus) - preference will be given to interactive threads and also the computational threads that need to be completed.


## Threads vs Process


### When to prefer multithreaded architecture: 

* prefer if the tasks share a lot of data
* Threads are much faster to create and destroy
* Shorter context switches if the threads are from same process. 

### When to prefer multi process architecture

* Security and Stability are of high importance
* Tasks are unrelated to eaxh other.

## Thread Creation Notes

* Thread class encapsulates all thread related functionality
* Two ways to run a thread:
    > Implement Runnable interface, and pass to a new Thread object.                            
     Extend Thread class, and create an object of that class
## Thread Termination - Why and When

* Threads consume resources
    > Memory and Kernel resources

    > CPU cycles and Cache memory
* If a thread finishes it's work, but the application is still running, 
we want to clean up the thread's resources.
* If a thread is misbehaving, we want to stop it.
* By default, the application will not stop 
as long as at least one thread is still running

## Thread.interrupt() - when can we interrupt a thread ?
1. If the thread is executing a method that throws an InterruptedException
2. If the thread's code is handling the interrupt signal explicitly.

## Daemon Threads

* Background threads that do not prevent 
the application from exiting if the main thread terminates

### Daemon Threads Scenario 1

* Background tasks, that should not block our application from terminating

    Example: File saving thread in Text Editor

### Daemon Threads Scenario 2

* Code in a worker thread is not in our control, and we do not want it to 
block our application from terminating.

    Example: Worker thread that uses an external library
 
 ### Thread Coordination - Why do we need it 
 
 * Different threads run independently
 * Order of execution is out of control
 
 ### Thread Coordination - dependency 
 
 * What if one thread depends on the another thread - 
    * Naive solution : Thread B runs in a loop and 
    keeps checking if Thread A's result is ready 
    this solution is inefficient. 
    Thread B is going to burn CPU cycles just for doing checks
    
    * Desired Solution: Thread B checks and goes to sleep, 
    Thread A completes, Thread B wakes up. Thread.join() will achive this.
    
  * Thread.join() 
    * More control over worker threads
    * Safely collect and aggregate results
    * Gracefully handle runaway threads using Thread.join(timeout)
 ### Key takeaways
 
 * Never rely on the order of execution of threads
 * Always use Thread coordination
 * Design Code for worst case scenarios
 * Threads make take unreasonably long time
 * Stop the thread if it's not done by certain timeout
 
 
                 