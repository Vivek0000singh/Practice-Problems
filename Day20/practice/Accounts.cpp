#include <iostream>
#include <map>
#include <string>

using namespace std;

class Account
{
private:
    int actid;
    string name;
    double balance;

public:
    Account(int actid, string name, double balance)
    {

        this->actid = actid;
        this->name = name;
        this->balance = balance;
    }

    void display()
    {
        cout << "AcCtId: " << actid << " Name: " << name << " Balance: " << balance;
    }
};

int main()
{

    map<int, Account> a;

    int choice;

    do
    {

        cout << "\n1.Add Account \n2.DisplayAll \n3.Search for the id  \n4.remove all accounts \n5.exit \nEnterYour choice: ";

        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            int id;
            string name;
            double balance;

            cout << "Enter id: " << endl;
            cin >> id;

            cout << "Name: " << endl;
            cin >> name;

            cout << "Balance :" << endl;
            cin >> balance;

            a[id] = Account(id, name, balance);
            break;
        }

        case 2:
        {
            cout << "Show All Details";

            for (auto &it : a)
            {
                it.second.display();
            }
            break;
        }

        case 3:
        {
            int id;
            cout << "Enter id to search";
            cin >> id;

            auto it = a.find(id);
            if (it != a.end())
            {
                it->second.display();
            }
            else
            {
                cout << "Not found";
            }
            break;
        }

        case 4:
        {
            a.clear();
            cout << "All accounts removed";

            break;
        }
        }

    } while (choice != 5);

    return 0;
}