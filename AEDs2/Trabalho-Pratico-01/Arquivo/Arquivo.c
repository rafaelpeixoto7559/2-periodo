//Faça um programa que leia um número inteiro n indicando o número de valores reais que devem ser lidos e salvos sequencialmente em um arquivo texto. Após a leitura dos valores, devemos fechar o arquivo. 
 
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
    int n;
    scanf("%d", &n);
    FILE *arq = fopen("arq.txt", "wb");

    if(arq == NULL)
    {
        printf("Erro na abertura do arquivo");
        exit(1);
    }
    for(int i = 0; i < n; i++)
    {
        double num;
        scanf("%lf", &num);
        fwrite(&num, sizeof(double), 1, arq);
    }
    fclose(arq);
    arq = fopen("arq.txt", "rb");
    if(arq == NULL)
    {
        perror("Erro na abertura do arquivo");
        return 1;
    }
    for(int i = 0; i < n; i++){
        fseek(arq, (n - 1 - i) * sizeof(double), SEEK_SET);
        double num;
        fread(&num, sizeof(double), 1, arq);
        int numi = (int)num;
        if (num - numi == 0) {
            printf("%d\n", numi);
        } else {
            printf("%.3lf\n", num);
        }
    }
    fclose(arq);
    return 0;
}
