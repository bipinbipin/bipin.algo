package bipin.advent;

import java.util.ArrayList;
import java.util.List;

public class TwentyTwentyOne_Day8 {
    /*
    0: 6
   *1: 2
    2: 5
    3: 5
   *4: 4
    5: 5
    6: 6
   *7: 3
   *8: 7
    9: 6
     */
    public static void main(String[] args) {
        //part II
        String topChar = "";
        for(String line : testInput.split(System.lineSeparator())) {
            String[] lineSections = line.split("\\|");
            for(String digit : lineSections[0].trim().split(" ")) {
//                if (digit.length() == )
            }
        }

    }

    static void partOne() {
        String[] lineArray = input.split(System.lineSeparator());

        int countOfKnown = 0;
        for(String line : lineArray) {
            String[] lineSections = line.split("\\|");
            for(String digit : lineSections[1].trim().split(" ")) {
                if (digit.length() == 2 || digit.length() == 4 || digit.length() == 3 || digit.length() == 7) {
                    countOfKnown++;
                }
            }
        }

        System.out.println("Number of Known Digits: " + countOfKnown);
    }

    static String testInput = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe\n" +
            "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc\n" +
            "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg\n" +
            "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb\n" +
            "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea\n" +
            "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb\n" +
            "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe\n" +
            "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef\n" +
            "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb\n" +
            "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce";

    static String input = "defabc gcb dbafcg gc gcbed fbecgd begfdac fcbde cfge debag | gfce fgce bdefgca aebgd\n" +
            "eabdc egbda bagcef eg fdageb beg bcfdag egdf agbfd cbgdafe | fdbga bge ebg eg\n" +
            "gfbda feg eg afgcbe fbdcag bfedg gead ecfdabg dfecb gedafb | gedbfa dgae degbf gefdb\n" +
            "ecadfb edg defgcb ecbda fbagcde ge dbeag gacbed agec bdfga | debcaf geafdbc gedab egabd\n" +
            "gcedbf bfeag bcgfdea bcgdaf eg gfe gace cgefab gabcf edfba | gbcfa gfe gef eg\n" +
            "bd bcdgefa dab gcdbaf dabfec cedab gcafde bgcae cafed debf | efcdab dba ebdca edafcb\n" +
            "cdaef fbcedg gdaeb gedcfa cgaed bcfaed gc ceg cgaf eadfbcg | cdfae acfg adbcefg cg\n" +
            "cagbed fbedca cfgdabe ecbda aedfg bcge dfagbc dceag cdg cg | abdec cgd bagdecf eadbc\n" +
            "adbfc fdcabg bg ceabfd bfg bcefga cgbd fgaed fdbag cfbeadg | bfadg bagfcd aefbgcd bg\n" +
            "agbefc aebc cbg cb dafgce deafbgc ebgdf ecfga cgfeb fgdbac | bdfge gefca dgefac ecbfg\n" +
            "cgb cbefgd debac ceadfbg bgceaf gbecd fgdeb cg dgfeab cfdg | fbeacg eafbgcd abcde bfcgdae\n" +
            "aedf fcged abfdcg fcadg ef bgcde efc dgacef fcgbea acebgfd | edbgc geacdf cagdfe bgcfea\n" +
            "gdeba bcafed efbacgd efdacg febadg eg gacdb fadeb bgef ega | bdgae cagbfde cdgba edfbac\n" +
            "gdcae dab bgac cegafdb ab ebafcd gbadce dcefag gfdeb degab | fedabc bcag adceg egbfd\n" +
            "fgcda bgedfa abec bcedfg dgeac dagbe cdeagb ecd ec cfegdba | ecd ce acgde aecdg\n" +
            "dfage becg dceabf beacgf eab acfdgbe gbdcaf bafge fgcab be | dfgcba gcfab eacbfd gaebf\n" +
            "dfabc ecgad fcdabe gfc bedfcg cdagbf dacgf bdgfeac bfag gf | dcfab fagb cgfda agbf\n" +
            "gefcd fad bgfea cgfdea da fbecgd bdgafc dgbfcea cdae edagf | cgfbda gefdc cdea adf\n" +
            "fg efgb fga bdgea adbegf cfeadg fbdag abgdce bdaefcg afbcd | bgfe gebf afgdcbe dbegaf\n" +
            "cagbe dbca gcedfa cga dabfcge ac dgbace fbage cdgeb edcfbg | adfecbg cagedb abcd gbdce\n" +
            "eabdf efb be efcda cabgfd gedfab cdefabg eagb cfedgb gdfba | aebdfcg gecbfd efb efb\n" +
            "ecd fadce acgfd cdgfeb ec edbafg dfcaeb fcegabd abdef ebca | fdeac adcfe dfgeabc dfacbe\n" +
            "egcadbf fca cafbd dceba fa agcfbe fgcdba defgcb afdg cgdfb | gfbcd efdbgc af caf\n" +
            "beca ea fbdegca cafdbg ecagf fae bfgaed efagbc gbafc ecdgf | aegfc adbegcf ea ebgfca\n" +
            "bgacfed gbc fbdeac gc bgfae adcg ecbad begac dabcge gfcdbe | gcb bceagd agcd daebc\n" +
            "ba fgbcead gbaefd ebcfag dagcfe dfeag bdcfg adeb gadfb afb | deba eadb gbefda aecdfg\n" +
            "ab cgfdea dgcbfa aedgc agb efbcadg bagced gbdfe gabde aecb | aefbdgc bfdcag egbda agb\n" +
            "gfcd fecdb fdbeag dcb dgefb ecfab bdecfag bgdeac cd cfgbde | cbaef ecgdbf gdfbe cd\n" +
            "bae dgeabc fdgae aedfb be gfbcad dbecaf cbfda gfcedab cfeb | gfdea fdabc abfcegd gfaed\n" +
            "cegfd dcefba daefc agdcfe cgebfda fg edgcb dgf debgfa cgfa | cfegd debcfa gfd edgfc\n" +
            "dceabg bgcfae fb cfgeb bfc dfceg bcfdea dcfbaeg acebg gfab | aegbdfc bcefg egbac egbfc\n" +
            "ceadgfb cfgadb eagfb eagbcd gebcfa ge age eabdf bacfg gecf | abdef ecagdb bgfea adgbfec\n" +
            "gdcaf egc cebfa cfdaeg cgdfbe eg eagfc gaed fabgced dbcgfa | afgce dcafbeg eadg dgfac\n" +
            "cfdbe dfcgeab ab abgdcf ageb cba eadgc cgadef cdaeb deabcg | efagdc cadeb ab eabg\n" +
            "bgfaedc gcdfe gfbdc fbga cbaedg dcagb gbdcaf bf bfd dacfbe | cgaebd fdgce bf fbdeca\n" +
            "gdabcf acgbefd egafc cda adbe gbadec fgdecb ad cdegb edgca | ecagd ad dcebg gbced\n" +
            "afdebc ebgcfda fabge ecfgdb caefdg dcbg cb fgecd gbcef cfb | eagfb fedgc ebgfc cbfedg\n" +
            "eb fgcade debgfc ebc gadec dfacb ecadb aegb ebcdga dagcfbe | efacbdg cdbaf fdcegb cbdage\n" +
            "gdefac gbdefca aec ce fecagb bfcgda gcafd dceg aefdb cdeaf | cbfaedg cdefag cgdfa cegd\n" +
            "bdegaf fda da ceda edfacg efbacg agdcf bfdgc faecg cgebafd | fdcga daf afd cdgbf\n" +
            "gec fbdgc abdceg febgdc gbacfed decgf facgdb fcbe fadge ec | agdfe cegdf gadcbef cfedg\n" +
            "fbeag bgcea cg cabfed agebcd acgd cadeb cge bgedfc cgaebfd | dfgbce efcbad cge bdcae\n" +
            "gdaef gbafdc gafdce fcadg gedc efbgdca de dfe baefg bcfdae | abcdfe gaefd cgfade dfe\n" +
            "gbcdf gcfa bgdaf dagbe dcegfb bfedca afb cgebdaf fa bafdcg | af fbegadc aegbd gfac\n" +
            "dbgacef ceagfb cfbd ebfdga bd edb bcged aecdg bcgfe fdbceg | db gbeafc befgad dfbegc\n" +
            "bdf bfadeg dbfgeac degcf aebf cgfadb gfdeb bf gdeab bgcdae | fb bgdaec gcfed feba\n" +
            "bgdeaf gbafe cdfeag gecfba debca adgcebf dfe df fdgb efabd | bfdeagc gdbaef fgeabc acdeb\n" +
            "edfcga fdab df fcbead bcagefd dbcage fgebc dcaeb befdc dfe | afbd caedb ebdac cdagef\n" +
            "dcbeg bcag bdaec fcdbeg adcef dfgaeb gcbaed ba begacfd bea | febgdc dbceg agecdbf dbceg\n" +
            "agbc eafbd dgcefb afdbg gaf gdecfa dfgbc fbgcad defcgba ag | edcgfb fadbg dfaeb abefd\n" +
            "abfdcge fadcge gde dcfgb cdgafb gbefd eg fcdgeb ecbg faebd | cgfdb ge dbgafc cegb\n" +
            "ab fbcge fegdbc gab fegad gebaf bgacef ceab fcdbega bcafdg | dgfbac gfacbe gba ab\n" +
            "bed fdage bcafge afebd cdegba fabce fdecab bd dfcb aebfcgd | dbe dgbeafc adebcgf eabfd\n" +
            "cbfdeg gbafe egf bdfgea dfea abceg ef gbdfa daecgfb bdgafc | edaf fabdge ebgac fgaeb\n" +
            "dgba bdcgaf bcdfg bg cgdfe cgb afcdeb bdfcega bdfca gcbeaf | aefdcb dbga cgfed cdfge\n" +
            "gefda gfbed cgfdbea feb dbcgf bgecfd becd fgabec be dfgbac | fgeda agcbdf bdce be\n" +
            "bcfge ab cagbed bea acdeg gdab aecbg fcegbad bcefda adfcge | bgadce dcgea febcg aeb\n" +
            "dagc dcefg gfcdaeb da fgecdb bfeac ead dgfcae eacdf begfda | bdeagf cfedgab dcbgaef ead\n" +
            "dg eadcb fcgd eafgbd fcdgbe bfegc gecbd deg dgcbafe cfegba | ebcad gecfbd ebgcd gfcbeda\n" +
            "bc bgc edbcfg gbafd ecgbfa ebdc gdcaef dfbecag bgfdc egfdc | bgfda fcdgb cgeafb fcbgd\n" +
            "abgf dbfcgae adegf gdabe cbdeg ab bae dgecfa caefdb aedbgf | daefg fbag badfce gbdefac\n" +
            "cabed gabcdf eb cegad fabcgde ebd ebaf fcdeba badfc egdbcf | dbeac cdafb edbfacg eb\n" +
            "degfac adgcf fbgade fae ef egcabfd egacb decf efagc agbcdf | ef fcadeg edcf cgafdb\n" +
            "adcefg agbefcd acdfe cdfba ecfdbg ed eagfc aged edf cegbfa | fcdea gbafec efd fecdgb\n" +
            "dfeacb fge fbgca gfcbe dbeg eg cdefb fbedgc fdbcaeg adecgf | gef dbeg efg becfgd\n" +
            "ae fbdegc gfcdae fbgda fecabd gfecd gdafe edgfcab afe acge | facged adcgfe cgae bacdgef\n" +
            "gfbac cfebda dfg degfca dfgbc cbgdfe dg dcefb edagcbf gbed | caedgfb gdf gd ecgdbf\n" +
            "gcdfea dafbcg gadfc aecdbf cab ba gcbaf abdg cebfgad ecbgf | bca gcfad dcfbage efbcg\n" +
            "gbceaf baegd gab ga agcd gecdb deabgc afedb agebcdf fdbgec | cdgeb gab eagfbc aebdg\n" +
            "ebagcd dgacef gbc gdefcba cbeagf bfadc bedg acdeg bgcda bg | aegdbfc cbg fagecbd agfedc\n" +
            "fcbage dfbage acdebgf ed faed bafge fdegb dge bfdcg egcabd | deg dgfbc bgdefca abcgef\n" +
            "aeg acegd degb dagfcb fadec bgeafc bfagcde eg bdecag gbdac | acefd defca degb cgeabd\n" +
            "bfce fadeg fegdb cdgeb cfdabge bf acdfgb bfd edbcga cebgfd | begadc edfcbag dcefbg bgfed\n" +
            "gc gfac fegcd fedcagb gaedbc cafed edbfg gedafc fecadb gec | adcfe cgdeba egfdc cfedg\n" +
            "egcfb dbac beafcdg cbgea fdeabg gadecb cdgaef cga gadbe ca | dfcabeg cbdgea ca egbca\n" +
            "edgbc fdeb dcfegb cgeafdb dfcaeg gebfc daebcg bfagc fe fec | bgdefc ebdgc ebfd dgbec\n" +
            "bgacde abfgecd caedg ba ebfdc ecfadg bagc eba dbeac gdebfa | cdefag bafedg agbc bcfed\n" +
            "febacg fegda gdbacf ceab cfa cbfeg fgabcde cgaef dgefbc ac | gbcfe beca deafg eagbfcd\n" +
            "debg fgbade gecabf dfaeg fdaegbc gad eagbf fedac dfabcg dg | egbacfd cfead fegadb gd\n" +
            "agfeb cf gcead fgcea gfcdba edagfc bcadeg dfec fca cdfabeg | geacf fbage gdfacb cf\n" +
            "dbfae geacfd eabgc cebfga gd cbgd dfbaecg edbgac adgbe gda | dag gd caefgd gfdceab\n" +
            "edabcg dgaf cgbfe bcdfa efdabc edcfgba ga cag dbgfca gacfb | fdcbag gac ag bdaecg\n" +
            "bf efb efcabd gfba agebdfc deafcg afegd gfeadb gebcd gdbef | bfga bfeadc bcegd fbe\n" +
            "edfgbc fgdc cf bgecf dcaefb efagdcb gdecb bfage cfe dcgeab | dfcg ebgdc fgdc aecbgd\n" +
            "bdgea dgebf ebcdaf ebf fe fabcgd gcfe bgedcf ecgdfab bgfdc | egfc gbcdef bfe fdbcg\n" +
            "ca gdbaef adecg acdfbe cefadg caedbgf afedg eac afcg ecdbg | eadgf dgefab dgeac gadce\n" +
            "dfgecb adcf becfadg cgfdea gfdae dcgae fd dgcaeb dfe egbaf | efcdbg caedfg eacdg dgeafc\n" +
            "agcbe fba dfag fgbca cdagbef fgdcb gcefdb acfdeb af dcbgfa | dcbafe afbcg bfa cdbfg\n" +
            "cead ce dcefga fce afgedb cfebagd agfebc fecgd dafeg cbgfd | fedagb cgbaef egcfba gadfec\n" +
            "dfebga bcadge gdfebac ed beagf eabdf gbafce gdef bdfca ade | ade abcdf bagcde fabcd\n" +
            "adg fgdbce abfgcd ecdgaf cebgdaf gcbad ga bgaf fcbgd edbac | beacd dag fgdcb gda\n" +
            "dbeacf edfcbga bgcde edbac gbac dgb dcegf bcgdea gdafeb bg | cbdge bg cbag ebcda\n" +
            "gafcd dcae cd cgaef bfedcga gfdab cbgfea cdgebf dagcef gdc | afcdg gcd gafdb bgcdaef\n" +
            "edabfg gecfdb adcf abf cfgbade gbace bcfed af bface febdac | eadcbf efabgd fa fba\n" +
            "af eaf daebg fgebac dfaeg geadcfb cfad fedgc dcefgb fadcge | afdge ecgfabd fa fa\n" +
            "dcfga agfdbc db gcbefad baefg fdb gefadc dgabf fgcbde bcad | gdcfa adgbf fbd cgfdeb\n" +
            "cbega fgb agfceb dfbcage dbfca efga dbgefc bcagf bedcag fg | dafbc dbcfa fdbcge ebdgac\n" +
            "eac cbaeg ce acbfg daefcg abgfde bgdeca dbgaecf ebagd cbde | abcedfg cae gbdae ec\n" +
            "gadef daebgfc fge beagd fcebad cbfgde gf afced gfdace agfc | bedfcg geadb gdefbc gf\n" +
            "adbfcg cdbge cfeg beagdfc cbegfd bfdaeg eacbd eg fbgcd egd | ge gdcfab cgebd dacbe\n" +
            "ca cbega abcefdg bfcdea bgdcea abc dgac ebdag ecfbg aebfgd | adgebf debagc bgcae bca\n" +
            "bg edcbg gbd dabegfc dcgae aefdgc cbga dbaegf eadgcb dbefc | cbga cgab adcgeb bgca\n" +
            "egbdf becfga gdcae cdgef cf cdgfea faegcbd dacf cgadeb fcg | cdfge gcdabe befagc cgf\n" +
            "fbade ca eca eabcd cefbag ebacdf fdbaeg cdgbe facd dbagfce | fcbgdae dbace debfgca cbade\n" +
            "fbdceg fgade egfcd fbdacg dgcbf cbed gec ec dgbacef ecagfb | aegdf egdaf gecdf feagd\n" +
            "aef bacedf aedcg bfge efabcg fcbagd fe gfbac fegca abdfceg | cgafb agcfdb gbcafe acfge\n" +
            "bgfc defgbc cf deagf gbcdea baedcf ecfgd ebgdc dcagfeb cdf | fgaed fedcab cdefg dfega\n" +
            "afecbgd bgefca eca gbcaf cgfe bgcdfa bceadf ec cabeg dgabe | ce efbcagd aec fceg\n" +
            "gaeb eafcd dbeafg egf dbfag adfbcg bfcaedg aefgd eg decgfb | fegbda bgfecd adgfe gef\n" +
            "cgb baecd begdc cbdefa adbg ebafgc gcfbead cgfde bgdcea gb | cfedg ebdca adbg eabcd\n" +
            "egafc ac fecdg acfgdb aceb befgcad eadgfb fbgcea cga ebfga | daecbgf bcea fegba ac\n" +
            "afde cefbgda gabdfe cegdab feb bdgae dbcgfe fbgca eabfg fe | dgeba dgcbfe bafge gaecbfd\n" +
            "ceabgd ba cfbagde afdce dba ebcdg abcg fdaegb adbce defcgb | fdgbcea bacg dba agcb\n" +
            "gbcfed eag dceabgf eagfdc febgc bfag eagbcf abdec ag cgeba | gae aeg gfdbace gbfa\n" +
            "gb gbfeda cbead gebdcaf gbdf cgabef beg fgaed gdabe cfgeda | gdbf bgfeac bcead cdefag\n" +
            "bcda fabceg dfecg eadgbc dcgae dfabeg afdgebc dga ad cgbea | dbecag efagdb da fcbeag\n" +
            "gfcdae cf fabgd cdfabe gcdfa fecabgd gdeca fegc dacgeb caf | fegc fca cf aefdbc\n" +
            "efcgb decfga cfbga bfdca gcfbde ag eagb gfa bgcaef gcbfdea | ga egba bfecg gfdcbe\n" +
            "cabedf cedf ace bdace acdgb afgbec fgdeba ce fadbe afgedcb | aebfd ebdacf ace dcef\n" +
            "fecdg cgdfae gecbfa de cagdefb bfdgc egda gacfe ecd cdafbe | dcgbf fgaec facdeg gfcdb\n" +
            "gabfdec dabfge abdeg fa egcbda fdbgac adf efbad efcbd fage | gdabe bgade bfdega afd\n" +
            "cbgad fcabdg cbfdg cgfaed fdg bafg cdabge bfcde fg abfcdeg | bfdaecg cgadeb defcb gdfabc\n" +
            "defba fgae daegbf adfgbc bfadg fegacdb bef bedca ef fbgecd | befda bcegdfa ef badgf\n" +
            "fdgbea agfdcbe bgfeca dag da eacd dagcb becadg fgbdc acegb | ecda adbfeg bgedca cead\n" +
            "gafd cdbaef dbgcf gdeacbf fdacb bcdagf abgdce gd efgcb dbg | gd gbd egfbc gadf\n" +
            "de abdegf edgfb efd gcfedab dbgaf afcdbg aedb fegadc begfc | fde edf ecfgb edba\n" +
            "cbgefd da bdagcf cda cegfabd gfdcb dabcf cfgead dgba acbef | bdfcg bgcafde dbcfga bafdcg\n" +
            "aebfcg gfedabc eadgb bf cafgdb bfg fbce fgcea gcdfae gebaf | afgebc fb fb bgf\n" +
            "gc fgecbd egc gaebf gecbda acbed fcaebd cagd bcgae gfabdce | gacd egbacd abefg egfba\n" +
            "dcfab bgdc efagd acg gc aedcfb cdafg begcfad dabgcf cbefga | cdagf gcfda dbfac cdgb\n" +
            "bcdfea dgce cadfg dae agfde cgdeaf adfegcb bafge ed cdbfga | cgedaf bgfae gafdc fbgae\n" +
            "adgcfe dfagecb gfbcda ba cafegb fbdce eagb agefc cafbe cab | bcedf bac ba fbcde\n" +
            "bfeacd fcdebg fg dbaeg egdaf dcgfae gcfa efadc bcegdfa fge | acdef fgaed gf bdeag\n" +
            "dcgefa ceabfg fagbc beagd df fagcdeb dbafg fgabcd dcfb fgd | egafdc gabde beagd dfbc\n" +
            "ef bgdaefc cagdbe fbcda fgbade aef gfce eagbcf gcabe cfbea | fcdab fgce bcfad acebf\n" +
            "efagbc fbdag afdcb fg bgf begda aedfbcg deafgb gedf cdgbea | dfgab acfdb gf gf\n" +
            "edcagb ecfbadg ebdfg ega fbaedc fecdag ga dacef gfac gaedf | dgbfe ga dcafe ag\n" +
            "bedfacg acbfge cbg badfeg begfc fbcde ecag facdgb gbfea gc | fbced gcb eagc agebdfc\n" +
            "fdgca fbgce gfecd gdeb cdfagbe ed ecd fedacb gfabce dgfbec | afcgd deabfc dfagc begcfa\n" +
            "bfeg dge cgadf cgedf gedfbca cebfad dfebc cdabge cdgefb ge | dbcef ged eg ebfacd\n" +
            "ed cebgadf gefdca cfega dcaegb dfce cgaefb dge gbfda dfaeg | aegdf afgce egd deg\n" +
            "aecfgd fgd cedbag fgecd bfagdc feacbdg gceda gf bcdef eagf | dfbce agced gf geadc\n" +
            "gbcfdae fdgea bdgcae edb edgbfc fagdcb ebca be ebgda adgcb | be edb bed gcbaed\n" +
            "gdef df afdgcb fdb ebcgd begadfc gdcbef efbdc baegdc fabec | dgceab acbef fbedc cgbed\n" +
            "dcbgf feg edfacgb efgadc eg fdace afbced fcged eacg aefbdg | cbaedfg ecag aecfdb efdacg\n" +
            "fdbega gcebaf dacgeb eabdc gabcfde fcdea gcbd bd adb agbce | afced efabdcg afced bda\n" +
            "cd dafcbe adegcb edabfgc bdcga adfgb gabecf cdb egcd cbega | daegbfc afbdg cd debacg\n" +
            "bga becfdg gcbfad gcbdf ag baefcg eadbc dcgab fcgadeb afdg | gfbcead edgcbf gdcab bag\n" +
            "aedgfbc fe cgdaef fbec feg agecb bgadf bacefg afebg cgdeba | aebgcfd gfe aegbf efbcga\n" +
            "afcegd gbdec acd afcgbe ad cagfe gdcea fgbedac edaf dgbacf | cad dagec aecgdf da\n" +
            "gfedc eagcfd becagf cafed ace edbaf dgac feadbcg ca bfecdg | gdac gcadef ac eafdc\n" +
            "gab abfdeg bgdac fadbc gcdfba bfdeac bcfadeg bgfc bg gaedc | bg fcbad gb bg\n" +
            "bgeda agdfcb gdaec cd fcabedg cgabed fgcae bdefag dca cbde | adc baegd febdag eafgbd\n" +
            "gedbca dacbe efda bfd efdcba fd bfacd cgabf cbedfga bcefgd | bafcg baecd fecbgd cagfb\n" +
            "egdc fed ed bgfced bfacd ebagcdf dbefc ebgdfa agbefc cfgeb | bfegcd cfebd agdcbef cafdb\n" +
            "bdg bdfga gdfca dfbae gbafcd fbgc eacbdg aegfcd bg dgceafb | gb bgd gfacde gbcf\n" +
            "egdbc badfec caebg cegdab ed bcdfg aedg afdcegb gfaceb bde | agde adge de egda\n" +
            "adef gdcfba adgbecf af acegb fab bfadeg bfega dbgfec efdbg | bcgea fdcegb degfcb fbedag\n" +
            "gbfe bcdgaf edfag gae gfdeba cfdbeag fgdba gebcad ge cdfea | cgfadbe bgef agcbed cgdfab\n" +
            "dfeca cdbg edafbg gcfbead bcafg cfgadb fgd bfgace dg cgadf | gfcda bgfadc cbgefa gfd\n" +
            "fbaecd bf dacfebg dcfge ecbgf gabf cegfab caebg bfc gdbace | abcge cegab egfdabc dcfeg\n" +
            "cbdfag fgbec gdabfe gfdbaec bdgfc ef fbcdge fbe agceb fced | gbfdc fe cegab cgebf\n" +
            "fdebc adfgcbe acebf fdac df dfb bdaegf abecdf abcegf bgedc | gbcefa ecbgd bafec dbecg\n" +
            "fadc fgc gbcdf bcdga edgfb cegbaf fgbdca fc debgca dafcgeb | dfcbag cabdg fbcgd afcd\n" +
            "dgcef dcgbef afc adfce feagbdc ac deafb cdag gcdfea befagc | ca cfegdab efcda fdeca\n" +
            "febgad ag gdeab afdbecg dcgfbe agfbec fbegd gfad aeg dcaeb | ebgdf abedc dgaf dfbge\n" +
            "daegcb agbcd edg bafdgc faecg gadec bfcgde abde ed fecagdb | baegcd edba efgac cefag\n" +
            "adbcf gcaf bgdac gecdfba efdba fdbcga fecgbd cfd cf adgceb | dcbag abdfc fcd fcd\n" +
            "cfedb cfa acefbd afbdcg edcbafg bfeag acebf ac ecdbgf adec | fedcb edcfbg bfaec gecfabd\n" +
            "cef befdcg dafeb cefdag fbdaceg fadec fc agced bdgace acfg | agcde daefc afcg cgaf\n" +
            "ebagd gd gfdbace fagbde febad gfdb dcebfa dcefag edg gcbea | dageb dg gde gd\n" +
            "de gdecfb baefg fedbg ecdf bacdgf bgfdaec dge acdegb cgdfb | dagfcb dcfe ed de\n" +
            "adgfc ad dcea caefgd cgfdb bfaegc afgec egafdb fegbdca fda | da gfedab ad afd\n" +
            "abf cdgfae acfbg gecbadf ecba efabdg cabgfe gbcfd efagc ab | acgbf fegacd acegf abf\n" +
            "cgbaefd cdage dgef geacdf agfdcb dacfg gcaeb cdefba ed ead | abfgdc abdgfc dagcfeb baceg\n" +
            "fgdec cbfa bf gbcfeda dfb fadbge acdeb dbfce cgbdea cdefab | cfegd fdeabc badecfg dgcfe\n" +
            "eba dacgefb deacb gabfde ecgadb cbdef cage gcbad afbdcg ae | gdfeba ae dfbec agce\n" +
            "daebc gcdeabf bgcfea agfeb bdega dgbeaf dgfa gdb gd bfcged | febdcg egfdcb bdace gdfa\n" +
            "gcbaef fdgbea adgfce bgefacd fdbg egdab daecb gbe bg gfdea | fbdg dfbg aefdg bdfg\n" +
            "dbgfce ec faebg fec fagdc cefga fgecda ebfgcad cdae dgbcfa | cadgf dgbeafc cgeafd ec\n" +
            "gabcef edacbfg dba agecb bdce dacgbf dgcaeb eafdg gadbe bd | dfgea db adb cbdgaf\n" +
            "cbfdgea fbdgca bedagf ae dae bfedca dacfb feca bcged adceb | ea ae fcea ead\n" +
            "daebgc db bagecdf bdaec fgdbea dfeac bgfeca cgdb bed gbaec | dfecbag ebacd bed db\n" +
            "agdcef fdaeg fbcdaeg cbgdae afgbd fea cfde eagcfb gdace ef | bgecda afe defc daegf\n" +
            "dcaegbf fdgeba ad dbafe defbc faebg dacfbg daf egda cfaegb | abedf bfdaeg dbfgea cfagbed\n" +
            "geb bgafecd bcae fgabce aefcg be gadfec gfebc bgdfc gbfeda | ebac be fgace dfebagc\n" +
            "cdfegba eafdc afcgb abcfge bfgd cfagbd adg dcafg cebdga gd | adbecfg cfagb dabgce cafbg\n" +
            "geaf fg acbgd fgd dgfcbae dbaef fgbda ebgdfa egfcbd acefbd | gcdba edfbgc ebcadf gf\n" +
            "cbgfe egac ce ecf bgfeca cbdgf fgbdea fbgceda geafb eafdcb | gecbaf adebcf efc ecf\n" +
            "fcd gfbcd dfbge dc gcbefad dcag afebdc gfbac efabgc fadbcg | bgdfc bcfga bfgdc cd\n" +
            "dg dgeb acedbg bdfagc faceg cfagdbe ebadc daceg afbdce cdg | gdaec afgec gcd eacdb\n" +
            "badeg dfegab efgadcb ad fgcdbe egbdf gcdeaf gad dafb bgcea | dgaeb bgdfe agdbe fbaged\n" +
            "deag ea gabedcf decfb dcfea fcdgae fgcda dgcfab cegabf fae | dcagfbe gafcde fedbc fdbacg\n" +
            "eacfg bged cgdafb dg cegad dgcbea bceadf adg gbdfcea baedc | bcfadg gcfae gbed eabdgc\n" +
            "efdba cegafb bcgdfae gdabe cefbd aef af ebgcdf ebdcfa facd | fdabec gfbeca fea adfc\n" +
            "ab fdeba cgefbd fdgae bea fbdce bdafce egfacb ecbdagf dabc | eba gdafe bdaef gfbeca\n" +
            "feadcb dgfabec gdafb cb ebgc fdcgbe cagefd dfgcb fgedc bcd | gfcde gdcfb fgbced decbfa\n" +
            "fabcde cae ecbfga agbed fbacg cegf cgdabef dbagfc ce acbeg | gbdea gcebfa fdeabc baceg\n" +
            "gfebca cageb dbfcaeg ed aecd edg bdegca ebgafd fcbgd gbdec | fbacge dcebg acde edca\n" +
            "bfgedca ec gacfd gcafbe decb cef gdafeb afebdc efadc dfbea | bdec cfeabd cagfd feadc\n";
}
