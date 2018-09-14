def f = new File("/home/jenkins/workspace/calculator/test.txt")
def src = new File("/home/jenkins/workspace/calculator/script.src")
def src2 = new File("/home/jenkins/workspace/calculator/script-update.src")
src2 << src.text
src2 << f.text
