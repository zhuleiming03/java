package pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {

    /**
     * 订单 Id
     */
    private Long id;

    /**
     * 放款时间
     */
    private LocalDate loanDate;

    /**
     * 放款金额
     */
    private BigDecimal loanAmount;

    /**
     * 期数
     */
    private Integer periods;

    public Order(Long id, LocalDate loanDate, BigDecimal loanAmount, Integer periods) {
        this.id = id;
        this.loanDate = loanDate;
        this.loanAmount = loanAmount;
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", loanAmount=" + loanAmount +
                ", periods=" + periods +
                '}';
    }

    public Long getId() {
        return id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public Integer getPeriods() {
        return periods;
    }

}
