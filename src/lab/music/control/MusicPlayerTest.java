package lab.music.control;

import lab.music.entity.*;

public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("===== 음악 재생 시스템 테스트 =====\n");

        System.out.println("--- MP3 테스트 ---");
        MP3 mp3 = new MP3("Dynamite", "BTS", "MP3", 5);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(8);
        mp3.play();
        mp3.stop();

        System.out.println("\n--- Vinyl 테스트 ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();

        System.out.println("\n--- 다형성 테스트 ---");
        MusicMedia media = new MP3("Butter", "BTS", "MP3", 4);
        media.displayInfo();
        media.play();

        System.out.println("\n--- 캐스팅 테스트 ---");
        if (media instanceof MP3) {
            MP3 casted = (MP3) media;
            casted.setVolume(3);
            casted.play();
            casted.setVolume(7);
            casted.stop();
        }
    }
}
