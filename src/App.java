import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

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
            System.out.println("10. Canviar idiomes amb el fitxer lenguages.json");
            System.out.println("11. Escriure dades a un fitxer nou 'tvs_mod.json'");
            System.out.println("12. Sortir");

            try {
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
            } catch (Exception e) {
                System.out.println("Error en l'opció introduïda.");
            }
        }while(opcio!=12);

    }
    private JSONArray llegirTvs()  {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/tvs.json"));
            return (JSONArray) obj;
        } catch (Exception e) {
            System.out.println("Error al llegir el fitxer: " + e.getMessage());
            return new JSONArray();
        }
    }

    public void exercici2() {
        JSONArray llista = llegirTvs();
        System.out.println("Total de sèries: " + llista.size());
    }

    public void exercici3() {
        JSONArray llista = llegirTvs();
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            System.out.println("- " + s.get("name") + " (" + s.get("original_name") + ")");
        }
    }

    public void exercici4() {
        JSONArray llista = llegirTvs();
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            System.out.println(s.get("name") + " -> Idioma: " + s.get("original_language"));
        }
    }

    public void exercici5() {
        JSONArray llista = llegirTvs();
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            JSONArray paisos = (JSONArray) s.get("origin_country");
            System.out.println(s.get("name") + " -> Països: " + paisos.toJSONString());
        }
    }

    public void exercici6() {
        JSONArray llista = llegirTvs();
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            System.out.print(s.get("name") + " -> Gèneres: ");
            JSONArray generes = (JSONArray) s.get("genres");
            for (Object g : generes) {
                System.out.print(((JSONObject)g).get("name") + " ");
            }
            System.out.println();
        }
    }

    public void exercici7() {
        JSONArray llista = llegirTvs();
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            if (s.get("name").toString().equals("Breaking Bad")) {
                System.out.println("Detalls de Breaking Bad:");
                System.out.println("Idioma: " + s.get("original_language"));
                System.out.println("Nota: " + s.get("vote_average"));
                System.out.println("Sinopsi: " + s.get("overview"));
            }
        }
    }

    public void exercici8() {
        JSONArray llista = llegirTvs();
        JSONObject millor = null;
        double max = -1;
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            double nota = Double.parseDouble(s.get("vote_average").toString());
            if (nota > max) { max = nota; millor = s; }
        }
        System.out.println("Millor sèrie: " + millor.get("name") + " (" + max + ")");
    }

    public void exercici9() {
        JSONArray llista = llegirTvs();
        JSONObject pitjor = null;
        double min = 11;
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            double nota = Double.parseDouble(s.get("vote_average").toString());
            if (nota < min) { min = nota; pitjor = s; }
        }
        System.out.println("Pitjor sèrie: " + pitjor.get("name") + " (" + min + ")");
    }

    public void exercici10() {
        JSONArray llista = llegirTvs();
        System.out.println("Sèries amb més de 100 episodis:");
        for (Object o : llista) {
            JSONObject s = (JSONObject) o;
            long eps = (long) s.get("number_of_episodes");
            if (eps > 100) System.out.println("- " + s.get("name") + ": " + eps);
        }
    }

    public void exercici11() {
        JSONParser parser = new JSONParser();
        try {
            JSONObject idiomes = (JSONObject) parser.parse(new FileReader("src/languages.json"));
            JSONArray llista = llegirTvs();
            for (Object o : llista) {
                JSONObject s = (JSONObject) o;
                String codi = (String) s.get("original_language");
                if (idiomes.containsKey(codi)) {
                    s.put("original_language", idiomes.get(codi));
                }
            }
            // Guardem la llista modificada en el fitxer a l'exercici 12
            System.out.println("Idiomes traduïts en memòria. Recorda guardar (opció 11).");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void exercici12() {
       try (FileWriter file = new FileWriter("src/tvs_modificat.json")) {
            file.write(llegirTvs().toJSONString());
            System.out.println("Fitxer guardat correctament.");
        } catch (Exception e) { e.printStackTrace(); }
    }

}
