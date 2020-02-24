import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        /**
         * An implement for hash table using open addressing
         */

        HashTable h=new HashTable();
        h.add(new Person("a","Darren"));
        h.add(new Person("ct","Tony"));
        h.add(new Person("ct3","Tony"));
        h.add(new Person("ct4","Tony"));
        h.add(new Person("ct5","Tony"));
        h.add(new Person("ct6","Tony"));
        h.add(new Person("ct7","Tony"));
        h.add(new Person("ct8","Tony"));
        h.add(new Person("ct9","Tony9"));
        h.add(new Person("ct10","Tony10"));



        System.out.println(h.find("a").getName());
        System.out.println(h.find("ct9").getName());
        h.delete("ct9");
        h.add(new Person("ct11","Tony"));
        h.printAll();
        System.out.println(h.find("ct9"));
    }
}

class HashTable
{
    private Person[] array;

    public HashTable()
    {
        array=new Person[10];
    }

    public void add(Person p)
    {
        int hashCode=hashCode(p.getKey())%array.length;
        int current=hashCode;
        while(array[current]!=null)
        {
            current++;
            current=current%array.length;
            if(current==hashCode)
            {
                System.out.println("Hash table is full, can't find a place to add item.");
                return;
            }
        }
        array[current]=p;
    }

    public Person find(String key)
    {
        int hashVal=hashCode(key)%array.length;
        if(array[hashVal].getKey().equals(key))
            return array[hashVal];
        else
        {
            int current=hashVal+1;
            while(current!=hashVal)
            {
                if(array[current]!=null)
                {
                    if (array[current].getKey().equals(key))
                        return array[current];
                }
                current++;
                current=current%array.length;
            }
            System.out.println("Can't find the item with this key.");
            return null;
        }
    }

    public Person delete(String key)
    {
        int hashVal=hashCode(key)%array.length;
        if(array[hashVal].getKey().equals(key))
        {
            Person temp=array[hashVal];
            array[hashVal]=null;
            return temp;
        }
        else
        {
            int current=hashVal+1;
            while(current!=hashVal)
            {
                if(array[current].getKey().equals(key))
                {
                    Person temp=array[current];
                    array[current]=null;
                    return temp;
                }
                current++;
                current=current%array.length;
            }
            System.out.println("Can't find the item with this key to delete.");
            return null;
        }
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

    public void printAll()
    {
        for(int i=0;i<array.length;i++)
        {
            if(array[i]!=null)
                System.out.println(array[i]);
            else
                System.out.println("Null at this position.");
        }
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

    @Override
    public String toString() {
        return "Person{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
