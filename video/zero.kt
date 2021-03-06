fun main(args: Array<String>) {
    learn().let(::println)
}
fun learn(): String {
    return """  zero learn
        01 什么是学习：
            记忆!=学习  记忆：容量有限，难以集齐
            可重复 -> 有限例子 -> 学习 -> 压缩信息 -> 无数情况 -> 规律/知识
                          记忆            学习
                        容量有限         找出知识
                        难以集齐         压缩信息
        02 如何学习：
            在人脑中，学习是通过例子找出问题和答案的规律重塑大脑链接而完成     第一步：明确什么是问题，什么是答案。      学习=!记忆  知识!=信息
            学习步骤：明确问题和答案
                    用例子构建知识
                    验证知识有效性
        03 学习误区：
            明确  问题/输入 -> 答案/输出  用例子构建知识
            学习方式：                                                   误区：
                运动类  思考类  -->  是否依靠意识 -> 意识是后进化出来的              1.错误的输入输出
                语言    数学                      擅长解决推断问题               2.错误的学习方式
                运动    逻辑                      速度缓慢                      3.不用例子学习
        04 应用误区：
            运动类能力可并行(边走路边聊天)，但意识在某一时刻只能专注于一个思考类问题
                搜索输入->输出的知识 -> 知识有限 ->  问题无法解决      应对办法： 多学知识
                                                                        分而治之  -->  指数级 -> 线性级
        05 构建知识：
                00 特别连接：    人类：                         机器：
                        为何学习：  找出规律             为何建模：  识别模式
                                  压缩信息                       压缩数据

                        如何学习：  明确任务             如何建模：  明确任务
                                  通过例子                       样本训练

                                  错误输入输出                    错误输入输出
                        学习误区：  错误知识类型          建模误区：  错误学习算法  -->  浅层学习
                                  把知识当信息                    错误迁移方式  -->  深度学习

                        如何应用：  分而治之             如何应用：  分而治之
                                  二阶知识                       先验知识

-----------------------------------------------------------------------------------------------------------------------

                    定义： 从有限例子找出规律
                          将信息压缩成知识

                    原则： 明确知识的输入输出
            学习：         用例子重塑大脑链接       【用新例子来验证知识】
                          理清关系与拆分知识                                      头脑风暴
                                                            搜集例子    -->     上网调查
                    方法： 思维导图    -->     使用步骤    -->                                     它是什么
                          费曼技巧                            自我提问  ->  一阶知识  ->  分类  ->  为什么是

                                                                                     回归  ->  它的目的
                                                                                              如何达成

                                                                         二阶知识  ->  组合关系  ->  它有什么
                                                                                     执行步骤  ->  先后顺序

                                                                        外框  ->  视角、注意力
                                                                        联系  ->  跨层知识关系
                                                          工具使用  -->  笔记   ->  知识描述
                                                                        概要  ->  显示描述

                                            使用技巧   -->  知识命名  ->  定语名词
                                                                      动词宾语

                                                                        记录所有信息
                                                                        知识间不独立
                                                          使用误区  -->　　记忆他人导图
                                                                        从不验证更新
                                                                        画无规律信息

                    　手段  　->  　目的　
                    学习方法　->  学习原理

        06 费曼技巧　-->  学习　　-->   将信息压缩成知识
                                    明确输入输出任务
                                    例子重塑大脑链接
                                    拆分知识理清关系

                        解释　-> 提取压缩
                                          　明确任务
                             -> 转为语言 ->　拆分知识
                                          　理清关系

                             -> 列举例子　-> 　新例子
                                          　新视角

-----------------------------------------------------------------------------------------------------------------------

        入门线性代数和微积分：
           累积因素(Linear Algebra) と 累积速度(Calculus)   -> 匀速积累(线性)
                                                        -> 变速积累(非线性)
                匀速： 单因素累积单因素(标量＊标量)  ->  积累速度：除法  y/x=w, w=标量  ||　 积累总量：乘法　y=wx, w=标量
                      多因素累积单因素(向量＊向量)
                      多因素累积多因素(矩阵＊向量)
                      批量多因素累积多因素（矩阵＊矩阵）

                变速：=> 单因素 -> 累积速度：微分    dy/dx=w, w=导数
                                累积总量：积分     y=∫wdx, w=变量

                        多因素 -> 累积速度：微分  dy/dx=w, w=[w1,w2]
                                                    偏导数
        """
}