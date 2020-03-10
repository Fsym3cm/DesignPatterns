# 责任链模式

责任链模式即为请求创建一个接受者对象的链。这种模式给与请求的类型，对请求的发送者和接受者进行解耦。这种类型的设计模式属于行为型模式。

在这种模式中。通常每个接受者都包含对另一个接收者的应用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，以此类推。

### 介绍

**意图：**避免请求发送者与接收者耦合在一起，让多个对象都有可能接受请求，将这些对象连接成一条链，并沿着这条链传递请求，知道有对象处理它为止。

**主要解决：**职责链上的处理者负责处理请求，客户端只需要将请求发送到职责链上即可，无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了。

**何时使用：**在处理消息的时候以过滤很多道。

**如何解决：**拦截的类都实现统一接口。

**关键代码：**`Handler`里面聚合它自己，在`HandlerRequest`里判断是否合适，如果没达到条件则向下传递，向谁传递之前先`set`进去。

**应用实例：**

1. 红楼梦中的“击鼓传花”。
2. `Js`中的事件冒泡。
3. `Java Web`中的`Apache Tomca`t对`Enconding`的处理，`Jsp Servlet`中的`Filter`。

**优点：**

1. 降低耦合度。它将请求的发送者和接受者解耦。
2. 简化了对象。使得对象不需要知道链的结构。
3. 增强给对象指派职责的灵活性。通过改变链内成员或者调动它们的次序，运行动态的新增或者删除责任。
4. 增加新的请求处理类很方便。

**缺点：**

1. 不能保证请求一定被接受。
2. 系统性能将受到一定的影响，而且在进行代码调试时不太方便，可能会造成循环调用。
3. 可能不容易观察运行时的特征，有碍于除错。

**使用场景：**

1. 有多个对象可以处理用一个请求，具体哪个对象处理该请求由运行时刻自动确定。
2. 在不明确指定接受者的情况下，向多个对象的一个提交一个请求。
3. 可动态指定一组对象处理请求。

**注意事项：**在`Java Web`中遇到很多应用。

### 实现

我们创建抽象类`AbstractLogger`,带有详细的日志记录级别。然后我们创建三种类型的记录器，都扩展了`AbstractLogger`。每个记录器消息的级别是否属于自己的级别，如果是则相应地打印出来，否则将不打印并把消息传递给下一个记录器。

![](../photo/ChainOfResponsibility.png)

**步骤一：**

创建创建抽象类`AbstractLogger`。

```java
public abstract class AbstractLogger{
    protected static int INFO = 1;
    protected static int DEBUG = 1;
    protected static int ERROR = 1;
    
    protected int level;
    //责任链中的下一个元素
    private AbstractLogger nextLogger;
    
    //设置责任链中下一个调用哪个接收者
    protected void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }
    
    public void logMessage(int level, String message){
        //当level小于等于传入的level时才打印。
        if (this.level <= level){
            write(message);
        }
        //如果责任链中的下一个元素不为空，则调用logMessage进行打印
        if (nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }
    
    public abstract void write(String message);
} 
```

**步骤二：**

创建扩展了该记录器类的实体类并设置其执行链的顺序。

（`ErrorLogger -> FileLogger -> ConsoleLogger-> null `）

```java
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(){
        this.level = INFO;
        setNextLogger(null);
    }

    @Override
    protected void write(String message) {
        System.out.println("控制台日志：" + message);
    }
}
```

```java
public class FileLogger extends AbstractLogger {

    public FileLogger(){
        this.level = DEBUG;
        setNextLogger(new ConsoleLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("文件日志：" + message);
    }
}
```

```java
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(){
        this.level = ERROR;
        setNextLogger(new FileLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("错误日志：" + message);
    }
}
```

**步骤三：**调用该执行链。

```java
public class ChainPatternDemo {
    public static void main(String[] args) {

        AbstractLogger errorLogger = new ErrorLogger();

        errorLogger.logMessage(1, "控制台信息");
        System.out.println();
        errorLogger.logMessage(2, "测试信息");
        System.out.println();
        errorLogger.logMessage(3, "错误信息");
    }
}
```

**运行结果：**

```java
控制台日志：控制台信息

文件日志：测试信息
控制台日志：测试信息

错误日志：错误信息
文件日志：错误信息
控制台日志：错误信息
```

