import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class DivFree {
    static final long MODULO = (long) (1e9 + 7);
 
    public  int dfcount(int n, int k) {
        
    	Map<Integer, Integer> buckets = new HashMap<>();
        int[] pows = new int[100];
        
        for (int a = 1; a <= k; ++a) {
            int np = 0;
            int tmp = a;
            
            for (int i = 2; i * i <= tmp; ++i) {
                if (tmp % i == 0) {
                    pows[np] = 0;
                    while (tmp % i == 0) {
                        tmp /= i;
                        ++pows[np];
                    }
                    ++np;
                }
            }
            if (tmp > 1) {
                pows[np++] = 1;
            }
           
            Arrays.sort(pows, 0, np);
            for (int x : pows) {
                if (x >= 16) throw new RuntimeException();
            }
            
            if (np > 6) throw new RuntimeException();
            int key = 0;
            for (int i = 0; i < np; ++i) {
                key |= pows[i] << (4 * i);
            }
            Integer old = buckets.get(key);
            if (old == null) old = 0;
            buckets.put(key, old + 1);
        }
        
        Map<Integer, Integer> bucketId = new HashMap<>();
        int size = 0;
        for (int x : buckets.keySet()) {
            bucketId.put(x, size++);
        }
        long[][] a = new long[size][size];
        for (int x : buckets.keySet()) {
            Arrays.fill(a[bucketId.get(x)], buckets.get(x));
        }
        int[] npows = new int[100];
        int[] npows2 = new int[100];
        for (int x : buckets.keySet()) {
            int np = 6;
            for (int i = 0; i < 6; ++i) {
                pows[i] = (x >> (4 * i)) & 15;
            }
            while (np > 0 && pows[np - 1] == 0) --np;
            rec(pows, np, 0, 0, 1, npows, npows2, a, bucketId.get(x), bucketId);
        }
        long[] b = new long[size];
        b[bucketId.get(0)] = 1;
        long[] res = mul(pow(a, n), b);
        long ret = 0;
        for (long x : res) {
            ret += x;
        }
        return (int) (ret % MODULO);
    }
 
    private void rec(int[] pows, int np, int at, int nnp, long ways, int[] npows, int[] npows2, long[][] a, int bigId, Map<Integer, Integer> bucketId) {
        if (at == np) {
            System.arraycopy(npows, 0, npows2, 0, nnp);
            Arrays.sort(npows2, 0, nnp);
            int key = 0;
            for (int i = 0; i < nnp; ++i) {
                key |= npows2[i] << (4 * i);
            }
            int smallId = bucketId.get(key);
            if (smallId != bigId)
                a[smallId][bigId] = (a[smallId][bigId] - ways + MODULO) % MODULO;
            return;
        }
        for (int i = 0; i <= pows[at]; ++i) {
            npows[nnp] = i;
            rec(pows, np, at + 1, nnp + (i > 0 ? 1 : 0), ways, npows, npows2, a, bigId, bucketId);
        }
    }
 
    private long[] mul(long[][] a, long[] b) {
        int size = a.length;
        long[] c = new long[size];
        for (int i = 0; i < size; ++i) {
            long s = 0;
            for (int k = 0; k < size; ++k) {
                s = (s + a[i][k] * b[k]) % MODULO;
            }
            c[i] = s;
        }
        return c;
    }
 
    private long[][] mul(long[][] a, long[][] b) {
        int size = a.length;
        long[][] c = new long[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                long s = 0;
                for (int k = 0; k < size; ++k) {
                    s = (s + a[i][k] * b[k][j]) % MODULO;
                }
                c[i][j] = s;
            }
        }
        return c;
    }
 
    private long[][] pow(long[][] a, int n) {
        int size = a.length;
        if (n == 0) {
            long[][] res = new long[size][size];
            for (int i = 0; i < size; ++i) {
                res[i][i] = 1;
            }
            return res;
        }
        if (n % 2 == 0) {
            return pow(mul(a, a), n / 2);
        }
        return mul(a, pow(a, n - 1));
    }
 
public static void main(String args[]){
		
        DivFree div = new DivFree();
		System.out.println(div.dfcount(42, 23));
		//System.out.println(div.dfcount(49987, 49729));
	}
}