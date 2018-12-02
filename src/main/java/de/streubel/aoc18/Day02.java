package de.streubel.aoc18;

import de.streubel.AdventOfCodeRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day02 extends AdventOfCodeRunner {

    @Override
    public void run() {

        int nrOfTwoTimes = 0;
        int nrOfThreeTimes = 0;
        for (String s: input) {
            Map<Character, Integer> charCounter = countChars(s);
            if (charCounter.values().contains(2)) {
                nrOfTwoTimes++;
            }
            if (charCounter.values().contains(3)) {
                nrOfThreeTimes++;
            }
        }

        int checksum = nrOfTwoTimes * nrOfThreeTimes;

        System.out.println("Result Part 1: checksum="+checksum);


        final String[] strings = input;
        final List<String> commonLetters = new ArrayList<>();
        for (int i=0; i<strings.length; i++) {
            for (int j=i+1; j<strings.length; j++) {
                int pos = findDifferentCharPosition(strings[i], strings[j]);
                if (pos >= 0) {
                    commonLetters.add(strings[i].substring(0, pos).concat(strings[i].substring(pos+1)));
                }
            }
        }

        System.out.println("Result Part 2: commonLetters="+commonLetters);

    }

    private Map<Character, Integer> countChars(String s) {
        final Map<Character, Integer> charCounter = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charCounter.containsKey(c)) {
                charCounter.put(c, charCounter.get(c) + 1);
            } else {
                charCounter.put(c, 1);
            }
        }
        return charCounter;
    }

    private int findDifferentCharPosition(final String s1, final String s2) {
        int pos = -1;
        int differences = 0;
        for (int i=0; i<Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
                pos = i;
            }
        }
        return differences == 1 ? pos : -1;
    }

    private static String[] testInputPart1 = {
        "abcdef",
        "bababc",
        "abbcde",
        "abcccd",
        "aabcdd",
        "abcdee",
        "ababab",
    };

    private static String[] testInputPart2 = {
        "abcde",
        "fghij",
        "klmno",
        "pqrst",
        "fguij",
        "axcye",
        "wvxyz",
    };

    private static String[] input = {
        "auxwcbzrmdvpsjfgkrthnkioqm",
        "auxwcbzrmdvpsjfgbltonyijqe",
        "auxwcbzrmdfpsefgklthnoioqe",
        "auxwcbzrmdvpsjfgkluhnjisqe",
        "auxwcbzrmdvesjfgdzthnyioqe",
        "auxwcbzrmdvhsjfgklthnmijqe",
        "auxwcbzridvpsjfgkltxeyioqe",
        "ayxwcbzrgdvpsjfgklthiyioqe",
        "ajxwcbzrmdvpsjfgklkhnyiode",
        "auxwcbcrmdvpsjfqelthnyioqe",
        "auxwcbzrmsvpsjsgklthnyiope",
        "auxwcbzrmqvpsjzgklghnyioqe",
        "auxwcbzrmdvpsjtqklthxyioqe",
        "auxwcbzrmdopsjfdklthncioqe",
        "auxwcbzrmdvpsjfgkltmhyfoqe",
        "aixwcbzrmdvpsjfgllthdyeoqe",
        "vuxicbzrmdepsjfgklthnyioqe",
        "auxwcbbxmdkpsjfgklthnyioqe",
        "auxwcbzrgdvpsofaklthnyioqe",
        "auxycbzrmdvpsjfgklthnyuose",
        "aujwcbzrmdvprjfgkltcnyioqe",
        "auxwgbzrmdvpsjfgyzthnyioqe",
        "auxwcbzrmavpsjfgkltsnyiome",
        "auxwcbgrmdvpsjfgkdthnrioqe",
        "kuxwcbzrmdvpsyfgklthnyioue",
        "auxwcbzomdvpjdfgklthnyioqe",
        "auxwcbzrmdppsjfgklthvyifqe",
        "aunwubzrmdvpsjrgklthnyioqe",
        "auxwcbzrmoipsjfgklbhnyioqe",
        "auxwdbzrmdvpsjfgmlthnyioce",
        "auxwcbzjmsvpsjfiklthnyioqe",
        "auxwcbzrmwcpsjfcklthnyioqe",
        "auxwcbzfmdvprjfhklthnyioqe",
        "auxdcbzrgdvpsjfgklthnyxoqe",
        "wuxwbbzrmdvpsjfgklthnyiote",
        "auowcbjrmdvpsjfgklthnyfoqe",
        "auxwsbzrmdvpsjfglltcnyioqe",
        "quxwcbzrmdvpkjfgklthnyioqt",
        "vuxwcbzrudvpsjfgklthnyioqi",
        "puxwcbzrmdvgsjfgklthncioqe",
        "luxdcbzrmdvpsjfgkothnyioqe",
        "auxwcbzrmdvpsjfyklthfhioqe",
        "auxwcbqrmdvpsjfgkldhnyiote",
        "quxwcbzrmlvpsjfgklthnyioqi",
        "auxwcbzgmdvpsjfoklthnyiuqe",
        "auxwcbzrmdvpsbfgkltdjyioqe",
        "auxwcbzsmdrpsjfgklthpyioqe",
        "auxwcbzrmfvpsjfwklthnyiote",
        "auxbkpzrmdvpsjfgklthnyioqe",
        "auxwcbzrddvpsjfsklthnyroqe",
        "abxwcbzrmdvpsjfgkltdnyivqe",
        "awxwcbzrmvvpsjfgklthngioqe",
        "auxwcbzrmkvgsjfgkltcnyioqe",
        "auxwcbammdvpsjfgklthpyioqe",
        "auxwcbhrmdvpsjfgtlthnuioqe",
        "auxwcpzrmdvpbjogklthnyioqe",
        "auxwcbzrmdvpslfgklbhkyioqe",
        "auxwcbsrmdvpjjfgkldhnyioqe",
        "auxwcbzrmdqpsjfgauthnyioqe",
        "ydxwcbxrmdvpsjfgklthnyioqe",
        "auxwcbzrmdvpejfgklthnyyofe",
        "auxwchzrmxvpsjfgklthnyioqh",
        "auxwcbzrtdvpsjfgklxhnzioqe",
        "auxwcbyrmdvpsnfgklnhnyioqe",
        "auxwcbzrcdvpsjugklihnyioqe",
        "auxwcbzrddvpsjfgklhhnyiaqe",
        "aumwtbzrmdvpsjfgklthnyitqe",
        "auxucbzrmdvpsjfgklthwfioqe",
        "auxwcbzrmdvpzmfgkllhnyioqe",
        "auxwcbzrmdvpsjhgklthntiome",
        "buxwzbzrmdvpszfgklthnyioqe",
        "ouxwcbzsgdvpsjfgklthnyioqe",
        "auxwcbzrmdvpsjfskltgnyioqz",
        "auxwcbbrmdvpsjftklthnyioqu",
        "quxocbzrmdvpsjfgklthfyioqe",
        "acxwcbzrmdvpsjfgklfhnrioqe",
        "auxwcbzrmdnpsjfrkjthnyioqe",
        "wuxwybzrmdwpsjfgklthnyioqe",
        "auxwgbxrmdvpsjfghlthnyioqe",
        "atxwcbzrmdvnsjfgklthnyjoqe",
        "acxwcbzmmdvpsjfbklthnyioqe",
        "auxhcbzrmdvbsjbgklthnyioqe",
        "auxwlbzrfdvpsjfgxlthnyioqe",
        "auxwmbzrmdfpsjqgklthnyioqe",
        "auxwcbzrmdvpsgfgklahnyigqe",
        "auxwgbzrmdvpsjfgzldhnyioqe",
        "auxwcbzrmdvpydfgklthnyiohe",
        "auxwxbzrmdvpsjfsklchnyioqe",
        "auxqcbzrmdvpsjfgqlthnyiwqe",
        "auxwcozrmdvssbfgklthnyioqe",
        "auxvcczrmdvpsufgklthnyioqe",
        "auxwcbzrudvpsjfgklyhnyioxe",
        "aulwcbzrmdvpsjqgknthnyioqe",
        "auukcbzrmdvpsjfgklthtyioqe",
        "auxwcszimdvpsjfgklthnyigqe",
        "juxwcbzrbdvpsjfgklthnyboqe",
        "auxwcbzrmdvpjofgklthnyioqj",
        "auxwcbzrmdvpsjfgplfhnyione",
        "auxwcbzrmdhpsjfgkltknyeoqe",
        "luxwcqzrmdvpsjfgklthnbioqe",
        "uuxwcbzrmdvpsjfgkithnyiiqe",
        "auxwcbzrmdvpdjfgkrthnyeoqe",
        "auuwcbnrmdvpsjfgklthnjioqe",
        "auxwcnzrmdvpsjvgklthnyooqe",
        "auxwcbzcmdvpsjfcklthnyiose",
        "auxwcbzrldfpsjfgklthjyioqe",
        "auxwcizrmdvpsjfjklthnymoqe",
        "auxwcbtrmdvpsjfgtlphnyioqe",
        "amxwcbzrmdvksjfgklthnyiove",
        "auxwcbzrmdvpszfgkpthnyiuqe",
        "auxwcbzrmdvxdjfgkltqnyioqe",
        "auxwcbzrudvpsjfgklthnymiqe",
        "auxwcbirmdvfsjfgklmhnyioqe",
        "auwwcbzrndvprjfgklthnyioqe",
        "auxwcbormdgpsjfgklbhnyioqe",
        "auxwabzrmdupsjfgklthnyioqt",
        "auxvcbzrmdvpsjfgkltrmyioqe",
        "auxwcbzrmddpsjfsklthnyizqe",
        "auxwcczrmuvpyjfgklthnyioqe",
        "auxwcczrmdvpsnfgkpthnyioqe",
        "auxkcbzrmdvpsjfhklihnyioqe",
        "auxwcbzrmdvpsjfgklthnkijje",
        "auxwcbzcmdvpsjpgkldhnyioqe",
        "auxwcnzrudvpstfgklthnyioqe",
        "xuxwcbzrgdvusjfgklthnyioqe",
        "aaxwcbzrmdvpsjvgklthnyidqe",
        "auxwcbztmdvpsjfgklthnyhqqe",
        "auxwcbzrmfvpsjfgklthnyilfe",
        "auxwcbzrmdvksjfgklthjyioqq",
        "auxwcbzrmdzksjfgktthnyioqe",
        "auxwcbzrmfvpszfgklohnyioqe",
        "auxwckzamdvpsjfgklthnyioqs",
        "auxwcmzrhdvpsjfaklthnyioqe",
        "fuxwcbzrmdapsjfgklrhnyioqe",
        "avxwxbzrmdvpsjfgklthniioqe",
        "auxwubzrmevpsjfgkltpnyioqe",
        "fuxwcbzrgdvpsjfgklhhnyioqe",
        "duxwwbdrmdvpsjfgklthnyioqe",
        "audwcbzrmdvpnjcgklthnyioqe",
        "auxtcbzrmdvpsjmgklthnyyoqe",
        "aucwcbwrmdepsjfgklthnyioqe",
        "auxwcbzrudvpsjfpklthnyiose",
        "auxwcbzridvpsjfsklthxyioqe",
        "auxtcbzrmdvpscfgklyhnyioqe",
        "auxwcbzrmdvppjfgklthnyivee",
        "auxwdbzrmuvpskfgklthnyioqe",
        "auxwubzrmdvosjfgklthnyiope",
        "auxwcbzrmhnpsjfgklthnyimqe",
        "auxwcbzrmdqpwjfgkltpnyioqe",
        "auxwcbormdvpsjljklthnyioqe",
        "auxwcbzrmdjpsjfgkltjpyioqe",
        "auxwcbzrmdvpszfgklthkyizqe",
        "auxwcbzighvpsjfgklthnyioqe",
        "auxwcbzrmdlpsjfgcythnyioqe",
        "auxwcbzumdvpsjflklthnyimqe",
        "pdxwcbzrmdvpsjfgklthnyihqe",
        "auxwcbzrsdvpsjfgklhhvyioqe",
        "auxwcfzamdvpsjfgkmthnyioqe",
        "aexwcdzrmdvpsjogklthnyioqe",
        "auxxcbkrmavpsjfgklthnyioqe",
        "auxwcbzredvssjfgklthryioqe",
        "aupwqbzrmdvpsjfgklthnyioqc",
        "auxwcbzrmdvpkcagklthnyioqe",
        "auxwcbzrmdvwsbfgklthnlioqe",
        "aunwcbzxmdvhsjfgklthnyioqe",
        "auxwcbzrhddpsjfgklthnnioqe",
        "ouxwcbzrmdvtsifgklthnyioqe",
        "auxwcbzrmdqpsjfgklthnyfoqp",
        "auxwrbzrhdvpsjfgolthnyioqe",
        "auxwcbcqmdvpsjugklthnyioqe",
        "auxwcbzrqdvpsjhgklthnjioqe",
        "auxmcbzrmdvpsjfgmlthnyjoqe",
        "auxwcbzrmdvpsjfgzlthnycoqv",
        "auswcbzrmdvpsffgslthnyioqe",
        "auxwcbzrfdvpsjfrmlthnyioqe",
        "auxwcbzrmdvpsjngzlthnxioqe",
        "auxwcbzrmdvpsjfuqlthnyiyqe",
        "auxwzbzrrdvosjfgklthnyioqe",
        "auxwcbzdmdvpsjfikxthnyioqe",
        "guxwcbzrmdvpsjfgmlthnytoqe",
        "auxwcbzrmdvpspfgkytenyioqe",
        "auxvcbzrldvpsjfgklthnyhoqe",
        "auxwcbzrmavpckfgklthnyioqe",
        "autwcbzrmdvpsafgklthnyirqe",
        "auxwcbzrxuvpsjfgklthmyioqe",
        "auxwcbarmdppsjfgklthnywoqe",
        "anxvcbzrmdvpsjfgklthnyijqe",
        "auxwcbwrmdapsjngklthnyioqe",
        "abxwcbzrmdvpsjugkltgnyioqe",
        "auxwcbtrmdvpsjfgkltunyioue",
        "aujwcbzrmovpsjfgklthryioqe",
        "auxwcbzrydvpsjfgklthndikqe",
        "auxwcbzrmdvpsjfgklmrnyioqo",
        "auxwcbzrddvpsjfggithnyioqe",
        "auxwcbzrmdvpfjfaklthlyioqe",
        "fuxtcbzrmdvpsjfgklwhnyioqe",
        "tuxwcbzrjdvpsjfgjlthnyioqe",
        "auxwcbzrmdppsofgklthnyfoqe",
        "auxvclzamdvpsjfgklthnyioqe",
        "auxwcbzrmdvpsjfdklhhnzioqe",
        "auxwcbzrmsvpsvdgklthnyioqe",
        "arxfcbzrmdvpsvfgklthnyioqe",
        "auxzcbzrmdvpsjfgklthnhioqj",
        "auxwcbzrrdvpsjfgpltunyioqe",
        "auxuibzrmdvpwjfgklthnyioqe",
        "auxwcbzrwdqpsjfgklthnyooqe",
        "aujwcbzrmdvpsjvgklthxyioqe",
        "abxwcbzrmfvpsjfgklthnyxoqe",
        "aurwcbzrmdvpshfgklthnyhoqe",
        "auxwcbzjmdvpsjfgknthnycoqe",
        "auxwcbzrmdvpsjfgklmhxwioqe",
        "auxwcbzrmfvpsjfgklthnyiorq",
        "auxwcbormdvpsjfgklwhnlioqe",
        "auxwctzrmdvpsjfgklcknyioqe",
        "awxwcbzrmdvpsjfgvlthnyiome",
        "auxwcbzrmdvpsjfjklthnyixje",
        "auxwcsxrmdvpsjfgkltsnyioqe",
        "auxbmbzrmdvpsjfgklthnyioce",
        "auxwcbzrmdvpsjfukzthnytoqe",
        "aixwcbzrmdvpsjfgllthdyioqe",
        "auxwcbzrmdypsjfgklthnlioqy",
        "auxccbzrmdvpsjfgkltrnnioqe",
        "auxwcznrmdvpsjfgklthnykoqe",
        "auxwmqzrmdvpsjfgilthnyioqe",
        "auxwcbzrmdvpdyfgolthnyioqe",
        "auxwcbzrmdvpsjfgkmohnqioqe",
        "auxwcfzrmzvpsjfoklthnyioqe",
        "auxwjyzrmdvpsjfgulthnyioqe",
        "auxwcgzredvpsjfgkxthnyioqe",
        "wuxwcbtrmdvpsjfgklthnyiofe",
        "auxwcbzrmdopsgfgklthncioqe",
        "auxmcbzjmdvpsjfgklbhnyioqe",
        "auxwlbzrmdvpsjffklthgyioqe",
        "auxwcbzrmrvpsjfgqlthtyioqe",
        "kuxwhbzrmdvpsjfgklthgyioqe",
        "auxwcozrmdgpsjfgklthnydoqe",
        "auxwdbzrmdvpdjfgklthgyioqe",
        "auxwqbzrmdapsvfgklthnyioqe",
        "auqwcbzridvjsjfgklthnyioqe",
        "auxwckzrmdvpsjfoklthnyuoqe",
        "auxwcbzvmdvpsjfgklghnyiome",
        "auxtcbzrmdvpsjqgktthnyioqe",
        "auxwcbzrmdvesjfgkljhnnioqe",
        "auxwcbzrmpvpsqfgklthnqioqe",
        "auxwcbzrmdcpsqfgklthnzioqe",
        "yuxwcbzrmdvpsjggklthnlioqe",
        "auxwcbzradvpsjftklthoyioqe",
        "auxwcbzrmdvjujfgklmhnyioqe",
        "auxwcbzrmdvpsrfgklpinyioqe",
        "auxwobzrvqvpsjfgklthnyioqe",
    };
}
