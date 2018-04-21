package javafx.domian;


public class ConvertTorRi {
    private String s1 = "";
    private String s2 = "";
    private String s3 = "";

    private void met(String number, int i) {
        switch (number) {
            case "1" : number = "I"; break;
            case "2" : number = "II"; break;
            case "3" : number = "III"; break;
            case "4" : number = "IV"; break;
            case "5" : number = "V"; break;
            case "6" : number = "VI"; break;
            case "7" : number = "VII"; break;
            case "8" : number = "VIII"; break;
            case "9" : number = "IX"; break;
            case "10" : number = "X"; break;

            case "11" : number = "XI"; break;
            case "12" : number = "XII"; break;
            case "13" : number = "XIII"; break;
            case "14" : number = "XIV"; break;
            case "15" : number = "XV"; break;
            case "16" : number = "XVI"; break;
            case "17" : number = "XVII"; break;
            case "18" : number = "XVIII"; break;
            case "19" : number = "XIX"; break;
            case "20" : number = "XX"; break;

            case "21" : number = "XXI"; break;
            case "22" : number = "XXII"; break;
            case "23" : number = "XXIII"; break;
            case "24" : number = "XXIV"; break;
            case "25" : number = "XXV"; break;
            case "26" : number = "XXVI"; break;
            case "27" : number = "XXVII"; break;
            case "28" : number = "XXVIII"; break;
            case "29" : number = "XXIX"; break;
            case "30" : number = "XXX"; break;

            case "31" : number = "XXXI"; break;
            case "32" : number = "XXXII"; break;
            case "33" : number = "XXXIII"; break;
            case "34" : number = "XXXIV"; break;
            case "35" : number = "XXXV"; break;
            case "36" : number = "XXXVI"; break;
            case "37" : number = "XXXVII"; break;
            case "38" : number = "XXXVIII"; break;
            case "39" : number = "XXXIX"; break;
            case "40" : number = "XL"; break;

            case "41" : number = "XLI"; break;
            case "42" : number = "XLII"; break;
            case "43" : number = "XLIII"; break;
            case "44" : number = "XLIV"; break;
            case "45" : number = "XLV"; break;
            case "46" : number = "XLVI"; break;
            case "47" : number = "XLVII"; break;
            case "48" : number = "XLVIII"; break;
            case "49" : number = "XLIX"; break;
            case "50" : number = "L"; break;

            case "51" : number = "LI"; break;
            case "52" : number = "LII"; break;
            case "53" : number = "LIII"; break;
            case "54" : number = "LIV"; break;
            case "55" : number = "LV"; break;
            case "56" : number = "LVI"; break;
            case "57" : number = "LVII"; break;
            case "58" : number = "LVIII"; break;
            case "59" : number = "LIX"; break;
            case "60" : number = "LX"; break;
        }
        if (i == 0) {
            s3 = number;
        } else if(i == 1) {
            s2 = number;
        } else if(i == 2) {
            s1 = number;
        }
    }

    public String Convertor (int h, int m, int s) {

        for(int i = 0 ; i < 3; i ++) {
            String number = "";
            if(i == 0) {
                number = String.valueOf(s);
            } else if(i == 1) {
                number = String.valueOf(m);
            } else if(i == 2) {
                number = String.valueOf(h);
            }
            met(number,i) ;
        }
        if(s1.equals("0")) {
            s1 = "--";
        }
        if(s2.equals("0")) {
            s2 = "--";
        }
        return s1 + ":" + s2 + ":" + s3;
    }
}
