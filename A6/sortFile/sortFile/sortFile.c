//Name: Hanwen Wang   ID:260778557
//
//  main.c
//  sortFile
//
//  Created by Go through the tunnel on 2018/4/6.
//  Copyright © 2018年 Go through the tunnel. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXBUF 100
//struct a Binarytree that has three things: root value, left tree and right tree
struct BinaryTree
{
    char name[50];
    struct BinaryTree* left;
    struct BinaryTree* right;
};
//This is the function of creating a new Binarytree.Copy stu_name into tree's root value, and set left tree and right tree to null.
struct BinaryTree* create_new_BinaryTree(char* stu_name)
{
    struct BinaryTree* add=(struct BinaryTree*)malloc(sizeof(struct BinaryTree));
    strncpy(add->name, stu_name, sizeof(add->name));
    add->left= NULL;
    add->right= NULL;
    return add;
}
//Function of adding a new node. First compare two strings. If the name that is to be add is smaller than the root value, add it to its left. Else, add it to its right. And always check whether left of right node is empty or not. If not, recall the fuction on that node.
void addNode(char* stu_name,struct BinaryTree* bt)
{
    if(strcmp(stu_name, bt->name)<0)
    {
        if(bt->left!=NULL)
        {
            addNode(stu_name, bt->left);
        }
        else
        {
            bt->left=create_new_BinaryTree(stu_name);
        }
    }
    else
    {
        if(bt->right!=NULL)
        {
            addNode(stu_name, bt->right);
        }
        else
        {
            bt->right=create_new_BinaryTree(stu_name);
        }
    }
}
//Function used to print the nodes in order(left root right)
void traverse_BinaryTree(struct BinaryTree* bt)
{
    if(bt->left!=NULL)
    {
        traverse_BinaryTree(bt->left);
    }
    printf("%s",bt->name);
    if(bt->right!=NULL)
    {
        traverse_BinaryTree(bt->right);
    }
}
int main(int argc, const char * argv[])
{
    FILE* Names;
    char* line;
    int bufsize=MAXBUF;
    long linelen;
    //the codition of only has 1 program name and a file name should be the only way to be executed
    if(argc!=2)
    {
        printf("Usage: fileReader [text file name]\n");
        return -1;
    }
    //If can't read from file, EXIT-FAIL
    if ((Names=fopen(argv[1],"r"))==NULL) {
        printf("Can't read from file %s\n",argv[1]);
        return -2;
    }
    line=(char *)malloc(bufsize+1);
    //If the file has nothing, EXIT-FAIL
    if (line==NULL) {
        printf("Unable to allocate a buffer for reading.\n");
        return -3;
    }
    else
    {
        printf("File in sort order:\n");
        //create a new tree using the first line and then add the remaing names to the tree. Finally, traverse the tree
        struct BinaryTree* bt=create_new_BinaryTree(line);
        while ((linelen=getline(&line,(size_t *)&bufsize,Names))>0)
        {
            addNode(line, bt);
        }
        traverse_BinaryTree(bt);
        }
    return 0;
}
