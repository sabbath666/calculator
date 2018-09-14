def call(String filepath){
    def f = new File(filepath)
    def src = new File("./script.src")
    src << "---------------------------"
    src << f.text
    println ("script.src: ${src.text}")
    def src2 = new File("./script-2.src")
    src2.write("dfgdfgdfgdfdfgdfngmdfng")
}
