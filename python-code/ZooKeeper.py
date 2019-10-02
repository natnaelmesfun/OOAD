#!/usr/bin/env python
# coding: utf-8

# In[3]:

from Animals import Animals
from abc import *
from zooAnouncer import *

class zooInterface():
    def registerObserver(self): pass
    def removeObserver(self): pass
    def notifyObserver(self): pass

class ZooKeeper(zooInterface):
#     Zoo keeper performs his duty through different methods listed below.
#     Each method takes it animal object as a parameter so it can ask corresponding move for animals to behave
#     when Zoo Keeper executes certain action.
    observers = []

    def registerObserver(self, observer):
        observers.append(observer)
    def removeObserver(self, observer):
        observers.remove(observer)
    def notifyObserver(self, order):
        for obs in self.observers:
            obs.update(order)

    def wake(self, Animals):
        self.notifyObserver("wake animals")
        Animals.wakingUp()

    def rollCall(self, Animals):
        self.notifyObserver("Calling animals")
        Animals.makeNoise()

    def feed(self, Animals):
        self.notifyObserver("feed animals")
        Animals.eat()

    def exercise(self, Animals):
        self.notifyObserver("exercise animals")
        Animals.roam()

    def shut(self, Animals):
        self.notifyObserver("Shut the zoo")
        Animals.sleep()

