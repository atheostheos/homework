#include <iostream>
#include <vector>
#include <array>

using namespace std;

void printarr(int nums[], int numsize)
{
    for (int i = 0; i < numsize; i++)
    {
        cout << nums[i] << " ";
    }
    cout << endl;
}

void merge(int nums[], int left, int center, int right) {
    int i = left, j = center + 1;
    vector<int> sorted_arr(0);

    int initial_left = left;

    while (i <= center && j <= right) {
        if (nums[i] < nums[j]) sorted_arr.push_back(nums[i++]);
        else sorted_arr.push_back(nums[j++]);
    }
    while (i <= center) sorted_arr.push_back(nums[i++]);
    while (j <= right) sorted_arr.push_back(nums[j++]);

    int size = right - left + 1;
    for (int i = 0; i < size; i++)
    {
        nums[i + initial_left] = sorted_arr[i];
    }
}

void mergesort(int nums[], int left, int right)
{

    if (left >= right) return;
    int center = (right + left) / 2;

    mergesort(nums, left, center);
    mergesort(nums, center+1, right);

    merge(nums, left, center, right);
}

void mergesort(int nums[], int numsize)
{
    mergesort(nums, 0, numsize-1);
}

int main()
{
    int arr[] = { 9,8,7,100,5,-4,-10,3,2,1 };
    int len = sizeof arr / sizeof (int);
    mergesort(arr, len);
    printarr(arr, len);

    return 0;
}
