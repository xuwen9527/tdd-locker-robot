package cn.xpbootcamp.gilded_rose;

import java.io.ObjectInputStream.GetField;

public class LockerRobot {
    private int count;
    private int current;

    public LockerRobot() {
        count = 19;
        current = 19;
    }

    public LockerRobot(int count) {
        this.count = count;
        current = count;
    }

    public Ticket deposit() {
        if (current == 0) {
            return null;
        }

        int id = current;
        current--;
        return new Ticket(id);
    }

    public int getAvailableCount() {
        return current;
    }

    public boolean checkTicket(Ticket ticket) {
        int ticketId = ticket.getId();
        return ticketId > current && ticketId <= count;
    }

    public boolean take(Ticket ticket) {
        if (!checkTicket(ticket)) {
            return false;
        }
        current++;
        return true;
    }
}
