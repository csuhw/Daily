import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String[] str1=str.split(",");
		int[] arr=new int[str1.length];
		for(int i=0;i<str1.length;i++){
			arr[i]=Integer.parseInt(str1[i]);
		}
		int rs=doub(arr);
	//	int rs1=single(arr,arr.length-1);
		System.out.println(rs);
	//	System.out.println(rs1);
	}
	//当前最大值
		//1. 最大-最小  2.当前值i-最小j 2~i-1 +j-1-0~j-2  与 上一个位置的最大值比较
		//1 2 求最大
		//i>=3
	public static int single(int[] arr,int end)
	{
		int min=arr[0];
		
		int cha=0;
		for(int i=1;i<=end;i++){
			if(arr[i]<min)
				min=arr[i];
			if(arr[i]-min>cha)
				cha=arr[i]-min;
			
		}
		return cha;
	}
	public static int doub(int[] arr){
		int maxP=3;
		int minP=2;
		int max=arr[maxP];	
		int min=arr[minP];
		int cha=0;
		for(int i=3;i<arr.length;i++){
			// max=arr[i]>max?arr[i]:max;
			 if(arr[i]>max){
				 maxP=i;
				 max=arr[maxP];
			 }
		
			 
			for(int j=i-1;j>1;j--){
				 if(arr[j]<min&&j<maxP){
					 minP=j;
					 min=arr[minP];
				 }
				
				int first=single(arr,minP-1);
				cha=Math.max((max-min+first)>first?(max-min+first):first,cha);
			}
		}
		return cha;
	}
	

}
