#include <stdio.h>
#include <stdlib.h>

int* heap_alloc(int size) {
    // memory allocated by malloc is placed on the heap and will continue
    // to exist until we deallocate it
    int* arr = (int *)malloc(size * sizeof(int));
    return arr;
}

int* stack_alloc() {
    int arr[15]; // exists on the stack, will be "released" when bar returns
    arr[0] = -43;
    return arr;
}

int main(int argc, char** argv) {
    int* heap_arr = heap_alloc(15);
    int* stack_arr = stack_alloc(); // ??? Should not do this!!

    heap_arr[0] = 19;
    heap_arr[14] = 989;
    printf("%d\n", heap_arr[0]);
    printf("%d\n", stack_arr[0]);

    printf("before free: %p\n",heap_arr);
    free(heap_arr);
    printf("after free: %p\n",heap_arr);
    heap_arr = NULL;
}