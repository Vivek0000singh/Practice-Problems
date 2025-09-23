#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void showVector(const vector<int> &v)
{
    cout << "[ ";
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
    cout << "]" << endl;
}

int main()
{
    vector<int> v;
    int choice;

    do

    {
        cout << "\n1.add \n2.show all  \n3.search \n4.sort \n5.reverse \n6.clear \n7.Exit \nEnter choice:";
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            int val;
            cout << "Enter value:";
            cin >> val;

            v.push_back(val);
            break;
        }

        case 2:
        {
            showVector(v);
            break;
        }

        case 3:
        {
            int key;
            cout << "Enter the key";
            cin >> key;
            bool found = false;
            for (int i = 0; i < v.size(); i++)
            {
                if (v[i] == key)
                {
                    cout << "Found at pos" << i << endl;
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                cout << "Notfound" << endl;
            }
            break;
        }

        case 4:
        {
            sort(v.begin(), v.end());
            cout << "Sorted";
            showVector(v);
            break;
        }
        case 5:
        {
            reverse(v.begin(), v.end());
            cout << "Reversed:";
            showVector(v);
            break;
        }

        case 6:
        {
            v.clear();
            cout << "Cleared";
            showVector(v);
            break;
        }
        }
    } while (choice != 7);

    return 0;
}