The goal of this project is to create a list of potentially **typo squatted domains** for checking with the Free tool *
*Aleph Search Clear** (or another one) : https://www.aleph-networks.eu/en/our-search-engines/aleph-search-clear/ you can
ask for an access here : https://www.aleph-networks.eu/en/contact/
![image](https://github.com/hernic/JTypoSquatting/assets/4397039/874a5ff7-68d5-4d8b-9a60-a4dddde188f9)

- This project is a ehanced version of https://github.com/typosquatter/ail-typo-squatting written in Java.
- This project is still in **draft mode**

![image](https://github.com/hernic/JTypoSquatting/assets/4397039/042a2ebf-2b8f-4950-b70f-e4e1717579c7)

Requirements:

- on Windows JTypoSquatting needs Java 21 (or 11) to be runned : https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe

Usage:

```
java -jar JTypoSquatting
```

Algorithms:

- Dash : adding, removing and moving Dash in the domain name (www.aleph-networks.eu > www.alephnetworks.eu)
- Homoglyphs : replacing characters which as visually similar to others
  ones (www.aleph-networks.eu > www.αleph-networks.eu)
- Misspells : replacing well spelled word with misspelled ones (english only) (www.absence.com > www.absense.com)
- TLD : changing TLD, and adding TLD to the domain name. This create company name as a
  subdomain (www.aleph_networks.eu > www.aleph-networks.fr or www.aleph-networks.eu > www.aleph-networks.eu.com). 
