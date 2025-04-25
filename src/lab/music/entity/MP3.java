package lab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;
    private int volume;

    public MP3(String title, String artist, String format, int fileSize) {
        this(title, artist, format, fileSize, 5); 
    }

    public MP3(String title, String artist, String format, int fileSize, int volume) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = volume;
    }

    @Override
    public void play() {
        super.play();
        System.out.println("현재 볼륨: " + volume);
    }

    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("볼륨이 " + volume + "로 설정되었습니다.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize + "MB");
    }
}
