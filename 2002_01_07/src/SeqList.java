public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;

    public int getSize() {
        return size;
    }
    public void disPlay() {
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

    public void add(int pos, int data) {
        //判断顺序表是否满了 满了就增大存储量
        if(size >= datas.length) {
            int[] newDatas = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }
        //判断pos是否合法
        if (pos < 0 || pos > size) {
            return;
        }
        //是否尾插
        if (pos == size) {
            datas[pos] = data;
            size++;
            return;
        }
        //3 4 5 6
        for (int i = size; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }

    public boolean contains(int toFind) {
        //循环遍历整个数组
        for (int i = 0; i < size; i++) {
            if(datas[i] == toFind){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind){
        for (int i = 0; i < size; i++) {
            if(datas[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    public int getPose(int pos) {
        return datas[pos];
    }

    public void setPos(int pos, int value) {
        //给pos位置的元素设为value
        datas[pos] = value;
    }
    public void remove(int toRmove) {
        // 2 3  4 5
        int pos = search(toRmove);
        if (pos == -1) {
            return;
        }
        if (pos == size - 1) {
            size--;
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }
    public void clear() {
        size = 0;
    }


}





