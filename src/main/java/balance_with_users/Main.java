package balance_with_users;


@SuppressWarnings("all")
public class Main {
   public static void main(String[] args) {
      var transactionList = DataLoader.loadData_4();
      transactionList.forEach(System.out::println);

      var netChangeList = ParserUtil.transactionsToNetChange(transactionList);
      netChangeList.sort((n1, n2) -> Long.compare(n1.getUser().getId(), n2.getUser().getId()));
      netChangeList.forEach(System.out::println);

      BalanceCalculator calculator = new BalanceCalculator(netChangeList);
      calculator.calculate();
      calculator.out.forEach(System.out::println);
   }
}