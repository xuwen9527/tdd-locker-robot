package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Given 可用柜子为19个, When 存放1个包, Then 收到1个取包ticket，可用柜为18个
Given 可用柜子为19个, When 依次存放2个包, Then 收到2个不同的取包ticket，可用柜为17个
Given 可用柜子为0个, When 存放1个包, Then 无法存包
Given 可用柜子为18个, When 使用1个合法ticket取包, Then 对应的包被取出，可用柜19个
Given 可用柜子为18个, When 使用已被使用ticket取包, Then 无包取出
Given 可用柜子为18个, When 使用1个非法ticket取包, Then 无包取出
*/
public class LockerRobotTest {
    @Test
    void should_return_1_ticket_and_18_available_when_deposit_1_given_19_available () {
        LockerRobot robot = new LockerRobot();
        Ticket tickets= robot.deposit();

        int size = robot.getAvailableCount();
        assertEquals(18, size);
    }

    @Test
    void should_2_ticket_and_17_available_when_deposit_2_given_19_available () {
        LockerRobot robot = new LockerRobot();
        Ticket ticket1 = robot.deposit();
        Ticket ticket2 = robot.deposit();

        assertNotEquals(ticket1, ticket2);

        int count = robot.getAvailableCount();
        assertEquals(17, count);
    }

    @Test
    void should_deposit_fail_when_deposit_1_given_0_available () {
        LockerRobot robot = new LockerRobot();
        int count = robot.getAvailableCount();
        for (int i = 0; i < count; i++) {
            robot.deposit();
        }
        assertEquals(0, robot.getAvailableCount());

        Ticket ticket = robot.deposit();
        assertNull(ticket);
    }

    //Given 可用柜子为18个, When 使用1个合法ticket取包, Then 对应的包被取出，可用柜19个
    @Test
    void should_take_successfully_19_available_when_valid_ticket_and_take_once_given_18_available () {
        LockerRobot robot = new LockerRobot();
        robot.deposit();
        assertEquals(18, robot.getAvailableCount());

        Ticket ticket = new Ticket(19);
        assertTrue(robot.take(ticket));

        assertEquals(19,robot.getAvailableCount());
    }

    //Given 可用柜子为18个, When 使用已被使用ticket取包, Then 无包取出
    @Test
    void should_take_fail_when_valid_ticket_and_take_twice_given_18_available () {
        LockerRobot robot = new LockerRobot();
        robot.deposit();
        assertEquals(18, robot.getAvailableCount());

        Ticket ticket1 = new Ticket(19);
        assertTrue(robot.take(ticket1));
        assertEquals(19, robot.getAvailableCount());

        Ticket ticket2 = new Ticket(19);
        assertFalse(robot.take(ticket2));

    }

    //Given 可用柜子为18个, When 使用1个非法ticket取包, Then 无包取出
    @Test
    void should_take_fail_when_invalid_ticket_and_take_once_given_18_available () {
        LockerRobot robot = new LockerRobot();
        robot.deposit();
        assertEquals(18, robot.getAvailableCount());

        Ticket ticket1 = new Ticket(-1);
        assertFalse(robot.take(ticket1));

        Ticket ticket2 = new Ticket(17);
        assertFalse(robot.take(ticket2));

    }

}
