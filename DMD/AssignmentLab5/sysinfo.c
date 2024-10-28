#include <stdio.h>
#include <windows.h>
#include <psapi.h>

void printMemorySize(DWORDLONG sizeInBytes) {
    if (sizeInBytes >= (1ULL << 30)) {
        printf("%llu GB\n", sizeInBytes / (1ULL << 30));
    } else if (sizeInBytes >= (1ULL << 20)) {
        printf("%llu MB\n", sizeInBytes / (1ULL << 20));
    } else if (sizeInBytes >= (1ULL << 10)) {
        printf("%llu KB\n", sizeInBytes / (1ULL << 10));
    } else {
        printf("%llu Bytes\n", sizeInBytes);
    }
}

void displayPerformanceInfo(SYSTEM_INFO sysInfo) {

    PERFORMANCE_INFORMATION perfInfo;
    perfInfo.cb = sizeof(perfInfo);
    if (GetPerformanceInfo(&perfInfo, sizeof(perfInfo))) {
        printf("Total commited memory: %llu pages\n", perfInfo.CommitTotal);
        printf("Commit limit: %llu pages\n", perfInfo.CommitLimit);
        
        DWORDLONG kernelMemorySize = perfInfo.KernelPaged * sysInfo.dwPageSize + 
                                      perfInfo.KernelNonpaged * sysInfo.dwPageSize;

        printf("Kernel memory size: ");
        printMemorySize(kernelMemorySize);

        printf("Number of running processes: %lu\n", perfInfo.ProcessCount);
    }
}

void displaySystemInfo() {

    SYSTEM_INFO sysInfo;
    GetSystemInfo(&sysInfo);

    printf("Page size: %lu bytes\n", sysInfo.dwPageSize);

    printf("Virtual address space: [ 0x%ph - 0x%ph ]\n",
    sysInfo.lpMinimumApplicationAddress, sysInfo.lpMaximumApplicationAddress);
    
    printf("Number of logical processors: %lu\n", sysInfo.dwNumberOfProcessors);

    displayPerformanceInfo(sysInfo);
}

void displayMemoryStatus() {

    MEMORYSTATUSEX memStatus;
    memStatus.dwLength = sizeof(memStatus);
    GlobalMemoryStatusEx(&memStatus);

    printf("Total physical memory: ");
    printMemorySize(memStatus.ullTotalPhys);

    printf("Available physical memory: ");
    printMemorySize(memStatus.ullAvailPhys);

    printf("Total virtual memory: ");
    printMemorySize(memStatus.ullTotalVirtual);

    printf("Available virtual memory: ");
    printMemorySize(memStatus.ullAvailVirtual);
}

LPVOID allocateVirtualMemory(DWORDLONG bytes) {

    LPVOID allocatedMemory = 
    VirtualAlloc(NULL, bytes , MEM_RESERVE | MEM_COMMIT, PAGE_READWRITE);

    if (allocatedMemory != NULL) {

        printf("\nAllocated virtual memory in the address space of the current process: ");
        printMemorySize(bytes);
       
    } else {
        perror("\nFailed to allocate memory.\n");
        exit(1);
    }

    return allocatedMemory;
}

int main() {
    
    printf("\nSystem info:\n");
    displaySystemInfo();

    printf("\nMemory Status before allocation:\n");
    displayMemoryStatus();

    LPVOID allocatedMemory = allocateVirtualMemory(1024 * 1024);

    printf("\nMemory Status after allocation:\n");
    displayMemoryStatus();
    
    if( allocatedMemory != NULL) {
        VirtualFree(allocatedMemory, 0, MEM_RELEASE);
    }
    return 0;
}
//gcc sysinfo.c -lpsapi