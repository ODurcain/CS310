public class WordUsage {
    private final String word;
    private int count;

    public WordUsage(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public WordUsage(String word) {
        this.word = word;
        this.count = 1;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }

    //Again just for me to make sure it works
    public static void main(String[] args) {
        WordUsage wordUsage1 = new WordUsage("hello");
        WordUsage wordUsage2 = new WordUsage("world", 3);
        WordUsage wordUsage3 = new WordUsage("Godbye", 364287);

        System.out.println("Word: " + wordUsage1.getWord());
        System.out.println("Count: " + wordUsage1.getCount());

        System.out.println("Word: " + wordUsage2.getWord());
        System.out.println("Count: " + wordUsage2.getCount());

        System.out.println("Word: " + wordUsage3.getWord());
        System.out.println("Count: " + wordUsage3.getCount());
    }
}