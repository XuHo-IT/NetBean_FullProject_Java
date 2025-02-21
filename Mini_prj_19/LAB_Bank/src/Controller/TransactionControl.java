package Controller;

import Model.*;
import View.Validation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static Controller.CardControl.cardList;

public class TransactionControl {
    ArrayList<Transaction> transactions = new ArrayList<>();
    Validation val;

    public TransactionControl(ArrayList<Transaction> transactions, Validation val) {
        this.transactions = transactions;
        this.val = val;
    }

    public TransactionControl() {
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Validation getVal() {
        return val;
    }

    public void setVal(Validation val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TransactionControl{" +
                "transactions=" + transactions +
                ", val=" + val +
                '}';
    }

    private boolean transactionLoaded = false;

    public void viewCard() throws CardException, TransactionDateException {
        if (!transactionLoaded) {
            loadTransactionFile();
            transactionLoaded = true;
        }
        for (Transaction card : transactions) {
            System.out.println(card);
        }
    }

    private void loadTransactionFile() throws CardException, TransactionDateException {
        String url = "D:\\IdeaProjects\\LAB\\LAB_Bank\\file.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(url);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner sc = new Scanner(fileInputStream);
        while (sc.hasNextLine()) {
            String[] listCard = sc.nextLine().split(",");
            if (listCard.length >= 3) {
                String dateString = listCard[2];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateRelease = null;
                try {
                    dateRelease = dateFormat.parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                listCard[3] = listCard[3].substring(0, listCard[3].length());
                Transaction newTransaction = new Transaction(listCard[0], listCard[1], dateRelease, Double.parseDouble(listCard[3]), listCard[4]);
                if (validateCardTransaction(newTransaction) && validateTransactionDate(dateRelease, listCard[1])) {
                    transactions.add(newTransaction);
                    update(newTransaction);
                } else {
                    System.out.println("Invalid data format in the file.");
                }

            }
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void addNew() throws CardException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter TransactionID");
        String transactionID = sc.nextLine();
        System.out.println("Enter CardID");
        String cardID = sc.nextLine();
        System.out.println("Enter money");
        double money = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter note");
        String note = sc.nextLine();
        System.out.println("Enter TransactionDate (YYYY-MM-DD)");
        String dateString = sc.nextLine();
        Date transactionDate = parseDate(dateString);
        try {
            Transaction newTransaction = new Transaction(transactionID, cardID, transactionDate, money, note);
            if (validateCardTransaction(newTransaction) && validateTransactionDate(transactionDate, cardID)) {
                transactions.add(newTransaction);
                update(newTransaction);
                System.out.println("Transaction added successfully!");
            } else {
                System.out.println("Invalid data format in the file.");
            }
        } catch (TransactionDateException e) {
            System.out.println(e.getMessage());
        }
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean validateTransactionDate(Date transactionDate, String cardID) throws TransactionDateException {
        if (transactionDate == null) {
            throw new TransactionDateException("Invalid date format. Please use YYYY-MM-DD.");
        }

        Card card = findCardByID(cardID);

        if (card == null) {
            throw new TransactionDateException("Card not found.");
        }
        if (transactionDate.before(card.getDateRelease())) {
            throw new TransactionDateException("Transaction date must be after the release date of the card.");
        }

        Date minimumDate = new Date(0);
        if (transactionDate.before(minimumDate)) {
            throw new TransactionDateException("Transaction date must be greater than or equal to 01/01/1900.");
        }
        return true;
    }

    private Card findCardByID(String cardID) {
        for (Card card : cardList) {
            if (card.getCardID().equals(cardID)) {
                return card;
            }
        }
        return null;
    }

    public class CardException extends Exception {
        public CardException(String message) {
            super(message);
        }
    }

    public class TransactionDateException extends Exception {
        public TransactionDateException(String message) {
            super(message);
        }
    }

    public boolean validateCardTransaction(Transaction transaction) throws CardException {
        for (Card card : cardList) {
            if (card.getCardID().equals(transaction.getCardID())) {
                if (card instanceof CreditCard) {
                    CreditCard creditCard = (CreditCard) card;
                    if (creditCard.getAmountDue() + transaction.getMoney() > creditCard.getAmountMax()) {
                        System.out.println("Fail transaction for: " + creditCard + " dont have enough money");
                        return false;
                    }
                } else if (card instanceof DebitCard) {
                    DebitCard debitCard = (DebitCard) card;
                    if (debitCard.getAmountRemain() < transaction.getMoney()) {
                        System.out.println("Fail transaction for:" + debitCard + " dont have enough money");
                        return false;
                    }
                } else if (card instanceof ATMCard) {
                    ATMCard atmCard = (ATMCard) card;
                    if (atmCard.getAmount() < transaction.getMoney()) {
                        System.out.println("Fail transaction for:" + atmCard + " dont have enough money");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean update(Transaction transaction) throws CardException {
        for (Card card : cardList) {
            if (card.getCardID().equals(transaction.getCardID())) {
                if (card instanceof CreditCard) {
                    CreditCard creditCard = (CreditCard) card;
                    creditCard.setAmountDue(creditCard.getAmountDue() + transaction.getMoney());
                } else if (card instanceof DebitCard) {
                    DebitCard debitCard = (DebitCard) card;
                    debitCard.setAmountRemain(debitCard.getAmountRemain() - transaction.getMoney());
                } else if (card instanceof ATMCard) {
                    ATMCard atmCard = (ATMCard) card;
                    atmCard.setAmount(atmCard.getAmount() - transaction.getMoney());
                }
            }
        }
        return true;
    }

    public void payment() throws TransactionDateException, CardException {
        Map<String, Double> cardSums = new HashMap<>();
        for (Transaction transaction : transactions) {
            String cardID = transaction.getCardID();
            double money = transaction.getMoney();
            if (cardSums.containsKey(cardID)) {
                double currentSum = cardSums.get(cardID);
                cardSums.put(cardID, currentSum + money);
            } else {
                cardSums.put(cardID, money);
            }
        }
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(cardSums.entrySet());

        Collections.sort(sortedList, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> entry1, Map.Entry<String, Double> entry2) {
//                return entry1.getKey().compareTo(entry2.getKey());  return sort with ID
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        Collections.reverse(sortedList);
        for (Map.Entry<String, Double> entry : sortedList) {
            System.out.println(entry.getKey() + ", total payment: " + entry.getValue());
            System.out.println("-----------------------");
        }
        System.out.println("Top 3 cards with the largest total payments:");
        int count = 0;
        for (Map.Entry<String, Double> entry : sortedList) {
            if (count < 3) {
                System.out.println(entry.getKey() + ", total payment: " + entry.getValue());
                System.out.println("-----------------------");
                count++;
            } else {
                break;
            }
        }

    }



        public void checkDate() {
            Map<Date, List<Transaction>> transactionsByDate = new HashMap<>();

            // Group transactions by date
            for (Transaction transaction : transactions) {
                Date date = transaction.getTransactionDate();
                if (!transactionsByDate.containsKey(date)) {
                    transactionsByDate.put(date, new ArrayList<>());
                }
                transactionsByDate.get(date).add(transaction);
            }

            // Print the transaction with the largest amount of money for each day
            for (Map.Entry<Date, List<Transaction>> entry : transactionsByDate.entrySet()) {
                Date date = entry.getKey();
                List<Transaction> transactionsOnDate = entry.getValue();

                // Find the transaction with the largest amount
                Transaction maxTransaction = Collections.max(transactionsOnDate, Comparator.comparingDouble(Transaction::getMoney));

                // Print the transaction with the largest amount
                System.out.println("Transaction on " + date + ":");
                System.out.println("Money: " + maxTransaction.getMoney());
                // Add other transaction details as needed
                System.out.println("-----------------------");
            }
        }
    }









