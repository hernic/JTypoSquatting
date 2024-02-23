package com.aleph.graymatter.jtyposquatting.generator;

import com.aleph.graymatter.jtyposquatting.net.DomainName;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Misppell {

    private static final JSONParser jsonP = new JSONParser();

    public static void AddMisspelledDomains(DomainName domainName, ArrayList<DomainName> resultList) throws FileNotFoundException {
        JSONObject jo;
        try {
            jo = (JSONObject) jsonP.parse(new FileReader("common-misspellings.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        Collection<String> misValues = (Collection<String>) jo.values();
        Iterator iterator = misValues.iterator();

        String validSpell = "";
        while (iterator.hasNext())
            validSpell = iterator.next().toString();
        if (domainName.toString().contains(validSpell)) {
            //jo.
        }

    }


}

