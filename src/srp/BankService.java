package srp;

import java.util.Arrays;
import java.util.Iterator;

public class BankService {

    public Long deposit(Long amount, String accountNo) {
        return 0l;
    }

    public Long withDraw(Long amount, String accountNo) {
        return 0l;
    }

    public void printPassbook() {

    }

    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {

        }

        if (loanType.equals("personalLoan")) {

        }

        if (loanType.equals("car")) {

        }
    }

    public void sendOtp(String medium) {
        if (medium.equals("email")) {

        }
    }
}


class ArrayPrintingExercise {
    public static void main(String[] args) {
        String[] strArray = new String[]{"John", "Mary", "Bob"};
        Iterator<String> it = Arrays.asList(strArray).iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}

