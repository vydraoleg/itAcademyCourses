package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Neil Alishev
 */
@Component
public class MusicPlayer {
    @Autowired
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    // IoC

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
