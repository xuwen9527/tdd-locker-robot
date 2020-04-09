package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ###存包
 * * 1 Given 储物柜有空位，When 机器人存放1个包， Then 机器人存包成功并收到1个取包ticket
 * * 2 Given 储物柜有空位，一个储物柜空位数为1，另一个储物柜空位数为2，When 机器人存放1个包， Then 机器人存包成功并收到1个取包ticket
 * * 3 Given 储物柜无空位，When 机器人存放1个包， Then 机器人存包失败
 * ###取包
 * * 4 Given 储物柜有空位, When 机器人使用1个合法ticket取包, Then 机器人取包成功且对应的包被取出
 * * 5 Given 储物柜有空位, When 机器人使用1个非法ticket取包，Then 机器人取包失败
 * * 6 Given 储物柜有空位, When 机器人使用已被使用ticket取包， Then 机器人取包失败
 */
public class SmartRobotTest {
    @Test
    void should_deposit_successfully_and_get_1_ticket_given_locker_is_available_when_robot_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());
        assertNotNull(ticket);
    }

    @Test
    void should_deposit_successfully_and_get_1_ticket_given_available_amount_of_one_locker_is_1_and_the_other_locker_is_2_when_robot_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));
        lockers.add(new Locker(2));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());
        assertNotNull(ticket);
    }

    @Test
    void should_deposit_fail_and_get_error_message_given_locker_is_unavailable_when_robot_deposit_1_bag() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        robot.deposit(new Bag());
        Ticket ticket = robot.deposit(new Bag());
        assertNull(ticket);
    }

    @Test
    void should_take_successfully_and_get_right_bag_given_locker_is_available_when_robot_take_one_bag_out_by_a_valid_ticket() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        Bag takenBag = robot.take(ticket);
        assertEquals(bag, takenBag);
    }

    @Test
    void should_take_fail_and_get_error_message_given_locker_is_available_when_robot_take_one_bag_by_an_invalid_ticket() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        robot.deposit(new Bag());

        Ticket ticket = new Ticket();
        Bag bag = robot.take(ticket);
        assertNull(bag);
    }

    @Test
    void should_take_fail_and_get_error_message_given_locker_is_available_when_robot_take_one_bag_by_an_used_ticket() {
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new Locker(1));

        Robot robot = new Robot(lockers);
        Ticket ticket = robot.deposit(new Bag());

        robot.take(ticket);
        Bag bag = robot.take(ticket);

        assertNull(bag);
    }
}
