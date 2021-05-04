#include "Header.h"

const int MAX_EDGE_VALUE = 10;

int getMaxEdgesAmount(int v)
{
	int amount = 0;
	for (int i = 1; i < v; i++)
	{
		amount += i;
	}
	return amount;
}

vector<vector<int>> getGraph(int v, int e)
{
	
	vector<vector<int>> graph(v);
	for (int i=0; i<v; i++)
	{
		graph[i].resize(v);
	}

	int count = 0;

	srand(time(NULL));
	while (count != e) 
	{
		int i = rand() % v;
		int j = rand() % v;
		if ((i != j) && (graph[i][j] == 0))
		{
			int value = rand() % MAX_EDGE_VALUE*4 - MAX_EDGE_VALUE;
			if (graph[j][i] == 0)
			{
				graph[i][j] = value;
				count++;
			}
		}
	}
	
	return graph;
}

void printGraph(vector<vector<int>> graph)
{
	for (vector<int> line : graph)
	{
		for (int value : line) {
			if (value == INF) 
				printf("   -");
			else 
				printf("%4d", value);
		}
		cout << endl;
	}
}