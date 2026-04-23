import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            randomNumbers.add(rand.nextInt(10));
        }

        bubbleSort(randomNumbers);

        System.out.println(randomNumbers);
    }

    static ArrayList bubbleSort(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if ((i + 1 < lista.size()) && (lista.get(i) > lista.get(i + 1))) {
                int aux = lista.get(i + 1);
                lista.set(i + 1, lista.get(i));
                lista.set(i, aux);
                i = -1;
            }
        }
        return lista;
    }
}
