#!/usr/bin/env python
# coding: utf-8

# In[3]:

from Animals import Animals
from abc import *

# observer pattern is applied 

class zooInterface():
    def registerObserver(self): pass
    def removeObserver(self): pass
    def notifyObserver(self): pass

class ZooKeeper(zooInterface):

    def __init__(self):
        self.observers = []
    #     Zoo keeper performs his duty through different methods listed below.
#     Each method takes it animal object as a parameter so it can ask corresponding move for animals to behave
#     when Zoo Keeper executes certain action.

    def registerObserver(self, observer):
        self.observers.append(observer)
        # print(observer)
    def removeObserver(self, observer):
        self.observers.remove(observer)
        
    def notifyObserver(self, order):
        for obs in self.observers:
            obs.update(order)

    def wake(self, animals):
        self.notifyObserver("wake animals")
        for animal in animals:
            animal.wakingUp()

    def rollCall(self, animals):
        self.notifyObserver("call animals")
        for animal in animals:
            animal.makeNoise()

    def feed(self, animals):
        self.notifyObserver("feed animals")
        for animal in animals:
            animal.eat()

    def exercise(self, animals):
        self.notifyObserver("exercise animals")
        for animal in animals:
            animal.roam()

    def shut(self, animals):
        self.notifyObserver("shut the zoo")
        for animal in animals:
            animal.sleep()

