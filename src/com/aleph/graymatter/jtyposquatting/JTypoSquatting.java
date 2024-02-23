package com.aleph.graymatter.jtyposquatting;

import com.aleph.graymatter.jtyposquatting.generator.Dash;
import com.aleph.graymatter.jtyposquatting.generator.Homoglyph;
import com.aleph.graymatter.jtyposquatting.generator.TLD;
import com.aleph.graymatter.jtyposquatting.net.DomainName;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static com.aleph.graymatter.jtyposquatting.generator.Misppell.AddMisspelledDomains;

public class JTypoSquatting {
    private StringBuilder listOfDomains = new StringBuilder();

    public JTypoSquatting(String domain) throws FileNotFoundException, InvalidDomainException {
        DomainName domainName = null;
        try {
            domainName = new DomainName(domain);
        } catch (InvalidDomainException e) {
            throw new RuntimeException(e);
        }


        UpdateDDNSList();
        UpdateTLDList();

        ArrayList<DomainName> domainsArrayResults = new ArrayList<DomainName>();
        Homoglyph.addHomglyphedDomains(domainName,
                domainsArrayResults,
                false,
                200,
                false,
                false,
                false);

        Dash.addDash(domainName,
                domainsArrayResults,
                false,
                200,
                false,
                false,
                false);
        Dash.removeDash(domainName,
                domainsArrayResults,
                false,
                200,
                false,
                false,
                false);

        TLD.AddAndReplaceAllTLD(domainName,
                domainsArrayResults,
                false,
                200,
                false,
                false,
                false);

        try {
            AddMisspelledDomains(domainName,
                    domainsArrayResults,
                    false,
                    200,
                    false,
                    false,
                    false);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < domainsArrayResults.size(); i++) {
            try {
                listOfDomains.append(domainsArrayResults.get(i).getAsHttpsUrl().toString()).append('\n');
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void UpdateDDNSList() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://raw.githubusercontent.com/MISP/misp-warninglists/main/lists/dynamic-dns/list.json"))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("dynamic-dns.json", StandardCharsets.UTF_8);
            writer.print(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert writer != null;
            writer.close();
        }
    }

    private static void UpdateTLDList() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://data.iana.org/TLD/tlds-alpha-by-domain.txt"))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("TLD.txt", StandardCharsets.UTF_8);
            writer.print(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert writer != null;
            writer.close();
        }
    }

    public String getListOfDomainsAsURL() {
        return listOfDomains.toString();
    }
}
