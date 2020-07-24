package pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bill {

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

    public Bill(Integer periods, BigDecimal amount, BillType billType, LocalDate dueDate) {
        this.periods = periods;
        this.amount = amount;
        this.billType = billType;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "periods=" + periods +
                ", amount=" + amount +
                ", billType=" + billType +
                ", dueDate=" + dueDate +
                '}';
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

    public LocalDate getDueDate() {
        return dueDate;
    }
}
