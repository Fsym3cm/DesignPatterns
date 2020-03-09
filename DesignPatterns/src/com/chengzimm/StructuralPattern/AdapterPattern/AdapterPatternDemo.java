package com.chengzimm.StructuralPattern.AdapterPattern;

public class AdapterPatternDemo {
    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "ai.mp3");
        audioPlayer.play("mp4", "Java.mp4");
        audioPlayer.play("vlc", "Spring.vlc");
        audioPlayer.play("avi", "LeetCode.java");
    }
}
