import java.util.Scanner;

interface Stack {
    void create(int[] array, int top, int n);
    void push(int[] array, int top, int num, int n);
    void pop(int[] array, int top);
    void display(int[] array, int top);
}

class InterStack implements Stack {
    int top; // Updated: Removed the redundant 'i' variable

    @Override
    public void create(int[] array, int top, int n) {
        Scanner obj1 = new Scanner(System.in);
        this.top = -1; // Updated: Initialize the top correctly
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter element %d: ", i + 1);
            array[i] = obj1.nextInt();
            this.top++;
        }
    }

    @Override
    public void push(int[] array, int top, int num, int n) {
        if (this.top == n - 1) {
            System.out.println("Stack overflow");
        } else {
            array[++this.top] = num;
        }
    }

    @Override
    public void pop(int[] array, int top) {
        int n;
        if (this.top == -1) {
            System.out.println("Stack Underflow");
        } else {
            n = array[this.top];
            System.out.println("Popped element: " + n);
            this.top--;
        }
    }

    @Override
    public void display(int[] array, int top) {
        System.out.println("Stack elements:");
        for (int i = this.top; i >= 0; i--) { // Updated: Use 'this.top' to iterate through the stack
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}

public class stack1 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int m =10;
        int array[] = new int[m];
        int top = -1, n, num, choice;
        System.out.printf("Enter no of elements: ");
        n = obj.nextInt();
        InterStack s = new InterStack();
        s.create(array, top, n);
      
        System.out.printf("\nEnter 1 for push: ");
        choice = obj.nextInt();
        while(choice ==1){
        if (choice == 1) {
            System.out.printf("\nEnter element to push: ");
            num = obj.nextInt();
            s.push(array, top, num, m);
        }       
        System.out.printf("\nEnter 1 for push: ");
        choice = obj.nextInt();
    } System.out.printf("\nEnter 3 for display: ");
        choice = obj.nextInt();
        if (choice == 3) {
            s.display(array, top);
        }
        System.out.printf("\nEnter 2 for pop: ");
        choice = obj.nextInt();
        while(choice ==2){
        if (choice == 2) {
            s.pop(array, top);
        }System.out.printf("\nEnter 2 for pop: ");
        choice = obj.nextInt();
        }
        System.out.printf("\nEnter 3 for display: ");
        choice = obj.nextInt();
        if (choice == 3) {
            s.display(array, top);
        }
    }
}