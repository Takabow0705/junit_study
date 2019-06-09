package dbaccess.dao.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Bond {
    /* 債券コード**/
    @Getter
    @Setter
    private String code;
    /* 債券名称**/
    @Getter
    @Setter
    private String name;
    /* 債券の償還年限**/
    @Getter
    @Setter
    private String maturity;
    /* クーポンレート**/
    @Getter
    @Setter
    private BigDecimal coupon;
    /* 取得簿価**/
    @Getter
    @Setter
    private BigDecimal bookValue;
    /* 時価**/
    @Getter
    @Setter
    private BigDecimal fairValue;
    /* 債券数量**/
    @Getter
    @Setter
    private BigDecimal amount;
    /* データの論理削除用フラグ**/
    @Getter
    @Setter
    private Boolean deleteFlag;

    /**
     * Bondの直接のインスタンス化を回避
     */
    private Bond(){}

}