pipeline{
    agent any

    triggers{
        pollSCM('* * * * *')
    }

    stages{
        stage("Compile"){
            steps{
                sh "./gradlew compileJava"
            }
        }

        stage("Unit tests"){
            steps{
                sh "./gradlew test"
            }
        }
    }
}