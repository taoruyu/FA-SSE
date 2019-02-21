import java.util.Arrays;
public class SuffixArray_with_pad {

    public static final float SIZE = 99999;

    public static int[] generateSA(String s,int len1) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        float m = SIZE;
        int[] sa = new int[len];
        int[] x = new int[len];
        int[] y = new int[len];
        int[] ysort = new int[len];
        float[] bucket = new float[(int) SIZE];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < len; i++) {
            x[i] = ch[i];
            bucket[ch[i]]++;
        }
        for (int i = 1; i < m; i++)
            bucket[i] += bucket[i-1];
        for (int i = len-1; i >= 0; i--)
            sa[(int) --bucket[ch[i]]] = i;

        for (int step = 1, p = 0; p < len; step *= 2, m = p) {
            p = 0;
            for (int i = len - step; i < len; i++)
                y[p++] = i;
            for (int i = 0; i < len; i++) {
                if (sa[i] >= step)
                    y[p++] = sa[i] - step;
            }

            for (int i = 0; i < len; i++)
                ysort[i] = x[y[i]];

            Arrays.fill(bucket, 0);
            for (int i = 0; i < len; i++)
                bucket[ysort[i]]++;
            for (int i = 1; i < m; i++)
                bucket[i] += bucket[i-1];
            for (int i = len - 1; i >= 0; i--)
                sa[(int) --bucket[ysort[i]]] = y[i];

            Arrays.fill(y, 0);
            System.arraycopy(x, 0, y, 0, len);

            x[sa[0]] = 0;
            p = 1;
            for (int i = 1; i < len; i++)
                x[sa[i]] = compare(y, sa[i], sa[i-1], step) ? p-1 : p++;
        }
        for(int i=0;i<sa.length;i++)
        {
        	if(sa[i]>len1-1)
        	{sa[i] = -((int)((1+Math.random())*10000)+1);}
        }
        
        return sa;
    }

    public static int[] generateRank(int[] sa) {
        int len = sa.length;
        int[] rank = new int[len];
        for (int i = 0; i < len; i++)
            rank[sa[i]] = i;
        return rank;
    }

    public static int[] generateH(String s, int[] sa) {
        char[] ch = s.toCharArray();
        int len = sa.length;
        int[] h = new int[len];
        int[] rank = generateRank(sa);

        Arrays.fill(h, 0);
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (rank[i] == 0)
                continue;
            for (int j = sa[rank[i]-1]; inBounds(i+index, j+index, len) && ch[i+index] == ch[j+index];)
                index++;
            h[rank[i]] = index;
            if (index > 0)
                index--;
        }
        return h;
    }

    private static boolean inBounds(int i, int j, int len) {
        return i < len && j < len;
    }

    private static boolean compare(int[] y, int a, int b, int l) {
        int[] tmp = new int[y.length + 1];
        System.arraycopy(y, 0, tmp, 0, y.length);
        return tmp[a] == tmp[b] && tmp[a+l] == tmp[b+l];
    }
    public static int[] Sa(String s,int len) {
    	//System.out.println("sawithpad s is"+s);
        int[] sa = generateSA(s,len);
        return sa;
    }

}
