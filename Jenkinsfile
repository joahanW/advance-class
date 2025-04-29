pipeline{
    agent any
    stages {
        stage('Build'){
            steps{
                echo "Start Build"
                sh "./mvnw clean compile"
                echo "End Build"
            }
        }

        stage('Test'){
            steps{
                echo "Start Testing"
                sh "./mvnw test"
                echo "End Testing"
            }
        }

        stage('Deploy'){
            steps{
                echo "Start Deploy"
                sleep(5)
                echo "End Deploy"
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