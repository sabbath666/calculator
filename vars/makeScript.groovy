def call(def filepath){
    println("current dir ${new File(".").canonicalPath}")
    def f = new File(filepath)
    def src = new File("script.src")
    src << f.text
    println ("script.src: ${src.text}")
}
