import java.util.Arrays;

public class DynamicArray  {
    private Object[] array = new Object[2];
    private  int indexArray = 0;
    public void add(Object object){
        if(array.length <= indexArray){
            Object[] newArray = new Object[array.length *2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[indexArray++] = object;

    }
    public Object[] get(){
        return array;
    }
    public int size(){
        return indexArray;
    }
    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                ", indexArray=" + indexArray +
                '}';
    }
}
