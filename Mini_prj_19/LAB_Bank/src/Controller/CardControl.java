package Controller;

import Model.*;
import View.Validation;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CardControl {
    protected static ArrayList<Card> cardList = new ArrayList<>();
    protected Validation val;

    public CardControl(ArrayList<Card> cardList, Validation val) {
        this.cardList = cardList;
        this.val = val;
    }

    public CardControl() {
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    public Validation getVal() {
        return val;
    }

    public void setVal(Validation val) {
        this.val = val;
    }


    public void addNew(){
        ATMCard atmCard = new ATMCard();
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type of card ");
        System.out.println("1.ATMCard  ");
        System.out.println("2.DebitCard ");
        System.out.println("3.CreditCard ");
        System.out.println("Choose: ");
        int a = sc.nextInt();
        sc.nextLine();
        if (a==1){
            cardList.add(atmCard.createNewCard());
        }
        if (a==2){
            cardList.add(debitCard.createNewCard());
        }
        if (a==3){
            cardList.add(creditCard.createNewCard());
        }
    }
    private boolean cardLoaded = false;
    public void show(){
        if (!cardLoaded) {
            readFile();
            cardLoaded = true;
        }
        for (Card card : cardList) {
            System.out.println(card);
        }
    }
//    public void loadCardFile() {
//        String url = "D:\\IdeaProjects\\LAB\\LAB_Bank\\fileCard.txt";
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(url);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        Scanner sc = new Scanner(fileInputStream);
//        while (sc.hasNextLine()) {
//            String[] listCard = sc.nextLine().split(",");
//            if (listCard.length >= 2) {
//                String dateString = listCard[2];
//                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                Date dateRelease = null;
//                try {
//                    dateRelease = dateFormat.parse(dateString);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                Card newCard = new Card(listCard[0], listCard[1], dateRelease, Integer.parseInt(listCard[3]));
//                cardList.add(newCard);
//                Collections.sort(cardList, new Comparator<Card>() {
//                    @Override
//                    public int compare(Card card1, Card card2) {
//                        return card1.getDateRelease().compareTo(card2.getDateRelease());
//                    }
//                });
//            } else {
//                System.out.println("Invalid data format in the file.");
//            }
//        }
//        try {
//            fileInputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    public void readFile(){
        String filePath = "D:\\\\IdeaProjects\\\\LAB\\\\LAB_Bank\\\\fileCard.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                int cardType = Integer.parseInt(tokens[3]);
                try {
                    Date dateRelease = dateFormat.parse(tokens[2]);
                    switch(cardType){
                        case 1:
                            Date creditDateValid = dateFormat.parse(tokens[4]);
                            double amountDue = Double.parseDouble(tokens[5]);
                            double amountMax = Double.parseDouble(tokens[6]);
                            CreditCard creditCard = new CreditCard(tokens[0],tokens[1],dateRelease,cardType,creditDateValid,amountDue,amountMax);
                            cardList.add(creditCard);
                            break;
                        case 2:
                            Date debitDateValid = dateFormat.parse(tokens[4]);
                            double amountRemain = Double.parseDouble(tokens[5]);
                            DebitCard debitCard = new DebitCard(tokens[0],tokens[1],dateRelease,cardType,debitDateValid,amountRemain);
                            cardList.add(debitCard);
                            break;
                        case 3:
                            double amount = Double.parseDouble(tokens[4]);
                            ATMCard atmCard = new ATMCard(tokens[0],tokens[1],dateRelease,cardType,amount);
                            cardList.add(atmCard);
                            break;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
