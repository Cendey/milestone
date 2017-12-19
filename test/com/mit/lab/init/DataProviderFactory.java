package com.mit.lab.init;

import com.mit.lab.intf.Function;
import com.mit.lab.intf.UseInstance;
import com.mit.lab.meta.Items;
import com.mit.lab.norm.FileWriterEAM;
import com.mit.lab.norm.FireEngines;
import com.mit.lab.norm.FluentMailer;
import com.mit.lab.norm.Holder;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <p>Project    : Blueprint</p>
 * <p>Description: DataProviderFactory</p>
 * <p>Copyright  : Copyright (c) 2014, All right reserved.</p>
 * <p>Company    : MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 4/30/2014
 */
public class DataProviderFactory {

    @DataProvider(name = "file-writer-arm-factory")
    public static Object[][] generateFileWriterARM() {
        return new Object[][]{new Object[]{"peek-a-boo"}};
    }

    @DataProvider(name = "file-writer-eam-factory")
    public static Object[][] generateFileWriterEAM() {
        UseInstance<FileWriterEAM, IOException> useInstance = fileWriterEAM -> fileWriterEAM.writeStuff("sweet");
        return new Object[][]{new Object[]{"eam.txt", useInstance}};
    }

    @DataProvider(name = "mailer-factory")
    public static Object[][] generateMailer() {
        Consumer<FluentMailer> fluentMailerConsumer = mailer -> mailer.from("build@agiledeveloper.com")
            .to("venkats@agiledeveloper.com").subject("build notification").body("...much better...");
        return new Object[][]{new Object[]{fluentMailerConsumer}};
    }

    @DataProvider(name = "holder-factory")
    public static Object[][] generateHolder() {
        Holder instance = new Holder();
        return new Object[][]{new Object[]{instance}, new Object[]{instance}, new Object[]{instance}};
    }

    @DataProvider(name = "fire-engine-factory")
    public static Object[][] generateFireEngines() {
        return new Object[][]{new Object[]{new FireEngines<>()}, new Object[]{new FireEngines<>(50.5)}};
    }

    @DataProvider(name = "worlds-factory")
    public static Object[][] generateWorlds() {
        return new Object[][]{
            new Object[]{"i just wanna be with you! do you know?", 10},
            new Object[]{"but and i wanna know who is in your heart. just yourself or someone else?", 100},
            new Object[]{"go out or stay at home!", 2},
            new Object[]{"this is so beautiful,then as the owner i will keep of it!", 100},
            new Object[]{"中国辉煌的文明必将影响世界", 8},
            new Object[]{"中国は栄光のウェン・ミングの世界に影響を与えるにバインドされ", 8},
            new Object[]{"중국은 영광스러운 웬 밍 세계에 영향을 미칠 수밖에 없다", 8},
            new Object[]{"Wen Ming Sinis est in gloria mundi tenetur et afficit,", 8}
        };
    }

    @DataProvider(name = "register-factory")
    public static Object[][] generateRegister() {
        return new Object[][]{
            new Object[]{"Developer"}, new Object[]{"Dina"},
            new Object[]{"JavaDeveloper@sskaje.me"}, new Object[]{"Tina"}};
    }

    @DataProvider(name = "date-factory")
    public static Object[][] generateDate() {
        String value = "yyyyMMddHHmm";
        return new Object[][]{
            new String[]{"20141231145800", value}, new String[]{"20150113180000", value},
            new String[]{"20151231135800", value}, new String[]{"20131230190000", value},
            new String[]{"20140228190000", value}};
    }

    @DataProvider(name = "string-factory")
    public static Object[][] generateString() {
        return new Object[][]{
            new String[]{"A |B| C|D", "\\|"},
            new String[]{"Hello, World! ^ I'm a programmer for java!", "\\^"}, new String[]{"OP-SE-BL", "-"},
            new String[]{"OP-SE-CONSOL", "-"}, new String[]{"OP-SE-BOOKING", "-"}};
    }

    @DataProvider(name = "bizrule-factory")
    public static Object[][] generateBizRule() {
        return new Object[][]{
            new Object[]{
                new HashMap<String, String>() {
                    {
                        put("com.mit.lab.norm.BizRule", "Biz Rule");
                        put("java.util.HashMap", "Hash Map");
                        put("java.util.ArrayList", "Array List");
                        put("com.mit.lab.norm.Person", "Person");
                        put("Truck", "com.mit.lab.norm.Truck");
                        put("com.mit.lab.norm.Album", "Album");
                        put("com.mit. lab.norm.Artist", "Artist");
                        put("com.mit.lab.norm. DatePlain", "Data Plain");
                        put(" com.mit .lab.norm.Track", "Track");
                    }
                }
            }
        };
    }

    @DataProvider(name = "solution-factory")
    public static Object[][] generateNumbers() {
        return new Object[][]{
            new Object[]{5, 3},
            new Object[]{1, 3, 5, 7, 9},
            new Object[]{5, 3, 4, 7, 6, 13, 9},
            new Object[]{1, 5, 3, 3, 7},
            new Object[]{1, 5, 3, 3, 4, 7},
            new Object[]{1, 3, 5, 3, 4},
            new Object[]{10, 3, 5, 7, 2}};
    }

    @DataProvider(name = "parking-time-factory")
    public static Object[][] generateParking() {
        return new Object[][]{
            new String[]{"10:00", "15:30"},
            new String[]{"00:00", "00:15"},
            new String[]{"09:00", "09:59"},
            new String[]{"10:30", "11:31"},
            new String[]{"18:00", "19:01"}};
    }

    @DataProvider(name = "collections-factory")
    public static Object[][] generateCollections() {
        return new Object[][]{
            new Object[]{
                new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("sno.", 1);
                        put("unid", 80);
                    }});
                    add(new HashMap<String, Object>() {{
                        put("sno.", 2);
                        put("unid", 120);
                    }});
                    add(new HashMap<String, Object>() {{
                        put("sno.", 3);
                        put("unid", 40);
                    }});
                }}, "unid"},
            new Object[]{
                new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("sno.", 4);
                        put("unid", 10);
                    }});
                    add(new HashMap<String, Object>() {{
                        put("sno.", 5);
                        put("unid", 1);
                    }});
                }}, "unid"}};
    }

    @DataProvider(name = "seat-factory")
    public static Object[][] generateSeats() {
        return new Object[][]{
            new Object[]{2, "1A 2F 1C"},
            new Object[]{1, ""},
            new Object[]{10, "1A 1J 2C 2E 3F 3K"}};
    }

    @DataProvider(name = "division-factory")
    public static Object[][] generateDivision() {
        return new Object[][]{
            new Integer[]{4, 5, 1, 1, 1, 1, 4, 3, 1},
            new Integer[]{-1, 3, -4, 5, 1, -6, 2, 1},
            new Integer[]{1, -8, 16, -7, 100, -1, -2, 9, -13},
            new Integer[]{10, 80, -100, 32}};
    }

    @DataProvider(name = "script-factory")
    public static Object[][] generateScript() {
        return new Object[][]{
            new Object[]{new Items(5, 7), "(item.num <= 15 && item.num >= 1) || (item.pos != -1)"},
            new Object[]{new Items(20, -1), "(item.num <= 15 && item.num >= 1) || (item.pos != -1)"},
            new Object[]{
                new Items("U", null), "item.status!=\"S\" || (typeof item.limited!=\"undefined\")"},
            new Object[]{
                new Items("S", null), "item.status==\"S\" && (typeof item.limited!=\"undefined\")"},
            new Object[]{new Items("F", "Y"), "item.status==\"F\" && !item.limited"}
        };
    }

    @DataProvider(name = "function-factory-main")
    public static Object[][] generateFunction() {
        Function<Integer, Integer> triple = x -> x * 3;
        Function<Integer, Integer> square = x -> x * x;
        Function<Double, Double> cycle = z -> Math.PI / 2 - z;
        Function<Double, Double> calc = Math::cos;
        return new Object[][]{
            new Object[]{triple, square, 5},
            new Object[]{triple, triple, 5},
            new Object[]{square, triple, 5},
            new Object[]{square, square, 5},
            new Object[]{cycle, calc, 10.0},
            new Object[]{calc, cycle, 10.0}
        };
    }

    @DataProvider(name = "function-factory-swap")
    public static Object[][] generateSwap() {
        Double realRate = 9.0;
        Double realPrice = 150.0;
        Function<Double, Function<Double, Double>> addTax1stRate = rate -> price -> price + price / 100 * rate;
        Function<Double, Function<Double, Double>> addTax1stPrice = price -> rate -> price + price / 100 * rate;
        return new Object[][]{
            new Object[]{addTax1stRate, realRate, realPrice},
            new Object[]{addTax1stPrice, realPrice, realRate}
        };
    }

    @DataProvider(name = "validation-factory")
    public static Object[][] generateValidation() {
        return new Object[][]{
            new Object[]{"this.is@my.email"},
            new Object[]{null},
            new Object[]{""},
            new Object[]{"john.doe@acme.com"}
        };
    }
}
