package com.aleph.graymatter.jtyposquatting.generator;

import com.google.common.collect.ImmutableList;
import com.google.common.net.InternetDomainName;

import java.util.ArrayList;

// it would not work with domain names like xxx.yyy.www.zz domains with www.yyy has subdomain
public class AddDash {
    public static String[] addDash(InternetDomainName internetDomainName, ArrayList<InternetDomainName> resultList, boolean verbose, int limit, boolean giveVariations, boolean keepOriginal, boolean combo) {
        if (resultList.size()<limit) {
            ArrayList<InternetDomainName> resultLoc = new ArrayList<InternetDomainName>();
            ArrayList<InternetDomainName> locList = new ArrayList<InternetDomainName>();

            ImmutableList<String> parts = internetDomainName.parts();
            StringBuilder prefix = new StringBuilder();

            if (parts.size()>= 3) {
                prefix.append(parts.getFirst()) ;
            }
            String domainMinusTLD = parts.get(parts.size()-2);
            String TLD = parts.getLast();

            return new String[]{prefix.toString(), domainMinusTLD, TLD};
        }
        else return new String[3];
    }
}
