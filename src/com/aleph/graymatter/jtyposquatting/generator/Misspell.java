package com.aleph.graymatter.jtyposquatting.generator;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.net.DomainName;
import com.aleph.graymatter.jtyposquatting.util.JSonUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Misspell {

    private static final JSONParser jsonP = new JSONParser();

    public static void AddMisspelledDomains(DomainName domainName, ArrayList<DomainName> resultList) throws FileNotFoundException, InvalidDomainException {
        JSONObject jo;
        try {
            jo = JSonUtils.KeysValuesSwap((JSONObject) jsonP.parse(new FileReader("common-misspellings.json")));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        Set<String> keySet = jo.keySet();
        Iterator<String> iterator = keySet.iterator();

        String key;
        while (iterator.hasNext()) {
            key = iterator.next();

            String TLD = DomainName.getSuffix(domainName.toString());

            if (DomainName.getDomainWithoutTLD(domainName.toString()).contains(key)) {
                //TODO : implements and find some other misspells per country
                System.out.println(domainName + " could be " + jo.get(key));
                String missSpelledDomainWithoutTLD = DomainName.getDomainWithoutTLD(domainName.toString());
                missSpelledDomainWithoutTLD = missSpelledDomainWithoutTLD.replace((CharSequence) key, (CharSequence) jo.get(key));

                resultList.add(new DomainName(missSpelledDomainWithoutTLD+'.'+TLD));
            }
        }

    }
}
