package com.aleph.graymatter.jtyposquatting;

// source : https://raw.githubusercontent.com/MISP/misp-warninglists/main/lists/dynamic-dns/list.json
// as misp_warning_list_json

import com.aleph.graymatter.jtyposquatting.ui.JTypoFrame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws InvalidDomainException, URISyntaxException, IOException {
        JTypoFrame jTypoFrame = new JTypoFrame();
        jTypoFrame.setVisible(true);
    }
}