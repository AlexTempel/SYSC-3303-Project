SYSC 3303 Project Group 8

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

Files used - input.csv, FloorSubSystem.java, Request.java,
             Elevator.java, Scheduler.java, Floor.java