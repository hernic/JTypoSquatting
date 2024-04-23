package com.aleph.graymatter.jtyposquatting.net;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;

import java.net.URI;
import java.net.URISyntaxException;

public final class DomainName {
    private final String subDomain;
    private final String domain;
    private final String TLD;

    public DomainName(String domainName) throws InvalidDomainException {
        if (!isValidDomain(domainName)) {
            throw new InvalidDomainException(domainName + " is not valid");
        } else {
            this.TLD = getSuffix(domainName);
            String domainWithoutTLD = getDomainWithoutTLD(domainName);
            this.domain = getDomainWithoutSubDomain(domainWithoutTLD);
            this.subDomain = getSubDomain(domainWithoutTLD);
        }
    }

    public static String getDomainWithoutSubDomainMinusTLD(final String domain) {
        if (!haveSubDomain(domain)) {
            return getDomainWithoutTLD(domain);
        } else {
            String domainWithoutTLD = getDomainWithoutTLD(domain);
            return getDomainWithoutSubDomain(domainWithoutTLD);
        }
    }


    private static boolean isValidDomain(String domainName) {
        return domainName.contains(".") && domainName.indexOf('.') != domainName.length() - 1;
    }

    public static boolean haveSubDomain(final String domain) {
        return domain.indexOf(".") != domain.lastIndexOf(".");
    }

    public static String getSubDomain(final String domain) {
        if (haveSubDomain(domain)) {
            int inc_temp = domain.indexOf(".");
            return domain.substring(0, inc_temp);
        } else {
            return "";
        }
    }

    public static String getDomainWithoutSubDomain(final String domain) {
        if (!haveSubDomain(domain)) {
            return domain;
        } else {
            return domain.substring(domain.indexOf(".") + 1);
        }
    }

    public static String getDomainWithoutTLD(final String domain) {
        int inc_temp = domain.lastIndexOf(".");
        if (inc_temp == -1) {
            return domain;
        } else {
            return domain.substring(0, inc_temp);
        }
    }

    public static String getSuffix(String domain) {
        int inc_temp = domain.lastIndexOf(".");
        if (inc_temp == -1) {
            return "";
        } else {
            return domain.substring(inc_temp + 1);
        }
    }

    public boolean haveSubDomain() {
        return !subDomain.isEmpty();
    }

    public String getSubDomain() {
        return subDomain;
    }

    public String getTLD() {
        return TLD;
    }

    public String getDomain() {
        return domain;
    }

    public URI getAsHttpsUrl() throws URISyntaxException {
        return new URI("https://" + this);
    }

    public String toString() {
        return (subDomain.isEmpty() ? "" : subDomain + ".") + domain + "." + TLD;
    }
}
