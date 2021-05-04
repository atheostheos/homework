#pragma once
#include <vector>
#include <iostream>
#include <chrono>

using namespace std;
using namespace std::chrono;


const int INF = 99;

vector<vector<int>> getGraph(int n, int m);
void printGraph(vector<vector<int>>);


vector<vector<vector<int>>> calculateFWFull(vector<vector<int>> graph);
vector<vector<int>> calculateFW(vector<vector<int>> graph);
void printRoutes(vector<vector<vector<int>>> routes);
int getMaxEdgesAmount(int v);


void testAlgorithm();
