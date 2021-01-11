package com.it.spring;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private Music music;
    private List<Music> musicList = new ArrayList<>();

    private String name;
    private int volume;

    // IoC
    public MusicPlayer() {}

    public MusicPlayer(Music music) { this.music = music; }
    public void setMusic(Music music) { this.music = music;  }
    public void playMusic(){  System.out.println("Playning : " +  music.getSong());  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusicList() {
        for(Music music : musicList) {
            System.out.println("Playing: " + music.getSong());
        }
    }
}
