/*
     TEAM: VARGA Sergiu
     FAUR Cristian-Ovidiu
                            */

#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>
#include <string.h>

int g_initialized_int = 42; 
int g_zero_int = 0;         
int g_uninitialized_int;    

float g_initialized_float = 3.14f; 
float g_zero_float = 0.0f;        
float g_uninitialized_float;       

const char* check_endianness() {
    uint32_t x = 1;
    return (*(uint8_t*)&x) ? "Little Endian" : "Big Endian";
}

void print_memory_info(const char* name, void* address, size_t size, const char* type) {
    printf("Variable: %s\n", name);
    printf("  Address: %p\n", address);
    printf("  Size: %lu bytes\n", (unsigned long)size);

    printf("  Memory Encoding: ");
    uint8_t* byte_ptr = (uint8_t*)address;
    for (size_t i = 0; i < size; i++) {
        printf("%02X ", byte_ptr[i]);
    }
    printf("\n");

    size_t alignment = 0;
    if (strcmp(type, "int") == 0) {
        alignment = _Alignof(int);
    } else if (strcmp(type, "float") == 0) {
        alignment = _Alignof(float);
    }
    printf("  Alignment: %lu\n", (unsigned long)alignment);

    if (strcmp(type, "int") == 0) {
        printf("  Value: %d\n", *(int*)address);
    } else if (strcmp(type, "float") == 0) {
        printf("  Value: %.6f\n", *(float*)address);
    }
    printf("\n");
}
void print_function_parameters(int param1, float param2, int param3) {
    printf("Function Parameters:\n\n");
    print_memory_info("param1", &param1, sizeof(param1), "int");
    print_memory_info("param2", &param2, sizeof(param2), "float");
    print_memory_info("param3", &param3, sizeof(param3), "int");
}

int main() {
    printf("System Endianness: %s\n\n", check_endianness());

    int l_initialized_int = 42; 
    int l_zero_int = 0;         
    int l_uninitialized_int;    

    float l_initialized_float = 3.14f; 
    float l_zero_float = 0.0f;       
    float l_uninitialized_float;      

    print_memory_info("g_initialized_int", &g_initialized_int, sizeof(g_initialized_int), "int");
    print_memory_info("g_zero_int", &g_zero_int, sizeof(g_zero_int), "int");
    print_memory_info("g_uninitialized_int", &g_uninitialized_int, sizeof(g_uninitialized_int), "int");

    print_memory_info("g_initialized_float", &g_initialized_float, sizeof(g_initialized_float), "float");
    print_memory_info("g_zero_float", &g_zero_float, sizeof(g_zero_float), "float");
    print_memory_info("g_uninitialized_float", &g_uninitialized_float, sizeof(g_uninitialized_float), "float");

    print_memory_info("l_initialized_int", &l_initialized_int, sizeof(l_initialized_int), "int");
    print_memory_info("l_zero_int", &l_zero_int, sizeof(l_zero_int), "int");
    print_memory_info("l_uninitialized_int", &l_uninitialized_int, sizeof(l_uninitialized_int), "int");

    print_memory_info("l_initialized_float", &l_initialized_float, sizeof(l_initialized_float), "float");
    print_memory_info("l_zero_float", &l_zero_float, sizeof(l_zero_float), "float");
    print_memory_info("l_uninitialized_float", &l_uninitialized_float, sizeof(l_uninitialized_float), "float");

    print_function_parameters(123, 4.56f, 789);

    int* h_initialized_int = malloc(sizeof(int));
    int* h_zero_int = malloc(sizeof(int));
    int* h_uninitialized_int = malloc(sizeof(int));

    float* h_initialized_float = malloc(sizeof(float));
    float* h_zero_float = malloc(sizeof(float));
    float* h_uninitialized_float = malloc(sizeof(float));

    *h_initialized_int = 42;
    *h_zero_int = 0;
    *h_initialized_float = 3.14f;
    *h_zero_float = 0.0f;

    print_memory_info("h_initialized_int", h_initialized_int, sizeof(*h_initialized_int), "int");
    print_memory_info("h_zero_int", h_zero_int, sizeof(*h_zero_int), "int");
    print_memory_info("h_uninitialized_int", h_uninitialized_int, sizeof(*h_uninitialized_int), "int");

    print_memory_info("h_initialized_float", h_initialized_float, sizeof(*h_initialized_float), "float");
    print_memory_info("h_zero_float", h_zero_float, sizeof(*h_zero_float), "float");
    print_memory_info("h_uninitialized_float", h_uninitialized_float, sizeof(*h_uninitialized_float), "float");

    printf("\nMemory Sections:\n");
    printf("  .text section (code): %p\n", (void*)main);
    printf("  .data section (initialized globals): %p\n", (void*)&g_initialized_int);
    printf("  .bss section (uninitialized globals): %p\n", (void*)&g_uninitialized_int);
    printf("  Heap: %p\n", (void*)h_initialized_int);
    int stack_var;
    printf("  Stack: %p\n", (void*)&stack_var);

    free(h_initialized_int);
    free(h_zero_int);
    free(h_uninitialized_int);
    free(h_initialized_float);
    free(h_zero_float);
    free(h_uninitialized_float);

    return 0;
}
