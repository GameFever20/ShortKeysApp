package utils;

/**
 * Created by Aisha on 12/28/2017.
 */

public class KeyBoardShortcut {

    public String getShortKeyCode() {
        return shortKeyCode;
    }

    public void setShortKeyCode(String shortKeyCode) {
        this.shortKeyCode = shortKeyCode;
    }

    public String getShortKeyExplaination() {
        return shortKeyExplaination;
    }

    public void setShortKeyExplaination(String shortKeyExplaination) {
        this.shortKeyExplaination = shortKeyExplaination;
    }

    private String shortKeyCode;
    private String shortKeyExplaination;

    public String getShortKeyUID() {
        return shortKeyUID;
    }

    public void setShortKeyUID(String shortKeyUID) {
        this.shortKeyUID = shortKeyUID;
    }

    private String shortKeyUID;
}
