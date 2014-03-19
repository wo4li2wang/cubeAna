import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.math.BigInteger;


public class Framer {
	/**
	 * 后来因为光线问题，有两种颜色很难分清，不得不改用四种颜色进行分析
	 * 将识别的颜色保存到read.txt 为0-3的序列
	 * */
public static void main(String[] args) {
	try{
		FileWriter fw=new FileWriter(GlobalVariable.path+"read.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		File f=new File(GlobalVariable.path+"read.txt");
		if(!f.exists())f.createNewFile();
		FileInputStream fis=new FileInputStream(GlobalVariable.pic);//测试的图片
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
//这步之前已经实现转化为4进制序列，后面的是用别的语言实现转为binary file的
Runtime.getRuntime().exec(GlobalVariable.path+"序列转化.exe");
		
//		}
		
	}catch(Exception e){
	}
	
}
private static String addZero(String string) {
	
	  java.text.DecimalFormat df = new java.text.DecimalFormat("0000");
	  return df.format(string); 
}
}
