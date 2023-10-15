/*Ordenação pelo Método da Bolha de Vetor
Neste documento, descreve-se a implementação do algoritmo de ordenação pelo Método da Bolha (Bubble Sort) utilizando vetores. A chave de pesquisa considerada é o atributo anoNascimento.

Entrada
A entrada padrão é semelhante à da questão anterior e consiste em duas partes:

A primeira parte é igual à entrada da primeira questão.

A segunda parte é composta por várias linhas, cada uma contendo um elemento que será ordenado no vetor. A última linha da segunda parte contém a palavra FIM.

Saída
A saída padrão será composta por várias linhas contendo os registros ordenados com base no atributo anoNascimento.

Algoritmo de Ordenação pelo Método da Bolha (Bubble Sort)
O algoritmo de ordenação pelo Método da Bolha funciona da seguinte maneira:

Percorre repetidamente o vetor, comparando cada par de elementos adjacentes.
Se os elementos estiverem fora de ordem, realiza uma troca.
Continua percorrendo e trocando até que não seja necessária mais nenhuma troca.
Registro de Log
Um arquivo de log será criado na pasta corrente com o nome matrícula_bolha.txt. Este arquivo conterá uma única linha com as seguintes informações, separadas por uma tabulação ('\t'):

Sua matrícula
Número de comparações entre elementos do vetor durante a ordenação
Número de movimentações (trocas) entre elementos do vetor durante a ordenação
Tempo de execução do algoritmo de ordenação pelo Método da Bolha
Observações
Certifique-se de substituir "matrícula" pela sua matrícula real e fornecer as informações de comparações, movimentações e tempo de execução ao preencher o arquivo de log.

Este documento descreve como implementar o algoritmo de ordenação pelo Método da Bolha em vetores, com base na chave de pesquisa anoNascimento, e como registrar as informações necessárias no arquivo de log.*/

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

// ordenacao por bubblesort
void bubblesort(Jogador *jogador, int n, int *comp, int *mov)
{
    for (int i = (n - 1); i > 0; i--)
    {
        for (int j = 0; j < i; j++)
        {
            (*comp)++;
            if (atoi(jogador[j].anoNascimento) > atoi(jogador[j + 1].anoNascimento))
            {
                Jogador temp = clone(&jogador[j]);
                jogador[j] = clone(&jogador[j + 1]);
                jogador[j + 1] = clone(&temp);
                (*mov)++;
            } else if(atoi(jogador[j].anoNascimento) == atoi(jogador[j + 1].anoNascimento)){
                (*comp)++;
                if(strcmp(jogador[j].nome, jogador[j + 1].nome) > 0){
                    Jogador temp = clone(&jogador[j]);
                    jogador[j] = clone(&jogador[j + 1]);
                    jogador[j + 1] = clone(&temp);
                    (*mov)++;
                }
            }
        }
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


    // chama a funcão de ordenacao bubblesort
    int comp = 0, mov = 0;
    tempo = clock();
    bubblesort(entradajogador, jogpos, &comp, &mov);

    // imprime os jogadores ordenados
    for(int i = 0; i < jogpos; i++){
        imprimir(entradajogador[i]);
    }

    // cria arquivo de log
    FILE *log = fopen("1453574_bolha.txt", "w");
    tempo = clock() - tempo;
    fprintf(log, "Matricula: 1453574\tTempo de execução: %lf\tNúmero de comparações: %d", ((double)tempo) / ((CLOCKS_PER_SEC / 1000)), comp);

    fclose(arq);
    fclose(log);

    return 0;
}