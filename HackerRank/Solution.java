package hackerrank.weekofcode21;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.Writer;
import java.io.OutputStreamWriter;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Egor Kulikov (egor@egork.net)
 */
public class Solution {
    public static void main(String[] args) {
       
    	InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        DemandingMoney solver = new DemandingMoney();
        solver.solve(1, in, out);
        out.close();
    }

    static class DemandingMoney {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            
        	int n = in.readInt();
            int m = in.readInt();
            int[] c = IOUtils.readIntArray(in, n);
            long[] matrix = new long[n];
            
            for (int i = 0; i < m; i++) {
                int a = in.readInt() - 1;
                int b = in.readInt() - 1;
                matrix[a] |= 1L << b;
                matrix[b] |= 1L << a;
            }
            
            int half = n / 2;
            int[] first = new int[half];
            int mask = (1 << half) - 1;
            
            for (int i = 0; i < half; i++) {
                first[i] = (int) (matrix[i] & mask);
            }
            int[] second = new int[(n + 1) / 2];
            for (int i = half; i < n; i++) {
                second[i - half] = (int) (matrix[i] >> half);
            }
            int[] fRes = exact(first, Arrays.copyOf(c, half));
            Pair<int[], long[]> se = solve(second, Arrays.copyOfRange(c, half, n));
            int[] sRes = se.first;
            long[] sWays = se.second;
            int answer = -1;
            long ways = 0;
            int all = (1 << ((n + 1) / 2)) - 1;
            for (int i = 0; i < fRes.length; i++) {
                if (fRes[i] == -1) {
                    continue;
                }
                int bad = 0;
                for (int j = 0; j < half; j++) {
                    if ((i >> j & 1) == 1) {
                        bad |= matrix[j] >> half;
                    }
                }
                int good = all - bad;
                int current = fRes[i] + sRes[good];
                if (current > answer) {
                    answer = current;
                    ways = sWays[good];
                } else if (current == answer) {
                    ways += sWays[good];
                }
            }
            out.printLine(answer, ways);
        }

        private int[] exact(int[] graph, int[] cost) {
            int n = graph.length;
            int[] res = new int[1 << n];
            for (int i = 0; i < res.length; i++) {
                int mask = -1;
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) == 1) {
                        mask &= ~graph[j];
                        res[i] += cost[j];
                    }
                }
                if ((mask & i) != i) {
                    res[i] = -1;
                }
            }
            return res;
        }

        private Pair<int[], long[]> solve(int[] graph, int[] cost) {
            int n = graph.length;
            int[] res = new int[1 << n];
            long[] ways = new long[1 << n];
            ways[0] = 1;
            for (int i = 1; i < res.length; i++) {
                int id = Integer.lowestOneBit(i);
                res[i] = res[i - id];
                ways[i] = ways[i - id];
                int at = Integer.bitCount(id - 1);
                int candidate = cost[at] + res[(i - id) & (~graph[at])];
                if (candidate > res[i]) {
                    res[i] = candidate;
                    ways[i] = ways[(i - id) & (~graph[at])];
                } else if (candidate == res[i]) {
                    ways[i] += ways[(i - id) & (~graph[at])];
                }
            }
            return Pair.makePair(res, ways);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class IOUtils {
        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class Pair<U, V> implements Comparable<Pair<U, V>> {
        public final U first;
        public final V second;

        public static <U, V> Pair<U, V> makePair(U first, V second) {
            return new Pair<U, V>(first, second);
        }

        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }


        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            return !(first != null ? !first.equals(pair.first) : pair.first != null) &&
                    !(second != null ? !second.equals(pair.second) : pair.second != null);
        }


        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }


        public String toString() {
            return "(" + first + "," + second + ")";
        }

        @SuppressWarnings({"unchecked"})
        public int compareTo(Pair<U, V> o) {
            int value = ((Comparable<U>) first).compareTo(o.first);
            if (value != 0) {
                return value;
            }
            return ((Comparable<V>) second).compareTo(o.second);
        }

    }
}
