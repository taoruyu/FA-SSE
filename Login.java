import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;
import javax.swing.JTable;

//server端每次操作后都return；

public class Login extends JFrame {
	private JPanel contentPane;
	public static JTextField textField;
	public static JTable table;
	public static String id;
	public static JButton buttondic;
	public static JButton buttonset;
	public static JButton buttonup;
	public static JButton buttonre;
	public static JButton buttonfil;
	public static String path ="";
	public static String lines="";
	public static String padstr ="";
	private JScrollPane scrollPane;
	public static String str="";
	//public static DefaultTableModel model;
	public static Vector<String> names = new Vector<>();// 列名向量，使用它的add()方法添加列名
	public static Vector<Vector> rowdata = new Vector<>(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
	public String F= "";
	public String L= "";
	//public Vector data =new Vector();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
//				    buttonre.setEnabled(false);
//				    buttonfil.setEnabled(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws IOException
	 */
	public Login() throws IOException {
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((width/4), (height/4), width/2, height-100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		buttonset = new Button("建立LLset");
//		buttonset.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//String path ="";
//				JFileChooser fc = new JFileChooser();
//				fc.setDialogTitle("请选择要建立LLset的文件...");
//				fc.setApproveButtonText("确定");
//				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(contentPane)) {
//				    path=fc.getSelectedFile().getPath();
//				    if (path=="")
//				    {return;}
//			    F = BwtEncode.enCodeLineF(BwtEncode.StringFilter(BwtEncode.replaceBlank(lines.toLowerCase())));
//               // int []rank = BwtEncode.sortWithRank(F);
//		        try {
//					FileWriter fw4 = new FileWriter("E:/workspace/code/code/LLset/"+id+"LLset.txt",false);
//					int index =0;
//					for (int i = 0; i < F.length(); i++) {
//
//						if(i==0)
//						{
//							fw4.write(F.charAt(i)+"==>");
//							fw4.write(index+"");
//							index++;
//							continue;
//						}
//						if(F.charAt(i)==F.charAt(i-1))
//						{
//							fw4.write(index+"");
//							index++;
//							if(i!=F.length()-1 && F.charAt(i)==F.charAt(i+1))
//							{
//								fw4.write("==");
//							}
//						}else
//						{
//							fw4.write("\r\n"+F.charAt(i)+"==>");
//							fw4.write(index+"");
//							index++;
//							if(i!=F.length()-1 && F.charAt(i)==F.charAt(i+1))
//							{
//								fw4.write("==");
//							}
//						}
//
//
//					}		fw4.close();
//					System.out.println("LLset建立完毕");
//
////	for (int i = 0; i < F.length(); i++) {  //加密版
////
////						if(i==0)
////						{
////							String s = BwtEncode.twoStrXor(SHAR_1.bcSHA1(Character.toString(F.charAt(i)), 1),SHAR_1.bcSHA1(Character.toString(F.charAt(i)), 2));
////							fw4.write(s+"==>");
////
////							s = BwtEncode.twoStrXor(index+"",SHAR_1.bcSHA1(Character.toString(F.charAt(i)),2));
////
////							fw4.write(s);
////
////							index++;
////							continue;
////						}
////						if(F.charAt(i)==F.charAt(i-1))
////						{
////							String s = BwtEncode.twoStrXor(index+"",SHAR_1.bcSHA1(Character.toString(F.charAt(i)),2));
////							fw4.write(s);-+
////							index++;
////							if(i!=F.length()-1 && F.charAt(i)==F.charAt(i+1))
////							{
////								fw4.write("==");
////							}
////						}else
////						{
////							String s = BwtEncode.twoStrXor(SHAR_1.bcSHA1(Character.toString(F.charAt(i)), 1),SHAR_1.bcSHA1(Character.toString(F.charAt(i)), 2));
////							fw4.write("\r\n"+s+"==>");
////							s = BwtEncode.twoStrXor(index+"",SHAR_1.bcSHA1(Character.toString(F.charAt(i)),2));
////							fw4.write(s);
////							index++;
////							if(i!=F.length()-1 && F.charAt(i)==F.charAt(i+1))
////							{
////								fw4.write("==");
////							}
////						}
////
////
////					}		fw4.close();
//
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
////		        System.out.println(F.length());
////		        System.out.println(rank.length);
////				for (int i = 0; i < rank.length; i++) {
////					System.out.print(F.charAt(i)+""+rank[i]+"--");
////					//[1--[2--]1--]2--a1--a2--a3--a4--a5--a6--a7--a8--a9--a10--a11--a12--a13--a14--a15--a16--a17--a18--a19--a20--a21--a22--a23--a24--a25--a26--a27--a28--a29--a30--a31--a32--a33--a34--a35--a36--a37--a38--a39--a40--a41--a42--a43--a44--a45--a46--a47--a48--a49--a50--a51--a52--a53--a54--a55--a56--a57--a58--a59--a60--a61--a62--a63--a64--a65--a66--a67--a68--a69--a70--a71--a72--a73--a74--a75--a76--a77--a78--a79--a80--a81--a82--a83--a84--a85--a86--a87--a88--b1--b2--b3--b4--b5--b6--b7--b8--b9--b10--b11--b12--b13--b14--b15--b16--b17--b18--c1--c2--c3--c4--c5--c6--c7--c8--c9--c10--c11--c12--c13--c14--c15--c16--c17--c18--c19--c20--c21--c22--c23--c24--c25--c26--c27--c28--c29--c30--c31--c32--c33--c34--c35--c36--c37--c38--c39--c40--c41--c42--c43--c44--c45--c46--c47--c48--c49--c50--c51--c52--c53--c54--c55--c56--c57--c58--c59--c60--c61--c62--c63--c64--c65--c66--c67--c68--c69--c70--c71--c72--c73--c74--c75--c76--c77--c78--c79--d1--d2--d3--d4--d5--d6--d7--d8--d9--d10--d11--d12--d13--d14--d15--d16--d17--d18--d19--d20--d21--d22--d23--d24--d25--d26--d27--d28--d29--d30--d31--d32--d33--d34--d35--d36--d37--d38--d39--d40--d41--d42--d43--d44--d45--d46--d47--d48--d49--d50--d51--d52--d53--d54--d55--e1--e2--e3--e4--e5--e6--e7--e8--e9--e10--e11--e12--e13--e14--e15--e16--e17--e18--e19--e20--e21--e22--e23--e24--e25--e26--e27--e28--e29--e30--e31--e32--e33--e34--e35--e36--e37--e38--e39--e40--e41--e42--e43--e44--e45--e46--e47--e48--e49--e50--e51--e52--e53--e54--e55--e56--e57--e58--e59--e60--e61--e62--e63--e64--e65--e66--e67--e68--e69--e70--e71--e72--e73--e74--e75--e76--e77--e78--e79--e80--e81--e82--e83--e84--e85--e86--e87--e88--e89--e90--e91--e92--e93--e94--e95--e96--e97--e98--e99--e100--e101--e102--e103--e104--e105--e106--e107--e108--e109--e110--e111--e112--e113--e114--e115--e116--e117--e118--e119--e120--e121--e122--e123--e124--e125--e126--e127--e128--e129--e130--e131--e132--e133--e134--e135--e136--e137--e138--e139--e140--e141--e142--e143--e144--e145--e146--e147--e148--e149--e150--e151--e152--e153--e154--e155--e156--e157--e158--e159--e160--e161--e162--e163--e164--e165--e166--e167--e168--e169--e170--e171--e172--e173--f1--f2--f3--f4--f5--f6--f7--f8--f9--f10--f11--f12--f13--f14--f15--f16--f17--f18--f19--f20--f21--f22--f23--f24--f25--g1--g2--g3--g4--g5--g6--g7--g8--g9--h1--h2--h3--h4--h5--h6--h7--h8--h9--h10--h11--h12--h13--h14--h15--h16--h17--h18--h19--h20--h21--h22--h23--h24--h25--h26--h27--h28--h29--h30--h31--h32--h33--h34--h35--h36--h37--h38--h39--h40--h41--h42--h43--h44--h45--h46--h47--h48--h49--h50--h51--h52--h53--h54--h55--h56--h57--h58--h59--h60--i1--i2--i3--i4--i5--i6--i7--i8--i9--i10--i11--i12--i13--i14--i15--i16--i17--i18--i19--i20--i21--i22--i23--i24--i25--i26--i27--i28--i29--i30--i31--i32--i33--i34--i35--i36--i37--i38--i39--i40--i41--i42--i43--i44--i45--i46--i47--i48--i49--i50--i51--i52--i53--i54--i55--i56--i57--i58--i59--i60--i61--i62--i63--k1--k2--k3--k4--k5--l1--l2--l3--l4--l5--l6--l7--l8--l9--l10--l11--l12--l13--l14--l15--l16--l17--l18--l19--l20--l21--l22--l23--l24--l25--l26--l27--l28--l29--l30--l31--l32--l33--l34--l35--l36--m1--m2--m3--m4--m5--m6--m7--m8--m9--m10--m11--m12--m13--m14--m15--m16--m17--m18--m19--m20--m21--m22--m23--m24--m25--m26--m27--m28--m29--m30--m31--m32--m33--n1--n2--n3--n4--n5--n6--n7--n8--n9--n10--n11--n12--n13--n14--n15--n16--n17--n18--n19--n20--n21--n22--n23--n24--n25--n26--n27--n28--n29--n30--n31--n32--n33--n34--n35--n36--n37--n38--n39--n40--n41--n42--n43--n44--n45--n46--n47--n48--n49--n50--n51--n52--n53--n54--n55--n56--n57--n58--n59--n60--n61--n62--n63--n64--n65--n66--n67--n68--n69--n70--n71--n72--n73--n74--n75--n76--n77--n78--n79--n80--n81--n82--n83--n84--n85--n86--n87--n88--n89--n90--n91--n92--n93--o1--o2--o3--o4--o5--o6--o7--o8--o9--o10--o11--o12--o13--o14--o15--o16--o17--o18--o19--o20--o21--o22--o23--o24--o25--o26--o27--o28--o29--o30--o31--o32--o33--o34--o35--o36--o37--o38--o39--o40--o41--o42--o43--o44--o45--o46--o47--o48--o49--o50--o51--o52--o53--o54--o55--o56--o57--o58--o59--o60--o61--o62--o63--o64--o65--o66--o67--o68--o69--o70--o71--o72--o73--o74--o75--o76--o77--o78--o79--o80--o81--o82--o83--o84--o85--o86--o87--o88--o89--o90--o91--p1--p2--p3--p4--p5--p6--p7--p8--p9--p10--p11--p12--p13--p14--p15--p16--p17--p18--p19--p20--p21--p22--p23--p24--p25--p26--p27--p28--p29--p30--q1--r1--r2--r3--r4--r5--r6--r7--r8--r9--r10--r11--r12--r13--r14--r15--r16--r17--r18--r19--r20--r21--r22--r23--r24--r25--r26--r27--r28--r29--r30--r31--r32--r33--r34--r35--r36--r37--r38--r39--r40--r41--r42--r43--r44--r45--r46--r47--r48--r49--r50--r51--r52--r53--r54--r55--r56--r57--r58--r59--r60--r61--r62--r63--r64--r65--r66--r67--r68--r69--r70--r71--r72--r73--r74--r75--r76--r77--r78--r79--r80--r81--r82--r83--r84--r85--r86--r87--r88--r89--r90--r91--r92--r93--r94--r95--r96--r97--r98--r99--r100--r101--r102--r103--r104--s1--s2--s3--s4--s5--s6--s7--s8--s9--s10--s11--s12--s13--s14--s15--s16--s17--s18--s19--s20--s21--s22--s23--s24--s25--s26--s27--s28--s29--s30--s31--s32--s33--s34--s35--s36--s37--s38--s39--s40--s41--s42--s43--s44--s45--s46--s47--s48--s49--s50--s51--s52--s53--s54--s55--s56--s57--s58--s59--s60--s61--s62--s63--s64--s65--s66--s67--s68--s69--s70--s71--s72--s73--s74--s75--s76--s77--s78--s79--s80--s81--s82--s83--s84--s85--s86--s87--s88--s89--s90--s91--s92--s93--s94--s95--s96--s97--s98--s99--s100--s101--s102--s103--s104--s105--t1--t2--t3--t4--t5--t6--t7--t8--t9--t10--t11--t12--t13--t14--t15--t16--t17--t18--t19--t20--t21--t22--t23--t24--t25--t26--t27--t28--t29--t30--t31--t32--t33--t34--t35--t36--t37--t38--t39--t40--t41--t42--t43--t44--t45--t46--t47--t48--t49--t50--t51--t52--t53--t54--t55--t56--t57--t58--t59--t60--t61--t62--t63--t64--t65--t66--t67--t68--t69--t70--t71--t72--t73--t74--t75--t76--t77--t78--t79--t80--t81--t82--t83--t84--t85--t86--t87--t88--t89--t90--t91--t92--t93--t94--t95--t96--t97--t98--t99--t100--t101--t102--t103--t104--t105--t106--t107--t108--t109--t110--t111--t112--t113--t114--t115--t116--t117--t118--t119--t120--t121--t122--t123--t124--t125--t126--t127--t128--t129--t130--t131--u1--u2--u3--u4--u5--u6--u7--u8--u9--u10--u11--u12--u13--u14--u15--u16--u17--u18--u19--u20--u21--u22--u23--u24--u25--u26--u27--u28--u29--u30--u31--u32--u33--u34--u35--u36--u37--u38--u39--u40--u41--u42--u43--u44--u45--u46--u47--v1--v2--v3--v4--v5--v6--v7--v8--v9--v10--w1--w2--w3--w4--w5--w6--w7--w8--w9--w10--w11--w12--w13--w14--w15--w16--x1--x2--x3--x4--x5--x6--x7--y1--y2--y3--y4--y5--y6--y7--y8--y9--y10--y11--y12--y13--y14--y15--y16--y17--y18--y19--y20--y21--y22--y23--y24--z1--
////				}
//
//
//
//				}
//			}
//		});
//		buttonset.setBounds(335, 139, 76, 23);
//		contentPane.add(buttonset);
//		buttondic = new Button("生成字典");
//		buttondic.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//String path ="";
//				JFileChooser fc = new JFileChooser();
//				fc.setDialogTitle("请选择要建立生成字典的文件...");
//				fc.setApproveButtonText("确定");
//				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(contentPane)) {
//					path=fc.getSelectedFile().getPath();
//
//					String [] p = path.split("\\\\");
//					String [] name = p[p.length-1].split("\\.");
//
//					try {
//						Create_Dic.Create_Dic(id, name[0], "E:/workspace/code/code/EncFile/"+id+".txt", "E:/workspace/code/code/FLSA/"+id+"/");
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//
//				}
//			}
//		});
//		buttondic.setBounds(335, 169, 76, 23);
//		contentPane.add(buttondic);

		buttonre = new JButton("增强 搜索");
		buttonre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date day=new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


				System.out.println(id+"搜索完毕"+df.format(day));
				rowdata.clear();
				String search = BwtEncode.StringfuzzyFilter(BwtEncode.replaceBlank(textField.getText().toLowerCase()));

				while(search.charAt(search.length()-1)=='?'||search.charAt(search.length()-1)=='*')
				{
					search = search.substring(0, search.length()-1);
				}
				if (search.equals("")) {
					JOptionPane.showMessageDialog(null, "请不要输入空字符", "Sorry", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String [] searchfuzzyset = Fuzzyset.fuzzyset(search);
				if (searchfuzzyset==null) {
					//*容忍丢失2个字符

					String contentf = "";
					String contentl = "";
					for (int i = 0; i < search.length(); i++) {
						contentf = contentf + SHAR_1.bcSHA1(search.charAt(i) + "", 1) + "alice";
					}
					contentl = SHAR_1.bcSHA1(search.charAt(search.length() - 1) + "", 2);
					String[] contentsearch = contentf.split("alice");
					String Fklm = contentl;


					File file = new File("E:/workspace/code/code/LLsetPath/LLsetPath.txt");
					String[] pathcontent;
					try {
						pathcontent = Readtxt.txt2String(file).split("\r\n");
						MyThreadSearchLLsettoFM mtSl = new MyThreadSearchLLsettoFM(pathcontent, contentsearch, Fklm, 0);
						mtSl.run();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//System.out.println(pathcontent[1]);

//				for (int i = 0; i < contentsearch.length; i++) {
//					//System.out.println(contentsearch[i].length);
//				}

				}else{
//
//					String contentf[] = new String[100];
//					Arrays.fill(contentf, "");
//					String contentl[] = new String[100];
//					Arrays.fill(contentl, "");
//					String Fklm[] = new String[100];
//					Arrays.fill(Fklm,"" );
//
//					int j,i;
//					for(i=0;i<searchfuzzyset.length;i++) {
//						for(j=0;j<searchfuzzyset[i].length();j++) {
//							contentf[i]=contentf[i]+searchfuzzyset[i].charAt(j)+"alice";
//							//contentf[i]=contentf[i]+SHAR_1.bcSHA1(search[i].charAt(j)+"",1)+"alice";
//						}
//						contentl[i]=searchfuzzyset[i].charAt(j-1)+"alice";
//						//contentl[i]=SHAR_1.bcSHA1(search[i].charAt(j-1)+"",2);
//					}
//
//					Fklm = contentl;
//
//					//二维数组初始化，化为一维
//					String contentsearch[][] = new String[100][100];
//					for(int v=0;v<100;v++) {
//						Arrays.fill(contentsearch[v],"" );
//					}
//
//
//					for(int k=0;k<contentf.length;k++) {
//						String[] aa=contentf[k].split("alice");
//						for(int x=0;x<aa.length;x++) {
//							contentsearch[k][x] = aa[x];
//						}
//					}
//
//					File file = new File("E:/workspace/code/code/LLsetPath/LLsetPath.txt");
//					String[] pathcontent;
//					try {
//						pathcontent = Readtxt.txt2String(file).split("\r\n");
//						MyThreadSearchLLsettoFM mtSl = new MyThreadSearchLLsettoFM(pathcontent, contentsearch, Fklm, 0);
//						mtSl.run();
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//
				}
			}
		});
		buttonre.setBounds(1150, 139, 100, 23);
		contentPane.add(buttonre);


		JButton button = new JButton("关键词搜索");//搜索关键词
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				buttonfil.setEnabled(true);
				String search = BwtEncode.StringFilter(BwtEncode.replaceBlank(textField.getText().toLowerCase()));
				if(search.equals(""))
				{
					JOptionPane.showMessageDialog(null, "请不要输入空字符", "Sorry", JOptionPane.ERROR_MESSAGE);
					return;
				}
//	            char [] searchfl = search.toCharArray();
//	            String [] searchf =new String[searchfl.length];
//	            String [] searchl =new String[searchfl.length];
//	            for (int i = 0; i < searchfl.length; i++) {
//					searchf[i] = SHAR_1.bcSHA1(String.valueOf(searchfl[i]), 1);
//					searchl[i] = SHAR_1.bcSHA1(String.valueOf(searchfl[i]), 2);
//				}

				rowdata.clear();
				MyThreadSearchDic mts  = new MyThreadSearchDic(search,0);
				mts.run();
			}
		});
		button.setBounds(1150, 25, 100, 23);
		contentPane.add(button);



		buttonup = new JButton("上传文档");
		buttonup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("请选择要上传的文件...");
				fc.setApproveButtonText("确定");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(contentPane)) {
					path=fc.getSelectedFile().getPath();
					//System.out.println(path);
					if (path==""){return;}

//				    System.out.println(path);
//				    System.out.println(fc.getSelectedFile().getParent());
//				    C:\Users\Administrator\Desktop\test.txt
//				    C:\Users\Administrator\Desktop


					else{
						File file = new File(fc.getSelectedFile().getParent());
						File[] tempList = file.listFiles();
						for (int a = 0; a < tempList.length; a++) {
							path = tempList[a].getPath();


				    Date day=new Date();
				    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    System.out.println(df.format(day));
//

							FileInputStream inputStream = null;
							Scanner sc = null;
							try {
								int i=0;
								String id0 = "";
								inputStream = new FileInputStream(path);
								sc = new Scanner(inputStream, "UTF-8");
								lines="";
								while (sc.hasNextLine()) {
									String line="";
									if (i==0){
										id0 = sc.nextLine();
										line = id0;i++;
									}else{

										line = sc.nextLine();
									}
									lines+= line;
								}
								Random random = new Random();
								int zifu = random.nextInt(999);
								id = id0.hashCode()+zifu+"";

               System.out.println(lines.length());
								Padding pad = new Padding(BwtEncode.StringFilter(BwtEncode.enCodeLineF(lines.toLowerCase()+"$")));

								pad.count(BwtEncode.StringFilter(BwtEncode.enCodeLineF(lines.toLowerCase()+"$")));
								pad.gen_pad();
//				        pad.pad_str="";
								String padstr = pad.pad_str;  //  实现的时候我们不pad填充
								//    System.out.println(pad.pad_str);
//				        System.out.println("len is "+lines.length());
//				       System.out.println("paded len is "+(padstr+lines).length());
//					    System.out.println("生成padding的时间"+df.format(day));

								File file1 = new File("E:/workspace/code/code/FLSA/"+id+"/"+id+"F.txt");
								File file2 = new File("E:/workspace/code/code/FLSA/"+id+"/"+id+"L.txt");
								File file3 = new File("E:/workspace/code/code/FLSA/"+id+"/"+id+"SA.txt");
								File file4 = new File("E:/workspace/code/code/FLSA/"+id+"/"+id+"LLset.txt");
								//判断父目录是否存在，如果不存在，则创建
								if (file1.getParentFile() != null && !file1.getParentFile().exists()) {
									file1.getParentFile().mkdirs();
								}
								file1.createNewFile();
								file2.createNewFile();
								file3.createNewFile();
								file4.createNewFile();

								int [] sa = SuffixArray_with_pad.Sa(BwtEncode.StringFilter(BwtEncode.replaceBlank((lines+padstr+"$").toLowerCase())),BwtEncode.StringFilter(BwtEncode.replaceBlank(lines.toLowerCase())).length());
								FileWriter fw3 = new FileWriter("E:/workspace/code/code/FLSA/"+id+"/"+id+"SA.txt",false);
								MyThreadEncSa mts = new MyThreadEncSa(sa,fw3);
								mts.run();

								FileWriter fw1 = new FileWriter("E:/workspace/code/code/FLSA/"+id+"/"+id+"F.txt",false);
								FileWriter fw2 = new FileWriter("E:/workspace/code/code/FLSA/"+id+"/"+id+"L.txt",false);
								MyThreadBwt mtb = new MyThreadBwt((lines+padstr+"$").toLowerCase(),fw1,fw2);
								mtb.run();




								F = BwtEncode.enCodeLineF(BwtEncode.StringFilter(BwtEncode.replaceBlank((lines+padstr+"$").toLowerCase())));
								FileWriter fw4 = new FileWriter("E:/workspace/code/code/FLSA/"+id+"/"+id+"LLset.txt",false);
								MyThreadLLset mtl = new MyThreadLLset(F,id,(lines+padstr+"$").toLowerCase(),fw4);
								mtl.run();


								String [] p = path.split("\\\\");
								String [] name = p[p.length-1].split("\\.");
								MyThreadDic mtc = new MyThreadDic(id, name[0], "E:/workspace/code/code/EncFile/"+id+".txt", "E:/workspace/code/code/FLSA/"+id+"/",path);
								mtc.run();

								int type = 1;//1代表上传
								EchoSenderThread s = new EchoSenderThread();
								s.type = type;
								s.id = id;
								s.run();
								// buttonset.setEnabled(true);
								// buttondic.setEnabled(true);


								if (sc.ioException() != null) {
									try {
										throw sc.ioException();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} finally {
								if (inputStream != null) {
									try {
										inputStream.close();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (sc != null) {
									sc.close();
								}
							}

						}
					}
				}
			}
		});
		buttonup.setBounds(1150, 209, 100, 23);
		contentPane.add(buttonup);



//		table = new JTable();
//		JScrollPane jsp = new JScrollPane(table);
//		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//		tableModel.addColumn("关键词");
//		tableModel.addColumn("文档编号");
//		tableModel.addColumn("文档标题");
//		tableModel.addColumn("下载地址");
//		table.setBounds(30, 70, 299, 170);
//		Vector colnames=new Vector<>();
//		colnames.add("kewords");
//		colnames.add("ID");
//		colnames.add("Etit");
//		colnames.add("EEdad");
//		table=new JTable(data,colnames);

		//	model = new DefaultTableModel(); // 新建一个默认数据模型
		names.add("文档编号");names.add("文档标题");names.add("搜索关键词");names.add("下载地址");names.add("相关度");
		table = new JTable(rowdata,names); // 用数据模型创建JTable，JTable会自动监听到数据模型中的数据改变并显示出来
		//	scrollPane = new JScrollPane(table); // 用列表创建可滚动的Panel，把这个Panel添加到窗口中
//		Vector row = new Vector(); // 数据行向量，使用它的add()添加元素，比如整数、String、Object等，有几行就new几个行向量
//		Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
//		Vector names = new Vector();// 列名向量，使用它的add()方法添加列名
//		names.add("关键词");names.add("文档编号");names.add("文档标题");names.add("下载地址");
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		row.add("a");row.add("b");row.add("c");row.add("d");data.add(row);
//		model.setDataVector(data,names); // 设置模型中的元素，它会自动显示在列表中

		//JTable使用方法


		//table.isCellEditable(2,1);
		scrollPane = new JScrollPane(table);
		//	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(52, 70, 2, 2);
		contentPane.add(scrollPane);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setBounds(30, 70, 1100, 600);
		TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) table.getRowSorter();
		if(sorter == null) {
			sorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(sorter);
		}



		//JScrollPane jscroll = new JScrollPane(table);
		buttonfil = new JButton("Filter 搜索");
		buttonfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(table.getRowCount());

				String search = BwtEncode.StringFilter(BwtEncode.replaceBlank(textField.getText().toLowerCase()));
				if(search.equals(""))
				{
					JOptionPane.showMessageDialog(null, "请不要输入空字符", "Sorry", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Object[] op = {"关键词搜索_Filter","增强搜索_Filter"};
				String strop = (String) JOptionPane.showInputDialog(null,"选择你需要的操作","标题",JOptionPane.QUESTION_MESSAGE,null,op,op[0]);
				str = "";
				str = JOptionPane.showInputDialog(null,"请输入过滤词");



				if(strop.equals("关键词搜索_Filter"))
				{
					String [] id = new String[table.getRowCount()];
					for (int i = 0; i < table.getRowCount(); i++) {
						id[i] = (String) table.getValueAt(i, 0);
					}
					rowdata.clear();
					MyThreadSearchDic mts = new MyThreadSearchDic(str,0);
					mts.id = id;
					mts.run();
				}else
				{
					String [] llset_id = new String[table.getRowCount()];
					for (int i = 0; i < table.getRowCount(); i++) {
						llset_id[i] = (String) table.getValueAt(i, 3);
						llset_id[i] = llset_id[i].split("EncFile")[0] + "FLSA/"+(String) table.getValueAt(i, 0)+"/"+(String) table.getValueAt(i, 0)+"LLset.txt";
					}
					rowdata.clear();



					while(str.charAt(str.length()-1)=='?'||str.charAt(str.length()-1)=='*')
					{
						str = str.substring(0, str.length()-1);
					}
					if(str.equals(""))
					{
						JOptionPane.showMessageDialog(null, "请不要输入空字符", "Sorry", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String contentf = "";
					String contentl = "";
					for (int i = 0; i < str.length(); i++) {
						contentf = contentf + SHAR_1.bcSHA1(str.charAt(i)+"", 1)+ "alice";
					}
					contentl =  SHAR_1.bcSHA1(str.charAt(str.length()-1)+"", 2);
					String []contentsearch=contentf.split("alice");
					String Fklm =contentl;

					MyThreadSearchLLsettoFM mtSl = new MyThreadSearchLLsettoFM(llset_id,contentsearch,Fklm,1);
					mtSl.run();

					//System.out.println(pathcontent[1]);

//					for (int i = 0; i < contentsearch.length; i++) {
//						//System.out.println(contentsearch[i].length);
//					}



				}




			}
		});
		buttonfil.setBounds(1150, 89, 100, 23);
		contentPane.add(buttonfil);
//        buttonfil.setEnabled(false);
//        buttonre.setEnabled(false);



		textField = new JTextField("请输入搜索关键词");
		textField.setToolTipText("");
		textField.setBounds(100, 25, 209, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				textField.setText("");}
		});

	}

}
