# Answers

## Exercise 1.1

### 1

Different results each time eg.
Count is 18925430 and should be 20000000
Count is 19723492 and should be 20000000

Why?
This is because of Race Condition.

### 2

No, it is not guarenteed, however, because the count now is so "small" it is less likely that the interleaving affects the result

The first thread probably just completes the entire run before the second thread even starts.
It is not technically guaranteed, especially if you have a slower machine, but on modern machines, it should always be 200.

### 3

No, don't think there should be a difference in performance. There is no obvious difference between either operation when running the program.

### 4

Mutual exclusion, Critial Sections, Interleaving

Because it is not possible for the two threads to create a race condition. One thread will always finish writing before another thread tries to read. We created mutual exclusion.

### 5

Yes, we have used the lock around the functionality within "increment", which is the tiniest critical section possible
lock.lock();
count = count +  1;
lock.unlock();

Another option that could have been but would create a slightly bigger critical section would be to have the lock around the 
call of the increment function:
lock.lock();
lc.increment();
lock.unlock();

## 1.2

### 1

We have made the PrintDasher.java file

### 2

(1) System.out.print("-");
(2) try { Thread.sleep(50); } catch (InterruptedException exn) { }
(3) System.out.print("|");

In the following interleaving the t1 and t2 threads prints their "-" following each other, and starts their timer respectivly after, then after their timer is done they both also print their "|" following each other, which produce the "--||" weaving faults

t1(1), t2(1), t1(2), t2(2), t1(3), t2(3)
Would produce: 
--||

### 3

We lock the critical section of the code, which enforces that each thread needs to write both the "-" and the "|" before unlocking, which makes it impossible for any other threads to type -'s or |'s to mess with the weaving 

## 1.3

### 1

We include the check in the lock, such that both threads agree on counter being at 15.000. 

### 2

This means that after the counter has been increased to 15000, we no longer allow the counter to go up (we stop people from entering) However we do not stop the processes, just check every time if the number is still over 15000 (which it would be).

## 1.4

### 1 

We believe there is great overlap between Nygaard's Hidden, and Goetz Fairness, as well as their Exploitation and Resource Utilization respectivly. 

Hidden speaks about how a user should have access to a resource without noticing that others might have access to that resource too, thus speaking about how the user should be unaffected (if possible) performancevise.
Similarly, Fairness speaks about how if multiple systems/users have equal rights to a resource, it would be unfair to "queue" their access/usage and make one wait for the other, and instead make them both have partial access/usage so they both wait equally for each other.

Exploitation speaks about how modern computers are capable of running multiple tasks at a time, so you might as well do it to safe time.
Similarly Resource Utilization speaks about how instead of doing one thing at a time and wait for the first to finish, you might as well start on a second task while running the first, if possible.

Therefore these are hard to find examples that are included in the first and not in the latter, and vise versa.


However, there does not seem to be much otherlap between their Inherent and Convinence categories/motivations. 

An example of a system that is explained by Goetz, namely Conveniece, but not in the concurrency notes is a assembly line factory. Where each area/person is a process which only does 1 task, and that in total can create a car. But no individual process/person can create an entire car themselves. And while the notes are directly related to software systems, it could be possible to create a software system like an assembly line.

### 2 
Inherent: 
An application on an iphone that waits for information (such as an email) before giving the phone a ping, while you are using reddit.
A website which sends information to and from a user's browser.
If a webshop sells jackets, and there are 100 jackets, every time a user tries to buy a jacket, the server has to check that it still has jackets, and can't sell the last jacket to two different people.

Exploitation: 
A Peer to Peer network. 
Block Chain. These both use communication and coordination between multiple independent Computers to create a shared system. 
A multi proccessor CPU that allows us to run multiple processes at once (e.g intel core i5)


Hidden: 
I have a shared Netflix account where me and my family all can watch movies as if we were the sole owner. Somewhere our account access a server where all movies are stored, and we all get these movies streamed at the same time equally as if we were the sole owner. 
Wifi - distributes internet access to all users that are connected.
Skat - The people that actually get through without being in line has access to the Skat's webpage. However, all the people in queue are very much aware of the resource being used by others. However, this is needed because if the resource were to be split to all the people that want access, there would be too little "resource" left for anyone to be able to do anything in the site. 
