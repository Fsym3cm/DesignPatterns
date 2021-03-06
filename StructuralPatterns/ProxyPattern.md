# 代理模式

在代理模式中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。

在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。

### 介绍

**意图：**为其他对象提供一种代理以控制这个对象的访问。

**主要解决：**在直接访问对象时带来的问题，当要访问的对象在远程的机器上时。在面向对象系统中，有些对象由于某些原因（比如对象创建的开销很大，或者某些操作需要安全控制，或者需要进程外的访问），直接访问会给使用者或者系统结构带来很多麻烦，我们可以在访问此对象时加上一个对此对象的访问层。

**如何使用：**想在访问一个类时做一些控制。

**如何解决：**增加中间层。

**关键代码：**实现与被代理类组合。

**应用实例：**

1. Windows里面的快捷方式。
2. 猪八戒去找高翠兰结果是孙悟空变得，可以这样理解：把高翠兰的外貌抽象出来，高翠兰本人和孙悟空都实现了这个接口，猪八戒访问高翠兰的时候看不出来这个是孙悟空，所以说孙悟空是高翠兰代理类。
3. 买火车票不一定在火车站买，也可以去代售点。
4. 一张支票或银行存单是账户中资金的代理。支票在市场交易中用来代替现金，并提供对签发人账号上资金的控制。
5. `Spring AOP`。

**优点：**

1. 职责清晰。
2. 高扩展性。
3. 智能化。

**缺点：**

1. 由于客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
2. 代理模式需要额外的工作，有些代理模式的实现非常复杂。

**使用场景：**按职责划分，通常有以下使用场景：

1. 远程代理。
2. 虚拟代理。
3. Copy-on-Write代理。
4. 保护代理。
5. Cache代理。
6. 防火墙代理。
7. 同步化代理。
8. 智能引用代理。

**注意事项：**

1. 和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
2. 和装饰器模式的区别：装饰器模式是为了增强功能，而代理模式是为了加以控制。

### 实现

创建一个`Image`接口和实现了`Image`接口的实体类。`ProxyImage`是一个代理类，减少`RealImage`对象加载的内存占用。`ProxyPatternDemo`作为演示类，使用`ProxyImage`来获取要加载的`Image`对象，并按照需求进行显示。

![](../Photo/Proxy.png)

**步骤一：**

创建`Image`接口类。

```java
public interface Image {

    void display();
}
```

**步骤二：**

实现`Image`接口类。

```java
public class RealImage implements Image {

    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("展示 " + fileName);
    }

    public void loadFromDisk(String fileName){
        System.out.println("加载 " + fileName);
    }
}
```

**步骤三：**

实现一个`RealImage`的代理类。

```java
public class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;
    
    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealImage();
        }
        realImage.display();
    }
}
```

**步骤四：**

使用代理类来获取`RealImage`类对象。

```java
public class ProxyPatternDemo {
    public static void main(String[] args) {

        Image image = new ProxyImage("123.jpg");
        image.display();
        //如果有这个对象则不会重新加载。
        image.display();
    }
}
```

运行结果：

```java
加载 123.jpg
展示 123.jpg
展示 123.jpg
```

