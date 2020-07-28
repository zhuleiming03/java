package repertory;

import pojo.Bill;
import pojo.BillType;
import pojo.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

public class BillRepertory {

    public List<Bill> getDefault() {
        List<Bill> bills = getBills(new Order(System.currentTimeMillis(),
                LocalDate.now().minusMonths(3), new BigDecimal(30000f), 12));

        bills.addAll(getBills(new Order(System.currentTimeMillis(),
                LocalDate.now().minusMonths(4), new BigDecimal(12000f), 6)));

        return bills;
    }

    public List<Bill> getBills(Order order) {

        Integer count = (1 + order.getPeriods()) * order.getPeriods() / 2;

        List<Bill> bills = new LinkedList<>();
        for (int i = 1; i <= order.getPeriods(); i++) {
            Bill bill = new Bill(order.getId(),
                    i,
                    order.getLoanAmount().divide(new BigDecimal(count), 0).multiply(new BigDecimal(i)),
                    getBillType(i, order.getLoanDate()),
                    order.getLoanDate().plusMonths(i));
            bills.add(bill);
        }

        return bills;
    }

    private BillType getBillType(Integer i, LocalDate loanDate) {

        Period period = Period.between(loanDate.plusMonths(i), LocalDate.now());

        if (period.getMonths() > 0) {
            return BillType.NORMAL;
        } else if (period.getMonths() == 0) {
            return BillType.OVERDUE;
        } else {
            return BillType.FINISH;
        }
    }
}
