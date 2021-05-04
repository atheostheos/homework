#include<iostream>
#include "Header.h"

vector<vector<vector<int>>> calculateFWFull(vector<vector<vector<int>>> routes, int k, int v)
{
	if (k > routes[0].size()) return routes;

	routes[k] = routes[k-1];
	for (int i = 0; i < v; i++) 
	{
		for (int j = 0; j < v; j++) 
		{
			if (routes[k][i][k - 1] == INF || routes[k][k - 1][j] == INF) continue;

			routes[k][i][j] = min(routes[k][i][j], routes[k][i][k - 1] + routes[k][k - 1][j]);
		}
	}

	return calculateFWFull(routes, k + 1, v);
}


vector<vector<vector<int>>> calculateFWFull(vector<vector<int>> graph) 
{
	int v = graph.size();
	for (int i=0; i < v; i++) {
		for (int j=0; j < v; j++) {
			if ((i != j) && (graph[i][j] == 0)) graph[i][j] = INF;
		}
	}

	vector<vector<vector<int>>> routes(v+1);
	routes[0] = graph;

	return calculateFWFull(routes, 1, v);
}

vector<vector<int>> calculateFW(vector<vector<int>> routes, int k, int v)
{
	if (k > v) return routes;
	for (int i = 0; i < v; i++)
	{
		for (int j = 0; j < v; j++)
		{
			if (routes[i][k - 1] == INF || routes[k - 1][j] == INF) continue;

			int new_value = routes[i][k - 1] + routes[k - 1][j];
			if (routes[i][j] > new_value) routes[i][j] = new_value;
		}
	}

	return calculateFW(routes, k + 1, v);
}


vector<vector<int>> calculateFW(vector<vector<int>> graph)
{
	int v = graph.size();
	for (int i = 0; i < v; i++) {
		for (int j = 0; j < v; j++) {

			if ((i != j) && (graph[i][j] == 0)) graph[i][j] = INF;
		}
	}

	return calculateFW(graph, 1, v);
}

void printRoutes(vector<vector<vector<int>>> routes)
{
	for (int k=0; k < routes.size(); k++)
	{
		cout << "k = " << k << endl;
		printGraph(routes[k]);
	}
}