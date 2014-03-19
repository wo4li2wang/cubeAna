/**
 * 用来记录识别出的晶格的属性
 * 这里是默认值，在运行程序识别时会重新分析
 * */
public class Record {
public static double cubeLength=0;//晶格长度
public static int number=12;//一行晶格个数，这里用的是N×N的格式
public static DPointer middle=null;//晶格的中间点
public static DPointer middle2=null;//备份的中间点，因为可能会对中心位置有一定修正
public static double compArr[]={0.01,0.1,0.2,0.4};//比较矩阵，用来比较两个晶格的相似程度有多大 如：极相似、有些相似等  

}
