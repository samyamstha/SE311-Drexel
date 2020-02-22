Samyam C. Shestha
ss4674
SE 311
Assignment 3

The program functions as required by the assignment. Implicit invocation is used as needed for the assignment.
The use of Observer pattern and events can be clearly seen on the attached UML.

I have wrote my own custom Observable class (MyObservable), Observer class (MyObserver), and Event Class (MyEvent). The Observable and Observer classes provided by Java are deprecated anyway so just wrote my own for this assignment.

LineStorage and InteractiveInput classes extend the MyObservable class. 

CircularShift, Alphabetize, ConsoleOutput are the observers. Also, there are some inner classes that are the observers for interactive line additions and deletions. 

MyEvent class has several event types (LINE_ADDED, PRINT_READY, LINE_REMOVED, ALBHABETIZE). Thus, when an event is announced/created it is created with a particular eventType. So, when the notification is broadcasted, the observers check if it the eventType they want to listen to and depending on that the observers perform their respective actions. 
I could created an abstract Event class and then create concrete Events for each type, but for the scope of the assignment, I felt that just separating out events with type would be sufficient. 

Alphabetize, ConsoleOutput listen to the InteractiveInput as the user will input there to print the lines.

CircularShift listens to LineStorage as the addition of a new line will have to be circularly shifted. 

The two inner classes that inherit MyObserver will listen to the line addition and deletion inputs from the user in the InteractiveInput class. 

Run: Just unzip and import the project to eclipse. Run the main method MasterControl.java class.
Output: As per the discussion with Professor, the program only needs to have ConsoleOutput.

