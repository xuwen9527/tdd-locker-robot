#### 存包
* Given 3个寄存柜，每个寄存柜可存放10个包, When 机器人存放1个包，Then 得到1个ticket
* Given 3个寄存柜，每个寄存柜可存放10个包，When 机器人存放2个包，Then 得到两个不同的Ticket
* Given 3个寄存柜，每个寄存柜可存放10个包，When 机器人存放11个包，Then 得到11个Ticket
* Given 3个寄存柜，每个寄存柜可存放0个包，When 机器人存放1个包，Then 存包失败
* Given 0个寄存柜，When 机器人存放1个包，Then 存包失败
* Given 3个寄存柜，每个寄存柜可存放10个包，3个寄存柜均已存放10个包，When 机器人存放1个包，Then 存包失败

#### 取包
* Given 3个寄存柜，每个寄存柜可存放10个包，寄存柜已经存放1个包，When 机器人用1个存入时获得的ticket取包，Then 取得1个存放时的包
* Given 3个寄存柜，每个寄存柜可存放10个包，寄存柜已经存放11个包，When 机器人用11个存入时获得的ticket取包，Then 取得11个包
* Given 3个寄存柜，每个寄存柜可存放10个包，寄存柜已经存放1个包，When 机器人用1个无效的ticker取包，Then 取包失败