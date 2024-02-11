package com.aleph.graymatter.jtyposquatting;

// source : https://raw.githubusercontent.com/MISP/misp-warninglists/main/lists/dynamic-dns/list.json
// as misp_warning_list_json

import com.aleph.graymatter.jtyposquatting.constants.Const;
import com.aleph.graymatter.jtyposquatting.generator.AddDash;
import com.google.common.net.InternetDomainName;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
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
        }
        finally {
            assert writer != null;
            writer.close();
        }
    }

    private static void runAll(String domain, int limit, String formatOutput, String pathOutput, boolean verbose, boolean give_variations, boolean keep_original, boolean all_homoglyph) {
        ArrayList<String> resultList = new ArrayList<String>();
    }

    public static void main(String[] args) {
        UpdateDDNSList();
        System.out.println(Arrays.toString(AddDash.addDash(InternetDomainName.from("aleph-networks.com"),
                new ArrayList<>(),
                false,
                200,
                false,
                false,
                false)));
        //JTypoSquatting window = new JTypoSquatting();
    }
}