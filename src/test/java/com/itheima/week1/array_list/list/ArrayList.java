package com.itheima.week1.array_list.list;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-17 16:52
 **/
public class ArrayList implements List<Integer> {
    int[] elementData;
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    
    public ArrayList() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }
    
    public ArrayList(int initCapacity) {
        if (initCapacity > 0) {
            
            this.elementData = new int[initCapacity];
        } else {
            throw new IllegalArgumentException("initCapacity error" + initCapacity);
        }
        
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public int indexOf(int o) {
        for (int i = 0; i < size; i++) {
            if (o == elementData[i]) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean contains(int e) {
        int index = indexOf(e);
        return index >= 0;
    }
    
    @Override
    public boolean add(int e) {
        //需要扩容
        ensureCapacity(size + 1);
        elementData[size] = e;
        size++;
        
        return true;
    }
    
    private void ensureCapacity(int minCapacity) {
        
        if (elementData.length < minCapacity) {
            // 就要扩容了
            grow(minCapacity);
            // 就要扩容了
        }
    }
    
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        copyOf(newCapacity);
    }
    
    private void copyOf(int newCapacity) {
        int[] newarray = new int[newCapacity];
        System.arraycopy(this.elementData, 0, newarray, 0, size);
        this.elementData = newarray;
    }
    
    @Override
    public void add(int index, int element) {
        //方法中先检查索
        // 引位置是否合理，然后检查是否需要扩容，最后在指定索引位置插入元素
        rangeCheck(index);
        //因为要加一个元素，之前的元素不会被覆盖，只会向后移动，所以可能在元素后移之前要先扩容
        ensureCapacity(size + 1);
        System.arraycopy(this.elementData, index, this.elementData, index + 1, size - index);
        //在index位置存入数据
        this.elementData[index] = element;
        size++;
    }
    
    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index:" + index + ",size=" + this.size);
        }
    }
    
    @Override
    public int set(int index, int element) {
        // 引位置是否合理，然后检查是否需要扩容，最后在指定索引位置插入元素
        rangeCheck(index);
        //因为要加一个元素，之前的元素不会被覆盖，只会向后移动，所以可能在元素后移之前要先扩容
        int oldElement = this.elementData[index];
        this.elementData[index] = element;
        return oldElement;
    }
    
    @Override
    public int get(int index) {
        // 引位置是否合理，然后检查是否需要扩容，最后在指定索引位置插入元素
        rangeCheck(index);
        return this.elementData[index];
    }
    
    @Override
    public int remove(int index) {
        // 引位置是否合理，然后检查是否需要扩容，最后在指定索引位置插入元素
        rangeCheck(index);
        int oldElement = this.elementData[index];
        System.arraycopy(this.elementData, index + 1,
                this.elementData, index, size - index - 1);
        this.elementData[size - 1] = 0;
        size--;
        return oldElement;
    }
    
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elementData[i] = 0;
        }
        size = 0;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (size - 1 != i) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
