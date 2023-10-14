/*Ordenação por Shellsort de Vetor
Neste documento, descreve-se a implementação do algoritmo de ordenação Shellsort utilizando vetores. A chave de pesquisa considerada é o atributo peso.

Entrada
A entrada padrão é semelhante à da questão anterior e consiste em duas partes:

A primeira parte é igual à entrada da primeira questão.

A segunda parte é composta por várias linhas, cada uma contendo um elemento que será ordenado no vetor. A última linha da segunda parte contém a palavra FIM.

Saída
A saída padrão será composta por várias linhas contendo os registros ordenados com base no atributo peso.

Algoritmo de Ordenação Shellsort
O algoritmo de ordenação Shellsort é uma variação do método de inserção que divide o vetor em subvetores menores e ordena esses subvetores separadamente, utilizando um intervalo de separação chamado de "h".

O algoritmo Shellsort funciona da seguinte maneira:

Divide o vetor em subvetores separados por um intervalo "h".
Ordena cada subvetor separadamente utilizando o método de inserção.
Reduz gradualmente o valor de "h" e repete o processo até que o vetor inteiro esteja ordenado.
Registro de Log
Um arquivo de log será criado na pasta corrente com o nome matrícula_shellsort.txt. Este arquivo conterá uma única linha com as seguintes informações, separadas por uma tabulação ('\t'):

Sua matrícula
Número de comparações entre elementos do vetor durante a ordenação
Número de movimentações (trocas) entre elementos do vetor durante a ordenação
Tempo de execução do algoritmo de ordenação Shellsort
Observações
Certifique-se de substituir "matrícula" pela sua matrícula real e fornecer as informações de comparações, movimentações e tempo de execução ao preencher o arquivo de log.
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

bool comparacao(Jogador i, Jogador tmp, int comp) {
    bool resp;
    if (atoi(i.peso) > atoi(tmp.peso)) {
        resp = true;
        comp++;
    } 
    else if (atoi(i.peso) == atoi(tmp.peso) && strcmp(i.nome, tmp.nome) > 0) {
        resp = true;
        comp+=3;
    } 
    else resp = false;
    return resp;
}

void insercao(Jogador *vet, int cor, int h, int tam, int mov, int comp) {
    for (int i = (h+cor); i < tam; i+=h) {
        Jogador tmp = vet[i];
        mov++;
        int j = i - h;
        while ((j >= 0) && comparacao(vet[j], tmp, comp)) {
            comp++;
            mov++;
            vet[j + h] = vet[j];
            j-=h;
        }
        vet[j+h] = tmp;
        mov++;
    }
}

// ordenacao por selecao recursiva
void shellsort(Jogador *vet, int tam, int mov, int comp)
{
    int h = 1;
    do {
        h = (h * 3) + 1;
    } while (h < tam);

    do {
        h/=3;
        for (int i = 0; i < h; i++) {
            insercao(vet, i, h, tam, mov, comp);
        }
    } while (h != 1);
}

int main()
{
    clock_t tempo;

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
            entradajogador[jogpos] = clone(&time[atoi(entrada)]);
            jogpos++;
        }
    }

    // chama a funcão de ordenacao por shellsort
    int comp = 0;
    int mov = 0;
    shellsort(entradajogador, jogpos, mov, comp);

    // imprime os jogadores ordenados
    for(int i = 0; i < jogpos; i++){
        imprimir(entradajogador[i]);
    }

    // cria arquivo de log
    FILE *log = fopen("1453574_shellsort.txt", "w");
    tempo = clock() - tempo;
    fprintf(log, "matricula: 1453574\tcomp: %d\tmov: %d\ttempo: %lf", comp, mov, ((double)tempo) / ((CLOCKS_PER_SEC / 1000)));

    fclose(arq);
    fclose(log);

    return 0;
}