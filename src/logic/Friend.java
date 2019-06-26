package logic;

public class Friend {

    private String name;
    private PlayList playList;

    public Friend(String name, PlayList playList) {
        this.name = name;
        this.playList = playList;
    }

    public String getName() {
        return name;
    }

    public PlayList getPlayList() {
        return playList;
    }
}
