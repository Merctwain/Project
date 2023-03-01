# I Mahum_Tariq, 000848909, certify that this work is my own effort and that I have not allowed anyone else to copy from it.

# ---- Question 1a ----

def question1a(ph):
    if ph == 7:
        return "neutral"
    elif ph < 4:
        return "very acidic"
    elif ph < 7:
        return "acidic"
    elif ph > 10:
        return "very basic"
    elif ph > 7:
        return "basic"

print("Question 1\n")
print( "Running solution to question 1a …")
print( "Assuming valid numeric input" )
ph = float(input("What is the pH that you want to know about? "))
answer = question1a( ph )
print( "The answer is: " + answer +"\n")

# --- Question 1b ---

def question1b(min, max):
    liquid = False
    crops = False
    if min > 0 and max < 100:
        liquid = True

    if min > 21 and min < 32:
        crops = True

    string = ""
    if liquid:
        string+="The planet can sustain liquid water"
    else:
        string+="The planet cannot sustain liquid water"

    if crops:
        string+=", the planet can grow crops"
    else:
        string +=", the planet cannot grow crops"

    if crops and liquid:
        string+=", the planet is habitable"
    else:
        string +=", the planet is not habitable"

    return string

print( "Running solution to question 1b …")
print( "Assuming valid numeric input" )
min = float(input("What is the minimum temperature of the planet? "))
max = float(input("What is the maximum temperature of the planet? "))
answer = question1b( min, max )
print( "The answer is: " + answer +"\n")

# --- Question 1c ---

def question1c(a, b,c):
    triangle = False
    type = "scalene"
    if (a+b) > c and (b+c) > a and (a+c) > b:
        triangle = True

    if a == b and b == c:
        type = "equilaterial"
    elif a==b or b==c or a==c:
        type = 'isosceles'

    if triangle:
        return "The triangle is valid with and is "+type
    else:
        return "The triangle is not valid"

print( "Running solution to question 1c …")
print( "Assuming valid numeric input" )
a = int(input("What is the length of side a of the triangle? "))
b = int(input("What is the length of side b of the triangle? "))
c = int(input("What is the length of side c of the triangle? "))
answer = question1c( a, b, c )
print( "The answer is: " + answer +"\n")


# ---- Question 2 ----

print("\nQuestion 2\n")
print("Running solution to question 1a …")
print("Assuming valid numeric input")
value = (input("What is the pH that you want to know about? "))
while value != "quit":
    answer = question1a(float(value))
    print("The answer is: " + answer +"\n")
    value = (input("What is the pH that you want to know about? "))








