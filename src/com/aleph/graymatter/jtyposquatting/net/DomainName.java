package com.aleph.graymatter.jtyposquatting.net;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.google.common.net.InternetDomainName;

import java.net.URI;
import java.net.URISyntaxException;

public final class DomainName {
    private final String subDomain;
    private final String domain;
    private final String TLD;

    public DomainName(String domainName) throws InvalidDomainException {
        if (!InternetDomainName.isValid(domainName)) {
            throw new InvalidDomainException(domainName + " is not valid");
        } else {
            subDomain = getSubDomain(domainName);
            domain = getDomainWithoutSubDomain(domainName);
            TLD = getSuffix(domainName);
        }
    }

    public static boolean haveSubDomain(final String domain) {
        return (domain.indexOf(".")) != (domain.lastIndexOf("."));
    }

    public static String getSubDomain(final String domain) {
        if (DomainName.haveSubDomain(domain)) {
            StringBuilder sb = new StringBuilder(DomainName.getDomainWithoutTLD(domain));
            int idx = sb.lastIndexOf(".");
            if (idx != -1)
                sb.delete(idx, sb.length());
            return sb.toString();
        } else {
            return "";
        }
    }

    public static String getDomainWithoutSubDomainMinusTLD(final String domain) {
        StringBuilder sb = new StringBuilder(getDomainWithoutSubDomain(domain));
        String suffix = getSuffix(domain);
        int start = sb.indexOf(suffix) - 1;
        int end = sb.indexOf(suffix) - 1 + suffix.length() + 1;
        sb.delete(start, end);
        return sb.toString();
    }

    public static String getDomainWithoutSubDomain(final String domain) {
        StringBuilder sb = new StringBuilder(domain);
        String subDomain = DomainName.getSubDomain(domain);
        sb.delete(sb.indexOf(subDomain), subDomain.length() + 1);
        return sb.toString();
    }

    public static String getDomainWithoutTLD(final String domain) {
        StringBuilder sb = new StringBuilder(domain);
        int idx = sb.lastIndexOf(DomainName.getSuffix(domain));
        sb.delete(idx - 1, sb.length()); //-1 for removing the dot

        return sb.toString();
    }

    public static String getSuffix(String domain) {
        return domain.substring(domain.lastIndexOf(".") + 1);
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
        return getSubDomain() + '.' + getDomain();
    }
}
