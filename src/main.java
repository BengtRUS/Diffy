import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String [] args){
		//common data
		boolean b=false;
		long p=0, a=0, y1=0, y2=0;
		//users
		User user1 = new User() ,user2 = new User();
		long k1=0, k2=0, temp=1;
		try(FileWriter writer = new FileWriter("out.txt", false)){
			writer.write("");
			writer.append("***�������� �����-��������***\n");
			writer.append("������� ������� ����� ��� ������� P >>");
			System.out.println("������� ������� ����� ��� ������� P >>");
			Scanner in = new Scanner(System.in);
			while(!b) {
				if(in.hasNextInt()){
					p=in.nextInt();
					for(int i=2;i<p;i++) {
						if(p%i==0) {
							writer.append("������� ������� ����� ��� ������� P >>");
							b=false;
							break;
						}
						else b=true;
					}
				}
			}
			writer.append(p+"\n");
			writer.append("");
			writer.append("������� �, ����� ��� 1<A<"+(p-1)+" >>");
			System.out.println("������� �, ����� ��� 1<A<"+(p-1)+" >>");
			if(in.hasNextInt()){
				a=in.nextInt();
				while((int)(Math.pow(a, (p/2)-1)%p)==1) {
					writer.append("���������� ������ � >>");
					if(in.hasNextInt()){
						a=in.nextInt();
						if((a<1)||a>(p-1)){
							throw new IllegalArgumentException();
						}
					}
				}
			}
			writer.append(a+"\n");
			writer.append("������������ 1 ���������� ��������� ���� "+user1.generate(p)+"\n");
			y1=user1.count(p, a);
			writer.append("������������ 1 ��������� y1 "+y1+"\n");
			writer.append("������������ 2 ���������� ��������� ����� "+user2.generate(p)+"\n");
			y2=user2.count(p, a);
			writer.append("������������ 2 ��������� y2 "+y2+"\n");
			writer.append("������������ ������������ y..."+"\n");
			k1=user1.key(y2, p);
			k2=user2.key(y1, p);
			writer.append("������������ 1 ������� ���� "+k1+"\n");
			writer.append("������������ 2 ������� ���� "+k2+"\n");
			if(k1==k2) writer.append("����� �����");
			else writer.append("����� �� ����� =(");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
