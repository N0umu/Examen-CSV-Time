import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lecteur {
    public static ArrayList<List<String>> lireCSV(String chemin){
        final char SEPARATEUR = ',';
        final char QUOTE = '"';

        String ligne = "";

        ArrayList<List<String>> resultTab = new ArrayList<>();
        List<String> ligneTab = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean citation = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(chemin));
            ArrayList<String> tab = new ArrayList<>();

            while ((ligne = br.readLine()) != null) {
                for (char c : ligne.toCharArray()) {
                    switch (c) {
                        case QUOTE:
                            citation = !citation;
                            break;
                        case SEPARATEUR:
                            if (citation) {
                                result.append(c);
                            } else {
                                ligneTab.add("" + result.toString() + "");
                                result.setLength(0);
                            }
                        default:
                            if(c != SEPARATEUR){
                                result.append(c);
                            }
                    }
                }
                if(citation){
                    ligneTab.add("\\n");
                }else{
                    ligneTab.add("" + result.toString() + "");
                    resultTab.add(ligneTab);
                    ligneTab = new ArrayList<String>();
                    result.setLength(0);
                }
            }
            return resultTab;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
}
