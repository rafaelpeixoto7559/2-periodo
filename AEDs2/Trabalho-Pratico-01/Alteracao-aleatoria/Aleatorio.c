#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

char LetraRandom()
{
    char randomChar = (char)(rand() % 26 + 'a');
    return randomChar;
}

void strRandomRecursiva(char *array, char Creferencia, char Ctroca, int index)
{
    if (index >= strlen(array))
    { 
        return;
    }
    if (array[index] == Creferencia)
    {
        array[index] = Ctroca;                                 
    }
    strRandomRecursiva(array, Creferencia, Ctroca, index + 1); 
    
}

int strRandom(char *array)
{
    char Crefernecia = LetraRandom(), Ctroca = LetraRandom();

    strRandomRecursiva(array, Crefernecia, Ctroca, 0);
}

int main()
{
    srand(57);

    while (true)
    {

        char array[400];

        scanf(" %[^\n]", array);

        if (strcmp(array, "FIM") == 0)
        {
            break;
        }

        


        printf("%s\n",array);

      
    }

    return 0;
}