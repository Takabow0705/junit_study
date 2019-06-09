package dao;

import dbaccess.dao.model.Bond;
import org.junit.Before;

import java.math.BigDecimal;

public class BondTest {

    /** 時価を含む場合の債券インスタンス*/
    private Bond bondIncludesFairValue;
    /** 時価を含まないケースの債券インスタンス*/
    private Bond bondNotIncludesFairValue;
    @Before
    public void setUp(){
        bondIncludesFairValue = Bond.builder()
                    .code("0001")
                    .name("testSecurity")
                    .maturity("2019/01/01")
                    .fairValue(new BigDecimal(500))
                    .bookValue(new BigDecimal(480))
                    .amount(new BigDecimal(3000))
                    .coupon(new BigDecimal(0.03))
                    .deleteFlag(false)
                    .build();

        bondNotIncludesFairValue = Bond.builder()
                .code("0001")
                .name("testSecurity")
                .maturity("2019/01/01")
                .bookValue(new BigDecimal(480))
                .amount(new BigDecimal(3000))
                .coupon(new BigDecimal(0.03))
                .deleteFlag(false)
                .build();
    }



}
