package com.chengzimm.StructuralPattern.AdapterPattern;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("播放vlc文件：" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
    }
}
