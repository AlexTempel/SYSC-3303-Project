import random

with open("Input.csv", 'w') as file:
    file.write("Time Floor FloorButton Carbutton\n")
    file.close()

with open("Input.csv", 'a') as file:
    for i in range(0, 10000):
        rand_hours = str(random.randint(0, 23))
        if (int(rand_hours) < 10):
            rand_hours = "0" + rand_hours
        rand_minute = str(random.randint(0, 59))
        if (int(rand_minute) < 10):
            rand_minute = "0" + rand_minute
        rand_second = str(random.randint(0, 59))
        if (int(rand_second) < 10):
            rand_second = "0" + rand_second
        
        rand_starting_floor = str(random.randrange(1, 22))
        if (random.random() > 0.5 or rand_starting_floor == "1") and rand_starting_floor != "22":
            rand_direction = "Up"
        else:
            rand_direction = "Down"
            
        if rand_direction == "Up":
            if rand_starting_floor == "21":
                rand_end_floor = "22"
            else:
                rand_end_floor = str(random.randrange(int(rand_starting_floor) + 1, 22))
        else:
            if rand_starting_floor == "2":
                rand_end_floor = "1"
            else:
                rand_end_floor = str(random.randrange(1, int(rand_starting_floor) - 1))
        
        file.write(rand_hours + ":" + rand_minute + ":" + rand_second + ".0" + " " + rand_starting_floor + " " + rand_direction + " " + rand_end_floor + "\n")

    file.close()