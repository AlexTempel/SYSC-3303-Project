SYSC 3303 Project Group 8

sequence of events

1 - floor subsystem reads input csv and creates a list of requests ( in format )
  - scheduler constantly polling floor sub checking if there is a request for the current time
  - elevator constantly polling scheduler sub checking if there is a request 

2 - when request time=now, request is sent to scheduler, then to elevator
