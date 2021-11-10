package Dev_TP2;

import java.io.Serializable;

public class Class1 implements Serializable
{
 public String name;
 public String address;
 public transient int SSN;
 public int number;

 public void mailCheck()
 {
 System.out.println("Mail de verification de " + name + " " + address);
 }
}
