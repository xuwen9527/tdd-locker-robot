package cn.xpbootcamp.gilded_rose;

import java.util.*;

public class Locker {
    Map<Ticket, Bag> storedBags = new HashMap<>();
    int _capacity = 0;

    public Locker(int capacity) {
        _capacity = capacity;
    }

    public Ticket deposit(Bag bag) {
        if (available() == false) {
            return null;
        }

        Ticket ticket = new Ticket();
        storedBags.put(ticket, bag);
        
        return ticket;
    }

    public Bag take(Ticket ticket) {
        if (ticket == null) {
            return null;
        }
        
        return storedBags.remove(ticket);
    }

    public boolean available() {
        return storedBags.size() < _capacity;
    }

    public int countOfBags() {
        return storedBags.size();
    }
}
