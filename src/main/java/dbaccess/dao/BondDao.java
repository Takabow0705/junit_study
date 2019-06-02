package dbaccess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dbaccess.dao.model.Bond;

/**
 * DBに接続して債券データを取得するDAOクラス
 * 
 * @author takahiro haraguchi
 * 
 */
public class BondDao extends DaoBase {
    /** ロガー */
    private static final Logger logger = Logger.getLogger(BondDao.class.getName());
    
    /**
     * 債券データのうち、有効なもののみを取得して返却する
     * 
     * @return List<Bond>
     */
    public List<Bond> selectAllBond(){
        String sql = "select * from Bond where delete_flag = 0";

        try(Statement stmt = connect();){
            logger.info("DB Connection start");
            ResultSet rset = stmt.executeQuery(sql);
            logger.info(sql);
            List<Bond> result = new ArrayList<>();
        
            while(rset.next()){
                Bond bond = Bond.getInstance()
                                .setCode(rset.getString(1))
                                .setName(rset.getString(2))
                                .setMaturity(rset.getString(3))
                                .setCoupon(rset.getBigDecimal(4))
                                .setBookValue(rset.getBigDecimal(5))
                                .setFairValue(rset.getBigDecimal(6))
                                .setAmount(rset.getBigDecimal(7))
                                .setDeleteFlag(rset.getBoolean(8));
                            
                result.add(bond);
            }
            logger.info("DB Connection finished");
            return result;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
}