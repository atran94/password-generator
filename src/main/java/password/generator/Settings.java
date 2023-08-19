package password.generator;

/**
 * The setting class will store the state of the application,
 * persisting the user selections
 */
public final class Settings {
    //Set up the Settings singleton instance
    private final static Settings INSTANCE = new Settings();
    public static Settings getInstance(){
        return INSTANCE;
    }
    private Settings(){
        //don't allow private constructor
    }
    public boolean useAllAlpha = false;
    public boolean useNumeric = false;
    public boolean useSpecial = false;
    public int length = 0;
    public String password = "";

    public boolean isUseAllAlpha() {
        return useAllAlpha;
    }

    public void setUseAllAlpha(boolean useAllAlpha) {
        this.useAllAlpha = useAllAlpha;
    }

    public boolean isUseNumeric() {
        return useNumeric;
    }

    public void setUseNumeric(boolean useNumeric) {
        this.useNumeric = useNumeric;
    }

    public boolean isUseSpecial() {
        return useSpecial;
    }

    public void setUseSpecial(boolean useSpecial) {
        this.useSpecial = useSpecial;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
