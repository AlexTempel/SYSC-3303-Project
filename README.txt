SYSC 3303 Project Group 8
Jake Calder 101183666
Alex Tempel 101225006
Nicholas Kam 101186688
Peter Willis 101153612
Nicholas Nemec 101211060

FloorSubSystem.java, Elevator.java, Scheduler.java; are all threads, they pass request between them
Rest of the files currently do not have functionality.
Input.CSV gets parsed and becomes the requests that are sent from the Floor Subsystem to the Scheduler to the elevator
generate input.py is used to create a new Input.CSV with random requests

Instructions:
Run Main.java to run the program
Use generate input.py to create a new Input.csv file with random requests

sequence of events

1 - floor subsystem reads input csv and creates a list of requests ( in format )
  - scheduler constantly polling floor sub checking if there is a request for the current time
  - elevator constantly polling scheduler sub checking if there is a request 

2 - when request time=now, request is sent to scheduler, then to elevator
  - scheduler polling for elevator to pass confirmation response
  - floor polling for scheduler to pass confirmation response
3 - elevator moves to requested floor
4 - elevator moves to dest floor
5 - elevator sends confirmation response to scheduler
6 - scheduler sends confirmation response to floor sub
7 - floor sub marks successfully fulfilled request, repeat process for next event (@ time)

Files used - Input.csv, FloorSubSystem.java, Request.java, input.csv,
             Elevator.java, Scheduler.java, Floor.java, generate input.py

Responsibilities Breakdown:
Alex: Scheduler, Forwarding Request to elevator. Testing the code
Nick K.: Elevator class, confirmation in response to request from the floor,
         request from floor, send confirmation response to floor, Testing the code
Jake: Floor subsystem, request to scheduler, receive confirmation response,
      mark as done and print msg for completed request, Testing the code
Peter: UML Class and Sequence Diagram - help with CSV reader
Nik N.: Read input CSV file and create requests