import java.util.ArrayList;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ITimeService sec = new Seconde();
        ITimeService min = new Minute();
        ITimeService hr = new Heure();
        ITimeService jr = new Jour();
        ITimeService an = new Annee();

        sec.setNext(min);
        min.setNext(hr);
        hr.setNext(jr);
        jr.setNext(an);

        TimeRequest requestA = new TimeRequest(Integer.parseInt("2147483641"));

        sec.handleRequest(requestA, requestA.getRequest());

        System.out.println(requestA.getProcessedConclusion());

        //System.out.println(methode("sudc12"));
//        System.out.println(time("3600"));

    }

    public static String methode(String chaine){
        int chiffre = 1;

        for(int i =0; i < chaine.length(); i++){
            if(Character.isDigit(chaine.charAt(i))){
                String numberOnly= chaine.replaceAll("[^0-9]", "");
                chaine = chaine.replaceAll("\\d","");
                chiffre = Integer.valueOf(numberOnly) + 1;
                return (chaine + chiffre);
            }
        }
        return (chaine + chiffre);
    }
}