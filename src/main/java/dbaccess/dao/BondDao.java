package dbaccess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbaccess.dao.model.Bond;

public class BondDao extends DaoBase {

    public List<Bond> selectAllBond(){
        String sql = "select 1 from Bond where delete_flag = 0";

        try(Statement stmt = connect();){
            
            ResultSet rset = stmt.executeQuery(sql);
            List<Bond> result = new ArrayList();
        
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
            return result;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
}