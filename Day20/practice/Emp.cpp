#include <iostream>
#include <string>
using namespace std;

class Emp
{
protected:
    int id;
    string name;
    int deptId;
    double BasicSalary;

public:
    Emp(int id, string name, int deptId, double BasicSalary) : id(id), name(name), deptId(deptId), BasicSalary(BasicSalary)
    {
    }

    virtual double computeNetSalary()
    {
        return 0;
    }

    virtual void display()
    {
        cout << "Id: " << id << "Name: " << name << "depId:" << deptId << "BasicSalary: " << BasicSalary << endl;
    }

    virtual ~Emp() {};
};

class Mgr : public Emp
{
protected:
    double perfbonus;

public:
    Mgr(int id, string name, int deptId, double BasicSalary, double perfbonus) : Emp(id, name, deptId, BasicSalary), perfbonus(perfbonus) {}

    double computeNetSalary() override
    {
        return BasicSalary + perfbonus;
    }

    void display() override
    {

        Emp::display();
        cout << "perfbonus " << perfbonus << endl;
    }
};

class Wrkr : public Emp
{
protected:
    int hourlyWorked;
    int hourlyrate;

public:
    Wrkr(int id, string name, int deptId, double BasicSalary, int hourlyWorked, int hourlyrate) : Emp(id, name, deptId, BasicSalary), hourlyWorked(hourlyWorked), hourlyrate(hourlyrate) {}

    int getHourlyRate()
    {
        return hourlyrate;
    }

    double computeNetSalary() override
    {
        return BasicSalary + (hourlyWorked * hourlyrate);
    }

    void display() override
    {

        Emp::display();
        cout << "hourlyWorked " << hourlyWorked << "hourlyrate" << hourlyrate;
    }
};
int main()
{
    const int Max = 100;
    Emp *org[Max];
    int count = 0;
    int choice;

    do
    {
        cout << "\n1. Hire Manager\n2. Hire Worker\n3. Display all Employees\n4. Exit\nEnter choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            int id, dId;
            string name;
            double bs, perfB;

            cout << "Enter ID: ";
            cin >> id;
            cout << "Enter Name: ";
            cin >> name;
            cout << "Enter Dept ID: ";
            cin >> dId;
            cout << "Enter Basic Salary: ";
            cin >> bs;
            cout << "Enter Performance Bonus: ";
            cin >> perfB;

            // Corrected argument order
            org[count++] = new Mgr(id, name, dId, bs, perfB);
            break;
        }
        case 2:
        {
            int id, dId, hw, hr;
            string name;
            double bs;

            cout << "Enter ID: ";
            cin >> id;
            cout << "Enter Name: ";
            cin >> name;
            cout << "Enter Dept ID: ";
            cin >> dId;
            cout << "Enter Basic Salary: ";
            cin >> bs;
            cout << "Enter Hours Worked: ";
            cin >> hw;
            cout << "Enter Hourly Rate: ";
            cin >> hr;

            // Corrected argument order
            org[count++] = new Wrkr(id, name, dId, bs, hw, hr);
            break;
        }
        case 3:
        {
            cout << "\n--- Employee Details ---" << endl;
            for (int i = 0; i < count; ++i)
            {
                org[i]->display();
                cout << ", Net Salary: " << org[i]->computeNetSalary() << endl;
            }
            cout << "------------------------" << endl;
            break;
        }
        }
    } while (choice != 4);

    // Clean up allocated memory
    for (int i = 0; i < count; ++i)
    {
        delete org[i];
    }

    cout << "Exiting program." << endl;
    return 0;
}