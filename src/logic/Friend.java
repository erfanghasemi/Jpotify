package logic;


import java.io.Serializable;

public class Friend implements Serializable {

    private String name;
    private String IP;

    public Friend(String name, String IP) {
        this.name = name;
        this.IP = IP;
    }

    public String getName() {
        return name;
    }

    public String getIP() {
        return IP;
    }
}
