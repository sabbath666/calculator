pipeline{
    agent any

    triggers{
        pollSCM('* * * * *')
    }

    stages{
        stage("Compile"){
            steps{
                sh "chmod 777 -R *"
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