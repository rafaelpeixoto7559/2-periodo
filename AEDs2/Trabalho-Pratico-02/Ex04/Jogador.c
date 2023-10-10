/*Inserção e Pesquisa Binária em Vetor
Este documento descreve um algoritmo para a inserção de registros no final de um vetor e a subsequente realização de pesquisas utilizando a Pesquisa Binária, com base na chave primária, que é o atributo nome.

Entrada
A entrada padrão consiste em duas partes:

A primeira parte é igual à entrada da questão anterior.

A segunda parte é composta por várias linhas, cada uma contendo um elemento que deve ser pesquisado no vetor. A última linha da segunda parte contém a palavra FIM.

Saída
A saída padrão será composta por várias linhas, cada uma contendo as palavras SIM ou NAO para indicar se cada um dos elementos pesquisados foi encontrado no vetor.

Registro de Log
Além disso, um arquivo de log será criado na pasta corrente com o nome matrícula_binaria.txt. Este arquivo conterá uma única linha com as seguintes informações, separadas por uma tabulação ('\t'):

Sua matrícula
Tempo de execução do algoritmo
Número de comparações realizadas durante a execução
Observações
A entrada desta questão não está ordenada, mas a pesquisa binária requer uma ordenação prévia do vetor. Portanto, será necessário ordenar o vetor antes de realizar as pesquisas.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// definindo a estrutura Jogador
typedef struct Jogador
{
    char id[100] ;
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

int main()
{

    char leraq[600];

    Jogador time[3922];
    // arquivo

    FILE *arq = fopen("/tmp/players.csv", "r");

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
                    imprimir(time[i]);
                }
                
            }
        }
    }

    fclose(arq);

    return 0;
}