import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.math.BigInteger;


public class Framer {
	/**
	 * ������Ϊ�������⣬��������ɫ���ѷ��壬���ò�����������ɫ���з���
	 * ��ʶ�����ɫ���浽read.txt Ϊ0-3������
	 * */
public static void main(String[] args) {
	try{
		FileWriter fw=new FileWriter(GlobalVariable.path+"read.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		File f=new File(GlobalVariable.path+"read.txt");
		if(!f.exists())f.createNewFile();
		FileInputStream fis=new FileInputStream(GlobalVariable.pic);//���Ե�ͼƬ
		byte b[]=new byte[128];
		int bs;
		while(true){
		if(fis.available()<128){
			b=new byte[fis.available()];
			for(int i=0;i<b.length;i++) {
				 bs= b[i]&0xff;
				BigInteger bi=new BigInteger(bs+"");
				bw.write(addZero(bi.toString(4)));
			}   
			break;
		}else{
			fis.read(b);	
			for(int i=0;i<128;i++) {
				bs= b[i]&0xff;
				BigInteger bi=new BigInteger(bs+"");
				bw.write(addZero(bi.toString(4)));
				
			}   
			
		}
		}
		
bw.close();
fw.close();
fis.close();
//�ⲽ֮ǰ�Ѿ�ʵ��ת��Ϊ4�������У���������ñ������ʵ��תΪbinary file��
Runtime.getRuntime().exec(GlobalVariable.path+"����ת��.exe");
		
//		}
		
	}catch(Exception e){
	}
	
}
private static String addZero(String string) {
	
	  java.text.DecimalFormat df = new java.text.DecimalFormat("0000");
	  return df.format(string); 
}
}
