package day1;

import java.util.Scanner;

/**
 * 数组实现队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 测试一把
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {

            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {


                case 's':
                    queue.showQueue();
                    break;

                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;

                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("程序退出~~");
        }

    }
}


class ArrayQueue {
    private int maxSize;
    private int front;// 数组头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据，模拟队列

    // 创建队列
    ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向头部，指向队列头的 前一个位置
        rear = -1;  // 指向队列尾
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断是否为null
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列中
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了 不能添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 获取队列的数据
    public int getQueue() {
        // 判断队列是否为null
        if (isEmpty()) {
            throw new RuntimeException("队列null 不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的全部数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据 ，注意不是取数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~");
        }
        return arr[++front];
    }
}
