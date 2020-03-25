package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.List;

public class LockerRobot {
    private int count;

    public LockerRobot() {
        count = 19;
    }

    public Ticket deposit() {
        if (count == 0) {
            return null;
        }

        int id = count;
        count--;
        return new Ticket(id);
    }

    public int getAvailableCount() {
        return count;
    }

    public Boolean take(Ticket ticket) {
        if (ticket.getId() <= count) {
            return false;
        }
        count++;
        return true;
    }
}
