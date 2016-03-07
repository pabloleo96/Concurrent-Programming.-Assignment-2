# Concurrent-Programming.-Assignment-2

I. Introduction
In this class, we will synchronize java threads using 2 methods you are familiar with:
- Busy-wait
- signals (wait(), notify(), notifyAll()).
- Key-word synchronized
You may want to improve or refresh your knowledge about these methods in the following link:
http://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html

II. Solve the following tasks:

A. A simple version of the Writer/Reader problem

You are provided with class Queue which only buffers one integer variable n. This class has two
methods:
- void read(): prints the current value of n.
- void write(int x): the value of x is assigned to n.
Your Queue must be shared by 1 consumer and 1 writer. That is to say, you have to create one
thread Writer which updates the value of n, and one thread Reader which displays n on the screen.

Run the code above…
You have to improve the code so that threads work in turns: write, read, write, read,…
In order to do so:

1. Use condition synchronization and busy wait.
2. Use synchronized and signals.
You may want to read
http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#notify%28%29
3. Add one extra Reader
Each value of n must be read (printed) by the 2 readers. The read() method must show which
reader is printing the value.

----------------------------------------------------------------------------------------------------------------

B. The Ornamental Garden

There is an Ornamental Garden with 2 entrances accessible through a turnstile each. The manager
of the Garden wants to limit the access up to 40 people, so a global counter needs to be
implemented which sums up the individual counter from each turnstile.
You can download from Campus Virtual an Applet which simulates the problem of the Ornamental
Garden, with 2 turnstiles to grant access into the garden.
Since the global counter is shared, we need to grant mutual exclusion when accessing to it.
1. Identify the critical section and implement the Dekker algorithm.
2. Now solve the problem by using the synchronized key-word.
