package com.chengzimm.BehavioralPattern.AdapterPattern;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    //创建适配器构造函数，用于生产对应的播放对象
    public MediaAdapter(String audioType){
        if (audioType == "vlc"){
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType == "mp4") {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    //通过传入的 audioType 来确定调用那种播放器。
    @Override
    public void play(String audioType, String fileName) {
        if (audioType == "vlc"){
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType == "mp4") {
            advancedMusicPlayer.playMp4(fileName);
        }
    }

}
