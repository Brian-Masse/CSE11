import math


for x in range(0, 1000000):
    expression = x**2 + x
    floor = math.floor( math.sqrt( expression ) )
    square = floor**2
    if square == expression:
        print( "found match" + str(x) + ", expression: " + str(expression)  )