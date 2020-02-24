import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        /**
         * An implement for hash table
         */

        HashTable h=new HashTable();
        h.add(new Person("abc","Darren"));
        h.add(new Person("aaa","Tony"));

        System.out.println(h.find("abc").getName());
        System.out.println(h.find("aaa").getName());
    }
}

class HashTable
{
    private Person[] array;

    public HashTable()
    {
        array=new Person[100];
    }

    public void add(Person p)
    {
        int hashCode=hashCode(p.getKey())%array.length;
        array[hashCode]=p;
    }

    public Person find(String key)
    {
        int hashVal=hashCode(key)%array.length;
        return array[hashVal];
    }

    public int hashCode(String key)
    {
        int hashVal=0;
        int root27=1;
        for(int i=key.length()-1;i>=0;i--)
        {
            int letter=key.charAt(i)-96;
            hashVal+=letter*root27;
            root27*=27;
        }
        return Math.abs(hashVal);
    }
}

class Person
{
    private String key;
    private String name;

    public Person(String key,String name)
    {
        this.key=key;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
