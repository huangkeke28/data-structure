public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;

    //1.打印顺序表
    public void display() {
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

    //2.往顺序表中index位置增加数据
    public void add(int index,int data) {
        //a. 时刻关注参数的合法性
        if (index < 0 || index > size) {
            return;
        }
        //b. 数组的容量是否够用
        if (size >= datas.length) {
            int[] newDatas = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }
        //c. 考虑尾插
        if (index == size) {
            datas[index] = data;
            size++;
            return;
        }
        //d. 正常插入
        for (int i = size - 1; i >= index; i--) {
            datas[i + 1] = datas[i];
        }
        datas[index] = data;
        size++;
        return;
    }

    //3.删除顺序表index位置处的数据
    public void remove(int index) {
        //a. 检查参数的有效性
        if (index < 0 || index >= size) {
            return;
        }
        //b. 尾删
        if (index == size - 1) {
            size--;
            return;
        }
        //c. 正常删除
        for (int i = index; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
        return;
    }

    //4.判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
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

    //给pos位置的元素设为value;
    public void setPos(int pos, int value) {
        datas[pos] = value;
    }

    //获取顺序表的长度
    public int size() {
        return size;
    }

    //清空顺序表
    public void clear() {
        size = 0;
    }
}


