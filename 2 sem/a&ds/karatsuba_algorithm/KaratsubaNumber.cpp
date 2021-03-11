#include <iostream>
#include <vector>

using namespace std;

class KaratsubaNumber
{
protected:
	int const capacity = 32;
	vector<bool> digits;

public:
	KaratsubaNumber()
	{
		digits.resize(capacity, 0);
	}

	KaratsubaNumber(int n) :KaratsubaNumber()
	{
		add(n);
	}

	KaratsubaNumber(KaratsubaNumber *n) :KaratsubaNumber()
	{
		add(n);
	}

public:
	int add(int n)
	{
		return add(toDigits(n));
	}

	int add(KaratsubaNumber* n)
	{
		return add(n->digits);
	}

	int getValue()
	{
		int value = 0;
		bool negative;
		if (digits[0])
		{
			negative = true;
			inverse(digits);
		}
		for (int i = capacity - 1; i > 0; i--)
		{
			if (digits[i])
			{
			value += pow(2, capacity-1- i);
			}
		}
		if (negative)
		{
			value *= -1;
			inverse(digits);
		}

		return value;
	}

	void printDigits()
	{
		for (int el : digits)
		{
			cout << el << " ";
		}
		cout << endl;
	}

protected:
	vector<bool> toDigits(int n)
	{
		vector<bool> d(32,0);
		int i = capacity-1;
		bool negative = false;

		if (n < 0)
		{
			negative = true;
			n *= -1;
		}

		while (n > 0)
		{
			d[i] = n % 2;
			n = div(n, 2).quot;
			i--;
		}

		if (negative) inverse(d);

		return d;
	}

	void inverse(vector<bool> d)
	{
		for (int i = 0; i < capacity; i++) 
		{
			d[i] = !d[i];
		}
		add(1);
	}

	int add(vector<bool> n)
	{
		int c;
		bool addflag = false;
		
		for (int i = capacity-1 ; i > 0; i--)
		{
			c = digits.at(i) + n[i] + addflag;
			switch (c)
			{
			case 1:
				digits[i] = 1;
				addflag = false;
				break;
			case 2:
				digits[i] = 0;
				addflag = true;
				break;
			case 3:
				digits[i] = 1;
				addflag = true;
				break;
			}
		}
		digits[0] = !digits[0] || addflag;

		return getValue();
	}

	
	
};

int main()
{
	KaratsubaNumber n = new KaratsubaNumber();

	n.add(10);
	cout << n.getValue() << endl;
	n.printDigits();

	return 0;
}