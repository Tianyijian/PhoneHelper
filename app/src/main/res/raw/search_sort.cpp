#include<iostream>
#include<stdlib.h>
#include<time.h>
using namespace std;
#define Max 1000000
#define N1 10000
#define N2 30000
#define N3 50000
#define N4 300000
#define N5 500000
#define N6 8000000


struct records{
	int key;
	char s;
};
typedef records LIST[Max];

void CreateList(LIST &A,int n)//m��ʾ��Χ��n��ʾ���� 
{
	for(int i=1;i<=n;i++)
	{
		A[i].key=(rand()*rand())%1000;
	}
}

void ShowList(LIST A,int n)
{
	for(int i=1;i<=n;i++)
	{
		cout<<A[i].key<<"\t";
		if(i%5==0)
		cout<<endl;
	}
	cout<<endl;
}

void Excle1(double time[3][3])
{
	cout<<"��ģ\t����\t����\t����"<<endl;
	for(int i=0;i<3;i++)
	{
		if(i==0)
		cout<<"10000\t";
		if(i==1)
		cout<<"30000\t";
		if(i==2)
		cout<<"50000\t";
		for(int j=0;j<3;j++)
		{
			cout<<time[i][j]<<"\t";
		}
		cout<<endl;
	}
}

void Excle2(double time[3][2])
{
	cout<<"��ģ\t�ǵݹ�\t�ݹ�"<<endl;
	for(int i=0;i<3;i++)
	{
		if(i==0)
		cout<<"10000\t";
		if(i==1)
		cout<<"30000\t";
		if(i==2)
		cout<<"50000\t";
		for(int j=0;j<2;j++)
		{
			cout<<time[i][j]<<"\t";
		}
		cout<<endl;
	}
}

void Rorder(LIST A,LIST &B,int n)
{
	for(int i=1;i<=n;i++)
	{
		B[i].key=A[n-i+1].key;
		B[i].s=A[n-i+1].s;
	}
}

void BubbleSort(LIST &A,int n)
{
	for(int i=1; i<= n-1; i++)
	{
		int sp=0;
		for(int j=n;j>=i+1;j--)
		{
			if(A[j].key<A[j-1].key)
			{
				swap(A[j].key,A[j-1].key);
				sp=1;
			}
		}
		if(sp==0)
			return;
	}
}

int FindPivot(int i,int j,LIST A)
{
	int firstkey=A[i].key;
	int k;
	for(k=i+1;k<=j;k++)
		if(A[k].key>firstkey)
			return k;
		else if(A[k].key<firstkey)
			return i;
	return 0;
}

int Partition(int i,int j,int pivot,LIST &A)
{
	int l=i,r=j;
	do{
		while(A[r].key>=pivot)
			r--;
		while(A[l].key<pivot)
			l++;
		if(l<r)
			swap(A[l].key,A[r].key);
	}while(l<=r);
	return l;
}

void QuickSort(int i,int j,LIST &A)
{
	int pivot;
	int k;
	int pivotindex;
	pivotindex=FindPivot(i,j,A);
	if(pivotindex!=0)
	{
		pivot=A[pivotindex].key;
		k=Partition(i,j,pivot,A);
		QuickSort(i,k-1,A);
		QuickSort(k,j,A);
	}
}


int BinSearch1(int k,LIST F,int n)
{
	int low,up,mid;
	low=1;
	up=n;
	while(low<=up)
	{
		mid=(low+up)/2;
		if(F[mid].key==k)
			return mid;
		else if(F[mid].key>k)
			up=mid-1;
		else
			low=mid+1;
	}
	return 0;
}


int BinSearch2(LIST F,int low,int up,int k)
{
	if(low>up)
		return 0;
	else
	{
		int mid=(low+up)/2;
		if(k<F[mid].key)
			return BinSearch2(F,low,mid-1,k);
		else if(k>F[mid].key)
			return BinSearch2(F,mid+1,up,k);
		else return mid;
	}
}

int main()
{
	LIST A,B,C;
	long start,finish;
	double timeA[3][3],timeB[3][3];
	double timeC[3][2];
	int k; 
	
	CreateList(A,N1); 		
	/*ð����������10000��*/
	start=clock();
	BubbleSort(A,N1); 
	finish=clock();
	timeA[0][0]=(double)(finish-start)/CLK_TCK;	
	/*ð����������10000��*/
	start=clock();
	BubbleSort(A,N1); 
	finish=clock();
	timeA[0][1]=(double)(finish-start)/CLK_TCK;		
	/*ð�ݷ�������10000��*/
	Rorder(A,C,N1);
	start=clock();
	BubbleSort(C,N1); 
	finish=clock();
	timeA[0][2]=(double)(finish-start)/CLK_TCK;
	
	CreateList(A,N2);
	/*ð����������30000��*/
	start=clock();
	BubbleSort(A,N2); 
	finish=clock();
	timeA[1][0]=(double)(finish-start)/CLK_TCK;		
	/*ð����������30000��*/
	start=clock();
	BubbleSort(A,N2); 
	finish=clock();
	timeA[1][1]=(double)(finish-start)/CLK_TCK;		
	/*ð�ݷ�������30000��*/
	Rorder(A,C,N2);
	start=clock();
	BubbleSort(C,N2); 
	finish=clock();
	timeA[1][2]=(double)(finish-start)/CLK_TCK;

	CreateList(A,N3);
	/*ð����������50000��*/
	start=clock();
	BubbleSort(A,N3); 
	finish=clock();
	timeA[2][0]=(double)(finish-start)/CLK_TCK;		
	/*ð����������50000��*/
	start=clock();
	BubbleSort(A,N3); 
	finish=clock();
	timeA[2][1]=(double)(finish-start)/CLK_TCK;		
	/*ð�ݷ�������50000��*/
	Rorder(A,C,N3);
	start=clock();
	BubbleSort(C,N3); 
	finish=clock();
	timeA[2][2]=(double)(finish-start)/CLK_TCK;
	
	CreateList(A,N1);	
	/*������������10000��*/
	start=clock();
	QuickSort(1,N1,A); 
	finish=clock();
	timeB[0][0]=(double)(finish-start)/CLK_TCK;	
	/*������������10000��*/
	start=clock();
	QuickSort(1,N1,A); 
	finish=clock();
	timeB[0][1]=(double)(finish-start)/CLK_TCK;		
	/*���ٷ�������10000��*/
	Rorder(A,C,N1);
	start=clock();
	QuickSort(1,N1,C);
	finish=clock();
	timeB[0][2]=(double)(finish-start)/CLK_TCK;

	CreateList(A,N2);
	/*������������30000��*/
	start=clock();
	QuickSort(1,N2,A);
	finish=clock();
	timeB[1][0]=(double)(finish-start)/CLK_TCK;
	
	/*������������30000��*/
	start=clock();
	QuickSort(1,N2,A);
	finish=clock();
	timeB[1][1]=(double)(finish-start)/CLK_TCK;	
	
	/*���ٷ�������30000��*/
	Rorder(A,C,N2);
	start=clock();
	QuickSort(1,N2,C);
	finish=clock();
	timeB[1][2]=(double)(finish-start)/CLK_TCK;

	CreateList(A,N3);
	/*������������50000��*/
	start=clock();
	QuickSort(1,N3,A); 
	finish=clock();
	timeB[2][0]=(double)(finish-start)/CLK_TCK;
	
	/*������������50000��*/
	start=clock();
	QuickSort(1,N3,A); 
	finish=clock();
	timeB[2][1]=(double)(finish-start)/CLK_TCK;	
	
	/*���ٷ�������50000��*/
	Rorder(A,C,N3);
	start=clock();
	QuickSort(1,N3,C); 
	finish=clock();
	timeB[2][2]=(double)(finish-start)/CLK_TCK;



	/*���ֲ���*/
	CreateList(A,N4);
	QuickSort(1,N4,A);
	start=clock();
	k=rand()%1000;
	BinSearch1(k,A,N4);//�ǵݹ� 
	finish=clock();
	timeC[0][0]=(double)(finish-start)/CLK_TCK;	
	
	start=clock();
	BinSearch2(A,1,N4,k);//�ݹ� 
	finish=clock();
	timeC[0][1]=(double)(finish-start)/CLK_TCK;	
	
	CreateList(A,N5);
	QuickSort(1,N5,A);
	start=clock();
	k=rand()%1000;
	BinSearch1(k,A,N5);//�ǵݹ� 
	finish=clock();
	timeC[1][0]=(double)(finish-start)/CLK_TCK;	
	
	start=clock();
	BinSearch2(A,1,N5,k);//�ݹ� 
	finish=clock();
	timeC[1][1]=(double)(finish-start)/CLK_TCK;	
	
	CreateList(A,N6);
	QuickSort(1,N6,A);
	start=clock();
	k=rand()%1000;
	BinSearch1(k,A,N6);//�ǵݹ� 
	finish=clock();
	timeC[2][0]=(double)(finish-start)/CLK_TCK;	
	
	start=clock();
	BinSearch2(A,1,N6,k);//�ݹ� 
	finish=clock();
	timeC[2][1]=(double)(finish-start)/CLK_TCK;	
	
	cout<<"ð������"<<endl; 
	Excle1(timeA);
	cout<<"��������"<<endl;
	Excle1(timeB);
	cout<<"�۰���ң�"<<endl;
	Excle2(timeC);
/*	BubbleSort(A1);//���� 
	showList(A1);
	finish=clock();
	time[0][0]=(double)(finish-start)/CLK_TCK;
	cout<<time[0][0];
*/	
	
/*	QuickSort(1,B.num,B);//����
	ShowList(B);
	QuickSort(1,B.num,B);//���� 
*/	
	return 0;
}
