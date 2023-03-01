import random

amount = random.randint(0,20) + round(random.randint(0,100)/100,2)

print("Amount to be paid is: "+str(amount))
payment = float(input("Enter amount of payment: "))

change = payment - amount

if change > 0:
    d = 0
    q = 0
    i = 0
    n = 0

    d = change - change%1
    change = change - d

    if change > 0:
        amt = 0.25
        while amt < change:
            q+=1
            amt+=0.25

        change -= amt - 0.25

        amt = 0.1
        while amt < change:
            i += 1
            amt += 0.1

        change -= amt - 0.1

        if change > 0.05:
            i+=1
        elif change > 0:
            n = 1

    print("You got "+str(d)+" dollars, "+str(q)+" quarters, "+str(i)+" dimes and "+str(n)+" nickels back in change")

else:
    print("No change owed")
	
	
	