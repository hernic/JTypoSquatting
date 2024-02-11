package com.aleph.graymatter.jtyposquatting.constants;

import java.util.HashMap;

public final class Const {
    private static final String[] A = {"à", "á", "à", "â", "ã", "ä", "å", "ɑ", "ạ", "ǎ", "ă", "ȧ", "ą", "ə"};
    private static final String[] B = {"d", "ʙ", "ɓ", "ḃ", "ḅ", "ḇ", "ƅ"};
    private static final String[] C = {"e", "ƈ", "ċ", "ć", "ç", "č", "ĉ", "ᴄ"};
    private static final String[] D = {"b", "cl", "ɗ", "đ", "ď", "ɖ", "ḑ", "ḋ", "ḍ", "ḏ", "ḓ"};
    private static final String[] E = {"c", "é", "è", "ê", "ë", "ē", "ĕ", "ě", "ė", "ẹ", "ę", "ȩ", "ɇ", "ḛ"};
    private static final String[] F = {"ƒ", "ḟ"};
    private static final String[] G = {"q", "ɢ", "ɡ", "ġ", "ğ", "ǵ", "ģ", "ĝ", "ǧ", "ǥ"};
    private static final String[] H = {"ĥ", "ȟ", "ħ", "ɦ", "ḧ", "ḩ", "ⱨ", "ḣ", "ḥ", "ḫ", "ẖ"};
    private static final String[] I = {"1", "l", "í", "ì", "ï", "ı", "ɩ", "ǐ", "ĭ", "ỉ", "ị", "ɨ", "ȋ", "ī", "ɪ"};
    private static final String[] J = {"ʝ", "ǰ", "ɉ", "ĵ"};
    private static final String[] K = {"lc", "ḳ", "ḵ", "ⱪ", "ķ", "ᴋ"};
    private static final String[] L = {"1", "i", "ɫ", "ł", "ı", "ɩ"};
    private static final String[] M = {"n", "nn", "rn", "rr", "ṁ", "ṃ", "ᴍ", "ɱ", "ḿ"};
    private static final String[] N = {"m", "r", "ń", "ṅ", "ṇ", "ṉ", "ñ", "ņ", "ǹ", "ň", "ꞑ"};
    private static final String[] O = {"0", "ȯ", "ọ", "ỏ", "ơ", "ó", "ö", "ᴏ"};
    private static final String[] P = {"ƿ", "ƥ", "ṕ", "ṗ"};
    private static final String[] Q = {"g", "ʠ"};
    private static final String[] R = {"ʀ", "ɼ", "ɽ", "ŕ", "ŗ", "ř", "ɍ", "ɾ", "ȓ", "ȑ", "ṙ", "ṛ", "ṟ"};
    private static final String[] S = {"ʂ", "ś", "ṣ", "ṡ", "ș", "ŝ", "š", "ꜱ"};
    private static final String[] T = {"ţ", "ŧ", "ṫ", "ṭ", "ț", "ƫ"};
    private static final String[] U = {"ᴜ", "ǔ", "ŭ", "ü", "ʉ", "ù", "ú", "û", "ũ", "ū", "ų", "ư", "ů", "ű", "ȕ", "ȗ", "ụ"};
    private static final String[] V = {"ṿ", "ⱱ", "ᶌ", "ṽ", "ⱴ", "ᴠ"};
    private static final String[] W = {"vv", "ŵ", "ẁ", "ẃ", "ẅ", "ⱳ", "ẇ", "ẉ", "ẘ", "ᴡ"};
    private static final String[] X = {"ẋ", "ẍ"};
    private static final String[] Y = {"ʏ", "ý", "ÿ", "ŷ", "ƴ", "ȳ", "ɏ", "ỿ", "ẏ", "ỵ"};
    private static final String[] Z = {"ʐ", "ż", "ź", "ᴢ", "ƶ", "ẓ", "ẕ", "ⱬ"};

    public static final HashMap<Character, String[]> SIMILAR_CHAR = new HashMap<Character,String[]>();
    public static final HashMap<Character, String[]> NUMERAL = new HashMap<Character,String[]>();
    public static final String[] ALGO_NAME_LIST={ "omission", "repetition", "changeOrder", "replacement", "doubleReplacement",
            "addition", "missingDot", "stripDash", "vowelSwap", "addDash", "homoglyph",
            "commonMisspelling", "homophones", "wrongTld", "addTld", "subdomain",
            "singularPluralize", "changeDotDash", "wrongSld", "numeralSwap", "addDynamicDns"};

    public static final  String[] EXCLUDED_TLD =  {"gouv.fr"}; //for example

    private Const() {
        SIMILAR_CHAR.put('0', new String[]{"o"});
        SIMILAR_CHAR.put('1', new String[]{"l", "i", "ı"});
        SIMILAR_CHAR.put('2', new String[]{"ƻ"});
        SIMILAR_CHAR.put('5', new String[]{"ƽ"});
        SIMILAR_CHAR.put('a', A);
        SIMILAR_CHAR.put('b', B);
        SIMILAR_CHAR.put('c', C);
        SIMILAR_CHAR.put('d', D);
        SIMILAR_CHAR.put('e', E);
        SIMILAR_CHAR.put('f', F);
        SIMILAR_CHAR.put('g', G);
        SIMILAR_CHAR.put('h', H);
        SIMILAR_CHAR.put('i', I);
        SIMILAR_CHAR.put('j', J);
        SIMILAR_CHAR.put('k', K);
        SIMILAR_CHAR.put('l', L);
        SIMILAR_CHAR.put('m', M);
        SIMILAR_CHAR.put('n', N);
        SIMILAR_CHAR.put('o', O);
        SIMILAR_CHAR.put('p', P);
        SIMILAR_CHAR.put('q', Q);
        SIMILAR_CHAR.put('r', R);
        SIMILAR_CHAR.put('s', S);
        SIMILAR_CHAR.put('t', T);
        SIMILAR_CHAR.put('u', U);
        SIMILAR_CHAR.put('v', V);
        SIMILAR_CHAR.put('w', W);
        SIMILAR_CHAR.put('x', X);
        SIMILAR_CHAR.put('y', Y);
        SIMILAR_CHAR.put('z', Z);

        NUMERAL.put('0', new String[]{"zero"} );
        NUMERAL.put('1', new String[]{"one","first"} );
        NUMERAL.put('2', new String[]{"two","second"} );
        NUMERAL.put('3', new String[]{"three","third"} );
        NUMERAL.put('4', new String[]{"four","fourth","for"} );
        NUMERAL.put('5', new String[]{"five","fifth"} );
        NUMERAL.put('6', new String[]{"six","sixth"} );
        NUMERAL.put('7', new String[]{"seven","seventh"} );
        NUMERAL.put('8', new String[]{"eight","eighth"} );
        NUMERAL.put('9', new String[]{"nine","ninth"} );
    }

}
