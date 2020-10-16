class q1
{
    public static void main(String[] args)
    {
        int number = -1;
        byte b = (byte)number;
        int n = b;
        char c = (char)b, c1 = (char)n;
        int final_number = c;
        System.out.println("Initial integer: "+ number); // -1
        System.out.println("Byte: "+ b + " " + n + " " + c1); // -1
        System.out.println("Character: "+ c); // a rectangle char
        System.out.println("Final integer: "+ final_number); // 65535
    }
}