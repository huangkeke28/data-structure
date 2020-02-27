public class SeqList {
    private int size = 0;
    private int[] datas = new int[100];

    public int getSize() {
        return size;
    }

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

    public void add(int pos, int data) {
        if (pos < 0 || pos > size) {
            return;
        }
        if (size >= datas.length) {
            int[] newDatas = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }
        if (pos == size) {
            datas[pos] = data;
            size++;
            return;
        }
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
        return;
    }

    public boolean contains(int toFind) {
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

    public int getPos (int pos) {
        return datas[pos];
    }

    public void setPos(int pos, int value) {
        datas[pos] = value;
    }

    public void remove(int toRemove) {
        int index = search(toRemove);
        if (index == -1) {
            return;
        }
        if (index == size - 1) {
            size--;
            return;
        }
        for (int i = index; i < size - 1; i++) {
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
