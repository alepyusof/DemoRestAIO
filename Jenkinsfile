pipeline {
       agent any
       environment {
           AIO_TESTS_API_KEY = credentials('aioTestApiKey')
       }
       stages {
           stage('SCM') {
               steps {
                   git 'https://github.com/org/sample-testng-tests.git'                       
               }
           }
           stage('Build') {
               steps {
                   sh 'mvn test'
               }
           }
       }
       post {
           always {
                   aioImport jiraInstanceType: 'cloud',
                         frameworkType : 'TestNG',
                         addCaseToCycle :true,
                         createCase :true,
                         bddForceUpdateCase: true,
                         entry: [$class: 'NewCycle', cyclePrefix: 'Regression Run V1.0'],
                        //For existing cycles : entry: [$class: 'ExistingCycle', cycleKey: 'SCRUM-CY-191'],
                         apiKey : hudson.util.Secret.fromString(env.AIO_TESTS_API_KEY),
                         resultsFilePath : '/target/surefire-reports/testng-results.xml',
                         projectKey: 'SCRUM',
                         hideDetails: false
           }
       }
   }
