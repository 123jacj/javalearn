import java.util.Random;
import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        System.out.println(true);
//        System.out.println(false);
//        System.out.println(10);
//        System.out.println(10.5);
//        System.out.println('a');
//        System.out.println("a");
//        System.out.println("hello\nworld");
//        System.out.println("hello\tworld");
//        System.out.println("hello\bworld");
//        System.out.println("hello\fworld");
//        System.out.println("hello\rworld");
//        System.out.println("hello\"world");
//        System.out.println("hello\u0000World");
//        System.out.println("byte类型："+Byte.MAX_VALUE+" "+Byte.MIN_VALUE);
//        System.out.println("short类型："+Short.MAX_VALUE+" "+Short.MIN_VALUE);
//        System.out.println("int类型："+Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
//        System.out.println("long类型："+Long.MAX_VALUE+" "+Long.MIN_VALUE);
//        System.out.println("float类型："+Float.MAX_VALUE+" "+Float.MIN_VALUE);
//        System.out.println("double类型："+Double.MAX_VALUE+" "+Double.MIN_VALUE);
//        System.out.println("char类型："+Character.MAX_VALUE+" "+Character.MIN_VALUE);
//        System.out.println("boolean类型："+true+" "+false);
//        System.out.println("表达式结果："+expressipn(10,'a',(byte)10));
//        StringTest();
//        ArrayTest();
//        int[] nums = {1,3,5,9,6,4,8,10};
//        arraySort(nums);
//        for (int i = 0;i < nums.length;i++){
//            System.out.print(nums[i]+"\t");
//        }

//        initCards();纸牌游戏入口
//        GuessNumber();
//        VerfictionCode();
        FindPrime();
    }
    public static long expressipn(int a,char b, byte c){
        return a+b+c;
    }
    public static void StringTest(){
        //静态初始化数组
        String[] names = new String[]{"小明","张三","李四"};
        String[] names1 = new String[]{"1","2","3"};
        String[] names2 = {"1","2","3"};
        for (int i = 0;i < names.length;i++){
            System.out.print(names[i]+'\t');
        }
    }
    public static void ArrayTest(){
        int[] scores = new int[10];
        for (int i = 0;i < 10;i++){
            scores[i] = (int)(Math.random()*100);
        }
        for (int i = 0;i < scores.length;i++){
            System.out.println(scores[i]+"\t");
        }
    }
    public static int[] arraySort(int[] n){
        // 冒泡排序
        for (int i = 0;i < n.length;i++){
            for (int j = 0;j < n.length - i -1;j++){
                if (n[j] > n[j + 1]){
                    int temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }

            }
        }
        return n;
    }



    // 纸牌游戏
    public static void initCards(){
        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] cards = new String[54];
        System.out.println("初始化牌完成!");
        cards = createCards(cards,colors,numbers);
        cards = shuffleCards(cards);
        printCards(cards);
    }
    public static String[] createCards(String[] cards,String[] colors,String[] numbers){
        int num = 0;
        for (int i = 0; i < colors.length; i++){
            for (int j = 0; j < numbers.length; j++){
                cards[num++] = colors[i] + numbers[j];
            }
        }
        cards[num] = "joker";
        cards[num+1] = "king";
        return cards;
    }

    public static void printCards(String[] cards){
        for (int i = 0; i < cards.length; i++){
            System.out.print(cards[i] + " ");
        }
    }
    public static String[] shuffleCards(String[] cards){

        Random r = new Random();
        for (int i = cards.length - 1; i > 0; i--){
            int j = r.nextInt(54);
            String temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        return cards;
    }
    //GuessNumber
    public static void GuessNumber(){
        Random r = new Random();
        int number = r.nextInt(100);
        System.out.println("现在有一个数字，请你尝试猜一下！");
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true){

            int inputer = sc.nextInt();
            count += 1;
            if (inputer > number){
                System.out.println("你猜的数字太大了！");
            }else if (inputer < number){
                System.out.println("你猜的数字太小了！");
            }else {
                System.out.println("恭喜你猜对了！你猜了"+count+"次!");
                break;
            }
        }
    }

    //验证码
    public static void VerfictionCode(){
        System.out.println("请输入验证码位数:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String code = "";
        for (int i = 0;i < num;i++){
            int index = (int)(Math.random()*3);
            switch (index){
                case 0:
                    code += (int)(Math.random()*10);
                    break;
                case 1:
                    code += (char)(Math.random()*26+'a');
                    break;
                case 2:
                    code += (char)(Math.random()*26+'A');
                    break;
            }

        }
        System.out.println("验证码是："+code);
    }

    public static void FindPrime(){
        for (int i = 2;i < 100;i++){
            boolean flag = true;
            for (int j = 2;j < i;j++){
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}

