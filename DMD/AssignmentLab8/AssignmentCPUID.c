#include <stdio.h>

void cpuid(int function_id, int *eax, int *ebx, int *ecx, int *edx) {
    __asm__ __volatile__ (
        "cpuid"                      
        : "=a" (*eax), "=b" (*ebx), "=c" (*ecx), "=d" (*edx)  // Output operands
        : "a" (function_id)                                // Input operand
    );
}

void displayBits(int value) {
    for (int i = 31; i >= 0; i--) {
        printf("%d", (value >> i) & 1);
        if (i % 8 == 0) printf(" ");
    }
    printf("\n");
}

int main() {
    int eax, ebx, ecx, edx;

    // Function 0
    cpuid(0, &eax, &ebx, &ecx, &edx);
    char vendor[13];
    ((int*)vendor)[0] = ebx;
    ((int*)vendor)[1] = edx;
    ((int*)vendor)[2] = ecx;
    vendor[12] = '\0';
    printf("Vendor ID: %s\n", vendor);

    // Function 1
    cpuid(1, &eax, &ebx, &ecx, &edx);
    int processorSignature = eax;
    printf("Processor Signature: 0x%X\n", processorSignature);
    printf("Features (ECX): ");
    displayBits(ecx);
    printf("Features (EDX): ");
    displayBits(edx);

    // Function 2
    cpuid(2, &eax, &ebx, &ecx, &edx);
    printf("Cache and TLB Information:\n");
    printf("EAX: 0x%X\n", eax);
    printf("EBX: 0x%X\n", ebx);
    printf("ECX: 0x%X\n", ecx);
    printf("EDX: 0x%X\n", edx);

    return 0;
}
