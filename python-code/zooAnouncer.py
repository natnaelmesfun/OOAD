from abc import *
from ZooKeeper import ZooKeeper

class observerInterface():
    def subscribe(self): pass
    def unsubsribe(self): pass


class zooAnouncer(observerInterface):

    def subscribe(self, zoo):
        # print("subscribe")
        zoo.registerObserver(self)
    def unsubscribe(self, zoo):
        # print("unsubscribe")
        zoo.removeObserver(self)
    def update(self, order):
        print("Hi This is ZooAnnouncer. The Zookeeper is about to")
        print(order)    