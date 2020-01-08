import com.sun.deploy.ref.AppModel;

import javax.naming.PartialResultException;

public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;
    public int getSize() {
        return size;
    }
    public void display(){
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += datas[i];
            if (i < size - 1) {
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }
    //新增一个元素的方法
    //pos 新增的位置 data 新增的数据
    public void add(int pos, int data) {
        //pos 的位置是否合法
        if (pos < 0 || pos > size) {
            return;
        }
        //数组的存储空间是否够用,如果不够则需要考虑扩容
        if(size >= datas.length) {
            int[] newDatas = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }
        //尾部增加
        if (pos == size) {
           datas[pos] = data;
           size++;
           return;
        }
        //正常增加 2 3 4 5
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }
    //判定是否包含某个元素
    public boolean contains(int toFind) {
        //遍历数组查找是否包含
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    //查找某个元素的对应位置
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos) {
        return datas[pos];
    }
    //给pos元素位置设值为value
    public void setPos(int pos, int value) {
        datas[pos] = value;
    }
    //删除第一次出新的关键字key
    public void remove(int toRemove) {
        //如何实现这个方法呢？首先要找到元素的下标对吧
        int pos = search(toRemove);
        //要删的元素不存在
        if (pos == -1) {
           return;
        }
        //考虑尾删
        if(pos == size - 1) {
            size--;
            return;
        }
        //正常删除
        //3 4 5 6
        for(int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }
    //获取顺序表长度
    public int size() {
        return size;
    }
    //清空顺序表
    public void clear() {
        size = 0;
    }
    //顺序表适合查找一个元素 和尾插尾删等这些操作时间复杂度为O(1)其余时间复杂度都为O(n)
    //顺序表比较难写的代码也就事插入和删除 其余的代码都比较简单
}
