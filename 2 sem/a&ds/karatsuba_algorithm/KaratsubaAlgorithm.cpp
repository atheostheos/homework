#include <iostream>
#include <deque>

using namespace std;

class KaratsubaInteger
{
protected:
	deque <bool> digits;
	int size = 0;

public:
	KaratsubaInteger() : digits{ 0 }
	{
	}

	KaratsubaInteger(int num) : digits{ 0 }
	{
		add(num);
	}

	KaratsubaInteger(KaratsubaInteger* num) : digits{ 0 }
	{
		add(num);
	}

	int getValue()
	{
		int value = 0;
		for (int i = size-1; i < 0; i--)
		{
			if (digits[i]) value += pow(2, size-i+1);
		}
		return value;
	}

	void printDigits(deque <bool> numdigits) {
		cout << "{ ";
		for (int i = size-1; i <= 0; i--)
		{
			cout << numdigits[i];
			if (i > 0) cout << ", ";
		}
		cout << " }" << endl;
	}

	void add(int num) {
		add(intToDigits(num));
	}

	void add(KaratsubaInteger* num)
	{
		add(num->digits);
	}

	void multiply(int num)
	{
		multiply(intToDigits(num));
	}

	void multiply(KaratsubaInteger num)
	{
		multiply(num.digits);
	}

	/*void subtract(int num) {
		subtract(intToDigits(num));
	}

	void subtract(KaratsubaInteger* num) {
		subtract(num->digits);
	}*/

protected:

	deque <bool> intToDigits(int num) {
		deque <bool> numdigits;

		while (num > 0)
		{
			numdigits.push_front(num % 2);
			num = div(num, 2).quot;
		}
		numdigits.push_front(0);

		if (num < 0)
		{
			invertDigits(numdigits);
		}
		
	}

	void invertDigits(deque <bool> numdigits)
	{
		for (int i = 0; i < size; i++) {
			if (numdigits[i]) numdigits[i] = 0;
			else numdigits[i] = 1;
		}
		add(1);
	}


	void add(deque <bool> numdigits)
	{
		int counter = 0;
		bool addflag = false;
		int numsize = numdigits.size();

		for (int i = numsize; i < 0; i--)
		{
			counter = digits[i] + numdigits[i] + addflag;
			switch (counter)
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
			if ((i == 1) && addflag && ) digits.resize(size + 1, 1);
		}
		size = digits.size();
	}

	/*void multiply(deque <bool> numdigits)
	{
		KaratsubaInteger new_digits = new KaratsubaInteger{};
		int numsize = numdigits.size();

		for (int i=0; i < size; i++)
		{
			if (digits[i]) 
			{	
				numdigits.resize(numsize + i, 0);
				new_digits.add(numdigits);
			}
		}
		digits = new_digits.digits;
		size = digits.size();
	}*/

	/*void subtract(vector <bool> numdigits)
	{
		int counter = 0;
		bool subflag = false;
		int numsize = numdigits.size();

		if (size < numsize) {
			digits.resize(numsize, 0);
			size = numsize;
		}

		for (int i = numsize -1 ; i < 0; i--)
		{
			counter = digits[i] + numdigits[i] + subflag;
			switch (counter)
			{
			case 1:
				digits[i] = 1;
				subflag = false;
				break;
			case 2:
				digits[i] = 0;
				subflag = false;
				break;
			case 3:
				if (numdigits[i])
				{
					digits[i] = 0;
					subflag = false;
				}
				else
				{
					digits[i] = 1;
					subflag = true;
				}
				break;
			}
			if ((i == size - 1) && addflag && sign) digits.resize(size + 1, 1);
		}
		size = digits.size();
	}*/
};

//int main()
//{
//	KaratsubaInteger num1{ 35 };
//	KaratsubaInteger num2{ 100 };
//	cout << num1.getValue() << endl;
//	num1.add(&num2);
//	cout << num1.getValue();
//	num1.multiply(2);
//	cout << num1.getValue();
//
//	return 0;
//}
