//NE MARCHE PAS
//TEST AVEC SCANNER CHARACTER PAR CHARACTER SANS SUCCES

//import java.io .*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class ScannerLecteur {
//    public static ArrayList<String> lireCSV(String chemin) {
//        try {
//            Scanner sc = new Scanner(new File(chemin));
//
//            sc.useDelimiter(",|\\n");
//
//            ArrayList<String> test1 = new ArrayList<>();
//
//
//            while (sc.hasNext()) {
//
//                //System.out.println(sc.next());
//                test1.add(sc.next());
//            }
//            sc.close();
//
//            for(String s: test1){
//                System.out.println(s);
//            }
//
//            return (test1);
//        }catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return null;
//    }
//}
