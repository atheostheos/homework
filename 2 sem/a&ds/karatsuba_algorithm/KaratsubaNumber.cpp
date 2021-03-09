#include <iostream>

using namespace std;

class KaratsubaNumber
{
protected:
	int const capacity = 32;
	bool digits[32];

public:
	KaratsubaNumber()
	{
		for (int i = 0; i < capacity; i++)
		{
			digits[i] = 0;
		}
	}

	KaratsubaNumber(int n) 
	{
		KaratsubaNumber();
		add(n);
	}

	KaratsubaNumber(KaratsubaNumber *n)
	{
		KaratsubaNumber();
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
		for (int i = capacity - 1; i > 0; i--)
		{
			value += pow(2, capacity - i + 1);
		}
		if (digits[0]) value *= -1;

		return value;
	}

protected:
	bool* toDigits(int n)
	{
		bool d[32];
		int i = capacity-1;

		if (n < 0)
		{
			d[0] = 1;
			n *= -1;
		}

		while (n > 0)
		{
			d[i] = n % 2;
			n = div(n, 2).quot;
			i--;
		}

		return d;
	}

	int add(bool* n)
	{
		int c;
		bool addflag = false;
		
		for (int i = capacity-1 ; i > 0; i--)
		{
			c = digits[i] + n[i] + addflag;
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
	cout << n.getValue();

	return 0;
}