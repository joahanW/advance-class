pipeline{
    agent any
    stages {
        stage('Hello'){
            steps{
                echo 'Hello World'
                sh "./mvnw clean"
            }
        }
    }

    post{
        always{
            echo 'This will always run'
        }
        success{
            echo 'This will run only if successful'
        }
        failure{
            echo 'This will run only if failed'
        }
    }
}