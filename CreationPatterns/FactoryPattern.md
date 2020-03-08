# 工厂模式

工厂模式是Java中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

在工厂模式中，我们创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。

### 介绍

**意图：**定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂，工厂模式使其创建过程延迟到子类进行。

**主要解决：**主要解决接口选择的问题。

**何时使用：**明确地计划不同条件下创建不同实例时。

**如何解决：**让去子类实现工厂接口，返回的也是一个抽象的产品。

**应用实例：**

1. 当您需要一辆汽车时，可以直接从工厂里面提货，而不用去管这辆车是怎么做出来的，以及这个汽车里面的具体实现。
2. Spring框架换数据库只需要跟换连接URL和驱动。

**优点：**

1. 一个调用者想创建一个对象，只要知道其名称就行。
2. 扩展性高，如果想要增加一个产品，只要扩展一个工程类。
3. 屏蔽产品的具体实现，调用者只关心产品的接口。

**缺点：**每次增加一个产品时，都需要增加一个具体的类和对象实现工厂，使得系统中的类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。

**使用场景：**

1. 日志记录器：记录可能记录到本地硬盘，系统事件，远程服务器等，用户可以选择记录日志到什么地方。
2. 数据库访问，当用户不知道系统采用哪一类数据库，以及数据库可能有变化时。
3. 设计一个连接服务器的框架，需要三个协议，“`POP3`”，“`IMAP`”,"`HTTP`"，可以把这三个作为产品类，共同实现一个接口。

**注意事项：**作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。工厂模式只适合于复杂的对象，而简单对象，我们应该使用new来创建，使用工厂模式就需要引入一个工厂类，这就会增加系统的复杂度。

### 实现

我们将创建一个Shape接口和实现Shape接口的实体类。下一步是定义工厂类`ShapeFactory`。

`FactoryPatternDemo`，我们演示类使用`ShapeFactory`来获取Shape对象。它将向`ShapeFactory`传递信息，以便获取它所需对象的类型。

![](F:\Gitlibrary\DesignPatterns\Photo\ShapeFactory.png)

**步骤一：**

先创建`Shape`接口。

```java
public interface Shape{
    //创建一个draw方法
    void draw();
}
```

**步骤二：**

实现`Circle`, `Square`, `Rectangle`三个实体类。

```java
public class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("圆形绘画");
    }
}
```

```java
public class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("正方形绘画");
    }
}
```

```java
public class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("长形绘画");
    }
}
```

**步骤三：**

创建一个`ShapeFactory`实体类，用于创建其对应的实体类对象。

```java
public class ShapeFactory{
    
     //定义一个 getShape 方法用于获取改形状的对象
    public Shape getShape(String ShapeType){
        if (shapeType == "circle"){
            return new Circle();
        } else if (shapeType == "Square"){
            return new Square();
        } else if (shapeType == "Rectangle"){
            return new Rectangle();
        } else {
            return null;
        }
    }
}
```

**步骤四：**

使用该工厂，通过传递类型信息来获取实体类的对象。

```java
public class FactoryPatternDemo{
    public static void main(String[] args) {
        //通过工厂方法获取其形状
        ShapeFactory shapefactory = new ShapeFactory();
        Shape shape1 = shapefactory.getShape("circle");
        shape1.draw();
            
        Shape shape2 = shapeFactory.getShape("square");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("rectangle");
        shape3.draw();
    }
}
```

运行结果：

```java
圆形绘画
正方形绘画
长方形绘画
```

**概括工厂模式：**

-  **简单工厂**：一个工厂类，一种产品抽象类。
-  **工厂方法**：多个工厂类，一种产品抽象类。
-  **抽象工厂**：多个工厂类，多种产品抽象类。

**生活中的工厂模式：**

-  简单工厂类：一个麦当劳店，可以生产多种汉堡。
-  工厂方法类：一个麦当劳店，可以生产多种汉堡。一个肯德基店，也可以生产多种汉堡。
-  抽象工厂类：百胜餐饮集团下有肯德基和百事公司，肯德基生产汉堡，百事公司生成百事可乐。