package com.aleph.graymatter.jtyposquatting.generator;

import com.aleph.graymatter.jtyposquatting.InvalidDomainException;
import com.aleph.graymatter.jtyposquatting.net.DomainName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TLD {
    private static FileReader reader;
    private static BufferedReader br;

    public static void AddAndReplaceAllTLD(DomainName domainName, ArrayList<DomainName> resultList) {
        try {
            reader = new FileReader("res/TLD.txt", StandardCharsets.UTF_8);
            br = new BufferedReader(reader);

            String line = br.readLine();
            if (line != null) line = br.readLine(); // jump to the second line to sweep the comment
            while (line != null) {
                try {
                    DomainName newAddTLDDomainName = new DomainName(domainName.toString() + '.' + line.toLowerCase());
                    resultList.add(newAddTLDDomainName);
                    DomainName newReplaceTLDDomainName = new DomainName(DomainName.getDomainWithoutTLD(domainName.toString()) + '.' + line.toLowerCase());
                    resultList.add(newReplaceTLDDomainName);
                } catch (InvalidDomainException e) {
                    throw new RuntimeException(domainName.toString() + '.' + line.toLowerCase() + " is not a valid domain");
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert br != null;
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
