package nl.ITAcademy.project.LINGO;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class WoordenChecker {

    private String word = "";

    public void setWord(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void pickRandomWord(){
            Random random = new Random();
            int i = random.nextInt(wordList.length);
            word = wordList[i];
        }


    public boolean isValidWord(String input) {
        for (String word : wordList) {
            if (word.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public String[] checkInput(String input){
        char[] inputChars = input.toLowerCase().toCharArray();
        char[] wordChars = word.toCharArray();

        String[] output = new String[5];

        if (input.equals(word)){
            for (int i=0; i < 5; i++){
                output[i] = "right";
            }
            return output;
        }

        for (int i=0; i<word.length(); i++){
            if (inputChars[i] == wordChars[i]) {
                output[i] = "right";
                inputChars[i] = '8';
                wordChars[i] = '9';
            }
        }

        int i = 0;
        for (char c : inputChars) {
            for (char d : wordChars) {
                if (c == d) {
                    output[i] = "wrong";
                    inputChars[i] = '8';
                    int j = 0;
                    for (char e : wordChars) {
                        if (e == d) {
                            wordChars[j] = '9';
                        }
                        j++;
                    }
                }
            }
            i++;
        }
        return output;
    }

    private String[] wordList = new String[]{"aagje", "aaien", "aapje", "aarde", "aards", "aasje", "abaja", "abces", "abdij", "abdis", "abeel", "abuis", "acces", "acryl", "actie", "actor", "acuut", "addax", "adder", "adept", "adieu", "adios", "adres", "adult", "afbod", "afdak", "affix", "afgod", "afijn", "afrit", "afval", "afwas", "afzet", "agaat", "agame", "agape", "agave", "agens", "agent", "agger", "agoge", "agoog", "ahorn", "aioli", "airco", "ajour", "ajuin", "ajuus", "akant", "akela", "akker", "aktes", "alaaf", "alaam", "alant", "alarm", "album", "aldra", "aldus", "aleer", "alert", "alias", "alibi", "allee", "alles", "almee", "aloud", "alras", "alree", "alsem", "alsnu", "alsof", "alter", "aluin", "alver", "amant", "amber", "amice", "amict", "amigo", "amine", "amorf", "ampel", "amper", "ampex", "ampul", "amsoi", "amuse", "anaal", "ander", "angel", "angst", "anijs", "anima", "anime", "animo", "anion", "anita", "anjer", "anker", "annex", "anode", "aorta", "apart", "apert", "apneu", "appel", "april", "apsis", "arena", "arend", "argon", "argot", "argus", "aride", "ariër", "armee", "armoe", "aroma", "aroom", "array", "arren", "asbak", "asgat", "asiel", "askar", "asman", "aspic", "aspot", "assem", "assen", "aster", "astma", "aston", "asurn", "atjar", "atlas", "atoom", "audit", "avers", "aviso", "avond", "awara", "awari", "azijn", "azuki", "azuur", "baard", "baars", "baboe", "babok", "bacil", "bacon", "baden", "bader", "badge", "bagel", "baggy", "bagno", "bahai", "bahco", "bajes", "baken", "baker", "bakra", "bakte", "balen", "balie", "balsa", "balts", "bamba", "bamis", "bande", "banen", "banjo", "barak", "baren", "baret", "barok", "baron", "barre", "barst", "basen", "basis", "basta", "batch", "baten", "batig", "batik", "baton", "bavet", "bazen", "bazig", "bazin", "beaat", "bebop", "beeld", "beemd", "beest", "begin", "begon", "beide", "beier", "beige", "beits", "bejag", "bekaf", "beker", "beleg", "belet", "belle", "bende", "benen", "benig", "benul", "berde", "beren", "berge", "beril", "berin", "berst", "besef", "besje", "beste", "betel", "beten", "beter", "beton", "beurs", "beurt", "bevak", "beval", "bevek", "bevel", "beven", "bever", "bezem", "bezet", "bezie", "bezig", "bezit", "beërf", "bidet", "bidon", "biels", "biest", "biets", "bigot", "bijas", "bijna", "bijou", "biker", "bilan", "bingo", "binst", "biopt", "bisam", "bitch", "bivak", "bizar", "bizon", "blaag", "blaam", "blaar", "blaas", "blank", "blauw", "bleef", "bleek", "blees", "blein", "bliek", "bliep", "blies", "blijf", "blijk", "blind", "blink", "blits", "blode", "bloed", "bloei", "bloem", "bloes", "blond", "blonk", "bloot", "blues", "bluts", "board", "bobby", "bocht", "bodem", "boden", "bodes", "boede", "boers", "boert", "boete", "bogen", "bogey", "bogie", "bokje", "bolle", "bolus", "bomen", "bomer", "bomig", "bomma", "bompa", "bongo", "bonje", "bonus", "bonze", "boord", "boort", "boost", "boots", "borat", "borax", "boren", "borst", "bosje", "boson", "bosui", "botaf", "botel", "boten", "boter", "botje", "botox", "botte", "boven", "bowls", "boxen", "boxer", "bozig", "braaf", "braai", "braak", "braam", "brabo", "brand", "brasa", "bravo", "break", "breed", "breek", "brein", "brems", "breuk", "breve", "brief", "bries", "briet", "brijn", "brink", "brits", "broed", "broei", "broek", "broer", "broes", "broge", "brons", "brood", "broom", "broos", "broze", "bruid", "bruin", "bruis", "bruto", "bruut", "buddy", "bugel", "buggy", "buien", "buiig", "bunny", "buren", "buret", "burin", "busbo", "busje", "buste", "buten", "buurt", "buxus", "bühne", "caban", "cacao", "cache", "cadet", "cajun", "camee", "camel", "cameo", "campy", "canon", "canto", "caret", "carga", "cargo", "casco", "casus", "cauda", "cavia", "cedel", "ceder", "cello", "chant", "chaos", "chape", "check", "chick", "chijl", "chili", "chimp", "chips", "choco", "choke", "cider", "cijns", "circa", "citer", "civet", "claim", "clark", "claus", "clean", "click", "clips", "close", "clown", "coach", "cobra", "cocon", "codec", "codex", "cokes", "colli", "collo", "combi", "combo", "conga", "conto", "conus", "corgi", "corps", "corso", "coupe", "cover", "crack", "crank", "crash", "crawl", "crazy", "credo", "crime", "cross", "crypt", "crème", "crêpe", "cumul", "curie", "curry", "curve", "cyaan", "cyste", "daags", "dacht", "dadel", "dader", "dagen", "dager", "dagge", "dagje", "daken", "dalem", "dalen", "daler", "damar", "dames", "dandy", "danig", "dansi", "darts", "daten", "datje", "datum", "daver", "davit", "dawet", "dazen", "debat", "debet", "decor", "deden", "deels", "deern", "degel", "degen", "deken", "delen", "deler", "delta", "demon", "denim", "denke", "depot", "depri", "derby", "derde", "deren", "derny", "desem", "detox", "deuce", "deugd", "dezen", "dezer", "dezes", "dicht", "dieet", "diens", "diepe", "diets", "dijen", "dikte", "dildo", "dille", "dinar", "diner", "dingo", "diode", "disco", "divan", "dixit", "dizzy", "docht", "doden", "doder", "dogla", "dogma", "doken", "dolby", "dolce", "dolen", "doler", "dolik", "dolle", "dolly", "dombo", "domen", "domig", "domme", "donna", "donor", "donut", "doods", "dooie", "doorn", "dopen", "doper", "doren", "dorps", "dorst", "dosis", "doven", "dover", "dovig", "draad", "draai", "draak", "drain", "drama", "drang", "drank", "dreef", "dreun", "dries", "drift", "drink", "drive", "droef", "droeg", "droes", "droge", "drong", "dronk", "droog", "droom", "droop", "drops", "drost", "drugs", "druif", "druil", "drums", "druus", "duaal", "duist", "dulia", "dummy", "dunne", "dunte", "duren", "dutje", "duvel", "duwen", "duwer", "dwaal", "dwaas", "dwang", "dwars", "dwaze", "dweil", "dwerg", "ebben", "ebola", "echec", "echel", "edele", "edict", "edoch", "educt", "eerst", "effen", "egaal", "egard", "eggen", "eggig", "eiber", "eicel", "eider", "eigen", "eikel", "eiken", "eiker", "einde", "einze", "eisen", "eiser", "eitje", "eivol", "eiwit", "eland", "elfde", "elfen", "elven", "elite", "ellen", "elpee", "elpen", "elzen", "email", "emelt", "emmer", "emmes", "enfin", "engel", "engte", "enige", "enkel", "enorm", "enten", "enter", "enzym", "epiek", "eraan", "erbij", "erger", "ergon", "ergst", "erica", "erker", "ermee", "ernst", "ertoe", "eruit", "ervan", "erven", "espen", "essay", "essen", "ester", "etage", "ether", "ethos", "ethyl", "etsen", "etser", "etter", "etude", "etuis", "euvel", "euzie", "evers", "exact", "exces", "exoot", "expat", "extra", "fabel", "facet", "facie", "facit", "facta", "fagot", "faire", "faken", "fakir", "falen", "falie", "farad", "farao", "farce", "farde", "fasen", "fases", "fatum", "fatwa", "fauna", "faxen", "feces", "feeks", "feest", "femel", "fenol", "ferry", "fiber", "fiche", "fichu", "ficus", "fielt", "fiets", "fijne", "filet", "fiool", "firma", "fitis", "fjord", "flair", "flank", "flard", "flash", "flauw", "fleer", "flens", "flets", "fleur", "flink", "flirt", "flits", "floep", "floer", "floot", "flora", "floss", "fluim", "fluit", "fluks", "fluor", "flyer", "flûte", "fobie", "focus", "foert", "folie", "folio", "folky", "fonds", "forel", "forma", "forte", "forto", "forum", "fossa", "foton", "foyer", "fraai", "frame", "franc", "frank", "frase", "frats", "freak", "frees", "freon", "fries", "friet", "frigo", "frons", "front", "fruit", "frust", "frêle", "fundi", "funky", "furie", "fusee", "fusie", "futon", "fylum", "fysio", "gaard", "gabbe", "gaden", "gaffe", "gagel", "gaine", "gajes", "galei", "galon", "galop", "gamba", "gamel", "gamen", "gamer", "gamma", "gapen", "gaper", "garde", "garen", "garoe", "garve", "gaten", "gauss", "gaven", "gazel", "gazen", "gazet", "gazon", "gebak", "gebal", "gebbe", "gebed", "gebel", "gebit", "gebod", "gedag", "gedoe", "geduw", "geest", "geeuw", "gegil", "gehol", "geien", "gejij", "gejou", "gekef", "gekir", "gekko", "gekte", "gelag", "gelal", "gelee", "gelei", "gelen", "gelid", "gelig", "gelik", "gelui", "geluk", "gelul", "geluw", "gemak", "gemet", "gemis", "gemok", "gemor", "gemot", "genet", "genie", "genot", "genre", "genus", "geoha", "gepuf", "geram", "gerei", "geren", "gerij", "gerst", "gesar", "gesco", "gesel", "gesis", "gesol", "geste", "getal", "getij", "getik", "getob", "getto", "geuze", "geval", "gevat", "gevel", "geven", "gever", "gewag", "gewas", "gewei", "gewin", "gewis", "gezag", "gezel", "gezet", "gezin", "gibus", "gigue", "gilde", "gilet", "ginds", "ginst", "gipsy", "giraf", "glace", "glans", "gleed", "gleis", "gleuf", "glimp", "globe", "gloed", "gloop", "gloor", "gneis", "gnoom", "goden", "godin", "goede", "gogme", "gojim", "golem", "gomma", "gonje", "gorig", "gouwe", "gozer", "graad", "graaf", "graag", "graai", "graal", "graan", "graat", "grauw", "green", "greep", "grein", "grens", "grief", "griek", "griel", "griep", "gries", "griet", "grift", "grijn", "grijp", "grijs", "grill", "grime", "grind", "grint", "griot", "groef", "groei", "groen", "groep", "groet", "grond", "groot", "grote", "gruis", "guano", "guave", "gummi", "gunst", "guppy", "gyros", "haagt", "haaks", "haard", "haast", "hadji", "hagel", "hagen", "haiku", "haken", "haker", "hakje", "halal", "halen", "haler", "hallo", "halma", "halte", "halve", "hamam", "hamas", "hamei", "hamel", "hamer", "hands", "hanig", "hapax", "hapje", "happy", "haram", "harem", "haren", "harig", "harre", "harst", "haten", "hater", "haven", "haver", "havik", "hazen", "heavy", "hecht", "heden", "heeft", "heffe", "hegge", "heide", "heien", "heier", "heiig", "heila", "heisa", "hekel", "helen", "heler", "helft", "helix", "hemel", "henen", "henna", "henry", "herig", "herik", "heros", "hertz", "hesen", "heten", "hetze", "hevea", "hevel", "hevig", "hiaat", "hield", "hielp", "hieuw", "hihat", "hiken", "hinde", "hints", "hitte", "hobby", "hoede", "hoeks", "hoela", "hoera", "hoeri", "hoest", "hoeve", "hoezo", "hofje", "hogen", "hoger", "holen", "holst", "holte", "honds", "honen", "honig", "hoofd", "hoofs", "hoorn", "hopen", "hopje", "hopla", "hoppe", "hopsa", "horde", "horen", "horig", "horst", "hotel", "house", "hoven", "hozen", "https", "hulde", "hulst", "humor", "humus", "huren", "husky", "huwen", "hydra", "hyena", "hymen", "hymne", "hypen", "hyper", "hysop", "icing", "icoon", "idool", "iebel", "ieder", "iepen", "ijdel", "ijken", "ijker", "ijlen", "ijsco", "ijsje", "ijver", "ijzel", "ijzen", "ijzer", "ijzig", "image", "imago", "imker", "immer", "inbox", "index", "indom", "ineen", "inert", "infra", "inham", "inkom", "inlas", "inleg", "innen", "innig", "input", "inren", "inrit", "intro", "inval", "inwit", "inzet", "ionen", "ippon", "islam", "issue", "ivoor", "jaars", "jabot", "jacht", "jaden", "jagen", "jager", "jajem", "jalap", "jalon", "jambe", "janet", "janus", "japen", "japon", "jarig", "jatte", "javel", "jawel", "jazzy", "jeans", "jelui", "jemig", "jeton", "jeugd", "jicht", "jihad", "jijen", "jingo", "joego", "jofel", "joint", "joken", "joker", "jolen", "jolig", "jonas", "jonge", "joods", "jouen", "joule", "jouwe", "jozef", "jubee", "jubel", "judas", "juist", "jumbo", "junta", "juten", "kaard", "kaars", "kaart", "kaats", "kabas", "kabel", "kadee", "kaden", "kader", "kadet", "kaffa", "kafir", "kajak", "kakel", "kaken", "kaker", "kalen", "kalig", "kalis", "kalle", "kalot", "kamen", "kamer", "kamig", "kanen", "kanis", "kanji", "kanon", "kapel", "kapen", "kaper", "kapje", "kapok", "kapot", "kappa", "karaf", "karen", "karet", "karig", "karma", "karos", "karot", "karst", "kasba", "kassa", "kaste", "kater", "katje", "kauri", "kavel", "kawai", "kazak", "kazen", "kazer", "kebab", "kebon", "kefir", "kegel", "kegge", "keken", "keker", "kelen", "kelim", "kemel", "kenau", "kendo", "kenen", "kepen", "keper", "kepie", "kerel", "keren", "kerks", "kerst", "ketel", "keten", "ketje", "keurs", "keuze", "kevel", "keven", "kever", "kevie", "kezen", "kidde", "kieuw", "kille", "kilte", "kimme", "kinds", "kinky", "kiosk", "klaaf", "klaar", "klaas", "klamp", "klank", "klant", "klare", "klats", "klauw", "kleed", "kleef", "klein", "klerk", "klets", "kleun", "kleur", "kliek", "klier", "kliko", "kling", "klink", "kloef", "kloek", "kloet", "klojo", "klomp", "klonk", "klont", "kloof", "klooi", "kloon", "kloot", "klote", "klove", "kluft", "kluif", "kluis", "kluit", "kluns", "kluts", "kluut", "knaak", "knaap", "knauw", "kneep", "kneus", "knier", "knijp", "knoei", "knoet", "knook", "knoop", "knorf", "knots", "koala", "kobbe", "kocht", "kodak", "kodde", "koers", "koest", "koets", "kogel", "kogge", "koine", "koken", "koker", "koket", "kokos", "kolen", "kolom", "kolos", "komaf", "komen", "komma", "komst", "koord", "kopal", "kopen", "koper", "kopie", "kopij", "kopra", "koran", "koren", "korps", "korre", "korst", "koste", "koten", "koter", "koude", "kovel", "kozak", "kozen", "kraag", "kraai", "kraak", "kraal", "kraam", "kraan", "krach", "kramp", "krank", "krans", "krant", "krapa", "krats", "krauw", "kreeg", "kreek", "krees", "kreet", "kreng", "krent", "kreuk", "kriek", "kriel", "krijg", "krijn", "krijs", "krijt", "krill", "krimi", "krimp", "kring", "kroeg", "kroep", "kroes", "krols", "kromp", "kroon", "kroop", "kroos", "kroot", "kruid", "kruif", "kruik", "kruim", "kruin", "kruis", "kruit", "kubbe", "kubus", "kudde", "kuier", "kuise", "kuist", "kulas", "kunde", "kunst", "kuras", "kuren", "kwaad", "kwaal", "kwade", "kwant", "kwark", "kwart", "kwast", "kwats", "kweek", "kween", "kwelm", "kwets", "kwiek", "kwijl", "kwijt", "kwint", "kwips", "laaie", "laars", "label", "laden", "lader", "lagen", "lager", "lakei", "laken", "lamel", "lamet", "lamme", "lands", "lange", "langs", "lapel", "laren", "large", "largo", "larie", "larve", "laser", "lasso", "laste", "latei", "laten", "later", "latex", "latuw", "lavas", "laven", "lavet", "lazen", "lazer", "lease", "lebbe", "leden", "leder", "ledig", "leers", "leest", "leeuw", "legen", "leger", "leges", "legio", "leien", "leken", "lelie", "lemen", "lemma", "lende", "lenen", "lener", "lenig", "lente", "lento", "lenze", "lepel", "lepra", "leren", "lesbo", "leste", "leute", "leuze", "level", "leven", "lever", "lezen", "lezer", "liaan", "liane", "libel", "licht", "lieve", "lijst", "liman", "limbo", "limes", "limit", "linde", "linie", "links", "linze", "lipje", "liter", "litho", "lobby", "locus", "loden", "loens", "logee", "logen", "logos", "loipe", "loken", "loket", "lokus", "lolly", "lomig", "lonen", "loods", "loops", "lopen", "loper", "lorre", "loser", "losse", "loten", "lotje", "lotto", "lotus", "loven", "lover", "lozen", "lucht", "luide", "luien", "luier", "lullo", "lumen", "lumme", "lunch", "lunet", "lupus", "lutje", "luwen", "luwte", "lycra", "lymfe", "lysol", "maagd", "maand", "maart", "maats", "macho", "macht", "macro", "madam", "mager", "maggi", "magie", "magma", "magot", "majem", "major", "makam", "maken", "maker", "makke", "malen", "maler", "malie", "malta", "malus", "malve", "mamba", "mamma", "manco", "mande", "manen", "maner", "manga", "mango", "manie", "manna", "manou", "maren", "marge", "markt", "marot", "maske", "massa", "match", "maten", "mater", "matig", "matje", "matse", "mauve", "mazen", "media", "medio", "medoc", "meent", "meers", "meest", "meeuw", "meien", "meier", "mekka", "melde", "melen", "melig", "melis", "meluw", "memel", "menen", "menie", "menig", "mensa", "merci", "merel", "meren", "meson", "meten", "meter", "metro", "meute", "mezzo", "miauw", "micro", "mijne", "mijns", "mikwa", "mikwe", "milde", "mille", "mimen", "mimer", "minne", "minor", "minst", "minus", "mirre", "mirte", "mixed", "mixen", "mixer", "mixes", "mocht", "model", "modem", "modus", "moede", "moeke", "moest", "mogen", "mogol", "moker", "mokka", "molen", "molik", "monde", "moois", "moord", "morel", "moren", "mores", "morse", "motel", "motet", "motie", "motor", "motse", "motte", "motto", "moven", "mufte", "mulat", "mungo", "musea", "muzak", "mythe", "mêlee", "naakt", "naald", "naast", "nabij", "nabob", "nacht", "nadar", "nadat", "nader", "nadir", "nafta", "nagel", "naken", "nakie", "namen", "nanny", "nappa", "natie", "natte", "navel", "nawee", "nazin", "naief", "nebbe", "neder", "negen", "neger", "negge", "negus", "nemen", "nemer", "nepen", "neren", "nerts", "nesse", "netel", "neten", "netto", "nevel", "neven", "niche", "nicht", "niets", "nieuw", "nihil", "nikab", "nimby", "nipje", "nobel", "noden", "nodig", "noest", "nogal", "nolle", "nomen", "nonet", "nonna", "nooit", "noord", "nopen", "noren", "noria", "noten", "notie", "novum", "nozem", "nulde", "nurks", "nurse", "nylon", "oasis", "oblie", "obool", "octet", "odeur", "odium", "oehoe", "oempa", "oenig", "oeros", "oever", "offer", "ofwel", "ogief", "ohaën", "ohmse", "ojief", "okapi", "oksel", "olijf", "olijk", "oliën", "olmen", "omber", "omdat", "omega", "omina", "omkat", "omrit", "omver", "omweg", "omzeg", "omzet", "onder", "oneer", "ongel", "onkel", "onmin", "onnet", "onnut", "ontij", "onwel", "onwil", "onwis", "onzen", "onzer", "onzes", "onzin", "oogje", "oogst", "ootje", "opaak", "opaal", "opart", "opbod", "opdat", "opeen", "opera", "ophef", "opium", "opleg", "oppas", "opper", "opril", "oprit", "optie", "opzeg", "opzet", "opzij", "oraal", "order", "orgel", "orgie", "oribi", "otium", "otter", "ouder", "oudje", "ounce", "ouwel", "ovaal", "oxide", "paaps", "paard", "paars", "paart", "pacen", "pacht", "paddo", "paddy", "paden", "padie", "pager", "pages", "pakje", "palen", "palet", "palts", "pampa", "panda", "panel", "panen", "pangi", "panna", "panne", "panty", "paper", "papil", "papje", "pappa", "parel", "paren", "paret", "paria", "parka", "party", "parwa", "pasar", "pasja", "pasje", "passe", "pasta", "patat", "patch", "pater", "patio", "pauze", "pedel", "pedis", "peeën", "pegel", "peies", "pekel", "pelen", "peluw", "penis", "penny", "peper", "peren", "pesto", "peter", "pezen", "pezig", "piano", "piepa", "pijne", "piket", "pikol", "pilav", "pinas", "pinda", "pingo", "pioen", "pipet", "piste", "pitje", "pitte", "pixel", "pizza", "piëta", "plaag", "plaat", "plaid", "plane", "plank", "plano", "plant", "plebs", "pleet", "plein", "pleit", "plemp", "plens", "plint", "ploeg", "plomp", "plons", "plooi", "ploos", "ploot", "plots", "pluim", "pluis", "plurk", "poeha", "poema", "poets", "pogen", "poger", "poken", "poker", "polak", "polio", "polis", "polka", "ponem", "poort", "popel", "porem", "porie", "porno", "porto", "porum", "poses", "potas", "poten", "poter", "potig", "potje", "poule", "pover", "power", "pozen", "poëem", "poëet", "poëma", "praal", "praam", "praat", "prang", "prauw", "preek", "prent", "priel", "priem", "prijs", "prima", "prime", "primo", "prins", "print", "prion", "prior", "prive", "proef", "promo", "pronk", "pront", "prooi", "prove", "provo", "proxy", "proza", "pruik", "pruim", "prune", "pruts", "psalm", "puber", "pubis", "puist", "punch", "pupil", "puppy", "puree", "puren", "putse", "putto", "pylon", "quant", "quark", "quasi", "query", "queue", "quilt", "quota", "quote", "rabat", "rabbi", "racen", "racer", "radar", "raden", "rader", "radio", "radix", "radja", "radon", "rafel", "ragen", "rakel", "raken", "raket", "rally", "rambo", "ramee", "ramen", "ramin", "ramsj", "ranch", "range", "ranja", "rapen", "rappe", "rapte", "rasta", "ratel", "ratio", "raven", "rayon", "razen", "reaal", "ready", "realo", "rebbe", "rebel", "rebus", "reces", "recht", "recto", "reden", "reder", "reeds", "reeks", "reeuw", "regel", "regen", "regie", "regio", "reien", "reiki", "reine", "rekel", "reken", "rekke", "relax", "remix", "renen", "renet", "rente", "repel", "repen", "repro", "resem", "reset", "reten", "retor", "retro", "reuma", "reuze", "reven", "revue", "rezen", "reëel", "reële", "riant", "ribbe", "ribes", "rijen", "rijer", "rijke", "rijst", "rioja", "riool", "risee", "ritme", "ritus", "rivet", "riyal", "robot", "roden", "rodeo", "roede", "roest", "rogge", "roken", "roker", "roman", "romen", "romer", "romig", "ronde", "rondo", "rooie", "rooms", "ropij", "rotan", "roten", "rotje", "rotor", "rotte", "rouge", "route", "roven", "rover", "rowan", "rozen", "rozet", "rozig", "ruche", "rugby", "ruide", "ruien", "rumba", "ruste", "ruwen", "ruwte", "ruzie", "ruine", "rösti", "sabel", "sabra", "sagen", "sajet", "salam", "saldi", "saldo", "salet", "salie", "salmi", "salon", "salsa", "salto", "salut", "salvo", "samba", "sambo", "samen", "saoto", "sappe", "sarin", "satan", "sater", "sauna", "saven", "scala", "scalp", "scene", "schab", "schap", "schar", "schat", "schee", "scheg", "schei", "schel", "schep", "schik", "schil", "schim", "schip", "schok", "schol", "schop", "schor", "schot", "schub", "schut", "schuw", "scone", "scoop", "scope", "score", "scout", "scrip", "scrub", "scrum", "scène", "sedan", "seder", "sekse", "sekte", "sepia", "sepot", "seraf", "sereh", "serge", "serie", "serre", "serum", "serve", "servo", "sesam", "señor", "sfeer", "sfinx", "shawl", "sheet", "shell", "shift", "shirt", "shock", "shogi", "short", "shoyu", "shunt", "sibbe", "sicav", "siena", "sifon", "sigma", "silex", "sinas", "sinds", "sinjo", "sinus", "sirih", "sisal", "siste", "sitar", "sjaal", "sjahs", "sjako", "sjans", "sjees", "sjeik", "sjerp", "sjoel", "sjouw", "skaat", "skald", "skeet", "skiet", "skiff", "skiën", "skiër", "skunk", "slaaf", "slaak", "slaan", "slaap", "slang", "slank", "slash", "slede", "sleep", "sleet", "slemp", "slenk", "sleuf", "sleur", "slice", "sliep", "slier", "sliet", "slijk", "slijm", "slijp", "sloef", "sloeg", "sloep", "slome", "slomp", "slonk", "slons", "sloof", "sloom", "sloop", "sloor", "sloot", "slorp", "sluif", "sluik", "sluis", "sluit", "slump", "slurf", "slurp", "sluwe", "slöjd", "smaad", "smaak", "smack", "small", "smalt", "smart", "smash", "smeer", "smeet", "smelt", "smeue", "smoel", "smoes", "smolt", "smook", "smoor", "smous", "smout", "smurf", "snaai", "snaak", "snaar", "snack", "snars", "snauw", "snede", "sneed", "sneep", "sneer", "snees", "snert", "sneue", "snode", "snoei", "snoek", "snoep", "snoer", "snoes", "snoet", "snoge", "snood", "snoof", "snoot", "snuif", "snuit", "snurk", "sober", "soefi", "soeps", "soera", "soesa", "solde", "solex", "somma", "sonar", "sonde", "soort", "sores", "sorry", "sound", "spaak", "spaan", "spaat", "spade", "spahi", "spalk", "spang", "spant", "spats", "speed", "speek", "speen", "speer", "speet", "speld", "spelt", "spier", "spies", "spijk", "spijl", "spijs", "spijt", "spike", "spint", "spion", "spits", "split", "spoed", "spoel", "spong", "spons", "spoog", "spook", "spoor", "spoot", "spore", "sport", "spouw", "spray", "sprei", "sprot", "spruw", "spuit", "spurt", "spuug", "squaw", "staaf", "staag", "staak", "staal", "staan", "staar", "staat", "stads", "stage", "stamp", "stand", "stang", "stank", "stans", "start", "state", "steak", "steef", "steeg", "steek", "steel", "steen", "steil", "stele", "stelp", "stelt", "steng", "steno", "steps", "sterk", "stern", "steun", "steur", "stick", "stiel", "stier", "stiet", "stift", "stijf", "stijl", "stins", "stipt", "stock", "stoel", "stoep", "stoer", "stoet", "stola", "stolp", "stoma", "stomp", "stond", "stonk", "stoof", "stool", "stoom", "stoop", "stoot", "store", "storm", "stort", "stout", "straf", "strak", "stram", "stras", "strek", "strik", "strip", "strop", "strot", "stuff", "stuik", "stuip", "stuit", "stulp", "stunt", "stuur", "stylo", "stèle", "stère", "suave", "suite", "sujet", "sulky", "sumak", "summa", "super", "surah", "sushi", "suède", "swami", "swing", "swipi", "sylfe", "syrah", "taaie", "taart", "taats", "tabak", "tabee", "tabel", "tabla", "taboe", "tafel", "tafia", "tahin", "tahoe", "taiga", "takel", "taken", "talen", "talie", "talig", "talon", "talud", "tanen", "tanga", "tango", "tanig", "tante", "tapas", "tapen", "tapir", "tarok", "tarot", "tarra", "tarwe", "tater", "taupe", "taxol", "taxon", "taxus", "teaën", "teddy", "teder", "teelt", "teems", "teers", "tegel", "tegen", "teint", "teken", "tekst", "telco", "telen", "teler", "telex", "teloh", "temen", "temer", "temet", "tempo", "tenen", "tenor", "tenue", "tepel", "teren", "terig", "terne", "terra", "terts", "terug", "tesla", "tests", "tetra", "tezen", "thans", "thema", "these", "thuis", "thuja", "thyrs", "tiaar", "tiara", "ticje", "tiend", "tiens", "tijde", "tijen", "tikje", "tilde", "timen", "timer", "tinas", "tinne", "tinto", "tipsy", "tiran", "tiras", "titan", "titel", "titer", "tjalk", "tjerk", "toast", "tobbe", "tocht", "toddy", "toean", "toets", "tofoe", "togen", "toges", "token", "tombe", "tomen", "tommy", "tonen", "toner", "tonic", "tonus", "toorn", "toost", "topas", "topic", "topje", "topos", "toque", "toren", "toros", "torso", "torus", "toste", "tosti", "totem", "totok", "traag", "traan", "track", "trafo", "train", "tramp", "trans", "trant", "trash", "trede", "treef", "treek", "treem", "trees", "treil", "trein", "trema", "trend", "trens", "trial", "trias", "trien", "trijp", "trijs", "trips", "trits", "troef", "troel", "troep", "tromp", "tronk", "troon", "troop", "trots", "trouw", "truck", "trust", "tsaar", "tsuba", "tucht", "tuien", "tukje", "tulen", "tumor", "tuner", "turbo", "turen", "tutti", "tweed", "twijg", "twijn", "twist", "tyfus", "typen", "uilen", "uilig", "uiten", "uitje", "uiver", "ulaan", "ultra", "unief", "uniek", "upper", "uraan", "ureum", "urine", "urmen", "uzelf", "vaalt", "vaars", "vaart", "vaats", "vacht", "vadem", "vader", "vagen", "vaker", "valig", "vamen", "vanaf", "vanop", "varen", "varia", "vaste", "vaten", "vazal", "vedel", "veder", "veest", "vegen", "veger", "veine", "velen", "velum", "vemen", "vendu", "venen", "venig", "vents", "veraf", "veren", "verre", "verso", "verst", "verte", "veste", "veter", "vette", "vezel", "vezen", "video", "vieux", "vieze", "villa", "vinyl", "viool", "virus", "visie", "visum", "vitse", "vivat", "vlaag", "vlaai", "vlade", "vlees", "vleet", "vlerk", "vleug", "vlieg", "vliem", "vlier", "vlies", "vliet", "vlijm", "vlijt", "vloed", "vloei", "vloek", "vloer", "vlood", "vloog", "vloot", "vlouw", "vocht", "vodde", "vogel", "voile", "volks", "volle", "volop", "volta", "volte", "voogd", "voord", "voorn", "voort", "voren", "vorig", "vorst", "votum", "voute", "vozen", "vraag", "vraat", "vrank", "vrede", "vrees", "vreze", "vrije", "vrind", "vroed", "vroeg", "vrome", "vroom", "vroon", "vroor", "vrouw", "vuist", "vulgo", "vulva", "vuren", "vurig", "waaks", "waard", "wacht", "waden", "wafel", "wagen", "wagon", "waken", "waker", "wakke", "walen", "wamen", "wanen", "wants", "wapen", "waren", "wasco", "wasem", "washi", "water", "watje", "wazig", "webbe", "wedde", "weder", "weegs", "weeps", "weeig", "wegel", "wegen", "weger", "wegge", "weide", "weids", "weken", "welig", "welke", "welnu", "wende", "wenen", "wener", "wepel", "weren", "werst", "wessi", "weten", "weven", "wever", "wezel", "wezen", "whist", "wicht", "wieme", "wiens", "wierf", "wierp", "wigge", "wijde", "wijle", "wijze", "wikke", "wilde", "winch", "winde", "winst", "winti", "wisse", "witje", "witte", "wodka", "woede", "woerd", "woest", "wogen", "wonde", "wonen", "woord", "worst", "wraak", "wrake", "wrang", "wreed", "wreef", "wrong", "wulps", "xenon", "xeres", "yucca", "zacht", "zadel", "zaden", "zagen", "zager", "zaken", "zalig", "zambo", "zanik", "zavel", "zeboe", "zebra", "zeden", "zedig", "zeelt", "zegel", "zegen", "zegge", "zegje", "zeken", "zeker", "zelfs", "zelve", "zemel", "zemen", "zemig", "zenen", "zenig", "zenit", "zenuw", "zepen", "zeper", "zepig", "zesde", "zetel", "zeven", "zever", "zicht", "zieke", "ziens", "ziezo", "zijde", "zijig", "zijne", "zitje", "zloty", "zoals", "zocht", "zodat", "zoden", "zodra", "zogen", "zolen", "zomen", "zomer", "zomin", "zonde", "zones", "zonet", "zopas", "zopen", "zoute", "zover", "zowat", "zowel", "zucht", "zulke", "zulks", "zulle", "zulte", "zuren", "zurig", "zwaai", "zwaan", "zwaar", "zwade", "zwalp", "zwamp", "zwans", "zware", "zwart", "zweeg", "zweem", "zweep", "zweer", "zweet", "zwelg", "zwenk", "zwerk", "zwerm", "zwiep", "zwier", "zwijn", "zwilk", "zwing", "zwoel", "zwoor"};
}

