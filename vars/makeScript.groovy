def call(){
    def f = new File("test.txt")
    def src = new File("script.src")
    src << f.text
}
