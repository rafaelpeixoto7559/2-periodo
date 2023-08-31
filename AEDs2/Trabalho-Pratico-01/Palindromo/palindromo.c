#include <stdio.h>
#include <string.h>

/*
    Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um palíndromo.


    Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NAO indicando se a linha é um palíndromo.


    Destaca-se que uma linha de entrada pode ter caracteres não letras


    A entrada termina com a leitura de FIM
 */

int verifica(char x[]) {
    int tam = strlen(x);
    int vale = 1;

    for (int i = 0; i < tam; i++) {
        if (x[i] != x[tam - i - 1]) {
            vale = 0;
            break;
        }
    }

    return vale;
}

int main() {
    char x[500];  
    int res = 1;
    while (res == 1) {
        scanf("%[^\n]%*c", x);
    
        if (x[0] == 'F' && x[1] ==  'I' && x[2] == 'M')
        {
            res = 0;
        }
        else {
            int vale = verifica(x);
            if (vale == 1) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }

    return 0;
}