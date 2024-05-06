package wordladder;

class Node {
    private String word;
    private int f;

    public Node(String word, int f) {
        this.word = word;
        this.f = f;
    }

    public String getWord() {
        return word;
    }

    public int getF() {
        return f;
    }
}