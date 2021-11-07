package balance_with_users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private User from;
    private User to;
    private long amount;
}
