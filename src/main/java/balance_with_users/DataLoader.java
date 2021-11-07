package balance_with_users;

import java.util.ArrayList;
import java.util.List;

/**
 * creates dummy data
 */
@SuppressWarnings("all")
public class DataLoader {
    public static List<Transaction> loadData_1() {
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        User user4 = new User(4);
        User user5 = new User(5);

        List<Transaction> transactionList = new ArrayList<>();
        //setup user1
        transactionList.add(new Transaction(user1, user4, 10));
        transactionList.add(new Transaction(user1, user5, 5));

        //setup user2
        transactionList.add(new Transaction(user2, user1, 10));
        transactionList.add(new Transaction(user2, user3, 20));

        //setup user3
        transactionList.add(new Transaction(user3, user1, 10));
        transactionList.add(new Transaction(user3, user4, 20));

        //setup user5
        transactionList.add(new Transaction(user5, user1, 10));
        transactionList.add(new Transaction(user5, user2, 30));
        transactionList.add(new Transaction(user5, user3, 10));
        transactionList.add(new Transaction(user5, user4, 10));

        return transactionList;
    }

    public static List<Transaction> loadData_2() {
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);

        List<Transaction> transactionList = new ArrayList<>();
        //setup user1
        transactionList.add(new Transaction(user1, user2, 10));
        transactionList.add(new Transaction(user2, user3, 10));

        return transactionList;
    }

    public static List<Transaction> loadData_3() {
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        User user4 = new User(4);
        User user5 = new User(5);

        List<Transaction> transactionList = new ArrayList<>();
        //setup user1
        transactionList.add(new Transaction(user1, user4, 10));
        transactionList.add(new Transaction(user1, user5, 5));

        //setup user2
        transactionList.add(new Transaction(user2, user1, 10));
        transactionList.add(new Transaction(user2, user3, 20));

        //setup user3
        transactionList.add(new Transaction(user3, user1, 10));
        transactionList.add(new Transaction(user3, user4, 20));

        //setup user4
        transactionList.add(new Transaction(user4, user5, 50));

        //setup user5
        transactionList.add(new Transaction(user5, user1, 10));
        transactionList.add(new Transaction(user5, user2, 30));
        transactionList.add(new Transaction(user5, user3, 10));
        transactionList.add(new Transaction(user5, user4, 10));

        return transactionList;
    }

    public static List<Transaction> loadData_4() {
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        User user4 = new User(4);
        User user5 = new User(5);

        List<Transaction> transactionList = new ArrayList<>();
        //setup user1
        transactionList.add(new Transaction(user1, user4, 10));
        transactionList.add(new Transaction(user1, user5, 5));

        //setup user2
        transactionList.add(new Transaction(user2, user1, 10));
        transactionList.add(new Transaction(user2, user3, 20));
        transactionList.add(new Transaction(user2, user4, 5));

        //setup user3
        transactionList.add(new Transaction(user3, user1, 10));
        transactionList.add(new Transaction(user3, user4, 25));

        //setup user4
        transactionList.add(new Transaction(user4, user5, 40));

        //setup user5
        transactionList.add(new Transaction(user5, user1, 15));
        transactionList.add(new Transaction(user5, user2, 30));
        transactionList.add(new Transaction(user5, user3, 10));
        transactionList.add(new Transaction(user5, user4, 10));

        return transactionList;
    }
}