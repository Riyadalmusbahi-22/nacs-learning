package at.nacs.ex10creditcards.domain;

public class CreditCard {

    private String number;
    private String issuer;

    public CreditCard(String number, String issuer) {
        this.number = number;
        this.issuer = issuer;
    }

    public String getNumber() {
        return number;
    }

    public String getIssuer() {
        return issuer;
    }
}
