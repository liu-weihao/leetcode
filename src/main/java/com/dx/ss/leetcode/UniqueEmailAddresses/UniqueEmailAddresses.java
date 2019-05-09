package com.dx.ss.leetcode.UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>(emails.length);
        for (String email : emails) {
            String localName = email.substring(0, email.indexOf("@"));

            String newEmail = localName.replaceAll("\\.", "");
            if (newEmail.contains("+")) {
                set.add(email.replace(localName, newEmail.substring(0, newEmail.indexOf("+"))));
            } else {
                set.add(email.replace(localName, newEmail));
            }
        }
        return set.size();
    }

    public static void main(String[] args){
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
        int i = uniqueEmailAddresses.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
        System.out.println(i);
    }
}
