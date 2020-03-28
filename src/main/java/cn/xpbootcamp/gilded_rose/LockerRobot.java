package cn.xpbootcamp.gilded_rose;

import java.util.*;

public class LockerRobot {
    Map<Ticket, Bag> _ticker2bag = new HashMap<>();
    int _capacity = 19;

    public LockerRobot() {
        this(19);
    }

    public LockerRobot(int capacity) {
        _capacity = capacity;
    }

    public Ticket deposit(Bag bag) {
        if (_ticker2bag.size() >= _capacity) {
            return null;
        }

        Ticket ticket = new Ticket();
        _ticker2bag.put(ticket, bag);
        
        return ticket;
    }

    public Bag take(Ticket ticket) {
        if (ticket == null) {
            return null;
        }
        
        return _ticker2bag.remove(ticket);
    }
}
