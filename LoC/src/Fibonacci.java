import java.util.Scanner;
public class Fibonacci{
public static int fibonacci(int n){
if(n==0|n==1)return 1;
return fibonacci(n-1)+fibonacci(n-2);}

public static void main(String args[]){
int start=new Scanner(System.in).nextInt(),end=new Scanner(System.in).nextInt();
for(int i=start;i<=end;i++)
System.out.println(fibonacci(i));}}
