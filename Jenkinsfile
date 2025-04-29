pipeline{

    agent any
    stages{
        stage('prepare'){
            environment{
                APP = credentials('johan_secret')
            }
            steps{
                echo ('App User: ${APP_USR}')
                echo ('App User: ${APP_PSW}')
            }
        }
        stage('Hello'){
            steps{
                echo 'Hello'
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