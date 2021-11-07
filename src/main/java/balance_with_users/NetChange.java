package balance_with_users;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 *  Net Change in Cash = (Sum of Cash Income - Sum of Cash Outflow) for given user
 */
@Data
@AllArgsConstructor
public class NetChange implements Comparable<NetChange>{
    private User user;

    /**
     * if positive then user has to receive the amount
     * if negative user must give away the amount
     */
    private long amount;

    @Override
    public int compareTo(NetChange o) {
        return Long.compare(amount, o.amount);
    }

    public void subtractAmount(long sub){
        amount -= sub;
    }

    public void addAmount(long add){
        amount += add;
    }
}
