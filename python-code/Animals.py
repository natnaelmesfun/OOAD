#!/usr/bin/env python
# coding: utf-8

# In[5]:

class Animals:
    
    def __init__(self, name):
        self.name = name
        
        
    def makeNoise(self):
        print("My type is ", self.__class__.__name__, self.name, " Making Noise")

    def sleep(self):
        print("My type is ", self.__class__.__name__, self.name, " Going to sleep")
        
    def eat(self):
        print("My type is ", self.__class__.__name__, self.name, " Eating my meal")

    def roam(self):
        print("My type is ", self.__class__.__name__, self.name, " Moving around")

    def wakingUp(self):
        print("My type is ",  self.__class__.__name__, self.name, "good morning")

