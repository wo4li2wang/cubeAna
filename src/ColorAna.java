import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;

/**
 * ��ͼ����ɫ���з���
 * ������ȷ����ǰͼƬ����ɫ��Χ
 * ȷ��ͼƬ�е�һ��������ص�ͳ��ȣ���ʶ��ͼƬ��ÿһ���������ɫ����������
 * */
public class ColorAna extends Frame {
	private int width, height, tempx, tempy;// ͼƬ��С�Լ�һ������ĳ���;���ĸ���
	private ColorPoint cp[][];// ����
	private static ColorPoint red = new ColorPoint(255, 0, 0);
	private static ColorPoint green = new ColorPoint(0, 255, 0);
	private static ColorPoint blue = new ColorPoint(0, 0, 255);
	private static ColorPoint yellow = new ColorPoint(255, 255, 0);
	private static ColorPoint pink = new ColorPoint(255, 0, 255);
	private static ColorPoint indigo = new ColorPoint(0, 255, 255);
	private static ColorPoint white = new ColorPoint(255, 255, 255);
	private static ColorPoint black = new ColorPoint(0, 0, 0);
	private static ColorPoint bg = new ColorPoint(136, 136, 136);
	// Ĭ����ɫ
	private Pointer first, second, third, fourth;// ������λ��һ������λ��
	private String[][] ans;
	private int[] num;

	private int tx, ty, tx2, ty2;

	public void showWind() {
		setSize(width * 2, height * 2);
		setVisible(true);
		repaint();
	}

	public void paint(Graphics g) {

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				g.setColor(new Color(cp[i][j].r, cp[i][j].g, cp[i][j].b));
				g.fillRect(j + height / 2, i + width / 2, 1, 1);
			}
		}
		g.setColor(Color.black);
		// g.fillRect(ty+height/2,tx+width/2,1, 1);
		// g.fillRect(ty2+height/2,tx2+width/2,1, 1);
		// g.fillRect(Record.middle.y+height/2,Record.middle.x+width/2,1, 1);
		// ֤��3�㶼��׼ȷ�ģ�
		for (int i = 0; i < Record.number; i++) {
			for (int j = 0; j < Record.number; j++) {
				int x = (int) (Record.middle.x + (i * Record.cubeLength));
				int y = (int) (Record.middle.y + (j * Record.cubeLength));
				g.fillRect(y + height / 2, x + width / 2, 1, 1);
			}
		}
		g.setColor(Color.white);
		g.fillRect(first.y + height / 2, first.x + width / 2, 8, 8);
		g.fillRect(second.y + height / 2, second.x + width / 2, 8, 8);
		// g.setColor(Color.yellow);
		// g.fillRect(third.y+height/2,third.x+width/2,1, 1);
		// g.setColor(Color.blue);
		// g.fillRect(fourth.y+height/2,fourth.x+width/2,1, 1);

		// for(int i=0;i<Record.number;i++){
		// for(int j=0;j<Record.number;j++){
		// int x=Record.middle.x+i*Record.cubeLength;
		// int y=Record.middle.y+j*Record.cubeLength;
		// g.drawString("*", x+height/2, y+width/2);
		// }
		// }

	}

	public ColorAna(String filePath) {
		File file = new File(filePath);

		try {
			BufferedImage bufImg = ImageIO.read(file);
			width = bufImg.getHeight();
			height = bufImg.getWidth();
			cp = new ColorPoint[width][height];
			//������ɫ
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {// ���ͼ��
					Color c = new Color(bufImg.getRGB(j, i));
					cp[i][j] = new ColorPoint(c.getRed(), c.getGreen(),
							c.getBlue());
					if (ColorPoint.isSomeSame(cp[i][j], yellow)) {
						cp[i][j] = yellow;
					}
					else if (ColorPoint.isSomeSame(cp[i][j], red)) {
						cp[i][j] = red;
					}
					else if (ColorPoint.isSomeSame(cp[i][j], green)) {
						cp[i][j] = green;
					}
					else if (ColorPoint.isSomeSame(cp[i][j], blue)) {
						cp[i][j] = blue;
					}
					else if (ColorPoint.isSomeSame(cp[i][j], pink)) {
						cp[i][j] = pink;
					}
					else if (ColorPoint.isSomeSame(cp[i][j], indigo)) {
						cp[i][j] = indigo;//��ɫ
					}

					else if (ColorPoint.isSomeSame(cp[i][j], black)) {
						cp[i][j] = black;
					}
					else if (ColorPoint.isSomeSame(cp[i][j], white)) {
						cp[i][j] = white;
					}

				}
			}

		} catch (Exception e) {
		}
		autoDo();
	}
/**
 * ȷ����ɫ����Ҫ�������
 * */
	private String which(ColorPoint cp) {
		if (ColorPoint.isSame(cp, red))
			return "red";
		if (ColorPoint.isSame(cp, yellow))
			return "yellow";
		if (ColorPoint.isSame(cp, green))
			return "green";
		if (ColorPoint.isSame(cp, blue))
			return "blue";
		if (ColorPoint.isSame(cp, black))
			return "black";
		if (ColorPoint.isSame(cp, white))
			return "white";
		if (ColorPoint.isSame(cp, pink))
			return "pink";
		if (ColorPoint.isSame(cp, indigo))
			return "indigo";
		else
			return "gray";
	}
	/**
	 * ȷ����ɫ����Ҫ������int��¼��������
	 * */
	private int which2(ColorPoint cp) {
		if (ColorPoint.isSame(cp, red))
			return 0;
		if (ColorPoint.isSame(cp, yellow))
			return 3;
		if (ColorPoint.isSame(cp, green))
			return 1;
		if (ColorPoint.isSame(cp, blue))
			return 2;
		if (ColorPoint.isSame(cp, black))
			return 4;
		if (ColorPoint.isSame(cp, white))
			return 5;
		if (ColorPoint.isSame(cp, pink))
			return 6;
		if (ColorPoint.isSame(cp, indigo))
			return 7;
		else
			return -1;
	}

	/**
	 * ����������
	 * */
	public void print() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++)
				System.out.print(which(cp[i][j]) + "\t");
			System.out.print("\n");
		}
	}

	/**
	 * ����������(��������)
	 * */
	public void print2() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++)
				System.out.print(which2(cp[i][j]) + "\t");
			System.out.print("\n");
		}
	}

	/**
	 * ����������
	 * */
	public void printAns() {
		for (int i = 0; i < Record.number; i++) {
			for (int j = 0; j < Record.number; j++)
				System.out.print(ans[i][j] + "\t");
			System.out.print("\n");
		}
	}

	/**
	 * �ҵ�����ĵ�һ���㣬�����Ǵ����Ͻ������·����ƶ�ʶ��������һ����ʶ�𾧸�ͷֱ����������ƶ�
	 * �ҵ���������Ͻ�
	 * */
	private void getFirstPoint() {

		ColorPoint temp = null;
		int _x = 0, _y = 0;
		int shorter = width > height ? height : width;
		// System.err.println(shorter);
		for (int b = 0; b < shorter; b++) {

			if (ColorPoint.isSame(cp[b][b], red)
					|| ColorPoint.isSame(cp[b][b], green)
					|| ColorPoint.isSame(cp[b][b], blue)
					|| ColorPoint.isSame(cp[b][b], pink)
					|| ColorPoint.isSame(cp[b][b], indigo)
					|| ColorPoint.isSame(cp[b][b], yellow)) {
				// ֻҪ�����κο�ʶ����ɫ����һֱ����
				temp = cp[b][b];
				_x = b;
				_y = b;
				System.out.println("first:" + b);
				break;
			}

		}// �ҵ����·�Χ
			// System.out.println("--------------------");
		// System.out.println(_x);
		if (!ColorPoint.isSame(temp, cp[_x - 1][_y])
				&& !ColorPoint.isSame(temp, cp[_x][_y - 1]))
			first = temp.creatPointer(_x, _y);
		else {
			try {
				if (ColorPoint.isSame(temp, cp[_x - 1][_y]))// �����
				{
					if (!ColorPoint.isSame(temp, cp[_x][_y - 1]))// �����
						do {
							_x -= 1;
							temp = cp[_x][_y];
						} while (ColorPoint.isSame(temp, cp[_x - 1][_y]));
				} else {
					do {
						// System.err.println(ColorPoint.Same(temp,
						// cp[_x][_y-1]));
						_y -= 1;
						temp = cp[_x][_y];
					} while (ColorPoint.isSame(temp, cp[_x][_y - 1]));

				}
			} catch (Exception e) {
			}
			first = temp.creatPointer(_x, _y);
			tx = _x;
			ty = _y;
			// System.err.println(_x);
			// System.err.println(_y);
		}

	}

	/**
	 * �ҵ��ڶ�����
	 * �ڵ�һ������Ļ��������²��ң���������Ƭ������б�����ҵ���
	 * */
	private void getSecondPoint() {

		ColorPoint temp = null;
		int _x = first.x, _y = first.y;
		int shorter = width > height ? height : width;
		for (int b = 0; b < shorter; b++) {
			if (!ColorPoint.isSame(cp[_x + b][_y + b], (ColorPoint) first)) {
				temp = cp[_x + b - 2][_y + b - 2];
				// System.err.println(which(cp[_x+b-2][_y+b-2]));
				// System.err.println(which(temp));
				// System.err.println("------");
				_x = _x + b - 2;
				_y = _y + b - 2;
				break;
			}
			// System.out.println(ColorPoint.Same(cp[_x+b][_y+b],(ColorPoint)first));

		}// �ҵ����·�Χ

		if (!ColorPoint.isSame(temp, cp[_x + 1][_y])
				&& !ColorPoint.isSame(temp, cp[_x][_y + 1])) {
			second = temp.creatPointer(_x, _y);
			// System.err.println("hey2");
		} else {
			try {
				if (ColorPoint.isSame(temp, cp[_x + 1][_y]))// �ұ���
				{
					if (!ColorPoint.isSame(temp, cp[_x][_y + 1]))// �ұ���
						do {
							_x += 1;
							temp = cp[_x][_y];
							// System.out.println(which(cp[_x][_y])+":1");
						} while (ColorPoint.isSame(temp, cp[_x + 1][_y]));

				} else {
					do {
						_y += 1;
						temp = cp[_x][_y];
						// System.out.println(which(cp[_x][_y])+":2");
					} while (ColorPoint.isSame(temp, cp[_x][_y + 1]));

				}
			} catch (Exception e) {
			}
			_x++;
			_y++;
			second = temp.creatPointer(_x, _y);
			System.err.println("second:" + _x);
			tx2 = _x;
			ty2 = _y;
		}
		// third=cp[_x][first.y].creatPointer(_x, first.y);
		tempx = _x;
		tempy = first.y;
		// System.err.println(which((ColorPoint)second));
	}

	/**
	 * �ҵ���������
	 * ԭ����ͬ
	 * */
	private void getThirdPoint() {
		ColorPoint temp = cp[tempx][tempy];
		do {
			tempx++;
		} while (!(ColorPoint.isSame(temp, red)
				|| ColorPoint.isSame(temp, green)
				|| ColorPoint.isSame(temp, blue)
				|| ColorPoint.isSame(temp, pink)
				|| ColorPoint.isSame(temp, indigo) || ColorPoint.isSame(temp,
				yellow)));

		while (ColorPoint.isSame(cp[tempx - 1][tempy], cp[tempx][tempy])) {
			tempx--;
		}
		while (ColorPoint.isSame(cp[tempx][tempy - 1], cp[tempx][tempy])) {
			tempy--;
		}
		third = cp[tempx][tempy].creatPointer(tempx, tempy);

		System.err.println("third:" + tempx);
	}

	/**
	 * �ҵ����ĸ���
	 * ԭ����ͬ
	 * */
	private void getFourhPoint() {

		ColorPoint temp = null;
		int _x = third.x, _y = third.y;
		int shorter = width > height ? height : width;
		for (int b = 0; b < shorter; b++) {
			if (!ColorPoint.isSame(cp[_x + b][_y + b], (ColorPoint) third)) {
				temp = cp[_x + b - 2][_y + b - 2];
				// System.err.println(which(cp[_x+b-2][_y+b-2]));
				// System.err.println(which(temp));
				// System.err.println("------");
				_x = _x + b - 2;
				_y = _y + b - 2;
				break;
			}
			// System.out.println(ColorPoint.Same(cp[_x+b][_y+b],(ColorPoint)first));

		}// �ҵ����·�Χ
		while (ColorPoint.isSame(cp[_x][_y + 1], cp[_x][_y])) {
			_y++;
		}
		while (ColorPoint.isSame(cp[_x + 1][_y], cp[_x][_y])) {
			_x++;
		}

		if (!ColorPoint.isSame(temp, cp[_x + 1][_y])
				&& !ColorPoint.isSame(temp, cp[_x][_y + 1])) {
			fourth = temp.creatPointer(_x, _y);
			// System.err.println("_____________");
			// System.err.println("hey2");
		} else {
			try {
				if (ColorPoint.isSame(temp, cp[_x + 1][_y]))// �ұ���
				{
					if (!ColorPoint.isSame(temp, cp[_x][_y + 1]))// �ұ���
						do {
							_x += 1;
							temp = cp[_x][_y];
							// System.out.println(which(cp[_x][_y])+":1");
						} while (ColorPoint.isSame(temp, cp[_x + 1][_y]));

				} else {
					do {
						_y += 1;
						temp = cp[_x][_y];
						// System.out.println(which(cp[_x][_y])+":2");
					} while (ColorPoint.isSame(temp, cp[_x][_y + 1]));

				}
			} catch (Exception e) {

			}
			_x++;
			_y++;
			fourth = temp.creatPointer(_x, _y);
			System.err.println("fourth:" + _x);
		}
		// third=cp[_x][first.y].creatPointer(_x, first.y);
		tempx = _x;
		tempy = first.y;
		// System.err.println(which((ColorPoint)second));

	}

	/**
	 * �Զ���õ����
	 * */
	private void autoDo() {
		if (Record.middle == null) {
			//��ʱΪ���޸ķ��㣬���õ��⼸���ļ�����ɫ�ֱ�ŵ���ͬ���ļ���
			//��Ϊ��������ͼ����ģ����Բ�ͬ������û����ɫ�ķ�Χ������������ǿ�ƶ�����ɫĳ�������µ���ɫ����
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						"D:\\src\\color\\red.txt"));
				red = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
				br = new BufferedReader(new FileReader(
						"D:\\src\\color\\green.txt"));
				green = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
				br = new BufferedReader(new FileReader(
						"D:\\src\\color\\blue.txt"));
				blue = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
				br = new BufferedReader(new FileReader(
						"D:\\src\\color\\yellow.txt"));
				yellow = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
				br = new BufferedReader(new FileReader(
						"D:\\src\\color\\white.txt"));
				white = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
				br = new BufferedReader(new FileReader(
						"D:\\src\\color\\black.txt"));
				black = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
				br = new BufferedReader(new FileReader(
						"D:\\src\\color\\bg.txt"));
				bg = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						"D:\\src\\color\\pink.txt"));
				pink = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
			} catch (Exception e) {
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						"D:\\src\\color\\indigo.txt"));
				indigo = new ColorPoint(Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()), Integer.parseInt(br
								.readLine()));
				br.close();
			} catch (Exception e) {
			}

			getFirstPoint();// ��õ�һ������� ��һ����(����)
			getSecondPoint();// ��õ�һ������� �ڶ�����(����)
			// getThirdPoint();
			// getFourhPoint();

			// double x=((double)first.x+second.x)/2;
			//
			// double y=((double)first.y+second.y)/2;
			//
			// Record.middle=cp[(int)x][(int)y].creatDPointer(x, y);
			//
			// x=((double)third.x+fourth.x)/2;
			//
			// y=((double)third.y+fourth.y)/2;
			//
			//
			//
			// Record.middle2=cp[(int)x][(int)y].creatDPointer(x, y);
			//
			// Record.cubeLength=(double)(third.x+fourth.x-first.x-second.x)/2;

		}
		// ans=new String[Record.number][Record.number];

		// BianLi();
	}

	/**
	 * ȷ���м������񹹳�
	 * */
	private void CubeNum() {

		for (int i = (int) Record.middle.x; i < width; i += Record.cubeLength) {

			if (ColorPoint.isSame(cp[i][(int) Record.middle.y], bg)) {
				break;
			}
			Record.number++;
		}
		for (int i = (int) Record.middle.y; i < height; i += Record.cubeLength) {

			if (ColorPoint.isSame(cp[(int) Record.middle.x][i], bg)) {
				break;
			}
			Record.number++;
		}
		ans = new String[Record.number][Record.number];
	}

	/**
	 * �������о�������ɫ
	 * ǰ����֤�õ�
	 * */
	private void Traversal() {
		num = new int[Record.number * Record.number];
		int temps = 0;
		for (int i = 0; i < Record.number; i++) {
			for (int j = 0; j < Record.number; j++) {
				int x = (int) (Record.middle.x + i * Record.cubeLength);
				int y = (int) (Record.middle.y + j * Record.cubeLength);
				ColorPoint temp = cp[x][y];
				// System.err.print(which(temp)+'\t');
				if (ColorPoint.isSame(temp, red)) {
					ans[i][j] = "red";
					num[temps++] = 0;
				} else if (ColorPoint.isSame(temp, green)) {
					ans[i][j] = "green";
					num[temps++] = 1;
				} else if (ColorPoint.isSame(temp, blue)) {
					ans[i][j] = "blue";
					num[temps++] = 2;
				} else if (ColorPoint.isSame(temp, yellow)) {
					ans[i][j] = "yellow";
					num[temps++] = 3;
				} else if (ColorPoint.isSame(temp, black)) {
					ans[i][j] = "black";
					num[temps++] = 4;
				} else if (ColorPoint.isSame(temp, white)) {
					ans[i][j] = "white";
					num[temps++] = 5;
				} else if (ColorPoint.isSame(temp, pink)) {
					ans[i][j] = "pink";
					num[temps++] = 6;
				} else if (ColorPoint.isSame(temp, indigo)) {
					ans[i][j] = "indigo";
					num[temps++] = 7;
				}
			}
			// System.err.println();
		}
	}

	/**
	 * һ�м���
	 * */
	public int getXNum() {
		return Record.number;
	}

	/**
	 * ����
	 * */
	public int getYNum() {
		return Record.number;
	}

	/**
	 * ��ʾ����
	 * */
	public String[][] answer() {
		return ans;
	}

	/**
	 * ���������ֵ����
	 * */
	public int[] getSequence() {
		return num;
	}

	/**
	 * ���������ֵ����
	 * */
	public String getStrig() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++)
			sb.append(num[i]);
		return sb.toString();
	}
}
