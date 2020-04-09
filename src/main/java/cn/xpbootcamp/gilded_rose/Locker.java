package cn.xpbootcamp.gilded_rose;

import java.util.*;

public class Locker {
    Map<Ticket, Bag> storedBags = new HashMap<>();
    int _capacity = 0;

    public Locker(int capacity) {
        _capacity = capacity;
    }

    public Ticket deposit(Bag bag) {
        if (availableCount() <= 0) {
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

    public int availableCount() {
        return _capacity - storedBags.size();
    }
}
