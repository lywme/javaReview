import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        /**
         * An implement for hash table using open addressing
         */

        HashTable h=new HashTable();
        h.add(new Person("a0","Darren0"));
        h.add(new Person("a1","Darren1"));
        h.add(new Person("ct2","Tony2"));
        h.add(new Person("ct3","Tony3"));
        h.add(new Person("ct4","Tony4"));
        h.add(new Person("ct5","Tony5"));
        h.add(new Person("ct6","Tony6"));
        h.add(new Person("ct7","Tony7"));
        h.add(new Person("ct8","Tony8"));
        h.add(new Person("ct9","Tony9"));
        h.add(new Person("ct10","Tony10"));
        h.add(new Person("ct100","Tony100"));
        h.add(new Person("ct1000","Tony1000"));



        System.out.println(h.find("a0").getName());
        System.out.println(h.find("ct9").getName());
        h.printAll();
        h.delete("ct9");
        h.printAll();
    }
}

class HashTable
{
    private LinkedList<Person>[] array;

    public HashTable()
    {
        array=new LinkedList[10];
        for(int i=0;i<array.length;i++)
        {
            array[i]=new LinkedList<Person>();
        }
    }

    public void add(Person p)
    {
        int hashCode=hashCode(p.getKey())%array.length;

        if(array[hashCode]!=null)
        {
            array[hashCode].add(p);
        }

    }

    public Person find(String key)
    {
        int hashVal=hashCode(key)%array.length;
        if(array[hashVal]!=null)
        {
            Iterator iter = array[hashVal].iterator();
            while (iter.hasNext()) {
                Person p = (Person) iter.next();
                if (key.equals(p.getKey()))
                    return p;
            }
        }
        return null;
    }

    public Person delete(String key)
    {
        int hashVal=hashCode(key)%array.length;
        Iterator iter=array[hashVal].iterator();
        Person delP=null;
        while(iter.hasNext())
        {
            Person p= (Person) iter.next();
            if(key.equals(p.getKey()))
            {
                //save the p instance
                delP=p;
            }
        }
        if(delP!=null)
            array[hashVal].remove(delP);
        return delP;
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
            {
                Iterator iter=array[i].iterator();

                System.out.print("Hash table["+i+"] :");
                while(iter.hasNext())
                {
                    Person temp=(Person)iter.next();
                    System.out.print(temp.getName()+" -> ");
                }
                System.out.println();
            }
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
