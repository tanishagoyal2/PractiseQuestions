package heaps;
public class heapQuestions{
    int arr[];
    int maxSize;
    int size;

    //using min heap;
    heapQuestions(int n){
        this.maxSize=n;
        this.arr=new int[maxSize+1];
        this.size=0;
        arr[0]=Integer.MIN_VALUE;
    }

    public static int parent(int pos){
        return pos/2;
    }

    public static int leftChild(int pos){
        return pos*2;
    }

    public static int rightChild(int pos){
        return pos*2+1;
    }

    public void swap(int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public boolean isLeaf(int pos){
        if(leftChild(pos)<=maxSize || rightChild(pos)<=maxSize){
            return false;
        }
        return true;
    }


    public  void insert(int ele){
        if(size>=maxSize){
            	return ;
        }
        else{
            arr[++size]=ele;
            int current=size;
            while(arr[current]<arr[parent(current)]){
                swap(current,parent(current));
                current=parent(current);
            }
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + arr[i]
                             + " LEFT CHILD : " + arr[2 * i]
                             + " RIGHT CHILD :" + arr[2 * i + 1]);
            System.out.println();
        }
    }

    public void median(){
        int mid=size/2+1;
        if(size%2==0){
            System.out.println(arr[mid]+" "+arr[mid+1]);
        }
        else{
            System.out.println(arr[mid]);
        }

    }
    public static void main(String args[]){
        heapQuestions hq=new heapQuestions(9);
        hq.insert(5);
        hq.insert(3);
        hq.insert(17);
        hq.insert(10);
        hq.insert(84);
        hq.insert(19);
        hq.insert(6);
        hq.insert(22);
        hq.insert(9);
        hq.print();
        hq.median();
    }
}