-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 192.168.1.197    Database: pastry_shop
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cookie`
--

DROP TABLE IF EXISTS `cookie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cookie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nev` varchar(255) NOT NULL,
  `leiras` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cookie`
--

LOCK TABLES `cookie` WRITE;
/*!40000 ALTER TABLE `cookie` DISABLE KEYS */;
INSERT INTO `cookie` VALUES (1,'Palacsinta','Egy tálba ütjük a tojásokat, majd a cukrokkal együtt kikeverjük.\nFolyamatos keverés mellett hozzáadjuk a tojásos keverékhez a lisztet, majd a tejet és a szódát, végül az olajat, és csomómentesre keverjük.\nEgy serpenyőt vagy palacsintasütőt egy ecsettel vékonyan megkenünk olajjal, majd megsütjük a palacsintákat.'),(2,'New York-i sajttorta','A kekszet, cukrot és sót egy késes aprítóban teljesen simára daráljuk, majd hozzáadjuk az olvasztott vajat. Alaposan elkeverjük.\nEgy 22 centiméter átmérőjű kapcsos tortaformát alul kibélelünk egy ív sütőpapírral (tegyük a forma aljára a papírt, majd csíptessük oda a karikával). Szórjuk bele a vajas kekszalapot, majd egy pohár vagy mérőpohár segítségével egyengessük el. Mindenhol legyen ugyanolyan vastag és a forma oldalára is érjen fel, nagyjából kétujjnyi magasságig.\nA kekszes alapot 180 fokos sütőben 10 percig elősütjük, majd hagyjuk kihűlni. Közben elkészítjük a tölteléket.\nA szobahőmérsékletű krémsajtot egy állómixer táljába tesszük, majd magas fokozaton 2-3 percig habosítjuk. Ekkor hozzáadjuk a cukrot és az átszitált lisztet és további 2-3 percig habosítjuk. Ekkor jöhet a citromlé, -héj és a vanília. Ezen a ponton váltsunk habverőfejre, ha eddig mást használtunk és folytassuk a krém keverését, közepes fokozaton.\nEgyesével hozzáadjuk a tojásokat a krémhez, mindig megvárva, míg az előzőt teljesen fel nem vette a krémsajt. A második tojás hozzáadása után állítsuk le a keverést és egy spatulával kaparjuk le a tál oldalára kenődött krémet, hogy egyenletes legyen a keverés. A keverést folytatva közepes fokozaton, hozzáadjuk a maradék tojást, majd a tojássárgáját is.\nA krémhez adjuk a tejfölt, amit már óvatosan, kézi habverővel keverünk el. A kész masszát ráöntjük az elősütött, kihűtött kekszes alapra és egy spatulával egyenesre egyengetjük a felszínét.\nA sajttortát 220 fokra előmelegített sütőbe toljuk és teszünk alá egy tepsit forró vízzel. 10 percig sütjük ezen a magas hőfokon, majd lejjebb vesszük a sütőt 110 fokra, és így sütjük a süteményt további 45 percig. Ha letelt az idő, a sütő ajtaját kinyitjuk és így hagyjuk másfél órát pihenni a süteményt (ha szeretnénk, hogy a torta belseje kevésbé krémes, inkább szilárd legyen, a pihentetést végezzük zárt ajtónál).\nA sütőből kivett tortát lefedjük alufóliával, és formástul a hűtőbe rakjuk pihenni, legalább 8 óráig. Akár egy egész estét is adhatunk neki. Pihentetés után szeleteljük, tetszőlegesen magában vagy friss gyümölccsel tálaljuk.\n'),(3,'Isler','A tésztához egy keverőtálban összekeverjük a lisztet, a darált diót, a sót és a porcukrot. Kockázzuk bele a hideg vajat (vagy le is reszelhetjük). Gyors mozdulatokkal dolgozzuk össze, majd formázzunk belőle egy lapos cipót, és csomagoljuk be folpackba. Hűtőben pihentessük 30-40 percet (de akár egy egész éjszakát is hagyhatjuk).\nA sütőt előmelegítjük 180 fokra. Addig a tésztát kivesszük a hűtőből, és hagyjuk kicsit állni szobahőmérsékleten.\nLisztezett gyúródeszkán 2-3 mm vékonyra kinyújtjuk, majd 8-10 centis kör alakú formával kiszúrjuk. Kb. 30-40 darab jön ki.\nA linzerköröket tegyük sütőpapíros tepsire, és 12-15 perc alatt világos színűre sütjük. Világos színűnek kell maradnia, így lesz szép a végeredmény. Mialatt kihűl, még úgyis „tovább sül\", úgyhogy nem lesz semmiképp sem nyers.\nMiután teljesen kihűltek, az aljakra nyomunk egy púpozott evőkanál lekvárt (habzsákból a leggyorsabb és legegyszerűbb). Majd egy sima koronggal illesszük össze a lekváros aljakkal.\nTegyük őket a hűtőbe állni, addig elkészítjük a csokoládémázat. A csokoládét, vízgőz felett olvasszuk fel, és csorgassunk bele egy kevés étolajat, ezzel tudjuk picit hígítani.\nHelyezzük a korongokat rácsra és az egészet pedig egy sütőpapíros tepsire (ezen gyűjtsük majd a feleslegesen lecsorgó csokoládét, amit újra tudunk használni). Öntsük nyakon őket egyesével az olvasztott csokoládéval, majd spatulával egyengessük el és húzzuk le róluk a felesleget. Tegyünk a közepükre 1-1 szem diót, vagy húzzunk rá csokival csíkokat.\nTegyük hűtőbe egy éjszakára, hogy megdermedjen rajta a csokoládé, és kellően összepuhuljon.\n'),(4,'Habroló','Elsőnek a vaníliás pudingot a tasakon lévő utasítás szerint megfőzzük. Fél liter tej, egy tasak pudingpor, 3 ek cukor. Félretesszük kihűlni.\nA sütőt közben előmelegítjük 180 fokra. A leveles tésztát én készen veszem a boltokban. Felhasználás előtt kivesszük a hűtőből, és 10 percre állni hagyjuk, kitekerjük, majd az első csomagot 8 egyenlő csíkra vágjuk. A másik csomag leveles tésztával is ugyanígy teszünk. Elővesszük a habroló formákat, és feltekerjük rá a csíkokat úgy, hogy a tészta széle fedje egymást. Lekenjük tojással, és 10-15 perc alatt sütőpapírral bélelt tepsiben készre sütjük.\nMíg pihennek a sütik, elkészítjük a krémet. Felverjük a tejszínhabot, hozzáadunk 2 ek cukrot és a habfixálót. Összeforgatjuk a kihűlt pudinggal, habzsákba töltjük az így kapott krémet, és megtöltjük a rolókat. Tetejére lehet szórni egy kis porcukrot díszítésnek. '),(5,'Vegán Oreo torta','Alap:\nKibélelünk egy 21 cm-s tortaformát sütőpapírral. A konyhai robotgépbe beletesszük a kekszet, a sót és 30 másodpercig összedolgozzuk, amíg egynemű lesz. Hozzáadjuk a vajat és tovább keverjük. Akkor tökéletes az állaga, ha egynemű és ragacsos.\nBelenyomkodjuk a forma aljába egyenletesen a kekszes keveréket és egy egyenes aljú pohárral kisimítjuk. A formát a hűtőbe tesszük, amíg a krémet megcsináljuk.\nKrém:\nFelvágjuk az oreot kicsi darabokra és egy tálba tesszük. A kesudiót, a mascarponét, a joghurtot, az agavét, az olajat, a citromot és a vaníliát egy robotgépbe tesszük és addig aprítjuk/dolgozzuk össze, amíg egynemű nem lesz. Ezt a krémet hozzákeverjük a felaprított kekszhez és minimum 4 órára hűtőbe tesszük.\nDíszítés:\nFelvágjuk a csokoládét és egy hőálló tálba félretesszük. A kókusztejet vagy krémet egy edényben kicsit megforraljuk és ráöntjük a csokoládéra.\nÖsszekeverjük, majd hagyjuk 10-15 percig kihűlni. Fontos, hogy a csokikrém hidegen kerüljön a tortára. A csokikrémet egy spatulával eloszlatjuk a tetején és ízlés szerint díszítjük keksszel.\nA hűtőben légmentes tárolóban eláll 5 napig, de ha szükséges akkor légmentes tárolóban eláll pár hónapig a fagyasztóban is (ilyenkor ajánlott előre felvágni szeletekre). Még az is imádni fogja, aki szkeptikus a vegán süteményekkel kapcsolatban.\n'),(6,'Tiramisu torta','Alap:\nA zabkekszet egy csipet sóval ledaráljuk, majd az olvasztott vajjal összekeverjük. 24 cm-es tortaforma alján simára egyengetjük, majd 15 perce hűtőbe tesszük, hogy összeálljon.\nKrém:\nGőz fölött a tojássárgáját cukorral 80 fokig melegítjük, majd habosra keverjük - eközben ki is hűl. Hozzákeverjük a rumot és vaníliaaromát. A mascarponét kicsit kihabosítjuk, majd hozzákeverjük a tojásos krémet.\nA zselatint és a vizet összekeverjük, pár percig állni hagyjuk, majd mikróba tesszük kb. fél percre. Egy evőkanál krémmel hőkiegyenlítést végzünk a zselatinos oldattal, majd hozzákeverjük a mascarponés krémhez, és jó alaposan elkeverjük.\nA habtejszínt felverjük, és óvatosan hozzákeverjük a krémhez. Ebben az állapotban a krémet már használhatjuk is a torta összeállításához.\nÖsszeállítás:\nA hosszúkávét lefőzzük és hagyjuk hűlni.\nA krém egynegyedét habzsákba töltjük, amibe kör alakú habcsövet teszünk.\nA kekszes alapra rákenünk egy adag krémet, majd a kávéban megforgatott babapiskótákat helyezzük rá, és megszórjuk 1 evőkanál kakaóporral. Erre újabb réteg krém, áztatott piskóta és kakaópor következik, végül krémmel zárjuk. A tetejére kis krémhalmokat nyomunk a habzsákból. (Mi az egész torta tetejét befedtük, de tetszőlegesen díszíthetjük.)\nEgy napig érdemes hűteni (nem kötelező), hogy jól összeérjenek az ízek. Tálaláskor meghintjük a tetejét kakaóporral, és már fogyaszthatjuk is. Isteni finom desszert, nincsen párja.'),(7,'Epres paleo torta','Alap:\nA sütéshez használjunk (26 cm átmérőjű), kapcsos tortaformát, melynek az alját béleljük ki sütőpapírral.\nMelegítsük elő a sütőnket 180 fokra.\nAz egész tojásokat a xilittel egy tálban nagyon habosra keverjük, majd hozzáadjuk a szódabikarbónát és a kókuszreszeléket. Jól forgassuk át a reszelékkel, mert könnyen leül a tál aljára. Azonnal öntsük a masszánkat a kibélelt tortaformánkba, ha állni hagyjuk, megszívja magát a reszelék a tojásokkal és ez nem jó... kemény, morzsalékos tésztát kaphatunk.\n180 fokon 25 perc alatt megsütjük. Sütés után formából kiszedve kihűtjük.\nKrém:\n5 doboz, jól lehűtött \"cocomas\" növényi tejszínt kemény habbá verünk 2-3 ek xilittel.\nKeverés közben adjunk hozzá egy csomag zselatinfixet.\nVágjuk félbe a kihűlt tortalapunkat. Az alsó tortalapot tegyük vissza a tortaformába.\nAz eperből szeleteljünk 36 szép szeletet hosszában, a maradékot pedig vágjuk fel nagyobb darabokra. A krémet osszuk el két részre.\nAz egyik felét kenjük el az alsó tortalapon, szórjuk meg darabolt eperrel... Tegyük rá a tortalap másik felét, majd oszlassuk el rajta a maradék krémünket.\nOsszuk a tortát 12 szeletre, majd minden szeletre tegyük fel díszítésként a 3-3 eperszeletet.\nA díszítéshez:\nAz előírtak szerint készítsük el a tortazselét, kenjük be vele az eperszeleteket.\nVégezetül pirított mandulaszeletekkel szórjuk be a tortánkat. Használhatunk durvára darálva, illetve megszórhatjuk darált dióval is helyette.'),(8,'Almatorta','Almaragu:\nAz almákat megmossuk, meghámozzuk, kimagozzuk, és felnegyedeljük.\nEgy nagyobb serpenyőben a mézet (vagy a cukrot egy kevés vízzel) közepes hőmérsékleten elkezdjük karamellizálni addig, amíg be nem sűrűsödik, és sűrű karamellállaga lesz.\nEkkor belehelyezzük az almadarabokat, és 6-8 percig pároljuk, hogy az alma kissé megpuhuljon. Fűszerezzük fahéjjal és locsoljuk meg citromlével, hogy ne barnuljon be. Miután ezzel megvagyunk, félretesszük hűlni.\nTészta:\nA sütőt előmelegítjük 170 fokra. Egy 22 cm-es tortaforma oldalát olajjal kikenjük, liszttel körbeszórjuk, majd a hűtőbe tesszük. A sütőpapírt azért nem javasoljuk, mert beleragadhat a szirupos alma.\nA tojásokat cukorral habosra (fehéredésig, kb. 10-15 percig) verjük, majd folyamatos kevergetés mellett vékony sugárban hozzáadjuk az olajat. Ezután mehet bele a vaníliaaroma, citromhéj, a fahéj és a baracklekvár.\nEhhez a keverékhez hozzászitáljuk a lisztet, amit előzőleg a szódabikarbónával összekevertünk. Majd az egészet összefogatjuk óvatos, de határozott mozdulatokkal, lehetőleg egy irányban. Figyeljünk arra, hogy ne törjük össze a tojásos habot! Érdemes gumispatulával dolgozni.\nA tortaforma aljába ízlésesen és egyenletesen elhelyezzük az almadarabokat és rácsorgatjuk a maradék szirupot, majd erre halmozzuk a tésztát. Kicsit lekocogtatjuk az egészet, majd légkeveréses sütőben 170 C fokon 30-40 percig sütjük.\nAmikor elkészült, óvatosan és még melegen (!) fordítsuk rá fejjel lefelé egy tortatálra, és vegyük le róla a formát. Ha ezzel hűlésig várnánk, a ragacsos alja valószínűleg megszilárdulna, és az egész beleragadna a formában.\nPorcukorral meghintve tálaljuk.'),(9,'Csokoládétorta','Alap:\nA piskótához külön választjuk a tojások fehérjét és sárgáját. A sárgájához tesszük a cukrot, és robotgéppel habosra keverjük.\nA fehérjét keményre verjük egy csipet sóval.\nA lisztet, kakaóport, sütőport egy tálkában összekeverjük.\nEzután az egészet óvatosan homogénné keverjük egy fakanál segítségével.\nEgy kapcsos tortaforma aljába sütőpapírt feszítünk, ebbe öntjük a masszát, és előmelegített sütőben készre sütjük.\nHa kihűlt a piskótánk, vízszintesen három részre vágjuk.\nKrém:\nA krémhez a pudingporokat csomómentesre keverjük a tejben, beletördeljük a csokoládét (kivéve 1-2 kockát, amit a díszítésnél használunk majd), és lassú tűznél sűrű péppé főzzük. Kevergetve kihűtjük.\nA puha margarint habosra keverjük a cukorral, majd a pudingot is alaposan belekeverjük robotgéppel.\nEzután a piskótalapokat megtöltjük a krémmel, kívül is bevonjuk, majd díszítjük krém-rózsákkal, csokireszelékkel. '),(10,'Eszterházy torta','A tészta:\nA tortához 5 lapra lesz szükségünk, tehát érdemes először egy 20 cm-es tortaformát körberajzolni, jó erősen ceruzával, majd ezt fordítsuk meg, és úgy tegyük a tepsire, így nem fog a tészta hozzáérni a ceruzához/tollhoz. (Én 3 részletben sütöttem meg a lapokat, mert amúgy nem fért volna be a sütőbe. Fontos, hogy a tészta ne álljon sütés előtt, mert a fehérje összeesik.)\nA sütőt melegítsük elő 190 fokra.\nA tojásokat válasszuk szét, majd a fehérjét verjük fel a cukorral addig, amíg egy olyan habot kapunk, ami még lágy, de már van tartása. Óvatosan forgassuk bele a diót is, ehhez a legjobb egy szilikon spatulát használni.\nOsszuk el egyenletesen a megrajzolt sütőlapra, és egy hosszú késsel vagy egy kenőkéssel simítsuk el úgy, hogy a megrajzolt körön 1 centivel túllógjon, így majd ki tudjuk vágni, és egyenletes széleket kapunk.\nSüssük előmelegített sütőben 10 percig, vagy ameddig enyhén barna nem lesz. Ne süssük túl, mert törős lesz, de az sem jó, ha alulsütjük, mert akkor túlságosan ragadni fog. Ha megérintjük, és már szárazabbnak ítéljük és egy kissé barna is, jó lesz.\nFordítsuk le egy sütőpapírra, és hagyjuk őket kihűlni, majd húzzuk le a sütőpapírt a lapokról, és a 20 centis tortaforma segítségével vágjuk körbe őket.\nKrém:\nA krémhez a pudingport főzzük meg a 300 ml tejjel és a cukorral, a tasakon leírtak szerint. Ha kész, hagyjuk szobahőmérsékletűre hűlni. Fontos, hogy tegyünk a pudingra egy fóliát úgy, hogy hozzáérjen a pudinghoz, így nem lesz darabos.\nHa szobahőmérsékletűre hűlt a puding, keverjük hozzá a vajat, majd adjuk hozzá a diót és ízlés szerint a rumot is.\nÖsszeállítás:\nAz összeállításnál válasszuk ki a legszebb tortalapot, ezt tegyük félre, és legyen ez a teteje.\nA többit kenjük meg a krémmel, majd tegyük rá a félretett tortalapot, erre már ne kerüljön krém. Úgy osszuk el a krémet a tortalapok között, hogy maradjon a torta körbekenésére és díszítésére.\nDíszítés:\nOlvasszuk meg az étcsokoládét, majd tegyük kicsit félre, hogy kissé kihűljön. Ezután tegyük egy eldobható habzsákba, amire egy kis lyukat vágunk.\nOlvasszuk meg a fehér csokoládét 1-2 evőkanál étolajjal, ezt is hagyjuk kicsit kihűlni, majd lassan öntsük rá a legfelső tortalap közepére. Kenőkéssel oszlassuk el egyenletesen, vigyázva, hogy ne csöpögjön le a szélére.\nAmíg a fehér csokoládé még nedves, az étcsokoládéval a torta közepéről kezdve rajzoljunk egy csigavonalat. Nem kell rohanni, mert nem szárad olyan gyorsan, de izgulni sem kell rajta, nem kell hogy tökéletes legyen.\nAz étcsokit egy fogpiszkálóval húzzuk ki pókhálósra úgy, hogy először a közepét kihúzzuk 4 felé, majd kívülről befelé vonalakat húzunk a torta közepe felé.\nTegyük a hűtőbe pár órára, hogy teljesen megszáradjon a teteje.\nAz oldalát vonjuk be a megmaradt krémmel, majd darált dióval panírozzuk. Díszítsük ízlés szerint a krémmel és egész dióval.'),(11,'Dobos-torta','Alap:\nDobos lapok elkészítése:\nA tojások sárgáját a porcukor felével fehéredésig habosítjuk. A porcukor másik felével a tojásfehérjéket nem túl kemény habbá verjük.\nA két tojáshabot összeforgatjuk, hozzáadjuk az olvasztott vajat és a lisztet, és lazán elkeverjük. Ne keverjük túl sokáig, mert össze fog esni.\nA masszát osszuk 6 felé, kenjük szilikonos sütőlapra (tortaformát rányomjuk a szilikonos lapra, és elkenjük egyenletesen a masszát).\n210 fokos sütőben 10-12 perc alatt világosbarnára sütjük.\nKrém:\nA szobahőmérsékletű, puha vajat porcukorral jól kihabosítjuk, és félretesszük.\n4 tojást a porcukorral fokozatosan keverve \"csípősre\" hevítünk (maghőmérővel ellenőrizhetjük a hőfokot, 85 fok felé ne menjünk), folyamatosan kevergessük, nehogy lerántottásodjon. Ha nincs maghőmérőnk, ujjunkat belemártva ellenőrizzük: ha forrónak érezzük, akkor jó.\nEztán kihűlésig habosítsuk a tojást a porcukorral, teljesen fehérnek és sűrűnek kell lennie.\nA kakaóvajat egy lábasban olvasszuk fel, adjuk hozzá a kakaómasszát és az étcsokit is. Ne hevítsük túl, épp csak olvasszuk fel a csokikat, és tegyük is félre, hagyjuk kicsit kihűlni.\nEzután a kihabosított vajhoz adjuk hozzá a tojásos-porcukros masszát és a csokis masszát, dolgozzuk egyneművé kézi habverővel vagy szilikonlapáttal. A krém kész, tegyük félre.\nA dobos tető elkészítése:\nA cukrot kezdjük el olvasztani egy kicsi, magas falú lábasban, folyamatosan kevergessük. (Én most egy pár csepp ecetet, és picike vajat is adtam hozzá.) Az edény falára kiült kristályokat terelgessük vissza, hogy maradéktalanul felolvadjon. Ha kezd sötétedni, de még nem olvadt fel, vegyük le a tűzről, és úgy kevergessük, majd tegyük vissza.\nHa a karamell kész, öntsük óvatosan a dobos lap közepére, és egy nagyméretű késsel kenjük el egyenletesre. Majd a kés FOKÁVAL jelöljük be, hány szeletbe szeretnénk vágni a tortát. Ezután a kés élével roppantsuk el a cukrot. Minden roppantás után vajazzuk a kés élét, így nem ragad bele a menet közben dermedésnek indult karamellbe.\nA sütőt célszerű 200 fokra bekapcsolni még előtte, hogy amennyiben a karamell megköt, mielőtt fel tudnánk vágni, pár másodpercre toljuk be a dobos lapot a sütőbe, és újra vághatjuk.\nÖsszeállítás:\nKészítsünk elő egy tortakarikát, a krémet osszuk 6 felé. (Én lemértem a kész krémet, 830 g volt, így minden lap töltésénél lemértem 130 g-ot, és annyit kentem rá.)\n5 lapunk van, a 6. adag krém a torta oldalára és a tetejére fog kerülni, illetve a dobos tetőre díszítésképp, ha szeretnénk. Cakkos szélű habkártyával húzzuk át a torta oldalát.\nTegyük a tortát pár órára hűtőbe, ha a krém megdermedt, rakjuk fel a dobos tetőket, és készen is van.'),(12,'Erdeigyümölcs-torta','Alap:\nA piskótához a tojások fehérjét félkemény habbá verjük, majd hozzáadjuk a cukrokat és habcsók állagú, de szilárd habot verünk. A sárgáját fehéredésig verjük, spatulával a fehérjéhez keverjük. Ezután beleszitáljuk a lisztet és finoman, csomómentesre elvegyítjük a tojásokkal.\nA tésztát 30 cm-es kapcsos bélelt formába töltjük és előmelegített sütőben 150 C-on 30-35 percig/ tűpróbáig sütjük. A sűtőből kivéve rácson hűtjük, majd lapjában három részre vágjuk.\nKrém:\nA krémhez a gyümölcsöket megmossuk, majd a cukorral és a vízzel együtt, alacsony lángon főzni kezdjük. Addig főzzük, amíg a gyümölcsök szét nem főnek és lekvár állagú masszát nem kapunk. Ezután a masszát botmixerrel pépesítjük és hagyjuk teljesen kihűlni.\nA cukrászhabot kemény habbá verjük, hozzáadjuk a kihűlt gyümölcsmixet, az aromát és a zselatinfixet, majd fél órára hűtőbe tesszük.\nDíszítés:\nA lapokat megkenjük a krémmel, majd a maradékkal felül és oldalt átkenjük a tortát, tortakártyával egyenletesre és simára húzzuk, tetejét gyümölcsökkel díszítjük.\nFogyasztás előtt 2 órát hűtőben állni hagyjuk.'),(13,'Répatorta','Tészta:\nA cukrot kikavarjuk a tojássárgákkal és az olajjal.\nHozzáadjuk az apróra reszelt sárgarépát, a vaníliás cukrot és a sütőporos lisztet. Alaposan összekavarjuk.\nKis fahéjjal vagy citromhéjjal ízesítjük.\nA tojásfehérjékből habot verünk.Óvatosan a masszához forgatjuk\nSütőpapírral bélelt tortaformába simítjuk, és előmelegített sütőben sütjük.\nDíszítés:\nA máz hozzávalóit kb. méz sűrűségűre kavarjuk, és a kihűlt tortát bevonjuk vele. Díszítésnek használhatunk marcipánrépát.'),(14,'Nosztalgia krémes','A pudingot lábasba teszük, a vízzel felöntjük, és simára keverjük a cukorral, majd nagy lángon folyamatosan kevergetve sűrűre főzzük.\nHagyuk kihűlni.\nA tésztát kiolvasztjuk, és 4 felé vágjuk.\nMajd nagyon vékonyra kinyújtjuk, és kisütjük egy tepsi hátlapján. A sütőt előmelegítjük, és a lapokat megsütjük. (3-5 percig kel sütni. Ha sütőpapíron nyújtjuk kicsit könnyebb és egyszerűbb leszedni a tepsiről.) Hirtelen sül folyamatosan figyeljünk rá!!\nA pudingot tálba kaparjuk, ha már kihűlt, hozzáöntjük a habtejszínt (ha a tejszín nem édesített, 3 ek cukorral édesítjük.)\nMajd robotmixer legnagyobb fokozatával 10-15 percig keverjük.\nA lapokat tálcára helyezzük, és a krémmel rétegenként megkenjük.\nAz utolsó réteg tetejét porcukorral meg szórjuk.');
/*!40000 ALTER TABLE `cookie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cookie_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` int NOT NULL,
  `status` varchar(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` text NOT NULL,
  `order_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `suti_id` (`cookie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2,5,12,7200,'NEW','Kovács Anna','+36301234567','anna.kovacs@gmail.com','2024-12-04 00:00:00'),(3,8,5,3000,'FINISHED','Nagy Péter','+36301112222','peter.nagy@gmail.com','2024-12-03 00:00:00'),(4,13,20,12000,'IN_PROGRESS','Szabó János','+36305556666','janos.szabo@gmail.com','2024-12-02 00:00:00'),(5,10,3,1800,'CANCELLED','Tóth Erika','+36309998877','erika.toth@gmail.com','2024-11-30 00:00:00'),(6,2,8,4800,'FINISHED','Farkas László','+36304445555','laszlo.farkas@gmail.com','2024-12-01 00:00:00'),(7,7,15,9000,'NEW','Molnár Katalin','+36306667777','katalin.molnar@gmail.com','2024-12-04 00:00:00');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `cookie_id` int NOT NULL,
  `hozzavalo_id` int NOT NULL,
  `szukseges_mennyiseg` decimal(10,3) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `suti_id` (`cookie_id`),
  KEY `hozzavalo_id` (`hozzavalo_id`),
  CONSTRAINT `recipes_ibfk_1` FOREIGN KEY (`cookie_id`) REFERENCES `cookie` (`id`),
  CONSTRAINT `recipes_ibfk_2` FOREIGN KEY (`hozzavalo_id`) REFERENCES `storage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,1,0.200,1),(1,2,0.500,2),(1,3,3.000,3),(1,4,0.100,4),(1,5,0.100,5),(2,6,0.150,6),(2,7,0.080,7),(2,4,0.001,8),(2,8,0.001,9),(2,9,0.900,10),(2,4,0.250,11),(2,3,3.000,12),(2,3,1.000,13),(2,1,0.200,14),(2,10,0.010,15),(2,11,0.001,16),(2,12,0.010,17),(2,13,0.200,18),(3,1,0.300,19),(3,7,0.200,20),(3,4,0.100,21),(3,10,0.010,22),(3,14,0.005,23),(3,3,2.000,24),(3,15,0.050,25),(3,16,0.200,26),(3,17,0.400,27),(3,18,0.005,28),(3,8,0.001,29),(4,19,2.000,30),(4,20,0.040,31),(4,12,0.500,32),(4,4,0.005,33),(4,21,0.200,34),(4,22,1.000,35),(4,3,1.000,36),(5,23,0.200,70),(5,24,0.300,71),(5,25,0.120,72),(5,26,0.118,73),(5,12,0.015,74),(5,10,0.004,75),(5,27,0.075,76),(5,28,0.075,77),(5,29,32.000,78),(5,8,0.001,79),(5,18,0.105,80),(6,6,0.175,81),(6,8,0.001,82),(6,7,0.080,83),(6,3,6.000,84),(6,4,0.200,85),(6,31,0.030,86),(6,30,0.010,87),(6,9,0.750,88),(6,21,0.500,89),(6,20,0.020,90),(6,5,0.090,91),(6,5,0.250,92),(6,32,0.300,93),(6,33,0.020,94),(7,3,6.000,104),(7,34,0.090,105),(7,6,0.200,106),(7,35,0.005,107),(7,25,1.000,108),(7,22,1.000,109),(7,36,0.250,110),(7,37,1.000,111),(7,38,0.050,112),(8,42,4.000,113),(8,39,0.200,114),(8,14,0.005,115),(8,12,0.025,116),(8,4,0.200,117),(8,1,0.350,118),(8,18,0.150,119),(8,3,6.000,120),(8,30,0.005,121),(8,11,0.020,122),(8,35,0.005,123),(8,8,0.001,124),(8,40,0.075,125),(8,41,0.060,126),(9,3,9.000,127),(9,1,0.120,128),(9,33,0.045,129),(9,4,0.135,130),(9,43,0.500,131),(9,44,0.160,132),(9,17,0.100,133),(9,2,1.000,134),(9,7,0.250,135),(9,41,0.150,136),(10,3,5.000,137),(10,4,0.225,138),(10,15,0.200,139),(10,20,0.040,140),(10,2,0.300,141),(10,31,0.005,142),(10,7,0.150,143),(10,44,0.100,144),(10,17,0.020,145),(11,3,10.000,146),(11,1,0.100,147),(11,41,0.300,148),(11,7,0.270,149),(11,10,0.017,150),(11,17,0.200,151),(11,47,0.035,152),(11,46,0.035,153),(11,4,0.150,154),(12,50,0.390,155),(12,36,0.250,156),(12,48,0.250,157),(12,49,0.250,158),(12,5,0.150,159),(12,21,0.500,160),(12,4,0.290,161),(12,51,1.000,162),(12,3,12.000,163),(12,1,0.260,164),(12,10,0.080,165),(13,1,0.300,166),(13,3,4.000,167),(13,52,0.300,168),(13,18,0.150,169),(13,41,0.350,170),(13,10,0.040,171),(13,14,0.005,172),(13,43,0.020,173),(13,7,0.020,174),(13,12,0.005,175),(14,19,1.000,176),(14,20,0.160,177),(14,5,0.800,178),(14,4,0.060,179),(14,21,0.800,180),(14,41,0.010,181);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` text NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN','Admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `previous_session_id` int DEFAULT NULL,
  `jwt_token` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expiration_date` timestamp NOT NULL,
  `service_point_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role` (`role_id`),
  KEY `user` (`user_id`),
  CONSTRAINT `role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (1,3,1,NULL,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJudWxsIiwicm9sZSI6IkFETUlOIiwiZXhwIjoxNzMyNzYzNTUxLCJ1c2VySWQiOjN9.pbiovV1wEbshY8UxaYWYwqHjV68u8ioMrFZl2SSeGRw','2024-11-27 20:12:32','2024-11-28 04:12:32',NULL),(2,3,1,1,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwicm9sZSI6IkFETUlOIiwiZXhwIjoxNzMzMjgwODIxLCJ1c2VySWQiOjN9.3YBJbKdzrpPpkDOopIWZQ4JJXIgg-Zjx6UJ9Jmsyq-A','2024-12-03 19:53:41','2024-12-04 03:53:41',NULL);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hozzavalo_nev` varchar(255) NOT NULL,
  `mennyiseg` decimal(10,3) NOT NULL DEFAULT '0.000',
  `egyseg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `hozzavalo_nev` (`hozzavalo_nev`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,'Liszt',100.000,'kg'),(2,'Tej',100.000,'l'),(3,'Tojás',130.000,'db'),(4,'Cukor',100.000,'kg'),(5,'Víz',100.000,'l'),(6,'Keksz',100.000,'kg'),(7,'Vaj',100.000,'kg'),(8,'Só',100.000,'kg'),(9,'Krémsajt',100.000,'kg'),(10,'Vaníliás cukor',100.000,'kg'),(11,'Citromhéj',100.000,'kg'),(12,'Citromlé',100.000,'l'),(13,'Tejföl',100.000,'kg'),(14,'Fahéj',100.000,'kg'),(15,'Dió',100.000,'kg'),(16,'Málnalekvár',100.000,'kg'),(17,'Étcsokoládé',100.000,'kg'),(18,'Napraforgó olaj',100.000,'l'),(19,'Leveles tészta',100.000,'csomag'),(20,'Vaníliás pudingpor',100.000,'kg'),(21,'Habtejszín',100.000,'l'),(22,'Habfixáló',100.000,'csomag'),(23,'Kesudió',100.000,'kg'),(24,'Mascarpone (vegán)',100.000,'kg'),(25,'Növényi joghurt',100.000,'l'),(26,'Agávé szirup',100.000,'l'),(27,'Étcsokoládé (vegán)',100.000,'kg'),(28,'Kókusztej',100.000,'l'),(29,'Oreo keksz',100.000,'db'),(30,'Vaníliaaroma',100.000,'l'),(31,'Rum',100.000,'l'),(32,'Babapiskóta',100.000,'kg'),(33,'Kakaópor',100.000,'kg'),(34,'Xilit',100.000,'kg'),(35,'Szódabikarbóna',100.000,'kg'),(36,'Eper',100.000,'kg'),(37,'Tortazselé',100.000,'csomag'),(38,'Mandulapehely',100.000,'kg'),(39,'Méz',100.000,'kg'),(40,'Sárgabaracklekvár',100.000,'kg'),(41,'Porcukor',100.000,'kg'),(42,'Alma',100.000,'db'),(43,'Sütőpor',100.000,'csomag'),(44,'Csokoládés pudingpor',100.000,'kg'),(45,'Fehér csokoládé',100.000,'kg'),(46,'Kakaóvaj',100.000,'kg'),(47,'Csokoládé',100.000,'kg'),(48,'Szeder',100.000,'kg'),(49,'Áfonya',100.000,'kg'),(50,'Málna',100.000,'kg'),(51,'Zselatinfix',100.000,'csomag'),(52,'Sárgarépa',100.000,'kg');
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `role_code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,0,'Admin','Admin','2024-11-27 18:52:47','Macháty Mátyás','ADMIN'),(3,1,'Matyas','$2a$10$1Rtj/cLrs8MHIM9EqQq1F.jlBkvIgDHB6rMEA6Muw7csKJoDMyoqe','2024-11-27 19:02:52','Teszt Admin','ADMIN');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-04 17:19:41
