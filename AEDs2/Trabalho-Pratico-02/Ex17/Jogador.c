/*Ordenação Parcial por Heapsort (k = 10)
Nesta questão, abordaremos a ordenação parcial por Heapsort com um valor de k igual a 10. O objetivo é encontrar os 10 menores elementos do vetor com base em algum atributo específico, considerando o atributo altura como a chave de pesquisa.

Entrada
A entrada consiste em uma lista de registros, onde cada registro possui um atributo altura. A lista pode conter um grande número de registros, mas nosso objetivo é encontrar e listar os 10 registros com as menores alturas.

Saída
A saída será uma lista dos 10 registros com as menores alturas, em ordem crescente.

Algoritmo de Ordenação Parcial por Heapsort (k = 10)
O algoritmo de ordenação parcial por Heapsort com k igual a 10 funciona da seguinte maneira:

Inicialmente, selecione os primeiros 10 registros do vetor como os 10 menores registros até o momento.

Em seguida, construa um heap máximo (max-heap) com esses 10 registros.

Percorra o restante dos registros do vetor e, para cada registro, compare-o com o registro no topo do heap (que é o maior entre os 10 menores). Se o registro atual for menor, substitua o registro no topo do heap pelo registro atual e ajuste o heap para manter a propriedade do max-heap.

Continue percorrendo o vetor e atualizando o heap até que todos tenham sido processados.

No final, o heap conterá os 10 registros com as menores alturas.

Extraia os registros do heap para obter a lista final dos 10 menores registros, que estarão em ordem crescente.

Observações
Este algoritmo é eficiente quando precisamos encontrar um subconjunto dos menores elementos em uma grande lista. É uma forma de ordenação parcial que não requer que todos os elementos sejam ordenados, economizando tempo e recursos quando apenas uma parte dos resultados é necessária.


Lembre-se de fornecer a entrada adequada e adaptar o algoritmo para o seu contexto específico, considerando a ordenação parcial com k igual a 10.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

// definindo a estrutura Jogador
typedef struct Jogador
{
    char id[100];
    char nome[100];
    char altura[100];
    char peso[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

// clona um jogador
Jogador clone(Jogador *jogador)
{
    Jogador novo = *jogador;

    return novo;
}

// lê uma linha do arquivo e retorna os dados lidos
void ler(Jogador *j, char *frase)
{
}

void imprimir(Jogador jogador)
{
    // id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento
    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n", jogador.id, jogador.nome, jogador.altura, jogador.peso, jogador.anoNascimento, jogador.universidade, jogador.cidadeNascimento, jogador.estadoNascimento);
}

// tratamento de frase
char *tratarFrase(char *frase)
{
    char data[] = "nao informado";
    char *newfrase = malloc(sizeof(char) * 200); // Aloque memória suficiente
    if (newfrase == NULL)
    {
        // Tratamento de erro na alocação de memória
        return NULL;
    }

    strcpy(newfrase, ""); // Inicialize newfrase como uma string vazia

    for (int i = 0; frase[i] != '\0'; i++)
    {
        if (frase[i] == ',' && frase[i + 1] == ',')
        {
            strcat(newfrase, ","); //+=
            strcat(newfrase, data);
        }
        else if (frase[i] == ',' && frase[i + 2] == '\0')
        {
            strcat(newfrase, ",");
            strcat(newfrase, data);
        }
        else
        {
            char temp[2] = {frase[i], '\0'}; // Converta o caractere em uma string
            strcat(newfrase, temp);
        }
    }

    return newfrase;
}

// adiciona um jogador
void adcionarPlayer(Jogador *player, char tokens[8][100])
{
    strcpy(player->id, tokens[0]);

    strcpy(player->nome, tokens[1]);
    strcpy(player->altura, tokens[2]);
    strcpy(player->peso, tokens[3]);
    strcpy(player->universidade, tokens[4]);
    strcpy(player->anoNascimento, tokens[5]);
    strcpy(player->cidadeNascimento, tokens[6]);
    strcpy(player->estadoNascimento, tokens[7]);
}

// separa os dados de uma linha em tokens
void split(const char *str, char delimiter, char tokens[8][100])
{

    int linha = 0;
    int index = 0;
    while (linha < 8)
    {
        int i = 0;
        while (1)
        {

            if (str[index] == delimiter || str[index] == '\0' || str[index] == '\n')
            {
                tokens[linha][i] = '\0';
                break;
            }

            tokens[linha][i] = str[index];
            i++;
            index++;
        }

        index++;
        linha++;
    }
}

Jogador getMax(Jogador *arrJogadores, int nArrJogadores) {
    Jogador maior = arrJogadores[0];
    for (int i = 1; i < nArrJogadores; i++) {
        if (atoi(maior.id) < atoi(arrJogadores[i].id)) {
            maior = arrJogadores[i];
        }
    }
    return maior;
}

// heapsort heap maximo
void heapsort(Jogador *jogador, int n){
    Jogador *arrJogadores = malloc(sizeof(Jogador) * n);
    for (int i = 0; i < n; i++) {
        arrJogadores[i] = clone(&jogador[i]);
    }

    int comp = 0;
    int mov = 0;

    // construcao do heap
    for (int i = 1; i < n; i++) {
        int filho = i + 1;
        while (filho > 1 && (atoi(arrJogadores[filho/2 - 1].altura) < atoi(arrJogadores[filho - 1].altura) || (atoi(arrJogadores[filho/2 - 1].altura) == atoi(arrJogadores[filho - 1].altura) && strcmp(arrJogadores[filho/2 - 1].nome, arrJogadores[filho - 1].nome) < 0))) {
            Jogador temp = clone(&arrJogadores[filho/2 - 1]);
            arrJogadores[filho/2 - 1] = clone(&arrJogadores[filho - 1]);
            arrJogadores[filho - 1] = clone(&temp);
            filho /= 2;
            comp++;
            mov += 3;
        }
    }

    // ordenacao propriamente dita
    for (int i = n; i > 1; i--) {
        Jogador temp = clone(&arrJogadores[0]);
        arrJogadores[0] = clone(&arrJogadores[i - 1]);
        arrJogadores[i - 1] = clone(&temp);
        int pai = 1;
        int filho = 2;
        while (filho <= i - 1) {
            if (filho < i - 1 && (atoi(arrJogadores[filho - 1].altura) < atoi(arrJogadores[filho].altura) || (atoi(arrJogadores[filho - 1].altura) == atoi(arrJogadores[filho].altura) && strcmp(arrJogadores[filho - 1].nome, arrJogadores[filho].nome) < 0))) {
                filho++;
                comp++;
            }
            if (atoi(arrJogadores[pai - 1].altura) >= atoi(arrJogadores[filho - 1].altura) && (atoi(arrJogadores[pai - 1].altura) != atoi(arrJogadores[filho - 1].altura) || strcmp(arrJogadores[pai - 1].nome, arrJogadores[filho - 1].nome) >= 0)) {
                break;
            }
            Jogador temp = clone(&arrJogadores[pai - 1]);
            arrJogadores[pai - 1] = clone(&arrJogadores[filho - 1]);
            arrJogadores[filho - 1] = clone(&temp);
            pai = filho;
            filho = 2 * pai;
            comp++;
            mov += 3;
        }
    }

    for (int i = 0; i < 10; i++) {
        imprimir(arrJogadores[i]);
    }
}

int main()
{
    clock_t tempo;

    char leraq[600];

    Jogador time[3922];
    // arquivo

    FILE *arq = fopen("/tmp/playersAtualizado.csv", "r");

    fgets(leraq, sizeof(leraq), arq);

    int i = 0;
    while (fgets(leraq, 600, arq) != NULL)
    {
        char *frase = tratarFrase(leraq);

        char dados[8][100];
        split(frase, ',', dados);
        free(frase);

        adcionarPlayer(&time[i], dados);

        i++;
    }

    Jogador entradajogador[3922];
    int jogpos = 0;
    while (1)
    {
        char entrada[100];
        scanf("%s", entrada);
        if (strcmp(entrada, "FIM") == 0)
        {
            break;
        }
        else
        {
            for (int i = 0; i < 3922; i++)
            {
                if (strcmp(entrada, time[i].id) == 0)
                {
                    entradajogador[jogpos] = clone(&time[i]);
                    jogpos++;
                }
            }
        }
    }

    // chama a funcão de ordenacao por heapsort
    heapsort(entradajogador, jogpos);

    fclose(arq);

    return 0;
}