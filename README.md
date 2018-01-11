# spring5
spring5

# AOP
## 概念
- Aspect(切面): 一个衡切很多class的模块。事物管理就是一个很好的例子。在Spring AOP中，切面由普通的class实现(schema-based approach)
或带注解@Aspect的不同class实现。
- Join point(连接点):程序执行中的点，如方法的调用或异常的抛出，在Spring AOP中专指程序的调用。
- Advice(增强): 切面在特定的切入点执行的动作。类型有:'around','before','after'。很多AOP框架(包括Spring)把advice已interceptor的形式
来实现，管理一个围绕着连接点的interceptors串。
- Pointcut(切入点):符合切入条件的连接点。advice是和pointcut表达式相关联的，在连接点符合条件时执行。
- Introduction(引入): 将方法和字段添加到被处理的类中。Spring允许你将新的接口(和对应的实现)引入到任何被处理的对象中。比如你可以使任何对象
实现IsModified接口来简化缓存。
- Target Object(目标对象):被增强的对象。如果AOP框架使用动态代理实现，它也被称为被代理的对象。
- AOP proxy(AOP 代理): AOP框架创建的对象，用于实现增强。在Spring Framework中，AOP代理有可能是JDK的动态代理或者是CGLIB代理。
- Weaving(植入):链接其他对象或应用创建增强对象的过程。可以在编译期(如:AspectJ compiler)，加载期，或运行期。Spring AOP和其他
纯Java AOP框架都是在运行期进行植入的。