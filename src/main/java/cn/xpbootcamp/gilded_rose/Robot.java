package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private List<Locker> _lockers = new ArrayList<>();

    public Robot(List<Locker> lockers) {        
        _lockers = lockers;        
    }

    public Ticket deposit(Bag bag) {
        Locker max_locker = null;
        int max_available_count = 0;

        for (Locker locker : _lockers) {
            int available_count = locker.availableCount();
            if (available_count > max_available_count) {
                max_available_count = available_count;
                max_locker = locker;
            }
        }

        if (max_locker == null)
            return null;

        return max_locker.deposit(bag);
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