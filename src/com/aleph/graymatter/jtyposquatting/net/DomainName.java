package com.aleph.graymatter.jtyposquatting.net;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.google.common.net.InternetDomainName;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static String getSubDomain(final String domain) {
        StringBuilder sb = new StringBuilder(DomainName.getDomainWithoutTLD(domain));
        int idx = sb.lastIndexOf(".");
        if (idx != -1)
            sb.delete(idx, sb.length());
        return sb.toString();
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
        if (InternetDomainName.from(domain).registrySuffix() == null) {
            StringBuilder notValid = new StringBuilder(domain);
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.INFO, domain + " is not a valid TLD for google InternetDomainName Class");
            return notValid.substring(notValid.lastIndexOf(".") + 1);
        } else {
            return Objects.requireNonNull(InternetDomainName.from(domain).registrySuffix()).toString();
        }
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
        return new URI("https://" + this.toString());
    }

    public String toString() {
        return getSubDomain() + '.' + getDomain();
    }
}
