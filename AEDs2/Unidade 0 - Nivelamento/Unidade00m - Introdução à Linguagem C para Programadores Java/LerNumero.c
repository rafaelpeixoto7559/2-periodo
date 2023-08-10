#include <stdio.h>

int main() {
    int n, num;
    
    printf("Quantidade de números a serem inseridos: ");
    scanf("%d", &n);
    
    FILE *file = fopen("numeros.txt", "w");
    if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }
    
    for (int i = 0; i < n; i++) {
        printf("Digite o número %d: ", i + 1);
        scanf("%d", &num);
        fprintf(file, "%d\n", num);
    }
    
    fclose(file);
    
    file = fopen("numeros.txt", "r");
    if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }
    
    printf("Números lidos do arquivo:\n");
    while (fscanf(file, "%d", &num) != EOF) {
        printf("%d\n", num);
    }
    
    fclose(file);
    
    return 0;
}
