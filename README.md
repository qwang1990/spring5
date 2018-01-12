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

## advice的类型
- Before advice:在join point之前执行增强，它没有中断join point后续执行的能力(除非抛异常)
- After returning advice:在join point正常执行完后执行增强
- After throwing advice:当方法抛出异常的时候执行增强
- After(finally) advice:无论join point如何结束都执行增强
- Around advice:在方法执行的前后来增强。这种类型的增强是能力最大的，它可以在方法执行的前或后加入自定义的行为。它也可以是否继续执行或直接
返回或抛出异常。

## Spring AOP的能力和目标
Spring AOP是用纯java实现的，不需要其他的特别编译，不用控制类加载机制，所以适合用在servlet容器和应用中。

Spring AOP暂时只支持方法类型join point(建议是spring beans中的方法)。字段interception暂时不支持，虽然它可以在不破坏Spring AOP核心api
的基础上添加。如果你想增强字段，可以考虑使用AspectJ。

Spring AOP的实现和其他大多AOP框架不尽相同。它致力于更紧密的结合AOP实现和Spring IoC，而不是提供最完成的AOP实现。

因此Spring AOP通常用于结合Spring IoC。切面可以使用普通的bean的语法。这是Spring AOP和其他AOP最大的不同。当然也有很多事情使用不适合使用
Spring AOP，比如增强一个细粒度的对象？？（例如domain object），这时使用AspectJ是一个更好的选择。

Spring AOP从来不在提供完备的AOP功能上和AspectJ竞争。我相信每种proxy-based框架如Spring AOP和AspectJ都是有价值的。它们的关系应该是互相协作
而不是竞争。Spring为了能使所有的AOP用户无缝集成了Spring AOP，IoC和AspectJ。

## AOP 代理
Spring AOP默认是使用标准的JDK动态代理。它可以代理任意的interface。当Spring AOP需要代理一个类而不是接口时，它也可以使用CGLIB代理。当业务对象
没有实现接口的时候默认使用CGLIB。你也可以强制使用CGLIB(希望不要经常这样)

## 支持@AspectJ注解
@AspectJ用来把常规java类标声明为切面。它是在AspectJ 5 release版本被引入的，Spring使用了同样的注解，使用AspectJ提供的库来解析匹配切点。尽管如此
AOP用的还是纯的Spring AOP，没有依赖AspectJ的编译或植入。

## 开启@AspectJ
Spring可以通过XML或JAVA配置类的方式来支持@AspectJ。但是无论哪种形式，你要首先确保在你项目的类路径里有aspectjweaver.jar这个包

- 使用JAVA配置类的形式
```java
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

}
```
- 使用XML配置的形式
```xml
<aop:aspectj-autoproxy/>
```

## 声明一个aspect
在你的程序中的任意一个class，只要以@AspectJ为注解就能被Spring自动检测到称为切面。
```java
package org.xyz;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class NotVeryUsefulAspect {

}
```
切面和其他的类一样可以有方法和字段。它们也可以包含pointcut，advice，introduction。
> 注意：切面不可再被增强。当class带有@Aspect注解以后，他就不会被auto-proxying了。

## 声明pointcut
回忆一下pointcut决定着对那个join points感兴趣，因此也控制了增强执行的时机。Spring AOP值支持方法执行的join point，所以你可以认为pointcut
就是匹配方法的。一个pointcut声明包含两部分:1.签名包含名字和参数，2.一个pointcut表达式，用来决定感兴趣的方法。在@AspectJ注解风格的AOP中，
签名是有一个普通的方法定义提供的，pointcut表达式是包含在注解里的。
> 为pointcut的方法返回值必须为void

下面这个例子就是一个pointcut，名字为anyOldTransfer，它会匹配所有名为'transfer'的方法
```java
@Pointcut("execution(* transfer(..))")// pointcut表达式
private void anyOldTransfer() {}// 签名
```
pointcut表达式是标准的AspectJ5切点表达式，详情关注:[AspectJ Programming Guide](https://www.eclipse.org/aspectj/doc/released/progguide/index.html)




























