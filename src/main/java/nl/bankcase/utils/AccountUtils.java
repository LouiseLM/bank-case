package nl.bankcase.utils;

import java.util.Random;

public class AccountUtils {
    public String makeIban() {
        StringBuilder start = new StringBuilder("NL");
        Random value = new Random();

        int r1 = value.nextInt(10);
        int r2 = value.nextInt(10);
        start.append(r1).append(r2).append(" RABO ");

        int count = 0;
        int n = 0;
        for(int i = 0; i < 10; i++)
        {
            if(count == 4)
            {
                start.append(" ");
                count =0;
            }
            else
                n = value.nextInt(10);
            start.append(n);
            count++;

        }
        return start.toString();
    }
}
