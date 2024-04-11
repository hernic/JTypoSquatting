package com.aleph.graymatter.jtyposquatting;

import com.aleph.graymatter.jtyposquatting.generator.Dash;
import com.aleph.graymatter.jtyposquatting.generator.Homoglyph;
import com.aleph.graymatter.jtyposquatting.generator.Misspell;
import com.aleph.graymatter.jtyposquatting.generator.TLD;
import com.aleph.graymatter.jtyposquatting.net.DomainName;
import com.aleph.graymatter.jtyposquatting.ui.JTypoFrame;

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

public class JTypoSquatting {
    private final ArrayList<String> listOfDomains = new ArrayList<String>();

    public JTypoSquatting(String domain) throws FileNotFoundException, InvalidDomainException {
        DomainName domainName;
        try {
            domainName = new DomainName(domain);
        } catch (InvalidDomainException e) {
            throw e;
        }

        //UpdateDDNSList();
        try {
            UpdateTLDList();
        }
        catch(IOException ioe) {
            System.err.println(ioe);
        }

        ArrayList<DomainName> domainsArrayResults = new ArrayList<DomainName>();

        Misspell.AddMisspelledDomains(domainName, domainsArrayResults);
        Homoglyph.addHomglyphedDomains(domainName,
                domainsArrayResults);
        Dash.addDash(domainName,
                domainsArrayResults);
        Dash.removeDash(domainName,
                domainsArrayResults);
        TLD.AddAndReplaceAllTLD(domainName,
                domainsArrayResults);

     /*   try {
            AddMisspelledDomains(domainName, domainsArrayResults);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/
        for (DomainName domainsArrayResult : domainsArrayResults) {
            try {
                listOfDomains.add(domainsArrayResult.getAsHttpsUrl().toString());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void UpdateDDNSList() {
        //TODO : secure file upload update
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

    private static void UpdateTLDList() throws RuntimeException, IOException {
        // TODO : secure file updload/update
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
        } finally {
            assert writer != null;
            writer.close();
        }
    }

    public static void main(String[] args) throws InvalidDomainException, URISyntaxException, IOException {
        JTypoFrame jTypoFrame = new JTypoFrame();
        jTypoFrame.setVisible(true);
    }

    public String getListOfDomainsAsURL() {
        StringBuilder listOfDomainsAsString = new StringBuilder();
        listOfDomains.trimToSize();

        for (int i=0;i<listOfDomains.size();i++)
        {
            listOfDomainsAsString.append(listOfDomains.get(i)+'\n');
        }
        return listOfDomainsAsString.toString();
    }

    public String getNumberOfDomains() {
        listOfDomains.trimToSize();
        return Integer.toString(listOfDomains.size());
    }
}
