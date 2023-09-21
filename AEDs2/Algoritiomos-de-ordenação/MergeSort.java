public class MergeSort{

    static void merge(int esq, int dir, int[] array){
        if(esq < dir){
            int meio = (esq + dir) / 2;
            merge(esq, meio, array);
            merge(meio + 1, dir, array);
            intercalar(esq, meio, dir, array);
        }
    }

    static void intercalar(int esq, int meio, int dir, int[] array){
        int nEsq = (meio+1)-esq;
        int nDir = dir-meio;

        int[] arrayEsq = new int[nEsq+1];
        int[] arrayDir = new int[nDir+1];

        arrayEsq[nEsq] = arrayDir[nDir] = 0x7FFFFFFF;
        
        int iEsq, iDir, i;
        //inicializa primeiro subarray
        for(iEsq = 0; iEsq < nEsq; iEsq++){
            arrayEsq[iEsq] = array[esq+iEsq];
        }
        //inicializa segundo subarray
        for(iDir = 0; iDir < nDir; iDir++){
            arrayDir[iDir] = array[(meio+1)+iDir];
        }
        //Intercalação propriamente dita
        for(iEsq = iDir = 0, i = esq; i <= dir; i++){
            array[i] =(arrayEsq[iEsq] <= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1, 3};
        
        merge(0, array.length-1, array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}