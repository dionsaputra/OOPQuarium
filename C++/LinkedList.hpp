#ifndef LINKEDLIST_HPP
#define LINKEDLIST_HPP
#include <iostream>
using namespace std;
//Linear list with First and Last pointer
template <class Type>
class LinkedList{
    public:
        //Default constructor
        LinkedList(){
            First = Last = NULL;
        }

        //Copy Constructor
        LinkedList(const LinkedList& LL){
            if(LL.isEmpty()){

                First = Last = NULL;
            }
            else{
                First = NULL;
                Last = NULL;
                ElmtList *P = LL.First;
                while(P != NULL){
                    add(P->info);
                    P = P->next;
                }
            }
        }

        //destruct all the element
        ~LinkedList(){
            if(isEmpty()){

            }
            else{
                ElmtList *P = First;
                ElmtList *temp;

                while(P != NULL){
                    temp = P->next;
                    delete[] P;
                    if(temp!=NULL){
                        P = temp->next;
                    }
                    else{
                        P = NULL;
                    }
                }
            }
        }
        //deep copy all of the element
        LinkedList& operator=(const LinkedList& LL){
            if(LL.isEmpty()){
                First = Last = NULL;
            }
            else{
                ElmtList *P = LL.First;
                while(P != NULL){
                    add(P->info);
                    P = P->next;
                }
            }
            return *this;
        }

        //check whether a list is empty
        bool isEmpty() const{
            return (First == NULL);
        }

        //Add a element in the last
        void add(Type T){
            if(isEmpty()){
                First = Last = new ElmtList(T);
            }
            else{
                Last->next = new ElmtList(T);
                Last = Last->next;
            }
        }
        //remove an element in list
        void remove(Type T){
            if(isEmpty()){

            }
            else{
                //T must be exist in the list
                ElmtList *P = First;
                ElmtList *Prev = NULL;
                while(P->info != T){
                    Prev = P;
                    P = P->next;
                }
                if(P == First){
                    //if in the first element
                    if(P == Last){
                        delete[]P;
                        First = Last = NULL;
                    }
                    else{
                        First = P->next;
                        delete[]P;
                    }
                }
                else if(P == Last){
                    Prev->next = NULL;
                    Last = Prev;
                    delete[]P;
                }
                else{
                    Prev->next = P->next;
                    delete[]P;
                }
            }
        }
        //find an element in list and returns its index (starts from 0)
        //return -1 if not found
        int find(Type T){
            if(isEmpty()){
                return -1;
            }
            else{
                ElmtList *P = First;
                int idx = 0;
                while(P != NULL){
                    if(P->info == T){
                        return idx;
                    }
                    else{
                        idx++;
                        P  = P->next;
                    }
                }
                //if not found
                return -1;
            }
        }

        //return element of an index
        //index MUST be valid
        Type& get(int _idx){
            int x = 0;
            ElmtList* P = First;
            while(x < _idx){
                P = P->next;
                x++;
            }
            return P->info;
        }
        //Print All Elements in the list
        void PrintAllElement(){
            if(isEmpty()){
                cout<<"List Empty !"<<endl;
            }
            else{
                ElmtList *P = First;
                while(P != NULL){
                    P->info.printInfo();
                    cout<<endl;
                    P = P->next;
                }
            }
        }
        int totalElmt(){
            int countElmt = 0;
            ElmtList *P = First;
            while(P != NULL){
                countElmt++;
                P = P->next;
            }
            return countElmt;
        }
    private:
        class ElmtList{
            public:
                ElmtList(Type _info){
                    info = _info;
                    next = NULL;
                }
                Type info;
                ElmtList *next;
        };
        ElmtList* First;
        ElmtList* Last;
};

#endif
