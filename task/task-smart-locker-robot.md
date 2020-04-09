###存包
* 1 Given 储物柜有空位，When 机器人存放1个包， Then 机器人存包成功并收到1个取包ticket
* 2 Given 储物柜有空位，一个储物柜空位数为1，另一个储物柜空位数为2，When 机器人存放1个包， Then 机器人存包成功并收到1个取包ticket
* 3 Given 储物柜无空位，When 机器人存放1个包， Then 机器人存包失败
###取包
* 4 Given 储物柜有空位, When 机器人使用1个合法ticket取包, Then 机器人取包成功且对应的包被取出
* 5 Given 储物柜有空位, When 机器人使用1个非法ticket取包，Then 机器人取包失败
* 6 Given 储物柜有空位, When 机器人使用已被使用ticket取包， Then 机器人取包失败