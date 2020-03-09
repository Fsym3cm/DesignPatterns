package com.chengzimm.BehavioralPattern.AdapterPattern;

public class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String audioType, String fileName) {
        //播放其支持的 mp3 文件和通过适配器播放 vlc 和 mp4 文件
        if (audioType == "mp3"){
            System.out.println("播放mp3文件: " + fileName);
        } else if (audioType == "vlc" || audioType == "mp4"){
            //通过适配器的构造函数来调用相应的播放器
            MediaAdapter mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("不支持这种格式的文件");
        }
    }
}
