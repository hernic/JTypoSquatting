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

        if (domainWithoutTLD.indexOf('a') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);

            idx = stringBuilder.indexOf("a");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('a').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('a')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('b') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("b");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('b').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('b')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('c') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("c");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('c').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('c')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('d') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("d");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('d').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('d')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('e') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("e");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('e').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('e')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('f') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("f");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('f').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('f')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('g') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("g");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('g').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('g')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('h') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("h");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('h').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('h')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('i') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("i");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('i').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('i')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('j') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("j");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('j').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('j')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('k') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("k");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('k').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('k')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('l') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("l");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('l').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('l')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('m') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("m");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('m').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('m')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('n') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("n");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('n').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('n')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('o') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("o");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('o').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('o')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('p') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("p");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('p').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('p')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('q') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("q");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('q').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('q')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('r') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("r");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('r').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('r')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('s') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("s");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('s').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('s')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('t') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("t");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('t').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('t')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('u') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("u");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('u').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('u')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('v') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("v");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('v').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('v')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('w') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("w");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('w').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('w')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('x') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("x");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('x').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('x')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('y') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("y");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('z').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('y')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
        if (domainWithoutTLD.indexOf('z') != -1) {
            stringBuilder = new StringBuilder(domainWithoutTLD);
            idx = stringBuilder.indexOf("z");
            for (int i = 0; i < Const.SIMILAR_CHAR.get('z').length; i++) {
                stringBuilder.replace(idx, idx + 1, Const.SIMILAR_CHAR.get('z')[i]);
                resultList.add(new DomainName(stringBuilder.toString()+'.'+TLD));
            }
        }
    }
}


