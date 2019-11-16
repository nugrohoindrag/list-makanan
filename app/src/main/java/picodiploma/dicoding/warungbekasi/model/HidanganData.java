package picodiploma.dicoding.warungbekasi.model;

import java.util.ArrayList;

/**
 * Created by sidiqpermana on 10/29/16.
 */

public class HidanganData {
    public static String[][] data = new String[][]{
            {"Mie Ayam Pangsit", "Mie dengan campuran ayam dan pangsit", "https://img-global.cpcdn.com/003_recipes/90f5b746a2f016df/751x532cq70/mie-ayam-pangsit-goreng-foto-resep-utama.jpg"},
            {"Nasi Pecel Madiun", "Nasi dengan bumbu pecel khas Madiun", "https://sgp1.digitaloceanspaces.com/tz-mag-id/wp-content/uploads/2018/10/111110104646/Preview-Nasi-Pecel-Madiun-770x433.jpg"},
            {"Indomie Goreng Telur", "Indomie Goreng Telur", "https://img-global.cpcdn.com/003_recipes/692b5279e9f1691e/751x532cq70/indomie-telor-asin-foto-resep-utama.jpg"},
            {"Soda Susu Gembira", "Es Soda dengan Susu", "https://www.ayamgepukshinta.com/uploads/2016/10/Es-Soda-Susu.png"},
            {"Es Lemon Tea", "Es dengan perasan lemon dan teh", "https://www.dapoerkita.com/wp-content/uploads/2017/12/lemontea.jpg"},
            {"Kerupuk Kulit", "Kerupuk yang dibuat dengan kulit", "https://ecs7.tokopedia.net/img/cache/700/product-1/2019/2/4/5339796/5339796_cf3c16f5-de6b-4ac9-9be1-0749bd364f78_1560_1560.jpg"}
    };

    public static ArrayList<Hidangan> getListData(){
        ArrayList<Hidangan> list = new ArrayList<>();
        for (String[] aData : data) {
            Hidangan hidangan = new Hidangan();
            hidangan.setName(aData[0]);
            hidangan.setFrom(aData[1]);
            hidangan.setPhoto(aData[2]);

            list.add(hidangan);
        }

        return list;
    }
}
