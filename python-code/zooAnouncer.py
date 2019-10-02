from abc import *
from ZooKeeper import *

class observerInterface():
    def subscribe(): pass
    def unsubsribe(): pass


class zooAnouncer(observerInterface):
    def subsribe(self):
        ZooKeeper.registerObserver(self)
    def unscribe(self):
        ZooKeeper.removeObserver(self)
    def update(self, order):
        print(order)