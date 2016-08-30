class label {
    public static void main(String args[]) {
        //使用break的带标签版
        while (true) {
            label1:
            for (int i = 1; i < 5; i++)
            {
                System.out.println(i);
                if (i == 3) break label1;//it will break the loop of label1
            }
            System.out.println("break!!!");
            break;
        }
    }
}
