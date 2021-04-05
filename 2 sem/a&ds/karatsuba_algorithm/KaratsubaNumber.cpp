#include <iostream>
#include <vector>

using namespace std;

class KaratsubaNumber
{
protected:
	int const capacity = 64;
	vector<bool> digits;

public:
	KaratsubaNumber()
	{
		for (int i = 0; i < capacity; i++)
		{
			digits.push_back(0);
		}
	}

	KaratsubaNumber(long n) :KaratsubaNumber()
	{
		add(n);
	}

	KaratsubaNumber(KaratsubaNumber *n) :KaratsubaNumber()
	{
		add(n);
	}

	long add(long n)
	{
		digits = add(digits, toDigits(n));
		return toNumber(digits);
	}

	long add(KaratsubaNumber* n)
	{
		digits = add(digits, n->digits);
		return toNumber(digits);
	}

	long subtract(long n)
	{
		digits = add(digits, toDigits(-n));
		return toNumber(digits);
	}

	long subtract(KaratsubaNumber* n)
	{
		digits = add(digits, inverse(n->digits));
		return toNumber(digits);
	}

	long multiply(long n)
	{
		digits = karatsubaMultiply(digits, toDigits(n), capacity);
		return toNumber(digits);
	}

	long multiply(KaratsubaNumber* n)
	{
		digits = karatsubaMultiply(digits, n->digits, capacity);
		return toNumber(digits);
	}

	long getValue()
	{
		return toNumber(digits);
	}

	void printDigits()
	{
		for (bool el : digits)
		{
			cout << el << " ";
		}
		cout << endl;
	}

protected:

	vector<bool> add(vector<bool> d, vector<bool> n)
	{
		int size = d.size();
		int c;
		bool addflag = false;

		for (int i = size-1 ; i > 0; i--)
		{
			c = d.at(i) + n[i] + addflag;
			switch (c)
			{
			case 1:
				d[i] = 1;
				addflag = false;
				break;
			case 2:
				d[i] = 0;
				addflag = true;
				break;
			case 3:
				d[i] = 1;
				addflag = true;
				break;
			default:
				d[i] = 0;
				addflag = false;
				break;
			}
		}
		c = d[0] + n[0] + addflag;
		d[0] = (c == 1 || c == 3) ? 1 : 0;

		return d;
	}

	vector<bool> subtract(vector<bool> d, vector<bool> n)
	{
		n = inverse(n);
		return add(d, n);
	}

	vector<bool> arithemticMultiply(vector<bool> d, vector<bool> n)
	{
		int size = d.size();
		bool negative = d[0] ^ n[0];
		vector<bool> temp;

		if (d[0]) d = inverse(d);
		if (n[0]) n = inverse(n);
		
		temp = d;
		d.clear();
		d.resize(size, 0);
		d[0] = temp[0];

		for (int i = size - 1; i > 0 && !temp[0]; i--)
		{
			if (n[i]) d = add(d, temp);
			temp = bitshift(temp, 1);
		}

		if (negative) d = inverse(d);
		
		return d;
	}

	vector<bool> karatsubaMultiply(vector<bool> d, vector<bool> n, int size)
	{
		if (size <= 4) return arithemticMultiply(d, n);

		bool negative = d[0] ^ n[0];
		if (d[0]) d = inverse(d);
		if (n[0]) n = inverse(n);

		int middle = size / 2;
		vector<bool> a(d.end()-size, d.end() - middle);
		vector<bool> b(d.end() - middle, d.end());
		vector<bool> c(n.end()-size, n.end() - middle);
		vector<bool> e(n.end() - middle, n.end());

		while (a.size() != capacity)
		{
			a.insert(a.begin(), 0);
			b.insert(b.begin(), 0);
			c.insert(c.begin(), 0);
			e.insert(e.begin(), 0);
		}

		vector<bool> ac = karatsubaMultiply(a, c, middle);
		vector<bool> be = karatsubaMultiply(b, e, middle);
		vector<bool> ab_ce = karatsubaMultiply(add(a, b), add(c, e), middle);

		vector<bool> result = add(add(bitshift(ac, middle*2), bitshift(subtract(ab_ce, add(ac, be)), middle)), be);

		if (negative) result = inverse(result);
		
		return result;

	}

	long toNumber(vector<bool> d)
	{
		long value = 0;

		for (int i = capacity - 1; i > 0; i--)
		{
			if (d[i] ^ d[0]) value += pow(2, capacity - 1 - i);
		}
		if (d[0])
		{
			value *= -1;
			value -= 1;
		}
		
		return value;
	}

	vector<bool> toDigits(long n)
	{
		vector<bool> d(capacity, 0);
		int i = capacity - 1;
		bool negative = false;

		if (n < 0)
		{
			negative = true;
			n *= -1;
		}

		while (n > 0)
		{
			d[i] = (int)n % 2;
			n /= 2;
			i--;
		}

		if (negative) d = inverse(d);

		return d;
	}

	vector<bool> inverse(vector<bool> d)
	{
		if (toNumber(d) == 0) return d;

		bool negative = d[0];
		vector<bool> one;

		if (negative)
		{
			one.resize(capacity, 1);

			d = add(d, one);
			d[0] = 0;
		}

		for (int i = 1; i < capacity; i++)
		{
			d[i] = !d[i];
		}

		if (!negative)
		{
			one.resize(capacity, 0);
			one[capacity - 1] = 1;

			d[0] = 1;
			d = add(d, one);
		}

		return d;
	}

	vector<bool> bitshift(vector<bool>d, int length)
	{
		int size = d.size();

		for (int i = 0; i < size-length; i++)
		{
			d[i] = d[i + length];
		}
		for (int i = size-length; i < size; i++)
		{
			d[i] = 0;
		}

		return d;
	}

};

int main()
{
	KaratsubaNumber n1 = new KaratsubaNumber(2147);
	cout << n1.multiply(-153151) << endl;
	n1.printDigits();

	return 0;
}