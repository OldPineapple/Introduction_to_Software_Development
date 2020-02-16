//Name: Hanwen Wang     ID: 260778557
//
//  main.c
//  c
//
//  Created by Go through the tunnel on 2018/3/31.
//  Copyright © 2018年 Go through the tunnel. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//state two functions
void dec2base(int input,int base,char *str);
void revStr(char *str,int length);
int main(int argc, const char * argv[]) {
    int a,b;
    //a for number, b for base, if amout of number is not 2 or 3, exit. If number is 2, base is automatically turned into 2. If amount of number is 3,the second number is base.
    if(argc!=2&&argc!=3)
    {
        printf("Wrong number of arguments\n");
        return 0;
    }
    else if(argc==3)
    {
        sscanf(argv[1],"%d",&a);
        sscanf(argv[2],"%d",&b);
        if (b>36||b<2)
        {
            printf("Wrong boundary\n");
            return 0;
        }
    }
    else
    {
        sscanf(argv[1],"%d",&a);
        b=2;
    }
    //state a string that is used in two functions
    char str[256];
    int length;
    dec2base(a, b,str);
    //length is equal to length of string
    for(length=0;str[length]!='\0';++length);
    printf("The Base-%d form of %d is:",b,a);
    revStr(str, length);
    return 0;
}
void dec2base(int input,int base,char *str)
{
    int i = 0;
    char range [36]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int remainder;
    while(input>0)
    {
        remainder=input%base;
        input=input/base;
        *(str + i) = range[remainder];// range + remainder, the i-th digit is the remainder digit of string range
        i++;
    }
}
void revStr(char *str,int length)
{
    for(length=length-1;length>=0;length--)
    {
           printf("%c",*(str + length));//print length-th digit of string str
    }
    printf("\n");
}
