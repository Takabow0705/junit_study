package dbaccess.dao.model;

import java.math.BigDecimal;

public class Bond {
    private String code;
    private String name;
    private String maturity;
    private BigDecimal coupon;
    private BigDecimal bookValue;
    private BigDecimal fairValue;
    private BigDecimal unit;
    private boolean deleteFlag;

    private Bond(){}

    public static Bond getInstance(){
        return new Bond();
    }

    /**
     * 
     * @param code
     * @return
     */
    public Bond setCode(String code){
        this.code = code;
        return this;
    }
    /**
     * 
     * @param name
     * @return
     */
    public Bond setName(String name){
        this.name = name;
        return this;
    }
    /**
    * 
    * @param maturity
    * @return
    */
    public Bond setMaturity(String maturity){
        this.maturity = maturity;
        return this;
    }

    /**
     * 
     * @param coupon
     * @return
     */
    public Bond setCoupon(BigDecimal coupon){
        this.coupon = coupon;
        return this; 
    }

    /**
     * 
     * @param bookValue
     * @return
     */
    public Bond setBookValue(BigDecimal bookValue){
        this.bookValue = bookValue;
        return this;
    }

    /**
     * 
     * @param fairValue
     * @return
     */
    public Bond setFairValue(BigDecimal fairValue){
        this.fairValue = fairValue;
        return this;
    }

    /**
     * 
     * @param unit
     * @return
     */
    public Bond setUnit(BigDecimal unit){
        this.unit = unit;
        return this;
    }
    /**
     * 
     * @param deleteFlag
     * @return
     */
    public Bond setDeleteFlag(boolean deleteFlag){
        this.deleteFlag = deleteFlag;
        return this;
    }

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public String getMaturity(){
        return this.maturity;
    }

    public BigDecimal getCoupon(){
        return this.coupon;
    }

    public BigDecimal getFairValue(){
        return this.fairValue;
    }

    public BigDecimal getBookValue(){
        return this.bookValue;
    }

    public BigDecimal getUnit(){
        return this.unit;
    }

    public boolean getDeleteFlag(){
        return this.deleteFlag;
    }

}