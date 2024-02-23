package com.aleph.graymatter.jtyposquatting.generator;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.net.DomainName;

import java.util.ArrayList;

// it would not work with domain names like xxx.yyy.www.zz domains with www.yyy has subdomain
public class Dash {
    public static void addDash(DomainName domainName, ArrayList<DomainName> resultList, boolean verbose, int limit, boolean giveVariations, boolean keepOriginal, boolean combo) {
        if (resultList.size() < limit) {

            String domainWithoutSubDomainMinusTLD = DomainName.getDomainWithoutSubDomainMinusTLD(domainName.toString());

            for (int i = 1; i < domainWithoutSubDomainMinusTLD.length(); i++) {
                StringBuilder sb = new StringBuilder(domainWithoutSubDomainMinusTLD);
                sb.insert(i, '-');
                try {
                    resultList.add(new DomainName(domainName.getSubDomain() + '.' + sb.toString() + '.' + domainName.getTLD()));
                } catch (InvalidDomainException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void removeDash(DomainName domainName, ArrayList<DomainName> resultList, boolean verbose, int limit, boolean giveVariations, boolean keepOriginal, boolean combo) {
        if (resultList.size() < limit) {
            String domainWithoutSubDomainMinusTLD = DomainName.getDomainWithoutSubDomainMinusTLD(domainName.toString());
            StringBuilder sb = new StringBuilder(domainWithoutSubDomainMinusTLD);

            while (sb.indexOf("-") != -1) {
                sb.delete(sb.indexOf("-"), sb.indexOf("-") + 1);
                try {
                    resultList.add(new DomainName(domainName.getSubDomain() + '.' + sb.toString() + '.' + domainName.getTLD()));
                } catch (InvalidDomainException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
