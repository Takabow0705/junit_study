package dbaccess.dao.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Bond {
    /* 債券コード**/
    @NonNull
    private String code;
    /* 債券名称**/
    @NonNull
    private String name;
    /* 債券の償還年限**/
    @NonNull
    private String maturity;
    /* クーポンレート**/
    @NonNull
    private BigDecimal coupon;
    /* 取得簿価**/
    @NonNull
    private BigDecimal bookValue;
    /* 時価**/
    private BigDecimal fairValue;
    /* 債券数量**/
    @NonNull
    private BigDecimal amount;
    /* データの論理削除用フラグ**/
    @NonNull
    private Boolean deleteFlag;

    /**
     * Bondの直接のインスタンス化を回避
     */
    private Bond(){}

}