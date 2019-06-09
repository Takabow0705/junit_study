package dbaccess.dao.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Bond {
    /* 債券コード**/
    private String code;
    /* 債券名称**/
    private String name;
    /* 債券の償還年限**/
    private String maturity;
    /* クーポンレート**/
    private BigDecimal coupon;
    /* 取得簿価**/
    private BigDecimal bookValue;
    /* 時価**/
    private BigDecimal fairValue;
    /* 債券数量**/
    private BigDecimal amount;
    /* データの論理削除用フラグ**/
    private Boolean deleteFlag;

    /**
     * Bondの直接のインスタンス化を回避
     */
    private Bond(){}

}