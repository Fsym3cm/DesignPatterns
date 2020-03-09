package com.chengzimm.BehavioralPattern.AdapterPattern;

public interface AdvancedMediaPlayer {

    //播放 vlc 和 mp4 两种格式的播放器
    void playVlc(String fileName);
    void playMp4(String fileName);
}
