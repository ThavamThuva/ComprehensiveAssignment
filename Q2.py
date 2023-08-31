import math

class CircleComp:
    def __init__(self, radius):
        self.radius = radius
        self.diameter = self.radius * 2.0
        self.circumference = 2 * math.pi * self.radius
        self.area = math.pi * self.radius * self.radius
        
    def display(self):
        print(f"Diameter: {self.diameter}")
        print(f"Area: {self.area}")

radius = float(input("Type radius of the circle: "))
circle = CircleComp(radius)
circle.display()
