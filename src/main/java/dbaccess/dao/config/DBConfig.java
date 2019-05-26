package dbaccess.dao.config;

/**
 * アクセスするDBへの設定を集約するためのクラス
 */
public final class DBConfig{
    /** DBアクセス用変数*/
    private static final String DB_URL = "jdbc:mysql://localhost/testDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    private DBConfig(){}
    /**
     * DBConfig生成用ファクトリ
     * @return　DBConfigのインスタンス
     */
    public static DBConfig getInstance(){
        return new DBConfig();
    }
    /**
     * URLを返す。
     * 
     * @return DBへのURL
     */
    public String getURL(){
        return DB_URL;
    }

    /**
     * DBのユーザ名を返す。
     * 
     * @return DBのユーザ
     */
    public String getUSER(){
        return DB_USER;
    }

    /**
     * DBへのパスワードを返す。
     * 
     * @return DBアクセス用PW
     */
    public String getPASSWORD(){
        return DB_PASSWORD;
    }

    /**
     * ドライバーのFQCNを返す
     * 
     * @return DB Driver
     */
    public String getDRIVER(){
        return DB_DRIVER;
    }

}