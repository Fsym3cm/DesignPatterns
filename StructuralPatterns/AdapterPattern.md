# 适配器模式

适配器模式是作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。

这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。举个真实的例子，读卡器是作为内存卡和笔记本之间的适配器。您将内存卡插入读卡器，再讲读卡器插入笔记本，这样就可以通过笔记本来读取内存卡。

我们通过下面的实例来演示适配器模式的使用。其中音频播放器设备只能播放`mp3`文件，通过使用一个更高级的音频播放器来播放`vlc`和`MP4`文件。

### 介绍

**意图：**将一个类的接口转换成客户希望的另一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

**主要解决：**主要解决在软件系统中，常常要将一些“现存的对象”放到新的环境中，而新环境要求的接口是现对象不能满足的。

**何时使用**：

1. 系统需要使用现有的类，而此类的接口不符合系统的需要。
2. 想要建立一个可以重复使用的类，由于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作，这些源类不一定有一致的接口。
3. 通过接口转换，将一个类插入另一个类系中。（比如老虎和飞禽，现在多一个飞虎，在不增加实体的需求下，增加一个适配器，在里面包容一个虎对象，实现飞的接口。）

**如何解决：**继承或依赖（推荐）。

**关键代码：**适配器继承或依赖已有的对象，实现想要的目标接口。

**应用实例：**

1. 美国电器`110V`，中国`220V`，就要一个适配器将`110V`转化为`220V`。
2. `Java JDK 1.1`提供了`Enume`接口，而在1.2中提供`Iterator`接口，想要使用1.2的`JDK`，则要将以前系统的`Enumeration`接口转化为`Iterator`接口，这时就需要适配器模式。
3. 在Linux上运行Windows程序。
4. Java中的`JDBC`。

**优点：**

1. 可以让任何两没有关联的类一起运行。
2. 提高了类的复用。
3. 增加了类的透明度。
4. 灵活性好。

**缺点：**

1. 过多地使用适配器，会让系统非常凌乱，不易整体进行把握。比如，看到调用的是A接口，其实内部被适配成了B接口的实现，一个系统如果太多这种情况，无异于一场灾难。如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
2. 由于Java至多继承一个类，所以至多只能适配一个适配器类，而且目标类必须是抽象类。

**使用场景：**有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。

**注意事项：**适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。

### 实现

有一个`MediaPlayer`接口和一个实现了`MediaPlayer`接口的实体类`AudioPlayer`。默认情况下，`AudioPlayer`可以播放`mp3`格式的音频文件。还有另一个接口`AdvanceMediaPlayer`和实现了`AdvancedMediaPlayer`的接口的实体类。该类可以播放`vlc`和`mp4`格式的文件。

想要让`AudioPlayer`播放其他格式的音频文件。为了实现这个功能，我们需要创建一个实现了`MediaPlayer`接口的适配器类`MediaAdapter`，并使用`AdvancedMediaPlayer`对象来播放所需的格式。

`AudioPlayer`使用适配器类`MediaAdapter`传递所需的音频类型，不需要知道能播放所需格式音频的实际类。`AdapterPatternDemo`作为演示类，使用`AudioPlayer`来播放各种格式。

![](../photo/Adapter.png)

**步骤一：**

创建`AdvancedMediaPlayer`和`MediaPlayer`创建接口。

```java
public interface AdvancedMediaPlayer{
    
    void playVlc(String fileName);
    void playMp4(String fileName);
}
```

```java
public interface MediaPlayer{
    
    void play(String audioType, String fileName);
}
```

**步骤二：**

创建`AdvancedMediaPlayer`接口的实体类

```java
public class VlcPlayer implements AdvancedMediaPlayer {
    
    @Override
    public void playVlc(String fileName){
        System.out.println("播放vlc文件：" + fileName);
    }
    
    @Override
    public void playMp4(String fileName) {
        
    }
}

```

```java
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("播放mp4文件: " + fileName);
    }
}
```

**步骤三：**

创建实现了`MediaPlayer` 接口的适配器类。

```java
public class MediaAdapter implements MediaPlayer {
    
    AdvancedMediaPlayer advancedMusicPlayer;
    public MediaAdapter(String audioType){
        if (audioType == "vlc"){
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType == "mp4"){
            advancedMusicPlayer = new Mp4Player();
        }
    }
    
    @Override
    void play(String audioType, String fileName) {
        if (audioType == "vlc"){
            advancedMusicPlayer.playVlc(fileName)
        } else if (audioType == "mp4"){
            advancedMusicPlayer.playMp4(fileName)
        }
    }
}
```

**步骤四**

创建`MediaPlayer`接口的实体类

```java
public class AudioPlayer implements MediaPlayer {
    
    @Override
    void play(String audioType, String fileName) {
        if (audioType == "mp3"){
            System.out.println("播放mp3文件: " + fileName);
        } else if (audioType == "vlc" || audioType == "mp4"){
            MediaAdapter mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("不支持这种格式的文件");
        }
    }
}
```

**步骤五：**

使用 `AudioPlayer` 来播放不同类型的音频格式。

```java
public class AdapterPatternDemo {
    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "ai.mp3");
        audioPlayer.play("mp4", "Java.mp4");
        audioPlayer.play("vlc", "Spring.vlc");
        audioPlayer.play("avi", "LeetCode.java");
    }
}
```

**运行结果：**

```java
播放mp3文件: ai.mp3
播放mp4文件: Java.mp4
播放vlc文件：Spring.vlc
不支持这种格式的文件
```

