/*Ordenação Parcial por Inserção (k = 10)
Nesta questão, abordaremos a ordenação parcial por inserção com um valor de k igual a 10. O objetivo é encontrar os 10 menores elementos do vetor com base em algum atributo específico, considerando o atributo anoNascimento como a chave de pesquisa.

Entrada
A entrada consiste em uma lista de registros, onde cada registro possui um atributo anoNascimento. A lista pode conter um grande número de registros, mas nosso objetivo é encontrar e listar os 10 registros com os menores valores do atributo anoNascimento.

Saída
A saída será uma lista dos 10 registros com os menores valores do atributo anoNascimento, em ordem crescente.

Algoritmo de Ordenação Parcial por Inserção (k = 10)
O algoritmo de ordenação parcial por inserção com k igual a 10 funciona da seguinte maneira:

Inicialmente, selecione os primeiros 10 registros do vetor como os 10 menores registros até o momento.

Em seguida, percorra o restante dos registros do vetor e, para cada registro, insira-o na posição correta dos 10 menores registros com base no atributo anoNascimento, mantendo a ordem crescente.

Se o tamanho da lista dos 10 menores registros exceder 10, remova o registro com o maior valor de anoNascimento para manter apenas os 10 menores.

Continue percorrendo o vetor e atualizando a lista dos 10 menores registros até que todos tenham sido processados.

No final, a lista conterá os 10 registros com os menores valores do atributo anoNascimento.

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

void insercaoParcial(Jogador *jogador, int n)
{
    int k = 10;
    for (int i = 1; i < n; i++) {
        Jogador tmp = jogador[i];
        int j = (i < k) ? i-1 : k -1;
        while ((j >= 0) && (atoi(jogador[j].anoNascimento) > atoi(tmp.anoNascimento) || (atoi(jogador[j].anoNascimento) == atoi(tmp.anoNascimento) && strcmp(jogador[j].nome, tmp.nome) > 0))) {
            jogador[j+1] = jogador[j];
            j--;
        }
        jogador[j+1] = tmp;
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

    // chama a funcão de ordenacao por insercao parcial
    insercaoParcial(entradajogador, jogpos);

    //imprime o array de jogadores
    for (int i = 0; i < 10; i++)
    {
        imprimir(entradajogador[i]);
    }


    fclose(arq);

    return 0;
}