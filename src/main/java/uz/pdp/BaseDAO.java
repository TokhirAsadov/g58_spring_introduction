package uz.pdp;

public class BaseDAO {
    private String url;
    private String db;
    private String user;
    private String password;
    private String driver;

    public BaseDAO(String url, String db, String user, String password, String driver) {
        this.url = url;
        this.db = db;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "BaseDAO{" +
                "url='" + url + '\'' +
                ", db='" + db + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
