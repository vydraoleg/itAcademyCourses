package com.it.spring;

public class MusicPlayer {
    private Music music;

    // IoC
    public MusicPlayer(Music music) { this.music = music; }

    public void setMusic(Music music) { this.music = music;  }

    public void playMusic(){
        System.out.println("Playning : " +  music.getSong());
    }
}
