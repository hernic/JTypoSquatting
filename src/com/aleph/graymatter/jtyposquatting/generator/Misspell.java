package com.aleph.graymatter.jtyposquatting.generator;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.net.DomainName;
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
            jo = (JSONObject) jsonP.parse(new FileReader("common-misspellings.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        Set<String> misValues = jo.keySet();
        Iterator<String> iterator = misValues.iterator();

        String validSpell;
        while (iterator.hasNext()) {
            validSpell = iterator.next();

            if (domainName.toString().contains(validSpell)) {
                //TODO : implements and find some other misspells per country
                System.out.println(domainName + " could be " + jo.get(validSpell));
                String missSpelledDomain = domainName.toString();
                missSpelledDomain = missSpelledDomain.replace((CharSequence) validSpell, (CharSequence) jo.get(validSpell));

                resultList.add(new DomainName(missSpelledDomain));
            }
        }

    }
}
