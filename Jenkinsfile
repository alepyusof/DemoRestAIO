pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Hi'
            }
        }
        stage('Test') {
            steps {
                input('Do you want to proceed?')
            }
        }
        stage('Publish') {
            when {
                not {
                    branch "main"
                }
            }
            steps {
                echo "Hello"
            }
        }
        stage('Done') {
            parallel {
                stage('Unit Test') {
                    steps {
                        echo "Running the unit test..."
                    }
                }
                stage('Integration Test') {
                    agent {
                        docker {
                            reuseNode false
                        }
                    }
                    steps {
                        echo 'Running the integration test...'
                    }
                }
            }
        }
    }
}
