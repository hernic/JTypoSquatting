package com.aleph.graymatter.jtyposquatting.generator;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.constants.Const;
import com.aleph.graymatter.jtyposquatting.net.DomainName;

import java.util.ArrayList;

public class Homoglyph {
    public static void addHomglyphedDomains(DomainName domainName, ArrayList<DomainName> resultList, boolean verbose, int limit, boolean giveVariations, boolean keepOriginal, boolean combo) throws InvalidDomainException {
        StringBuilder stringBuilder = null;
        int idx = -1;
        String domainWithoutTLD = DomainName.getDomainWithoutTLD(domainName.toString());
        String TLD = domainName.getTLD();

        if (domainName.toString().indexOf('a') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);

            idx = stringBuilder.indexOf("a");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('a').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('a')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainName.toString().indexOf('b') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("b");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('b').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('b')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainName.toString().indexOf('c') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("c");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('c').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('c')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainName.toString().indexOf('d') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("d");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('d').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('d')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainName.toString().indexOf('e') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("e");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('e').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('e')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }

    }
}


