package br.pucrs;
import java.util.Random ;
import java.util.Arrays ;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main (String [] args){
        int [] vet = geraVetor(4, 5);
        int [] vetord = mergeSort(vet);
        for (int i = 0; i < vetord.length; i++) {
            System.out.print(vetord[i] +", " );
        }
    }

    public static int[] mergeSort(int[] desord){
        if(desord.length == 1) return desord;

        int [] a = new int[desord.length/2];
        for(int i = 0; i < a.length; i++){
            a[i] = desord[i];
        }
        int [] b = new int[desord.length - a.length];
        int j = 0;
        for(int i = a.length; i < desord.length; i++){
            b[j] = desord[i];
            j++;
        }
        return merge(mergeSort(a), mergeSort(b));

    }

    public static int[] merge(int[] esq, int[] dir){
        int [] ord = new int[esq.length + dir.length];
        if(esq[0] > dir[0]){
            ord[0] = dir[0];
            ord[1] = esq[0];
        }
        if(esq[0] <= dir[0]){
            ord[0] = esq[0];
            ord[1] = dir[0];
        }
        return ord;
    }
    private static int[] geraVetor(int nroPares, int nroImpares){
        int [] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                (nroPares + nroImpares > 0)) {

            res = new int[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98)+1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar+contImpar] = novoNum;
                    contPar++;
                }
                else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar+contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }

}
