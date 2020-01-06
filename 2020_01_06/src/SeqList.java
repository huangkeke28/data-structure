

public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;
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
    public void add(int pos, int data){
        //pos的位置是否合法
        if (pos < 0 || pos > size){
            return;
        }
        //datas内存是否够用
        if (size >= datas.length) {
           int[] datas2 = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                datas2[i] = datas[i];
            }
            datas = datas2;
        }
        //pos尾部插入
        if(pos == size){
            datas[pos] = data;
            size++;
            return;
        }
        //pos中间插入
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }
    public boolean contains(int toFind) {
        for (int i = 0; i < size; i++) {
            if(datas[i] == toFind){
                return true;
            }
        }
        return false;
    }
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if(datas[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    public int getPose(int pos){
        return datas[pos];
    }

    public void setPos(int pos, int value){
        //给pos位置设值
        //是否考虑pos是否合法
        datas[pos] = value;
    }
    public void remove(int toRemove) {
        //删除第一次出现的关键字
        int pos = search(200);
        if(pos == -1) {
            return;
        }
        if(pos == size - 1){
            size--;
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }
    public int size() {
        return size;
    }
    public void clear(){
        size = 0;
    }

}
