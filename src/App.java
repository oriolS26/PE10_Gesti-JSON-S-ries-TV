import java.text.ParseException;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        App p = new App();
        p.programa();
    }
    public void programa() {
        int opcio = 0;
        do {
            System.out.println("Benvingut al programa de les sèries de televisió");
            System.out.println("Opcions: ");
            System.out.println("1. Quantes sèries de televisió hi ha?");
            System.out.println("2. Llistar per nom i nom original");
            System.out.println("3. Llistar per idioma original");
            System.out.println("4. Llistar per païs d'origen");
            System.out.println("5. Llistar per generes");
            System.out.println("6. Llistar per nom, idioma original, països d'origen, gèneres, puntuació i descripció de la sèrie \"Breaking Bad\"");
            System.out.println("7. Llistar la sèrie amb millor puntuació");
            System.out.println("8. Llistar la sèrie amb pitjor puntuació");
            System.out.println("9. Llistar dada interessant");
            System.out.println("10. ");
            System.out.println("11. ");
            System.out.println("12. Sortir");
            opcio = new Scanner(System.in).nextInt();
        
            switch(opcio){
                case 1:
                    exercici2();
                    break;
                case 2:
                    exercici3();
                    break;
                case 3:
                    exercici4();
                    break;
                case 4:
                    exercici5();
                    break;  
                case 5:
                    exercici6();
                    break;
                case 6:
                    exercici7();
                    break;
                case 7:
                    exercici8();
                    break;
                case 8:
                    exercici9();
                    break;
                case 9:
                    exercici10();
                    break;
                case 10:
                    exercici11();
                    break;
                case 11:
                    exercici12();
                    break;
                case 12:
                    System.out.println("Fins aviat!");
            }
        }while(opcio!=12);

    }
    private JSONArray llegirTvs() {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("../src/tvs.json"));
        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void exercici2() {
        
    }
    public void exercici3() {
        
    }
    public void exercici4() {
        
    }
    public void exercici5() {
        
    }
    public void exercici6() {
        
    }
    public void exercici7() {
        
    }
    public void exercici8() {
        
    }
    public void exercici9() {
        
    }
    public void exercici10() {
        
    }
    public void exercici11() {
        
    }
    public void exercici12() {
        
    }

}
