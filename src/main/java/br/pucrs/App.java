package br.pucrs;
import java.util.Random ;
import java.util.Arrays ;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int cont1;
    public static int cont2;

    public static void main (String [] args){
        int [] vet = geraVetor(2500, 2500);
        int a = maxVal1(vet, vet.length - 1);
        int b = maxVal2(vet, 0, vet.length - 1);
        
        System.out.println("ops 1: " + cont1);
        System.out.println("ops 2: " + cont2);
        
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

    public static int maxVal1(int A[], int n) {  
        int max = A[0];
        for (int i = 1; i < n; i++) {  
            if( A[i] > max ) 
               max = A[i];
            cont1++;
        }
        return max;
    }

    public static int maxVal2(int A[], int init, int end) {  
        if (end - init <= 1){
            cont2++;
            return max(A[init], A[end]);  
        }
        else {
              int m = (init + end)/2;
              cont2++;
              int v1 = maxVal2(A,init,m);   
              int v2 = maxVal2(A,m+1,end);  
              return max(v1,v2);
             }
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

    public static int max(int a, int b){
        if(a>b){ return a;}
        else{ return b;}
    }
}
