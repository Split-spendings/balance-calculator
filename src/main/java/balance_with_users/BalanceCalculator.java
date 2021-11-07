package balance_with_users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class BalanceCalculator {
    private final List<NetChange> netChangeList;
    private final List<NetChange> positiveNetChangeList;
    private final List<NetChange> negativeNetChangeList;
    public final List<Transaction> out = new ArrayList<>();

    public BalanceCalculator(List<NetChange> netChangeList) {
        this.netChangeList = netChangeList;
        positiveNetChangeList = getPositiveNetChanges();
        negativeNetChangeList = getNegativeNetChanges();
        // zeroes are ignored
    }

    public void calculate(){
        /**
         * always passes the user who is owed the most by other users. After each iteration positive user is either
         * removed or the dept is decreased
         */
        while (!positiveNetChangeList.isEmpty()){
            sort();
            performIteration(positiveNetChangeList.get(0));
        }
    }

    private void performIteration(NetChange positive){
        NetChange previousNegative = null;
        for(NetChange negative : new ArrayList<>(negativeNetChangeList)){
            long absNegativeAmount = Math.abs(negative.getAmount());

            /**
             * checks if the first negative has the debt smaller than the first positive
             */
            if ((previousNegative == null) && absNegativeAmount < positive.getAmount()){
                performTransaction(negative, positive, absNegativeAmount);
                continue;
            }

            /**
             * checks if current negative debt is the last one
             */
            if (negativeNetChangeList.get(negativeNetChangeList.size() - 1).equals(negative)){
                performTransaction(negative, positive, positive.getAmount());
                continue;
            }
            /**
             * finds the closest negative dept to current positive
             */
            if (absNegativeAmount > positive.getAmount()){
                previousNegative = negative;
                continue;
            }

            if (absNegativeAmount < positive.getAmount()){
                performTransaction(previousNegative, positive, positive.getAmount());
            }
        }
    }

    private void performTransaction(NetChange negative, NetChange positive, long amount){
        negative.addAmount(amount);
        positive.subtractAmount(amount);

        Transaction transaction = new Transaction(negative.getUser(), positive.getUser(), amount);
        out.add(transaction);

        if (negative.getAmount() == 0){
            negativeNetChangeList.remove(negative);
        }

        if (positive.getAmount() == 0){
            positiveNetChangeList.remove(positive);
        }
    }

    private void sort(){
        positiveNetChangeList.sort(NetChange::compareTo);
        negativeNetChangeList.sort(NetChange::compareTo);
    }

    private List<NetChange> getPositiveNetChanges(){
        return netChangeList.stream().filter(n -> n.getAmount() > 0).collect(Collectors.toList());
    }

    private List<NetChange> getNegativeNetChanges(){
        return netChangeList.stream().filter(n -> n.getAmount() < 0).collect(Collectors.toList());
    }
}