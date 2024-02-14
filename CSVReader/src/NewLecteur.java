import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewLecteur {
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

                for (int i=0; i<ligne.toCharArray().length; i++) {
                    char c = ligne.charAt(i);
                    switch (c) {
                        case QUOTE:
                            if (!citation) {
                                citation = true;
                            } else if (i < ligne.length() - 1 && ligne.charAt(i + 1) == QUOTE) {
                                result.append(QUOTE);
                                i++;
                            } else {
                                citation = false;
                            }
                            break;
                        case SEPARATEUR:
                            if (citation) {
                                result.append(c);
                            } else {
                                ligneTab.add("'" + result.toString() + "'");
                                result.setLength(0);
                            }
                            break;
                        default:
                            result.append(c);
                            break;
                    }
                }
                if(citation){
                    result.append("\\n");
                }else{
                    ligneTab.add("'" + result.toString() + "'");
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
