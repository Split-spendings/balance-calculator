package balance_with_users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParserUtil {

    /**
     * parses Transactions to NetChange
     */
    public static List<NetChange> transactionsToNetChange(List<Transaction> transactionList){
        Set<User> allUsers = getAllUsers(transactionList);
        List<NetChange> out = getAllNetChanges(allUsers);

        for(NetChange netChange : out){
            User user = netChange.getUser();
            for (Transaction transaction : transactionList){
                if (transaction.getFrom().equals(user)){
                    netChange.setAmount(netChange.getAmount() + transaction.getAmount());
                }
                if (transaction.getTo().equals(user)){
                    netChange.setAmount(netChange.getAmount() - transaction.getAmount());
                }
            }
        }
        return out;
    }

    private static List<NetChange> getAllNetChanges(Iterable<User> allUsers){
        List<NetChange> out = new ArrayList<>();
        for (User user : allUsers){
            out.add(new NetChange(user, 0));
        }
        return out;
    }

    private static Set<User> getAllUsers(List<Transaction> transactionList){
        Set<User> out = new HashSet<>();
        for (Transaction transaction : transactionList){
            out.add(transaction.getFrom());
            out.add(transaction.getTo());
        }
        return out;
    }
}