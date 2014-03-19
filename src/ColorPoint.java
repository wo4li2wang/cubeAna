/**
 * 晶格对象，
 * 记录晶格的属性
 * 实现晶格的比较，确定两个晶格的相似程度
 * 或输出晶格
 * */
class ColorPoint {
	int r,g,b;
	ColorPoint(int r,int g,int b) {
		this.r=r;
		this.g=g;
		this.b=b;
}
	/**
	 * 两点颜色的欧氏距离，判断是否接近
	 * */
	 static boolean isSame(ColorPoint cp1,ColorPoint cp2){
		 double r1=(double)cp1.r;
		 double g1=(double)cp1.g;
		 double b1=(double)cp1.b;
		 double dr=r1-(double)cp2.r;
		 double dg=g1-(double)cp2.g;
		 double db=b1-(double)cp2.b;
		 double fenmu=Math.sqrt(3)*255;
		 double fenzi=Math.sqrt(dr*dr+dg*dg+db*db);
		 double jl=Record.compArr[1];//0.1代表就是
		 if(fenzi==0)//一模一样
			 jl=Record.compArr[0];
		 else{ 
		 jl=Math.abs(fenzi/fenmu);
		 }
//		 System.err.println(jl);
		 if(jl<Record.compArr[2]&&jl>0)
			 return true;
		 else
			 return false;
	}
	 /**
	  * 判断是否为相似的晶格
	  * */
	 static boolean isSomeSame(ColorPoint cp1,ColorPoint cp2){
		 double r1=(double)cp1.r;
		 double g1=(double)cp1.g;
		 double b1=(double)cp1.b;
		 double dr=r1-(double)cp2.r;
		 double dg=g1-(double)cp2.g;
		 double db=b1-(double)cp2.b;
		 double fenmu=Math.sqrt(3)*255;
		 double fenzi=Math.sqrt(dr*dr+dg*dg+db*db);
		 double jl=Record.compArr[1];//
		 if(fenzi==0)//一模一样
			 jl=Record.compArr[0];
		 else{ 
		 jl=Math.abs(fenzi/fenmu);
		 }
//		 System.err.println(jl);
		 if(jl<Record.compArr[3]&&jl>0)
			 return true;
		 else
			 return false;
	}
	 static double Same(ColorPoint cp1,ColorPoint cp2){
		 double r1=(double)cp1.r;
		 double g1=(double)cp1.g;
		 double b1=(double)cp1.b;
		 double dr=r1-(double)cp2.r;
		 double dg=g1-(double)cp2.g;
		 double db=b1-(double)cp2.b;
		return Math.sqrt(dr*dr+dg*dg+db*db)/Math.sqrt(r1*r1+g1*g1+b1*b1);
	}
	Pointer creatPointer(int x,int y){
		return new Pointer(r, g, b, x, y);
	}
	DPointer creatDPointer(double x,double y){
		return new DPointer(r, g, b, x, y);
	}
}
class Pointer extends ColorPoint{
	int x,y;
	Pointer(int r,int g,int b,int x,int y) {
		super(r, g, b);
		this.x=x;
		this.y=y;
	}
	
	
}
class DPointer extends ColorPoint{
	double x,y;
	DPointer(int r,int g,int b,double x,double y) {
		super(r, g, b);
		this.x=x;
		this.y=y;
	}
	
	
}
