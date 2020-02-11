package com.company;
import java.util.*;


public class Test{
    public static void main(String[] args)
    {
        /**
         * Implementing a hash table by chaining
         */

        ChainedHashTable h=new ChainedHashTable();
        h.put(new StoredPerson("Yewei",new Person("Yewei",34)));
        h.put(new StoredPerson("Wenting",new Person("Wenting",33)));
        h.put(new StoredPerson("Darren1",new Person("Darren",34)));
        h.put(new StoredPerson("Darren2",new Person("Darren",34)));
        h.printTable();
    }
}

class ChainedHashTable
{
    private LinkedList<StoredPerson>[] htable;

    ChainedHashTable()
    {
        htable=new LinkedList[10];
        for(int i=0;i<htable.length;i++)
            htable[i]=new LinkedList<StoredPerson>();
    }

    public void put(StoredPerson person)
    {
        int hashcode=getHash(person.getKey());
        htable[hashcode].add(person);
    }

    public void printTable()
    {
        for(int i=0;i<htable.length;i++)
        {
            if(htable[i]!=null)
            {
                System.out.print("Position "+i+" has ->");
                Iterator<StoredPerson> iter=htable[i].listIterator();
                while(iter.hasNext())
                {
                    StoredPerson temp=iter.next();
                    System.out.print(temp.toString()+ " -> ");
                }
                System.out.println();
            }
            else
            {
                System.out.println("Position "+i+" is empty.");
            }
        }
    }

    private int getHash(String key)
    {
        return key.length()%htable.length;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "(Person" +
                "name='" + name + '\'' +
                ", age=" + age +
                ')';
    }
}

class StoredPerson
{
    String key;
    Person p;

    public StoredPerson(String key, Person p) {
        this.key = key;
        this.p = p;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "{"+"Key :"+key+"Person :"+p.toString()+"}";
    }
}
