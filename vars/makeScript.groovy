def call(){
    def process = """git diff --name-only  $GIT_PREVIOUS_COMMIT $GIT_COMMIT""".execute()
    process.wait(30000)
    def res=process.inputStream.text
    println("DIFF: $res")
    def src = new File("script.src")
    src << res
    println("script.src: ${src.text}")
}
