* Given 可用柜子为19个, When 存放1个包, Then 收到1个取包ticket
* Given 可用柜子为19个, When 依次存放2个包, Then 收到2个不同的取包ticket
* Given 可用柜子为0个, When 存放1个包, Then 无法存包
* Given 可用柜子为18个，使用1个合法ticket, When 取包, Then 对应的包被取出
* Given 可用柜子为18个，使用已被使用ticket, When 取包, Then 无包取出
* Given 可用柜子为18个，使用1个非法ticket, When 取包, Then 无包取出