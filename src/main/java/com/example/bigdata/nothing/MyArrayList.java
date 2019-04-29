package com.example.bigdata.nothing;

public class MyArrayList<E> {

    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
       if(capacity<0){
            throw new RuntimeException("capacity can't be negative:"+capacity);
        }else if(capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
           this.elementData = new Object[capacity];
       }
    }

    public void add(E e) {
        if(size==elementData.length) {
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];  //10-->10+10/2
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        this.elementData[size++] = e;
    }

    public void remove(E element) {
        for(int i = 0; i < size; i++) {
            if(element.equals(get(i))) {
                remove(i);
            }
        }
    }

    public void remove(int index) {
        int numMoved = elementData.length - index - 1;
        if(numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }




    private void checkRange(int index) {
        if(index < 0 ||  index > size - 1) {
            throw new RuntimeException("illegal index:" + index);
        }
    }

    public E get(int index) {
        checkRange(index);
        return (E)elementData[index];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size; i++) {
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) {
        MyArrayList<String> list =new MyArrayList<>();
        System.out.println(list.size());

        for(int i = 0; i < 400; i++) {
            list.add("cloud"+i);
        }
        System.out.println(list);

        System.out.println(list.size());
    }



}
