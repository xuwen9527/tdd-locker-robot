package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Given 可用柜子为19个, When 存放1个包, Then 收到1个取包ticket
Given 可用柜子为19个, When 依次存放2个包, Then 收到2个不同的取包ticket
Given 可用柜子为0个, When 存放1个包, Then 无法存包
Given 可用柜子为18个, When 使用1个合法ticket取包, Then 对应的包被取出
Given 可用柜子为18个, When 使用已被使用ticket取包, Then 无包取出
Given 可用柜子为18个, When 使用1个非法ticket取包, Then 无包取出
*/
public class LockerTest {
    @Test
    void should_return_1_ticket_when_deposit_1_bag_given_19_available () {
        Locker robot = new Locker(19);
        
        Ticket ticket = robot.deposit(new Bag());
        assertNotNull(ticket);
    }

    @Test
    void should_2_ticket_when_deposit_2_bag_given_19_available () {
        Locker robot = new Locker(19);

        Ticket ticket1 = robot.deposit(new Bag());
        Ticket ticket2 = robot.deposit(new Bag());
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void should_deposit_fail_when_deposit_1_given_0_available () {
        Locker robot = new Locker(19);
        for (int i = 0; i < 19; i++) {
            robot.deposit(new Bag());
        }

        Ticket ticket = robot.deposit(new Bag());
        assertNull(ticket);
    }

    //Given 可用柜子为18个, When 使用1个合法ticket取包, Then 对应的包被取出，可用柜19个
    @Test
    void should_take_successfully_19_available_when_valid_ticket_and_take_once_given_18_available () {
        Locker robot = new Locker(19);

        Bag bag = new Bag();
        Ticket ticket = robot.deposit(bag);

        assertEquals(robot.take(ticket), bag);
    }

    //Given 可用柜子为18个, When 使用已被使用ticket取包, Then 无包取出
    @Test
    void should_take_fail_when_valid_ticket_and_take_twice_given_18_available () {
        Locker robot = new Locker(19);

        Bag bag = new Bag();
        Ticket ticket1 = robot.deposit(bag);
        robot.take(ticket1);

        assertNull(robot.take(ticket1));
    }

    //Given 可用柜子为18个, When 使用1个非法ticket取包, Then 无包取出
    @Test
    void should_take_fail_when_invalid_ticket_and_take_once_given_18_available () {
        Locker robot = new Locker(19);
        
        Bag bag = new Bag();
        robot.deposit(bag);

        Ticket ticket1 = new Ticket();
        assertNull(robot.take(ticket1));
    }
}
