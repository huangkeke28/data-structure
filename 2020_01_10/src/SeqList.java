public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;

    public void display() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += datas[i];
            if (i < size -1) {
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }

    public void add(int pos, int data) {
        //1.判断参数是否合法
        if (pos < 0 || pos > size) {
            return;
        }
        //2. 数组的容量是否够用
        if (size >= datas.length) {
            int[] newDatas = new int[2 * datas.length];
            //将原数组传入新的数组
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            //将原数组的引用赋给新的数组
            datas = newDatas;
        }
        //判断是否是尾插
        if (pos == size) {
            datas[pos] = data;
            size++;
            return;
        }
        //正常插入
        //2 3 4 5
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
        return;
        //这个代码漏洞百出 后面要继续加强 加油
    }
    public boolean contains(int toFind) {
        //循环遍历数组 寻找要查找的值
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos) {
        return datas[pos];
    }

    public void setPos(int pos, int value) {
        datas[pos] = value;
    }

    public void remove(int toRemove) {
        //先获取toRemove的位置
        int pos = search(toRemove);
        //是否是最后一个元素
        if (pos == size - 1) {
            size--;
            return;
        }
        if (pos == -1) {
            return;
        }
        //正常删除 1 2 3 4
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
        return;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

}
