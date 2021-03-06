package com.spacitron.citiesapp;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.spacitron.citiesapp.citymodel.City;

import java.util.Collections;
import java.util.List;


public class CityData {

   public final static String data = "[" +
            "{\"country\":\"UA\",\"name\":\"Hurzuf\",\"_id\":707860,\"coord\":{\"lon\":34.283333,\"lat\":44.549999}}," +
            "{\"country\":\"UA\",\"name\":\"Alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +

            //Fake country to see that the country is taken into consideration when sorting
            "{\"country\":\"AA\",\"name\":\"Alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +

            //Lowercase to ensure that sorting is case insensitive amd indexes are built correctly
            "{\"country\":\"UA\",\"name\":\"alupka\",\"_id\":713514,\"coord\":{\"lon\":34.049999,\"lat\":44.416668}}," +
            "{\"country\":\"RU\",\"name\":\"Novinki\",\"_id\":519188,\"coord\":{\"lon\":37.666668,\"lat\":55.683334}}," +
            "{\"country\":\"NP\",\"name\":\"Gorkh\u0101\",\"_id\":1283378,\"coord\":{\"lon\":84.633331,\"lat\":28}}," +
            "{\"country\":\"IN\",\"name\":\"State of Hary\u0101na\",\"_id\":1270260,\"coord\":{\"lon\":76,\"lat\":29}}," +
            "{\"country\":\"UA\",\"name\":\"Holubynka\",\"_id\":708546,\"coord\":{\"lon\":33.900002,\"lat\":44.599998}}," +
            "{\"country\":\"NP\",\"name\":\"B\u0101gmat\u012B Zone\",\"_id\":1283710,\"coord\":{\"lon\":85.416664,\"lat\":28}}," +
            "{\"country\":\"RU\",\"name\":\"Mar\u2019ina Roshcha\",\"_id\":529334,\"coord\":{\"lon\":37.611111,\"lat\":55.796391}}," +
            "{\"country\":\"IN\",\"name\":\"Republic of India\",\"_id\":1269750,\"coord\":{\"lon\":77,\"lat\":20}}," +
            "{\"country\":\"NP\",\"name\":\"Kathmandu\",\"_id\":1283240,\"coord\":{\"lon\":85.316666,\"lat\":27.716667}}," +
            "{\"country\":\"NP\",\"name\":\"kathmandu\",\"_id\":1283240,\"coord\":{\"lon\":85.316666,\"lat\":27.716667}}," +

            // These following three are used to test filtering
            "{\"country\":\"UA\",\"name\":\"Laspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +
            "{\"country\":\"UA\",\"name\":\"Lasspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +
            "{\"country\":\"UA\",\"name\":\"Lassspi\",\"_id\":703363,\"coord\":{\"lon\":33.733334,\"lat\":44.416668}}," +

            "{\"country\":\"IQ\",\"name\":\"Qarah Gawl al \u2018Uly\u0101\",\"_id\":384848,\"coord\":{\"lon\":45.6325,\"lat\":35.353889}}," +
            "{\"country\":\"RU\",\"name\":\"Zavety Il\u2019icha\",\"_id\":464176,\"coord\":{\"lon\":37.849998,\"lat\":56.049999}}," +
            "{\"country\":\"IL\",\"name\":\"\u2018Azriqam\",\"_id\":295582,\"coord\":{\"lon\":34.700001,\"lat\":31.75}}," +
            "{\"country\":\"UA\",\"name\":\"Tyuzler\",\"_id\":690856,\"coord\":{\"lon\":34.083332,\"lat\":44.466667}}," +
            "{\"country\":\"RU\",\"name\":\"Zaponor\u2019ye\",\"_id\":464737,\"coord\":{\"lon\":38.861942,\"lat\":55.639999}}," +
            "{\"country\":\"UA\",\"name\":\"Il\u2019ich\u00EBvka\",\"_id\":707716,\"coord\":{\"lon\":34.383331,\"lat\":44.666668}}," +
            "]";


   static List<City> getCities(){
       List<City> result =  new GsonBuilder()
               .create()
               .fromJson(data, new TypeToken<List<City>>() {
               }.getType());
       result.removeAll(Collections.singleton(null));
       return result;
   }


   static final String longData = "\n" +
           "[\n" +
           "{\"country\":\"CF\",\"name\":\"Boda\",\"_id\":2388614,\"coord\":{\"lon\":17.46953,\"lat\":4.31887}},\n" +
           "{\"country\":\"CF\",\"name\":\"boda\",\"_id\":2388614,\"coord\":{\"lon\":17.46953,\"lat\":4.31887}},\n" +
           "{\"country\":\"CF\",\"name\":\"Commune de Bangui\",\"_id\":2596686,\"coord\":{\"lon\":18.58333,\"lat\":4.36667}},\n" +
           "{\"country\":\"CG\",\"name\":\"Mossendjo\",\"_id\":2256895,\"coord\":{\"lon\":12.72611,\"lat\":-2.95056}},\n" +
           "{\"country\":\"CG\",\"name\":\"Loandjili\",\"_id\":2258378,\"coord\":{\"lon\":11.85778,\"lat\":-4.75611}},\n" +
           "{\"country\":\"CG\",\"name\":\"Kayes\",\"_id\":2259383,\"coord\":{\"lon\":13.29278,\"lat\":-4.16556}},\n" +
           "{\"country\":\"CH\",\"name\":\"Aussersihl\",\"_id\":2661666,\"coord\":{\"lon\":8.52127,\"lat\":47.377522}},\n" +
           "{\"country\":\"CH\",\"name\":\"Riehen\",\"_id\":3206590,\"coord\":{\"lon\":7.64683,\"lat\":47.578838}},\n" +
           "{\"country\":\"CI\",\"name\":\"Arrah\",\"_id\":2292755,\"coord\":{\"lon\":-3.97222,\"lat\":6.66528}},\n" +
           "{\"country\":\"CI\",\"name\":\"Akoupe\",\"_id\":2293107,\"coord\":{\"lon\":-3.90028,\"lat\":6.39}},\n" +
           "{\"country\":\"CI\",\"name\":\"Agnibilekrou\",\"_id\":2293260,\"coord\":{\"lon\":-3.20472,\"lat\":7.13444}},\n" +
           "{\"country\":\"CI\",\"name\":\"Seguela\",\"_id\":2596934,\"coord\":{\"lon\":-6.67306,\"lat\":7.96111}},\n" +
           "{\"country\":\"CI\",\"name\":\"Soubre\",\"_id\":2598243,\"coord\":{\"lon\":-6.60833,\"lat\":5.78556}},\n" +
           "{\"country\":\"CL\",\"name\":\"Valdivia\",\"_id\":3868707,\"coord\":{\"lon\":-73.245888,\"lat\":-39.81422}},\n" +
           "{\"country\":\"CL\",\"name\":\"San Antonio\",\"_id\":3872395,\"coord\":{\"lon\":-71.621674,\"lat\":-33.59333}},\n" +
           "{\"country\":\"CL\",\"name\":\"Puente Alto\",\"_id\":3875024,\"coord\":{\"lon\":-70.583328,\"lat\":-33.616669}},\n" +
           "{\"country\":\"CL\",\"name\":\"Melipilla\",\"_id\":3880107,\"coord\":{\"lon\":-71.216667,\"lat\":-33.700001}},\n" +
           "{\"country\":\"CL\",\"name\":\"La Union\",\"_id\":3883629,\"coord\":{\"lon\":-73.083328,\"lat\":-40.283329}},\n" +
           "{\"country\":\"CL\",\"name\":\"Iquique\",\"_id\":3887127,\"coord\":{\"lon\":-70.143059,\"lat\":-20.220831}},\n" +
           "{\"country\":\"CL\",\"name\":\"El Monte\",\"_id\":3890949,\"coord\":{\"lon\":-71.01667,\"lat\":-33.683331}},\n" +
           "{\"country\":\"CL\",\"name\":\"Cauquenes\",\"_id\":3896105,\"coord\":{\"lon\":-72.322479,\"lat\":-35.967098}},\n" +
           "{\"country\":\"CL\",\"name\":\"Cartagena\",\"_id\":3896433,\"coord\":{\"lon\":-71.605278,\"lat\":-33.554169}},\n" +
           "{\"country\":\"CL\",\"name\":\"Canete\",\"_id\":3896924,\"coord\":{\"lon\":-73.400002,\"lat\":-37.799999}},\n" +
           "{\"country\":\"CL\",\"name\":\"La Pintana\",\"_id\":7281017,\"coord\":{\"lon\":-70.634193,\"lat\":-33.583309}},\n" +
           "{\"country\":\"CL\",\"name\":\"Lo Prado\",\"_id\":7281020,\"coord\":{\"lon\":-70.725517,\"lat\":-33.444302}},\n" +
           "{\"country\":\"CM\",\"name\":\"Wum\",\"_id\":2221053,\"coord\":{\"lon\":10.06667,\"lat\":6.38333}},\n" +
           "{\"country\":\"CM\",\"name\":\"Tibati\",\"_id\":2221530,\"coord\":{\"lon\":12.63333,\"lat\":6.46667}},\n" +
           "{\"country\":\"CM\",\"name\":\"Tchollire\",\"_id\":2221607,\"coord\":{\"lon\":14.1698,\"lat\":8.4022}},\n" +
           "{\"country\":\"CM\",\"name\":\"Sangmelima\",\"_id\":2222230,\"coord\":{\"lon\":11.98333,\"lat\":2.93333}},\n" +
           "{\"country\":\"CM\",\"name\":\"Penja\",\"_id\":2222623,\"coord\":{\"lon\":9.67987,\"lat\":4.63911}},\n" +
           "{\"country\":\"CM\",\"name\":\"Obala\",\"_id\":2223293,\"coord\":{\"lon\":11.53333,\"lat\":4.16667}},\n" +
           "{\"country\":\"CM\",\"name\":\"Nkoteng\",\"_id\":2223734,\"coord\":{\"lon\":12.03333,\"lat\":4.51667}},\n" +
           "{\"country\":\"CM\",\"name\":\"Nkongsamba\",\"_id\":2223763,\"coord\":{\"lon\":9.9404,\"lat\":4.9547}},\n" +
           "{\"country\":\"CM\",\"name\":\"Nanga Eboko\",\"_id\":2225457,\"coord\":{\"lon\":12.36667,\"lat\":4.68333}},\n" +
           "{\"country\":\"CM\",\"name\":\"Muyuka\",\"_id\":2225726,\"coord\":{\"lon\":9.4103,\"lat\":4.2898}},\n" +
           "{\"country\":\"CM\",\"name\":\"Mutengene\",\"_id\":2225728,\"coord\":{\"lon\":9.3144,\"lat\":4.0913}},\n" +
           "{\"country\":\"CM\",\"name\":\"Mora\",\"_id\":2225991,\"coord\":{\"lon\":14.14011,\"lat\":11.04611}},\n" +
           "{\"country\":\"CM\",\"name\":\"Mokolo\",\"_id\":2226275,\"coord\":{\"lon\":13.80188,\"lat\":10.73978}},\n" +
           "{\"country\":\"CM\",\"name\":\"Melong\",\"_id\":2227230,\"coord\":{\"lon\":9.96143,\"lat\":5.1218}},\n" +
           "{\"country\":\"CM\",\"name\":\"Meiganga\",\"_id\":2227402,\"coord\":{\"lon\":14.3,\"lat\":6.51667}},\n" +
           "{\"country\":\"CM\",\"name\":\"Mbouda\",\"_id\":2227613,\"coord\":{\"lon\":10.25517,\"lat\":5.62578}},\n" +
           "{\"country\":\"CM\",\"name\":\"Mbandjok\",\"_id\":2228028,\"coord\":{\"lon\":11.9,\"lat\":4.45}},\n" +
           "{\"country\":\"CM\",\"name\":\"Manjo\",\"_id\":2228499,\"coord\":{\"lon\":9.8217,\"lat\":4.8428}},\n" +
           "{\"country\":\"CM\",\"name\":\"Loum\",\"_id\":2229152,\"coord\":{\"lon\":9.7351,\"lat\":4.7182}},\n" +
           "{\"country\":\"CM\",\"name\":\"Lolodorf\",\"_id\":2229267,\"coord\":{\"lon\":10.73333,\"lat\":3.23333}},\n" +
           "{\"country\":\"CM\",\"name\":\"Limbe\",\"_id\":2229411,\"coord\":{\"lon\":9.2149,\"lat\":4.0242}},\n" +
           "{\"country\":\"CM\",\"name\":\"Lagdo\",\"_id\":2229681,\"coord\":{\"lon\":13.73333,\"lat\":9.05}},\n" +
           "{\"country\":\"CM\",\"name\":\"Kumbo\",\"_id\":2229748,\"coord\":{\"lon\":10.66667,\"lat\":6.2}},\n" +
           "{\"country\":\"CM\",\"name\":\"Kribi\",\"_id\":2229761,\"coord\":{\"lon\":9.91667,\"lat\":2.95}},\n" +
           "{\"country\":\"CM\",\"name\":\"Kaele\",\"_id\":2230599,\"coord\":{\"lon\":14.45083,\"lat\":10.10917}},\n" +
           "{\"country\":\"CM\",\"name\":\"Guider\",\"_id\":2230876,\"coord\":{\"lon\":13.94861,\"lat\":9.93417}},\n" +
           "{\"country\":\"CM\",\"name\":\"Fundong\",\"_id\":2231482,\"coord\":{\"lon\":10.26667,\"lat\":6.25}},\n" +
           "{\"country\":\"CM\",\"name\":\"Fontem\",\"_id\":2231564,\"coord\":{\"lon\":9.8818,\"lat\":5.4685}},\n" +
           "{\"country\":\"CM\",\"name\":\"Bogo\",\"_id\":2233805,\"coord\":{\"lon\":14.60928,\"lat\":10.7336}},\n" +
           "{\"country\":\"CM\",\"name\":\"Banyo\",\"_id\":2234794,\"coord\":{\"lon\":11.81667,\"lat\":6.75}},\n" +
           "{\"country\":\"CN\",\"name\":\"Laojunmiao\",\"_id\":1280757,\"coord\":{\"lon\":97.73333,\"lat\":39.833328}},\n" +
           "{\"country\":\"CN\",\"name\":\"Baijiantan\",\"_id\":1529626,\"coord\":{\"lon\":85.183327,\"lat\":45.633331}},\n" +
           "{\"country\":\"CN\",\"name\":\"Zhoucun\",\"_id\":1784178,\"coord\":{\"lon\":117.816673,\"lat\":36.816669}},\n" +
           "{\"country\":\"CN\",\"name\":\"Zhongxing\",\"_id\":1784253,\"coord\":{\"lon\":118.679169,\"lat\":33.703892}},\n" +
           "{\"country\":\"CN\",\"name\":\"Zaoyang\",\"_id\":1785462,\"coord\":{\"lon\":112.754173,\"lat\":32.12722}},\n" +
           "{\"country\":\"CN\",\"name\":\"Yishui\",\"_id\":1786455,\"coord\":{\"lon\":118.628059,\"lat\":35.784721}},\n" +
           "{\"country\":\"CN\",\"name\":\"Xucheng\",\"_id\":1787837,\"coord\":{\"lon\":110.128838,\"lat\":20.35}},\n" +
           "{\"country\":\"CN\",\"name\":\"Dongyang\",\"_id\":1791056,\"coord\":{\"lon\":120.225281,\"lat\":29.26778}},\n" +
           "{\"country\":\"CN\",\"name\":\"Wucheng\",\"_id\":1791347,\"coord\":{\"lon\":118.17495,\"lat\":29.600771}},\n" +
           "{\"country\":\"CN\",\"name\":\"Wenling\",\"_id\":1791464,\"coord\":{\"lon\":121.360001,\"lat\":28.36694}},\n" +
           "{\"country\":\"CN\",\"name\":\"Taozhuang\",\"_id\":1793089,\"coord\":{\"lon\":117.333328,\"lat\":34.849998}},\n" +
           "{\"country\":\"CN\",\"name\":\"Tangjiazhuang\",\"_id\":1793385,\"coord\":{\"lon\":118.449997,\"lat\":39.73333}},\n" +
           "{\"country\":\"CN\",\"name\":\"Suozhen\",\"_id\":1793774,\"coord\":{\"lon\":118.104721,\"lat\":36.953892}},\n" +
           "{\"country\":\"CN\",\"name\":\"Shenjiamen\",\"_id\":1795632,\"coord\":{\"lon\":122.298019,\"lat\":29.957621}},\n" +
           "{\"country\":\"CN\",\"name\":\"Shaping\",\"_id\":1795842,\"coord\":{\"lon\":112.95652,\"lat\":22.75452}},\n" +
           "{\"country\":\"CN\",\"name\":\"Shancheng\",\"_id\":1795919,\"coord\":{\"lon\":116.081673,\"lat\":34.79528}},\n" +
           "{\"country\":\"CN\",\"name\":\"Shanghai\",\"_id\":1796236,\"coord\":{\"lon\":121.458061,\"lat\":31.222219}},\n" +
           "{\"country\":\"CN\",\"name\":\"Mingshui\",\"_id\":1800498,\"coord\":{\"lon\":117.5,\"lat\":36.716671}},\n" +
           "{\"country\":\"CN\",\"name\":\"Luoyang\",\"_id\":1801797,\"coord\":{\"lon\":118.681107,\"lat\":24.962219}},\n" +
           "{\"country\":\"CN\",\"name\":\"Linxi\",\"_id\":1803334,\"coord\":{\"lon\":118.433327,\"lat\":39.700001}},\n" +
           "{\"country\":\"CN\",\"name\":\"Juegang\",\"_id\":1804979,\"coord\":{\"lon\":121.185516,\"lat\":32.317371}},\n" +
           "{\"country\":\"CN\",\"name\":\"Huangchuan\",\"_id\":1807553,\"coord\":{\"lon\":115.039436,\"lat\":32.12722}},\n" +
           "{\"country\":\"CN\",\"name\":\"Hecun\",\"_id\":1808747,\"coord\":{\"lon\":114.111107,\"lat\":36.533329}},\n" +
           "{\"country\":\"CN\",\"name\":\"Handan\",\"_id\":1808963,\"coord\":{\"lon\":114.467781,\"lat\":36.600559}},\n" +
           "{\"country\":\"CN\",\"name\":\"Fenyi\",\"_id\":1811114,\"coord\":{\"lon\":114.668053,\"lat\":27.811171}},\n" +
           "{\"country\":\"CN\",\"name\":\"Deqing\",\"_id\":1812981,\"coord\":{\"lon\":119.9599,\"lat\":30.544849}},\n" +
           "{\"country\":\"CN\",\"name\":\"Dancheng\",\"_id\":1813892,\"coord\":{\"lon\":115.183327,\"lat\":33.633331}},\n" +
           "{\"country\":\"CN\",\"name\":\"Chengyang\",\"_id\":1815184,\"coord\":{\"lon\":118.832779,\"lat\":35.579441}},\n" +
           "{\"country\":\"CN\",\"name\":\"Changleng\",\"_id\":1815667,\"coord\":{\"lon\":115.816673,\"lat\":28.700001}},\n" +
           "{\"country\":\"CN\",\"name\":\"Bianzhuang\",\"_id\":1816406,\"coord\":{\"lon\":118.044724,\"lat\":34.84861}},\n" +
           "{\"country\":\"CN\",\"name\":\"Baihe\",\"_id\":1817701,\"coord\":{\"lon\":107.23333,\"lat\":22.15}},\n" +
           "{\"country\":\"CN\",\"name\":\"Linghai\",\"_id\":2037913,\"coord\":{\"lon\":121.366669,\"lat\":41.165279}},\n" +
           "{\"country\":\"CN\",\"name\":\"Boli\",\"_id\":2038274,\"coord\":{\"lon\":130.516663,\"lat\":45.76667}},\n" +
           "{\"country\":\"CO\",\"name\":\"Mompos\",\"_id\":3674597,\"coord\":{\"lon\":-74.426666,\"lat\":9.24194}},\n" +
           "{\"country\":\"CO\",\"name\":\"Malaga\",\"_id\":3675605,\"coord\":{\"lon\":-72.73233,\"lat\":6.69903}},\n" +
           "{\"country\":\"CO\",\"name\":\"Ayapel\",\"_id\":3689381,\"coord\":{\"lon\":-75.139816,\"lat\":8.31372}},\n" +
           "{\"country\":\"CR\",\"name\":\"Tejar\",\"_id\":3621335,\"coord\":{\"lon\":-84.233681,\"lat\":9.74622}},\n" +
           "{\"country\":\"CR\",\"name\":\"Mercedes\",\"_id\":3622881,\"coord\":{\"lon\":-84.133957,\"lat\":10.00696}},\n" +
           "{\"country\":\"CU\",\"name\":\"Provincia Artemisa\",\"_id\":7668824,\"coord\":{\"lon\":-82.756058,\"lat\":22.813999}},\n" +
           "{\"country\":\"CU\",\"name\":\"Rodas\",\"_id\":3541999,\"coord\":{\"lon\":-80.55722,\"lat\":22.34083}},\n" +
           "{\"country\":\"CU\",\"name\":\"Jobabo\",\"_id\":3556077,\"coord\":{\"lon\":-76.299438,\"lat\":20.96917}},\n" +
           "{\"country\":\"CU\",\"name\":\"Guanajay\",\"_id\":3557801,\"coord\":{\"lon\":-82.6875,\"lat\":22.92639}},\n" +
           "{\"country\":\"CU\",\"name\":\"Gibara\",\"_id\":3558315,\"coord\":{\"lon\":-76.131668,\"lat\":21.10972}},\n" +
           "{\"country\":\"CU\",\"name\":\"Baguanos\",\"_id\":3746938,\"coord\":{\"lon\":-76.026939,\"lat\":20.751671}},\n" +
           "{\"country\":\"CZ\",\"name\":\"Otrokovice\",\"_id\":3068690,\"coord\":{\"lon\":17.53944,\"lat\":49.209339}},\n" +
           "{\"country\":\"CZ\",\"name\":\"Hodonin\",\"_id\":3075654,\"coord\":{\"lon\":17.132441,\"lat\":48.84893}},\n" +
           "{\"country\":\"CZ\",\"name\":\"Bilina Kyselka\",\"_id\":3079346,\"coord\":{\"lon\":13.76667,\"lat\":50.549999}},\n" +
           "{\"country\":\"CZ\",\"name\":\"Bilina\",\"_id\":3079348,\"coord\":{\"lon\":13.77535,\"lat\":50.548538}},\n" +
           "{\"country\":\"DE\",\"name\":\"Wardenburg\",\"_id\":2814146,\"coord\":{\"lon\":8.2,\"lat\":53.066669}},\n" +
           "{\"country\":\"DE\",\"name\":\"Stellingen\",\"_id\":2827552,\"coord\":{\"lon\":9.9287,\"lat\":53.592201}},\n" +
           "{\"country\":\"DE\",\"name\":\"Senden\",\"_id\":2833080,\"coord\":{\"lon\":10.04442,\"lat\":48.324409}},\n" +
           "{\"country\":\"DE\",\"name\":\"Schwanewede\",\"_id\":2835260,\"coord\":{\"lon\":8.6,\"lat\":53.23333}},\n" +
           "{\"country\":\"DE\",\"name\":\"Porta Westfalica\",\"_id\":2852577,\"coord\":{\"lon\":8.91901,\"lat\":52.237789}},\n" +
           "{\"country\":\"DE\",\"name\":\"Pfaffenhofen an der Ilm\",\"_id\":2854386,\"coord\":{\"lon\":11.51667,\"lat\":48.533329}},\n" +
           "{\"country\":\"DE\",\"name\":\"Nauen\",\"_id\":2866930,\"coord\":{\"lon\":12.87374,\"lat\":52.60701}},\n" +
           "{\"country\":\"DE\",\"name\":\"Lilienthal\",\"_id\":2877709,\"coord\":{\"lon\":8.91667,\"lat\":53.133331}},\n" +
           "{\"country\":\"DE\",\"name\":\"Leichlingen\",\"_id\":2879315,\"coord\":{\"lon\":7.01667,\"lat\":51.116669}},\n" +
           "{\"country\":\"DE\",\"name\":\"Leer\",\"_id\":2879697,\"coord\":{\"lon\":7.461,\"lat\":53.231571}},\n" +
           "{\"country\":\"DE\",\"name\":\"Idar-Oberstein\",\"_id\":2896753,\"coord\":{\"lon\":7.3,\"lat\":49.700001}},\n" +
           "{\"country\":\"DE\",\"name\":\"Hille\",\"_id\":2904725,\"coord\":{\"lon\":8.75,\"lat\":52.333328}},\n" +
           "{\"country\":\"DE\",\"name\":\"Haltern\",\"_id\":2911395,\"coord\":{\"lon\":7.18163,\"lat\":51.74297}},\n" +
           "{\"country\":\"DE\",\"name\":\"Giengen an der Brenz\",\"_id\":2920620,\"coord\":{\"lon\":10.24312,\"lat\":48.622189}},\n" +
           "{\"country\":\"DE\",\"name\":\"Engelskirchen\",\"_id\":2930216,\"coord\":{\"lon\":7.4,\"lat\":50.98333}},\n" +
           "{\"country\":\"DE\",\"name\":\"Edewecht\",\"_id\":2933364,\"coord\":{\"lon\":7.98333,\"lat\":53.133331}},\n" +
           "{\"country\":\"DE\",\"name\":\"Delbruck\",\"_id\":2938389,\"coord\":{\"lon\":8.56667,\"lat\":51.76667}},\n" +
           "{\"country\":\"DE\",\"name\":\"Cuxhaven\",\"_id\":2939658,\"coord\":{\"lon\":8.69087,\"lat\":53.871761}},\n" +
           "{\"country\":\"DE\",\"name\":\"Crailsheim\",\"_id\":2939797,\"coord\":{\"lon\":10.07193,\"lat\":49.134441}},\n" +
           "{\"country\":\"DE\",\"name\":\"Blomberg\",\"_id\":2947641,\"coord\":{\"lon\":9.09067,\"lat\":51.94331}},\n" +
           "{\"country\":\"DE\",\"name\":\"Bahnhof Lohne\",\"_id\":2953269,\"coord\":{\"lon\":8.71667,\"lat\":52.200001}},\n" +
           "{\"country\":\"DE\",\"name\":\"Bad Zwischenahn\",\"_id\":2953310,\"coord\":{\"lon\":8,\"lat\":53.183331}},\n" +
           "{\"country\":\"DE\",\"name\":\"Apolda\",\"_id\":2955770,\"coord\":{\"lon\":11.5,\"lat\":51.01667}},\n" +
           "{\"country\":\"DE\",\"name\":\"Altdorf\",\"_id\":2958024,\"coord\":{\"lon\":11.35722,\"lat\":49.387501}},\n" +
           "{\"country\":\"DE\",\"name\":\"Ostfildern\",\"_id\":3336892,\"coord\":{\"lon\":9.24954,\"lat\":48.727039}},\n" +
           "{\"country\":\"DK\",\"name\":\"Naestved\",\"_id\":2616038,\"coord\":{\"lon\":11.76092,\"lat\":55.229919}},\n" +
           "{\"country\":\"DO\",\"name\":\"Cotui\",\"_id\":3509207,\"coord\":{\"lon\":-70.149391,\"lat\":19.052719}},\n" +
           "{\"country\":\"DO\",\"name\":\"Constanza\",\"_id\":3509363,\"coord\":{\"lon\":-70.744987,\"lat\":18.909189}},\n" +
           "{\"country\":\"DO\",\"name\":\"Concepcion de La Vega\",\"_id\":3509382,\"coord\":{\"lon\":-70.529556,\"lat\":19.222071}},\n" +
           "{\"country\":\"DO\",\"name\":\"Bani\",\"_id\":3512067,\"coord\":{\"lon\":-70.333328,\"lat\":18.283331}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ouargla\",\"_id\":2485801,\"coord\":{\"lon\":5.32502,\"lat\":31.94932}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Mila\",\"_id\":2487452,\"coord\":{\"lon\":6.26444,\"lat\":36.450279}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Mazouna\",\"_id\":2489987,\"coord\":{\"lon\":0.89865,\"lat\":36.122318}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Mansourah\",\"_id\":2490180,\"coord\":{\"lon\":4.45192,\"lat\":36.08725}},\n" +
           "{\"country\":\"DZ\",\"name\":\"LArbaa Nait Irathen\",\"_id\":2491042,\"coord\":{\"lon\":4.19864,\"lat\":36.631119}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ighram\",\"_id\":2493605,\"coord\":{\"lon\":4.50532,\"lat\":36.462952}},\n" +
           "{\"country\":\"DZ\",\"name\":\"El Achir\",\"_id\":2498766,\"coord\":{\"lon\":4.62744,\"lat\":36.063862}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Draa Ben Khedda\",\"_id\":2499116,\"coord\":{\"lon\":3.96223,\"lat\":36.73436}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Chetouane\",\"_id\":2501362,\"coord\":{\"lon\":-1.29512,\"lat\":34.921291}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Cheraga\",\"_id\":2501465,\"coord\":{\"lon\":2.95924,\"lat\":36.76775}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Chemini\",\"_id\":2501508,\"coord\":{\"lon\":4.61667,\"lat\":36.599998}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Chebli\",\"_id\":2501680,\"coord\":{\"lon\":3.00917,\"lat\":36.577221}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Chabet el Ameur\",\"_id\":2501873,\"coord\":{\"lon\":3.69474,\"lat\":36.637089}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Bou Ismail\",\"_id\":2502939,\"coord\":{\"lon\":2.69007,\"lat\":36.64262}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Bordj Zemoura\",\"_id\":2503620,\"coord\":{\"lon\":4.85668,\"lat\":36.27462}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Birkhadem\",\"_id\":2503847,\"coord\":{\"lon\":3.05002,\"lat\":36.714989}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Birine\",\"_id\":2503852,\"coord\":{\"lon\":3.225,\"lat\":35.634998}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Bir el Djir\",\"_id\":2503874,\"coord\":{\"lon\":-0.545,\"lat\":35.720001}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Bir el Ater\",\"_id\":2503878,\"coord\":{\"lon\":8.06024,\"lat\":34.744881}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Beni Mester\",\"_id\":2504616,\"coord\":{\"lon\":-1.42319,\"lat\":34.870449}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Beni Mered\",\"_id\":2504622,\"coord\":{\"lon\":2.86131,\"lat\":36.523891}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Beni Douala\",\"_id\":2504703,\"coord\":{\"lon\":4.08282,\"lat\":36.619541}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Bejaia\",\"_id\":2505329,\"coord\":{\"lon\":5.08433,\"lat\":36.755871}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Barbacha\",\"_id\":2505651,\"coord\":{\"lon\":4.96667,\"lat\":36.566669}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Baraki\",\"_id\":2505653,\"coord\":{\"lon\":3.09606,\"lat\":36.66655}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Bab Ezzouar\",\"_id\":2505854,\"coord\":{\"lon\":3.18291,\"lat\":36.726151}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Azazga\",\"_id\":2506043,\"coord\":{\"lon\":4.37222,\"lat\":36.74472}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Arhribs\",\"_id\":2506519,\"coord\":{\"lon\":4.31158,\"lat\":36.79361}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ammi Moussa\",\"_id\":2507155,\"coord\":{\"lon\":1.11143,\"lat\":35.867809}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Amizour\",\"_id\":2507169,\"coord\":{\"lon\":4.90131,\"lat\":36.640221}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Akbou\",\"_id\":2507646,\"coord\":{\"lon\":4.53494,\"lat\":36.4575}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain Touta\",\"_id\":2507877,\"coord\":{\"lon\":5.90001,\"lat\":35.376751}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain Taya\",\"_id\":2507912,\"coord\":{\"lon\":3.28694,\"lat\":36.793331}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain Smara\",\"_id\":2507926,\"coord\":{\"lon\":6.50135,\"lat\":36.267399}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain Fakroun\",\"_id\":2508102,\"coord\":{\"lon\":6.87374,\"lat\":35.971081}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain el Turk\",\"_id\":2508119,\"coord\":{\"lon\":-0.7693,\"lat\":35.743809}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain el Hammam\",\"_id\":2508152,\"coord\":{\"lon\":4.30619,\"lat\":36.564709}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain el Hadjel\",\"_id\":2508157,\"coord\":{\"lon\":3.88153,\"lat\":35.670029}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Ain Beida\",\"_id\":2508287,\"coord\":{\"lon\":7.39278,\"lat\":35.796391}},\n" +
           "{\"country\":\"DZ\",\"name\":\"Abou el Hassan\",\"_id\":2509031,\"coord\":{\"lon\":1.19616,\"lat\":36.416569}},\n" +
           "{\"country\":\"EC\",\"name\":\"Manta\",\"_id\":3654410,\"coord\":{\"lon\":-80.73333,\"lat\":-0.95}},\n" +
           "{\"country\":\"EG\",\"name\":\"Qalyub\",\"_id\":350789,\"coord\":{\"lon\":31.205601,\"lat\":30.17922}},\n" +
           "{\"country\":\"EG\",\"name\":\"Halwan\",\"_id\":355795,\"coord\":{\"lon\":31.30084,\"lat\":29.84144}},\n" +
           "{\"country\":\"EG\",\"name\":\"Farshut\",\"_id\":356933,\"coord\":{\"lon\":32.163288,\"lat\":26.054939}},\n" +
           "{\"country\":\"EG\",\"name\":\"Faraskur\",\"_id\":356945,\"coord\":{\"lon\":31.715071,\"lat\":31.329769}},\n" +
           "{\"country\":\"EG\",\"name\":\"Faqus\",\"_id\":356989,\"coord\":{\"lon\":31.801821,\"lat\":30.730061}},\n" +
           "{\"country\":\"EG\",\"name\":\"Diyarb Najm\",\"_id\":358095,\"coord\":{\"lon\":31.439251,\"lat\":30.754219}},\n" +
           "{\"country\":\"EG\",\"name\":\"Disuq\",\"_id\":358108,\"coord\":{\"lon\":30.64649,\"lat\":31.133051}},\n" +
           "{\"country\":\"EG\",\"name\":\"Dishna\",\"_id\":358115,\"coord\":{\"lon\":32.475979,\"lat\":26.12467}},\n" +
           "{\"country\":\"EG\",\"name\":\"Dikirnis\",\"_id\":358172,\"coord\":{\"lon\":31.594271,\"lat\":31.088711}},\n" +
           "{\"country\":\"EG\",\"name\":\"Dayrut\",\"_id\":358269,\"coord\":{\"lon\":30.80764,\"lat\":27.556021}},\n" +
           "{\"country\":\"EG\",\"name\":\"Dayr Mawas\",\"_id\":358274,\"coord\":{\"lon\":30.846621,\"lat\":27.64176}},\n" +
           "{\"country\":\"EG\",\"name\":\"Basyun\",\"_id\":358970,\"coord\":{\"lon\":30.813379,\"lat\":30.93976}},\n" +
           "{\"country\":\"EG\",\"name\":\"Bani Suwayf\",\"_id\":359173,\"coord\":{\"lon\":31.097851,\"lat\":29.074409}},\n" +
           "{\"country\":\"EG\",\"name\":\"Banha\",\"_id\":359280,\"coord\":{\"lon\":31.178579,\"lat\":30.459061}},\n" +
           "{\"country\":\"EG\",\"name\":\"Awsim\",\"_id\":359576,\"coord\":{\"lon\":31.13571,\"lat\":30.12303}},\n" +
           "{\"country\":\"EG\",\"name\":\"At Tall al Kabir\",\"_id\":359710,\"coord\":{\"lon\":31.78525,\"lat\":30.544479}},\n" +
           "{\"country\":\"EG\",\"name\":\"Muḩāfaz̧at as Suways\",\"_id\":359797,\"coord\":{\"lon\":32.299999,\"lat\":29.700001}},\n" +
           "{\"country\":\"EG\",\"name\":\"Ashmun\",\"_id\":360048,\"coord\":{\"lon\":30.976351,\"lat\":30.298571}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Wasitah\",\"_id\":360464,\"coord\":{\"lon\":31.205561,\"lat\":29.33778}},\n" +
           "{\"country\":\"EG\",\"name\":\"Muḩāfaz̧at al Uqşur\",\"_id\":7603259,\"coord\":{\"lon\":32.650002,\"lat\":25.700001}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Qusayr\",\"_id\":360531,\"coord\":{\"lon\":34.277931,\"lat\":26.104259}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Qanayat\",\"_id\":360612,\"coord\":{\"lon\":31.460991,\"lat\":30.618799}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Qanatir al Khayriyah\",\"_id\":360615,\"coord\":{\"lon\":31.13703,\"lat\":30.19327}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Manzilah\",\"_id\":360754,\"coord\":{\"lon\":31.937,\"lat\":31.15815}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Khankah\",\"_id\":360928,\"coord\":{\"lon\":31.36812,\"lat\":30.21035}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Jizah\",\"_id\":360995,\"coord\":{\"lon\":31.21093,\"lat\":30.00808}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Ibrahimiyah\",\"_id\":361103,\"coord\":{\"lon\":31.56299,\"lat\":30.718769}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Hawamidiyah\",\"_id\":361179,\"coord\":{\"lon\":31.25,\"lat\":29.9}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Fashn\",\"_id\":361329,\"coord\":{\"lon\":30.899481,\"lat\":28.82431}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Bawiti\",\"_id\":361394,\"coord\":{\"lon\":28.86591,\"lat\":28.34919}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Balyana\",\"_id\":361435,\"coord\":{\"lon\":32.003471,\"lat\":26.23568}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Bajur\",\"_id\":361457,\"coord\":{\"lon\":31.03681,\"lat\":30.43026}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Badari\",\"_id\":361478,\"coord\":{\"lon\":31.415541,\"lat\":26.992571}},\n" +
           "{\"country\":\"EG\",\"name\":\"Al Arish\",\"_id\":361546,\"coord\":{\"lon\":33.798439,\"lat\":31.13159}},\n" +
           "{\"country\":\"EG\",\"name\":\"Akhmim\",\"_id\":361661,\"coord\":{\"lon\":31.745029,\"lat\":26.56217}},\n" +
           "{\"country\":\"EG\",\"name\":\"Aja\",\"_id\":361702,\"coord\":{\"lon\":31.29151,\"lat\":30.94154}},\n" +
           "{\"country\":\"EG\",\"name\":\"Ad Dilinjat\",\"_id\":361827,\"coord\":{\"lon\":30.536329,\"lat\":30.827909}},\n" +
           "{\"country\":\"EG\",\"name\":\"Abu Qurqas\",\"_id\":362277,\"coord\":{\"lon\":30.838409,\"lat\":27.9312}},\n" +
           "{\"country\":\"EG\",\"name\":\"Abu Kabir\",\"_id\":362485,\"coord\":{\"lon\":31.67148,\"lat\":30.72508}},\n" +
           "{\"country\":\"EG\",\"name\":\"Abnub\",\"_id\":362973,\"coord\":{\"lon\":31.151051,\"lat\":27.2696}},\n" +
           "{\"country\":\"EG\",\"name\":\"Az Zarqa\",\"_id\":419435,\"coord\":{\"lon\":31.63554,\"lat\":31.20829}},\n" +
           "{\"country\":\"EG\",\"name\":\"Ain Sukhna\",\"_id\":7521348,\"coord\":{\"lon\":32.316711,\"lat\":29.60018}},\n" +
           "{\"country\":\"EH\",\"name\":\"Smara\",\"_id\":2461874,\"coord\":{\"lon\":-11.67194,\"lat\":26.738411}},\n" +
           "{\"country\":\"ER\",\"name\":\"Zoba Ānseba\",\"_id\":448497,\"coord\":{\"lon\":37.5,\"lat\":16.5}},\n" +
           "{\"country\":\"ER\",\"name\":\"Keren\",\"_id\":333287,\"coord\":{\"lon\":38.458061,\"lat\":15.77778}},\n" +
           "{\"country\":\"ER\",\"name\":\"Barentu\",\"_id\":342711,\"coord\":{\"lon\":37.592781,\"lat\":15.11389}},\n" +
           "{\"country\":\"ER\",\"name\":\"Zoba Debubawī K’eyih Bahrī\",\"_id\":448499,\"coord\":{\"lon\":41.5,\"lat\":13.75}},\n" +
           "{\"country\":\"ES\",\"name\":\"Zafra\",\"_id\":2509377,\"coord\":{\"lon\":-6.41667,\"lat\":38.416672}},\n" +
           "{\"country\":\"ES\",\"name\":\"Vila-real\",\"_id\":2509509,\"coord\":{\"lon\":-0.1,\"lat\":39.933331}},\n" +
           "{\"country\":\"ES\",\"name\":\"Tomelloso\",\"_id\":2510392,\"coord\":{\"lon\":-3.02431,\"lat\":39.15218}},\n" +
           "{\"country\":\"ES\",\"name\":\"Santa Cruz de la Palma\",\"_id\":2511180,\"coord\":{\"lon\":-17.76421,\"lat\":28.68351}},\n" +
           "{\"country\":\"ES\",\"name\":\"Picassent\",\"_id\":2512620,\"coord\":{\"lon\":-0.45,\"lat\":39.366669}},\n" +
           "{\"country\":\"ES\",\"name\":\"Pajara\",\"_id\":2513026,\"coord\":{\"lon\":-14.1076,\"lat\":28.350389}},\n" +
           "{\"country\":\"ES\",\"name\":\"Los Llanos de Aridane\",\"_id\":2514651,\"coord\":{\"lon\":-17.918209,\"lat\":28.65851}},\n" +
           "{\"country\":\"ES\",\"name\":\"Lora del Rio\",\"_id\":2514893,\"coord\":{\"lon\":-5.52751,\"lat\":37.658958}},\n" +
           "{\"country\":\"ES\",\"name\":\"Lliria\",\"_id\":2515036,\"coord\":{\"lon\":-0.6,\"lat\":39.633331}},\n" +
           "{\"country\":\"ES\",\"name\":\"LEliana\",\"_id\":2516004,\"coord\":{\"lon\":-0.53333,\"lat\":39.566669}},\n" +
           "{\"country\":\"ES\",\"name\":\"Inca\",\"_id\":6533948,\"coord\":{\"lon\":2.90588,\"lat\":39.718681}},\n" +
           "{\"country\":\"ES\",\"name\":\"Fuengirola\",\"_id\":2517595,\"coord\":{\"lon\":-4.62473,\"lat\":36.539982}},\n" +
           "{\"country\":\"ES\",\"name\":\"Denia\",\"_id\":2518878,\"coord\":{\"lon\":0.10574,\"lat\":38.840778}},\n" +
           "{\"country\":\"ES\",\"name\":\"Adra\",\"_id\":2522430,\"coord\":{\"lon\":-3.02055,\"lat\":36.749611}},\n" +
           "{\"country\":\"ES\",\"name\":\"Tolosa\",\"_id\":3108008,\"coord\":{\"lon\":-2.07801,\"lat\":43.134838}},\n" +
           "{\"country\":\"ES\",\"name\":\"La Pineda\",\"_id\":3119231,\"coord\":{\"lon\":1.18515,\"lat\":41.076248}},\n" +
           "{\"country\":\"ES\",\"name\":\"Gernika-Lumo\",\"_id\":3120989,\"coord\":{\"lon\":-2.68333,\"lat\":43.316669}},\n" +
           "{\"country\":\"ES\",\"name\":\"Galdakao\",\"_id\":3121751,\"coord\":{\"lon\":-2.83333,\"lat\":43.23333}},\n" +
           "{\"country\":\"ES\",\"name\":\"El Astillero\",\"_id\":3123667,\"coord\":{\"lon\":-3.82051,\"lat\":43.40094}},\n" +
           "{\"country\":\"ES\",\"name\":\"Durango\",\"_id\":3123773,\"coord\":{\"lon\":-2.6338,\"lat\":43.171242}},\n" +
           "{\"country\":\"ES\",\"name\":\"Camargo\",\"_id\":3126917,\"coord\":{\"lon\":-3.88498,\"lat\":43.40744}},\n" +
           "{\"country\":\"ES\",\"name\":\"Calahorra\",\"_id\":3127065,\"coord\":{\"lon\":-1.96521,\"lat\":42.305061}},\n" +
           "{\"country\":\"ES\",\"name\":\"Benicassim\",\"_id\":3128272,\"coord\":{\"lon\":0.06667,\"lat\":40.049999}},\n" +
           "{\"country\":\"ES\",\"name\":\"Benicarlo\",\"_id\":3128273,\"coord\":{\"lon\":0.42709,\"lat\":40.4165}},\n" +
           "{\"country\":\"ES\",\"name\":\"Benavente\",\"_id\":3128291,\"coord\":{\"lon\":-5.67826,\"lat\":42.002491}},\n" +
           "{\"country\":\"ES\",\"name\":\"Algorta\",\"_id\":3130380,\"coord\":{\"lon\":-3.0094,\"lat\":43.34927}},\n" +
           "{\"country\":\"ES\",\"name\":\"Las Gabias\",\"_id\":6559641,\"coord\":{\"lon\":-3.69765,\"lat\":37.132961}},\n" +
           "{\"country\":\"ES\",\"name\":\"Corvera de Asturias\",\"_id\":7115111,\"coord\":{\"lon\":-5.8691,\"lat\":43.51062}},\n" +
           "{\"country\":\"ET\",\"name\":\"Yabelo\",\"_id\":326036,\"coord\":{\"lon\":38.083328,\"lat\":4.88333}},\n" +
           "{\"country\":\"ET\",\"name\":\"Werota\",\"_id\":326206,\"coord\":{\"lon\":37.700001,\"lat\":11.91667}},\n" +
           "{\"country\":\"ET\",\"name\":\"Wenji\",\"_id\":326308,\"coord\":{\"lon\":39.283329,\"lat\":8.45}},\n" +
           "{\"country\":\"ET\",\"name\":\"Tippi\",\"_id\":327694,\"coord\":{\"lon\":35.450001,\"lat\":7.2}},\n" +
           "{\"country\":\"ET\",\"name\":\"Shashemene\",\"_id\":328689,\"coord\":{\"lon\":38.599998,\"lat\":7.2}},\n" +
           "{\"country\":\"ET\",\"name\":\"Shambu\",\"_id\":328709,\"coord\":{\"lon\":37.099998,\"lat\":9.56667}},\n" +
           "{\"country\":\"ET\",\"name\":\"Shakiso\",\"_id\":328716,\"coord\":{\"lon\":38.916672,\"lat\":5.75}},\n" +
           "{\"country\":\"ET\",\"name\":\"Sebeta\",\"_id\":329114,\"coord\":{\"lon\":38.616669,\"lat\":8.91667}},\n" +
           "{\"country\":\"ET\",\"name\":\"Nejo\",\"_id\":330120,\"coord\":{\"lon\":35.5,\"lat\":9.5}},\n" +
           "{\"country\":\"ET\",\"name\":\"Nazret\",\"_id\":330186,\"coord\":{\"lon\":39.26667,\"lat\":8.55}},\n" +
           "{\"country\":\"ET\",\"name\":\"Mojo\",\"_id\":330491,\"coord\":{\"lon\":39.116669,\"lat\":8.6}},\n" +
           "{\"country\":\"ET\",\"name\":\"Metu\",\"_id\":330764,\"coord\":{\"lon\":35.583328,\"lat\":8.3}},\n" +
           "{\"country\":\"ET\",\"name\":\"Mendi\",\"_id\":331038,\"coord\":{\"lon\":35.099998,\"lat\":9.8}},\n" +
           "{\"country\":\"ET\",\"name\":\"Maychew\",\"_id\":331416,\"coord\":{\"lon\":39.542221,\"lat\":12.7875}},\n" +
           "{\"country\":\"ET\",\"name\":\"Kombolcha\",\"_id\":333373,\"coord\":{\"lon\":39.743389,\"lat\":11.08155}},\n" +
           "{\"country\":\"ET\",\"name\":\"Jinka\",\"_id\":333750,\"coord\":{\"lon\":36.650002,\"lat\":5.65}},\n" +
           "{\"country\":\"ET\",\"name\":\"Inda Silase\",\"_id\":334227,\"coord\":{\"lon\":38.28289,\"lat\":14.10307}},\n" +
           "{\"country\":\"ET\",\"name\":\"Hārarī Hizb Kilil\",\"_id\":444184,\"coord\":{\"lon\":42.166672,\"lat\":9.25}},\n" +
           "{\"country\":\"ET\",\"name\":\"Harer\",\"_id\":335035,\"coord\":{\"lon\":42.125832,\"lat\":9.30944}},\n" +
           "{\"country\":\"ET\",\"name\":\"Gelemso\",\"_id\":337010,\"coord\":{\"lon\":40.51667,\"lat\":8.81667}},\n" +
           "{\"country\":\"ET\",\"name\":\"Gebre Guracha\",\"_id\":337152,\"coord\":{\"lon\":38.400002,\"lat\":9.8}},\n" +
           "{\"country\":\"ET\",\"name\":\"Gambela Regional State\",\"_id\":444183,\"coord\":{\"lon\":34.5,\"lat\":7.83333}},\n" +
           "{\"country\":\"ET\",\"name\":\"Fiche\",\"_id\":337771,\"coord\":{\"lon\":38.73333,\"lat\":9.8}},\n" +
           "{\"country\":\"ET\",\"name\":\"Dila\",\"_id\":338998,\"coord\":{\"lon\":38.316669,\"lat\":6.41667}},\n" +
           "{\"country\":\"ET\",\"name\":\"Debre Zeyit\",\"_id\":339666,\"coord\":{\"lon\":38.98333,\"lat\":8.75}},\n" +
           "{\"country\":\"ET\",\"name\":\"Debre Tabor\",\"_id\":339686,\"coord\":{\"lon\":38.01667,\"lat\":11.85}},\n" +
           "{\"country\":\"ET\",\"name\":\"Bure\",\"_id\":341397,\"coord\":{\"lon\":37.066669,\"lat\":10.7}},\n" +
           "{\"country\":\"ET\",\"name\":\"Boditi\",\"_id\":341877,\"coord\":{\"lon\":37.866669,\"lat\":6.96667}},\n" +
           "{\"country\":\"ET\",\"name\":\"Bichena\",\"_id\":342190,\"coord\":{\"lon\":38.200001,\"lat\":10.45}},\n" +
           "{\"country\":\"ET\",\"name\":\"Bedesa\",\"_id\":342559,\"coord\":{\"lon\":40.783329,\"lat\":8.9}},\n" +
           "{\"country\":\"ET\",\"name\":\"Bedele\",\"_id\":342567,\"coord\":{\"lon\":36.35302,\"lat\":8.456}},\n" +
           "{\"country\":\"ET\",\"name\":\"Asbe Teferi\",\"_id\":343402,\"coord\":{\"lon\":40.866669,\"lat\":9.08333}},\n" +
           "{\"country\":\"ET\",\"name\":\"Adis Zemen\",\"_id\":344923,\"coord\":{\"lon\":37.783329,\"lat\":12.11667}},\n" +
           "{\"country\":\"FI\",\"name\":\"Ylojarvi\",\"_id\":630752,\"coord\":{\"lon\":23.59606,\"lat\":61.55632}},\n" +
           "{\"country\":\"FI\",\"name\":\"Vihti\",\"_id\":631708,\"coord\":{\"lon\":24.33333,\"lat\":60.416672}},\n" +
           "{\"country\":\"FI\",\"name\":\"Lieto\",\"_id\":648056,\"coord\":{\"lon\":22.46176,\"lat\":60.510319}},\n" +
           "{\"country\":\"FI\",\"name\":\"Kuusankoski\",\"_id\":649919,\"coord\":{\"lon\":26.633329,\"lat\":60.900002}},\n" +
           "{\"country\":\"FI\",\"name\":\"Korsholm\",\"_id\":651299,\"coord\":{\"lon\":21.682159,\"lat\":63.114182}},\n" +
           "{\"country\":\"FI\",\"name\":\"Janakkala\",\"_id\":656073,\"coord\":{\"lon\":24.6,\"lat\":60.900002}},\n" +
           "{\"country\":\"FI\",\"name\":\"Haukipudas\",\"_id\":658629,\"coord\":{\"lon\":25.352329,\"lat\":65.176537}},\n" +
           "{\"country\":\"FR\",\"name\":\"Wittenheim\",\"_id\":2967318,\"coord\":{\"lon\":7.33702,\"lat\":47.8078}},\n" +
           "{\"country\":\"FR\",\"name\":\"Vallauris\",\"_id\":2970962,\"coord\":{\"lon\":7.05451,\"lat\":43.57803}},\n" +
           "{\"country\":\"FR\",\"name\":\"Sin-le-Noble\",\"_id\":2974494,\"coord\":{\"lon\":3.13113,\"lat\":50.361591}},\n" +
           "{\"country\":\"FR\",\"name\":\"Sens\",\"_id\":2975050,\"coord\":{\"lon\":3.28333,\"lat\":48.200001}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Priest\",\"_id\":2977356,\"coord\":{\"lon\":4.93892,\"lat\":45.696121}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Pol-sur-Mer\",\"_id\":2977388,\"coord\":{\"lon\":2.33984,\"lat\":51.031158}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Pierre-des-Corps\",\"_id\":6433124,\"coord\":{\"lon\":0.73333,\"lat\":47.383331}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Pierre-des-Corps\",\"_id\":2977491,\"coord\":{\"lon\":0.74849,\"lat\":47.38623}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Maximin-la-Sainte-Baume\",\"_id\":2978100,\"coord\":{\"lon\":5.86219,\"lat\":43.452141}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Martin-dHeres\",\"_id\":2978317,\"coord\":{\"lon\":5.76337,\"lat\":45.165279}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Jean-de-la-Ruelle\",\"_id\":2979316,\"coord\":{\"lon\":1.86483,\"lat\":47.91127}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Jean-de-Braye\",\"_id\":6434714,\"coord\":{\"lon\":1.9718,\"lat\":47.912399}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Jean-de-Braye\",\"_id\":2979341,\"coord\":{\"lon\":1.97705,\"lat\":47.913029}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Fons\",\"_id\":2980097,\"coord\":{\"lon\":4.86057,\"lat\":45.708801}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saintes\",\"_id\":2980340,\"coord\":{\"lon\":-0.63333,\"lat\":45.75}},\n" +
           "{\"country\":\"FR\",\"name\":\"Sainte-Foy-les-Lyon\",\"_id\":2980586,\"coord\":{\"lon\":4.79688,\"lat\":45.736919}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Egreve\",\"_id\":2980636,\"coord\":{\"lon\":5.68333,\"lat\":45.23333}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Die-des-Vosges\",\"_id\":2980827,\"coord\":{\"lon\":6.95,\"lat\":48.283329}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Cyr-sur-Loire\",\"_id\":2980935,\"coord\":{\"lon\":0.66667,\"lat\":47.400002}},\n" +
           "{\"country\":\"FR\",\"name\":\"Saint-Amand-les-Eaux\",\"_id\":2981839,\"coord\":{\"lon\":3.43076,\"lat\":50.447182}},\n" +
           "{\"country\":\"FR\",\"name\":\"Pontivy\",\"_id\":2986160,\"coord\":{\"lon\":-2.98333,\"lat\":48.066669}},\n" +
           "{\"country\":\"FR\",\"name\":\"Ploemeur\",\"_id\":2986732,\"coord\":{\"lon\":-3.43333,\"lat\":47.73333}},\n" +
           "{\"country\":\"FR\",\"name\":\"Pertuis\",\"_id\":2987825,\"coord\":{\"lon\":5.50285,\"lat\":43.69252}},\n" +
           "{\"country\":\"FR\",\"name\":\"Palaiseau\",\"_id\":2988758,\"coord\":{\"lon\":2.25,\"lat\":48.716671}},\n" +
           "{\"country\":\"FR\",\"name\":\"Outreau\",\"_id\":2988936,\"coord\":{\"lon\":1.5897,\"lat\":50.705349}},\n" +
           "{\"country\":\"FR\",\"name\":\"Oullins\",\"_id\":2988998,\"coord\":{\"lon\":4.80382,\"lat\":45.717739}},\n" +
           "{\"country\":\"FR\",\"name\":\"Cherbourg-Octeville\",\"_id\":6614508,\"coord\":{\"lon\":-1.6147,\"lat\":49.638599}},\n" +
           "{\"country\":\"FR\",\"name\":\"Octeville\",\"_id\":2989755,\"coord\":{\"lon\":-1.64349,\"lat\":49.626122}},\n" +
           "{\"country\":\"FR\",\"name\":\"Noyon\",\"_id\":6454450,\"coord\":{\"lon\":3,\"lat\":49.583328}},\n" +
           "{\"country\":\"FR\",\"name\":\"Noyon\",\"_id\":2989877,\"coord\":{\"lon\":3,\"lat\":49.583328}},\n" +
           "{\"country\":\"FR\",\"name\":\"Niort\",\"_id\":2990355,\"coord\":{\"lon\":-0.45877,\"lat\":46.323132}},\n" +
           "{\"country\":\"FR\",\"name\":\"Morlaix\",\"_id\":2991772,\"coord\":{\"lon\":-3.83333,\"lat\":48.583328}},\n" +
           "{\"country\":\"FR\",\"name\":\"Montivilliers\",\"_id\":2992367,\"coord\":{\"lon\":0.18769,\"lat\":49.545181}},\n" +
           "{\"country\":\"FR\",\"name\":\"Montigny-les-Metz\",\"_id\":2992402,\"coord\":{\"lon\":6.15167,\"lat\":49.094349}},\n" +
           "{\"country\":\"FR\",\"name\":\"Millau\",\"_id\":2993875,\"coord\":{\"lon\":3.08333,\"lat\":44.099998}},\n" +
           "{\"country\":\"FR\",\"name\":\"Meyzieu\",\"_id\":2994048,\"coord\":{\"lon\":5,\"lat\":45.76667}},\n" +
           "{\"country\":\"FR\",\"name\":\"Meylan\",\"_id\":2994087,\"coord\":{\"lon\":5.79007,\"lat\":45.219879}},\n" +
           "{\"country\":\"FR\",\"name\":\"Mayenne\",\"_id\":2994935,\"coord\":{\"lon\":-0.61667,\"lat\":48.299999}},\n" +
           "{\"country\":\"FR\",\"name\":\"Mauguio\",\"_id\":2995121,\"coord\":{\"lon\":4.00739,\"lat\":43.618099}},\n" +
           "{\"country\":\"FR\",\"name\":\"Luce\",\"_id\":2997246,\"coord\":{\"lon\":1.46359,\"lat\":48.436901}},\n" +
           "{\"country\":\"FR\",\"name\":\"Louviers\",\"_id\":2997336,\"coord\":{\"lon\":1.16667,\"lat\":49.216671}},\n" +
           "{\"country\":\"FR\",\"name\":\"Lingolsheim\",\"_id\":6441200,\"coord\":{\"lon\":7.68253,\"lat\":48.55838}},\n" +
           "{\"country\":\"FR\",\"name\":\"Les Herbiers\",\"_id\":3000648,\"coord\":{\"lon\":-1.01667,\"lat\":46.866669}},\n" +
           "{\"country\":\"FR\",\"name\":\"Le Puy-en-Velay\",\"_id\":3002465,\"coord\":{\"lon\":3.88523,\"lat\":45.043659}},\n" +
           "{\"country\":\"FR\",\"name\":\"Le Pontet\",\"_id\":3002570,\"coord\":{\"lon\":4.86008,\"lat\":43.961189}},\n" +
           "{\"country\":\"FR\",\"name\":\"Le Bouscat\",\"_id\":3005066,\"coord\":{\"lon\":-0.59411,\"lat\":44.866001}},\n" +
           "{\"country\":\"FR\",\"name\":\"Lattes\",\"_id\":3006121,\"coord\":{\"lon\":3.9046,\"lat\":43.56752}},\n" +
           "{\"country\":\"FR\",\"name\":\"Lanester\",\"_id\":3007794,\"coord\":{\"lon\":-3.33965,\"lat\":47.761318}},\n" +
           "{\"country\":\"FR\",\"name\":\"La Crau\",\"_id\":3009791,\"coord\":{\"lon\":6.07425,\"lat\":43.149811}},\n" +
           "{\"country\":\"FR\",\"name\":\"La Chapelle-sur-Erdre\",\"_id\":3010237,\"coord\":{\"lon\":-1.55309,\"lat\":47.295841}},\n" +
           "{\"country\":\"FR\",\"name\":\"Hautmont\",\"_id\":3013681,\"coord\":{\"lon\":3.92143,\"lat\":50.250771}},\n" +
           "{\"country\":\"FR\",\"name\":\"Fleury-les-Aubrais\",\"_id\":6434601,\"coord\":{\"lon\":1.91667,\"lat\":47.933331}},\n" +
           "{\"country\":\"FR\",\"name\":\"Firminy\",\"_id\":3018455,\"coord\":{\"lon\":4.29074,\"lat\":45.387321}},\n" +
           "{\"country\":\"FR\",\"name\":\"Dole\",\"_id\":3021263,\"coord\":{\"lon\":5.5,\"lat\":47.099998}},\n" +
           "{\"country\":\"FR\",\"name\":\"Cran-Gevrier\",\"_id\":3022700,\"coord\":{\"lon\":6.1,\"lat\":45.900002}},\n" +
           "{\"country\":\"FR\",\"name\":\"Coulommiers\",\"_id\":3023240,\"coord\":{\"lon\":3.08498,\"lat\":48.81451}},\n" +
           "{\"country\":\"FR\",\"name\":\"Coueron\",\"_id\":3023324,\"coord\":{\"lon\":-1.72171,\"lat\":47.21508}},\n" +
           "{\"country\":\"FR\",\"name\":\"Coudekerque-Branche\",\"_id\":3023356,\"coord\":{\"lon\":2.39359,\"lat\":51.022881}},\n" +
           "{\"country\":\"FR\",\"name\":\"Chatellerault\",\"_id\":3026141,\"coord\":{\"lon\":0.53333,\"lat\":46.799999}},\n" +
           "{\"country\":\"FR\",\"name\":\"Cesson-Sevigne\",\"_id\":3027767,\"coord\":{\"lon\":-1.603,\"lat\":48.121201}},\n" +
           "{\"country\":\"FR\",\"name\":\"Cavaillon\",\"_id\":3028134,\"coord\":{\"lon\":5.03586,\"lat\":43.831249}},\n" +
           "{\"country\":\"FR\",\"name\":\"Carvin\",\"_id\":3028486,\"coord\":{\"lon\":2.95815,\"lat\":50.492352}},\n" +
           "{\"country\":\"FR\",\"name\":\"Carquefou\",\"_id\":3028535,\"coord\":{\"lon\":-1.49024,\"lat\":47.298222}},\n" +
           "{\"country\":\"FR\",\"name\":\"Canteleu\",\"_id\":3028779,\"coord\":{\"lon\":1.02459,\"lat\":49.440651}},\n" +
           "{\"country\":\"FR\",\"name\":\"Bruay-la-Buissiere\",\"_id\":3029825,\"coord\":{\"lon\":2.55,\"lat\":50.48333}},\n" +
           "{\"country\":\"FR\",\"name\":\"Bourg-les-Valence\",\"_id\":3030985,\"coord\":{\"lon\":4.91023,\"lat\":44.956009}},\n" +
           "{\"country\":\"GB\",\"name\":\"Yate\",\"_id\":2633406,\"coord\":{\"lon\":-2.41839,\"lat\":51.540741}},\n" +
           "{\"country\":\"GB\",\"name\":\"Worksop\",\"_id\":2633551,\"coord\":{\"lon\":-1.12404,\"lat\":53.301819}},\n" +
           "{\"country\":\"GB\",\"name\":\"Spennymoor\",\"_id\":2637235,\"coord\":{\"lon\":-1.60229,\"lat\":54.698799}},\n" +
           "{\"country\":\"GB\",\"name\":\"Spalding\",\"_id\":2637265,\"coord\":{\"lon\":-0.15141,\"lat\":52.78709}},\n" +
           "{\"country\":\"GB\",\"name\":\"South Shields\",\"_id\":2637329,\"coord\":{\"lon\":-1.4323,\"lat\":54.998589}},\n" +
           "{\"country\":\"GB\",\"name\":\"Scarborough\",\"_id\":2638419,\"coord\":{\"lon\":-0.40443,\"lat\":54.279659}},\n" +
           "{\"country\":\"GB\",\"name\":\"Ripon\",\"_id\":2639323,\"coord\":{\"lon\":-1.52122,\"lat\":54.135208}},\n" +
           "{\"country\":\"GB\",\"name\":\"Ripley\",\"_id\":2639325,\"coord\":{\"lon\":-1.4,\"lat\":53.033329}},\n" +
           "{\"country\":\"GB\",\"name\":\"Rawmarsh\",\"_id\":2639588,\"coord\":{\"lon\":-1.34437,\"lat\":53.460621}},\n" +
           "{\"country\":\"GB\",\"name\":\"Porthcawl\",\"_id\":2640054,\"coord\":{\"lon\":-3.70362,\"lat\":51.479031}},\n" +
           "{\"country\":\"GB\",\"name\":\"Musselburgh\",\"_id\":2641942,\"coord\":{\"lon\":-3.04991,\"lat\":55.9417}},\n" +
           "{\"country\":\"GB\",\"name\":\"Morley\",\"_id\":2642189,\"coord\":{\"lon\":-1.59877,\"lat\":53.740131}},\n" +
           "{\"country\":\"GB\",\"name\":\"Melton Mowbray\",\"_id\":2642763,\"coord\":{\"lon\":-0.88693,\"lat\":52.765881}},\n" +
           "{\"country\":\"GB\",\"name\":\"Maesteg\",\"_id\":2643218,\"coord\":{\"lon\":-3.65823,\"lat\":51.609261}},\n" +
           "{\"country\":\"GB\",\"name\":\"Macclesfield\",\"_id\":2643266,\"coord\":{\"lon\":-2.12564,\"lat\":53.260231}},\n" +
           "{\"country\":\"GB\",\"name\":\"Litherland\",\"_id\":2644386,\"coord\":{\"lon\":-2.99809,\"lat\":53.469929}},\n" +
           "{\"country\":\"GB\",\"name\":\"Kingswinford\",\"_id\":2645420,\"coord\":{\"lon\":-2.16889,\"lat\":52.497551}},\n" +
           "{\"country\":\"GB\",\"name\":\"Hebburn\",\"_id\":2647209,\"coord\":{\"lon\":-1.51546,\"lat\":54.973019}},\n" +
           "{\"country\":\"GB\",\"name\":\"Guisborough\",\"_id\":2647785,\"coord\":{\"lon\":-1.05606,\"lat\":54.534779}},\n" +
           "{\"country\":\"GB\",\"name\":\"Grangemouth\",\"_id\":2648215,\"coord\":{\"lon\":-3.72183,\"lat\":56.01141}},\n" +
           "{\"country\":\"GB\",\"name\":\"Gainsborough\",\"_id\":2648945,\"coord\":{\"lon\":-0.76667,\"lat\":53.383331}},\n" +
           "{\"country\":\"GB\",\"name\":\"Eastwood\",\"_id\":2650309,\"coord\":{\"lon\":-1.3,\"lat\":53}},\n" +
           "{\"country\":\"GB\",\"name\":\"East Kilbride\",\"_id\":2650405,\"coord\":{\"lon\":-4.16667,\"lat\":55.76667}},\n" +
           "{\"country\":\"GB\",\"name\":\"Cumbernauld\",\"_id\":2651715,\"coord\":{\"lon\":-3.99051,\"lat\":55.94685}},\n" +
           "{\"country\":\"GB\",\"name\":\"Cramlington\",\"_id\":2652095,\"coord\":{\"lon\":-1.58598,\"lat\":55.086521}},\n" +
           "{\"country\":\"GB\",\"name\":\"Colwyn Bay\",\"_id\":2652513,\"coord\":{\"lon\":-3.72674,\"lat\":53.29483}},\n" +
           "{\"country\":\"GB\",\"name\":\"Coity\",\"_id\":2652622,\"coord\":{\"lon\":-3.55531,\"lat\":51.521999}},\n" +
           "{\"country\":\"GB\",\"name\":\"Coatbridge\",\"_id\":2652696,\"coord\":{\"lon\":-4.02469,\"lat\":55.86216}},\n" +
           "{\"country\":\"GB\",\"name\":\"Cleethorpes\",\"_id\":2652885,\"coord\":{\"lon\":-0.03225,\"lat\":53.560471}},\n" +
           "{\"country\":\"GB\",\"name\":\"Clacton-on-Sea\",\"_id\":2652974,\"coord\":{\"lon\":1.15597,\"lat\":51.789669}},\n" +
           "{\"country\":\"GB\",\"name\":\"Brierley Hill\",\"_id\":2654724,\"coord\":{\"lon\":-2.12139,\"lat\":52.481731}},\n" +
           "{\"country\":\"GB\",\"name\":\"Bentley\",\"_id\":2655882,\"coord\":{\"lon\":-1.15,\"lat\":53.533329}},\n" +
           "{\"country\":\"GB\",\"name\":\"Baildon\",\"_id\":2656627,\"coord\":{\"lon\":-1.78785,\"lat\":53.847111}},\n" +
           "{\"country\":\"GB\",\"name\":\"Ayr\",\"_id\":2656708,\"coord\":{\"lon\":-4.63393,\"lat\":55.46273}},\n" +
           "{\"country\":\"GB\",\"name\":\"Arnold\",\"_id\":2657030,\"coord\":{\"lon\":-1.13333,\"lat\":53}},\n" +
           "{\"country\":\"GB\",\"name\":\"Airdrie\",\"_id\":2657613,\"coord\":{\"lon\":-3.98025,\"lat\":55.86602}},\n" +
           "{\"country\":\"GB\",\"name\":\"Camden\",\"_id\":3333138,\"coord\":{\"lon\":-0.15942,\"lat\":51.542809}},\n" +
           "{\"country\":\"GB\",\"name\":\"Lewisham\",\"_id\":3333166,\"coord\":{\"lon\":-0.018,\"lat\":51.453548}},\n" +
           "{\"country\":\"GE\",\"name\":\"Telavi\",\"_id\":611694,\"coord\":{\"lon\":45.473148,\"lat\":41.919781}},\n" +
           "{\"country\":\"GE\",\"name\":\"Gori\",\"_id\":614455,\"coord\":{\"lon\":44.11578,\"lat\":41.984219}},\n" +
           "{\"country\":\"GR\",\"name\":\"Argos\",\"_id\":264670,\"coord\":{\"lon\":22.73333,\"lat\":37.633331}},\n" +
           "{\"country\":\"GR\",\"name\":\"Peraia\",\"_id\":734712,\"coord\":{\"lon\":22.924999,\"lat\":40.500278}},\n" +
           "{\"country\":\"GT\",\"name\":\"Chichicastenango\",\"_id\":3598655,\"coord\":{\"lon\":-91.116669,\"lat\":14.93333}},\n" +
           "{\"country\":\"HN\",\"name\":\"La Ceiba\",\"_id\":3608248,\"coord\":{\"lon\":-86.782211,\"lat\":15.75971}},\n" +
           "{\"country\":\"HR\",\"name\":\"Virovitica\",\"_id\":3187694,\"coord\":{\"lon\":17.38389,\"lat\":45.83194}},\n" +
           "{\"country\":\"HU\",\"name\":\"Szarvas\",\"_id\":715466,\"coord\":{\"lon\":20.549999,\"lat\":46.866669}},\n" +
           "{\"country\":\"HU\",\"name\":\"Gyula\",\"_id\":720334,\"coord\":{\"lon\":21.283331,\"lat\":46.650002}},\n" +
           "{\"country\":\"HU\",\"name\":\"Gyomaendrod\",\"_id\":720364,\"coord\":{\"lon\":20.83333,\"lat\":46.933331}},\n" +
           "{\"country\":\"HU\",\"name\":\"Vac\",\"_id\":3043293,\"coord\":{\"lon\":19.13612,\"lat\":47.775909}},\n" +
           "{\"country\":\"HU\",\"name\":\"Tata\",\"_id\":3044083,\"coord\":{\"lon\":18.31838,\"lat\":47.652889}},\n" +
           "{\"country\":\"HU\",\"name\":\"Szigetszentmiklos\",\"_id\":3044475,\"coord\":{\"lon\":19.04335,\"lat\":47.343819}},\n" +
           "{\"country\":\"HU\",\"name\":\"Paks\",\"_id\":3046768,\"coord\":{\"lon\":18.859619,\"lat\":46.62648}},\n" +
           "{\"country\":\"HU\",\"name\":\"Nagykoros\",\"_id\":3047651,\"coord\":{\"lon\":19.77857,\"lat\":47.034191}},\n" +
           "{\"country\":\"HU\",\"name\":\"Godollo\",\"_id\":3052236,\"coord\":{\"lon\":19.35515,\"lat\":47.596569}},\n" +
           "{\"country\":\"HU\",\"name\":\"God\",\"_id\":3052241,\"coord\":{\"lon\":19.134171,\"lat\":47.683239}},\n" +
           "{\"country\":\"HU\",\"name\":\"Dabas\",\"_id\":3053836,\"coord\":{\"lon\":19.310909,\"lat\":47.18594}},\n" +
           "{\"country\":\"HU\",\"name\":\"Baja\",\"_id\":3055685,\"coord\":{\"lon\":18.95639,\"lat\":46.174961}},\n" +
           "{\"country\":\"HU\",\"name\":\"Ajka\",\"_id\":3056357,\"coord\":{\"lon\":17.55892,\"lat\":47.101959}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XI. keruelet\",\"_id\":7284824,\"coord\":{\"lon\":19.036051,\"lat\":47.476028}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest IX. keruelet\",\"_id\":7284825,\"coord\":{\"lon\":19.06591,\"lat\":47.48299}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest VIII. keruelet\",\"_id\":7284826,\"coord\":{\"lon\":19.07012,\"lat\":47.489189}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest VII. keruelet\",\"_id\":7284827,\"coord\":{\"lon\":19.06875,\"lat\":47.50045}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest VI. keruelet\",\"_id\":7284828,\"coord\":{\"lon\":19.06583,\"lat\":47.503689}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XIV. keruelet\",\"_id\":7284829,\"coord\":{\"lon\":19.107889,\"lat\":47.518299}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XIII. keruelet\",\"_id\":7284830,\"coord\":{\"lon\":19.080681,\"lat\":47.529781}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest IV. keruelet\",\"_id\":7284831,\"coord\":{\"lon\":19.08909,\"lat\":47.561821}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XV. keruelet\",\"_id\":7284832,\"coord\":{\"lon\":19.11681,\"lat\":47.56263}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XVI. keruelet\",\"_id\":7284833,\"coord\":{\"lon\":19.17028,\"lat\":47.51482}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest X. keruelet\",\"_id\":7284834,\"coord\":{\"lon\":19.15835,\"lat\":47.479099}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XIX. keruelet\",\"_id\":7284835,\"coord\":{\"lon\":19.149429,\"lat\":47.45293}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XVIII. keruelet\",\"_id\":7284836,\"coord\":{\"lon\":19.175949,\"lat\":47.444172}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XXIII. keruelet\",\"_id\":7284837,\"coord\":{\"lon\":19.11492,\"lat\":47.397881}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XXII. keruelet\",\"_id\":7284838,\"coord\":{\"lon\":19.040159,\"lat\":47.426979}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XXI. keruelet\",\"_id\":7284839,\"coord\":{\"lon\":19.07098,\"lat\":47.43047}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XX. keruelet\",\"_id\":7284840,\"coord\":{\"lon\":19.100929,\"lat\":47.436741}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest XVII. keruelet\",\"_id\":7284841,\"coord\":{\"lon\":19.25388,\"lat\":47.479969}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest III. keruelet\",\"_id\":7284842,\"coord\":{\"lon\":19.04501,\"lat\":47.541569}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest II. keruelet\",\"_id\":7284843,\"coord\":{\"lon\":19.031839,\"lat\":47.512909}},\n" +
           "{\"country\":\"HU\",\"name\":\"Budapest I. keruelet\",\"_id\":7284844,\"coord\":{\"lon\":19.03961,\"lat\":47.497051}},\n" +
           "{\"country\":\"ID\",\"name\":\"Stabat\",\"_id\":1213655,\"coord\":{\"lon\":98.451302,\"lat\":3.761}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sibolga\",\"_id\":1213855,\"coord\":{\"lon\":98.779198,\"lat\":1.7427}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pangkalan Brandan\",\"_id\":1214302,\"coord\":{\"lon\":98.278198,\"lat\":4.0238}},\n" +
           "{\"country\":\"ID\",\"name\":\"Meulaboh\",\"_id\":1214488,\"coord\":{\"lon\":96.128502,\"lat\":4.1363}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lhokseumawe\",\"_id\":1214658,\"coord\":{\"lon\":97.150703,\"lat\":5.1801}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kisaran\",\"_id\":1214882,\"coord\":{\"lon\":99.615799,\"lat\":2.9845}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kabanjahe\",\"_id\":1214965,\"coord\":{\"lon\":98.490799,\"lat\":3.1001}},\n" +
           "{\"country\":\"ID\",\"name\":\"Binjai\",\"_id\":1215355,\"coord\":{\"lon\":98.485397,\"lat\":3.6001}},\n" +
           "{\"country\":\"ID\",\"name\":\"Belawan\",\"_id\":1215412,\"coord\":{\"lon\":98.683197,\"lat\":3.7755}},\n" +
           "{\"country\":\"ID\",\"name\":\"Wongsorejo\",\"_id\":1621439,\"coord\":{\"lon\":114.400902,\"lat\":-7.9908}},\n" +
           "{\"country\":\"ID\",\"name\":\"Weleri\",\"_id\":1621655,\"coord\":{\"lon\":110.066597,\"lat\":-6.9713}},\n" +
           "{\"country\":\"ID\",\"name\":\"Watampone\",\"_id\":1621884,\"coord\":{\"lon\":120.327904,\"lat\":-4.5386}},\n" +
           "{\"country\":\"ID\",\"name\":\"Wanaraja\",\"_id\":1622138,\"coord\":{\"lon\":107.980797,\"lat\":-7.1749}},\n" +
           "{\"country\":\"ID\",\"name\":\"Waingapu\",\"_id\":1622318,\"coord\":{\"lon\":120.264099,\"lat\":-9.6567}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ubud\",\"_id\":1622846,\"coord\":{\"lon\":115.265404,\"lat\":-8.5098}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tulangan Utara\",\"_id\":1623096,\"coord\":{\"lon\":112.650497,\"lat\":-7.4737}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tuban\",\"_id\":1623180,\"coord\":{\"lon\":112.064903,\"lat\":-6.8976}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tual\",\"_id\":1623197,\"coord\":{\"lon\":132.75,\"lat\":-5.66667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Trucuk\",\"_id\":1623223,\"coord\":{\"lon\":110.65889,\"lat\":-7.71833}},\n" +
           "{\"country\":\"ID\",\"name\":\"Trenggalek\",\"_id\":1623251,\"coord\":{\"lon\":111.716667,\"lat\":-8.05}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tondano\",\"_id\":1623424,\"coord\":{\"lon\":124.911201,\"lat\":1.3038}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tomohon\",\"_id\":1623446,\"coord\":{\"lon\":124.839203,\"lat\":1.3346}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ternate\",\"_id\":1624041,\"coord\":{\"lon\":127.400002,\"lat\":0.8}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tegal\",\"_id\":1624494,\"coord\":{\"lon\":109.140198,\"lat\":-6.8694}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tasikmalaya\",\"_id\":1624647,\"coord\":{\"lon\":108.220703,\"lat\":-7.3274}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tarub\",\"_id\":1624668,\"coord\":{\"lon\":109.166672,\"lat\":-6.93333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Bandarlampung\",\"_id\":1624917,\"coord\":{\"lon\":105.258034,\"lat\":-5.42544}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tanggulangin\",\"_id\":1625067,\"coord\":{\"lon\":112.699921,\"lat\":-7.49958}},\n" +
           "{\"country\":\"ID\",\"name\":\"Tabanan\",\"_id\":1625708,\"coord\":{\"lon\":115.125221,\"lat\":-8.5413}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sungairaya\",\"_id\":1625908,\"coord\":{\"lon\":108.900002,\"lat\":0.7}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sungaipenuh\",\"_id\":1625929,\"coord\":{\"lon\":101.383331,\"lat\":-2.08333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sungailiat\",\"_id\":1625958,\"coord\":{\"lon\":106.133331,\"lat\":-1.85}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sumenep\",\"_id\":1626099,\"coord\":{\"lon\":113.866669,\"lat\":-7.01667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Palasari\",\"_id\":6581396,\"coord\":{\"lon\":107.914719,\"lat\":-6.85222}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sumedang Utara\",\"_id\":1626100,\"coord\":{\"lon\":107.916672,\"lat\":-6.85}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sumberpucung\",\"_id\":1626134,\"coord\":{\"lon\":112.482918,\"lat\":-8.15856}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sumber\",\"_id\":1626183,\"coord\":{\"lon\":108.483063,\"lat\":-6.76028}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sokaraja\",\"_id\":1626312,\"coord\":{\"lon\":109.288063,\"lat\":-7.45806}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sukabumi\",\"_id\":1626381,\"coord\":{\"lon\":106.926666,\"lat\":-6.91806}},\n" +
           "{\"country\":\"ID\",\"name\":\"Srono\",\"_id\":1626486,\"coord\":{\"lon\":114.266609,\"lat\":-8.40003}},\n" +
           "{\"country\":\"ID\",\"name\":\"Soko\",\"_id\":1626673,\"coord\":{\"lon\":112.42704,\"lat\":-7.48315}},\n" +
           "{\"country\":\"ID\",\"name\":\"Soe\",\"_id\":1626703,\"coord\":{\"lon\":124.283951,\"lat\":-9.86071}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sleman\",\"_id\":1626754,\"coord\":{\"lon\":110.35556,\"lat\":-7.71556}},\n" +
           "{\"country\":\"ID\",\"name\":\"Slawi\",\"_id\":1626758,\"coord\":{\"lon\":109.140701,\"lat\":-6.9816}},\n" +
           "{\"country\":\"ID\",\"name\":\"Situbondo\",\"_id\":1626801,\"coord\":{\"lon\":114.009758,\"lat\":-7.70623}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sinjai\",\"_id\":1626895,\"coord\":{\"lon\":120.252998,\"lat\":-5.1241}},\n" +
           "{\"country\":\"ID\",\"name\":\"Singosari\",\"_id\":1626899,\"coord\":{\"lon\":112.665802,\"lat\":-7.8924}},\n" +
           "{\"country\":\"ID\",\"name\":\"Singkawang\",\"_id\":1626916,\"coord\":{\"lon\":109,\"lat\":0.9}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sengkang\",\"_id\":1626921,\"coord\":{\"lon\":120.029701,\"lat\":-4.1279}},\n" +
           "{\"country\":\"ID\",\"name\":\"Singaraja\",\"_id\":1626932,\"coord\":{\"lon\":115.088181,\"lat\":-8.112}},\n" +
           "{\"country\":\"ID\",\"name\":\"Singaparna\",\"_id\":1626936,\"coord\":{\"lon\":108.111,\"lat\":-7.3515}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sijunjung\",\"_id\":1627185,\"coord\":{\"lon\":100.953651,\"lat\":-0.68762}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sidoarjo\",\"_id\":1627253,\"coord\":{\"lon\":112.7183,\"lat\":-7.4478}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sidareja\",\"_id\":1627267,\"coord\":{\"lon\":108.792297,\"lat\":-7.4846}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sewon\",\"_id\":1627357,\"coord\":{\"lon\":110.358887,\"lat\":-7.87639}},\n" +
           "{\"country\":\"ID\",\"name\":\"Serpong\",\"_id\":1627459,\"coord\":{\"lon\":106.664169,\"lat\":-6.31694}},\n" +
           "{\"country\":\"ID\",\"name\":\"Serang\",\"_id\":1627549,\"coord\":{\"lon\":106.1502,\"lat\":-6.1149}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sepatan\",\"_id\":1627610,\"coord\":{\"lon\":106.574997,\"lat\":-6.11889}},\n" +
           "{\"country\":\"ID\",\"name\":\"Selogiri\",\"_id\":1627969,\"coord\":{\"lon\":110.866669,\"lat\":-7.78333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sawangan\",\"_id\":1628453,\"coord\":{\"lon\":106.774437,\"lat\":-6.40278}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sampit\",\"_id\":1628884,\"coord\":{\"lon\":112.949997,\"lat\":-2.53333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Sampang\",\"_id\":1628899,\"coord\":{\"lon\":113.239403,\"lat\":-7.1872}},\n" +
           "{\"country\":\"ID\",\"name\":\"Salatiga\",\"_id\":1629131,\"coord\":{\"lon\":110.492783,\"lat\":-7.33194}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ruteng\",\"_id\":1629380,\"coord\":{\"lon\":120.472099,\"lat\":-8.6136}},\n" +
           "{\"country\":\"ID\",\"name\":\"Rengasdengklok\",\"_id\":1629710,\"coord\":{\"lon\":107.298058,\"lat\":-6.15917}},\n" +
           "{\"country\":\"ID\",\"name\":\"Rembangan\",\"_id\":1629749,\"coord\":{\"lon\":111.341599,\"lat\":-6.7036}},\n" +
           "{\"country\":\"ID\",\"name\":\"Rantepao\",\"_id\":1629974,\"coord\":{\"lon\":119.897797,\"lat\":-2.9701}},\n" +
           "{\"country\":\"ID\",\"name\":\"Rangkasbitung\",\"_id\":1630058,\"coord\":{\"lon\":106.249397,\"lat\":-6.3591}},\n" +
           "{\"country\":\"ID\",\"name\":\"Rajapolah\",\"_id\":1630200,\"coord\":{\"lon\":108.189598,\"lat\":-7.221}},\n" +
           "{\"country\":\"ID\",\"name\":\"Purwokerto\",\"_id\":1630328,\"coord\":{\"lon\":109.234444,\"lat\":-7.42139}},\n" +
           "{\"country\":\"ID\",\"name\":\"Purwodadi\",\"_id\":1630333,\"coord\":{\"lon\":110.915802,\"lat\":-7.0868}},\n" +
           "{\"country\":\"ID\",\"name\":\"Purwakarta\",\"_id\":1630341,\"coord\":{\"lon\":107.443329,\"lat\":-6.55694}},\n" +
           "{\"country\":\"ID\",\"name\":\"Purbalingga\",\"_id\":1630366,\"coord\":{\"lon\":109.363892,\"lat\":-7.38806}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pundong\",\"_id\":1630416,\"coord\":{\"lon\":110.34861,\"lat\":-7.95222}},\n" +
           "{\"country\":\"ID\",\"name\":\"Prigen\",\"_id\":1630649,\"coord\":{\"lon\":112.616669,\"lat\":-7.68333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Praya\",\"_id\":1630662,\"coord\":{\"lon\":116.270363,\"lat\":-8.70536}},\n" +
           "{\"country\":\"ID\",\"name\":\"Candi Prambanan\",\"_id\":1630681,\"coord\":{\"lon\":110.494171,\"lat\":-7.75}},\n" +
           "{\"country\":\"ID\",\"name\":\"Poso\",\"_id\":1630723,\"coord\":{\"lon\":120.752403,\"lat\":-1.3959}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ponorogo\",\"_id\":1630798,\"coord\":{\"lon\":111.461998,\"lat\":-7.8685}},\n" +
           "{\"country\":\"ID\",\"name\":\"Provinsi Sulawesi Barat\",\"_id\":1996550,\"coord\":{\"lon\":119.333298,\"lat\":-2.5}},\n" +
           "{\"country\":\"ID\",\"name\":\"Polewali\",\"_id\":1630935,\"coord\":{\"lon\":119.343498,\"lat\":-3.4324}},\n" +
           "{\"country\":\"ID\",\"name\":\"Petarukan\",\"_id\":1631271,\"coord\":{\"lon\":109.433327,\"lat\":-6.88333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Perabumulih\",\"_id\":1631393,\"coord\":{\"lon\":104.25,\"lat\":-3.45}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pemangkat\",\"_id\":1631637,\"coord\":{\"lon\":108.966667,\"lat\":1.16667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pemalang\",\"_id\":1631648,\"coord\":{\"lon\":109.366669,\"lat\":-6.9}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pelabuhanratu\",\"_id\":1631733,\"coord\":{\"lon\":106.551392,\"lat\":-6.9875}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pekalongan\",\"_id\":1631766,\"coord\":{\"lon\":109.675301,\"lat\":-6.8886}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pecangaan\",\"_id\":1631851,\"coord\":{\"lon\":110.710701,\"lat\":-6.6978}},\n" +
           "{\"country\":\"ID\",\"name\":\"Payakumbuh\",\"_id\":1631905,\"coord\":{\"lon\":100.630783,\"lat\":-0.22019}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pati\",\"_id\":1631992,\"coord\":{\"lon\":111.038002,\"lat\":-6.7559}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pasuruan\",\"_id\":1632033,\"coord\":{\"lon\":112.907501,\"lat\":-7.6453}},\n" +
           "{\"country\":\"ID\",\"name\":\"Paseh\",\"_id\":1632197,\"coord\":{\"lon\":107.764099,\"lat\":-7.1026}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pasarkemis\",\"_id\":1632228,\"coord\":{\"lon\":106.530281,\"lat\":-6.17028}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pariaman\",\"_id\":1632334,\"coord\":{\"lon\":100.119972,\"lat\":-0.61898}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pare\",\"_id\":1632358,\"coord\":{\"lon\":112.197998,\"lat\":-7.7679}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pandeglang\",\"_id\":1632823,\"coord\":{\"lon\":106.106697,\"lat\":-6.3084}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pandakan\",\"_id\":1632859,\"coord\":{\"lon\":112.6875,\"lat\":-7.65268}},\n" +
           "{\"country\":\"ID\",\"name\":\"Panarukan\",\"_id\":1632903,\"coord\":{\"lon\":113.918442,\"lat\":-7.70181}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pameungpeuk\",\"_id\":1632974,\"coord\":{\"lon\":107.603889,\"lat\":-7.01833}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pamekasan\",\"_id\":1632978,\"coord\":{\"lon\":113.474602,\"lat\":-7.1568}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pamanukan\",\"_id\":1632998,\"coord\":{\"lon\":107.810562,\"lat\":-6.28417}},\n" +
           "{\"country\":\"ID\",\"name\":\"Palu\",\"_id\":1633034,\"coord\":{\"lon\":119.870697,\"lat\":-0.8917}},\n" +
           "{\"country\":\"ID\",\"name\":\"Palimanan\",\"_id\":1633056,\"coord\":{\"lon\":108.424171,\"lat\":-6.70694}},\n" +
           "{\"country\":\"ID\",\"name\":\"Palangkaraya\",\"_id\":1633118,\"coord\":{\"lon\":113.833328,\"lat\":-2.2}},\n" +
           "{\"country\":\"ID\",\"name\":\"Pagaralam\",\"_id\":1633308,\"coord\":{\"lon\":103.26667,\"lat\":-4.01667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Padang\",\"_id\":1633419,\"coord\":{\"lon\":100.354271,\"lat\":-0.94924}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ngunut\",\"_id\":1633986,\"coord\":{\"lon\":112.015907,\"lat\":-8.1058}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ngoro\",\"_id\":1634010,\"coord\":{\"lon\":112.258041,\"lat\":-7.68386}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ngawi\",\"_id\":1634098,\"coord\":{\"lon\":111.446098,\"lat\":-7.4038}},\n" +
           "{\"country\":\"ID\",\"name\":\"Nganjuk\",\"_id\":1634131,\"coord\":{\"lon\":111.903503,\"lat\":-7.6051}},\n" +
           "{\"country\":\"ID\",\"name\":\"Negara\",\"_id\":1634266,\"coord\":{\"lon\":114.602547,\"lat\":-8.31507}},\n" +
           "{\"country\":\"ID\",\"name\":\"Muntok\",\"_id\":1634678,\"coord\":{\"lon\":105.183327,\"lat\":-2.06667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Muntilan\",\"_id\":1634680,\"coord\":{\"lon\":110.292778,\"lat\":-7.58111}},\n" +
           "{\"country\":\"ID\",\"name\":\"Muncar\",\"_id\":1634718,\"coord\":{\"lon\":114.333328,\"lat\":-8.43333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Mranggen\",\"_id\":1634954,\"coord\":{\"lon\":110.5158,\"lat\":-7.0268}},\n" +
           "{\"country\":\"ID\",\"name\":\"Mojokerto\",\"_id\":1635111,\"coord\":{\"lon\":112.4338,\"lat\":-7.4664}},\n" +
           "{\"country\":\"ID\",\"name\":\"Mojoagung\",\"_id\":1635116,\"coord\":{\"lon\":112.349998,\"lat\":-7.56667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Mlonggo\",\"_id\":1635164,\"coord\":{\"lon\":110.699997,\"lat\":-6.53333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Metro\",\"_id\":1635283,\"coord\":{\"lon\":105.306671,\"lat\":-5.11306}},\n" +
           "{\"country\":\"ID\",\"name\":\"Mertoyudan\",\"_id\":1635342,\"coord\":{\"lon\":110.226387,\"lat\":-7.52}},\n" +
           "{\"country\":\"ID\",\"name\":\"Melati\",\"_id\":1635660,\"coord\":{\"lon\":110.366669,\"lat\":-7.73333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Maumere\",\"_id\":1635815,\"coord\":{\"lon\":122.211098,\"lat\":-8.6199}},\n" +
           "{\"country\":\"ID\",\"name\":\"Martapura\",\"_id\":1636022,\"coord\":{\"lon\":114.849998,\"lat\":-3.41667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Margasari\",\"_id\":1636121,\"coord\":{\"lon\":109.01667,\"lat\":-7.1}},\n" +
           "{\"country\":\"ID\",\"name\":\"Margahayukencana\",\"_id\":1636125,\"coord\":{\"lon\":107.567497,\"lat\":-6.97083}},\n" +
           "{\"country\":\"ID\",\"name\":\"Manismata\",\"_id\":1636322,\"coord\":{\"lon\":111.033333,\"lat\":-2.46667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Manggar\",\"_id\":1636426,\"coord\":{\"lon\":108.26667,\"lat\":-2.88333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Mandahara\",\"_id\":1636507,\"coord\":{\"lon\":103.583328,\"lat\":-1.03333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Mamuju\",\"_id\":1636556,\"coord\":{\"lon\":118.888496,\"lat\":-2.6748}},\n" +
           "{\"country\":\"ID\",\"name\":\"Majene\",\"_id\":1636806,\"coord\":{\"lon\":118.970703,\"lat\":-3.5403}},\n" +
           "{\"country\":\"ID\",\"name\":\"Majenang\",\"_id\":1636808,\"coord\":{\"lon\":108.764198,\"lat\":-7.2975}},\n" +
           "{\"country\":\"ID\",\"name\":\"Majalengka\",\"_id\":1636816,\"coord\":{\"lon\":108.227783,\"lat\":-6.83611}},\n" +
           "{\"country\":\"ID\",\"name\":\"Madiun\",\"_id\":1636930,\"coord\":{\"lon\":111.523903,\"lat\":-7.6298}},\n" +
           "{\"country\":\"ID\",\"name\":\"Luwuk\",\"_id\":1637001,\"coord\":{\"lon\":122.787498,\"lat\":-0.9516}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lumajang\",\"_id\":1637090,\"coord\":{\"lon\":113.2248,\"lat\":-8.1335}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lubuklinggau\",\"_id\":1637158,\"coord\":{\"lon\":102.866669,\"lat\":-3.3}},\n" +
           "{\"country\":\"ID\",\"name\":\"Loa Janan\",\"_id\":1637510,\"coord\":{\"lon\":117.095032,\"lat\":-0.58295}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lembang\",\"_id\":1638063,\"coord\":{\"lon\":107.6175,\"lat\":-6.81167}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lebaksiu\",\"_id\":1638217,\"coord\":{\"lon\":109.144096,\"lat\":-7.0496}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lawang\",\"_id\":1638284,\"coord\":{\"lon\":112.694702,\"lat\":-7.8353}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lasem\",\"_id\":1638352,\"coord\":{\"lon\":111.452698,\"lat\":-6.6922}},\n" +
           "{\"country\":\"ID\",\"name\":\"Lamongan\",\"_id\":1638562,\"coord\":{\"lon\":112.416672,\"lat\":-7.11667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Labuhanbajo\",\"_id\":1638868,\"coord\":{\"lon\":119.887703,\"lat\":-8.4964}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kuta\",\"_id\":1639002,\"coord\":{\"lon\":115.17234,\"lat\":-8.72332}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kuningan\",\"_id\":1639094,\"coord\":{\"lon\":108.483063,\"lat\":-6.97583}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kualatungkal\",\"_id\":1639286,\"coord\":{\"lon\":103.466667,\"lat\":-0.81667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kualakapuas\",\"_id\":1639304,\"coord\":{\"lon\":114.387589,\"lat\":-3.00913}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kresek\",\"_id\":1639362,\"coord\":{\"lon\":106.379723,\"lat\":-6.13139}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kraksaan\",\"_id\":1639431,\"coord\":{\"lon\":113.39624,\"lat\":-7.75845}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kotabumi\",\"_id\":1639524,\"coord\":{\"lon\":104.900002,\"lat\":-4.83333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Klaten\",\"_id\":1639900,\"coord\":{\"lon\":110.606392,\"lat\":-7.70583}},\n" +
           "{\"country\":\"ID\",\"name\":\"Klangenan\",\"_id\":1639925,\"coord\":{\"lon\":108.440002,\"lat\":-6.70944}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kertosono\",\"_id\":1640185,\"coord\":{\"lon\":112.099998,\"lat\":-7.58333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kepanjen\",\"_id\":1640296,\"coord\":{\"lon\":112.572701,\"lat\":-8.1303}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kencong\",\"_id\":1640354,\"coord\":{\"lon\":113.366669,\"lat\":-8.28333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kefamenanu\",\"_id\":1640576,\"coord\":{\"lon\":124.478058,\"lat\":-9.44667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kedungwuni\",\"_id\":1640581,\"coord\":{\"lon\":109.647942,\"lat\":-6.97038}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kedungwaru\",\"_id\":1640585,\"coord\":{\"lon\":111.916672,\"lat\":-8.06667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kediri\",\"_id\":1640660,\"coord\":{\"lon\":112.01667,\"lat\":-7.81667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kebonarun\",\"_id\":1640755,\"coord\":{\"lon\":110.563057,\"lat\":-7.70028}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kebomas\",\"_id\":1640765,\"coord\":{\"lon\":112.633301,\"lat\":-7.16667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kawalu\",\"_id\":1640902,\"coord\":{\"lon\":108.208199,\"lat\":-7.3817}},\n" +
           "{\"country\":\"ID\",\"name\":\"Katabu\",\"_id\":1640972,\"coord\":{\"lon\":122.516701,\"lat\":-4.9333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Karangsembung\",\"_id\":1641184,\"coord\":{\"lon\":108.642197,\"lat\":-6.8487}},\n" +
           "{\"country\":\"ID\",\"name\":\"Karangasem\",\"_id\":1641301,\"coord\":{\"lon\":115.616669,\"lat\":-8.45}},\n" +
           "{\"country\":\"ID\",\"name\":\"Karanganom\",\"_id\":1641333,\"coord\":{\"lon\":110.625,\"lat\":-7.64889}},\n" +
           "{\"country\":\"ID\",\"name\":\"Karangampel\",\"_id\":1641342,\"coord\":{\"lon\":108.451942,\"lat\":-6.46222}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kamal\",\"_id\":1641792,\"coord\":{\"lon\":112.71917,\"lat\":-7.16778}},\n" +
           "{\"country\":\"ID\",\"name\":\"Kalianget\",\"_id\":1641977,\"coord\":{\"lon\":113.933327,\"lat\":-7.05}},\n" +
           "{\"country\":\"ID\",\"name\":\"Juwana\",\"_id\":1642317,\"coord\":{\"lon\":111.151398,\"lat\":-6.715}},\n" +
           "{\"country\":\"ID\",\"name\":\"Jombang\",\"_id\":1642414,\"coord\":{\"lon\":112.23307,\"lat\":-7.54595}},\n" +
           "{\"country\":\"ID\",\"name\":\"Jogonalan\",\"_id\":1642437,\"coord\":{\"lon\":110.53611,\"lat\":-7.70361}},\n" +
           "{\"country\":\"ID\",\"name\":\"Jember\",\"_id\":1642588,\"coord\":{\"lon\":113.703171,\"lat\":-8.16604}},\n" +
           "{\"country\":\"ID\",\"name\":\"Jatiwangi\",\"_id\":1642684,\"coord\":{\"lon\":108.262779,\"lat\":-6.73361}},\n" +
           "{\"country\":\"ID\",\"name\":\"Jatiroto\",\"_id\":1642692,\"coord\":{\"lon\":111.116669,\"lat\":-7.88333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Jatibarang\",\"_id\":1642726,\"coord\":{\"lon\":108.315277,\"lat\":-6.47472}},\n" +
           "{\"country\":\"ID\",\"name\":\"Jaten\",\"_id\":1642754,\"coord\":{\"lon\":110.897499,\"lat\":-7.57722}},\n" +
           "{\"country\":\"ID\",\"name\":\"Gresik\",\"_id\":1643776,\"coord\":{\"lon\":112.656113,\"lat\":-7.15389}},\n" +
           "{\"country\":\"ID\",\"name\":\"Gorontalo\",\"_id\":1643837,\"coord\":{\"lon\":123.059502,\"lat\":0.5412}},\n" +
           "{\"country\":\"ID\",\"name\":\"Gongdanglegi Kulon\",\"_id\":1643898,\"coord\":{\"lon\":112.635941,\"lat\":-8.17529}},\n" +
           "{\"country\":\"ID\",\"name\":\"Genteng\",\"_id\":1644178,\"coord\":{\"lon\":114.150002,\"lat\":-8.36667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Gedangan\",\"_id\":1644349,\"coord\":{\"lon\":112.726669,\"lat\":-7.39083}},\n" +
           "{\"country\":\"ID\",\"name\":\"Gebog\",\"_id\":1644360,\"coord\":{\"lon\":110.844398,\"lat\":-6.735}},\n" +
           "{\"country\":\"ID\",\"name\":\"Gampengrejo\",\"_id\":1644522,\"coord\":{\"lon\":112.01667,\"lat\":-7.76667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Gambiran Satu\",\"_id\":1644557,\"coord\":{\"lon\":114.1464,\"lat\":-8.3939}},\n" +
           "{\"country\":\"ID\",\"name\":\"Galesong\",\"_id\":1644605,\"coord\":{\"lon\":119.366096,\"lat\":-5.3166}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ende\",\"_id\":1644932,\"coord\":{\"lon\":121.6623,\"lat\":-8.8432}},\n" +
           "{\"country\":\"ID\",\"name\":\"Dukuhturi\",\"_id\":1645154,\"coord\":{\"lon\":109.083328,\"lat\":-6.9}},\n" +
           "{\"country\":\"ID\",\"name\":\"Driyorejo\",\"_id\":1645220,\"coord\":{\"lon\":112.621902,\"lat\":-7.3659}},\n" +
           "{\"country\":\"ID\",\"name\":\"Diwek\",\"_id\":1645428,\"coord\":{\"lon\":112.231087,\"lat\":-7.57897}},\n" +
           "{\"country\":\"ID\",\"name\":\"Depok\",\"_id\":1645518,\"coord\":{\"lon\":110.431671,\"lat\":-7.7625}},\n" +
           "{\"country\":\"ID\",\"name\":\"Depok\",\"_id\":1645524,\"coord\":{\"lon\":106.818611,\"lat\":-6.4}},\n" +
           "{\"country\":\"ID\",\"name\":\"Demak\",\"_id\":1645559,\"coord\":{\"lon\":110.639603,\"lat\":-6.8909}},\n" +
           "{\"country\":\"ID\",\"name\":\"Dampit\",\"_id\":1645749,\"coord\":{\"lon\":112.749336,\"lat\":-8.21162}},\n" +
           "{\"country\":\"ID\",\"name\":\"Curup\",\"_id\":1645875,\"coord\":{\"lon\":102.533333,\"lat\":-3.46667}},\n" +
           "{\"country\":\"ID\",\"name\":\"Curug\",\"_id\":1645895,\"coord\":{\"lon\":106.556389,\"lat\":-6.26583}},\n" +
           "{\"country\":\"ID\",\"name\":\"Comal\",\"_id\":1645976,\"coord\":{\"lon\":109.534698,\"lat\":-6.9053}},\n" +
           "{\"country\":\"ID\",\"name\":\"Colomadu\",\"_id\":1645978,\"coord\":{\"lon\":110.75,\"lat\":-7.53333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Citeureup\",\"_id\":1646034,\"coord\":{\"lon\":106.881943,\"lat\":-6.48556}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cirebon\",\"_id\":1646170,\"coord\":{\"lon\":108.556999,\"lat\":-6.7063}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ciputat\",\"_id\":1646194,\"coord\":{\"lon\":106.695557,\"lat\":-6.2375}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cileunyi\",\"_id\":1646492,\"coord\":{\"lon\":107.752777,\"lat\":-6.93889}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cileungsi\",\"_id\":1646494,\"coord\":{\"lon\":106.959167,\"lat\":-6.39472}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cikarang\",\"_id\":1646678,\"coord\":{\"lon\":107.152779,\"lat\":-6.26111}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cikampek\",\"_id\":1646698,\"coord\":{\"lon\":107.455833,\"lat\":-6.41972}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cicurug\",\"_id\":1646893,\"coord\":{\"lon\":106.782501,\"lat\":-6.78139}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cibinong\",\"_id\":1647003,\"coord\":{\"lon\":106.854172,\"lat\":-6.48167}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ciamis\",\"_id\":1647149,\"coord\":{\"lon\":108.353401,\"lat\":-7.3257}},\n" +
           "{\"country\":\"ID\",\"name\":\"Cepu\",\"_id\":1647179,\"coord\":{\"lon\":111.590599,\"lat\":-7.1475}},\n" +
           "{\"country\":\"ID\",\"name\":\"Caringin\",\"_id\":1647298,\"coord\":{\"lon\":106.821388,\"lat\":-6.70611}},\n" +
           "{\"country\":\"ID\",\"name\":\"Ciampea\",\"_id\":1647383,\"coord\":{\"lon\":106.700829,\"lat\":-6.55472}},\n" +
           "{\"country\":\"ID\",\"name\":\"Bulakamba\",\"_id\":1647834,\"coord\":{\"lon\":108.955902,\"lat\":-6.8748}},\n" +
           "{\"country\":\"ID\",\"name\":\"Bukittinggi\",\"_id\":1647866,\"coord\":{\"lon\":100.370552,\"lat\":-0.30907}},\n" +
           "{\"country\":\"ID\",\"name\":\"Boyolangu\",\"_id\":1648082,\"coord\":{\"lon\":111.893501,\"lat\":-8.1181}},\n" +
           "{\"country\":\"ID\",\"name\":\"Boyolali\",\"_id\":1648084,\"coord\":{\"lon\":110.595833,\"lat\":-7.53306}},\n" +
           "{\"country\":\"ID\",\"name\":\"Bontang\",\"_id\":1648186,\"coord\":{\"lon\":117.5,\"lat\":0.13333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Blitar\",\"_id\":1648580,\"coord\":{\"lon\":112.168098,\"lat\":-8.0983}},\n" +
           "{\"country\":\"ID\",\"name\":\"Bitung\",\"_id\":1648636,\"coord\":{\"lon\":125.182404,\"lat\":1.4451}},\n" +
           "{\"country\":\"ID\",\"name\":\"Besuki\",\"_id\":1648918,\"coord\":{\"lon\":113.697853,\"lat\":-7.73379}},\n" +
           "{\"country\":\"ID\",\"name\":\"Bekasi\",\"_id\":1649378,\"coord\":{\"lon\":106.989601,\"lat\":-6.2349}},\n" +
           "{\"country\":\"ID\",\"name\":\"Baturaden\",\"_id\":1649595,\"coord\":{\"lon\":109.216667,\"lat\":-7.3}},\n" +
           "{\"country\":\"ID\",\"name\":\"Batu\",\"_id\":1649824,\"coord\":{\"lon\":112.528328,\"lat\":-7.87}},\n" +
           "{\"country\":\"ID\",\"name\":\"Batang\",\"_id\":1649881,\"coord\":{\"lon\":110.708298,\"lat\":-6.4846}},\n" +
           "{\"country\":\"ID\",\"name\":\"Barabai\",\"_id\":1650064,\"coord\":{\"lon\":115.383331,\"lat\":-2.58333}},\n" +
           "{\"country\":\"ID\",\"name\":\"Banyuwangi\",\"_id\":1650077,\"coord\":{\"lon\":114.357552,\"lat\":-8.2325}},\n" +
           "{\"country\":\"ID\",\"name\":\"Banyumas\",\"_id\":1650095,\"coord\":{\"lon\":109.294167,\"lat\":-7.51417}},\n" +
           "{\"country\":\"ID\",\"name\":\"Bantul\",\"_id\":1650119,\"coord\":{\"lon\":110.328888,\"lat\":-7.88806}},\n" +
           "{\"country\":\"ID\",\"name\":\"Banjaran\",\"_id\":1650227,\"coord\":{\"lon\":107.587784,\"lat\":-7.04528}},\n" +
           "{\"country\":\"ID\",\"name\":\"Banjar\",\"_id\":1650232,\"coord\":{\"lon\":114.967499,\"lat\":-8.19}},\n" +
           "{\"country\":\"ID\",\"name\":\"Banjar\",\"_id\":1650234,\"coord\":{\"lon\":107.431297,\"lat\":-7.1955}}\n" +
           "]";
   static List<City> getLongCities(){
        List<City> result =  new GsonBuilder()
                .create()
                .fromJson(longData, new TypeToken<List<City>>() {
                }.getType());
        result.removeAll(Collections.singleton(null));
        return result;
    }

}
