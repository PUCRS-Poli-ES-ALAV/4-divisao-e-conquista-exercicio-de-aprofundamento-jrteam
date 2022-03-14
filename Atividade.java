import java.util.Arrays;
import java.util.List;

public class Atividade{

    public static void main (String []args){
       int[] lista = {1,3,5,7};
       int[] resultado = mergeSort(lista);
       System.out.println(resultado.length);

       for(int i=0;i<resultado.length;i++){
           System.out.println(resultado[i]);

       }
    }

    public static int [] mergeSort(int [] lista ) {
        if(lista.length==1){
            return lista;
        }
        
        
        int A [] = Arrays.copyOfRange(lista, 0, lista.length/2);

        int B [] = Arrays.copyOfRange(lista, (lista.length/2), lista.length);

        return B;

    }

}
