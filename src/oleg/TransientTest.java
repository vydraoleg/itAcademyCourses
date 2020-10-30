package oleg;

import java.io.*;

public class TransientTest implements Serializable {
    private String a;
    private transient String b;

    public TransientTest(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {  // 1
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {  // 2
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TransientTest sc = new TransientTest("Test1", "Test2");
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        TransientTest sc2 = (TransientTest) in.readObject();
        System.out.println(sc2);
    }
}