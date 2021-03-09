#include <iostream>

using namespace std;

struct Cell
{
public:
	int value;
	Cell* previous;
	Cell* next;

	Cell(int value, Cell* previous, Cell* next)
	{
		this->value = value;
		this->previous = previous;
		this->next = next;
	}

	int get(int n)
	{
		if (n <= 0) return value;
		return next->get(n - 1);
	}
};

struct LinkedList
{
	int size = 0;
	struct Cell* head = NULL;
	struct Cell* tail = NULL;

	void add(int value)
	{
		addlast(value);
	}

	void addfirst(int value)
	{
		Cell* newcell = new Cell{ value, NULL, head };
		head->previous = newcell;
		head = newcell;
		size += 1;
	}

	void addlast(int value)
	{
		if (size == 0)
		{
			head = new Cell{ value, NULL, NULL };
			tail = head;
		}
		else
		{
			Cell* newcell = new Cell{ value, tail, NULL };
			tail->next = newcell;
			tail = newcell;
		}
		size += 1;
	}

	void deletefirst()
	{
		head = head->next;
		delete head->previous;
		head->previous = NULL;
		size -= 1;
	}

	void deletelast()
	{
		tail = tail->previous;
		delete tail->next;
		tail->next = NULL;
		size -= 1;
	}

	int get(int n)
	{
		return head->get(n);
	}

	void printlist()
	{
		Cell* cell = head;
		cout << "{";
		for (int i = 0; i < size; i++)
		{
			cout << (cell->value);
			if (i < (size - 1)) cout << ", ";
			cell = cell->next;
		}
		cout << "}" << endl;
	}
};

struct Queue
{
	int const INC_SIZE = 5;
	int capacity = 5;
	int size = 0;
	int* ar = new int[capacity];

	void add(int value)
	{
		if (size >= capacity) resize();
		ar[size++] = value;
	}

	int pop() {
		if (size < 1) throw out_of_range("No elements added.");
		int value = ar[0];
		for (int i = 1;i < size; i++)
		{
			ar[i - 1] = ar[i];
		}
		size--;
		return value;
	}

	int peep() {
		if (size < 1) throw out_of_range("No elements added.");
		return ar[0];
	}

	void resize() {
		capacity += INC_SIZE;
		int* newar = new int[capacity];
		for (int i = 0;i < size; i++)
		{
			newar[i] = ar[i];
		}
		delete ar;
		ar = newar;
	}
};

int main()
{
	LinkedList lst;

	lst.add(1);
	lst.add(2);
	lst.add(3);
	lst.addlast(4);

	lst.printlist();
	cout << lst.get(1) << endl;
	lst.deletefirst();
	lst.deletelast();
	lst.printlist();

	cout;
	//lst.addlast(5);
	//cout << lst.get(3) << endl;
	//lst.deletelast();
	//cout << lst.get(3) << endl;

	//

	//queue queue;
	//queue.add(1);
	//queue.add(2);
	//cout << queue.peep() << endl;
	//cout << queue.pop() << endl;
	//cout << queue.pop() << endl; 

}