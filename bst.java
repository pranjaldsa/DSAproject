package Assignment_7;


import java.util.*;
class node
{
node left ,right,root;
    String word,meaning;


node(String word,String meaning){
left =right=null;
root=null;
    this.word=word;
    this.meaning=meaning;
    }
}
class BinarySearchTree{
Scanner sc=new Scanner(System.in);
node root;
BinarySearchTree(){
root=null;
}
void create() {
String word,meaning;
int op;
do {
System.out.println("Enter the word:");
word=sc.next();
System.out.println("Enter the meaning:");
meaning=sc.next();
node temp_node=new node(word,meaning);
if(root==null) {
root=temp_node;
}else {
node ptr=root;
while(ptr!=null) {
if(temp_node.word.compareTo(ptr.word)<0) {
if(ptr.left==null) {
ptr.left=temp_node;
break;
}
else {
ptr=ptr.left;
}}
if(temp_node.word.compareTo(ptr.word)>0) {
if(ptr.right==null) {
ptr.right=temp_node;
break;
}else {
ptr=ptr.right;
}
}

}
}System.out.println("\nDo you want to continue?Enter 1 for Yess and 0 for Noo!!");
op=sc.nextInt();
}while(op!=0);

}
 void display(node LocalRoot) {
 
 if(LocalRoot!=null) {
 display(LocalRoot.left);
 System.out.println("Word="+LocalRoot.word+" Meaning="+LocalRoot.meaning);
 display(LocalRoot.right);

 }
 }
 void search() {
 System.out.println("Enter the word you want to search:");
 String word1=sc.next();
 node ptr=root;

 while(ptr!=null) {
 if(word1.equalsIgnoreCase(ptr.word)) {
 System.out.println("Word:"+ptr.word+ "  Meaning:"+ptr.meaning);
 return;
 }
 else if(word1.compareTo(ptr.word)<0) {
 ptr=ptr.left;
 }
 else {
 ptr=ptr.right;
 }
 }
 System.out.println("Word not found");
 }
 void update() {
 System.out.println("Enter the word you want to update:");
 String word1=sc.next();
 node ptr=root;

 while(ptr!=null) {
 if(word1.equals(ptr.word)) {
 System.out.println("Enter Meaning:");
 String Meaning=sc.next();
 ptr.meaning=Meaning;
 System.out.println("\nUpdated word and Meaning");
 System.out.println("Word="+ptr.word+"Meaning="+ptr.meaning);

 return;
 }
 else if(word1.compareTo(ptr.word)<0) {
 ptr=ptr.left;
 }
 else {
 ptr=ptr.right;
 }
 }
 System.out.println("Word not found");
 }
 
 void delete() {         //delete
int flag=0;
node parent=root;
System.out.println("\n\tEnter word to be update:");
String Word_Delete=sc.next();
 node ptr=root;
while(ptr!=null) {

if(Word_Delete.equalsIgnoreCase(ptr.word)) {
flag=1;
break;
}
if(Word_Delete.compareToIgnoreCase(ptr.word)>0) {
parent=ptr;
ptr=ptr.right;
}
else {
parent=ptr;
ptr=ptr.left;
}
}

if(flag==1) {
while(ptr!=null) {
if(ptr.left==null && ptr.right==null) {
if(ptr==parent.left) {
parent.left=null;
break;
}
else {
parent.right=null;
break;
}
}
else if(ptr.left!=null && ptr.right==null) {

if(ptr==parent.left) {
parent.left=ptr.left;
break;
}
else {
parent.right=ptr.left;
break;
}
}

                else if(ptr.left==null && ptr.right!=null) {

if(ptr==parent.left) {
parent.left=ptr.right;
break;
}
else {
parent.right=ptr.right;
break;
}
}

else if(ptr.left!=null && ptr.right!=null) {
int flag1=0;
node p=ptr.left;
parent=ptr;
while(p.right!=null) {
flag1=1;
parent=p;
p=p.right;
}
ptr.word=p.word;
ptr.meaning=p.meaning;
if(flag1==1) {
parent.right=null;
break;
}
else {
ptr.left=null;
}
}
else {
                System.out.println("\n\tNot found");
                }
}
}



}
}

 


public class bst {

public static void main(String[] args) {
BinarySearchTree BST =new BinarySearchTree();
int op;
Scanner sc1=new Scanner(System.in);
do {
System.out.println("*******Menu*******");
System.out.println("1.Create");
System.out.println("2.Display");
System.out.println("3.Search");
System.out.println("4.Update");
System.out.println("5.Delete");
System.out.println("Enter your choice:");
int ch=sc1.nextInt();
switch(ch) {
case 1:
BST.create();
break;
case 2:
BST.display(BST.root);
break;
case 3:
BST.search();
break;
case 4:
BST.update();
BST.display(BST.root);
break;
case 5:
BST.delete();
BST.display(BST.root);
break;
}
System.out.println("Do you want to continue ? Enter 1 for yes and 0 for Noo!!");
op=sc1.nextInt();
}while(op!=0);
}

}
