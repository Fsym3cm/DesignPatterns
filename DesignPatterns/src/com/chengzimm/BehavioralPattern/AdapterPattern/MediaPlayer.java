package com.chengzimm.BehavioralPattern.AdapterPattern;

public interface MediaPlayer {

    //通过设置 audioType 来确定调用哪个播放器
    void play(String audioType, String fileName);
}
