package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private List<Locker> _lockers = new ArrayList<>();

    public Robot(List<Locker> lockers) {        
        _lockers = lockers;        
    }

    public Ticket deposit(Bag bag) {
        for (Locker locker : _lockers) {
            if (locker.available())
                return locker.deposit(bag);
        }
        return null;
    }

    public Bag take(Ticket ticket) {
        for (Locker locker : _lockers) {
            Bag bag = locker.take(ticket);
            if (bag != null) {
                return bag;
            }
        }
        return null;
    }
}