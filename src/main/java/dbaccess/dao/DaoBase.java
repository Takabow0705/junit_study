package dbaccess.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import dbaccess.dao.config.DBConfig;

abstract class DaoBase{

    private static final Logger LOGGER = Logger.getLogger(DaoBase.class.getName());
    private static final DBConfig CONFIG = DBConfig.getInstance();
    private Statement stmt;

    /**
     * DBとのコネクションを確立してpreparedStatementを返す。
     * @return
     */
    protected Statement connect(){
        try{
            LOGGER.info(() -> "DBとのコネクション開始");
            Class.forName(CONFIG.getDRIVER());
        Connection con = DriverManager.getConnection(CONFIG.getURL(), 
                                              CONFIG.getUSER(), 
                                              CONFIG.getPASSWORD());
            
            return con.createStatement();
        }catch(SQLException e){
            LOGGER.info("コネクション時にエラーが発生しました。");
            e.printStackTrace();
            return null;
        }
    }
}