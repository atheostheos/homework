#include <iostream>
#include <ctime>
#include "Header.h"

int main()
{
    vector<vector<int>> graph = { {0,0,0,0,26},
                                   {22,0,-6,26,0},
                                   {-2,0,0,2,0},
                                   {0,0,0,0,0},
                                   {0,18,0,6,0} };
   printRoutes(calculateFWFull(graph));
   //testAlgorithm();

    return 0;
}

