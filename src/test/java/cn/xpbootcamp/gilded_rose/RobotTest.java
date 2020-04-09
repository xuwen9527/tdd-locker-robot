package cn.xpbootcamp.gilded_rose;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class RobotTest {
    //deposit bag case
    @Test
    public void should_get_1_ticket_when_robot_deposit_1_bag_given_3_lockers_and_each_one_has_10_capaticy() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());
        assertNotNull(ticket);
    }

    @Test
    public void should_get_2_not_same_tickets_when_robot_deposit_2_bags_given_3_lockers_and_each_one_has_10_capaticy() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        Ticket ticket1 = robot.deposit(new Bag());
        Ticket ticket2 = robot.deposit(new Bag());
        
        assertNotEquals(ticket1, ticket2);
    }
    
    @Test
    public void should_get_11_tickets_and_first_locker_has_10_bags_and_second_locker_has_1_bag_when_robot_deposit_11_bags_given_3_lockers_and_each_one_has_10_capaticy() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        int ticketCount = 0;
        for (int i = 0; i < 11; ++i) {
            robot.deposit(new Bag());
            ++ticketCount;
        }
        assertEquals(11, ticketCount);
    }

    @Test
    public void should_deposit_fail_when_robot_deposit_1_bag_given_3_lockers_and_each_one_has_0_capaticy() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(0));
        lockers.add(new Locker(0));
        lockers.add(new Locker(0));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());
        assertNull(ticket);
    }

    @Test
    public void should_deposit_fail_when_robot_deposit_1_bag_given_0_locker() {
        List<Locker> lockers = new ArrayList<>();

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());
        assertNull(ticket);
    }

    @Test
    public void should_deposit_fail_when_robot_deposit_1_bag_given_3_lockers_and_each_one_has_been_deposit_10_bags() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        for (int i = 0; i < 30; ++i) {
            robot.deposit(new Bag());
        }
        Ticket ticket = robot.deposit(new Bag());
        assertNull(ticket);
    }
    
    //take bag case
    @Test
    public void should_get_1_original_bag_when_robot_take_bag_with_1_ticket_given_3_lockers_and_each_one_has_10_capacity_and_lockers_has_been_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        Bag takedBag = robot.take(ticket);
        assertEquals(bag, takedBag);
    }

    @Test
    public void should_get_11_bags_when_robot_take_bag_with_11_tickets_given_3_lockers_and_each_one_has_10_capacity_and_lockers_has_been_deposit_11_bags() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < 11; ++i) {
            tickets.add(robot.deposit(new Bag()));
        }

        int bagCount = 0;
        for (Ticket ticket : tickets) {
            if (robot.take(ticket) != null) {
                ++bagCount;
            }
        }

        assertEquals(11, bagCount);
    }

    @Test
    public void should_get_bag_fail_when_robot_take_bag_with_1_invalid_ticket_given_3_lockers_and_each_one_has_10_capacity_and_lockers_have_been_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        robot.deposit(new Bag());

        Ticket ticket = new Ticket();
        Bag bag = robot.take(ticket);
        assertNull(bag);
    }

    @Test
    public void should_get_bag_fail_when_robot_take_bag_with_1_used_ticket_given_3_lockers_and_each_one_has_10_capacity_and_lockers_have_been_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));
        lockers.add(new Locker(10));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());
        
        robot.take(ticket);
        Bag bag = robot.take(ticket);

        assertNull(bag);
    }
}