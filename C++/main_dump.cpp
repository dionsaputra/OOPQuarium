#include <bits/stdc++.h>
#include "Point.hpp"
#include "Fish.hpp"
#include "Guppy.hpp"
#include "ObjekMati.hpp"
#include "MakananIkan.hpp"
using namespace std;

int main(){
	Fish *temp = new Guppy();
	ObjekMati *makan = new MakananIkan(70.0);
	Point p,q;
	p.setAbsis(100);
	p.setOrdinat(105);
	q.setAbsis(10);
	q.setOrdinat(10);
	temp -> setPosisi(p);
	temp -> getPosisi().PrintInfo();
	temp->setMoveTime(temp->getMoveTime()-1);
	cout<<temp->getStarvationPeriod()<<" ter\n";
	temp -> swimto(q,1);
	cout<<temp->getStarvationPeriod()<<" ter\n";
	temp -> getPosisi().PrintInfo();
	temp->setMoveTime(temp->getMoveTime()-1);
	temp -> swimto(q,1);
	cout<<temp->getStarvationPeriod()<<" ter\n";
	temp -> getPosisi().PrintInfo();
	temp->setMoveTime(temp->getMoveTime()-1);
}