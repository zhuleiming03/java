package repertory;

import pojo.Bill;
import pojo.BillType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BillRepertory {

    private Random random = new Random();

    private final static Integer BILL_COUNT = 12;

    private final static Integer AMOUNT_FACTOR = 1000;

    private final static Integer BEGIN_MONTH = 5;

    public List<Bill> getBills() {

        List<Bill> bills = new LinkedList<>();
        for (int i = 0; i < BILL_COUNT; i++) {
            Bill bill = new Bill(i + 1, getAmount(), getBillType(i),
                    LocalDate.now().minusMonths(BEGIN_MONTH).plusMonths(i));
            bills.add(bill);
        }

        return bills;
    }

    private BigDecimal getAmount() {
        float amount = AMOUNT_FACTOR * random.nextFloat();
        return new BigDecimal(amount);
    }

    private BillType getBillType(Integer i) {
        if (BEGIN_MONTH > i) {
            return BillType.FINISH;
        } else if (BEGIN_MONTH.equals(i)) {
            return BillType.OVERDUE;
        } else {
            return BillType.NORMAL;
        }
    }
}
