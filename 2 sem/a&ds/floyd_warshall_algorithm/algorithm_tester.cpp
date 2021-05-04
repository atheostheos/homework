#include "Header.h"
#include <fstream>

void testAlgorithm() {
    ofstream out("out_even.txt");
    vector<int> v = { 10,30,50,70,80,100,110,120,130};
    vector<int> e = { 40};

    vector<vector<int>> graph;
    vector<vector<vector<int>>> routes;

    const int REPEAT_AMOUNT = 30;
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
        for (int j = 0; j < e.size(); j++)
        {
            if (e[j] > getMaxEdgesAmount(v[i])) continue;
            out << v[i] << endl;
            //out << e[j] << endl;
            for (int r = 0; r < REPEAT_AMOUNT; r++)
            {
                graph = getGraph(v[i], e[j]);

                high_resolution_clock::time_point start = high_resolution_clock::now();

                routes = calculateFWFull(graph);

                high_resolution_clock::time_point end = high_resolution_clock::now();
                duration<double> time = duration_cast<duration<double>>(end - start);

                out << time.count()*1000 << endl;
            }
        }
        cout << "done" << endl;
    }
    out.close();
}