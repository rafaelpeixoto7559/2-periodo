#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;


void push(Node** top, int num) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        printf("Erro de memória.\n");
        exit(1);
    }
    newNode->data = num;
    newNode->next = *top;
    *top = newNode;
}

int pop(Node** top) {
    if (*top == NULL) {
        printf("Pilha vazia.\n");
        exit(1);
    }
    int num = (*top)->data;
    Node* temp = *top;
    *top = (*top)->next;
    free(temp);
    return num;
}

int main() {
    int n, num;
    Node* top = NULL; 
    
    printf("Quantidade de números a serem inseridos: ");
    scanf("%d", &n);
    
    for (int i = 0; i < n; i++) {
        printf("Digite o número %d: ", i + 1);
        scanf("%d", &num);
        push(&top, num);
    }
    
    printf("Números em ordem inversa:\n");
    while (top != NULL) {
        printf("%d\n", pop(&top));
    }
    
    return 0;
}
