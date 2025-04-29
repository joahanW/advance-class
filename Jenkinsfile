pipeline{

    agent any
    stages{
        stage('Hello'){
            steps{
                echo 'Hello World'
            }
        }
    }

    post{
        always{
            echo 'I am always here'
        }
        success{
            echo 'I am success'
        }
        failure{
            echo 'I am failure'
        }
        cleanup{
            echo 'I am cleanup'
        }
    }
}