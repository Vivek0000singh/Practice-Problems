#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Users
{
private:
    int userid;
    string name;
    string email;
    string pwd;

public:
    Users(int userid,
          string name,
          string email,
          string pwd)
    {
        this->userid = userid;
        this->name = name;
        this->email = email;
        this->pwd = pwd;
    }

    int getId()
    {
        return userid;
    }

    string getEmail()
    {
        return email;
    }
    string getPwd()
    {
        return pwd;
    }
    string getName()
    {
        return name;
    }

    string setPwd(string newpwd)
    {
        this->pwd = newpwd;
    }

    void display()
    {
        cout << "UserId: " << userid << " , name" << name << " , email" << email << endl;
    }
};

int main()
{
    vector<Users> users;
    int choice;

    do
    {
        cout << "\n1.Add user \n2.Display all user \n3.Search user \n4.change pwd \n5.delete all \n6.Exit \nEnter your choice";

        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            int id;
            string name, email, pwd;

            cout << "Enter Userid: " << endl;
            cin >> id;

            cout << "Enter Name: " << endl;
            cin.ignore();
            getline(cin, name);
            cout << "Enter Email: " << endl;
            cin.ignore();
            getline(cin, email);

            cout << "Enter pwd: " << endl;
            cin.ignore();
            getline(cin, pwd);

            users.emplace_back(id, name, email, pwd);

            break;
        }

        case 2:
        {
            for (auto &u : users)
            {
                u.display();
            }
            break;
        }

        case 3:
        {
            int id;
            cout << "Enter the id to search for user ";
            cin >> id;

            bool found = false;

            for (auto &u : users)
            {
                if (u.getId() == id)
                {
                    u.display();
                    found = true;
                }
            }
            if (!found)
            {
                cout << "Not found";
            }
            break;
        }

        case 4:
        {
            int id;
            string newPwd;

            cout << "Enter id:";
            cin >> id;

            cout << "Enter newpwd: " << endl;
            cin.ignore();
            getline(cin, newPwd);

            for (auto &u : users)
            {
                if (u.getId() == id)
                {
                    u.setPwd(newPwd);
                    cout << "Password updated." << endl;
                }
            }
            break;
        }

        case 5:
        {
            cout << "removed all";
            users.clear();
            break;
        }
        }

    } while (choice != 6);

    return 0;
}