package com.ah3nan.opensqs.core;


import java.io.*;

public class SQSerializer<T> {

  public static byte[] serialize(Object object) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(object);
    oos.flush();
    return bos.toByteArray();
  }

  public static <T> T deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
    ByteArrayInputStream bos2 = new ByteArrayInputStream(bytes);
    ObjectInputStream ois = new ObjectInputStream(bos2);
    return (T) ois.readObject();

  }

}
