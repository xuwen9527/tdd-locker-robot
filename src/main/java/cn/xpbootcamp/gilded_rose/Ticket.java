package cn.xpbootcamp.gilded_rose;

public class Ticket {
    private int id;

    public Ticket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Ticket) {
            Ticket other = (Ticket)o;
            return other.getId() == id;
        }

        return false;
    }
}
