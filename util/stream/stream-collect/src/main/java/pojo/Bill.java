package pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bill {

    /**
     * 订单 ID
     */
    private Long orderId;

    /**
     * 期数
     */
    private Integer periods;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 账单类型
     */
    private BillType billType;

    /***
     * 逾期日期
     */
    private LocalDate dueDate;

    public Bill(Long orderId, Integer periods, BigDecimal amount, BillType billType, LocalDate dueDate) {
        this.orderId = orderId;
        this.periods = periods;
        this.amount = amount;
        this.billType = billType;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "orderId=" + orderId +
                ", periods=" + periods +
                ", amount=" + amount +
                ", billType=" + billType +
                ", dueDate=" + dueDate +
                '}';
    }


    public Long getOrderId() {
        return orderId;
    }

    public Integer getPeriods() {
        return periods;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BillType getBillType() {
        return billType;
    }

}
