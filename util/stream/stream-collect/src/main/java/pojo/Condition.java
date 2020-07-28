package pojo;

import java.util.Objects;

public class Condition {

    /**
     * 订单 ID
     */
    private Long orderId;

    /**
     * 账单类型
     */
    private BillType billType;

    public Condition(Long orderId, BillType billType) {
        this.orderId = orderId;
        this.billType = billType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Condition condition = (Condition) o;
        return Objects.equals(orderId, condition.orderId) &&
                billType == condition.billType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, billType);
    }

    public Long getOrderId() {
        return orderId;
    }

    public BillType getBillType() {
        return billType;
    }
}
