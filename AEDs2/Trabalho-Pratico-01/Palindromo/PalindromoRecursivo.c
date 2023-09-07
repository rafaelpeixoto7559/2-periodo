#include <stdio.h>
#include <string.h>

int verifica(char x[500], int c, int f){
    int vale = 0;

    if(c>=f){
        return 1;
    }
    else{
        if(x[c] == x[f-1]){
            vale = verifica(x, c+1, f-1);
            return vale;
        }else{
            vale = 0;
            return vale;
        }
    }
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
            int vale = verifica(x, 0, strlen(x));
            if (vale == 1) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }

    return 0;
}