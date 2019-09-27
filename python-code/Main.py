import Cat
import Lion
import ZooKeeper



class Main:
    if __name__ == '__main__':
        catie = Cat("catie")
        canny = Cat("cannie")
        lune = Lion("Lune")
        larry =Lion("Larry")
        john = ZooKeeper()

        store = [catie, canny, lune, larry]

        for animal in store:
            john.wake(store[animal])
            john.rollCall(store[animal])
            john.feed(store[animal])
            john.exercise(store[animal])
            john.shut(store[animal])

