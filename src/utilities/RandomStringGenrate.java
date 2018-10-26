package utilities;

import org.testng.annotations.Test;

import java.util.Random;

public class RandomStringGenrate
{

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String adding = null;
        int howmanystring = 5;
        for (int i = 1; i <= howmanystring; i++)
        {
            // System.out.println("length of string = " + SALTCHARS.length());
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 5)
            { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            adding = saltStr + "@gmail.com";
            //System.out.println("length of string = " + saltStr.length());

            String dradding  = adding;

        }

        return adding;
    }
}
